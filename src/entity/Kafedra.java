package entity;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Kafedra" )
public class Kafedra {
    @Id
    @Column(name = "idKafedra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idKafedra;
    @Column(name = "KafedraName", nullable = false, unique = true)
    private String kafedraName;
    @ManyToOne
    @JoinColumn(name = "idFaculty", nullable = false)
    private Faculty faculty;



    @OneToMany(mappedBy = "kafedra")
    private Set<Lecturer> lecturers;

    public long getIdKafedra() {
        return idKafedra;
    }

    public void setIdKafedra(long idKafedra) {
        this.idKafedra = idKafedra;
    }

    public String getKafedraName() {
        return kafedraName;
    }

    public void setKafedraName(String kafedraName) {
        this.kafedraName = kafedraName;
    }

    public Set<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(Set<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Kafedra() {
    }

    @Override
    public String toString() {
        return "Kafedra{" +
                "idKafedra=" + idKafedra +
                ", kafedraName='" + kafedraName + '\'' +
                ", faculty=" + faculty +
                '}';
    }
}
