package Tests;

import domain.*;
import org.junit.jupiter.api.Test;
import repository.Repository;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void getRepot() {
    }

    @Test
    void getRepod() {
        Teacher t1= new Teacher(1,"dsda","fdfds","lect");
        Teacher t2 = new Teacher(2,"fhidfs","gthhh","prof");
        Discipline d1= new Discipline(1,"maff",4);
        Discipline d2 = new Discipline(2,"fuiuj",7);
        Room r1=new Room(321,"Avram Iancu");
        Room r2=new Room(62,"Mathematica");
        Timeslot timeslot1=new Timeslot(DayOfWeek.MONDAY, LocalTime.NOON);
        Timeslot timeslot2= new Timeslot(DayOfWeek.FRIDAY,LocalTime.of(16,00));
        Activity a1 = new Activity(1,d1,"Seminar");
        Activity a2 = new Activity(2,d1,"Lab");

        Repository<Teacher> repot= new Repository<Teacher>();
        Repository<Discipline> repod=new Repository<Discipline>();
        Repository<Activity> repoa= new Repository<Activity>();
        Repository<Room> repom = new Repository<Room>();
        Repository<Formation> repof = new Repository<Formation>();

        repot.add(t1);
        repot.add(t2);
        repod.add(d1);
        repod.add(d2);
        assert(repot.getAll().size()==2);
    }

    @Test
    void getRepoa() {
        Teacher t1= new Teacher(1,"dsda","fdfds","lect");
        Teacher t2 = new Teacher(2,"fhidfs","gthhh","prof");
        Discipline d1= new Discipline(1,"maff",4);
        Discipline d2 = new Discipline(2,"fuiuj",7);
        Room r1=new Room(321,"Avram Iancu");
        Room r2=new Room(62,"Mathematica");
        Timeslot timeslot1=new Timeslot(DayOfWeek.MONDAY, LocalTime.NOON);
        Timeslot timeslot2= new Timeslot(DayOfWeek.FRIDAY,LocalTime.of(16,00));
        Activity a1 = new Activity(1,d1,"Seminar");
        Activity a2 = new Activity(2,d1,"Lab");

        Repository<Teacher> repot= new Repository<Teacher>();
        Repository<Discipline> repod=new Repository<Discipline>();
        Repository<Activity> repoa= new Repository<Activity>();
        Repository<Room> repom = new Repository<Room>();
        Repository<Formation> repof = new Repository<Formation>();

        repot.add(t1);
        repot.add(t2);
        repod.add(d1);
        repod.add(d2);
        assert(repoa.getAll().size()==0);
        repoa.add(a1);
        assert(repoa.getAll().size()==1);
        repoa.add(a2);
        assert(repoa.getAll().size()==2);
    }

    @Test
    void getRepom() {
    }

    @Test
    void getRepof() {
    }

    @Test
    void getRepota() {
    }

    @Test
    void getRepofa() {
    }

    @Test
    void getReportas() {
    }

    @Test
    void getGroupsOfFormation() {
    }

    @Test
    void getSubgroupsOfGroup() {
    }

    @Test
    void addTeacher() {

        Teacher t1 = new Teacher(1, "dsda", "fdfds", "lect");
        Teacher t2 = new Teacher(2, "fhidfs", "gthhh", "prof");
        Discipline d1 = new Discipline(1, "maff", 4);
        Discipline d2 = new Discipline(2, "fuiuj", 7);
        Room r1 = new Room(321, "Avram Iancu");
        Room r2 = new Room(62, "Mathematica");
        Timeslot timeslot1 = new Timeslot(DayOfWeek.MONDAY, LocalTime.NOON);
        Timeslot timeslot2 = new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(16, 00));
        Activity a1 = new Activity(1, d1, "Seminar");
        Activity a2 = new Activity(2, d1, "Lab");

        Repository<Teacher> repot = new Repository<Teacher>();
        Repository<Discipline> repod = new Repository<Discipline>();
        Repository<Activity> repoa = new Repository<Activity>();
        Repository<Room> repom = new Repository<Room>();
        Repository<Formation> repof = new Repository<Formation>();

        repot.add(t1);
        repot.add(t2);
        repod.add(d1);
        repod.add(d2);
        assert (repoa.getAll().size() == 0);
        repoa.add(a1);
        assert (repoa.getAll().size() == 1);
        repoa.add(a2);
        assert (repoa.getAll().size() == 2);
    }

    @Test
    void addDiscipline() {
    }

    @Test
    void addActivity() {
    }

    @Test
    void addFormation() {
    }

    @Test
    void addGroup() {
    }

    @Test
    void addSemigroup() {
    }

    @Test
    void addRoom() {
    }

    @Test
    void existAssocTeacherActivity() {
    }

    @Test
    void getAllActivitiesForTeacher() {
    }

    @Test
    void getAllActivitiesForFormation() {
    }

    @Test
    void addAssocTeacherActivity() {
    }

    @Test
    void deleteAssocTeacherActivity() {
    }

    @Test
    void existAssocFormationActivity() {
    }

    @Test
    void addAssocFormationActivity() {
    }

    @Test
    void deleteAssocFormationActivity() {
    }

    @Test
    void deleteTeacher() {
    }

    @Test
    void deleteDiscipline() {
    }

    @Test
    void deleteActivity() {
    }

    @Test
    void deleteRoom() {
    }

    @Test
    void deleteFormation() {
    }

    @Test
    void deleteGroup() {
    }

    @Test
    void deleteSemiGroup() {
    }

    @Test
    void updateTeacher() {
    }

    @Test
    void updateActivity() {
    }

    @Test
    void updateDiscipline() {
    }

    @Test
    void updateRoom() {
    }

    @Test
    void updateFormation() {
    }

    @Test
    void updateGroup() {
    }

    @Test
    void updateSemigroup() {
    }

    @Test
    void filterActivityByDisciplineId() {
    }

    @Test
    void filterActivityByTeacherId() {
    }

    @Test
    void searchTeacherById() {
    }

    @Test
    void searchActivityById() {
    }

    @Test
    void existRTASAssoc() {
    }

    @Test
    void addRTMASAssoc() {
    }

    @Test
    void getTeachersWithRankAlphabet() {
    }

    @Test
    void getAllActivitiesByRoom() {
    }

    @Test
    void getTimetableForFormation() {
    }
}