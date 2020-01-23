package com.caseStudy.Ecommerce.controller;

import com.caseStudy.Ecommerce.modal.login;
import com.caseStudy.Ecommerce.repository.userrepository;
import com.caseStudy.Ecommerce.service.cartservice;
import com.caseStudy.Ecommerce.service.currentuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/apl")
@CrossOrigin(origins="http://localhost:4200")
public class usercontroller {
    @Autowired
    userrepository ul;
    private cartservice cartservice;
    private currentuserservice currentuserservice;
    @Autowired
    public usercontroller(cartservice cartservice,currentuserservice currentuserservice)
    {
        this.cartservice=cartservice;
        this.currentuserservice=currentuserservice;
    }
    @PostMapping("/sign")
    public login createNewuser(@Valid @RequestBody login ifc)
    {
        ifc.setActive(1);
        ifc.setRole("user");
        return ul.save(ifc);
    }
    @GetMapping("/validateuser")
    public String validate()
    {
        return "\"user is valid\"";
    }
@GetMapping("/show")
@ResponseBody
    public login profile(Principal principal)
{
    return cartservice.showprofile(currentuserservice.getuserid(principal));
}
@PutMapping("/update")
    public login update(@Valid @RequestBody login users)
{

   users.setActive(1);
   users.setRole("user");
   return(ul.save(users));
  // return users;
}

}
