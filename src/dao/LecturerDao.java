package dao;

import entity.Lecturer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LecturerDao {
    //create
    void add(Lecturer lecturer) throws SQLException;

    //read
    ArrayList<String> getAll() throws SQLException;

    Lecturer getById(Long id) throws SQLException;

    //update
    void update(Lecturer lecturer) throws SQLException;

    //delete
    void remove(Lecturer lecturer) throws SQLException;

    int idForDelete(int num)  throws SQLException;

    ArrayList<String> lectorFromKaf(int id )throws SQLException;

    int idLectorForDiscipline(int num,String lecName)  throws SQLException;

}
