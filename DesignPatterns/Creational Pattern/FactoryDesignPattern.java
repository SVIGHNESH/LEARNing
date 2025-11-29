interface Logistics {
    void send();
}
class RoadLogistics implements Logistics {
    @Override
    public void send() {
        System.out.println("Transporting goods by Road.");
    }
}
class SeaLogistics implements Logistics {
    @Override
    public void send() {
        System.out.println("Transporting goods by Sea.");
    }   
}   
class Facotry{
    public static Logistics getLogistics(String type){
        if(type.equalsIgnoreCase("road")){
            return new RoadLogistics();
        } else if(type.equalsIgnoreCase("sea")){
            return new SeaLogistics();
        }
        return null;
    }
}
class FactoryDesignPattern {
    public static void main(String[] args) {
        Logistics roadLogistics = Facotry.getLogistics("road");
        roadLogistics.send();

        Logistics seaLogistics = Facotry.getLogistics("sea");
        seaLogistics.send();
    }
}