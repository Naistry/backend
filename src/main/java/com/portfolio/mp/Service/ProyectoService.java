/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mp.Service;

import com.portfolio.mp.Entity.Proyectos;
import com.portfolio.mp.Repository.ProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marti
 */

@Service
@Transactional
public class ProyectoService {
    
    @Autowired ProyectoRepository proyectoRepository;
    
     public List<Proyectos> list(){
        
        return proyectoRepository.findAll();
    }
    
    public Optional<Proyectos> getOne(Long id){
    
        return proyectoRepository.findById(id);
    }
    
    public Optional<Proyectos> getByTitulo(String tituloProyecto){
        return proyectoRepository.findByTituloProyecto(tituloProyecto);
    }
    
    public void save(Proyectos proyecto){
    
        proyectoRepository.save(proyecto);
    }
    
    public void delete(Long id){
    
        proyectoRepository.deleteById(id);
    }
    
    public boolean existsById(Long id){
    
        return proyectoRepository.existsById(id);
    }
    
    public boolean existsByNombre(String tituloProyecto){
        
        return proyectoRepository.existsByTituloProyecto(tituloProyecto);
    }
            
    
}
