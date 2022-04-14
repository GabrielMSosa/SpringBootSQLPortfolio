/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioSQLimplSpring.portfolioSQLimplSpring.ControllerAPI;

import com.portfolioSQLimplSpring.portfolioSQLimplSpring.DTO.IdiomaDTO;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.DTO.SkillDTO;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.servicioSkill.IServiLeng;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sosag
 */
@RestController
public class ControllerLenguaje {
       @Autowired
    private IServiLeng servi;
       
          
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/skill")
    public String CargarValor1 (@RequestBody SkillDTO dato){
    
    return servi.crearItem(dato);
        
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/skill/traertodo")
    public List <SkillDTO>TraerTodo1(){
    
    return servi.traerTodo();
    }
    
  @CrossOrigin(origins = "http://localhost:4200")  
  @DeleteMapping("/skill/borrar/{id}")    
  public void deleteItem(@PathVariable Long id){
    servi.borrarItem(id);
 
 }
@CrossOrigin(origins = "http://localhost:4200")  
@GetMapping("/skill/traer/{id}")    
  public SkillDTO traerItem(@PathVariable Long id){
      System.out.println("entramos  al get por  id de edu");
      return servi.traerPorId(id);
  
  }
  
  
 @CrossOrigin(origins = "http://localhost:4200")
  @PutMapping("/skill/editar/{id}")
 public String editarItem(@PathVariable Long id,
                        @RequestBody SkillDTO dato
            ){
 
      System.out.println("entramos al put");
 return servi.editarPorid(id, dato);
 
 }

       
       
    
    
}
