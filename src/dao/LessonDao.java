package dao;

import entity.Lesson;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface LessonDao {
    //create
    void add(Lesson lesson) throws SQLException;

    //read
    List<Lesson> getAll() throws SQLException;

    Lesson getById(Long id) throws SQLException;

    ArrayList<String> getStart() throws SQLException;
    ArrayList<String> getEnd() throws SQLException;

    //update
    void update(Lesson lesson) throws SQLException;

    //delete
    void remove(Lesson lesson) throws SQLException;

    int idForDelete(int num, Date curentDate)  throws SQLException;
}
