package domain;

public class TeacherDiscipline {

    private int tid;
    private int did;

    public TeacherDiscipline(int tid, int did) {
        this.tid = tid;
        this.did = did;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
}
