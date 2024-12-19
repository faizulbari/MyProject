package Anonymous;

public class AnonymousClassAsArgument {

    public static void main(String arg[])
    {
        Bus bus1 = new Bus(new Engine() {
            @Override
            public void buildEnginType() {
                noOfWheels = 4;
                type = "Diesel";
            }
        });
        bus1.defaultMove();

        Bus bus2 = new Bus();
        bus2.instantMove(new Engine() {
            @Override
            public void buildEnginType() {
                this.noOfWheels = 6;
                this.type = "Petrol";
            }
        });
        //bus2.defaultMove();

        bus2.instantMove(new Engine() {
            @Override
            public void buildEnginType() {
                this.noOfWheels = 4;
                this.type = "Gas";
            }
        });


    }
}

class Bus{
    Engine engine;
    String busType = "super delux";

    Bus(Engine eng){
        super();
        this.engine = eng;
    }

    public Bus() {

    }

    void defaultMove()
    {
        engine.buildEnginType();
        System.out.println("Bus moved with default wheel :" + engine.noOfWheels + " Engine :" + engine.type + busType );
    }

    void instantMove(Engine eng){
        eng.buildEnginType();
        System.out.println("Bus moved with wheel :" + eng.noOfWheels + " Engine :" + eng.type +  busType);
    }
}

abstract class Engine{
    int noOfWheels ;
    String type;
    public abstract void buildEnginType();
}