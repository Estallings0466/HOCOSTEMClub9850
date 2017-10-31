package org.firstinspires.ftc.teamcode.Luke.Suggestions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous (name = "Left Red", group = "Red")
public class NewLeftRed extends LinearOpMode {

xBotRobot robot = new xBotRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);


        //patiently waiting
        waitForStart();
        if (opModeIsActive()) {
            robot.closeClaw(1);
            sleep(100);
            robot.lowerJewelArm();
            if (robot.isRed()) {
                robot.driveBackward(.01);
                sleep(1000);
                robot.raiseJewelArm();
                sleep(500);
                robot.turnLeft(.005);
                robot.driveForward(.2);
                sleep(500);

            } else {
                robot.driveForward(.01);
                sleep(1000);
                robot.raiseJewelArm();
                sleep(500);

            }
        }

    }
}