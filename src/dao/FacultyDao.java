package dao;

import entity.Faculty;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FacultyDao {
    //create
    void add(Faculty faculty) throws SQLException;

    //read
    ArrayList<String> getAll() throws SQLException;

    Faculty getById(Long id) throws SQLException;

    //update
    void update(Faculty faculty) throws SQLException;

    //delete
    void remove(Faculty faculty) throws SQLException;

    int idForDelete(String field)  throws SQLException;
}
