package com.hanshan.cli.pattern;

public class Client {

    public static void main(String[] args) {

        Device tv = new Device("TV");
        Device xc = new Device("小米");

        TurnOffCommand turnOff = new TurnOffCommand(tv);
        TurnOnCommand turnOn = new TurnOnCommand(xc);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOff);
        remote.pressButton();

        remote.setCommand(turnOn);
        remote.pressButton();
    }
}
