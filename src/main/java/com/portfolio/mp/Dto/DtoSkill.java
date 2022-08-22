/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mp.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author marti
 */
public class DtoSkill {
    
    @NotBlank
    private Long percent;
    
    @NotBlank
    private String imgSkill;

    public DtoSkill() {
    }

    public DtoSkill(Long percent, String imgSkill) {
        this.percent = percent;
        this.imgSkill = imgSkill;
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
