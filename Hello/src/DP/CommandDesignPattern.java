package DP;

class Light {
    public void turnOn()
    {
        System.out.println(" DP.Light is Turned ON");
    }
    public void turnOff()
    {
        System.out.println(" DP.Light is Turned Off");
    }
}

class Fan {
    public void turnOn()
    {
        System.out.println(" DP.Fan is Turned ON");
    }
    public void turnOff()
    {
        System.out.println(" DP.Fan is Turned Off");
    }
}

interface Command {
    void execute();
    void undo();
}

class LigthTurnOnCommand implements Command
{
    private Light light ;

    public LigthTurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }

}

class FanTurnOnCommand implements Command{

    private Fan fan;

    public FanTurnOnCommand (Fan fan)
    {
        this.fan = fan;
    }

    @Override
    public void execute() {
        this.fan.turnOn();
    }

    @Override
    public void undo() {
        this.fan.turnOff();
    }
}

class RemoteControle{

    private Command cmd;

    public void setCommand (Command cmd){
        this.cmd = cmd;
    }

    public void onPress()
    {
        this.cmd.execute();
    }

    public void pressUndo()
    {
        this.cmd.undo();
    }

}

public class CommandDesignPattern {

    public static void main(String args[])
    {
        Light light = new Light();
        LigthTurnOnCommand lightCommand = new LigthTurnOnCommand(light);
        RemoteControle remote = new RemoteControle();
        remote.setCommand(lightCommand);
        remote.onPress();
        remote.pressUndo();

        Fan fan = new Fan();
        FanTurnOnCommand fanCommand = new FanTurnOnCommand(fan);
        remote.setCommand(fanCommand);
        remote.onPress();
        remote.pressUndo();
    }

}
