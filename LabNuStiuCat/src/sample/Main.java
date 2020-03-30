package sample;

import domain.*;
import infrastructure.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repository.Repository;
import utils.Utils;

import java.io.IOException;
import java.time.LocalTime;

public class Main extends Application {

    private void initData(Controller service) throws Exception {
        service.addTeacher(1,"Iuliana Bocicor","i@csubb","professor");
        service.addTeacher(2,"Lorincz Beata","b@csubb","professor");
        service.addTeacher(3,"Gabi Mircea","g@csubb","lecturer");

        Discipline d1 = new Discipline(1,"MAP",5);
        Discipline d2 = new Discipline(2,"Complex Analysis",4);
        Discipline d3 = new Discipline(3,"OOP",6);
        service.addDiscipline(1,"MAP",5);
        service.addDiscipline(2,"Complex Analysis",4);
        service.addDiscipline(3,"OOP",6);

        service.addRoom(321,"Avram Iancu");
        service.addRoom(621,"Central");

        service.addActivity(1,d1,"lab");
        service.addActivity(2,d2,"seminar");
        service.addActivity(3,d2,"curs");

        Timeslot ts1 = new Timeslot(Utils.parseDayOfWeek("Monday"), LocalTime.NOON);
        Timeslot ts2 = new Timeslot(Utils.parseDayOfWeek("thu"),LocalTime.of(18,00));
        Timeslot ts3 = new Timeslot(Utils.parseDayOfWeek("wed"),LocalTime.of(13,00));
        Timeslot ts4 = new Timeslot(Utils.parseDayOfWeek("tue"),LocalTime.of(10,00));

        service.addFormation(821);
        service.addFormation(911);

        service.addRTMASAssoc(321,ts1,2,911,1);
        service.addRTMASAssoc(621,ts2,1,821,2);
        service.addRTMASAssoc(621,ts3,3,911,3);
        service.addRTMASAssoc(321,ts4,1,821,1);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Repository<Teacher> repot=new Repository<>();
        Repository<Activity> repoa=new Repository<>();
        Repository<Discipline> repod=new Repository<>();
        Repository<Room> repom=new Repository<>();
        Repository<TeacherActivity> repota=new Repository<>();
        Repository<FormationActivity> repofa=new Repository<>();
        Repository<Formation> repof=new Repository<>();
        Repository<RTAS> reportas=new Repository<>();
        String s=" ";
        Controller service = new Controller(repot,repod,repoa,repom,repof,s,repota,repofa,reportas);
        initData(service);



        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        TeacherController teacherController = new TeacherController((service));
        loader.setController(teacherController);
        Parent root = loader.load();
        primaryStage.setTitle("Lab");
        primaryStage.setScene(new Scene(root, 450, 350));
        primaryStage.show();

        teacherController.initiailze();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
