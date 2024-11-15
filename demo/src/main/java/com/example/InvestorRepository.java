package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.CompanyInvestor;
import com.example.Investor;

@Repository
public interface InvestorRepository
    extends JpaRepository<Investor, Long>, JpaSpecificationExecutor<Investor> {

  @Query("SELECT i FROM Investor i WHERE TYPE(i) = CompanyInvestor AND i.name LIKE %:namePart%")
  List<CompanyInvestor> findCompanyInvestorsByNamePart(@Param("namePart") String namePart);

  @Query("SELECT i FROM Investor i WHERE TYPE(i) = CompanyInvestor")
  List<CompanyInvestor> findCompanyInvestors();

  @Query("SELECT i FROM Investor i WHERE TYPE(i) = CompanyInvestor AND i.id = :id")
  Optional<CompanyInvestor> findCompanyInvestorById(@Param("id") Long id);
}

