package Tests;

import domain.Teacher;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @org.junit.jupiter.api.Test
    void getRank() {
        Teacher t=new Teacher(1,"bb","ba","prof");
        assert(t.getRank()=="prof");
    }

    @org.junit.jupiter.api.Test
    void setRank() {
        Teacher t=new Teacher(1,"bb","ba","prof");
        t.setRank("lect");
        assert(t.getRank()=="lect");
    }

    @org.junit.jupiter.api.Test
    void getName() {
        Teacher t=new Teacher(1,"bb","ba","prof");
        assert(t.getName()=="bb");
    }

    @org.junit.jupiter.api.Test
    void setName() {
        Teacher t=new Teacher(1,"bb","ba","prof");
        t.setName("aa");
        assert(t.getName()=="aa");
    }

    @org.junit.jupiter.api.Test
    void getEmail() {
        Teacher t=new Teacher(1,"bb","ba","prof");
        assert(t.getEmail()=="ba");
    }

    @org.junit.jupiter.api.Test
    void setEmail() {
        Teacher t=new Teacher(1,"bb","ba","prof");
        t.setEmail("ab");
        assert(t.getEmail()=="ab");
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Teacher t=new Teacher(1,"bb","ba","prof");
        assert(t.toString().equals("Teacher{" +
                "id=" + 1 +
                "name='" + "bb" + '\'' +
                ", email='" + "ba" + '\'' +
                ", rank='" + "prof" + '\'' +
                '}'));
    }

    @org.junit.jupiter.api.Test
    void fileToString() {
        Teacher t=new Teacher(1,"bb","ba","prof");
        assert(t.fileToString().equals(1+ "," + "bb" + "," + "ba" + "," +
                "prof" + "\n"));
    }
}