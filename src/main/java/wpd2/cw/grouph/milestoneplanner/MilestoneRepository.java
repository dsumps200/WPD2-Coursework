package wpd2.cw.grouph.milestoneplanner;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wpd2.cw.grouph.milestoneplanner.models.Milestone;

@Repository
public interface MilestoneRepository extends CrudRepository<Milestone, Long> {
    /* The CrudRepository defines a findAll() method which gets all the entities from the database
    *  This is used in the MilestoneService */
}
