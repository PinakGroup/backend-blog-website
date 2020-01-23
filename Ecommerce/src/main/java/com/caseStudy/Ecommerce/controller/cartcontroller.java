package com.caseStudy.Ecommerce.controller;

import com.caseStudy.Ecommerce.modal.cart;
import com.caseStudy.Ecommerce.modal.items;
import com.caseStudy.Ecommerce.modal.orderhistory;
import com.caseStudy.Ecommerce.modal.profile;
import com.caseStudy.Ecommerce.service.cartservice;
import com.caseStudy.Ecommerce.service.currentuserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders = "*")
@RequestMapping("/cart")
public class cartcontroller {

   /* @Autowired
    public cartcontroller(cartservice cartservice,currentuserservice currentuserservice)
    {
        this.cartservice=cartservice;
        this.currentuserservice=currentuserservice;
    }
    @RequestMapping(value="/addproduct/recieve/{id}",method= RequestMethod.GET)
    @ResponseBody
    public cart addproducts (@PathVariable long id, Principal principal )
    {
        return cartservice.addproduct(currentuserservice.getuserid(principal),id);
    }
    @RequestMapping(value="/removeproduct/recieve/{id}",method=RequestMethod.GET)
    @ResponseBody
    public cart removeproduct(@PathVariable long id, Principal principal )
    {
        return cartservice.removeproduct(currentuserservice.getuserid(principal),id);
    }
    @RequestMapping(value="/addtocart/recieve/{id}",method=RequestMethod.GET)
    @ResponseBody
    public String addtocart(@PathVariable long id,Principal principal)
    {
        return cartservice.addtocart(currentuserservice.getuserid(principal),id);
    }
    @RequestMapping(value="/removefromcart/recieve/{id}",method=RequestMethod.GET)
    @ResponseBody
    public String removefromcart(@PathVariable long id,Principal principal)
    {
        return cartservice.removefromcart(currentuserservice.getuserid(principal),id);
    }
    @RequestMapping(value="/showcart/recieve",method=RequestMethod.GET)
    @ResponseBody
    public List<cart> showcart (Principal principal)
    {
        return cartservice.showcart(currentuserservice.getuserid(principal));
    }
    @RequestMapping(value="/checkout/recieve",method=RequestMethod.GET)
    @ResponseBody
    public double checkout(Principal principal)
    {
        return cartservice.checkout(currentuserservice.getuserid(principal));
    }
    @RequestMapping(value="/clearcart/recieve",method=RequestMethod.GET)
    @ResponseBody
    public String clearcart(Principal principal)
    {
        return cartservice.clearcart(currentuserservice.getuserid(principal));
    }*/


    private cartservice cartservice;
    private currentuserservice currentuserservice;
    @Autowired
    public cartcontroller(cartservice cartservice,currentuserservice currentuserservice)
    {
        this.cartservice=cartservice;
        this.currentuserservice=currentuserservice;
    }
    @RequestMapping(value = "/removeproduct/receive/{ProductId}", method = RequestMethod.GET)
    @ResponseBody
    public String removeproduct(@PathVariable Long ProductId, Principal principal){
        return cartservice.removeproduct(currentuserservice.getuserid(principal),ProductId);
    }

    @RequestMapping(value = "/addproduct/receive/{ProductId}", method = RequestMethod.GET)
    @ResponseBody
    public String addtocart(@PathVariable Long ProductId, Principal principal){
        return cartservice.addtocart(currentuserservice.getuserid(principal),ProductId);
    }
    @RequestMapping(value = "/increment/receive/{ProductId}", method = RequestMethod.GET)
    @ResponseBody
    public cart increment(@PathVariable Long ProductId, Principal principal){
        return cartservice.increment(currentuserservice.getuserid(principal),ProductId);
    }
    @RequestMapping(value = "/decrement/receive/{ProductId}", method = RequestMethod.GET)
    @ResponseBody
    public cart decrement(@PathVariable Long ProductId, Principal principal){
        return cartservice.decrement(currentuserservice.getuserid(principal),ProductId);
    }

//    @RequestMapping(value = "/removefromcart/receive/{productid}", method = RequestMethod.GET)
//    @ResponseBody
//    public String removefromcart(@PathVariable Long productid, Principal principal){
//        return cartService.removefromcart(currentUserService.getuserid(principal),productid);
//    }

    @RequestMapping(value = "/showcart/receive", method = RequestMethod.GET)
    @ResponseBody
    public List<cart> showcart(Principal principal){
        return cartservice.showcart((long) currentuserservice.getuserid(principal));

    }
   @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    @ResponseBody
    public List<orderhistory> checkout(Principal principal){
        return cartservice.checkout(currentuserservice.getuserid(principal));

    }
    @RequestMapping(value = "/clear", method = RequestMethod.GET)
    @ResponseBody
    public String clearcart(Principal principal){
        return cartservice.clearcart(currentuserservice.getuserid(principal));

    }


   /* @RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
    @ResponseBody
public cart addproduct(@PathVariable Long productid,Principal principal)
    {
        return cartservice.addproduct(currentuserservice.getuserid(principal),productid);
    }*/





}
