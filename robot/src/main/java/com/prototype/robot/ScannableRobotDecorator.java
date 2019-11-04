package com.prototype.robot;

import java.util.Random;

public class ScannableRobotDecorator extends BaseRobotDecorator {

    public ScannableRobotDecorator(IRobot robot) {
        super(robot);
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
        return super.validate() && true;
    }

    @Override
    public double performTask() {
        return super.performTask();
    }

    public double scanItem(int barCode) {
        Random random = new Random();
        int generatedNumber = random.nextInt(barCode);
        if(generatedNumber < 50){
            System.out.println("Scan Failure");
            return 0;
        }
        return generatedNumber;
    }

}
