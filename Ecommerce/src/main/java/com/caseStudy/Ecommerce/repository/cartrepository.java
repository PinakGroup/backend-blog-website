package com.caseStudy.Ecommerce.repository;

import com.caseStudy.Ecommerce.modal.cart;
import com.caseStudy.Ecommerce.modal.items;
import com.caseStudy.Ecommerce.modal.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface cartrepository extends JpaRepository<cart,Long> {

   // Optional<Object> findByUser(Long user);

    Optional<cart> findByLoginAndItems(login login, items items);
    List<cart> findAllByLogin(login login);
    void deleteByLoginAndItems(Optional<login>login,Optional<items>items);

    void deleteByLogin(login login);
//    List<cart> findByLoginAndItems_Active(login user, int i);
}
