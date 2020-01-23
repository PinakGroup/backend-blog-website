package com.caseStudy.Ecommerce.modal;

import javax.persistence.*;

@Entity
public class subscribe1 {
    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }



    public com.caseStudy.Ecommerce.modal.login getLogin() {
        return login;
    }

    public void setLogin(com.caseStudy.Ecommerce.modal.login login) {
        this.login = login;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_id;

    public com.caseStudy.Ecommerce.modal.login getLogin1() {
        return login1;
    }

    public void setLogin1(com.caseStudy.Ecommerce.modal.login login1) {
        this.login1 = login1;
    }

    @ManyToOne
    login login1;
    @ManyToOne
    login login;

   public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    private int times;
}
