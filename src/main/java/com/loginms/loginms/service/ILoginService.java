package com.loginms.loginms.service;

import com.loginms.loginms.dto.LoginInDTO;

public interface ILoginService {

    Boolean login(LoginInDTO loginInDTO) throws NullPointerException;

}
