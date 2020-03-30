//package main;
//
//import domain.*;
//import infrastructure.Controller;
//import repository.*;
//import ui.Ui;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.text.Normalizer;
//import java.time.DayOfWeek;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Properties;
//
//public class main {
//
//    public static void main(String[] args) throws Exception {
//        Teacher t1 = new Teacher(1, "dsda", "fdfds","lecturer");
//        Teacher t2 = new Teacher(2, "fhidfs", "gthhh","professor");
//        Teacher t3 = new Teacher(3, "faaahidfs", "ghhh","professor");
//        Teacher t4 = new Teacher(10, "fhidfs", "gthhh","professor");
//        Discipline d1 = new Discipline(1, "maff", 4);
//        Discipline d2 = new Discipline(2, "fuiuj", 7);
//        Timeslot timeslot1 = new Timeslot(DayOfWeek.MONDAY, LocalTime.of(12,00));
//        Timeslot timeslot2 = new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(16,00));
//        Room r1 = new Room(321, "Avram Iancu");
//        Room r2 = new Room(62, "Mathematica");
//        Activity a1 = new Activity(1, d1, "Seminar");
//        Activity a2 = new Activity(2, d1, "Lab");
//        Formation f1=new Formation(1,new ArrayList<Group>());
//        Formation f2 = new Formation(2,new ArrayList<Group>());
//        Group g1= new Group(1,new ArrayList<Subgroup>());
//        Group g2 = new Group(2,new ArrayList<Subgroup>());
//        Subgroup sg1=new Subgroup(1);
//
//
//        Repository<Teacher> repot = new Repository<Teacher>();
//        TeacherFileRepository<Teacher> frepot = new TeacherFileRepository<>();
//        TeacherBinaryRepository<Teacher> brepot = new TeacherBinaryRepository<>();
//        Repository<Discipline> repod = new Repository<Discipline>();
//        DisciplineFileRepository<Discipline> frepod = new DisciplineFileRepository<>();
//        Repository<Activity> repoa = new Repository<Activity>();
//        ActivityFileRepository<Activity> frepoa = new ActivityFileRepository<>();
//        ActivityBinaryRepository<Activity> brepoa = new ActivityBinaryRepository<>();
//        Repository<Room> repom = new Repository<Room>();
//        RoomFileRepository<Room> frepom = new RoomFileRepository<>();
//        Repository<Formation> repof = new Repository<Formation>();
//        Repository<FormationActivity> repofa = new Repository<>();
//        FormationActivityFileRepository<FormationActivity> frepofa=new FormationActivityFileRepository<>();
//        Repository<TeacherActivity> repota = new Repository<>();
//        TeacherActivityFileRepository<TeacherActivity> frepota = new TeacherActivityFileRepository<>();
//        TeacherActivityBinaryRepository<TeacherActivity> brepota = new TeacherActivityBinaryRepository<>();
//        Repository<RTAS> reportas= new Repository<>();
//
//        repot.add(t1);
//        repot.add(t2);
//        repod.add(d1);
//        repod.add(d2);
//        repoa.add(a1);
//        repoa.add(a2);
//        repom.add(r1);
//        repom.add(r2);
//        repof.add(f1);
//        repof.add(f2);
//        repof.searchById(1).getGroups().add(g1);
//        repof.searchById(2).getGroups().add(g2);
//        repof.searchById(1).getGroups().get(0).getSubgroups().add(sg1);
//        frepom.add(r1);
//        frepom.add(r2);
//        FormationActivity fa=new FormationActivity(12,1,2);
//        frepofa.add(fa);
//
//
//
//
//        ////////////////////////////
//
//
//        TeacherDatabaseRepository<Teacher> db_example = new TeacherDatabaseRepository<Teacher>();
//        //Class.forName("src.sqlite.jdbc.Driver");
//        db_example.openConnection();
//        db_example.createSchema();
//        db_example.initTables();
//
//        Teacher t = new Teacher(5,"Bocicor Iuliana", "bi@csubb","professor");
//        db_example.addTeacher(t);
//
//        Discipline dd = new Discipline(6,"cfdcsd",55);
//        db_example.addDiscipline(dd);
//
//        db_example.deleteTeacher(1);
//
//
//        ArrayList<Teacher> teachers = db_example.getTeachers();
//        for (Teacher tc: teachers)
//            System.out.println(tc);
//
//        ArrayList<Discipline> disciplines = db_example.getAllDisciplines();
//        for (Discipline tc: disciplines)
//            System.out.println(tc);
//
//        db_example.closeConnection();
//
//
//        ////////////////////////////
//
//
//
//
//
//        Properties prop = new Properties();
//        InputStream inputStream = new FileInputStream("src/nume.settings.properties")
//        {
//            @Override
//            public int read()
//            {
//                return 0;
//            }
//        };
//        prop.load(inputStream);
//        prop.getProperty("Repository");
//        System.out.println(prop.getProperty("Repository"));
//        String type = prop.getProperty("Repository");
//
//        if(type.equals("Text"))
//        {
//            String s=".txt";
//            frepot.readFile("src/Teacher.txt");
//            frepoa.readFile("src/Activity.txt");
//            frepota.readFile("src/TeacherActivity.txt");
//            frepod.readFile("src/Discipline.txt");
//            frepom.readFile("src/Room.txt");
//            frepofa.readFile("src/FormationActivity.txt");
//            Controller ctrl = new Controller(frepot, frepod, frepoa, frepom, repof,s,frepota,frepofa,reportas);
//            ctrl.addFormation(12);
//            ctrl.addFormation(20);
//            ctrl.addRTMASAssoc(321,timeslot1,1,12);
//            ctrl.addRTMASAssoc(321,timeslot2,2,20);
//            ctrl.addRTMASAssoc(52,timeslot2,2,20);
//            Ui ui = new Ui(ctrl);
//            ui.run();
//        }
//        else if(type.equals("Binary"))
//        {
//            String s=".bin";
//            Teacher tc=new Teacher(1,"Bocicor","bocicor@csubb","professor");
//            brepot.add(t);
//            Discipline d = new Discipline(1,"map",5);
//            Activity a = new Activity(1,d,"seminar");
//            brepoa.add(a1);
//            brepoa.add(a2);
//            TeacherActivity ta= new TeacherActivity(11,1,1);
//            brepota.add(ta);
//            brepot.readFile("src/Teacher.bin");
//            brepoa.readFile("src/Activity.bin");
//            brepota.readFile("src/TeacherActivity.bin");
//            Controller ctrl = new Controller(brepot, repod, brepoa, repom, repof,s,brepota,repofa,reportas);
//            ctrl.addFormation(12);
//            ctrl.addFormation(20);
//            ctrl.addRTMASAssoc(621,timeslot1,1,12);
//            ctrl.addRTMASAssoc(52,timeslot2,2,20);
//            Ui ui = new Ui(ctrl);
//            ui.run();
//        }
//        /*else {String s ="";
//            Controller ctrl = new Controller(repot, repod, frepoa, repom, repof,s);Ui ui = new Ui(ctrl);
//            ui.run();}*/
//
//
//
//    }
//}
