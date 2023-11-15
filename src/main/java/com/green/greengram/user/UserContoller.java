package com.green.greengram.user;

import com.green.greengram.ResVo;
import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserSigninVo;
import com.green.greengram.user.model.UserSigninDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserContoller {
    private final UserService service;

    @PostMapping
    public ResVo insUser(@RequestBody UserInsDto dto){
        ResVo rv = service.insUser(dto);
        return rv;
    }
    @PostMapping("/signin")
    public UserSigninVo login(@RequestBody UserSigninDto dto){

        return service.signin(dto);
    }


}
