package com.souljit2.selleverything.service;

import com.souljit2.selleverything.constants.DomainNames;
import com.souljit2.selleverything.exception.AuthenticationFailedException;
import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.model.SignInRequestDTO;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class SessionAuthServiceImpl implements AuthService {

    private MemberService memberService;


    private HttpSession session;

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
    public void signIn(SignInRequestDTO signInInfo) {
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
            session.setAttribute(DomainNames.MEMBER, memberInfoDTO.getId());
        } else {
            throw new AuthenticationFailedException(
                "Password mismatch for "
                    + "memberId: " + signInInfo.getMemberId()
                    + "Please check memberPassword."
            );
        }
    }

    @Override
    public int getRequestMemberId() {
        return (int) session.getAttribute(DomainNames.MEMBER);
    }


}
