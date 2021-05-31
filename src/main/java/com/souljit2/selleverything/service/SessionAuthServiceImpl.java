package com.souljit2.selleverything.service;

import com.souljit2.selleverything.exception.AuthenticationFailedException;
import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.model.SignInRequestDTO;
import javax.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SessionAuthServiceImpl implements SessionAuthService {

    private MemberService memberService;

    private SessionStorageService sessionStorageService;

    @Override
    public void signUp(MemberDTO newMemberInfo) {
        String encryptedPassword = BCrypt
            .hashpw(newMemberInfo.getMemberPassword(), BCrypt.gensalt());
        newMemberInfo.setMemberPassword(encryptedPassword);
        memberService.insertMember(newMemberInfo);
    }

    @Override
    public void signIn(SignInRequestDTO signInInfo, HttpSession session) {
        MemberDTO memberInfoDTO = memberService.getMemberInfo(signInInfo);
        if (memberInfoDTO == null) {
            throw new AuthenticationFailedException("No member information");
        }
        boolean isPasswordMatches = BCrypt.checkpw(
            signInInfo.getMemberPassword(),
            memberInfoDTO.getMemberPassword()
        );
        if (isPasswordMatches) {
            sessionStorageService.setMemberSession(memberInfoDTO.getId(), session);
        } else {
            throw new AuthenticationFailedException("Password mismatch");
        }
    }
}
