package cat.xtec.ioc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JoseAndrade
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("index");
        modelview.getModelMap().addAttribute("benvinguda", "Benvingut a l'App Proccontrol!");
        return modelview;
    }

    @RequestMapping(value = "/edicio", method = RequestMethod.GET)
    public ModelAndView menuEdicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("edicio");
        modelview.getModelMap().addAttribute("benvinguda", "Crea instal·lacions, refrències, usuaris i processos!");
        return modelview;
    }

    @RequestMapping(value = "/usersmenu", method = RequestMethod.GET)
    public ModelAndView menuUsuaris(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("menuUsuaris");
        modelview.getModelMap().addAttribute("benvinguda", "Gestiona els usuaris");
        return modelview;
    }
        @RequestMapping(value = "/secciomenu", method = RequestMethod.GET)
    public ModelAndView menuSeccions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("menuSeccions");
        modelview.getModelMap().addAttribute("benvinguda", "Gestiona les seccions");
        return modelview;
    }
    
        @RequestMapping(value = "/insalaciomenu", method = RequestMethod.GET)
    public ModelAndView menuInstalacions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("menuInstalacions");
        modelview.getModelMap().addAttribute("benvinguda", "Creació d'instal·lacions");
        return modelview;
    }

    @RequestMapping(value = "/processmenu", method = RequestMethod.GET)
    public ModelAndView menuProcessos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("menuProcessos");
        modelview.getModelMap().addAttribute("benvinguda", "Gestiona els processos");
        return modelview;
    }
}
