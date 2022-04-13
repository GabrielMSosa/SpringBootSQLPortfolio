/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioSQLimplSpring.portfolioSQLimplSpring.servicios;

import com.portfolioSQLimplSpring.portfolioSQLimplSpring.DTO.UserDTO;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.repository.IRepoCredenciales;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.repository.IRepoDatoUsuario;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.repository.IRepoUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sosag
 */
public interface IServicios {

    public List<UserDTO> retornaUser();
    
    public String guardarUser(UserDTO dato);
    
    public void EliminarUserporId(Long id);
    
    public void EditarUserporId(Long id);
    
}
