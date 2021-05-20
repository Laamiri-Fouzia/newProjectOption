package com.example.newprojectoption.dao;

import com.example.newprojectoption.bean.Ponderation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PonderationDao extends JpaRepository<Ponderation,Long> {
    Ponderation findByCode(String code);
    List<Ponderation>  findByCoefContinueAndCoefFinale(BigDecimal coefContinue,BigDecimal coefFinale);
}
