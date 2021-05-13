package com.souljit2.selleverything.service;

import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.model.SignInRequestDTO;

import javax.servlet.http.HttpSession;

public interface AuthService {
    public void signUp(MemberDTO memberDTO);
    public MemberDTO signIn(SignInRequestDTO signInRequestDTO, HttpSession session);
}
