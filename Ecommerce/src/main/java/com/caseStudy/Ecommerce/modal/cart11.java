package com.caseStudy.Ecommerce.modal;

import javax.persistence.*;

@Entity
public class cart11 {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.caseStudy.Ecommerce.modal.items getItems() {
        return items;
    }

    public void setItems(com.caseStudy.Ecommerce.modal.items items) {
        this.items = items;
    }

    public com.caseStudy.Ecommerce.modal.login getLogin() {
        return login;
    }

    public void setLogin(com.caseStudy.Ecommerce.modal.login login) {
        this.login = login;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private items items;
    @ManyToOne
    private login login;
    @Column(name="quantity")
    private int quantity;
}
