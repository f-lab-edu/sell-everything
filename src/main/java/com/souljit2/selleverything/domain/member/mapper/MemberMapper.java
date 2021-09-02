package com.souljit2.selleverything.domain.member.mapper;

import com.souljit2.selleverything.domain.member.model.MemberDTO;
import com.souljit2.selleverything.domain.member.model.SignInRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public void insertMember(MemberDTO memberInfo);

    public MemberDTO getMemberInfo(SignInRequestDTO signInInfo);

}
