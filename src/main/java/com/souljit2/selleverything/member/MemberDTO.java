package com.souljit2.selleverything.member;

import lombok.*;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
public class MemberDTO {

    @NonNull
    private int memberNo;                       /* 사용자 pk */
    @NonNull
    @NotBlank(message = "ID를 입력해주세요.")
    private String memberId;
    @Pattern(regexp="[a-zA-Z1-9]{6,12}", message = "비밀번호는 영어와 숫자가 포함된 6~12자리 문자를 입력해주세요.")
    private String memberPassword;
    @NonNull
    @NotBlank(message = "이름을 입력해주세요.")
    private String memberName;
    @NonNull
    @NotBlank(message = "닉네임을 입력해주세요.")
    private String memberNickname;
    @NonNull
    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    private String memberPhone;
    @AssertTrue /* 기대값 = true */
    private Boolean membershipAgreementYn;      /* 개인정보 활용 약관 동의. 필수*/
    @NonNull
    private Boolean optionalInfoAgreementYn;    /* 선택정보 활용 약관 동의. 선택 */
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }
}
