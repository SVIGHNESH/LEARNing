abstract class Car{
    abstract void start();
    public void noise(){
        System.out.println("NOISE??>???>>?");
    }
}
class ManualCar extends Car{
    void start(){
        System.out.println("Statring the MANUAL CAR");
    }
}

class abstractionOOPS{

        public void main(String []args){
            ManualCar mc = new ManualCar();
            mc.start();
            mc.noise();

        }
} 