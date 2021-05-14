package com.souljit2.selleverything.mapper;

import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.model.SignInRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    public void insertMember(MemberDTO memberInfo);
    public MemberDTO getMemberInfo(SignInRequestDTO signInInfo);

}
