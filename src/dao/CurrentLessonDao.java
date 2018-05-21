package dao;

import entity.CurrentLesson;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CurrentLessonDao {
    //create
    void add(CurrentLesson currentLesson) throws SQLException;

    //read
    ArrayList<String> getAll() throws SQLException;

    ArrayList<String> getFio() throws SQLException;
    ArrayList<String> getDisciplineName() throws SQLException;
    ArrayList<String> getKorpus() throws SQLException;
    ArrayList<Long> getClassRoomNum() throws SQLException;
    ArrayList<String> getDayOfTheWeek() throws SQLException;
    ArrayList<Long> getLessonNum() throws SQLException;
    ArrayList<Integer> getStart() throws SQLException;
    ArrayList<Integer> getEnd() throws SQLException;
    ArrayList<String> getFacultyName() throws SQLException;
    ArrayList<String> getDirectionName() throws SQLException;
    ArrayList<Long> getCourse() throws SQLException;
    ArrayList<Long> getGroupNum() throws SQLException;
    ArrayList<Integer> getRaspId() throws SQLException;

    CurrentLesson getById(Long id) throws SQLException;

    //update
    void update(CurrentLesson currentLesson) throws SQLException;

    //delete
    void remove(CurrentLesson currentLesson) throws SQLException;
}
