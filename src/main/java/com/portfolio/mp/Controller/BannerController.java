/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mp.Controller;

import com.portfolio.mp.Dto.DtoBanner;
import com.portfolio.mp.Entity.Banner;
import com.portfolio.mp.Security.Controller.Mensaje;
import com.portfolio.mp.Service.BannerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("banner")
@CrossOrigin(origins = "http://localhost:4200")
public class BannerController {
    
    @Autowired BannerService bannerService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Banner>> getBanner(){
       
        return new ResponseEntity<>(bannerService.getBanner(), HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?>createBanner(@RequestBody DtoBanner dtoBanner){
    
        Banner banner = new Banner(dtoBanner.getImgBanner());
        
        bannerService.saveBanner(banner);
        
        return new ResponseEntity<>(new Mensaje("Banner creado"), HttpStatus.CREATED);
    }
    
     
    @PutMapping("/update/{id}")
    public ResponseEntity<?> upDate(@PathVariable("id") Long id, @RequestBody DtoBanner dtoBanner){
    
     
       Banner banner = bannerService.getOne(id).get();
      banner.setImgBanner(dtoBanner.getImgBanner());
      bannerService.saveBanner(banner);
        return new ResponseEntity(new Mensaje("Banner actualizado"), HttpStatus.OK);
    }
    
   
    
}
