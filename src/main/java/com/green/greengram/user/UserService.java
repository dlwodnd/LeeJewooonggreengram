package com.green.greengram.user;

import com.green.greengram.ResVo;
import com.green.greengram.user.model.UserInsDto;
import com.green.greengram.user.model.UserSigninProcVo;
import com.green.greengram.user.model.UserSigninVo;
import com.green.greengram.user.model.UserSigninDto;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
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
    public UserSigninVo signin(UserSigninDto dto) {
        UserSigninVo vo = UserSigninVo.builder().result(3).build();

        UserSigninProcVo procVo = mapper.selUserByUid(dto.getUid());
        if(procVo == null) {
            vo = UserSigninVo.builder().result(2).build();
        } else if(procVo.getUpw().equals(dto.getUpw())) {
            vo = UserSigninVo.builder()
                        .result(1)
                        .iuser(procVo.getIuser())
                        .nm(procVo.getNm())
                        .pic(procVo.getPic())
                        .build();
        }
        return vo;
    }

}
