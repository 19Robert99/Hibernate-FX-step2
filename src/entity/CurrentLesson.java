package entity;

import javax.persistence.*;

@Entity
@Table(name = "CurrentLessons")
public class CurrentLesson {
    @Id
    @Column(name = "idCurLes")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCurLes;

    @ManyToOne
    @JoinColumn(name = "idStudGroup", nullable = false)
    private StudGroup studGroup;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idLesson", nullable = false)
    private Lesson lesson;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idClassRoom", nullable = false)
    private ClassRoom classRoom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDiscipline", nullable = false)
    private Discipline discipline;

    public CurrentLesson() {
    }




    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public StudGroup getStudGroup() {
        return studGroup;
    }

    public void setStudGroup(StudGroup studGroup) {
        this.studGroup = studGroup;
    }

    public long getIdCurLes() {
        return idCurLes;
    }

    public void setIdCurLes(long idCurLes) {
        this.idCurLes = idCurLes;
    }

    @Override
    public String toString() {
        return "CurrentLesson{" +
               "idCurLes=" + idCurLes +
                ", studGroup=" + studGroup +
                ", lesson=" + lesson +
                ", classRoom=" + classRoom +
                ", discipline=" + discipline +
                '}';
    }
}
