package org.firstinspires.ftc.teamcode.Luke.Suggestions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous (name = "Right RedNew", group = "Main")

public class NewRightRed extends LinearOpMode {

    xBotRobot robot = new xBotRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.initVuforia(hardwareMap);

        telemetry.addData(">", "Press Play to start");
        telemetry.update();


        //patiently waiting
        waitForStart();



        while (opModeIsActive()) {
            /*close the arm initially to hold glyph*/
            robot.closeClaw(1);
            sleep(100);
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(robot.relicTemplate);
                /* Found an instance of the template.  */
            if (vuMark == RelicRecoveryVuMark.LEFT) {
                telemetry.addData("VuMark", "%s visible", vuMark);
                robot.lowerRightArm();
                if (robot.isRedRight()) {
                    robot.driveBackward(.1);
                    Thread.sleep(1000);
                    robot.raiseArms();
                    Thread.sleep(500);
                    robot.driveForward(.2);
                    Thread.sleep(500);
                    robot.slewLeft(.5);



                } else {
                    robot.driveForward(.1);
                    Thread.sleep(1000);
                    robot.raiseArms();
                    Thread.sleep(500);
                    robot.slewLeft(.5);

                }
                robot.driveForward(.5);
                stop();

            }else if(vuMark == RelicRecoveryVuMark.RIGHT){
                 /* Found an instance of the template. The following is for CENTER or UNKNOWN. */
                telemetry.addData("VuMark", "%s visible", vuMark);
                robot.lowerRightArm();
                if (robot.isRedRight()) {
                    robot.driveBackward(.1);
                    Thread.sleep(1000);
                    robot.raiseArms();
                    Thread.sleep(500);
                    robot.driveForward(.2);
                    Thread.sleep(500);
                    robot.slewLeft(.7);



                } else {
                    robot.driveForward(.1);
                    Thread.sleep(1000);
                    robot.raiseArms();
                    Thread.sleep(500);
                    robot.slewLeft(.7);

                }
                robot.driveForward(.5);
                stop();
            }else {
                telemetry.addData("VuMark", "%s visible", vuMark);

                robot.lowerRightArm();
                if (robot.isRedRight()) {
                    robot.driveBackward(.1);
                    Thread.sleep(1000);
                    robot.raiseArms();
                    Thread.sleep(500);
                    robot.driveForward(.2);
                    Thread.sleep(500);
                    robot.slewLeft(.6);



                } else {
                    robot.driveForward(.1);
                    Thread.sleep(1000);
                    robot.raiseArms();
                    Thread.sleep(500);
                    robot.slewLeft(.6);

                }
                robot.driveForward(.5);
                stop();
            }
        }

    }
}