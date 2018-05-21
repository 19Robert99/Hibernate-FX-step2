package service;

import businesslogic.SessionUtil;
import dao.ClassRoomDao;
import entity.ClassRoom;
import entity.CurrentLesson;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomService extends SessionUtil implements ClassRoomDao {

    public void add(ClassRoom classRoom) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(classRoom);

        //close session with a transaction
        closeTransactionSession();
    }

    public ArrayList<String> getKorpus() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM classroom";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(ClassRoom.class);
        List<ClassRoom> classRoomList = query.list();
        ArrayList<String> list = new ArrayList<>();

        for (ClassRoom obj : classRoomList){
            list.add(obj.getKorpus());
        }
        //close session with a transaction
        closeTransactionSession();

        return list;
    }

    @Override
    public ArrayList<String> getClassNum(String korpName) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM ClassRoom WHERE classroom.Korpus=:korpName";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(ClassRoom.class);
        query.setParameter("korpName", korpName);
        List<ClassRoom> classRoomList = query.list();
        ArrayList<String> list = new ArrayList<>();

        for (ClassRoom obj : classRoomList){
            list.add((Long.toString(obj.getClassRoomNum())));
        }
        //close session with a transaction
        closeTransactionSession();

        return list;
    }

    public ClassRoom getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM ClassRoom WHERE ClassRoomNum = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(ClassRoom.class);
        query.setParameter("id", id);

        ClassRoom classRoom = (ClassRoom) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return classRoom;
    }

    public void update(ClassRoom classRoom) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(classRoom);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(ClassRoom classRoom) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(classRoom);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public int idForDelete(int num, String korp) throws SQLException {
        openTransactionSession();

        int id = 0;
        List<ClassRoom> ClList = null;

        String sql = "SELECT * FROM classroom WHERE classroom.ClassRoomNum =:num AND  classroom.Korpus=:korp";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(ClassRoom.class);
        query.setParameter("num", num);
        query.setParameter("korp", korp);
        ClList = query.list();
        ArrayList<Integer> list = new ArrayList<>();

        if (ClList.size()>0) {
            for (ClassRoom obj : ClList) {
                list.add(obj.getIdClassRoom());
            }
                id = list.get(0);
        }

        //close session with a transaction
        closeTransactionSession();

        return id;
    }

}
