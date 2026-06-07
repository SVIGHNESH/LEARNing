class ConstructorCalling {

    public static void main(String args[]) {
        Demo d1 = new Demo();
        System.out.println("Making sure to call the Constructor");
    }
}

class Demo {

    Demo() {
        System.out.println("ConstructorCalling of the Demo Class");
    }
}
