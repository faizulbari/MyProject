package DP;

class Package {


    private PackageState state = new OrderedState();

    public PackageState getState() {
        return state;
    }

    public void setState(PackageState state) {
        this.state = state;
    }

    public void printStatus() {
        state.printState();
    }

    public void nextState() {
        state.next(this);
    }
}

interface PackageState{

    public void next(Package aPackage);
    public PackageState prev();
    public void printState();
}

class OrderedState implements PackageState{

    public void next(Package aPackage){
        aPackage.setState(new ShippedState());
    }
    public PackageState prev(){
        return (new ShippedState());
    }
    public void printState(){
        System.out.println("The package is in Ordered State");
    }

}

class ShippedState implements PackageState{
    public void next(Package aPackage){
        aPackage.setState(new DeliveredState());
    }
    public PackageState prev(){
        return (new OrderedState());
    }
    public void printState(){
        System.out.println("The package is in Shipped State");
    }

}

class DeliveredState implements PackageState{

    public void next(Package aPackage){
        aPackage.setState(new DeliveredState());
    }
    public PackageState prev(){
        return (new ShippedState());
    }
    public void printState(){
        System.out.println("The package is in Delivered State");
    }
}

class ReceivedState implements PackageState{

    public void next(Package aPackage){
        aPackage.setState(new DeliveredState());
    }
    public PackageState prev(){
        return (new DeliveredState());
    }
    public void printState(){
        System.out.println("The package is in Received State");
    }
}


public class PackageDemoStateDesignPattern {

    public static void main (String args[])
    {
        Package pkg = new Package();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();
    }

}


