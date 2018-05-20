package dao;

import entity.Discipline;

import java.sql.SQLException;
import java.util.List;

public interface DisciplineDao {
    //create
    void add(Discipline discipline) throws SQLException;

    //read
    List<Discipline> getAll() throws SQLException;

    Discipline getById(Long id) throws SQLException;

    //update
    void update(Discipline discipline) throws SQLException;

    //delete
    void remove(Discipline discipline) throws SQLException;

    int idForDelete(String discipName, int lecId)  throws SQLException;
}
