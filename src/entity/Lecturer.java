package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Lecturer")
public class Lecturer {
    @Id
    @Column(name = "idLecture" ,nullable = false, unique = true)
    private int idLecture;
    @Column(name = "FIO", nullable = false, unique = true)
    private String fio;
    @Column (name = "Position", nullable = false)
    private String position;

    @ManyToOne
    @JoinColumn(name = "idKafedra" ,nullable = false)
    private Kafedra kafedra;

    @OneToMany(mappedBy = "lecturer")
    private Set<Discipline> discipline;


    public Lecturer() {
    }

    public Kafedra getKafedra() {
        return kafedra;
    }

    public void setKafedra(Kafedra kafedra) {
        this.kafedra = kafedra;
    }

    public long getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(int idLecture) {
        this.idLecture = idLecture;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Discipline> getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Set<Discipline> discipline) {
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "idLecture=" + idLecture +
                ", fio='" + fio + '\'' +
                ", position='" + position + '\'' +
                ", kafedra=" + kafedra +
                '}';
    }
}
