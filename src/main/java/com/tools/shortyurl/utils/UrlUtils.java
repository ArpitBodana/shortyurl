package com.tools.shortyurl.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class UrlUtils {
    public static HttpServletRequest getCurrentHttpRequest() {
        ServletRequestAttributes attrs = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        return attrs != null ? attrs.getRequest() : null;
    }

    public static String getBaseUrl() {
        HttpServletRequest request = getCurrentHttpRequest();
        if (request == null) return "";

        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String contextPath = "/";

        return scheme + "://" + serverName
                + ((serverPort == 80 || serverPort == 443) ? "" : ":" + serverPort)
                + contextPath;
    }

    public String getUpdatedUrl(String url) {
        return getBaseUrl() + url;
    }
}
