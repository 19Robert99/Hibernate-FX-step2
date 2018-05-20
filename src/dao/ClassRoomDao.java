package dao;

import java.sql.SQLException;
import java.util.List;
import entity.ClassRoom;

public interface ClassRoomDao {
    //create
    void add(ClassRoom classRoom) throws SQLException;

    //read
    List<ClassRoom> getAll() throws SQLException;

    ClassRoom getById(Long id) throws SQLException;

    //update
    void update(ClassRoom classRoom) throws SQLException;

    //delete
    void remove(ClassRoom classRoom) throws SQLException;

    int idForDelete(int num, String korp)  throws SQLException;
}
