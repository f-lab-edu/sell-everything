package com.souljit2.selleverything.service;

import com.souljit2.selleverything.exception.AuthenticationFailedException;
import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.model.SignInRequestDTO;
import com.souljit2.selleverything.utils.SessionUtils;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class SessionAuthServiceImpl implements SessionAuthService {

    private MemberService memberService;

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
            throw new AuthenticationFailedException();
        }
        boolean isPasswordMatches = BCrypt.checkpw(
            signInInfo.getMemberPassword(),
            memberInfoDTO.getMemberPassword()
        );
        if (!isPasswordMatches) {
            throw new AuthenticationFailedException();
        }
        SessionUtils.setMemberSession(session, memberInfoDTO.getId());
    }
}
