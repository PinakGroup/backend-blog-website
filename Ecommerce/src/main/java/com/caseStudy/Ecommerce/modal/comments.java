package com.caseStudy.Ecommerce.modal;

import javax.persistence.*;

@Entity
public class comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public com.caseStudy.Ecommerce.modal.blogs getBlogs() {
        return blogs;
    }

    public void setBlogs(com.caseStudy.Ecommerce.modal.blogs blogs) {
        this.blogs = blogs;
    }

    public com.caseStudy.Ecommerce.modal.login getLogin() {
        return login;
    }

    public void setLogin(com.caseStudy.Ecommerce.modal.login login) {
        this.login = login;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToOne
    private blogs blogs;
    @ManyToOne
    private login login;
    private String comment;
}
