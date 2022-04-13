/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioSQLimplSpring.portfolioSQLimplSpring.ControllerAPI;

import com.portfolioSQLimplSpring.portfolioSQLimplSpring.DTO.UserDTO;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.servicios.IServicios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sosag
 */
@RestController
public class ControllerUser {
 
    @Autowired
    private IServicios servi;
    
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/user/cargar")
    public String cargarvalores(@RequestBody UserDTO dato){
    return servi.guardarUser(dato);
    
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user/traertodo")
    public List<UserDTO> traertodo(){
        System.out.println("entramos al get de user");
    return servi.retornaUser();
    
    }
    
    
    
}
