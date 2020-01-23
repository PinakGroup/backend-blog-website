package com.caseStudy.Ecommerce.repository;

import com.caseStudy.Ecommerce.modal.blogs;
import com.caseStudy.Ecommerce.modal.login;
import com.caseStudy.Ecommerce.modal.subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface subscriberepository extends JpaRepository<subscribe,Long> {
    List<subscribe> findByLogin(login login);
    void deleteByLoginAndBlogs(login login, blogs blog);
}
