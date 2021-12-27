package com.codev.services;

import com.codev.domain.LogiParam;
import com.codev.domain.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAuthentificationService {

    public User authentification(@RequestBody LogiParam unUti)
            throws Exception;

}
