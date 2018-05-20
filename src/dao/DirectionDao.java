package dao;

import entity.Direction;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DirectionDao {
    //create
    void add(Direction direction) throws SQLException;

    //read
    ArrayList<String> getAll() throws SQLException;

    Direction getById(Long id) throws SQLException;

    //update
    void update(Direction direction) throws SQLException;

    //delete
    void remove(Direction direction) throws SQLException;

    int idForDelete(String field)  throws SQLException;
}
