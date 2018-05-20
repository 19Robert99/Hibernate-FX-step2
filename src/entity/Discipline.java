package entity;


import javax.persistence.*;

@Entity
@Table(name = "Discipline")
public class Discipline {
    @Id
    @Column(name = "idDiscipline")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDiscipline;

    @Column(name = "DisciplineName", nullable = false, unique = true)
    private String disciplineName;

    @ManyToOne
    @JoinColumn(name = "idLecture", nullable = false)
    private Lecturer lecturer;

    // @OneToOne(mappedBy = "discipline")
    // private CurrentLesson currentLesson;

    public Discipline() {
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public long getIdDiscipline() {
        return idDiscipline;
    }

    public void setIdDiscipline(long idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "idDiscipline=" + idDiscipline +
                ", disciplineName='" + disciplineName + '\'' +
                ", lecturer=" + lecturer +
                '}';
    }
}
