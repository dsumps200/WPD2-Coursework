package wpd2.cw.grouph.milestoneplanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wpd2.cw.grouph.milestoneplanner.models.Milestone;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/milestones")
public class MilestoneController {

    private static List<Milestone> milestones = new ArrayList<>();

    static {
        for (int i=0; i<10; i++) {
            milestones.add(new Milestone("description"+i, LocalDateTime.now()));
        }
    }

    @GetMapping
    public String getAllMilestones(Model model) {
        model.addAttribute("milestones", milestones);
        return "milestones";
    }
}
