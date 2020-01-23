package com.caseStudy.Ecommerce.modal;

import javax.persistence.*;
import java.util.Date;

@Entity
public class blogs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBlogname() {
        return blogname;
    }

    public void setBlogname(String blogname) {
        this.blogname = blogname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

  /*  public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }*/

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String blogname;
    private String content;
   // private String owner;
    private Date date;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String image;

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    @Column(name="paragraph",columnDefinition="LONGTEXT")
    private String paragraph;

    public com.caseStudy.Ecommerce.modal.login getLogin() {
        return login;
    }

    public void setLogin(com.caseStudy.Ecommerce.modal.login login) {
        this.login = login;
    }

    @ManyToOne
    private login login;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String status;

}
