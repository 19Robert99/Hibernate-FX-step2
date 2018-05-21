package service;

import businesslogic.SessionUtil;
import dao.LecturerDao;
import entity.Lecturer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LecturerService extends SessionUtil implements LecturerDao {
    public void add(Lecturer lecturer) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(lecturer);

        //close session with a transaction
        closeTransactionSession();
    }

    public ArrayList<String> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Lecturer";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lecturer.class);
        List<Lecturer> lecturerList = query.list();

        ArrayList<String> list = new ArrayList<>();

        for (Lecturer obj : lecturerList){
            list.add(obj.getFio());
        }
        //close session with a transaction
        closeTransactionSession();

        return list;
    }

    public ArrayList<String> getLectorNum() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Lecturer";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lecturer.class);
        List<Lecturer> lecturerList = query.list();

        ArrayList<String> listLecNum = new ArrayList<>();

        for (Lecturer obj : lecturerList){
            listLecNum.add(Long.toString(obj.getIdLecture()));
        }
        //close session with a transaction
        closeTransactionSession();

        return listLecNum;
    }


    public Lecturer getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Lecturer WHERE idLecture = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lecturer.class);
        query.setParameter("id", id);

        Lecturer lecturer = (Lecturer) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return lecturer;
    }

    public void update(Lecturer lecturer) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(lecturer);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Lecturer lecturer) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.delete(lecturer);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public int idForDelete(int num) throws SQLException {
        openTransactionSession();

        int id = 0;
        List<Lecturer> ClList = null;

        String sql = "SELECT * FROM lecturer WHERE lecturer.idLecture =:num ";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lecturer.class);
        query.setParameter("num", num);
        ClList = query.list();
        ArrayList<Integer> list = new ArrayList<>();

        if (ClList.size()>0) {
            for (Lecturer obj : ClList) {
                list.add((int)obj.getIdLecture());
            }
            id = list.get(0);
        }

        //close session with a transaction
        closeTransactionSession();

        return id;
    }

    @Override
    public ArrayList<String> lectorFromKaf(int id) throws SQLException {
        openTransactionSession();

        List<Lecturer> ClList = null;

        String sql = "SELECT * FROM lecturer WHERE lecturer.idKafedra=:id ";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lecturer.class);
        query.setParameter("id", id);
        ClList = query.list();
        ArrayList<String> list = new ArrayList<>();

            for (Lecturer obj : ClList) {
                list.add(obj.getFio());
            }
        //close session with a transaction
        closeTransactionSession();

        return list;
    }

    @Override
    public int idLectorForDiscipline(int num, String lecName) throws SQLException {
        openTransactionSession();

        int id ;
        List<Lecturer> ClList;

        String sql = "SELECT * FROM lecturer WHERE lecturer.idKafedra =:num AND lecturer.FIO=:lecName";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lecturer.class);
        query.setParameter("num", num);
        query.setParameter("lecName", lecName);
        ClList = query.list();
        ArrayList<Integer> list = new ArrayList<>();

            for (Lecturer obj : ClList) {
                list.add((int)obj.getIdLecture());
            }
            id = list.get(0);
        //close session with a transaction
        closeTransactionSession();

        return id;
    }

    @Override
    public int idLector(int kafID, String lecName) throws SQLException {
        openTransactionSession();

        int id ;
        List<Lecturer> ClList;

        String sql = "SELECT * FROM lecturer WHERE lecturer.idKafedra =:kafID AND lecturer.FIO=:lecName";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lecturer.class);
        query.setParameter("kafID", kafID);
        query.setParameter("lecName", lecName);
        ClList = query.list();
        ArrayList<Integer> list = new ArrayList<>();

        for (Lecturer obj : ClList) {
            list.add((int)obj.getIdLecture());
        }
        id = list.get(0);
        //close session with a transaction
        closeTransactionSession();

        return id;
    }
}
