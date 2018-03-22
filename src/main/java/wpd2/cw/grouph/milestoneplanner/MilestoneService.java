package wpd2.cw.grouph.milestoneplanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wpd2.cw.grouph.milestoneplanner.models.Milestone;

import java.util.ArrayList;
import java.util.List;

@Service
public class MilestoneService {
    private MilestoneRepository milestoneRepository;

    @Autowired
    public MilestoneService(MilestoneRepository mr) {
        super();
        this.milestoneRepository = mr;
    }

    public List<Milestone> getAllMilestones() {
        List<Milestone> milestones = new ArrayList<>();
        /* Iterate over all the milestones in the repository and add them to the milestones list, then return */
        this.milestoneRepository.findAll().forEach(milestone -> milestones.add(milestone));
        return milestones;
    }
}
