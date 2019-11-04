package com.prototype.robot;

public abstract class BaseRobotDecorator implements IRobot{

    protected IRobot robot;

    public BaseRobotDecorator(IRobot robot){
        this.robot = robot;
    }

    @Override
    public double performTask() {
        return robot.performTask();
    }

    @Override
    public void updateChargingStatus(double consumedChargingLevel) {
        robot.updateChargingStatus(consumedChargingLevel);
    }

    @Override
    public double getChargingStatus() {
        return robot.getChargingStatus();
    }

    @Override
    public boolean validate() {
        return robot.validate();
    }
}
