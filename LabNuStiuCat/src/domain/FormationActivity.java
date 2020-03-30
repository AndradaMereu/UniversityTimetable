package domain;

public class FormationActivity extends Entity {

        private int fid;
        private  int aid;

    public FormationActivity(int id, int f, int a) {
        super(id);
        this.fid = f;
        this.aid = a;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "FormationActivity{" +
                "fid=" + fid +
                ", aid=" + aid +
                '}';
    }

    @Override
    public String fileToString()
    {
        return this.getId() + "," + this.fid + "," + this.aid + "\n";
    }
}
