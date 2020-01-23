package com.caseStudy.Ecommerce.repository;

import com.caseStudy.Ecommerce.controller.loginsignup;
import com.caseStudy.Ecommerce.modal.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface userrepository  extends JpaRepository<login,Long> {
    Optional<login> findByEmail(String Email);


}
