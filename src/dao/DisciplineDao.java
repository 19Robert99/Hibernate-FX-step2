package dao;

import entity.Discipline;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DisciplineDao {
    //create
    void add(Discipline discipline) throws SQLException;

    //read
    ArrayList<String> getAll() throws SQLException;

    ArrayList<String> getById(Long id) throws SQLException;

    //update
    void update(Discipline discipline) throws SQLException;

    //delete
    void remove(Discipline discipline) throws SQLException;

    int idForDelete(String discipName, int lecId)  throws SQLException;
}
