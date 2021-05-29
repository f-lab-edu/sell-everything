package com.souljit2.selleverything.service;

import javax.servlet.http.HttpSession;

public interface SessionStorageService {

    public void setMemberSession(int id, HttpSession session);

    public int getMemberSession(HttpSession session);

}
