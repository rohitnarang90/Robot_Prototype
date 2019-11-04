package com.prototype.robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RobotApplicationTests {

	@Test
	void contextLoads() {
	}

	// Robot walks 3.5 kilometers
	@Test
	public void WalkValidTest() {
		RobotImpl robot = new RobotImpl(1, "test", 100);
		IRobot tester = new WalkableRobotDecorator(robot, 3.5);
		tester.validate();
		Assertions.assertEquals(30.0, tester.performTask());
	}

	// Robot lifts 8kg
	@Test
	public void WeightLiftValidTest() {
		RobotImpl robot = new RobotImpl(1, "test", 100);
		IRobot tester = new WeightLifterRobotDecorator(robot, 8);
		tester.validate();
		Assertions.assertEquals(true, tester.validate());
		Assertions.assertEquals(84.0, tester.performTask());
	}

	// Robot lifts 12kg
	@Test
	public void OverweightWeightLiftValidTest() {
		RobotImpl robot = new RobotImpl(1, "test", 100);
		IRobot tester = new WeightLifterRobotDecorator(robot, 12);
		Assertions.assertEquals(false, tester.validate());
	}

	// Robot lifts 3kg and walk for 2km
	@Test
	public void WalkAndWeightLiftValidTest() {
		RobotImpl robot = new RobotImpl(1, "test", 100);
		IRobot tester = new WeightLifterRobotDecorator(new WalkableRobotDecorator(robot, 2), 3);
		tester.validate();
		Assertions.assertEquals(54.0, tester.performTask());
	}

}
