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

    private static final String member = "member";

    @Override
    public void signUp(MemberDTO newMemberInfo) {
        memberService.insertMember(new MemberDTO(
            0,
            newMemberInfo.getMemberId(),
            BCrypt.hashpw(newMemberInfo.getMemberPassword(), BCrypt.gensalt()),
            newMemberInfo.getMemberName(),
            newMemberInfo.getMemberNickname(),
            newMemberInfo.getMemberPhone(),
            newMemberInfo.getMembershipAgreementYn(),
            newMemberInfo.getOptionalInfoAgreementYn(),
            null,
            null
        ));
    }

    @Override
    public void signIn(SignInRequestDTO signInInfo, HttpSession session) {
        MemberDTO memberInfoDTO = memberService.getMemberInfo(signInInfo);
        if (memberInfoDTO == null) {
            throw new AuthenticationFailedException(
                "No member information for "
                    + "memberId: " + signInInfo.getMemberId()
                    + "Please check memberId."
            );
        }
        boolean isPasswordMatches = BCrypt.checkpw(
            signInInfo.getMemberPassword(),
            memberInfoDTO.getMemberPassword()
        );
        if (isPasswordMatches) {
            session.setAttribute(member, memberInfoDTO.getId());
        } else {
            throw new AuthenticationFailedException(
                "Password mismatch for "
                    + "memberId: " + signInInfo.getMemberId()
                    + "Please check memberPassword."
            );
        }
    }

    @Override
    public int getMemberIdBySession(HttpSession httpSession) {
        return (int) httpSession.getAttribute(member);
    }

}
