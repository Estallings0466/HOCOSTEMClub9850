package org.firstinspires.ftc.teamcode.Luke.Suggestions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

@Autonomous (name = "Left Red", group = "Red")
public class NewLeftRed extends LinearOpMode {

xBotRobot robot = new xBotRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.init(hardwareMap);
        robot.initVuforia(hardwareMap);

        telemetry.addData(">", "Press Play to start");
        telemetry.update();

        //patiently waiting
        waitForStart();

        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(robot.relicTemplate);

        if (opModeIsActive()) {
            /*close the arm initially to hold glyph*/
            robot.closeClaw(1);
            sleep(100);

                /* Found an instance of the template.  */
            if (vuMark == RelicRecoveryVuMark.LEFT) {


                telemetry.addData("VuMark", "%s visible", vuMark);

            }else if(vuMark == RelicRecoveryVuMark.RIGHT){
                 /* Found an instance of the template. The following is for CENTER or UNKNOWN. */
                telemetry.addData("VuMark", "%s visible", vuMark);
            }else {
                telemetry.addData("VuMark", "%s visible", vuMark);

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
}