package com.caseStudy.Ecommerce.service;

import com.caseStudy.Ecommerce.modal.cart;
import com.caseStudy.Ecommerce.modal.login;
import com.caseStudy.Ecommerce.repository.cartrepository;
import com.caseStudy.Ecommerce.repository.fixedcartrepository;
import com.caseStudy.Ecommerce.repository.itemrepository;
import com.caseStudy.Ecommerce.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
@Service
public class currentuserservice {
    @Autowired
    private itemrepository it;
    @Autowired
    private cartrepository cr;
   /* @Autowired
    private fixedcartrepository fc;*/
   /* @Autowired
    private userrepository ur;*/


  /*  public Optional<login> CurrentUser(Principal principal){
        String email=principal.getName();
        return ur.findByEmail(email);
    }
    public Long getuserid(Principal principal)
    {
        String email=principal.getName();
        Long id=ur.findByEmail(email).get().getUserid();
        return id;
    }
    public Long getuserrole(Principal principal)
    {
        return ur.findByEmail(principal.getName()).get().getRole().getRoleid();
    }
    public Optional<login> getuserprofile(Principal principal)
    {
        return ur.findByEmail(principal.getName());
    }
    public ResponseEntity<?> checkdetails(login user, Principal principal)
    {
        Optional<login> usercheck=ur.findByEmail(principal.getName());
        Optional<login> usercheckinfo=ur.findByEmail(user.getEmail());
        if(usercheckinfo.isPresent() & usercheckinfo.get().getEmail() != usercheck.get().getEmail()){
            HttpHeaders responseHeaders=new HttpHeaders();
        }
        else{
            cart cart=new cart();
            cart.setItems(product);
            cart.setUser(user);
            cart.setQuantity(1);
            cr.save(cart);
        }
    }*/

    @Autowired
    userrepository ur;

    public Long getuserid(Principal principal) {
        String email = principal.getName();
        /*Long id= userRepository.findByEmail(email).get().getId();
        return id;*/
        login login=ur.findByEmail(email).get();
        return login.getId();
       // return ur.findByEmail(email).get().getId();

    }
public String getuserrole(Principal principal)
{
    return ur.findByEmail(principal.getName()).get().getRole();
}
public Optional<login> getuserprofile(Principal principal)
{
    return ur.findByEmail(principal.getName());
}
public void checkdetails(login users,Principal principal)
{

}

}
