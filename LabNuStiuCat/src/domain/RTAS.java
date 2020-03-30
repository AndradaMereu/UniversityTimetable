package domain;

public class RTAS extends Entity {

    private int roomid;
    private Timeslot timeslot;
    private int activityid;
    private int subgroupid;
    private int teacherid;

    public RTAS(int id, int roomid, Timeslot timeslot, int activityid, int subgroupid,int teacherid) {
        super(id);
        this.roomid = roomid;
        this.timeslot = timeslot;
        this.activityid = activityid;
        this.subgroupid = subgroupid;
        this.teacherid = teacherid;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public int getActivityid() {
        return activityid;
    }

    public void setActivityid(int activityid) {
        this.activityid = activityid;
    }

    public int getSubgroupid() {
        return subgroupid;
    }

    public void setSubgroupid(int subgroupid) {
        this.subgroupid = subgroupid;
    }



    @Override
    public String toString() {
        return "RTAS{" +
                "roomid=" + roomid +
                ", timeslot=" + timeslot +
                ", activityid=" + activityid +
                ", subgroupid=" + subgroupid +
                ", teacherid=" + teacherid +
                '}';
    }
}
