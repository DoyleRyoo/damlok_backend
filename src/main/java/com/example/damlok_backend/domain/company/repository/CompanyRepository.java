package com.example.damlok_backend.domain.company.repository;

import com.example.damlok_backend.domain.company.entity.Company;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findFirstByOrderByIdAsc();
}