package com.souljit2.selleverything.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public final class SessionUtils {

    public static void setAttribute(String name, Object object) {
        RequestContextHolder.getRequestAttributes()
            .setAttribute(name, object, RequestAttributes.SCOPE_SESSION);
    }

    public static Object getAttribute(String name) {
        return RequestContextHolder.getRequestAttributes()
            .getAttribute(name, RequestAttributes.SCOPE_SESSION);
    }

}
