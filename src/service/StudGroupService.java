package service;

import businesslogic.SessionUtil;
import dao.StudGroupDao;
import entity.StudGroup;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudGroupService extends SessionUtil implements StudGroupDao {
    public void add(StudGroup studGroup) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(studGroup);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<StudGroup> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM StudGroup";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(StudGroup.class);
        List<StudGroup> studGroupList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return studGroupList;
    }


    public StudGroup getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM StudGroup WHERE idStudGroup = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(StudGroup.class);
        query.setParameter("id", id);

        StudGroup studGroup = (StudGroup) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return studGroup;
    }

    public void update(StudGroup studGroup) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(studGroup);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(StudGroup studGroup) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(studGroup);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public int idForDelete(int numDir, int numGr) throws SQLException {
        openTransactionSession();

        int id =0;
        List<StudGroup> ClList = null;

        String sql = "SELECT * FROM studgroup WHERE studgroup.GroupNum =:numGr AND studgroup.idDirection=:numDir";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(StudGroup.class);
        query.setParameter("numGr", numGr);
        query.setParameter("numDir", numDir);
        ClList = query.list();
        ArrayList<Integer> list = new ArrayList<>();
        if (ClList.size()>0) {
            for (StudGroup obj : ClList) {
                list.add((int) obj.getIdStudGroup());
            }
            id = list.get(0);
        }

        //close session with a transaction
        closeTransactionSession();

        return id;
    }
}
