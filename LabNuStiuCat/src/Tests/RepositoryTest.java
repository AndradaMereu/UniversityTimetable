package Tests;

import domain.*;
import org.junit.jupiter.api.Test;
import repository.Repository;

import java.time.DayOfWeek;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    @Test
    void add() {
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
        assert(repot.getAll().size()==2);
    }

    @Test
    void delete() {

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
    }

    @Test
    void update() {
    }

    @Test
    void getAll() {
    }

    @Test
    void size() {
    }

    @Test
    void getIndex() {
    }

    @Test
    void searchById() {
    }

    @Test
    void readFile() {
    }
}