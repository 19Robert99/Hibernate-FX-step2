package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.ClassRoom;

public interface ClassRoomDao {
    //create
    void add(ClassRoom classRoom) throws SQLException;

    //read
    ArrayList<String> getKorpus() throws SQLException;

    ArrayList<String> getClassNum(String korpName) throws SQLException;

    ClassRoom getById(Long id) throws SQLException;

    //update
    void update(ClassRoom classRoom) throws SQLException;

    //delete
    void remove(ClassRoom classRoom) throws SQLException;

    int idForDelete(int num, String korp)  throws SQLException;
}
