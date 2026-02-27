class Passport {
  private String id;

  Passport(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}

class Student36 implements Cloneable {
  private String name;
  private Passport passport;

  Student36(String name, String passportId) {
    this.name = name;
    this.passport = new Passport(passportId);
    System.out.println("Constructor of the Student is called!!");

  }

  public void printStudentDetails() {
    System.out
        .println("The Name of the Student is " + this.name + " and the passport id of the it is : " + passport.getId());
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

}

public class CompositionRelationShip {
  public static void main(String[] args) throws CloneNotSupportedException {

    // This passport object shows the Composition Relationship that is a Strong
    // Relationhip

    Student36 student = new Student36("Vighnesh", "234567890");
    System.out.println();
    student.printStudentDetails();

    Student36 clonedStudent = (Student36) student.clone();
    System.out.println();
    clonedStudent.printStudentDetails();

  }
}
