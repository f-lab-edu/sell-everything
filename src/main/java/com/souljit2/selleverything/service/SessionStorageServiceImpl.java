package com.souljit2.selleverything.service;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class SessionStorageServiceImpl implements SessionStorageService {

    private final String member = "mebmer";

    @Override
    public void setMemberSession(int id, HttpSession session) {
        session.setAttribute(member, id);
    }

    @Override
    public int getMemberSession(HttpSession session) {
        return (int) session.getAttribute(member);
    }
}
