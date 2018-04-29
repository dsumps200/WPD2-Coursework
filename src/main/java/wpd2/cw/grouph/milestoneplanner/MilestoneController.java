package wpd2.cw.grouph.milestoneplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import wpd2.cw.grouph.milestoneplanner.models.Milestone;
import wpd2.cw.grouph.milestoneplanner.models.User;
import wpd2.cw.grouph.milestoneplanner.repository.MilestoneRepository;
import wpd2.cw.grouph.milestoneplanner.repository.UserRepository;
import wpd2.cw.grouph.milestoneplanner.services.MilestoneService;
import wpd2.cw.grouph.milestoneplanner.services.UserService;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
@RequestMapping("/milestones")
public class MilestoneController {

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Autowired
    private MilestoneService milestoneService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public MilestoneController(MilestoneService ms) {
        super();
        this.milestoneService = ms;
    }

    @GetMapping
    public String getAllMilestones(Model model, Principal user) {
        String name = user.getName();
        User currentUser = userRepository.findByUsername(name);
        List<Milestone> milestones = this.milestoneService.getAllMilestonesByUser(currentUser);
        if (milestones.size() > 0) {
            model.addAttribute("milestones", milestones);
            model.addAttribute("hasMilestones", true);
        } else {
            model.addAttribute("hasMilestones", false);
        }
        model.addAttribute("user", currentUser);
        return "milestones";
    }


    /* Post, Put and Delete mappings will go below */
    /* Shows the form for creating a milestone */
    @GetMapping("/create")
    public String createMilestone(Model model) {
        model.addAttribute("milestone", new Milestone());
        return "create-milestone";
    }

    @PostMapping("/create")
    public String create(HttpServletResponse response,
                         @RequestParam("title") String title,
                         @RequestParam("description") String description,
                         @RequestParam("intended-date") String intendedDueDate,
                         @RequestParam("actual-date") String actualDate,
                         Principal user) {

        // Retrieve the user
        String name = user.getName();
        User currentUser = userRepository.findByUsername(name);

        // Convert intendedDueDate to Date object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate intended = LocalDate.parse(intendedDueDate, formatter);
        LocalDate actual;

        if (!actualDate.equals("")) {
            actual = LocalDate.parse(actualDate, formatter);
            milestoneRepository.save(new Milestone(title, description, intended, actual, currentUser));
        } else {
            milestoneRepository.save(new Milestone(title, description, intended, currentUser));
        }

        return "redirect:/milestones";
    }

    @GetMapping("/{id}")
    public String individual_milestone(Model model, @PathVariable Long id, Principal user) {
        Optional<Milestone> milestone = milestoneRepository.findById(id);
        User currentUser = userRepository.findByUsername(user.getName());

        if (milestone.isPresent()) {
            Milestone m = milestone.get();

            if (m.getUser() != currentUser) {
                return "redirect:/milestones";
            }
            model.addAttribute("milestone", m);
            Boolean hasActualCompletion;
            if (m.getActualCompletionDate() == null) {
                hasActualCompletion = false;
            } else {
                hasActualCompletion = true;
            }
            model.addAttribute("hasCompletionDate", hasActualCompletion);
            return "individual_milestone";
        }

        return "redirect:/milestones";
    }

    @PostMapping("/{id}/edit")
    public String edit_milestone(@PathVariable Long id,
                                 @RequestParam("title") String title,
                                 @RequestParam("description") String description,
                                 @RequestParam("intended-date") String intendedDueDate,
                                 @RequestParam("actual-date") String actualCompletionDate,
                                 Principal user,
                                 RedirectAttributes redirectAttrs) {
        Optional<Milestone> milestone = milestoneRepository.findById(id);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate intended = LocalDate.parse(intendedDueDate, formatter);
        LocalDate actual;

        if (!actualCompletionDate.equals("")) {
            actual = LocalDate.parse(actualCompletionDate, formatter);
        } else actual = null;


        if (milestone.isPresent()) {
            Milestone m = milestone.get();
            m.setTitle(title);
            m.setDescription(description);
            m.setIntendedDueDate(intended);
            if (actual != null) {
                m.setActualCompletionDate(actual);
            }

            milestoneRepository.save(m);
        }
        redirectAttrs.addFlashAttribute("msg", "Milestone edited successfully.");
        redirectAttrs.addFlashAttribute("redir", true);
        return "redirect:/milestones/{id}";
    }

    /* Deletes a Milestone, and returns JSON response indicating if the delete was successful or not */
    @DeleteMapping("/{id}/delete")
    @ResponseBody
    public Map<String, Boolean> deleteMilestone(@PathVariable Long id) {
        Optional<Milestone> milestone = milestoneRepository.findById(id);
        if (milestone.isPresent()) {
            Milestone m = milestone.get();
            milestoneRepository.delete(m);
            return Collections.singletonMap("success", true);
        } else {
            return Collections.singletonMap("success", false);
        }
    }
}
