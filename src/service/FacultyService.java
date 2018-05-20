package service;

import businesslogic.SessionUtil;
import dao.FacultyDao;
import entity.Faculty;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyService extends SessionUtil implements FacultyDao {

    public void add(Faculty faculty) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(faculty);

        //close session with a transaction
        closeTransactionSession();
    }

    public ArrayList<String> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Faculty";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Faculty.class);
        List<Faculty> facultyList = query.list();

        ArrayList<String> list = new ArrayList<>();

        for (Faculty obj : facultyList){
            list.add(obj.getFacultyName());
        }
        //close session with a transaction
        closeTransactionSession();

        return list;
    }

    public Faculty getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Faculty WHERE idFaculty = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Faculty.class);
        query.setParameter("id", id);

        Faculty faculty = (Faculty) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return faculty;
    }

    public void update(Faculty faculty) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(faculty);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Faculty faculty) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.delete(faculty);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public int idForDelete(String field) throws SQLException {
        openTransactionSession();

        int id = 0;
        List<Faculty> ClList = null;

        String sql = "SELECT * FROM faculty WHERE FacultyName =:field";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Faculty.class);
        query.setParameter("field", field);
        ClList = query.list();
        ArrayList<Integer> list = new ArrayList<>();

        if (ClList.size()>0) {
            for (Faculty obj : ClList) {
                list.add((int)obj.getIdFaculty());
            }
            id = list.get(0);
        }

        //close session with a transaction
        closeTransactionSession();

        return id;
    }
}
