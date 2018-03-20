package wpd2.cw.grouph.milestoneplanner.models;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Milestone {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String description;
    @Column
    private LocalDateTime intendedDueDate;
    @Column
    private LocalDateTime actualCompletionDate;

    public Milestone() { super(); }

    public Milestone(String description, LocalDateTime dueDate) {
        this.description = description;
        this.intendedDueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getIntendedDueDate() {
        return intendedDueDate;
    }

    public void setIntendedDueDate(LocalDateTime intendedDueDate) {
        this.intendedDueDate = intendedDueDate;
    }

    public LocalDateTime getActualCompletionDate() {
        return actualCompletionDate;
    }

    public void setActualCompletionDate(LocalDateTime actualCompletionDate) {
        this.actualCompletionDate = actualCompletionDate;
    }
}
