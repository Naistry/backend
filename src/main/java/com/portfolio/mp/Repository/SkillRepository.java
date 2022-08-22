/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.mp.Repository;

import com.portfolio.mp.Entity.Skill;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author marti
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    
   
}
