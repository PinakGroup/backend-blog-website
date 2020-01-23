package com.caseStudy.Ecommerce.modal;

import javax.persistence.*;

@Entity
public class subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_id;
    @ManyToOne
    login login;

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

    public com.caseStudy.Ecommerce.modal.blogs getBlogs() {
        return blogs;
    }

    public void setBlogs(com.caseStudy.Ecommerce.modal.blogs blogs) {
        this.blogs = blogs;
    }

    @ManyToOne
    blogs blogs;

    public String getPara() {
        return para;
    }

    public void setPara(String para) {
        this.para = para;
    }
//@Column(nullable=false,columnDefinition = "varchar(max)")
    private String para;
}
