package wpd2.cw.grouph.milestoneplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wpd2.cw.grouph.milestoneplanner.models.Milestone;
import wpd2.cw.grouph.milestoneplanner.services.MilestoneService;

@Controller
@RequestMapping("/milestones")
public class MilestoneController {

    private MilestoneService milestoneService;

    @Autowired
    public MilestoneController(MilestoneService ms) {
        super();
        this.milestoneService = ms;
    }

    @GetMapping
    public String getAllMilestones(Model model) {
        model.addAttribute("milestones", this.milestoneService.getAllMilestones());

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
    public String create(@ModelAttribute Milestone milestone) {
        return "index";
    }
}
