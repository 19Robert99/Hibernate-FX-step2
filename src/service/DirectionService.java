package service;

import businesslogic.SessionUtil;
import dao.DirectionDao;
import entity.Direction;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DirectionService extends SessionUtil implements DirectionDao {
    public void add(Direction direction) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(direction);

        //close session with a transaction
        closeTransactionSession();
    }

    public ArrayList<String> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Direction";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Direction.class);
        List<Direction> directionList = query.list();

        ArrayList<String> list = new ArrayList<>();

        for (Direction obj : directionList){
            list.add(obj.getDirectionName());
        }
        //close session with a transaction
        closeTransactionSession();

        return list;
    }

    public ArrayList<String> getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM direction WHERE direction.idFaculty = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Direction.class);
        query.setParameter("id", id);
        List<Direction> directionList = query.list();
        ArrayList<String> list = new ArrayList<>();

        for (Direction obj : directionList){
            list.add(obj.getDirectionName());
        }
        //close session with a transaction
        closeTransactionSession();

        return list;
    }

    public void update(Direction direction) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(direction);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Direction direction) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(direction);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public int idForDelete(String field) throws SQLException {
        openTransactionSession();

        int id = 0;
        List<Direction> ClList = null;

        String sql = "SELECT * FROM direction WHERE DirectionName =:field";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Direction.class);
        query.setParameter("field", field);
        ClList = query.list();
        ArrayList<Integer> list = new ArrayList<>();

        if (ClList.size()>0) {
            for (Direction obj : ClList) {
                list.add((int)obj.getIdDirection());
            }
            id = list.get(0);
        }

        //close session with a transaction
        closeTransactionSession();

        return id;
    }
}
