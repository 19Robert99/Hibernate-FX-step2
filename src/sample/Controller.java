package sample;

import businesslogic.HibernateUtil;
import entity.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import service.*;

import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class Controller implements Initializable {

    @FXML private TextField groupNum,groupCount,groupKyrs,audNum,audKorpus,audPlaceCount,lessNum,
            lessStart,lessEnd,distsiplinaName,kafedraName,lectorFio,lectorPosition,lectorNum,directionName,facultName,idForDelite;
    @FXML private DatePicker dataPick,raspComboDate;
    @FXML private ComboBox<String> comboFacult,comboFacult1,comboDirection1,comboKafedra,comboLector,comboDay,comboKafForDistcipline,comboTime,
            raspComboTeacher,raspComboLesson,raspComboKorpus,raspComboClassroom,raspComboDay,raspComboLessonNum,raspComboFaculty,
            raspComboDirection,raspComboStart,raspComboEnd,raspComboKyrs,raspComboGroupNum,raspComboKafedra;

    @FXML private TableView<TableData> dataTable;
    @FXML private TableColumn<TableData, Integer> id;
    @FXML private TableColumn<TableData, String> teach;
    @FXML private TableColumn<TableData, String> les;
    @FXML private TableColumn<TableData, String> korp;
    @FXML private TableColumn<TableData, Long> room;
    @FXML private TableColumn<TableData, String> dayOf;
    @FXML private TableColumn<TableData, Long> numles;
    @FXML private TableColumn<TableData, Integer> from;
    @FXML private TableColumn<TableData, Integer> to;
    @FXML private TableColumn<TableData, String> facult;
    @FXML private TableColumn<TableData, String> napravl;
    @FXML private TableColumn<TableData, Long> kyrs;
    @FXML private TableColumn<TableData, Long> grupa;

    private ObservableList<TableData> data = FXCollections.observableArrayList();

    private final int SUCCESSFULLY_ADDED = 1;
    private final int FIELD_NOT_FOUND = 2;
    private final int FIELD_EXISTS = 3;
    private final int SUCCESSFULLY_DELETE = 4;

    private ArrayList<Integer> raspID,start,end;
    private ArrayList<String> teacher,lesson,korpus,day,department,direction,teacherForCombo,departmentForCombo,
            directionForCombo,kafedraForCombo,lectorDocNum;
    private ArrayList<Long> classroom,lessonNum,cours,group;

    ClassRoomService classRoomService = new ClassRoomService();
    CurrentLessonService currentLessonService = new CurrentLessonService();
    DirectionService directionService = new DirectionService();
    DisciplineService disciplineService = new DisciplineService();
    FacultyService facultyService = new FacultyService();
    KafedraService kafedraService = new KafedraService();
    LecturerService lecturerService = new LecturerService();
    LessonService lessonService = new LessonService();
    StudGroupService studGroupService = new StudGroupService();


    public void insertData() throws SQLException {
        CurrentLessonService currentLessonService = new CurrentLessonService();

        raspID = currentLessonService.getRaspId();
        teacher = currentLessonService.getFio();
        lesson= currentLessonService.getDisciplineName();
        korpus = currentLessonService.getKorpus();
        classroom=currentLessonService.getClassRoomNum();
        day=currentLessonService.getDayOfTheWeek();
        lessonNum=currentLessonService.getLessonNum();
        start=currentLessonService.getStart();
        end=currentLessonService.getEnd();
        department=currentLessonService.getFacultyName();
        direction = currentLessonService.getDirectionName();
        cours=currentLessonService.getCourse();
        group=currentLessonService.getGroupNum();



        for (int i = 0; i < teacher.size(); i++) {
            data.add(new TableData(raspID.get(i),teacher.get(i),lesson.get(i),korpus.get(i),classroom.get(i),day.get(i),lessonNum.get(i),start.get(i),
                    end.get(i),department.get(i),direction.get(i),cours.get(i),group.get(i)));
        }


    }
    public void createCombo() throws SQLException {

        ObservableList<String> rsKaf = FXCollections.observableArrayList(kafedraService.getAll());
        raspComboKafedra.setItems(rsKaf);

        raspComboKafedra.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
            try {
                int kafId = kafedraService.idForDelete(raspComboKafedra.getSelectionModel().getSelectedItem());
                ObservableList<String> rsTeach = FXCollections.observableArrayList(lecturerService.lectorFromKaf(kafId));
                raspComboTeacher.setItems(rsTeach);
            } catch (SQLException e) {} }
        );

        raspComboTeacher.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
            try {
                int kafId = kafedraService.idForDelete(raspComboKafedra.getSelectionModel().getSelectedItem());
                long teachId = lecturerService.idLector(kafId, raspComboTeacher.getSelectionModel().getSelectedItem());
                ObservableList<String> rsles = FXCollections.observableArrayList(disciplineService.getById(teachId));
                raspComboLesson.setItems(rsles);
            } catch (SQLException e) {} }
        );

        ObservableList<String> rsKorp = FXCollections.observableArrayList(classRoomService.getKorpus());
        raspComboKorpus.setItems(rsKorp);
        raspComboKorpus.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
            try {
                String selectKorp = raspComboKorpus.getSelectionModel().getSelectedItem();
                ObservableList<String> rsRoom = FXCollections.observableArrayList(classRoomService.getClassNum(selectKorp));
                raspComboClassroom.setItems(rsRoom);
            } catch (SQLException e) {} }
        );

        ObservableList<String> rsFc= FXCollections.observableArrayList(facultyService.getAll());
        raspComboFaculty.setItems(rsFc);
        raspComboFaculty.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
            try {
                long facultID = facultyService.idForDelete(raspComboFaculty.getSelectionModel().getSelectedItem());
                ObservableList<String> rsDir = FXCollections.observableArrayList(directionService.getById(facultID));
                raspComboDirection.setItems(rsDir);
            } catch (SQLException e) {} }
        );
        ObservableList<String> rsStart= FXCollections.observableArrayList(lessonService.getStart());
        raspComboStart.setItems(rsStart);

        ObservableList<String> rsEnd= FXCollections.observableArrayList(lessonService.getEnd());
        raspComboEnd.setItems(rsEnd);
        raspComboDay.getItems().addAll("Понедельник","Вторник","Среда","Четверг","Пятница","Суббота");
        raspComboLessonNum.getItems().addAll("1","2","3","4","5");
        raspComboKyrs.getItems().addAll("1","2","3","4","5","6");
        raspComboGroupNum.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
    }

    public void selectCombo() throws SQLException {
        departmentForCombo=facultyService.getAll();
        directionForCombo = directionService.getAll();
        kafedraForCombo = kafedraService.getAll();
        lectorDocNum = lecturerService.getLectorNum();

        ObservableList<String> combodepartment = FXCollections.observableList(departmentForCombo);
        ObservableList<String> combodirection = FXCollections.observableList(directionForCombo);
        ObservableList<String> combokafedra = FXCollections.observableList(kafedraForCombo);
        comboFacult.setItems(combodepartment);
        comboFacult1.setItems(combodepartment);
        comboDirection1.setItems(combodirection);
        comboKafedra.setItems(combokafedra);
        comboKafForDistcipline.setItems(combokafedra);

        comboDay.getItems().addAll("Понедельник","Вторник","Среда","Четверг","Пятница","Суббота");
        comboTime.getItems().addAll("8:30","10:00","11:40","13:00");

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            selectCombo();
            insertData();
        } catch (SQLException ignored) {}
        id.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getId()));
        teach.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getTeacher()));
        les.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getLesson()));
        korp.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getKorpus()));
        room.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getClassroom()));
        dayOf.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getDay()));
        numles.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getLessonNum()));
        from.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getStart()));
        to.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getEnd()));
        facult.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getFacult()));
        napravl.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getDirection()));
        kyrs.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getCourse()));
        grupa.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getGroup()));

        dataTable.setItems(data);

        comboKafForDistcipline.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
            try {
                int id = kafedraService.idForDelete(newValue);
                teacherForCombo= lecturerService.lectorFromKaf(id);
                ObservableList<String> comboteacher = FXCollections.observableList(teacherForCombo);
                comboLector.setItems(comboteacher);
            } catch (SQLException e) {} }
        );
        try {
            createCombo();
        } catch (SQLException e) {}
    }

    public  void  alert(int check){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Внимаие!");
        alert.setHeaderText(null);
        switch (check){
            case SUCCESSFULLY_ADDED:alert.setContentText("Запись добавлена");break;
            case FIELD_NOT_FOUND:alert.setContentText("Поле не существует");break;
            case FIELD_EXISTS:alert.setContentText("Данное поле существует");break;
            case SUCCESSFULLY_DELETE:alert.setContentText("Запись успешно удалена ");break;
        }
        alert.showAndWait();
    }
    public void addFacult(ActionEvent actionEvent) throws SQLException {
        Faculty faculty = new Faculty();
        String field = facultName.getText();
        faculty.setFacultyName(field);

        int id = facultyService.idForDelete(field);

        Button btn = (Button)actionEvent.getSource();
        String checkAction = btn.getText();

        if(checkAction.equals("+")) {
            if (departmentForCombo.contains(field)) {
                alert(FIELD_EXISTS);
            } else {
                facultyService.add(faculty);
                alert(SUCCESSFULLY_ADDED);
            }
        }
        if(checkAction.equals("-")) {
            if(id!=0) {
                faculty.setIdFaculty(id);
                facultyService.remove(faculty);
                alert(SUCCESSFULLY_DELETE);
            }else alert(FIELD_NOT_FOUND);
        }
        selectCombo();
    }

    public void addDirection(ActionEvent actionEvent) throws SQLException {
        Faculty faculty = new Faculty();
        Direction direction = new Direction();

        String facultField = comboFacult.getSelectionModel().getSelectedItem();
        int fcID = facultyService.idForDelete(facultField);
        faculty.setIdFaculty(fcID);
        faculty.setFacultyName(facultField);

        String field = directionName.getText();

        direction.setDirectionName(field);
        direction.setFaculty(faculty);

        Button btn = (Button)actionEvent.getSource();
        String checkAction = btn.getText();

        int id = directionService.idForDelete(field);

        if(checkAction.equals("+")) {
            if (directionForCombo.contains(field)) {
                alert(FIELD_EXISTS);
            } else {
                directionService.add(direction);
                alert(SUCCESSFULLY_ADDED);
            }
        }

        if(checkAction.equals("-")) {
            if(id!=0) {
                direction.setIdDirection(id);
                directionService.remove(direction);
                alert(SUCCESSFULLY_DELETE);
            }else alert(FIELD_NOT_FOUND);
        }
        selectCombo();
    }

    public void addKafedra(ActionEvent actionEvent) throws SQLException {
        Button btn = (Button)actionEvent.getSource();
        String checkAction = btn.getText();

        Faculty faculty = new Faculty();
        Kafedra kafedra = new Kafedra();

        String facultField = comboFacult1.getSelectionModel().getSelectedItem();

        int fcID = facultyService.idForDelete(facultField);
        faculty.setIdFaculty(fcID);
        faculty.setFacultyName(facultField);

        String field = kafedraName.getText();
        kafedra.setKafedraName(field);
        kafedra.setFaculty(faculty);

        if(checkAction.equals("+")) if (kafedraForCombo.contains(field)) {
            alert(FIELD_EXISTS);
        } else {
            kafedraService.add(kafedra);
            alert(SUCCESSFULLY_ADDED);
        }
            if(checkAction.equals("-")) {
                int id = kafedraService.idForDelete(field);
                if(id!=0) {
                    kafedra.setIdKafedra(id);
                    kafedraService.remove(kafedra);
                    alert(SUCCESSFULLY_DELETE);
                }else alert(FIELD_NOT_FOUND);
            }
        selectCombo();
    }

    public void addLector(ActionEvent actionEvent) throws SQLException {
        Button btn = (Button)actionEvent.getSource();
        String checkAction = btn.getText();

        Kafedra kafedra = new Kafedra();
        String kafName = comboKafedra.getSelectionModel().getSelectedItem();
        int kafID = kafedraService.idForDelete(kafName);
        kafedra.setIdKafedra(kafID);
        kafedra.setKafedraName(kafName);

        String field = lectorNum.getText();

        Lecturer lecturer = new Lecturer();
        lecturer.setIdLecture(Integer.parseInt(field));
        lecturer.setFio(lectorFio.getText());
        lecturer.setPosition(lectorPosition.getText());
        lecturer.setKafedra(kafedra);

        if(checkAction.equals("+")) {
            if (lectorDocNum.contains(field)) {
                alert(FIELD_EXISTS);
            } else {
                lecturerService.add(lecturer);
                alert(SUCCESSFULLY_ADDED);
            }
        }
        if(checkAction.equals("-")) {
            int id = lecturerService.idForDelete(Integer.parseInt(field));
            if(id!=0) {
                lecturer.setIdLecture(Integer.parseInt(field));
                lecturerService.remove(lecturer);
                alert(SUCCESSFULLY_DELETE);
            }else alert(FIELD_NOT_FOUND);
        }
        selectCombo();

    }
    public void addDistiplina(ActionEvent actionEvent) throws SQLException {
        Button btn = (Button)actionEvent.getSource();
        String checkAction = btn.getText();

        Lecturer lecturer = new Lecturer();
        int idKaf = kafedraService.idForDelete(comboKafForDistcipline.getSelectionModel().getSelectedItem());
        String lecName = comboLector.getSelectionModel().getSelectedItem();
        int lectID = lecturerService.idLectorForDiscipline(idKaf,lecName);
        lecturer.setIdLecture(lectID);

        Discipline discipline = new Discipline();
        String field = distsiplinaName.getText();
        discipline.setDisciplineName(field);
        discipline.setLecturer(lecturer);

        int idDis = disciplineService.idForDelete(field,lectID);

        if(checkAction.equals("+")) {
            if (idDis>0) {
                alert(FIELD_EXISTS);
            } else {
                disciplineService.add(discipline);
                alert(SUCCESSFULLY_ADDED);
            }
        }
        if(checkAction.equals("-")) {
            if(idDis>0) {
                discipline.setIdDiscipline(idDis);
                disciplineService.remove(discipline);
                alert(SUCCESSFULLY_DELETE);
            }else alert(FIELD_NOT_FOUND);
        }

        selectCombo();
    }
    public void addLesson(ActionEvent actionEvent) throws SQLException {
        Button btn = (Button)actionEvent.getSource();
        String checkAction = btn.getText();

        Lesson lesson = new Lesson();

        String num = lessNum.getText();

        lesson.setLessonNum(Long.parseLong(num));
        lesson.setLessonStart(comboTime.getSelectionModel().getSelectedItem());

        LocalDate localDate = dataPick.getValue();
        Date date = java.sql.Date.valueOf(localDate);
        lesson.setDate(date);
        lesson.setStart(Integer.parseInt(lessStart.getText()));
        lesson.setEnd(Integer.parseInt(lessEnd.getText()));
        lesson.setDayOfTheWeek(comboDay.getSelectionModel().getSelectedItem());

        int lesID = lessonService.idForDelete(Integer.parseInt(num),date);

        if(checkAction.equals("+")) {
            if (lesID>0) {
                alert(FIELD_EXISTS);
            } else {
                lessonService.add(lesson);
                alert(SUCCESSFULLY_ADDED);
            }
        }
        if(checkAction.equals("-")) {
            if(lesID>0) {
                lesson.setIdLesson(lesID);
                lessonService.remove(lesson);
                alert(SUCCESSFULLY_DELETE);
            }else alert(FIELD_NOT_FOUND);
        }

        selectCombo();
    }
    public void addClassroom(ActionEvent actionEvent) throws SQLException {

        String num = audNum.getText();
        String korp = audKorpus.getText();

        int id = classRoomService.idForDelete(Integer.parseInt(num),korp);


        ClassRoom classRoom = new ClassRoom();
        classRoom.setClassRoomNum(Integer.parseInt(num));
        classRoom.setKorpus(korp);
        classRoom.setPlaceCount(Integer.parseInt(audPlaceCount.getText()));

        Button btn = (Button)actionEvent.getSource();
        String checkAction = btn.getText();

        if(checkAction.equals("+")) {
            if (id!=0){
                alert(FIELD_EXISTS);
            }else {classRoomService.add(classRoom);alert(SUCCESSFULLY_ADDED);}
        }
        if(checkAction.equals("-")) {
            if(id!=0) {
                classRoom.setIdClassRoom(id);
                classRoomService.remove(classRoom);
                alert(SUCCESSFULLY_DELETE);
            }else alert(FIELD_NOT_FOUND);
        }
        selectCombo();
    }
    public void addGroup(ActionEvent actionEvent) throws SQLException {
        Button btn = (Button)actionEvent.getSource();
        String checkAction = btn.getText();

        Direction direction = new Direction();
        int dirID = directionService.idForDelete(comboDirection1.getSelectionModel().getSelectedItem());
        direction.setIdDirection(dirID);

        StudGroup studGroup = new StudGroup();
        long grNum = Long.parseLong(groupNum.getText());
        studGroup.setCourse(Long.parseLong(groupKyrs.getText()));
        studGroup.setGroupNum(grNum);
        studGroup.setStudCount(Long.parseLong(groupCount.getText()));
        studGroup.setDirection(direction);

        int stGrID = studGroupService.idForDelete(dirID,(int)grNum);
        if(checkAction.equals("+")) {
            if (stGrID>0) {
                alert(FIELD_EXISTS);
            } else {
                studGroupService.add(studGroup);
                alert(SUCCESSFULLY_ADDED);
            }
        }
        if(checkAction.equals("-")) {
            if(stGrID>0) {
                studGroup.setIdStudGroup(stGrID);
                studGroupService.remove(studGroup);
                alert(SUCCESSFULLY_DELETE);
            }else alert(FIELD_NOT_FOUND);
        }
        selectCombo();
    }



}
