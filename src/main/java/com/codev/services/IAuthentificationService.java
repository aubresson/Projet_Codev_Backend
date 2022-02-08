package com.codev.services;

import com.codev.domain.LogiParam;
import com.codev.domain.UserCodeId;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAuthentificationService {

    UserCodeId authentification(@RequestBody LogiParam unUti)
            throws Exception;

}
