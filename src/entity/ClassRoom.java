package entity;

import javax.persistence.*;

@Entity
@Table(name = "ClassRoom")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClassRoom")
    private int idClassRoom;
    @Column(name = "ClassRoomNum", nullable = false, unique = true)//unique = true
    private int classRoomNum;
    @Column(name = "Korpus", nullable = false)
    private String korpus;
    @Column(name = "PlaceCount", nullable = false)
    private int placeCount;

    //@OneToOne(mappedBy = "classRoom")
    //private CurrentLesson currentLesson;

    public ClassRoom() {

    }

    public int getIdClassRoom() {
        return idClassRoom;
    }

    public void setIdClassRoom(int idClassRoom) {
        this.idClassRoom = idClassRoom;
    }

    public long getClassRoomNum() {
        return classRoomNum;
    }

    public void setClassRoomNum(int classRoomNum) {
        this.classRoomNum = classRoomNum;
    }

    public String getKorpus() {
        return korpus;
    }

    public void setKorpus(String korpus) {
        this.korpus = korpus;
    }

    public long getPlaceCount() {
        return placeCount;
    }

    public void setPlaceCount(int placeCount) {
        this.placeCount = placeCount;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "idClassRoom=" + idClassRoom +
                ", classRoomNum=" + classRoomNum +
                ", korpus='" + korpus + '\'' +
                ", placeCount=" + placeCount +
                '}';
    }
}
