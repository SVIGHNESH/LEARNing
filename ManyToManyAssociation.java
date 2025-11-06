import java.util.ArrayList;
import java.util.List;

class Student{
        private String name;
        private List<Course> courses;
        Student(String name){
            this.name = name;
            courses = new ArrayList<>();
        }

        public void addCourse(Course crs){
            courses.add(crs);
        
        }
        public String getName(){
            return name;
        }
        public void printCourses(){
            for(Course st : courses){
                System.out.println("Course : " + st.getCourse());
            }
        }
        
}
class Course{
        private String name;
        private List<Student> students;
        Course(String name){
            this.name = name;
            students = new ArrayList<>();
        }

        public void addStudent(Student st){
            students.add(st);
        }

        public void printStudents(){
            for(Student st : students){
                System.out.println("Student : " + st.getName() );
            }
        }

        public String getCourse(){
                return name;
        }
}

public class ManyToManyAssociation {
    public static void main(String[] args) {
        Student s1 = new Student("Vighnesh");
    Student s2 = new Student("Ritik");

    Course tafl = new Course("TAFL");
    Course os = new Course("OS");

    s1.addCourse(tafl);
    s1.addCourse(os);
    System.out.println(s1.getName());
    s1.printCourses();

    System.out.println();   
    System.out.println();

    s2.addCourse(tafl); 
    s2.addCourse(os);
    System.out.println(s2.getName());
    s2.printCourses();

    System.out.println();   
    System.out.println();
    tafl.addStudent(s1);
    tafl.addStudent(s2);
    System.out.println(tafl.getCourse()); 

    tafl.printStudents();
    
     System.out.println();   
    System.out.println();
    os.addStudent(s1);
    os.addStudent(s2);
    System.out.println(os.getCourse()); 

    tafl.printStudents();



    }
    
}
