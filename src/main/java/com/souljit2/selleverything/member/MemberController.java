package com.souljit2.selleverything.member;

import com.souljit2.selleverything.messages.ApiErrorMessage;
import com.souljit2.selleverything.messages.ApiResponseMessage;
import com.souljit2.selleverything.messages.ApiSuccessMessage;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping("/apis/auth")
public class MemberController {

    private MemberServiceImpl memberService; /* @AllArgsConstructor에 의해 주입 */
    @PostMapping("/signUp")
    public ResponseEntity<ApiResponseMessage> signUp(@RequestBody @Valid MemberDTO memberDTO) throws Exception {
        try {
            memberService.signUp(memberDTO);
            ApiResponseMessage message = new ApiSuccessMessage<MemberDTO>("회원가입", "회원가입 성공", null);
            return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.CREATED);
        } catch (DuplicateKeyException e){
            ApiResponseMessage message = new ApiErrorMessage("회원가입", "아이디 중복");
            return new ResponseEntity<ApiResponseMessage>(message, HttpStatus.CONFLICT);
        }
    }
}
