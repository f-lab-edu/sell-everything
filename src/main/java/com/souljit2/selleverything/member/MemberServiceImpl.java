package com.souljit2.selleverything.member;

import com.souljit2.selleverything.exception.AuthenticationFailedException;
import com.souljit2.selleverything.utils.SessionUtils;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private MemberMapper memberMapper;

    @Override
    public void signUp(MemberDTO memberDTO) {
        String encryptedPassword = BCrypt.hashpw(memberDTO.getMemberPassword(), BCrypt.gensalt());
        memberDTO.setMemberPassword(encryptedPassword);
        memberMapper.signUp(memberDTO);
    }

    @Override
    public void signIn(SignInRequestDTO signInRequestDTO, HttpSession session) {
        MemberDTO memberInfoDTO = memberMapper.signIn(signInRequestDTO);
        if(memberInfoDTO == null) throw new AuthenticationFailedException();
        boolean isPasswordMatches = BCrypt.checkpw(
                signInRequestDTO.getMemberPassword(),
                memberInfoDTO.getMemberPassword()
        );
        if(!isPasswordMatches)
            throw new AuthenticationFailedException();
        SessionUtils.setMemberSession(session, memberInfoDTO.getId());
    }
}
