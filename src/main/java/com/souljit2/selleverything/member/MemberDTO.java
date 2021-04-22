package com.souljit2.selleverything.member;

import lombok.*;

import java.sql.Timestamp;

@Getter
@ToString
@EqualsAndHashCode
public class MemberDTO {
    private int memberNo;                       /* 사용자 pk */
    private String memberId;
    private String memberPassword;
    private String memberName;
    private String memberNickname;
    private String memberPhone;
    private Boolean membershipAgreementYn;      /* 개인정보 활용 약관 동의*/
    private Boolean optionalInfoAgreementYn;    /* 선택정보 활용 약관 동의 */
    private Timestamp createdAt;
    private Timestamp updatedAt;                /* 사용자 정보 수정 일시 */
}
