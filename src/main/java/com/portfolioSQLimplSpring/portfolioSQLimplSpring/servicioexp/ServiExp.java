/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioSQLimplSpring.portfolioSQLimplSpring.servicioexp;


import com.portfolioSQLimplSpring.portfolioSQLimplSpring.DTO.ExpeDTO;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.model.Usuario;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.modelexp.ExpeTiempo;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.modelexp.ExpeUbi;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.modelexp.Experiencia;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.repository.IRepoUsuario;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.repositoryexp.IRepoExpUbi;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.repositoryexp.IRepoExpeTiempo;
import com.portfolioSQLimplSpring.portfolioSQLimplSpring.repositoryexp.IRepoExper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sosag
 */
@Service
public class ServiExp implements IServiExp {
    
    @Autowired
    private IRepoUsuario repouser;
    
    @Autowired
    private IRepoExpUbi repoeu;
    @Autowired
    private IRepoExpeTiempo repoet;
    @Autowired
    private IRepoExper repoexp;

    @Override
    public List<ExpeDTO> traerTodo() {
    
        List<ExpeDTO> expdto=new ArrayList<>();
        List<Experiencia> expe = repoexp.findAll();
    //para evitar errores en traer con otro indice de nuestra base de datos solamente aprovechamos de las entidades que estan 
    //vinculadas y solamente usamos la entidad Experiencia y esa esta relaciona con la tabla Expetiempo que a su ves esta
    //relacionada con la entidad Expubi.
        
        
        
        
        //recorremos solo un array list ya que el resto tiene una relacion OneTOone entonces todos tienen la misma dimension-
        for (int i = 0; i < expe.size(); i++) {
               ExpeDTO x=new ExpeDTO();
               x.setId(expe.get(i).getId());
               x.setTrabajo(expe.get(i).getTrabajo());
               x.setEmpresa(expe.get(i).getExpetiempo().getEmpresa()); //para evitar buscar y que podamos traer con otro indice usamos la FK,
               x.setDeltaanio(expe.get(i).getExpetiempo().getDeltaanio());
               x.setFechaIni(Long.parseLong(expe.get(i).getExpetiempo().getFechafin()));
               x.setFechaFin(Long.parseLong(expe.get(i).getExpetiempo().getFechaini()));
               x.setUriImg(expe.get(i).getExpetiempo().getUbi().getUrlimg());
               x.setLocalidad(expe.get(i).getExpetiempo().getUbi().getLocalidad());
               x.setPais(expe.get(i).getExpetiempo().getUbi().getPais());
               x.setProvincias(expe.get(i).getExpetiempo().getUbi().getProvincia());
           
              expdto.add(x);
            
        }
        return  expdto;
        
    }

    @Override
    public void borrarItem(Long id) {
        repoexp.deleteById(id);
        System.out.println("Item borrado con exito");
    }

    @Override
    public String crearItem(ExpeDTO dato) {
        ExpeUbi expubi= new ExpeUbi();
        ExpeTiempo exptie= new ExpeTiempo();
        Experiencia expe = new Experiencia();
        List<Usuario> user=repouser.findAll();
        
        expubi.setLocalidad(dato.getLocalidad());
        expubi.setProvincia(dato.getProvincias());
        expubi.setPais(dato.getPais());
        expubi.setUrlimg(dato.getUriImg());
        repoeu.save(expubi);
        
        exptie.setFechaini(dato.getFechaIni().toString());
        exptie.setFechafin(dato.getFechaFin().toString());
        exptie.setEmpresa(dato.getEmpresa());
        exptie.setUbi(expubi);
        exptie.setDeltaanio(dato.getDeltaanio());
        repoet.save(exptie);
        
        
        expe.setTrabajo(dato.getTrabajo());
        expe.setUsuario(user.get(0));//asumimos que van a  no van a convivir +de 1 usuario a la vez en nuestra Base de datos
        
        expe.setExpetiempo(exptie);
        repoexp.save(expe);
        
        return "la carga de la experiencia fue exitosa";
        }

    @Override
    public ExpeDTO traerPorId(Long id) {
        
               Experiencia expe=repoexp.getById(id); //trae por id de la base de datos Experiencia               
        
               ExpeDTO x=new ExpeDTO();
               x.setId(expe.getId());
               x.setTrabajo(expe.getTrabajo());
               x.setEmpresa(expe.getExpetiempo().getEmpresa()); //para evitar buscar y que podamos traer con otro indice usamos la FK,
               x.setDeltaanio(expe.getExpetiempo().getDeltaanio());
               x.setFechaIni(Long.parseLong(expe.getExpetiempo().getFechafin()));
               x.setFechaFin(Long.parseLong(expe.getExpetiempo().getFechaini()));
               x.setUriImg(expe.getExpetiempo().getUbi().getUrlimg());
               x.setLocalidad(expe.getExpetiempo().getUbi().getLocalidad());
               x.setPais(expe.getExpetiempo().getUbi().getPais());
               x.setProvincias(expe.getExpetiempo().getUbi().getProvincia());
                
               
               return x;
    }

    
    
    
    
    
    
    
}
