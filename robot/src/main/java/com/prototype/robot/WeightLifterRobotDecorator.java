package com.prototype.robot;

public class WeightLifterRobotDecorator extends BaseRobotDecorator {

    private double inputInKilos;
    private final double MAX_CAPACITY = 10;

    public WeightLifterRobotDecorator(IRobot robot, double inputInKilometers) {
        super(robot);
        this.inputInKilos = inputInKilometers;
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
        if(inputInKilos > MAX_CAPACITY) {
            System.out.println("Overweight.");
            return false;
        }
        double requiredbattery = 2 * inputInKilos;
        return super.validate() && (getChargingStatus() - requiredbattery > 0);
    }

    @Override
    public double performTask() {
        super.performTask();
        System.out.println("Robot is lifting weight of " +inputInKilos +" kgs.");
        double consumedBattery = 2 * inputInKilos;
        updateChargingStatus(consumedBattery);
        return getChargingStatus();
    }
}
