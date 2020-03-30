package ui;
import infrastructure.Controller;
import domain.*;
import utils.Utils;

import java.io.IOException;
import java.sql.SQLOutput;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private Controller c;

    public Ui(Controller c) {
        this.c = c;
    }

    public void printGeneralMenu()
    {
        System.out.println("1.Teacher database");
        System.out.println("2.Discipline database");
        System.out.println("3.Activity database");
        System.out.println("4.Room database");
        System.out.println("5. Formation database");
    }

    public void printTeacherMenu()
    {
        System.out.println("\t 1. Add teacher");
        System.out.println("\t 2. Get all teachers");
        System.out.println("\t 3. Delete teacher");
        System.out.println("\t 4. Update teacher");
        System.out.println("\t 5. Add activity for a teacher");
        System.out.println("\t 6. Delete activity for a teacher");
        System.out.println("\t 7. Get all teachers with a given rank sorted alphabetically");

    }

    public void printDisciplineMenu()
    {
        System.out.println("\t 1. Add discipline");
        System.out.println("\t 2. Get all disciplines");
        System.out.println("\t 3. Delete discipline");
        System.out.println("\t 4. Update discipline");
    }

    public void printActivityMenu()
    {
        System.out.println("\t 1. Add activity");
        System.out.println("\t 2. Get all activities");
        System.out.println("\t 3. Delete activity");
        System.out.println("\t 4. Update activity");
        System.out.println("\t 5. Filter activities by discipline id");
        System.out.println("\t 6. Filter activities by teacher id");
        System.out.println("\t 7. Add formation for activity");
        System.out.println("\t 8. Delete formation for activity");
        System.out.println("\t 9. Filer activities by formation id");
        System.out.println("\t 10. Get all activities filtered by room");
        System.out.println("\t 11. Add a room-time-activity-formation association");
        System.out.println("\t 12. Get all room-time-activity-formation associations");
        System.out.println("\t 13. Get timetable for formation");
    }

    public void printRoomMenu()
    {
        System.out.println("\t 1. Add room");
        System.out.println("\t 2. Get all rooms");
        System.out.println("\t 3. Delete room");
        System.out.println("\t 4. Update room");
    }

    public void printFormationMenu()
    {
        System.out.println("\t 1.Add formation");
        System.out.println("\t 2.Add group");
        System.out.println("\t 3.Add subgroup");
        System.out.println("\t 4.Delete formation");
        System.out.println("\t 5.Delete group");
        System.out.println("\t 6.Delete semigroup");
        System.out.println("\t 7.Update formation");
        System.out.println("\t 8.Update group");
        System.out.println("\t 9.Update semigroup");
        System.out.println("\t 10.See all formations");
        System.out.println("\t 11.See all groups of a formation");
        System.out.println("\t 12.See all subgroups of a group");
    }


    public void run() throws Exception {
        while(true)
        {
            this.printGeneralMenu();
            int command=0;
            Scanner s=  new Scanner(System.in);
            command=s.nextInt();
            if (command ==0) break;
            else if(command==1)
                while(true){
                    {
                        this.printTeacherMenu();
                        command = s.nextInt();
                        if (command ==0) break;
                        else if (command ==1)
                        {
                            try {
                                System.out.println("Enter id:");
                                int tid = s.nextInt();
                                System.out.println("Enter name:");
                                String tname = s.next();
                                System.out.println("Enter email:");
                                String tmail = s.next();
                                System.out.println("Enter rank:");
                                String trank = s.next();
                                if (this.c.addTeacher(tid, tname,tmail, trank) == 1) System.out.println("Added successfully");
                                else System.out.println("Not added");
                            }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }
                        }
                        else if(command==2)
                        {
                            for(int i=0;i<this.c.getRepot().size();i++)
                            {
                                System.out.println(this.c.getRepot().get(i).toString()+": ");
                                System.out.println("\t" + this.c.getAllActivitiesForTeacher(this.c.getRepot().get(i).getId()));
                                System.out.println();
                            }
                        }
                        else if(command==3)
                        {
                            try {
                                System.out.println("Enter the id of the teacher");
                                int id = s.nextInt();
                                if (this.c.deleteTeacher(id) == 1) {
                                    System.out.println("Deleted successfully");
                                } else System.out.println("Not deleted");
                            }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }
                        }
                        else if(command == 4)
                        {
                            try {
                                System.out.println("Enter the id of the teacher");
                                int id = s.nextInt();
                                System.out.println("Enter new id:");
                                int tid = s.nextInt();
                                System.out.println("Enter new name:");
                                String tname = s.next();
                                System.out.println("Enter new email:");
                                String tmail = s.next();
                                System.out.println("Enter new rank:");
                                String trank = s.next();
                                Teacher t = new Teacher(tid, tname, tmail,trank);
                                if (this.c.updateTeacher(id, t) == 1) System.out.println("Updated successfully");
                                else System.out.println("Not updated");

                            }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }
                        }
                        else if (command == 5 )
                        {
                            try {
                                System.out.println("Enter the id of the teacher");
                                int tid = s.nextInt();
                                System.out.println("Enter the id of the activity");
                                int aid = s.nextInt();
                                if (this.c.addAssocTeacherActivity(tid, aid) == 1)
                                    System.out.println("Association added");
                                else System.out.println("Association not added");

                            }
                            catch (Exception e)
                            {
                                System.out.println(e);
                            }

                        }
                        else if (command == 6)
                        {
                            try {
                                System.out.println("Enter the id of the teacher");
                                int tid = s.nextInt();
                                System.out.println("Enter the id of the activity");
                                int aid = s.nextInt();
                                if (this.c.deleteAssocTeacherActivity(tid, aid) == 1)
                                    System.out.println("Association deleted");
                                else System.out.println("Association not deleted");

                            }
                            catch (Exception e)
                            {
                                System.out.println(e);
                            }
                        }
                        else if(command == 7)
                        {
                            System.out.println("Enter the rank");
                            String rank=s.next();
                            System.out.println(this.c.getTeachersWithRankAlphabet(rank));
                        }
                    }}
            else if(command==2)
                while(true){
                    {
                        this.printDisciplineMenu();
                        command = s.nextInt();
                        if (command ==0) break;
                        else if (command ==1)
                        {
                            try {
                                System.out.println("Enter id:");
                                int did = s.nextInt();
                                System.out.println("Enter name:");
                                String dname = s.next();
                                System.out.println("Enter number of credits:");
                                int dnr = s.nextInt();
                                if (this.c.addDiscipline(did, dname, dnr) == 1)
                                    System.out.println("Added successfully");
                                else System.out.println("Not added");
                            }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }
                        }
                        else if(command==2)
                        {
                            System.out.println(this.c.getRepod());
                        }
                        else if(command==3)
                        {
                            try {
                                System.out.println("Enter the id of the discipline");
                                int id = s.nextInt();
                                if (this.c.deleteDiscipline(id) == 1) {
                                    System.out.println("Deleted successfully");
                                } else System.out.println("Not deleted");
                            }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }
                        }
                        else if(command==4)
                        {
                            try {
                                System.out.println("Enter the id of the discipline");
                                int id = s.nextInt();
                                System.out.println("Enter new id:");
                                int did = s.nextInt();
                                System.out.println("Enter new name:");
                                String dname = s.next();
                                System.out.println("Enter new nr of credits:");
                                int dnewnr = s.nextInt();
                                Discipline d = new Discipline(did, dname, dnewnr);
                                if (this.c.updateDiscipline(id, d) == 1) System.out.println("Updated successfully");
                                else System.out.println("Not updated");
                            }
                            catch(Exception e)
                            {
                                System.out.println(e);
                            }
                        }
                    }}

            else if(command==3)
                while(true)
                {
                    this.printActivityMenu();
                    command=s.nextInt();
                    if (command ==0) break;
                    else if(command==1) {
                        try {
                            System.out.println("Enter activity id:");
                            int id = s.nextInt();
                            System.out.println("Enter discipline id:");
                            int did = s.nextInt();
                            System.out.println("Enter discipline name:");
                            String dname = s.next();
                            System.out.println("Enter number of credits:");
                            int dnr = s.nextInt();
                            System.out.println("Enter activity type");
                            String atype = s.next();
                            Discipline d = new Discipline(did, dname, dnr);
                            if (this.c.addActivity(id, d, atype) == 1) System.out.println("Added successfully");
                            else if (this.c.addActivity(id, d, atype) == 0) System.out.println("Not added");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }

                    else if(command==2)
                    {
                        System.out.println(this.c.getRepoa());
                    }
                    else if(command==3)
                    {
                        try {
                            System.out.println("Enter activity id: ");
                            int id = s.nextInt();
                            System.out.println("Enter discipline id:");
                            int did = s.nextInt();
                            System.out.println("Enter discipline name:");
                            String dname = s.next();
                            System.out.println("Enter number of credits:");
                            int dnr = s.nextInt();
                            System.out.println("Enter activity type");
                            String atype = s.next();

                            Discipline d = new Discipline(did, dname, dnr);
                            Activity a = new Activity(id, d, atype);
                            if (this.c.deleteActivity(id) == 1) System.out.println("Deleted successfully");
                            else System.out.println("Not deleted");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(command==4) {
                        try {
                            System.out.println("Enter activity id:");
                            int id = s.nextInt();
                            System.out.println("Enter discipline id:");
                            int did = s.nextInt();
                            System.out.println("Enter discipline name:");
                            String dname = s.next();
                            System.out.println("Enter number of credits:");
                            int dnr = s.nextInt();
                            System.out.println("Enter activity type");
                            String atype = s.next();

                            Discipline d = new Discipline(did, dname, dnr);
                            Activity a = new Activity(id, d, atype);


                            System.out.println("Enter new activity id:");
                            int id2 = s.nextInt();
                            System.out.println("Enter new discipline id:");
                            int did2 = s.nextInt();
                            System.out.println("Enter new discipline name:");
                            String dname2 = s.next();
                            System.out.println("Enter new number of credits:");
                            int dnr2 = s.nextInt();
                            System.out.println("Enter new activity type");
                            String atype2 = s.next();

                            Discipline d2 = new Discipline(did2, dname2, dnr2);
                            Activity a2 = new Activity(id2, d2, atype2);
                            if (this.c.updateActivity(id, a2) == 1) System.out.println("Updated successfully");
                            else System.out.println("Not updated");
                        } catch (Exception e) {
                            System.out.println(e);
                        }

                    }
                    else if(command==5)
                    {
                        System.out.println("Enter discipline id:");
                        int did=s.nextInt();
                        System.out.println(this.c.filterActivityByDisciplineId(did));
                    }
                    else if(command==6)
                    {
                        System.out.println("Enter teacher id:");
                        int tid=s.nextInt();
                        System.out.println(this.c.getAllActivitiesForTeacher(tid));
                    }
                    else if(command==7)
                    {
                        try{
                        System.out.println("Enter formation id:");
                        int fid=s.nextInt();
                        System.out.println("Enter activity id:");
                        int aid=s.nextInt();
                        if (this.c.addAssocFormationActivity(fid, aid) == 1)
                            System.out.println("Association added");
                        else System.out.println("Association not added");

                    }
                            catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    }
                    else if(command==8)
                    {
                        try {
                            System.out.println("Enter formation id");
                            int fid = s.nextInt();
                            System.out.println("Enter activity id");
                            int aid = s.nextInt();
                            if(this.c.deleteAssocFormationActivity(fid,aid)==1)
                                System.out.println("Association deleted");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }

                    }
                    else if(command==9)
                    {
                        System.out.println("Enter formation id:");
                        int fid=s.nextInt();
                        System.out.println(this.c.getAllActivitiesForFormation(fid));
                    }
                    else if(command==10)
                    {
                        System.out.println("Enter room id");
                        int roomid=s.nextInt();
                        for(int i=0;i<this.c.getAllActivitiesByRoom(roomid).size();i++)
                        {
                            int aid=this.c.getAllActivitiesByRoom(roomid).get(i).getActivityid();
                            Activity a=this.c.searchActivityById(aid);
                            System.out.println(a + ":" + this.c.getAllActivitiesByRoom(roomid).get(i).getTimeslot());
                        }
                        //System.out.println(this.c.getAllActivitiesByRoom(roomid));
                    }
                    else if(command==11)
                    {
                        System.out.println("Enter room number: ");
                        int rid=s.nextInt();
                        System.out.println("Enter day of the week");
                        DayOfWeek day=Utils.parseDayOfWeek(s.next());
                        System.out.println("Enter hour and minutes in HH:MM format");
                        String[] time=s.next().split(":");
                        LocalTime localtime=LocalTime.of(Integer.parseInt(time[0]),Integer.parseInt(time[1]));
                        Timeslot t=new Timeslot(day,localtime);
                        System.out.println("Enter activity id");
                        int aid=s.nextInt();
                        System.out.println("Enter Formation id");
                        int fid=s.nextInt();
                        System.out.println("Enter teacher id");
                        int tid=s.nextInt();
                        if(this.c.addRTMASAssoc(rid,t,aid,fid,tid)==1) System.out.println("Association added");
                    }
                    else if(command == 12)
                    {
                        System.out.println(this.c.getReportas());
                    }
                    else if(command ==13)
                    {
                        System.out.println("Enter formation id");
                        int formationid=s.nextInt();
                        System.out.println(this.c.getTimetableForFormation(formationid));
                    }

                }
            else if(command==4)
                while(true)
                {
                    this.printRoomMenu();
                    command = s.nextInt();
                    if(command==0) break;
                    else if(command==1)
                    {
                        System.out.println("Enter room nr:");
                        int roomnr=s.nextInt();
                        System.out.println("Enter building name:");
                        String rname=s.next();
                        if(this.c.addRoom(roomnr,rname)==1) System.out.println("Added successfully");
                        else System.out.println("Not added");
                    }
                    else if(command==2)
                    {
                        System.out.println(this.c.getRepom());
                    }
                    else if(command == 3)
                    {
                        System.out.println("Enter the nr of the room");
                        int nr=s.nextInt();
                        System.out.println("Enter the name of the building:");
                        String name=s.next();
                        if(this.c.deleteRoom(nr,name)==1) {System.out.println("Deleted successfully");}
                        else System.out.println("Not deleted");
                    }
                    else if(command == 4)
                    {
                        System.out.println("Enter the nr of the old room");
                        int nr=s.nextInt();
                        System.out.println("Enter the name of the old building:");
                        String name=s.next();
                        Room r = new Room(nr,name);
                        System.out.println("Enter the nr of the new room");
                        int newnr=s.nextInt();
                        System.out.println("Enter the name of the new building:");
                        String newname=s.next();
                        if(this.c.updateRoom(nr,newnr,newname)==1) {System.out.println("Updated successfully");}
                        else System.out.println("Not updated");
                    }
                }
            else if (command==5)
                while(true)
                {
                    printFormationMenu();
                    command = s.nextInt();
                    if(command==0) break;
                    else if(command==1)
                    {
                        try {
                            System.out.println("Enter formation id");
                            int fid = s.nextInt();
                            if (this.c.addFormation(fid) == 1) System.out.println("Added successfully");
                            else System.out.println("Not added");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(command==2)
                    {
                        try {
                            System.out.println("Enter formation id");
                            int fid = s.nextInt();
                            System.out.println("Enter group id");
                            int gid = s.nextInt();
                            if (this.c.addGroup(fid, gid) == 1) System.out.println("Added successfully");
                            else System.out.println("Not added");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(command==3)
                    {
                        try {
                            System.out.println("Enter formation id");
                            int fid = s.nextInt();
                            System.out.println("Enter group id");
                            int gid = s.nextInt();
                            System.out.println("Enter subgroup id");
                            int sid = s.nextInt();
                            if (this.c.addSemigroup(fid, gid, sid) == 1) System.out.println("Added successfully");
                            else System.out.println("Not added");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(command==4)
                    {
                        try {
                            System.out.println("Enter formation id");
                            int fid = s.nextInt();
                            if (this.c.deleteFormation(fid) == 1) System.out.println("Deleted successfully");
                            else System.out.println("Not deleted");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(command==5)
                    {
                        try {
                            System.out.println("Enter formation id");
                            int fid = s.nextInt();
                            System.out.println("Enter group id");
                            int gid = s.nextInt();
                            if (this.c.deleteGroup(fid, gid) == 1) System.out.println("Deleted successfully");
                            else System.out.println("Not deleted");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(command==6)
                    {
                        try {
                            System.out.println("Enter formation id");
                            int fid = s.nextInt();
                            System.out.println("Enter group id");
                            int gid = s.nextInt();
                            System.out.println("Enter subgroup id");
                            int sid = s.nextInt();
                            if (this.c.deleteSemiGroup(fid, gid, sid) == 1) System.out.println("Deleted successfully");
                            else System.out.println("Not deleted");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(command==7)
                    {
                        try {
                            System.out.println("Enter formation id");
                            int fid = s.nextInt();
                            System.out.println("Enter new formation id: ");
                            int fid2 = s.nextInt();
                            ArrayList<Group> groups = new ArrayList<>();
                            Formation f2 = new Formation(fid2, groups);
                            if (this.c.updateFormation(fid, f2) == 1) System.out.println("Deleted successfully");
                            else System.out.println("Not deleted");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(command==8)
                    {
                        try {
                            System.out.println("Enter formation id");
                            int fid = s.nextInt();
                            System.out.println("Enter group id");
                            int gid = s.nextInt();
                            System.out.println("Enter new group id");
                            int gid2 = s.nextInt();
                            ArrayList<Subgroup> subgroups = new ArrayList<>();
                            Group g = new Group(gid2, subgroups);
                            if (this.c.updateGroup(fid, gid, g) == 1) System.out.println("Updated sucessfully");
                            else System.out.println("Not updated");
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(command==9)
                    {try {
                        System.out.println("Enter formation id");
                        int fid = s.nextInt();
                        System.out.println("Enter group id");
                        int gid = s.nextInt();
                        System.out.println("Enter subgroup id");
                        int sid = s.nextInt();
                        System.out.println("Enter new subgroup id");
                        int sid2 = s.nextInt();
                        Subgroup s2 = new Subgroup(sid2);
                        if (this.c.updateSemigroup(fid, gid, sid, s2) == 1) System.out.println("Deleted successfully");
                        else System.out.println("Not deleted");
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    }
                    else if(command==10)
                    {
                        System.out.println(this.c.getRepof());
                    }
                    else if(command==11)
                    {
                        System.out.println("Enter the formation id");
                        int fid=s.nextInt();
                        try {
                            System.out.println(this.c.getGroupsOfFormation(fid));
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(command==12)
                    {
                        System.out.println("Enter the formation id");
                        int fid=s.nextInt();
                        System.out.println("Enter the group id");
                        int gid=s.nextInt();
                        try {
                            System.out.println(this.c.getSubgroupsOfGroup(fid,gid));
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }

                    }

                }
        }
    }
}
