import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    static Connection connection;

    public static void connect(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:543/sweater", "postgres", "1234");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void addStudent(Student s){
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users(name, surname, age) values(?,?,?)");
            statement.setString(1, s.getName());
            statement.setString(2, s.getSurname());
            statement.setInt(3, s.getAge());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                int age = resultSet.getInt("age");
                students.add(new Student(id, name, surname, age));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
}
