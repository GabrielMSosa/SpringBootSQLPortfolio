/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioSQLimplSpring.portfolioSQLimplSpring.ControllerAPI;

import com.portfolioSQLimplSpring.portfolioSQLimplSpring.DTO.ExpeDTO;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.modelexp.Experiencia;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.servicioexp.IServiExp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sosag
 */

@RestController
public class ControllerExp {
    
    @Autowired
    private IServiExp servi;
    
    /*
    Vamos a trabajar todo con DTO para no cambiar el codigo en el front end.
    
    
    
    */
    
    
    
    
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/experiencias")
    public String CargarValor (@RequestBody ExpeDTO dato){
    
    return  servi.crearItem(dato);
        
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/experiencias/traertodo")
    public List<ExpeDTO>TraerTodo(){
    
    return servi.traerTodo();
    }
    
  @CrossOrigin(origins = "http://localhost:4200")  
  @DeleteMapping("/experiencias/borrar/{id}")    
  public void deleteItem(@PathVariable Long id){
    servi.borrarItem(id);
 
 }
@CrossOrigin(origins = "http://localhost:4200")  
@GetMapping("/experiencias/traer/{id}")    
  public ExpeDTO traerItem(@PathVariable Long id){
  return servi.traerPorId(id);
  
  }
  
  
  @CrossOrigin(origins = "http://localhost:4200")
  @PutMapping("/experiencias/editar/{id}")
 public void editarItem(@PathVariable Long id,
                       @RequestParam String ntrabajo,
                       @RequestParam String nempresa,
                       @RequestParam String ndeltaanio,
                        @RequestParam Long nfechaFin,
                        @RequestParam Long nfechaIni,
                        @RequestParam String nprovincias,
                        @RequestParam String nuriImg,
                        @RequestParam String npais,
                        @RequestParam String nlocalidad
            ){
 
      System.out.println("entramos al endpoint put");
 ExpeDTO x= servi.traerPorId(id);
 x.setId(id);
 x.setTrabajo(ntrabajo);
 x.setEmpresa(nempresa);
 x.setDeltaanio(ndeltaanio);
 x.setFechaFin(nfechaFin);
 x.setFechaIni(nfechaIni);
 x.setProvincias(nprovincias);
 x.setUriImg(nuriImg);
 x.setPais(npais);
 x.setLocalidad(nlocalidad);
 
 servi.crearItem(x);
      System.out.println("item editado con exito");
 
 }

  
  
  
  
  

  
}
