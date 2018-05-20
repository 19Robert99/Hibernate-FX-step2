package entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Direction")
public class Direction {
    @Id
    @Column(name = "idDirection")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDirection;

    @Column(name = "DirectionName", nullable = false, unique = true)
    private String directionName;
    @ManyToOne
    @JoinColumn(name = "idFaculty", nullable = false)
    private Faculty faculty;

    @OneToMany(mappedBy = "direction")
    private Set<StudGroup> studGroups;

    public Direction() {
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public long getIdDirection() {
        return idDirection;
    }

    public void setIdDirection(long idDirection) {
        this.idDirection = idDirection;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public Set<StudGroup> getStudGroups() {
        return studGroups;
    }

    public void setStudGroups(Set<StudGroup> studGroups) {
        this.studGroups = studGroups;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "idDirection=" + idDirection +
                ", directionName='" + directionName + '\'' +
                ", faculty=" + faculty +
                '}';
    }
}
