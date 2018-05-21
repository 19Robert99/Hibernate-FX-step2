package service;

import businesslogic.SessionUtil;
import dao.CurrentLessonDao;
import entity.CurrentLesson;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class CurrentLessonService extends SessionUtil implements CurrentLessonDao {


    public void add(CurrentLesson currentLesson) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(currentLesson);

        closeTransactionSession();
    }


    public ArrayList<String> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);


        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<String> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add(obj.getDiscipline().getLecturer().getFio());
            list.add(obj.getDiscipline().getDisciplineName());
            list.add(obj.getClassRoom().getKorpus());
            list.add(Long.toString(obj.getClassRoom().getClassRoomNum()));
            list.add(obj.getLesson().getDayOfTheWeek());
            list.add(Long.toString(obj.getLesson().getLessonNum()));
            list.add(Long.toString(obj.getLesson().getStart()));
            list.add(Long.toString(obj.getLesson().getEnd()));
            list.add(obj.getStudGroup().getDirection().getFaculty().getFacultyName());
            list.add(obj.getStudGroup().getDirection().getDirectionName());
            list.add(Long.toString(obj.getStudGroup().getCourse()));
            list.add(Long.toString(obj.getStudGroup().getGroupNum()));

        }
        closeTransactionSession();
        return list;
    }

    @Override
    public ArrayList<String> getFio() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);


        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<String> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add(obj.getDiscipline().getLecturer().getFio());
        }
        closeTransactionSession();
        return list;
    }

    @Override
    public ArrayList<String> getDisciplineName() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);


        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<String> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add(obj.getDiscipline().getDisciplineName());
        }
        closeTransactionSession();
        return list;
    }

    @Override
    public ArrayList<String> getKorpus() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);


        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<String> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add(obj.getClassRoom().getKorpus());
        }
        closeTransactionSession();

        return list;
    }

    @Override
    public ArrayList<Long> getClassRoomNum() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);


        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<Long> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add(obj.getClassRoom().getClassRoomNum());
        }
        closeTransactionSession();
        return list;
    }

    @Override
    public ArrayList<String> getDayOfTheWeek() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);


        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<String> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add(obj.getLesson().getDayOfTheWeek());
        }
        closeTransactionSession();
        return list;
    }

    @Override
    public ArrayList<Long> getLessonNum() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);


        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<Long> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add(obj.getLesson().getLessonNum());
        }
        closeTransactionSession();
        return list;
    }

    @Override
    public ArrayList<Integer> getStart() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);


        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<Integer> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add(obj.getLesson().getStart());
        }
        closeTransactionSession();
        return list;
    }

    @Override
    public ArrayList<Integer> getEnd() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);


        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<Integer> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add(obj.getLesson().getEnd());
        }
        closeTransactionSession();
        return list;
    }

    @Override
    public ArrayList<String> getFacultyName() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);


        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<String> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add(obj.getStudGroup().getDirection().getFaculty().getFacultyName());
        }
        closeTransactionSession();
        return list;
    }

    @Override
    public ArrayList<String> getDirectionName() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);

        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<String> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add(obj.getStudGroup().getDirection().getDirectionName());
        }
        closeTransactionSession();
        return list;
    }

    @Override
    public ArrayList<Long> getCourse() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);

        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<Long> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add(obj.getStudGroup().getCourse());
        }
        closeTransactionSession();
        return list;
    }

    @Override
    public ArrayList<Long> getGroupNum() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);


        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<Long> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add(obj.getStudGroup().getGroupNum());
        }
        closeTransactionSession();

        return list;
    }

    @Override
    public ArrayList<Integer> getRaspId() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);


        List<CurrentLesson> CurrentLessonList = query.list();
        //List<CurrentLesson> curTest = new ArrayList<>(query.list()) ;
        ArrayList<Integer> list = new ArrayList<>();
        //close session with a transaction


        for (CurrentLesson obj : CurrentLessonList){
            list.add((int)obj.getIdCurLes());
        }
        closeTransactionSession();

        return list;
    }


    public CurrentLesson getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM currentlessons WHERE idCurLes = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(CurrentLesson.class);
        query.setParameter("id", id);

        CurrentLesson currentLesson = (CurrentLesson) query.getSingleResult();

        //close session with a transaction

        System.out.println("2//////: "+currentLesson.getClassRoom().toString());
            System.out.println("2: "+currentLesson.getDiscipline().getLecturer().getFio());
            System.out.println("2: "+currentLesson.getDiscipline().getDisciplineName());
            System.out.println("2: "+currentLesson.getClassRoom().getClassRoomNum());
            System.out.println("2: "+currentLesson.getLesson().getDayOfTheWeek());
            System.out.println("2: "+currentLesson.getLesson().getLessonNum());
            System.out.println("2: "+currentLesson.getLesson().getStart());
            System.out.println("2: "+currentLesson.getLesson().getEnd());
            System.out.println("2: "+currentLesson.getStudGroup().getDirection().getFaculty().getFacultyName());
            System.out.println("2: "+currentLesson.getStudGroup().getDirection().getDirectionName());
            System.out.println("2: "+currentLesson.getStudGroup().getCourse());
            System.out.println("2: "+currentLesson.getStudGroup().getGroupNum());

        closeTransactionSession();
        return currentLesson;
    }

    public void update(CurrentLesson currentLesson) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(currentLesson);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(CurrentLesson currentLesson) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(currentLesson);

        //close session with a transaction
        closeTransactionSession();
    }
}
