
class OuterClass {
  static int a = 10;
  String name = "Vighnesh";

  static class InnerClass {
    public void execute() {
      System.out.println("This is the inner Class Execute Method");
    }
  }
}

class ExampleOfInnerandOuterClass{
  OuterClass.InnerClass obj = new OuterClass.InnerClass();
  obj.execute(); 
    
}
