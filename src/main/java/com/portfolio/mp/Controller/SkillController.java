/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mp.Controller;

import com.portfolio.mp.Dto.DtoSkill;
import com.portfolio.mp.Entity.Skill;
import com.portfolio.mp.Security.Controller.Mensaje;
import com.portfolio.mp.Service.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marti
 */


@RestController
@RequestMapping("skill")
@CrossOrigin(origins = "https://frontendmp.web.app/")
public class SkillController {
    
    
    @Autowired SkillService skillService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Skill>> listSkill(){
    
        List<Skill> listSkill = skillService.getList();
        
        return new ResponseEntity<>(listSkill, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Skill> createSkill(@RequestBody DtoSkill dtoSkill){
    
        Skill skill =  new Skill(dtoSkill.getPercent(), dtoSkill.getImgSkill());
         System.out.println(dtoSkill.getPercent());
        skillService.saveSkill(skill);
        
        return new ResponseEntity<>(skill, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> upDatekill(@PathVariable("id")Long id, @RequestBody DtoSkill dtoSkill){
    
        if(!skillService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        Skill skill = skillService.getOne(id).get();
        
        skill.setPercent(dtoSkill.getPercent());
        skill.setImgSkill(dtoSkill.getImgSkill());
        
        skillService.saveSkill(skill);
        
        return  new ResponseEntity(new Mensaje("Skill actualizado"), HttpStatus.OK);
    
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkill (@PathVariable("id") Long id){
    
        if(!skillService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST); 
        
        skillService.deleteSkill(id);
        
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }
    
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") Long id){
        if(!skillService.existById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = skillService.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
}

