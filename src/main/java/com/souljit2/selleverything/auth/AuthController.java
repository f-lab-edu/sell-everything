package com.souljit2.selleverything.auth;

import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.model.SignInRequestDTO;
import com.souljit2.selleverything.service.SessionAuthService;
import com.souljit2.selleverything.utils.Responses;
import javax.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping("/apis/auth")
public class AuthController {

    private final SessionAuthService sessionAuthService;

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody @Valid MemberDTO newMemberInfo) throws Exception {
        sessionAuthService.signUp(newMemberInfo);
        return Responses.CREATED;
    }

    @PostMapping("/signIn")
    public ResponseEntity<MemberDTO> signIn(@RequestBody @Valid SignInRequestDTO signInInfo,
        HttpSession session) throws Exception {
        sessionAuthService.signIn(signInInfo, session);
        return Responses.OK;
    }
}
