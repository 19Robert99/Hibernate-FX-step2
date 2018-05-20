package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "StudGroup")
public class StudGroup {

    @Id
    @Column(name = "idStudGroup")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idStudGroup;
    @Column(name = "GroupNum", nullable = false)
    private long groupNum;
    @Column(name = "Course", nullable = false)
    private long course;
    @Column(name = "StudCount", nullable = false)
    private  long studCount;


    @ManyToOne
    @JoinColumn(name = "idDirection", nullable = false)
    private Direction direction;

    @OneToMany(mappedBy = "studGroup")
    private Set<CurrentLesson> currentLessons;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public long getIdStudGroup() {
        return idStudGroup;
    }

    public void setIdStudGroup(long idStudGroup) {
        this.idStudGroup = idStudGroup;
    }

    public long getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(long groupNum) {
        this.groupNum = groupNum;
    }

    public long getCourse() {
        return course;
    }

    public void setCourse(long course) {
        this.course = course;
    }

    public long getStudCount() {
        return studCount;
    }

    public void setStudCount(long stutCount) {
        this.studCount = stutCount;
    }

    public Set<CurrentLesson> getCurrentLessons() {
        return currentLessons;
    }

    public void setCurrentLessons(Set<CurrentLesson> currentLessons) {
        this.currentLessons = currentLessons;
    }

    public StudGroup() {
    }

    @Override
    public String toString() {
        return "StudGroup{" +
                "idStudGroup=" + idStudGroup +
                ", groupNum=" + groupNum +
                ", course=" + course +
                ", studCount=" + studCount +
                ", direction=" + direction +
                '}';
    }
}
