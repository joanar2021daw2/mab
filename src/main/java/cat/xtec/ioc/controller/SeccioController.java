/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.xtec.ioc.controller;

import cat.xtec.ioc.domain.Seccio;
import cat.xtec.ioc.domain.User;
import cat.xtec.ioc.service.SeccioService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JoseAndrade
 */
@Controller
@RequestMapping("/seccio")
public class SeccioController {

    @Autowired
    private SeccioService seccioService;

    @RequestMapping("/all")
    public ModelAndView getAllSeccions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelView = new ModelAndView("seccions");
        List<Seccio> seccions = seccioService.getAllSeccions();
        modelView.getModelMap().addAttribute("seccions", seccions);
        return modelView;
    }

    /*Nova secció*/
    @RequestMapping("/new")
    public ModelAndView novaSeccio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("seccio");
        Seccio formSeccio = new Seccio();
        List<Seccio> seccionsBD = seccioService.getAllSeccions();
        modelview.getModelMap().addAttribute("seccions", seccionsBD);
        modelview.getModelMap().addAttribute("act", "seccio/add");
        modelview.getModelMap().addAttribute("formseccio", formSeccio);
        return modelview;
    }

    @RequestMapping("/seccio")
    public ModelAndView updateSeccio(@RequestParam("seccioId") int seccioId, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelView;
        if (seccioId != 0) {
            modelView = new ModelAndView("seccio");
            Seccio formSeccio = seccioService.getSeccioById(seccioId);
            modelView.getModelMap().addAttribute("act", "seccio/update");
            modelView.getModelMap().addAttribute("formseccio", formSeccio);
        } else {
            modelView = new ModelAndView("seccio");
        }

        return modelView;
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("idSeccio") int seccioId, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Seccio seccio = seccioService.getSeccioById(seccioId);
        seccioService.deleteSeccio(seccio);
        return "redirect:/seccio/all";
    }

    @RequestMapping("/select")
    public ModelAndView selectSection(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelView = new ModelAndView("sselectSeccio");
        List<Seccio> seccions = seccioService.getAllSeccions();
        modelView.getModelMap().addAttribute("seccions", seccions);
        return modelView;
    }

    /*
     FORM DE Seccio POST, procès de creació de instal·lació, redirigim a "crear instal·lació"
    amb la secció creada com atribut per introduïrla a aquesta.
     */
    @RequestMapping(value = "/seccio/add", method = RequestMethod.POST)
    public String processAddForm(@ModelAttribute("formseccio") Seccio formSeccio, BindingResult result) {
        seccioService.addSeccio(formSeccio);
        return "redirect:/seccio/all";
    }

    @RequestMapping(value = "/seccio/update", method = RequestMethod.POST)
    public String processUpdateForm(@ModelAttribute("formseccio") Seccio formSeccio, BindingResult result) {
        seccioService.updateSeccio(formSeccio);
        return "redirect:/seccio/all";
    }
}
