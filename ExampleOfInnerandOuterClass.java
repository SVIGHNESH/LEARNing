
class OuterClass {
  static int a = 10;
  String name = "Vighnesh";
  public void execute(){
      System.out.println("This is the Outer Class Execute Method");
    }

   class InnerClass {
    public void execute(){
      System.out.println("This is the inner Class Execute Method");
    }
  }
}

class ExampleOfInnerandOuterClass{
  public static void main(String[] args) {
    OuterClass obj = new OuterClass();
    OuterClass.InnerClass ob= obj.new InnerClass();
    ob.execute();
    obj.execute(); 
  }
  
    
}
