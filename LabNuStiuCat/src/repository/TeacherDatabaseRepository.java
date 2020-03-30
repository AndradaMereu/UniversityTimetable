package repository;

import domain.Discipline;
import domain.Entity;
import domain.Teacher;

import java.sql.*;
import java.util.ArrayList;

public class TeacherDatabaseRepository<T extends Entity> extends Repository<T> {

    private static final String TeacherDatabaseRepository_URL= "jdbc:sqlite:src/test.db";

    private Connection conn = null;
    public void openConnection()
    {
        try
        {
            // with DriverManager
            if (conn == null || conn.isClosed())
                conn = DriverManager.getConnection(TeacherDatabaseRepository_URL);

            // with DataSource
//            SQLiteDataSource ds = new SQLiteDataSource();
//            ds.setUrl(JDBC_URL);
//            if (conn == null || conn.isClosed())
//                conn = ds.getConnection();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection()
    {
        try
        {
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void createSchema()
    {
        try
        {
            final Statement stmt = conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS teachers(id int, name varchar(200), email varchar(200),rank varchar(200));");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS disciplines(id int,name varchar(200), nrOfCredits int);");
            //stmt.executeUpdate("CREATE TABLE IF NOT EXISTS disciplines(id int, name varchar(200), nrOfCredits int);");
            // create any other tables that are needed
            stmt.close();
        }
        catch (SQLException e) {
            System.err.println("[ERROR] createSchema : " + e.getMessage());
        }
    }

    public void initTables() throws SQLException {
        PreparedStatement statementx = conn.prepareStatement("DELETE FROM teachers");
        statementx.executeUpdate();
        final String[] teachers = new String[]{
                "1|Surdu Sabina|s@ubbcluj|profesor",
                "2|Pop Emilia|p@csubb|assistant",
                "3|Crivei Septimiu|c@ubbcluj|professor"
        };

        final String[] disciplines = new String[]
                {
                        "1|OOP|5",
                        "2|MAP|5",
                        "3|Databases|4",
                        "4|Differential equations|5"
                };

        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO teachers VALUES (?, ?, ?, ?);");
            for (String s : teachers) {
                String[] tokens = s.split("[|]");
                statement.setInt(1, Integer.parseInt(tokens[0]));
                statement.setString(2, tokens[1]);
                statement.setString(3, tokens[2]);
                statement.setString(4, tokens[3]);
                statement.executeUpdate();}
            } catch (SQLException e)
            {
            e.printStackTrace();
            }
            try{
                PreparedStatement statement1 = conn.prepareStatement("INSERT INTO disciplines VALUES(?,?,?);");
                for (String s1 : disciplines) {
                    String[] tokens1 = s1.split("[|]");
                    statement1.setInt(1,Integer.parseInt(tokens1[0]));
                    statement1.setString(2,tokens1[1]);
                    statement1.setInt(3,Integer.parseInt(tokens1[2]));
                    statement1.executeUpdate();
                }
                statement1.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
        }
        }


    public void addTeacher(Teacher t)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO teachers VALUES (?, ?, ?, ?)");
            statement.setInt(1, t.getId());
            statement.setString(2, t.getName());
            statement.setString(3,t.getEmail());
            statement.setString(4,t.getRank());
            statement.executeUpdate();
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTeacher(int id)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM teachers WHERE id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Teacher> getTeachers()
    {
        ArrayList<Teacher> teachers = new ArrayList<>();
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * from teachers");
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                Teacher t = new Teacher(rs.getInt("id"), rs.getString("name"), rs.getString("email"),rs.getString("rank"));
                teachers.add(t);
            }
            rs.close();
            statement.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return teachers;
    }

    public void updateTeacher(Teacher t, Teacher newt)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("UPDATE * from teachers WHERE id=?");
            statement.setInt(1,t.getId());
            statement.setString(2,t.getName());
            statement.setString(3,t.getEmail());
            statement.setString(4,t.getRank());
            statement.setInt(5,newt.getId());
            statement.setString(2,newt.getName());
            statement.setString(3,newt.getEmail());
            statement.setString(4,newt.getRank());
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDiscipline(Discipline d)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO disciplines VALUES (?, ?, ?)");
            statement.setInt(1, d.getId());
            statement.setString(2, d.getName());
            statement.setInt(3,d.getNrOfCredits());
            statement.executeUpdate();
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteDiscipline(int id)
    {
        try
        {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM disciplines WHERE id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Discipline> getAllDisciplines()
    {
        ArrayList<Discipline> disciplines = new ArrayList<>();
        try
        {
            PreparedStatement statement = conn.prepareStatement("SELECT * from disciplines");
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                Discipline d = new Discipline(rs.getInt("id"), rs.getString("name"), rs.getInt("nrOfCredits"));
                disciplines.add(d);
            }
            rs.close();
            statement.close();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return disciplines;
    }

    public void updateDiscipline(Discipline d, Discipline newd) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("UPDATE * from disciplines WHERE id=?");
        statement.setInt(1,d.getId());
        statement.setString(2,d.getName());
        statement.setInt(3,d.getNrOfCredits());

        statement.setInt(4,newd.getId());
        statement.setString(5,newd.getName());
        statement.setInt(6,newd.getNrOfCredits());

        statement.executeUpdate();
        statement.close();
    }



}
