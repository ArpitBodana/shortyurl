package com.tools.shortyurl.config;

import com.tools.shortyurl.models.UrlMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Component;


@Component
@EnableMongoAuditing
public class MongoIndexConfig {

    @Autowired
    private MongoOperations mongoOperations;

    @EventListener(ContextRefreshedEvent.class)
    public void createTTLIndex() {
        mongoOperations.indexOps(UrlMappings.class)
                .createIndex(new Index()
                        .on("createdAt", Sort.Direction.ASC)
                        .named("createdAt_TTL_1hr") // avoid conflict
                        .expire(3600));
    }

}
