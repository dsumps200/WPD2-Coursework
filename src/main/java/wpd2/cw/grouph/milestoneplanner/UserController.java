package wpd2.cw.grouph.milestoneplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import wpd2.cw.grouph.milestoneplanner.models.Role;
import wpd2.cw.grouph.milestoneplanner.models.User;
import wpd2.cw.grouph.milestoneplanner.repository.RoleRepository;
import wpd2.cw.grouph.milestoneplanner.services.*;

import javax.servlet.ServletRequest;
import java.security.Principal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@ControllerAdvice
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserService userDetailsService;

    @GetMapping("/login")
    public String getLoginPage(ServletRequest request, Model model) {
        Map<String, String[]> paramMap = request.getParameterMap();

        if (paramMap.containsKey("error"))
        {
            model.addAttribute("error", true);
            model.addAttribute("msg", "Invalid username and password.");
        } else {
            model.addAttribute("error", false);
        }
        return "login";
    }

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm,
                               Model model,
                               RedirectAttributes redirectAttrs) {

        if (userService.findByUsername(userForm.getUsername()) != null) {
            redirectAttrs.addFlashAttribute("err", "This username is already taken.");
            redirectAttrs.addFlashAttribute("redir", true);
            return "redirect:/register";
        }

        Role r = roleRepository.findByName("ROLE_USER");
        Set<Role> role = new HashSet<>(Collections.singleton(r));
        userForm.setRoles(role);

        userService.save(userForm);

        //securityService.autologin(userForm.getUsername(), userForm.getPassword());

        return "redirect:/";
    }

    @ModelAttribute
    public void addAttributes(Model model, Principal user) {
        if(user != null) {
            String name = user.getName();
            UserDetails currentUser = userDetailsService.loadUserByUsername(name);
            model.addAttribute("user", currentUser);
            model.addAttribute("loggedin", true);

            /* Is user an admin? */
            if (currentUser.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
                model.addAttribute("isadmin",true);
            } else {
                model.addAttribute("isadmin", false);
            }
        } else {
            model.addAttribute("loggedin", false);
        }
    }
}
