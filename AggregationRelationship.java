class Passport{
    private String id;
    Passport(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
}
class Student{
    private String name;
    private Passport passport;

    Student(String name,Passport passport){
        this.name = name;
        this.passport = passport;

    }
    public void printStudentDetails(){
        System.out.println("The Name of the Student is "+this.name + " and the passport id of the it is : "+passport.getId());
    }

}
public class AggregationRelationship {
    public static void main(String[] args) {


        //This passport object shows the Aggregation Relationship that is a weak Relationhip
        Passport passport = new Passport("23456789");
        Student student = new Student("Vighnesh", passport);
        student.printStudentDetails();
    }
}
