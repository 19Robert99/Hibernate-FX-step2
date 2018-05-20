package dao;

import entity.Kafedra;

import java.sql.SQLException;
import java.util.ArrayList;

public interface KafedraDao {
    //create
    void add(Kafedra kafedra) throws SQLException;

    //read
    ArrayList<String> getAll() throws SQLException;

    Kafedra getById(Long id) throws SQLException;

    //update
    void update(Kafedra kafedra) throws SQLException;

    //delete
    void remove(Kafedra kafedra) throws SQLException;

    int idForDelete(String field)  throws SQLException;
}
