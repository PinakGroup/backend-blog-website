package com.caseStudy.Ecommerce.repository;

import com.caseStudy.Ecommerce.modal.items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface itemrepository extends JpaRepository<items,Long> {
    List<items> findByName(String name);
    List<items> findByPriceBetween(double p1,double p2);
    List<items> findByCategory(String category);
    List<items> findByCategoryAndPriceBetween(String Category,double p1,double p2);
//   items findByProduct_id(long id);
}
