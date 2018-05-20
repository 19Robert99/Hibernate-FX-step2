package sample;

import javax.persistence.Id;

public class TableData {
    private int id;
    private String teacher;
    private String lesson;
    private String korpus;
    private long classroom;
    private String day;
    private long lessonNum;
    private int start;
    private int end;
    private String facult;
    private String direction;
    private long course;
    private long group;

    public TableData(int id, String teacher, String lesson, String korpus, long classroom, String day, long lessonNum, int start, int end, String facult, String direction, long course, long group) {
        this.id = id;
        this.teacher = teacher;
        this.lesson = lesson;
        this.korpus = korpus;
        this.classroom = classroom;
        this.day = day;
        this.lessonNum = lessonNum;
        this.start = start;
        this.end = end;
        this.facult = facult;
        this.direction = direction;
        this.course = course;
        this.group = group;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public String getKorpus() {
        return korpus;
    }

    public void setKorpus(String korpus) {
        this.korpus = korpus;
    }

    public long getClassroom() {
        return classroom;
    }

    public void setClassroom(long classroom) {
        this.classroom = classroom;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public long getLessonNum() {
        return lessonNum;
    }

    public void setLessonNum(long lessonNum) {
        this.lessonNum = lessonNum;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getFacult() {
        return facult;
    }

    public void setFacult(String facult) {
        this.facult = facult;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public long getCourse() {
        return course;
    }

    public void setCourse(long course) {
        this.course = course;
    }

    public long getGroup() {
        return group;
    }

    public void setGroup(long group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "TableData{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", lesson='" + lesson + '\'' +
                ", korpus='" + korpus + '\'' +
                ", classroom=" + classroom +
                ", day='" + day + '\'' +
                ", lessonNum=" + lessonNum +
                ", start=" + start +
                ", end=" + end +
                ", facult='" + facult + '\'' +
                ", direction='" + direction + '\'' +
                ", course=" + course +
                ", group=" + group +
                '}';
    }
}
