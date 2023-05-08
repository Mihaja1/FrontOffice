package com.example.frontoffice.controller;

import com.example.frontoffice.dao.HibernateDao;
import com.example.frontoffice.modele.Publication;
import com.example.frontoffice.modele.Type_pub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private HibernateDao hibernateDao;



    //FrontOffice
    @GetMapping("/list/*")
    public ModelAndView list() {
        ModelAndView modelAndView= new ModelAndView();
        Publication p1= new Publication(1);
        Publication p2=new Publication(2);
        Publication p3=new Publication(3);
        Publication p4=new Publication(4);
        List<Publication> lp1= hibernateDao.findWhere(p1);
        List<Publication> lp2= hibernateDao.findWhere(p2);
        List<Publication> lp3= hibernateDao.findWhere(p3);
        List<Publication> lp4= hibernateDao.findWhere(p4);

        modelAndView.addObject("lp1",lp1);
        modelAndView.addObject("lp2",lp2);
        modelAndView.addObject("lp3",lp3);
        modelAndView.addObject("lp4",lp4);
        modelAndView.setViewName("Acceuil");

        return modelAndView;
    }


    @GetMapping("/list/{id}/*")
    public ModelAndView details(@PathVariable("id") Integer id){
        ModelAndView modelAndView= new ModelAndView();
        Publication publication= new Publication(id);
        List<Publication> pub= hibernateDao.findWhere(publication);
        modelAndView.addObject("pub",pub);
        modelAndView.setViewName("details");
        return modelAndView;
    }

}
