
package com.portfolio.mp.Controller;


import com.portfolio.mp.Entity.Persona;
import com.portfolio.mp.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://frontendmp.web.app")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public ResponseEntity< List<Persona>> getPersona(){
        
        return new ResponseEntity(ipersonaService.getPersona(), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        Persona personaCreated = new Persona (persona.getNombre(), persona.getApellido(), persona.getImg(),persona.getDescripcion(),persona.getTitulo());
       ipersonaService.savePersona(personaCreated);
       return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return("La persona fue eliminada correctamente");
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,@RequestBody Persona usuario){
        Persona persona = ipersonaService.findPersona(id);
        
        persona.setNombre(usuario.getNombre());
        persona.setApellido(usuario.getApellido());
        persona.setImg(usuario.getImg());
        persona.setDescripcion(usuario.getDescripcion());
        persona.setTitulo(usuario.getTitulo());
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    }
}
