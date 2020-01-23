package com.caseStudy.Ecommerce.service;

import com.caseStudy.Ecommerce.modal.blogs;
import com.caseStudy.Ecommerce.modal.login;
import com.caseStudy.Ecommerce.repository.blogrepository;
import com.caseStudy.Ecommerce.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Service
public class subservice {
    @Autowired
    blogrepository br;
    @Autowired
    userrepository ur;
    public Long gettingid(Principal principal)
    {
        String email=principal.getName();
        login login=ur.findByEmail(email).get();
        return login.getId();

    }



}
