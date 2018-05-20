package service;

import businesslogic.SessionUtil;
import dao.LessonDao;
import entity.Lesson;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LessonService extends SessionUtil implements LessonDao {
    public void add(Lesson lesson) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(lesson);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<Lesson> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Lesson";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lesson.class);
        List<Lesson> lessonList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return lessonList;
    }

    public Lesson getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Lesson WHERE idLesson = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lesson.class);
        query.setParameter("id", id);

        Lesson lesson = (Lesson) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return lesson;
    }

    public void update(Lesson lesson) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(lesson);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(Lesson lesson) throws SQLException {
//open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.delete(lesson);

        //close session with a transaction
        closeTransactionSession();
    }

    @Override
    public int idForDelete(int num, Date curentDate) throws SQLException {
        openTransactionSession();

        int id =0;
        List<Lesson> ClList = null;

        String sql = "SELECT * FROM lesson WHERE LessonNum =:num AND lesson.Date=:curentDate";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Lesson.class);
        query.setParameter("num", num);
        query.setParameter("curentDate", curentDate);
        ClList = query.list();
        ArrayList<Integer> list = new ArrayList<>();
        if (ClList.size()>0) {
            for (Lesson obj : ClList) {
                list.add((int) obj.getIdLesson());
            }
            id = list.get(0);
        }

        //close session with a transaction
        closeTransactionSession();

        return id;
    }
}
