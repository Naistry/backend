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


public class DtoBanner {
    
     @NotBlank
     private String imgBanner;

    public DtoBanner() {
    }

    public DtoBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }

    public String getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }
     
     
     
     
}
