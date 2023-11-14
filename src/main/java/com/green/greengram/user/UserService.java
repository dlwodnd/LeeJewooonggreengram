package com.green.greengram.user;

import com.green.greengram.ResVo;
import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserSigninDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public ResVo insUser(UserInsDto dto){
        int result = mapper.insUser(dto);
        return new ResVo(result);
    }
    //1: 아이디/비번 맞췄음, 2: 아이디 없음, 3: 비밀번호 다름
    public ResVo signin(UserSigninDto dto){
        int result = 3;
        String savedUpw = mapper.selUserByUid(dto.getUid());
        if(savedUpw == null){
            result = 2;
        }else if (savedUpw.equals(dto.getUpw())){
            result = 1;
        }
        return new ResVo(result);
    }
}
