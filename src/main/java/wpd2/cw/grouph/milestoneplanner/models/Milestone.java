package wpd2.cw.grouph.milestoneplanner.models;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="MILESTONE")
public class Milestone {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="due_date")
    private LocalDateTime intendedDueDate;

    @Column(name="completion_date")
    private LocalDateTime actualCompletionDate;

    public Milestone() { super(); }

    public Milestone(String title, String description, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.intendedDueDate = dueDate;
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
