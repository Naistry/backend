/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mp.Service;

import com.portfolio.mp.Entity.Skill;
import com.portfolio.mp.Repository.SkillRepository;
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
public class SkillService {
    
    @Autowired
    private SkillRepository skillRepository;
    
    
    public List<Skill> getList(){
        
        return skillRepository.findAll();
    }
    
    
    public Optional<Skill> getOne(Long id){
    
        return skillRepository.findById(id);
    }
    
    
    public void saveSkill(Skill skill){
        
        skillRepository.save(skill);
    }
    
    public void deleteSkill(Long id){
    
        skillRepository.deleteById(id);
    }
    
    public boolean existById(Long id){
    
        return skillRepository.existsById(id);
    }
    
    
}
