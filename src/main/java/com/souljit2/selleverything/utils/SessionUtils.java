package com.souljit2.selleverything.utils;

import javax.servlet.http.HttpSession;

public final class SessionUtils {

    public static void setMemberSession(HttpSession session, int id) {
        session.setAttribute("member", id);
    }

    public static String getMemberSession(HttpSession session) {
        return session.getAttribute("member").toString();
    }
}
