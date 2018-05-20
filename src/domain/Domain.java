package domain;

import businesslogic.HibernateUtil;
import entity.*;
import service.*;


import java.sql.SQLException;
import java.util.*;

public class Domain {
    private static List<CurrentLesson> currentLessonList = new ArrayList<CurrentLesson>();
    private static List<Kafedra> kafList = new ArrayList<Kafedra>();
    private static List<Lecturer> lectList = new ArrayList<Lecturer>();
    private static List<Discipline> dispList = new ArrayList<Discipline>();
    private static List<Direction> dirList = new ArrayList<Direction>();
    private static List<StudGroup> studgrList = new ArrayList<StudGroup>();
    private static List<Lesson> lessList = new ArrayList<Lesson>();
    private static List<ClassRoom> classfacList = new ArrayList<ClassRoom>();



    public static  void main(String [] args) throws SQLException {
        ClassRoomService classRoomService = new ClassRoomService();
        CurrentLessonService currentLessonService = new CurrentLessonService();
        DirectionService directionService = new DirectionService();
        DisciplineService disciplineService = new DisciplineService();
        FacultyService facultyService = new FacultyService();
        KafedraService kafedraService = new KafedraService();
        LecturerService lecturerService = new LecturerService();
        LessonService lessonService = new LessonService();
        StudGroupService studGroupService = new StudGroupService();


        Faculty faculty = new Faculty();
        faculty.setFacultyName("КСФ");

        Kafedra kafedra = new Kafedra();
        kafedra.setKafedraName("КТК");
        kafedra.setFaculty(faculty);

        Lecturer lecturer = new Lecturer();
        lecturer.setIdLecture(101);
        lecturer.setFio("Рублев И.с.");
        lecturer.setPosition("Старший преподаватель");
        lecturer.setKafedra(kafedra);

        Discipline discipline = new Discipline();
        discipline.setDisciplineName("ОБД");
        discipline.setLecturer(lecturer);

        Direction direction = new Direction();
        direction.setDirectionName("Компьютерные науки");
        direction.setFaculty(faculty);


        StudGroup studGroup = new StudGroup();
        studGroup.setCourse(4);
        studGroup.setGroupNum(3);
        studGroup.setStudCount(20);
        studGroup.setDirection(direction);

        Calendar calendar = Calendar.getInstance();
        calendar.set(1939, Calendar.MAY, 1);

        Lesson lesson = new Lesson();
        lesson.setLessonNum(2);
        lesson.setLessonStart("13:00");
        lesson.setDate(new java.sql.Date(calendar.getTime().getTime()));
        lesson.setStart(5);
        lesson.setEnd(14);
        lesson.setDayOfTheWeek("Monday");

        ClassRoom classRoom = new ClassRoom();
        classRoom.setClassRoomNum(212);
        classRoom.setKorpus("Старый корпус");
        classRoom.setPlaceCount(50);

        CurrentLesson currentLesson = new CurrentLesson();
        currentLesson.setLesson(lesson);
        currentLesson.setClassRoom(classRoom);
        currentLesson.setDiscipline(discipline);
        currentLesson.setStudGroup(studGroup);

        Set<Kafedra> kafedras = new HashSet<Kafedra>();
        kafedras.add(kafedra);
        faculty.setKafedras(kafedras);

        Set<Direction> directions = new HashSet<Direction>();
        directions.add(direction);
        faculty.setDirection(directions);

        Set<Lecturer> lecturers = new HashSet<Lecturer>();
        lecturers.add(lecturer);
        kafedra.setLecturers(lecturers);

        Set<Discipline> disciplines = new HashSet<Discipline>();
        disciplines.add(discipline);
        lecturer.setDiscipline(disciplines);

        facultyService.add(faculty);
        kafedraService.add(kafedra);
        lecturerService.add(lecturer);
        disciplineService.add(discipline);
        directionService.add(direction);
        studGroupService.add(studGroup);
        lessonService.add(lesson);
        classRoomService.add(classRoom);
        currentLessonService.add(currentLesson);
        HibernateUtil.shutdown();
    }
}
