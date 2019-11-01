package com.springtools.servicecompany.dao;

import com.springtools.servicecompany.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author ALLOUM on 28/10/2019
 */

@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
