package com.souljit2.selleverything.member;

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
    public ResponseEntity signUp(@RequestBody @Valid MemberDTO memberDTO) throws Exception {
        try {
            memberService.signUp(memberDTO);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (DuplicateKeyException e){
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }
}
