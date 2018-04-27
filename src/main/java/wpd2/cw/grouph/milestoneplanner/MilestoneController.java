package wpd2.cw.grouph.milestoneplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wpd2.cw.grouph.milestoneplanner.services.MilestoneService;

@Controller
@RequestMapping("/")
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
}
