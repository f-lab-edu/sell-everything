package com.souljit2.selleverything.auth;

import com.souljit2.selleverything.model.MemberDTO;
import com.souljit2.selleverything.model.SignInRequestDTO;
import com.souljit2.selleverything.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@AllArgsConstructor
@RequestMapping("/apis/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signUp")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void signUp(@RequestBody @Valid MemberDTO newMemberInfo) throws Exception {
        authService.signUp(newMemberInfo);
    }

    @PostMapping("/signIn")
    @ResponseStatus(value = HttpStatus.OK)
    public void signIn(@RequestBody @Valid SignInRequestDTO signInInfo) throws Exception {
        authService.signIn(signInInfo);
    }
}
