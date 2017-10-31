package org.firstinspires.ftc.teamcode.Luke.Suggestions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "Left Blue", group = "Blue")
public class NewLeftBlue extends LinearOpMode {

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
                robot.driveForward(.01);
                sleep(1000);
                robot.raiseJewelArm();
                sleep(500);


            } else {
                robot.driveBackward(.01);
                sleep(1000);
                robot.raiseJewelArm();
                sleep(500);

            }
        }

    }
}
