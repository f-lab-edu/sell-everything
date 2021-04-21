package com.souljit2.selleverything.member;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class MemberDTO {
    private Integer memberNo;                   /* 사용자 no(pk)*/
    private String memberId;                    /* 사용자 id */
    private String memberPassword;              /* 사용자 password */
    private String memberName;                  /* 사용자 이름 */
    private String memberNickname;              /* 사용자 닉네임 */
    private String memberPhone;                 /* 사용자 휴대폰 번호*/
    private Boolean membershipAgreementYn;      /* 개인정보 활용 약관 동의*/
    private Boolean optionalInfoAgreementYn;    /* 선택정보 활용 약관 동의 */
    private Timestamp createdAt;                /* 사용자 정보 생성 일시 */
    private Timestamp updatedAt;                /* 사용자 정보 수정 일시 */
}
