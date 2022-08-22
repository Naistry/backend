
package com.portfolio.mp.Service;

import com.portfolio.mp.Entity.Education;
import com.portfolio.mp.Repository.REducation;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducation {
    @Autowired
    REducation rEducation;
    
    public List<Education> list(){
        
        return rEducation.findAll();
    }
    
    public Optional<Education> getOne(int id){
    
        return rEducation.findById(id);
    }
    
    public Optional<Education> getByNombreE(String nombreE){
        return rEducation.findByNombreE(nombreE);
    }
    
    public void save(Education education){
    
        rEducation.save(education);
    }
    
    public void delete(int id){
    
        rEducation.deleteById(id);
    }
    
    public boolean existsById(int id){
    
        return rEducation.existsById(id);
    }
    
    public boolean existsByNombre(String nombreE){
        
        return rEducation.existsByNombreE(nombreE);
    }
}
