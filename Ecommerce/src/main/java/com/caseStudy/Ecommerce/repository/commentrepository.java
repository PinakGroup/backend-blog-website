package com.caseStudy.Ecommerce.repository;

import com.caseStudy.Ecommerce.modal.blogs;
import com.caseStudy.Ecommerce.modal.comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface commentrepository extends JpaRepository<comments,Long> {
     List<comments> findByBlogs(blogs blogs);
     void deleteByBlogsAndComment(blogs blogs,String comment);

}
