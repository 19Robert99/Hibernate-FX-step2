package service;

import businesslogic.SessionUtil;
import dao.KafedraDao;
import entity.Kafedra;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KafedraService extends SessionUtil implements KafedraDao {
    public void add(Kafedra kafedra) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(kafedra);

        //close session with a transaction
        closeTransactionSession();
    }

    public ArrayList<String> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Kafedra";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Kafedra.class);
        List<Kafedra> kafedraList= query.list();

        ArrayList<String> list = new ArrayList<>();

        for (Kafedra obj : kafedraList){
            list.add(obj.getKafedraName());
        }
        //close session with a transaction
        closeTransactionSession();

        return list;
    }

    public Kafedra getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Kafedra WHERE idKafedra = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Kafedra.class);
        query.setParameter("id", id);

        Kafedra kafedra = (Kafedra) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return kafedra;
    }

    public void update(Kafedra kafedra) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(kafedra);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Kafedra kafedra) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.delete(kafedra);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public int idForDelete(String field) throws SQLException {
        openTransactionSession();

        int id = 0;
        List<Kafedra> ClList = null;

        String sql = "SELECT * FROM kafedra WHERE kafedra.KafedraName=:field ";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Kafedra.class);
        query.setParameter("field", field);
        ClList = query.list();
        ArrayList<Integer> list = new ArrayList<>();

        if (ClList.size()>0) {
            for (Kafedra obj : ClList) {
                list.add((int)obj.getIdKafedra());
            }
            id = list.get(0);
        }

        //close session with a transaction
        closeTransactionSession();

        return id;
    }
}
