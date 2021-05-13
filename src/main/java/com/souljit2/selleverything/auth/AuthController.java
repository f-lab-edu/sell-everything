package com.souljit2.selleverything.member;

import com.souljit2.selleverything.service.AuthService;
import com.souljit2.selleverything.service.SessionService;
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

    private AuthService authService;
    private SessionService sessionService;

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody @Valid MemberDTO memberDTO) throws Exception {
        authService.signUp(memberDTO);
        return Responses.CREATED;
    }

    @PostMapping("/signIn")
    public ResponseEntity<MemberDTO> signIn(
            @RequestBody @Valid SignInRequestDTO signInRequestDTO,
            HttpSession session) throws Exception  {
        MemberDTO memberInfoDTO = authService.signIn(signInRequestDTO, session);
        sessionService.setMemberSession(memberInfoDTO, session);
        return Responses.OK;
    }
}
