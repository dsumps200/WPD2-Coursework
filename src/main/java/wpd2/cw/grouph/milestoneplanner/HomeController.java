package wpd2.cw.grouph.milestoneplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wpd2.cw.grouph.milestoneplanner.services.IUserService;
import wpd2.cw.grouph.milestoneplanner.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserDetailsService userService;

    @GetMapping
    public String index(Principal user, Model model) {
        return "index";
    }
}
