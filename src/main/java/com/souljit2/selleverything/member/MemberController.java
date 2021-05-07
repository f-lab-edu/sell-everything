package com.souljit2.selleverything.member;

import com.souljit2.selleverything.utils.Responses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping("/apis/auth")
public class MemberController {

    private MemberServiceImpl memberService;

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody @Valid MemberDTO memberDTO) throws Exception {
        memberService.signUp(memberDTO);
        return Responses.CREATED;
    }

    @PostMapping("/signIn")
    public ResponseEntity<MemberDTO> signIn(
            @RequestBody @Valid SignInRequestDTO signInRequestDTO,
            HttpSession session) throws Exception  {
        memberService.signIn(signInRequestDTO, session);
        return Responses.OK;
    }
}
