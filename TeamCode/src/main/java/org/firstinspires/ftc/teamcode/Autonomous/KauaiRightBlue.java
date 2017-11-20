package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Luke.Suggestions.xBotRobot;

/**
 * Created by emmab on 11/6/2017.
 */
@Autonomous (name = "kauai RB", group = "Kauai")

public class KauaiRightBlue extends LinearOpMode {

    xBotRobot robot = new xBotRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData(">", "Press Play to start");
        telemetry.update();
        robot.init(hardwareMap);
        //patiently waiting
        waitForStart();
          robot.closeClaw(.5);
            Thread.sleep(1000);
            robot.liftGlyph(1);
            Thread.sleep(1000);
       /*    robot.lowerLeftArm();
            Thread.sleep(2000);
        robot.LColor_Sensor.enableLed(true);

           while ((robot.LColor_Sensor.red() < 4)& (robot.LColor_Sensor.blue() < 4) )
        {

        }
            if (robot.LColor_Sensor.red() > 4)
            {
                telemetry.addData("Red Value:", robot.LColor_Sensor.red());
                telemetry.addData("Blue Value:", robot.LColor_Sensor.blue());
                telemetry.update();
                robot.driveBackward(.15);
                Thread.sleep(1000);

            }else {
                telemetry.addData("Red Value:", robot.LColor_Sensor.red());
                telemetry.addData("Blue Value:", robot.LColor_Sensor.blue());
                telemetry.update();
                robot.driveForward(.15);
                Thread.sleep(1000);
            }

robot.LColor_Sensor.enableLed(false);
          robot.raiseArms();
        Thread.sleep(1000);*/
          robot.driveForward(.15);
          Thread.sleep(1000);
          robot.slewRight(.5);
          Thread.sleep(500);
          robot.driveForward(.15);
          Thread.sleep(1000);
          robot.openClaw(1);
          Thread.sleep(1000);
        robot.openClaw(1);
        Thread.sleep(1000);
        robot.driveBackward(.1);

          stop();

        }
    }

