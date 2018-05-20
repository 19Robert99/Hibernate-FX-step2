package entity;

import javax.persistence.*;
import java.util.Set;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Faculty")
public class Faculty {
    @Id
    @Column(name = "idFaculty")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFaculty;
    @Column(name = "FacultyName", nullable = false, unique = true)
    private String facultyName;
    @OneToMany(mappedBy = "faculty")
    private Set<Direction> direction;

    @OneToMany(mappedBy = "faculty")
    private  Set<Kafedra> kafedras;



    public Faculty() {

    }

    public Set<Direction> getDirection() {
        return direction;
    }

    public void setDirection(Set<Direction> direction) {
        this.direction = direction;
    }

    public Set<Kafedra> getKafedras() {
        return kafedras;
    }

    public void setKafedras(Set<Kafedra> kafedras) {
        this.kafedras = kafedras;
    }

    public long getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(long idFaculty) {
        this.idFaculty = idFaculty;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "idFaculty=" + idFaculty +
                ", facultyName='" + facultyName + '\'' +
                '}';
    }
}
