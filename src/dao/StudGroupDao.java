package dao;

import entity.StudGroup;

import java.sql.SQLException;
import java.util.List;

public interface StudGroupDao {
    //create
    void add(StudGroup studGroup) throws SQLException;

    //read
    List<StudGroup> getAll() throws SQLException;

    StudGroup getById(Long id) throws SQLException;

    //update
    void update(StudGroup studGroup) throws SQLException;

    //delete
    void remove(StudGroup studGroup) throws SQLException;

    int idForDelete(int numGr, int num)  throws SQLException;
}
