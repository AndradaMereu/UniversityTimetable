package domain;

public class ClassforTimetable {

    private String teachername;
    private String actname;
    private String disciplinename;
    private String formationid;
    private String roomid;
    private String timeslot;
    private String teacherid;
    private String disciplineid;

    public ClassforTimetable(String teachername, String actname, String disciplinename, String formationid, String roomid, String timeslot, String teacherid, String disciplineid) {
        this.teachername = teachername;
        this.actname = actname;
        this.disciplinename = disciplinename;
        this.formationid = formationid;
        this.roomid = roomid;
        this.timeslot = timeslot;
        this.teacherid = teacherid;
        this.disciplineid = disciplineid;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getActname() {
        return actname;
    }

    public void setActname(String actname) {
        this.actname = actname;
    }

    public String getDisciplinename() {
        return disciplinename;
    }

    public void setDisciplinename(String disciplinename) {
        this.disciplinename = disciplinename;
    }

    public String getFormationid() {
        return formationid;
    }

    public void setFormationid(String formationid) {
        this.formationid = formationid;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getDisciplineid() {
        return disciplineid;
    }

    public void setDisciplineid(String disciplineid) {
        this.disciplineid = disciplineid;
    }
}
