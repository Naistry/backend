
package com.portfolio.mp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


/**
 *
 * @author marti
 */

@Entity
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private Long percent;
    
    @NotNull
    private String imgSkill;

    public Skill() {
    }

    public Skill(Long percent, String imgSkill) {
        this.percent = percent;
        this.imgSkill = imgSkill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPercent() {
        return percent;
    }

    public void setPercent(Long percent) {
        this.percent = percent;
    }

    public String getImgSkill() {
        return imgSkill;
    }

    public void setImgSkill(String imgSkill) {
        this.imgSkill = imgSkill;
    }
    
    
    
}
