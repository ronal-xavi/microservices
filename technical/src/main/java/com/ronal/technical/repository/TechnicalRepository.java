package com.ronal.technical.repository;

import com.ronal.technical.dao.TechnicalDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepository extends JpaRepository<TechnicalDAO,Long> {

    TechnicalDAO findByDniAndActiveTrue(String dni);
}
