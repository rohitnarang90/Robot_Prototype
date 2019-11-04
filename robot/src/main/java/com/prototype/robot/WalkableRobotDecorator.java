package com.prototype.robot;

public class WalkableRobotDecorator extends BaseRobotDecorator {

    private double inputInKilometers;
    private final double MAX_CAPACITY = 5;

    public WalkableRobotDecorator(IRobot robot, double inputInKilometers) {
        super(robot);
        this.inputInKilometers = inputInKilometers;
    }

    @Override
    public void updateChargingStatus(double consumedChargingLevel) {
        super.updateChargingStatus(consumedChargingLevel);
    }

    @Override
    public double getChargingStatus() {
        return super.getChargingStatus();
    }

    @Override
    public boolean validate() {
        if(inputInKilometers > MAX_CAPACITY){
            System.out.println("Can not run this much distance.");
            return false;
        }
        double requiredbattery = inputInKilometers * 100 / MAX_CAPACITY;
        boolean canWalk = getChargingStatus() - requiredbattery > 0;
        if(!canWalk){
            System.out.println("Not Enough Battery to walk.");
        }
        return super.validate() && canWalk;
    }

    @Override
    public double performTask() {
        super.performTask();
        System.out.println("Robot has started running for " +inputInKilometers +" kms.");
        double consumedBattery = inputInKilometers * 100 / MAX_CAPACITY;
        updateChargingStatus(consumedBattery);
        return getChargingStatus();
    }
}
