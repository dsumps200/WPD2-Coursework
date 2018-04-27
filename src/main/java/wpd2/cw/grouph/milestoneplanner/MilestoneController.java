package wpd2.cw.grouph.milestoneplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import wpd2.cw.grouph.milestoneplanner.models.Milestone;
import wpd2.cw.grouph.milestoneplanner.repository.MilestoneRepository;
import wpd2.cw.grouph.milestoneplanner.services.MilestoneService;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/milestones")
public class MilestoneController {

    @Autowired
    private MilestoneRepository milestoneRepository;

    @Autowired
    private MilestoneService milestoneService;

    @Autowired
    public MilestoneController(MilestoneService ms) {
        super();
        this.milestoneService = ms;
    }

    @GetMapping
    public String getAllMilestones(Model model) {
        List<Milestone> milestones = this.milestoneService.getAllMilestones();

        /* Convert dates to human-readable */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        milestones.forEach(milestone -> milestone.setIntendedDueDate(convertToDateViaSqlTimestamp()));

        model.addAttribute("milestones", milestones);
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
                         @RequestParam("intended-date") String intendedDueDate) {
        // Convert intendedDueDate to Date object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate intended;
        try {
            intended = LocalDate.parse(intendedDueDate, formatter);
        } catch(Exception e) {
            return "redirect:/milestones/create";
        }

        milestoneRepository.save(new Milestone(title, description, intended));
        return "redirect:/milestones";
    }

    @GetMapping("/{id}")
    public String individual_milestone(Model model, @PathVariable Long id) {
        Optional<Milestone> milestone = milestoneRepository.findById(id);

        if (milestone.isPresent()) {
            Milestone m = milestone.get();
            model.addAttribute("milestone", m);
            return "individual_milestone";
        }

        return "redirect:/milestones";
    }
}
