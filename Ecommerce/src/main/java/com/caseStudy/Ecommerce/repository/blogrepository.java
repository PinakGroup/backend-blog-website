package com.caseStudy.Ecommerce.repository;

import com.caseStudy.Ecommerce.modal.blogs;
import com.caseStudy.Ecommerce.modal.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface blogrepository extends JpaRepository<blogs,Long> {
   // List<blogs> findByOwner(String owner);
   List<blogs> findByBlogname(String blogname);
blogs findByContent(String content);
List<blogs>findByDate(Date date);
List<blogs>findByLogin(login login);
void deleteByIdAndLogin(Long id,login login);
blogs findByIdAndLogin(Long id,login login);
blogs findAllByLogin(login login);

}
