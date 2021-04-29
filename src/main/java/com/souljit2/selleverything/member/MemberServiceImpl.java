package com.souljit2.selleverything.member;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private MemberMapper memberMapper;
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(MemberDTO memberDTO) {
        String encryptedPassword = passwordEncoder.encode(memberDTO.getMemberPassword());
        memberDTO.setMemberPassword(encryptedPassword);
        memberMapper.signUp(memberDTO);
    }

    @Override
    public MemberDTO signIn(SignInRequestDTO signInRequestDTO) {
        MemberDTO memberInfoDTO = memberMapper.signIn(signInRequestDTO);
        if(memberInfoDTO == null) return null;
        boolean isPasswordMatches = passwordEncoder.matches(signInRequestDTO.getMemberPassword(), memberInfoDTO.getMemberPassword());
        return isPasswordMatches ? memberInfoDTO : null;
    }
}
