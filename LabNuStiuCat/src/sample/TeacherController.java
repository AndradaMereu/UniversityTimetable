package sample;

import domain.*;
import infrastructure.Controller;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import utils.Utils;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherController {

        private Controller service;

    public TeacherController(Controller service) {
        this.service = service;
    }

    @FXML
    private Tab teachertab;

    @FXML
    private TableColumn<Teacher, String> colid;

    @FXML
    private TableColumn<Teacher, String> colname;

    @FXML
    private TableColumn<Teacher, String> colemail;

    @FXML
    private Tab disciplinetab;

    @FXML
    private TextField textfieldId;

    @FXML
    private TextField textfieldName;

    @FXML
    private TextField textfieldEmail;

    @FXML
    private TextField textfieldRank;

    @FXML
    private TableView teachersTable;

    @FXML
    private TableView disciplinetable;

    @FXML
    private Button addbutton;

    @FXML
    private Button deletebutton;

    @FXML
    private TableColumn<Teacher, String> colrank;


    @FXML
    private TableColumn<Activity, String> activityidcol;

    @FXML
    private TableColumn<Discipline, String> disciplineidcol;

    @FXML
    private TableColumn<Discipline, String> disciplinenamecol;

    @FXML
    private TableColumn<Discipline, String> nrcreditscol;

    @FXML
    private TableColumn<Activity, String> activitytypecol;

    @FXML
    private TextField textfieldDiscipline;

    @FXML
    private TextField textFieldDisciplineName;

    @FXML
    private TextField textfieldActivityType;

    @FXML
    private TextField textfieldNrOfCredits;

    @FXML
    private Button addButton1;

    @FXML
    private Button deleteButton1;

    @FXML
    private Tab teacherdisciplinetab;

    @FXML
    private TableColumn<Teacher, String> tcol;

    @FXML
    private TableColumn<Discipline, String> ccol;

    @FXML
    private Button assocbutton;

    @FXML
    private TableView teacherdisciplinetable;

    @FXML
    private Tab timetabletab;

    @FXML
    private TextField textfieldActivityName;

    @FXML
    private TextField textfieldRoomId;

    @FXML
    private TextField textfieldFormationId;

    @FXML
    private TextField textfieldTime;

    @FXML
    private TextField textfieldDay;

    @FXML
    private TextField textfieldId1;

    @FXML
    private TextField textfieldDiscipline1;

    @FXML
    private TableView timetabletable;

    @FXML
    private TableColumn<String, String> formationcol;

    @FXML
    private TableColumn<String, String> daycol;

    @FXML
    private TableColumn<String, String> timecol;

    @FXML
    private TableColumn<Discipline, String> disciplinecol;

    @FXML
    private TableColumn<String, String> actnamecol;

    @FXML
    private TableColumn<String, String> roomcol;

    @FXML
    private TableColumn<String,String> teachercol;

    @FXML
    private TableColumn<String, String> disciplineidttcol;
    @FXML
    private TableColumn<String, String> teacheridttcol;


    @FXML
    private TextField textfieldTeacherId;

    @FXML
    private TextField textfieldDisciplineId;

    @FXML
    private Label errorlabeladdteacher;

    @FXML
    private Label errorlabeldeleteteacher;

    @FXML
    private  Label errorlabeltimetable;

    @FXML
    private Button showtimetableform;

    @FXML
    private Button showtimetableteacher;

    @FXML
    private Label errorlabeldiscipline;



    ArrayList<TeacherDiscipline> td = new ArrayList<>();


    @FXML
    public void initiailze() throws Exception {
       errorlabeladdteacher.setVisible(false);
       errorlabeldeleteteacher.setVisible(false);
       errorlabeldiscipline.setVisible(false);
       errorlabeltimetable.setVisible(false);

        this.teachersTable.getItems().clear();
        this.disciplinetable.getItems().clear();
        this.teacherdisciplinetable.getItems().clear();
        this.timetabletable.getItems().clear();

        ArrayList<Teacher> teachers = (ArrayList<Teacher>) this.service.getRepot();
        ObservableList<Teacher> obsTeachers = FXCollections.observableArrayList(teachers);



        ObservableList<TeacherDiscipline> obsTds = FXCollections.observableArrayList(td);


        ArrayList<Discipline> disciplines = this.service.getRepod();
        ObservableList<Discipline> obsDisciplines = FXCollections.observableArrayList(disciplines);

//        List<Entity> timetables = this.service.getReportas().stream().sorted(Comparator.comparingInt(RTAS::getSubgroupid)
//        .thenComparing((x1,x2)->x1.getTimeslot().getDay().compareTo(x2.getTimeslot().getDay()))
//            .thenComparing((x1,x2)->x1.getTimeslot().getTime().compareTo(x2.getTimeslot().getTime()))).collect(Collectors.toList());
//
//        ObservableList<Entity> obsTimetables = FXCollections.observableArrayList(timetables);



        colid.setCellValueFactory(new PropertyValueFactory<Teacher, String>("Id"));
        colname.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
        colemail.setCellValueFactory(new PropertyValueFactory<Teacher,String>("email"));
        colrank.setCellValueFactory(new PropertyValueFactory<Teacher,String>("rank"));

        disciplineidcol.setCellValueFactory(new PropertyValueFactory<Discipline,String>("id"));
        disciplinenamecol.setCellValueFactory(new PropertyValueFactory<Discipline,String>("name"));
        nrcreditscol.setCellValueFactory(new PropertyValueFactory<Discipline,String>("nrOfCredits"));

        tcol.setCellValueFactory(new PropertyValueFactory<Teacher,String>("tid"));
        ccol.setCellValueFactory(new PropertyValueFactory<Discipline,String>("did"));


//        formationcol.setCellValueFactory(new PropertyValueFactory<>("subgroupid"));
//        daycol.setCellValueFactory(new PropertyValueFactory<>("timeslot"));
//        actnamecol.setCellValueFactory(new PropertyValueFactory<>("activityid"));
//        roomcol.setCellValueFactory(new PropertyValueFactory<>("roomid"));
//        teachercol.setCellValueFactory(new PropertyValueFactory<>("teacherid"));



        ArrayList<ClassforTimetable> timet= new ArrayList<>();
        for(RTAS tt:this.service.getReportas().stream().sorted(Comparator.comparingInt(RTAS::getSubgroupid)
                .thenComparing((x1,x2)->x1.getTimeslot().getDay().compareTo(x2.getTimeslot().getDay()))
                .thenComparing((x1,x2)->x1.getTimeslot().getTime().compareTo(x2.getTimeslot().getTime()))).collect(Collectors.toList())
)
        {
            String teachname = service.searchTeacherById2(tt.getTeacherid()).getName();
            Activity a = service.searchActivityById(tt.getActivityid());
            String actname = a.getActivityName();
            String d = a.getDiscipline().getName();
            String formationid = String.valueOf(tt.getSubgroupid());
            String roomid = String.valueOf(tt.getRoomid());
            String timeslot = tt.getTimeslot().toString();
            String teachid = String.valueOf(service.searchTeacherById2(tt.getTeacherid()).getId());
            String disciplineid =String.valueOf(a.getDiscipline().getId());

            ClassforTimetable cft = new ClassforTimetable(teachname,actname,d,formationid,roomid,timeslot,teachid,disciplineid);
            timet.add(cft);

        }
        ObservableList<ClassforTimetable> ocft = FXCollections.observableArrayList(timet);

        formationcol.setCellValueFactory(new PropertyValueFactory<>("formationid"));
        daycol.setCellValueFactory(new PropertyValueFactory<>("timeslot"));
        actnamecol.setCellValueFactory(new PropertyValueFactory<>("actname"));
        roomcol.setCellValueFactory(new PropertyValueFactory<>("roomid"));
        teachercol.setCellValueFactory(new PropertyValueFactory<>("teachername"));
        disciplinecol.setCellValueFactory(new PropertyValueFactory<>("disciplinename"));
        disciplineidttcol.setCellValueFactory(new PropertyValueFactory<>("disciplineid"));
        teacheridttcol.setCellValueFactory(new PropertyValueFactory<>("teacherid"));



        this.teachersTable.setItems(obsTeachers);
        this.disciplinetable.setItems(obsDisciplines);
        this.teacherdisciplinetable.setItems(obsTds);
        this.timetabletable.setItems(ocft);
    }

    @FXML
    void addbuttonhandler(ActionEvent event) throws Exception {
        int id=Integer.parseInt(textfieldId.getText());
        String name= textfieldName.getText();
        String email = textfieldEmail.getText();
        String rank = textfieldRank.getText();
        Teacher t = new Teacher(id,name,email,rank);
        try {
            this.service.addTeacher(id, name, email, rank);
            this.initiailze();
        }
        catch (Exception e)
        {   errorlabeldeleteteacher.setVisible(false);
            errorlabeladdteacher.setVisible(true);
            System.out.println(e);
        }
    }

    @FXML
    void deletebuttonhandler(ActionEvent event) {

        int id=Integer.parseInt(textfieldId.getText());
        try{
            this.service.deleteTeacher(id);
            this.initiailze();

        } catch (Exception e) {
           // e.printStackTrace();
            errorlabeladdteacher.setVisible(false);
            errorlabeldeleteteacher.setVisible(true);
        }
    }

    @FXML
    void addButton1Handler(ActionEvent event) {
            int id = Integer.parseInt(textfieldDiscipline.getText());
            String name = textFieldDisciplineName.getText();
            int nrOfCredits = Integer.parseInt(textfieldNrOfCredits.getText());
            try{
                this.service.addDiscipline(id,name,nrOfCredits);
                this.initiailze();

            } catch (Exception e) {
                errorlabeldiscipline.setText(e.getMessage());
                errorlabeldiscipline.setVisible(true);
               // e.printStackTrace();
            }

    }


    @FXML
    void deleteButton1Handler(ActionEvent event) {
        int id=Integer.parseInt(textfieldDiscipline.getText());
        try
        {
            this.service.deleteDiscipline(id);
            this.initiailze();
        } catch (Exception e) {
            errorlabeldiscipline.setVisible(true);
            errorlabeldiscipline.setText(e.getMessage());
           // e.printStackTrace();
        }


    }

    @FXML
    void assocButton(ActionEvent event) throws Exception {
        int tid=Integer.parseInt(textfieldId1.getText());
        int did = Integer.parseInt(textfieldDiscipline1.getText());
        TeacherDiscipline td1=new TeacherDiscipline(tid,did);

        td.add(td1);
        teacherdisciplinetable.getItems().clear();
        this.initiailze();

    }


    @FXML
    void timetableButton(ActionEvent event) throws Exception {
        int tid = Integer.parseInt(textfieldTeacherId.getText());
        int did = Integer.parseInt(textfieldDisciplineId.getText());
        String activityname = textfieldActivityName.getText();
        int roomid = Integer.parseInt(textfieldRoomId.getText());
        int fid  = Integer.parseInt(textfieldFormationId.getText());
        String timetext = textfieldTime.getText();
        String[] time=timetext.split(":");
        LocalTime localtime=LocalTime.of(Integer.parseInt(time[0]),Integer.parseInt(time[1]));
        String day = textfieldDay.getText();
        Timeslot ts = new Timeslot(Utils.parseDayOfWeek(day),localtime);
        Discipline d = this.service.searchDisciplineById(did);
        int aid = this.service.searchActivityId(did,activityname);
        if (aid==-1)
        {
            service.addActivity(Utils.combineInts(activityname.length(),did),d,activityname);
            aid = Utils.combineInts(activityname.length(),did);
        }

        try {
            //this.service.existRTASAssoc(roomid, ts, aid, fid, tid);
            this.service.addRTMASAssoc(roomid, ts, aid, fid, tid);

            timetabletable.getItems().clear();
            this.initiailze();
        }
        catch (Exception e)
        {
            errorlabeltimetable.setVisible(true);
            errorlabeltimetable.setText(e.getMessage());
        }
    }

    @FXML
    void timetableButtonform(ActionEvent event) {
        ArrayList<ClassforTimetable> timet= new ArrayList<>();
        int fid = Integer.parseInt(textfieldFormationId.getText());
        for(RTAS tt:this.service.getTimetableForFormation(fid).stream().sorted(Comparator.comparingInt(RTAS::getSubgroupid)
                .thenComparing((x1,x2)->x1.getTimeslot().getDay().compareTo(x2.getTimeslot().getDay()))
                .thenComparing((x1,x2)->x1.getTimeslot().getTime().compareTo(x2.getTimeslot().getTime()))).collect(Collectors.toList())
        ) {
            String teachname = service.searchTeacherById2(tt.getTeacherid()).getName();
            Activity a = service.searchActivityById(tt.getActivityid());
            String actname = a.getActivityName();
            String d = a.getDiscipline().getName();
            String formationid = String.valueOf(tt.getSubgroupid());
            String roomid = String.valueOf(tt.getRoomid());
            String timeslot = tt.getTimeslot().toString();
            String teachid = String.valueOf(service.searchTeacherById2(tt.getTeacherid()).getId());
            String disciplineid =String.valueOf(a.getDiscipline().getId());

            ClassforTimetable cft = new ClassforTimetable(teachname, actname, d, formationid, roomid, timeslot,teachid,disciplineid);
            timet.add(cft);
        }
        ObservableList<ClassforTimetable> obsTimetableForm = FXCollections.observableArrayList(timet);
        timetabletable.setItems(obsTimetableForm);

    }

    @FXML
    void timetableButtonteacher(ActionEvent event) throws Exception {
        int tid = Integer.parseInt(textfieldTeacherId.getText());
        try{
            ArrayList<ClassforTimetable> timet= new ArrayList<>();
            for(RTAS tt:this.service.getTimetableForTeacher(tid).stream().sorted(Comparator.comparingInt(RTAS::getSubgroupid)
                    .thenComparing((x1,x2)->x1.getTimeslot().getDay().compareTo(x2.getTimeslot().getDay()))
                    .thenComparing((x1,x2)->x1.getTimeslot().getTime().compareTo(x2.getTimeslot().getTime()))).collect(Collectors.toList())
            ) {
                String teachname = service.searchTeacherById2(tt.getTeacherid()).getName();
                Activity a = service.searchActivityById(tt.getActivityid());
                String actname = a.getActivityName();
                String d = a.getDiscipline().getName();
                String formationid = String.valueOf(tt.getSubgroupid());
                String roomid = String.valueOf(tt.getRoomid());
                String timeslot = tt.getTimeslot().toString();
                String teachid = String.valueOf(service.searchTeacherById2(tt.getTeacherid()).getId());
                String disciplineid =String.valueOf(a.getDiscipline().getId());

                ClassforTimetable cft = new ClassforTimetable(teachname, actname, d, formationid, roomid, timeslot,teachid,disciplineid);
                timet.add(cft);
            }
            ObservableList<ClassforTimetable> obsTimetableForm = FXCollections.observableArrayList(timet);
            timetabletable.setItems(obsTimetableForm);}
        catch (Exception e)
        {
            errorlabeltimetable.setVisible(true);
            errorlabeltimetable.setText(e.getMessage());
        }

    }




}
