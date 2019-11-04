package com.prototype.robot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RobotApplication {

    public static void main(String[] args) {
        SpringApplication.run(RobotApplication.class, args);

        IRobot robot = RobotImpl.builder()
                .id(1)
                .name("discovery")
                .chargingLevel(100)
                .build();

        robot.performTask();

        IRobot walkableRobotDecorator = new WalkableRobotDecorator(robot, 3.5);
        if(walkableRobotDecorator.validate()){
            System.out.println("Battery left: "+walkableRobotDecorator.performTask());
        }

        IRobot weightLiftableRobot = new WeightLifterRobotDecorator(robot, 12);
        if(weightLiftableRobot.validate()){
            System.out.println("Battery left: "+weightLiftableRobot.performTask());
        }

        IRobot walkableRobot = new WalkableRobotDecorator(robot, 2);
        IRobot runAndWeightLiftable = new WeightLifterRobotDecorator(walkableRobot, 3);
        if(runAndWeightLiftable.validate()){
            System.out.println("Battery left: "+runAndWeightLiftable.performTask());
        }

        ScannableRobotDecorator scannable = new ScannableRobotDecorator(robot);
        System.out.println("Display Price for item: "+scannable.scanItem(23434));

    }

}
