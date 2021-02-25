/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.controller;

import cat.xtec.ioc.domain.Instalacio;
import cat.xtec.ioc.domain.User;
import cat.xtec.ioc.service.InstalacioService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("/instalacio")
public class InstalacioController {

    @Autowired
    private InstalacioService instalacioService;

    //Crear nova instal·lació
    @RequestMapping("/new")
    public ModelAndView createInstalacio (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelView = new ModelAndView("instalacio");
        Instalacio formInstalacio = new Instalacio();
        List<Instalacio> instalacionsDB = instalacioService.getAllInstalacions();
        modelView.getModelMap().addAttribute("instalacions", instalacionsDB);
        modelView.getModelMap().addAttribute("act", "instalacio/add");
        modelView.getModelMap().addAttribute("formInstalacio",formInstalacio);
        return modelView;
    }

}
