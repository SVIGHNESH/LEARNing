import java.util.ArrayList;
import java.util.List;

class OuterClass {
  static int a = 10;
  String name = "Vighnesh";
  public void execute(){
      System.out.println("This is the Outer Class Execute Method");
    }

   static class InnerClass {
    public void execute(){
      System.out.println("This is the inner Class Execute Method " + a);
    }
  }
}

class ExampleOfInnerandOuterClass{
  public static void main(String[] args) {
  
    // OuterClass outer = new OuterClass();
    OuterClass.InnerClass inner =new OuterClass.InnerClass();

    //inner.execute(); 

    ArrayList<Integer> ls = new ArrayList<>(){
        @Override
        public boolean add(Integer e )
        {
            System.out.println("This is the overriden Method Calling with the " + e );
            super.add(e);
            return true;
        }

    };
    ls.add(345);
    ls.add(2533);
    System.out.println(ls);

    
  }
  
    
}
