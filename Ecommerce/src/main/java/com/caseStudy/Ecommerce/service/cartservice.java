package com.caseStudy.Ecommerce.service;

import com.caseStudy.Ecommerce.modal.*;
import com.caseStudy.Ecommerce.repository.cartrepository;
import com.caseStudy.Ecommerce.repository.itemrepository;
import com.caseStudy.Ecommerce.repository.orderhistoryrepository;
import com.caseStudy.Ecommerce.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class cartservice {
    @Autowired
    private itemrepository it;
    @Autowired
    private cartrepository cr;
    //    @Autowired
    //  private fixedcartrepository fc;
    @Autowired
    private userrepository ur;
    @Autowired
    private orderhistoryrepository oh;

    public String addtocart(Long id, Long product_id) {
        items items = it.findById(product_id).get();
        login login = ur.findById(id).get();
        if (cr.findByLoginAndItems(login, items).isPresent()) {
          /*  cart cart=cr.findByUser(user).get();
           // fixedcart fixedcart=fc.findByRefid(cart.getId().intValue());
            cart.setQuantity(cart.getQuantity()+1);
           // fc.setQuantity(fixedcart.getQuantity()+1);
            cr.save(cart);
           // fc.save(fixedcart);*/
            cart cart = cr.findByLoginAndItems(login, items).get();
            cart.setQuantity(cart.getQuantity() + 1);
            cr.saveAndFlush(cart);
            return "this item is already present";
        } else {
            cart c = new cart();
            c.setItems(items);
            c.setLogin(login);
            c.setQuantity(1);
            cr.save(c);
            return "successfully adde";

        }
        //   return (cart) cr.findByUser(user).get();

    }

    public cart increment(Long id, Long product_id) {
        items items = it.findById(product_id).get();
        login login = ur.findById(id).get();
        cart cart = cr.findByLoginAndItems(login, items).get();
        cart.setQuantity(cart.getQuantity() + 1);
        return (cr.saveAndFlush(cart));
        //return "this item is incremented";

    }

    public cart decrement(Long id, Long product_id) {
        items items = it.findById(product_id).get();
        login login = ur.findById(id).get();
        cart cart = cr.findByLoginAndItems(login, items).get();
        if(cart.getQuantity()>0) {
            cart.setQuantity(cart.getQuantity() - 1);
        }
        return (cr.saveAndFlush(cart));
        //return "this item is deccremented";

    }

    @Transactional
    public String removeproduct(Long userid, Long product_id) {
        Optional<items> item1 = it.findById(product_id);
        Optional<login> user1 = ur.findById(userid);
      /*  if(cr.findByLoginAndItems(user1,item1).get().getQuantity()==1){
            cart car1=cr.findByLoginAndItems(user1,item1).get();
            car1.setQuantity(0);
            cr.save(car1);}
        else if(cr.findByLoginAndItems(user1,item1).get().getQuantity()>1) {
            cart cart1 = cr.findByLoginAndItems(user1, item1).get();
            cart1.setQuantity(cart1.getQuantity()-1);
            cr.save(cart1);
        }*/
        //cart cart=cr.findByLoginAndItems(user1,item1).get();
        cr.deleteByLoginAndItems(user1, item1);
        return "deletion ";

    }

    public cart addproduct(Long userid, long productid) {
        items i = it.findById(productid).get();
        login login = ur.findById(userid).get();
        if (cr.findByLoginAndItems(login, i).isPresent()) {
            cart cart = (cart) cr.findByLoginAndItems(login, i).get();
            cart.setQuantity(cart.getQuantity() + 1);
            cr.save(cart);
        } else {
            cart c = new cart(i, login, 1);
            cr.save(c);

        }
        return (cart) cr.findByLoginAndItems(login, i).get();
    }

    public List<cart> showcart(Long userid) {
        login user = ur.findById((userid)).get();
        return cr.findAllByLogin(user);
    }

    public List<orderhistory> checkout(Long userid) {
        Optional<login> login = ur.findById(userid);
        List<cart> cartlist = cr.findAllByLogin(login.get());
        for (cart car : cartlist) {
            orderhistory order = new orderhistory();
            order.setItemname(car.getItems().getName());
            order.setUserid(car.getLogin().getId());
            double p = car.getItems().getPrice();
            order.setQuantity(car.getQuantity());
            order.setPrice((int) (car.getQuantity() * p));
            order.setDate(new Date());
            cr.delete(car);
            oh.saveAndFlush(order);

        }
        return oh.findAllByUserid(login.get().getId());
    }
public login showprofile(Long userid)
{ return ur.findById(userid).get();

}
@Transactional
public  String clearcart(Long userid)
{
    login login=ur.findById(userid).get();
    cr.deleteByLogin(login);
    return "cart is cleared";
}

}
   /* public String clearcart(Long userid) {
        login user=ur.findById((userid)).get();
        List<cart> cartitems=cr.findByUser(user);
        for(cart cart:cartitems)
        {
            cr.deleteById(cart.getId());
        }
        return "cart cleared";
    }*/
   /*public List<orderhistory> checkOut(Principal principal) {
       Optional<login> users = ur.getByEmail(principal.getName());
       ArrayList<cart> cartList = cr.findAllByLogin(users);

       for (int i=0;i<cartList.size();i++) {
           cart cartObject = cartList.get(i);
           orderhistory orders = new orderhistory();

           orders.setUserid(cartObject.getLogin().getId());
           orders.setQuantity(cartObject.getQuantity());
           orders.setPrice(cartObject.getItems().getPrice());
           orders.setItemname(cartObject.getItems().getName());
           orders.setDate(new Date());
           cr.delete(cartObject);
           oh.saveAndFlush(orders);
       }
       return oh.findAllByUserId(users.get().getId());
   }*/



