package infrastructure;

import domain.*;
import repository.Repository;
import repository.TeacherBinaryRepository;
import repository.TeacherFileRepository;
import utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    private Repository<Teacher> repot;
    private Repository<Discipline> repod;
    private Repository<Activity> repoa;
    private Repository<Room> repom;
    private Repository<Formation> repof;
    private Repository<TeacherActivity> repota;
    private Repository<FormationActivity> repofa;
    private Repository<RTAS> reportas;
    private String s;

    private TeacherFileRepository<Teacher> frepot;
    private TeacherBinaryRepository<Teacher> brepot;

    public Controller(Repository<Teacher> repot, Repository<Discipline> repod, Repository<Activity> repoa, Repository<Room> repom, Repository<Formation> repof,String s,
                      Repository<TeacherActivity> repota, Repository<FormationActivity> repofa,Repository<RTAS> reportas) {
        this.repot = repot;
        this.repod = repod;
        this.repoa = repoa;
        this.repom = repom;
        this.repof = repof;
        this.repota = repota;
        this.repofa = repofa;
        this.s = s;
        this.reportas=reportas;
    }

    public ArrayList<Teacher> getRepot() {
        return repot.getAll();
    }

    public ArrayList<Discipline> getRepod() {
        return repod.getAll();
    }

    public ArrayList<Activity> getRepoa() {
        return repoa.getAll();
    }

    public ArrayList<Room> getRepom() {
        return repom.getAll();
    }

    public ArrayList<Formation> getRepof() {
        return repof.getAll();
    }

    public ArrayList<TeacherActivity> getRepota() { return repota.getAll(); }

    public ArrayList<FormationActivity> getRepofa() { return repofa.getAll(); }

    public ArrayList<RTAS> getReportas() {return reportas.getAll();}

    public ArrayList<Group> getGroupsOfFormation(int fid) throws Exception {
        if(this.repof.searchById(fid)!=null)
            return this.repof.searchById(fid).getGroups();
        else throw new Exception("Formation not found");
    }

    public ArrayList<Subgroup> getSubgroupsOfGroup(int fid,int gid) throws Exception {
        ArrayList<Subgroup> subgroups=new ArrayList<>();
        int i = this.repof.getIndex(fid);
        int indexgroup=-1;
        if (i != -1) {
            for (int j = 0; j < this.repof.getAll().get(i).getGroups().size(); j++)
            {
                if (this.repof.getAll().get(i).getGroups().get(j).getId() == gid)
                {
                    indexgroup=j;
                    for (int k = 0; k < this.repof.getAll().get(i).getGroups().get(j).getSubgroups().size(); k++)
                    {
                        subgroups.add(this.repof.getAll().get(i).getGroups().get(j).getSubgroups().get(k));
                    }
                }
            }
            if(indexgroup==-1) throw new Exception("Group not found");
        }
        else throw new Exception("Formation not found");
        return subgroups;
    }


    public int addTeacher(int id, String name, String email, String rank) throws Exception
    {
        Teacher t=new Teacher(id,name,email,rank);
        int i=this.repot.getIndex(id);
        if(i==-1) {this.repot.add(t);
        String str="src/Teacher"+this.s;
        this.repot.writeFile(str);
        System.out.println(str);
        return 1;}
        else throw new Exception("Teacher is already in the repository.");

    }

    public int addDiscipline(int id, String name, int nrOfCredits) throws Exception {
        Discipline d= new Discipline(id,name,nrOfCredits);
        int i=this.repod.getIndex(id);
        if(i==-1) {
                this.repod.add(d);
                String str="src/Discipline"+this.s;
                this.repod.writeFile(str);
                return 1;
        }
        else throw new Exception("Discipline is already in the repository.");

    }

    public int addActivity(int id,Discipline d, String activityType) throws Exception {
        int i=this.repoa.getIndex(id);
        Activity a = new Activity(id,d,activityType);
        if(i==-1) {this.repoa.add(a);
            String str="src/Activity"+this.s;
            this.repoa.writeFile(str);
            return 1;}
        else throw new Exception("Activity is already in the repository.");
    }

    public int addFormation(int id) throws Exception {
        int i = this.repof.getIndex(id);
        Formation f = new Formation(id, new ArrayList<>());
        if (i == -1) {
            this.repof.add(f);
            return 1;
        }
        else throw new Exception("Formation is already in the repository.");
    }

    public int addGroup(int fid, int gid) throws Exception
    {
        int i = this.repof.getIndex(fid);
        if(i==-1) throw new Exception("Formation not found");
        else
        {
        ArrayList<Group> groups=this.repof.getAll().get(i).getGroups();
        int index=-1;
        for(int j=0;j<groups.size();j++)
        {
            if (groups.get(j).getId()==gid) index=j;
        }
        if(index!=-1) throw new Exception("Group already exist");
        else
            {
            Group g = new Group(gid,new ArrayList<>());
            this.repof.getAll().get(i).getGroups().add(g);
            return 1;
            }
        }
    }


    public int addSemigroup(int fid,int gid, int sid) throws Exception
    {
        int i=this.repof.getIndex(fid);
        int indexgroup=-1; int indexsmg=-1;
        if(i!=-1) {
            for (int j = 0; j < this.repof.getAll().get(i).getGroups().size(); j++)
            {
                if(this.repof.getAll().get(i).getGroups().get(j).getId()==gid)
                {
                    indexgroup=j;
                    for (int k = 0; k < this.repof.getAll().get(i).getGroups().get(j).getSubgroups().size(); k++) {
                        if (this.repof.getAll().get(i).getGroups().get(j).getSubgroups().get(k).getId() == sid)
                            indexsmg = k;
                    }
                }
            }
            if(indexgroup==-1) throw new Exception("Group not found");
        }
        else throw new Exception("Formation not found");
        if(indexsmg==-1) {Subgroup smg= new Subgroup(sid);
            this.repof.getAll().get(i).getGroups().get(indexgroup).getSubgroups().add(new Subgroup(sid));
            return 1;}
        else throw new Exception("Subgroup already exists");
    }

    public int addRoom(int nr, String building) throws Exception {
        Room r = new Room(nr,building);
        int j= this.repom.getIndex(nr);
        if(j==-1) { this.repom.add(r); this.repom.writeFile("src/Room"+this.s); return 1;}
        else throw new Exception("Room already exists");
    }

    public int existAssocTeacherActivity(int tid,int aid)
    {
        int id=-1;
        /*Teacher t=this.repot.searchById(tid);
        Activity a =this.repoa.searchById(aid);
        int taid=Utils.combineInts(tid,aid);*/
        for(int i=0;i<this.repota.getAll().size();i++)
        {
            if(this.repota.getAll().get(i).getTid()==tid &&
                this.repota.getAll().get(i).getAid()==aid) id=i;

        }
        return id;
    }

    public ArrayList<Activity> getAllActivitiesForTeacher(int tid)
    {
        Teacher t=this.repot.searchById(tid);
        ArrayList<Activity> arra=new ArrayList<>();
        for(int i=0;i<this.getRepota().size();i++)
        {
            if(this.getRepota().get(i).getTid()==tid)
            {
               arra.add(this.repoa.searchById(this.getRepota().get(i).getAid()));
            }
        }
        return arra;
    }

    public ArrayList<Activity> getAllActivitiesForFormation(int fid)
    {
        Teacher t=this.repot.searchById(fid);
        ArrayList<Activity> arra=new ArrayList<>();
        for(int i=0;i<this.getRepofa().size();i++)
        {
            if(this.getRepofa().get(i).getFid()==fid)
            {
                arra.add(this.repoa.searchById(this.getRepofa().get(i).getAid()));
            }
        }
        return arra;
    }

    public int addAssocTeacherActivity(int tid, int aid) throws Exception {
        if(this.existAssocTeacherActivity(tid,aid)==-1) {
            if (this.repot.getIndex(tid) != -1 && this.repoa.getIndex(aid) != -1) {
                TeacherActivity ta = new TeacherActivity(Utils.combineInts(tid, aid), tid, aid);
                this.repota.add(ta);
                String str = "src/TeacherActivity" + this.s;
                this.repota.writeFile(str);
                return 1;
            }
            else throw new Exception("Either teacher or activity could not be found");

        }
        else throw new Exception("Association already exists");

    }


    public int deleteAssocTeacherActivity(int tid,int aid) throws Exception {
        int id = this.existAssocTeacherActivity(tid,aid);
        if(id!=-1) {this.repota.delete(id);
            String str="src/TeacherActivity"+this.s;
            this.repota.writeFile(str);
            return 1;}
        else throw new Exception("Association is not found");
    }

    public int existAssocFormationActivity(int fid,int aid)
    {
        int id=-1;
        for(int i=0;i<this.repofa.getAll().size();i++)
        {
            if(this.repofa.getAll().get(i).getFid()==fid &&
                    this.repofa.getAll().get(i).getAid()==aid) id=i;

        }
        return id;
    }

    public int addAssocFormationActivity(int fid, int aid) throws Exception {

        if(this.existAssocFormationActivity(fid,aid)==-1) {
            if (this.repof.getIndex(fid) != -1 && this.repoa.getIndex(aid) != -1) {
                FormationActivity fa = new FormationActivity(Utils.combineInts(fid, aid), fid, aid);
                this.repofa.add(fa);
                String str = "src/FormationActivity" + this.s;
                this.repofa.writeFile(str);
                return 1;
            }
            else throw new Exception("Either teacher or activity could not be found");

        }
        else throw new Exception("Association already exists");

    }

    public int deleteAssocFormationActivity(int fid,int aid) throws Exception {
        int id = this.existAssocFormationActivity(fid,aid);
        if(id!=-1) {this.repota.delete(id);
            String str="src/TeacherActivity"+this.s;
            this.repofa.writeFile(str);
            return 1;}
        else throw new Exception("Association is not found");
    }

    public int deleteTeacher(int id) throws Exception {
        int i =this.repot.getIndex(id);
        if(i!=-1)
        {this.repot.delete(i);
            String str="src/Teacher"+this.s;
            this.repot.writeFile(str);
            for(int j=0;j<this.repota.getAll().size();j++)
            {
                if (this.repota.getAll().get(j).getTid()==id) this.repota.delete(j);
            }
        return 1;}
        else throw new Exception("Teacher not found");
    }

    public int deleteDiscipline(int id) throws Exception {
        int i =this.repod.getIndex(id);
        if(i!=-1)
        {this.repod.delete(i); String str="src/Discipline"+this.s;
            this.repod.writeFile(str); return 1;}
        else throw new Exception("Discipline not found");
    }

    public int deleteActivity(int id) throws Exception {
        int i = this.repoa.getIndex(id);
        if(i!=-1)
        {this.repoa.delete(i);
            String str="src/Activity"+this.s;
            this.repoa.writeFile(str);
            return 1;}
        else throw new Exception("Activity not found");
    }

    public int deleteRoom(int nr, String building) throws Exception {
        Room r=new Room(nr,building);
        Room tobesearched = this.repom.searchById(nr);
        if(r.equals(tobesearched))
        {   this.repom.delete(this.repom.getIndex(nr));
            this.repom.writeFile("src/Room"+this.s);
            return 1;
        }
            else throw new Exception("Room already exists");
    }

    public int deleteFormation(int fid) throws Exception {
        int i=this.repof.getIndex(fid);
        if(i!=-1) { this.repof.delete(i); return 1;}
        else throw new Exception("Formation not found");
    }

    public int deleteGroup(int fid, int gid) throws Exception
    {
        int i=this.repof.getIndex(fid);
        if(i==-1) throw new Exception("Formation not found");
        ArrayList<Group> groups=this.repof.getAll().get(i).getGroups();
        int index=-1;
        for(int j=0;j<groups.size();j++)
        {
            if (groups.get(j).getId()==gid) index=j;
        }
        if(index==-1) throw new Exception("Group not found");
        else
        {
            this.repof.getAll().get(i).getGroups().remove(index);
            return 1;
        }


    }

    public int deleteSemiGroup(int fid, int gid, int sid) throws Exception{
        int i = this.repof.getIndex(fid);
        int indexgroup = -1;
        int indexsmg = -1;
        if (i != -1) {
            for (int j = 0; j < this.repof.getAll().get(i).getGroups().size(); j++)
            {
                if (this.repof.getAll().get(i).getGroups().get(j).getId() == gid)
                {
                    indexgroup = j;
                    for (int k = 0; k < this.repof.getAll().get(i).getGroups().get(j).getSubgroups().size(); k++)
                    {
                        if (this.repof.getAll().get(i).getGroups().get(j).getSubgroups().get(k).getId() == sid)
                            indexsmg = k;
                    }
                }
            }
        }
        else throw new Exception("Formation not found");
        if(indexsmg!=-1 && indexgroup!=-1) {
            this.repof.getAll().get(i).getGroups().get(indexgroup).getSubgroups().remove(indexsmg);
            return 1;
        }
        else if(indexgroup==-1)  throw new Exception("Group not found");
        else throw new Exception("Semigroup not found");
    }

    public int updateTeacher(int id, Teacher t) throws Exception {
        int i =this.repot.getIndex(id);
        if(i!=-1)
        {this.repot.update(this.repot.getAll().get(i),t);
            this.repot.writeFile("src/Teacher"+this.s);
            for(int j=0;j<this.repota.getAll().size();j++)
            {
                if(this.repota.getAll().get(j).getTid()==id)
                    this.repota.getAll().get(j).setTid(t.getId());

            }
            this.repota.writeFile("src/TeacherActivity"+this.s);
            return 1;}
        else throw new Exception("Teacher not found");
    }



    public int updateActivity(int id,Activity newa) throws Exception {
        int i = this.repoa.getIndex(id);
        if(i!=-1)
        {this.repoa.update(this.repoa.getAll().get(i),newa);
            this.repoa.writeFile("src/Activity.txt");
        return 1;}
        else throw new Exception("Activity not found");
    }

    public int updateDiscipline(int id, Discipline d) throws Exception {
        int i =this.repod.getIndex(id);
        if(i!=-1)
        {this.repod.update(this.repod.getAll().get(i),d);
            String str="src/Discipline"+this.s;
            this.repod.writeFile(str);
            return 1;}
        else throw new Exception("Discipline not found");
    }

    public int updateRoom(int oldnr, int newnr, String newBuilding) throws Exception {
        int i=this.repom.getIndex(oldnr);
        Room newr = new Room(newnr,newBuilding);
        if(i!=-1) { this.repom.update(this.repom.getAll().get(i),newr); this.repom.writeFile("src/Room"+this.s); return 1;}
        else throw new Exception("Room not found");
    }

    public int updateFormation(int fid,Formation newformation) throws Exception {
        int i=this.repof.getIndex(fid);
        if(i!=-1) { this.repof.update(this.repof.getAll().get(i),newformation); return 1;}
        else throw new Exception("Formation not found");
    }

    public int updateGroup(int fid,int gid, Group g) throws Exception{
        int i = this.repof.getIndex(fid);
        if (i!=-1) {
            ArrayList<Group> groups = this.repof.getAll().get(i).getGroups();
            int index = -1;
            for (int j = 0; j < groups.size(); j++) {
                if (groups.get(j).getId() == gid) index = j;
            }
            if (index == -1) throw new Exception("Group not found");
            else {
                this.repof.getAll().get(i).getGroups().get(index).setId(g.getId());
                this.repof.getAll().get(i).getGroups().get(index).setSubgroups(g.getSubgroups());
                return 1;
            }
        }
        else throw new Exception("Formation not found");
    }

    public int updateSemigroup(int fid, int gid, int sid, Subgroup smg) {
        int i = this.repof.getIndex(fid);
        int indexgroup = -1;
        int indexsmg = -1;
        if (i != -1) {
            for (int j = 0; j < this.repof.getAll().get(i).getGroups().size(); j++) {
                if (this.repof.getAll().get(i).getGroups().get(j).getId() == gid) {
                    indexgroup = j;
                    for (int k = 0; k < this.repof.getAll().get(i).getGroups().get(j).getSubgroups().size(); k++) {
                        if (this.repof.getAll().get(i).getGroups().get(j).getSubgroups().get(k).getId() == sid)
                            indexsmg = k;
                    }
                }
            }}
        if (indexsmg != -1) {
            this.repof.getAll().get(i).getGroups().get(indexgroup).getSubgroups().get(indexsmg).setId(smg.getId());
            return 1;
        }
        return 0;
    }

    public ArrayList<Activity> filterActivityByDisciplineId(int id)
    {
        ArrayList<Activity> filteredActivities= new ArrayList<>();
        for(int i=0;i<this.repoa.getAll().size();i++)
        {
            if(this.repoa.getAll().get(i).getDiscipline().getId()==id) filteredActivities.add(this.repoa.getAll().get(i));
        }
        return filteredActivities;
    }

    public ArrayList<Activity> filterActivityByTeacherId(int id)
    {
        ArrayList<Activity> filteredActivities= new ArrayList<>();
        for(int i=0;i<this.repoa.getAll().size();i++)
        {
            if(this.repota.getAll().get(i).getTid()==id) filteredActivities.add(this.repoa.getAll().get(i));
        }
        return filteredActivities;
    }

    public int searchTeacherById(int id) throws Exception {
        if(this.repot.getIndex(id)!=-1)
        return this.repot.getIndex(id);
    else throw new Exception("Teacher id not found");
    }

    public Teacher searchTeacherById2(int id) { return this.repot.searchById(id);}

    public Activity searchActivityById(int id)
    {
        return this.repoa.searchById(id);
    }

    public int existRTASAssoc(int roomid, Timeslot ts, int aid, int fid, int teacherid) throws Exception {
        int id=-1;
        for(int i=0;i<this.reportas.getAll().size();i++)
        {
            if(this.reportas.getAll().get(i).getTeacherid()==teacherid &&
                    this.reportas.getAll().get(i).getTimeslot().getDay() == ts.getDay()&&
                    this.reportas.getAll().get(i).getTimeslot().getTime()==ts.getTime())
            throw new Exception("Teacher cannot have 2 activities at the same time");

            if(this.reportas.getAll().get(i).getRoomid()==roomid &&
                    this.reportas.getAll().get(i).getActivityid()==aid &&
                    this.reportas.getAll().get(i).getSubgroupid()==fid &&
                this.reportas.getAll().get(i).getTimeslot().getDay()==ts.getDay() &&
                this.reportas.getAll().get(i).getTimeslot().getTime()==ts.getTime())
                throw new Exception("Association already exists");

            if(this.reportas.getAll().get(i).getRoomid()==roomid &&
                    this.reportas.getAll().get(i).getTimeslot().getDay()==ts.getDay() &&
                    this.reportas.getAll().get(i).getTimeslot().getTime()==ts.getTime())
                throw new Exception("At most one activity can take place in one room at one time");


            if(this.reportas.getAll().get(i).getSubgroupid()==fid &&
                    this.reportas.getAll().get(i).getTimeslot().getDay() == ts.getDay()&&
                    this.reportas.getAll().get(i).getTimeslot().getTime()==ts.getTime())
                throw new Exception("Formation cannot have 2 activities at the same time");


        }
        return id;
    }




    public int addRTMASAssoc(int roomid, Timeslot ts, int activityid, int formationid, int teacherid) throws Exception {
        if(this.repom.getIndex(roomid)!=-1 && this.repoa.getIndex(activityid)!=-1 &&
            this.repof.getIndex(formationid)!=-1)
        {

            if(existRTASAssoc(roomid,ts,activityid,formationid,teacherid)==-1)
            {
                int id = Utils.combineInts(roomid, activityid);
                int id2 = Utils.combineInts(id, formationid);
                RTAS rtas = new RTAS(id2, roomid, ts, activityid, formationid,teacherid);
                reportas.add(rtas);
                return 1;
            }
            else throw new Exception("Association already exists");
        }
        else throw new Exception("One of the attributes does not exist in the repository");
    }



    public List<Teacher> getTeachersWithRankAlphabet(String rank)
    {
        List<Teacher> tcs=this.repot.getAll().stream().filter
                (x->x.getRank().equals(rank)).collect(Collectors.toList());
        List<Teacher> tcsa=tcs.stream().sorted((x1,x2)->x1.getName().compareTo(x2.getName())).collect(Collectors.toList());
        return tcsa;
    }

    public List<RTAS> getAllActivitiesByRoom(int roomid)
    {
        List<RTAS> filtered=this.reportas.getAll().stream().filter
                (x->x.getRoomid()==roomid).collect(Collectors.toList());


        List<RTAS> filteredsorted= filtered.stream().sorted
                ((x1,x2)->x1.getTimeslot().getDay().compareTo(x2.getTimeslot().getDay())).collect(Collectors.toList());


        return filteredsorted;

    }

    public List<RTAS> getTimetableForFormation(int fid)
    {
        List<RTAS> filtered=this.reportas.getAll().stream().filter
                (x->x.getSubgroupid()==fid).collect(Collectors.toList());


        List<RTAS> filteredsorted= filtered.stream().sorted
                ((x1,x2)->x1.getTimeslot().getDay().compareTo(x2.getTimeslot().getDay())).collect(Collectors.toList());


        return filteredsorted;
    }

    public List<RTAS> getTimetableForTeacher(int tid)
    {

        List<RTAS> filtered=this.reportas.getAll().stream().filter
                (x->x.getTeacherid()==tid).collect(Collectors.toList());


        List<RTAS> filteredsorted= filtered.stream().sorted
                ((x1,x2)->x1.getTimeslot().getDay().compareTo(x2.getTimeslot().getDay())).collect(Collectors.toList());


        return filteredsorted;
    }

    public Discipline searchDisciplineById(int did)
    {
        return this.repod.searchById(did);
    }

    public int searchActivityId(int did, String activityname)
    {
        for(Activity a: this.repoa.getAll())
        {
            if(a.getDiscipline().getId()==did && a.getActivityName().equals(activityname))
                return a.getId();
        }
        return -1;
    }
}
