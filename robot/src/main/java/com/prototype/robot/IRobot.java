package com.prototype.robot;

public interface IRobot {

    public boolean validate();
    public double performTask();
    public void updateChargingStatus(double consumedChargingLevel);
    public double getChargingStatus();

}
