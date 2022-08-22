
package com.portfolio.mp.Interface;

import com.portfolio.mp.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    
    //Get list de persona
    public List<Persona> getPersona();
    
    //Save object persona
    public void savePersona(Persona persona);
    
    //Delete 
    public void deletePersona(Long id);
    
    //Search
    public Persona findPersona(Long id);
}
