package wpd2.cw.grouph.milestoneplanner.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="MILESTONE")
public class Milestone {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="due_date")
    private LocalDate intendedDueDate;

    @Column(name="completion_date")
    private LocalDate actualCompletionDate;

    public Milestone() { super(); }

    public Milestone(String title, String description, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.intendedDueDate = dueDate;
    }
    public Milestone(String title, String description, LocalDate dueDate, LocalDate actualDate) {
        this.title = title;
        this.description = description;
        this.intendedDueDate = dueDate;
        this.actualCompletionDate = actualDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getIntendedDueDate() {
        return intendedDueDate;
    }

    public void setIntendedDueDate(LocalDate intendedDueDate) {
        this.intendedDueDate = intendedDueDate;
    }

    public LocalDate getActualCompletionDate() {
        return actualCompletionDate;
    }

    public void setActualCompletionDate(LocalDate actualCompletionDate) {
        this.actualCompletionDate = actualCompletionDate;
    }
}
