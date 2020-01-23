package com.caseStudy.Ecommerce.controller;

import com.caseStudy.Ecommerce.modal.blogs;
import com.caseStudy.Ecommerce.modal.comments;
import com.caseStudy.Ecommerce.modal.subscribe;
import com.caseStudy.Ecommerce.modal.subscribe1;
import com.caseStudy.Ecommerce.repository.blogrepository;
import com.caseStudy.Ecommerce.service.subservice;
import com.caseStudy.Ecommerce.service.subuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/sub")
public class subscribecontroller {
  @Autowired
 private  subuserservice subuserservice;
  @Autowired
 private subservice subservice;
    @Autowired
    private blogrepository br;

 @GetMapping("/subscribe/{id}")
    @ResponseBody
   public String subscribeblog(Principal principal,@PathVariable(value="id")Long id)
 {
     return subuserservice.addtosubscribe(subservice.gettingid(principal),id);
 }
    @GetMapping("/showall")
    @ResponseBody
    public List<blogs> showallsubscribe(Principal principal)
    {
        return subuserservice.showall(subservice.gettingid(principal));
    }
    @GetMapping("/unsubscribe/{id}")
    @ResponseBody
    public String unsub(Principal principal,@PathVariable(value="id") Long id)
    {
        return subuserservice.unsubscribe(subservice.gettingid(principal),id);
    }
    @GetMapping("/unsub1/{id}")
    @ResponseBody
    public String unsub1(@PathVariable(value="id") Long id)
    {
        return subuserservice.unsub1(id);
    }
    @GetMapping("/show1")
    @ResponseBody
    public List<blogs> show1(Principal principal)
    {
        return subuserservice.show1(subservice.gettingid(principal));
    }
    @GetMapping("/del/{id}")
    @ResponseBody
    public String del(Principal principal,@PathVariable(value="id")Long id)
    {
        return subuserservice.del(subservice.gettingid(principal),id);
    }

    @PostMapping ("/addblog")
    @ResponseBody
    public blogs addnew(@Valid @RequestBody blogs bt ,Principal principal)
    {
        return subuserservice.addnew(subservice.gettingid(principal),bt);
    }
    @PutMapping("/up/{id}")
    @ResponseBody
    public blogs updation(@Valid @RequestBody blogs bs, @PathVariable(value="id") Long id)
    {
        return br.save(bs);
    }
    @GetMapping("/getdata/{id}")
    @ResponseBody
    public blogs getdata(Principal principal,@PathVariable(value="id") Long id)
    {
        return subuserservice.getdata(subservice.gettingid(principal),id);
    }
    @GetMapping("/getuser/{email}")
    @ResponseBody
    public List<blogs> getuser(Principal principal,@PathVariable(value="email") String name)
    {
        return subuserservice.getuser(subservice.gettingid(principal),name);
    }
    @GetMapping("/subscribe1/{email}")
    @ResponseBody
    public subscribe1 subscribe1(Principal principal, @PathVariable(value="email") String name)
    {
        return subuserservice.subscribe1(subservice.gettingid(principal),name);
    }
    @GetMapping("/showsubscribe1")
    @ResponseBody
    public List<subscribe1> showsubscribe1(Principal principal)
    {
        return subuserservice.showsubscribe1(subservice.gettingid(principal));
    }

    @GetMapping("/delfollower/{name}")
    @ResponseBody
    public String delfollower(Principal principal,@PathVariable(value="name") String name )
    {
        return subuserservice.delfollower(subservice.gettingid(principal),name);
    }
    @GetMapping("/following/{name}")
    @ResponseBody
    public String following(Principal principal,@PathVariable(value="name") String name )
    {
     if(subuserservice.following(subservice.gettingid(principal),name)==true)
     {
         return "\"true\"";
     }
     else
     {
         return "\"false\"";
     }
    }
    @GetMapping("/comment/{id}")
    @ResponseBody
    public List<comments> showcomment(Principal principal, @PathVariable(value="id") Long id)
    {
     return subuserservice.comment(subservice.gettingid(principal),id);
    }
    @PostMapping("/savecomment/{id}")
    @ResponseBody
    public comments savecomment(Principal principal,@Valid @RequestBody comments bt,@PathVariable(value="id")Long id)
    {
        return subuserservice.savecomment(subservice.gettingid(principal),bt,id);
    }
@GetMapping("/delcomment/{comment}/{id}")
    @ResponseBody
public String delcomment(@PathVariable(value="comment")String comment,@PathVariable(value="id")Long id)
{
    return subuserservice.delcomment(comment,id);
}

}
