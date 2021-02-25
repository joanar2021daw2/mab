package cat.xtec.ioc.controller;

import cat.xtec.ioc.domain.User;
import cat.xtec.ioc.service.UserService;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/all")
    public ModelAndView getAllUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelView = new ModelAndView("users");
        List<User> users = userService.getAllUsers();
        modelView.getModelMap().addAttribute("usuaris", users);
        return modelView;
    }

    /*Nou usuari*/
    @RequestMapping("/new")
    public ModelAndView newUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView modelview = new ModelAndView("user");
        User formUser = new User();
        List<User> usuarisBD = userService.getAllUsers();
        modelview.getModelMap().addAttribute("usuaris", usuarisBD);
        modelview.getModelMap().addAttribute("act", "user/add");
        modelview.getModelMap().addAttribute("formuser", formUser);
        return modelview;
    }

    @RequestMapping("/user")
    public ModelAndView updateUser(@RequestParam("userId") int userId, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelView;
         if (userId != 0) {
            modelView = new ModelAndView("user");
            User formUser = userService.getUserById(userId);
            modelView.getModelMap().addAttribute("act", "user/update");
            modelView.getModelMap().addAttribute("formuser", formUser);
        } else {
            modelView = new ModelAndView("users");
        }

        return modelView;
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("userId") int userId, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = userService.getUserById(userId);
        userService.remove(user);
        return "redirect:/users/all";
    }

    /*
     FORM DE user POST
     */
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String processAddForm(@ModelAttribute("formuser") User formUser, BindingResult result) {
        userService.createUser(formUser);
        return "redirect:/users/all";
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String processUpdateForm(@ModelAttribute("formuser") User formUser, BindingResult result) {
        userService.updateUser(formUser);
        return "redirect:/users/all";
    }
}
