package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Luke.Suggestions.xBotRobot;

/**
 * Created by emmab on 11/6/2017.
 */
@Autonomous(name = "Kauai LR", group = "Kauai")
@Disabled
public class KauaiLeftRed extends LinearOpMode {

    xBotRobot robot = new xBotRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData(">", "Press Play to start");
        telemetry.update();

        robot.init(hardwareMap);
        //patiently waiting
        waitForStart();


        while (opModeIsActive()) {
            robot.closeClaw(.5);
            Thread.sleep(1000);
            robot.liftGlyph(1);
            Thread.sleep(1000);
            robot.driveForward(.15);
            Thread.sleep(500);
            robot.turnRight(.3);
            robot.driveForward(.4);
            Thread.sleep(1000);
            robot.openClaw(1);
            Thread.sleep(1000);
            robot.driveBackward(.1);
            stop();


        }
    }
}
