/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioSQLimplSpring.portfolioSQLimplSpring.repositoryexp;

import com.portfolioSQLimplSpring.portfolioSQLimplSpring.modelexp.ExpeUbi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sosag
 */
@Repository
public interface IRepoExpUbi extends JpaRepository<ExpeUbi,Long> {
    
}
