package com.caseStudy.Ecommerce.repository;

import com.caseStudy.Ecommerce.modal.orderhistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface orderhistoryrepository extends JpaRepository<orderhistory,Long> {
    List<orderhistory> findAllByUserid(Long userid);
}
