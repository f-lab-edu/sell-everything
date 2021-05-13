package com.souljit2.selleverything.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@ToString
@EqualsAndHashCode
public class SignInRequestDTO {

    @NonNull
    @NotBlank(message = "ID를 입력해주세요.")
    private String memberId;
    @NonNull
    @Pattern(regexp="[a-zA-Z1-9]{6,12}", message = "비밀번호는 영어와 숫자가 포함된 6~12자리 문자를 입력해주세요.")
    private String memberPassword;

}
