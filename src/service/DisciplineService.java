package service;

import businesslogic.SessionUtil;
import dao.DisciplineDao;
import entity.Discipline;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplineService extends SessionUtil implements DisciplineDao {
    public void add(Discipline discipline) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(discipline);

        //close session with a transaction
        closeTransactionSession();
    }

    public ArrayList<String> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Discipline";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Discipline.class);
        List<Discipline> disciplineList = query.list();
        ArrayList<String> list = new ArrayList<>();

        for (Discipline obj : disciplineList){
            list.add(obj.getDisciplineName());
        }
        //close session with a transaction
        closeTransactionSession();

        return list;
    }

    public ArrayList<String> getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM discipline WHERE discipline.idLecture = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Discipline.class);
        query.setParameter("id", id);
        List<Discipline> disciplineList = query.list();
        ArrayList<String> list = new ArrayList<>();

        for (Discipline obj : disciplineList){
            list.add(obj.getDisciplineName());
        }
        //close session with a transaction
        closeTransactionSession();

        return list;
    }

    public void update(Discipline discipline) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(discipline);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Discipline discipline) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.delete(discipline);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public int idForDelete(String discipName, int lecId) throws SQLException {
        openTransactionSession();

        int id =0;
        List<Discipline> ClList = null;

        String sql = "SELECT * FROM discipline WHERE DisciplineName =:discipName AND discipline.idLecture=:lecId";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Discipline.class);
        query.setParameter("discipName", discipName);
        query.setParameter("lecId", lecId);
        ClList = query.list();
        ArrayList<Integer> list = new ArrayList<>();
        if (ClList.size()>0) {
            for (Discipline obj : ClList) {
                list.add((int) obj.getIdDiscipline());
            }
            id = list.get(0);
        }

        //close session with a transaction
        closeTransactionSession();

        return id;
    }


}
