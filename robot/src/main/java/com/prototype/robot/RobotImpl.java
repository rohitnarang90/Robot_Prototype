package com.prototype.robot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RobotImpl implements IRobot {

    private int id;
    private String name;
    private double chargingLevel;

    @Override
    public void updateChargingStatus(double consumedChargingLevel) {
        setChargingLevel(getChargingStatus() - consumedChargingLevel);
    }

    @Override
    public double getChargingStatus() {
        return getChargingLevel();
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public double performTask() {
        return 0;
    }
}
