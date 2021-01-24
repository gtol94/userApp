import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    ArrayList<Student> students;
    Student student;
    String operationType;

    public PackageData(Student student, String operationType) {
        this.student = student;
        this.operationType = operationType;
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public PackageData(ArrayList<Student> students, String operationType) {
        this.students = students;
        this.operationType = operationType;
    }
}
