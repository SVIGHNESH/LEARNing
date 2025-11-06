import java.util.ArrayList;
import java.util.List;

class Student{
    private String name;
    private String id;
    Student(String name,String id){
        this.name = name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
}
class College{
    private String name;
    private List<Student> Students = new ArrayList<>();
    College(String name){
        this.name = name;        
    }

    public void addStudent(Student st){
        Students.add(st);

    }
    public void printAllStudents(){
        for(Student st : Students){
            System.out.println("Name of the Student with the Id : "+st.getId()+ " is "+st.getName());
        }
    }
}

public class AssociationRelation {
    public static void main(String[] args) {
             Student s1 = new Student("Vighnesh", "1");
            Student s2 = new Student("Ritik", "2");
            Student s3 = new Student("Devang", "3");
            Student s4 = new Student("Suresh", "4");

            College clg = new College("RBCET");
            clg.addStudent(s1);
            clg.addStudent(s2);
            clg.addStudent(s3);
            clg.addStudent(s4);
            clg.printAllStudents();

    }
}
