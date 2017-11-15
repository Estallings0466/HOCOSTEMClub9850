package org.firstinspires.ftc.teamcode.Luke.Suggestions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous (name = "Left BlueNew", group = "Main")

public class NewLeftBlue extends LinearOpMode {

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
                telemetry.update();

                robot.lowerLeftArm();
                if (robot.isRedLeft()) {
                    robot.closeClaw(.5);
                    Thread.sleep(1000);
                    robot.driveForward(.5);
                    Thread.sleep(500);
                    robot.raiseArms();
                    robot.liftGlyph(1);
                    Thread.sleep(1000);
                    robot.driveForward(.2);
                    Thread.sleep(500);
                    robot.turnLeft(.3);
                    robot.driveForward(.4);
                    Thread.sleep(1000);
                    robot.openClaw(1);
                    Thread.sleep(1000);


                } else {
                    robot.driveBackward(.1);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);
                    robot.closeClaw(.5);
                    Thread.sleep(1000);
                    robot.driveForward(.5);
                    Thread.sleep(500);
                    robot.raiseArms();
                    robot.liftGlyph(1);
                    Thread.sleep(1000);
                    robot.driveForward(.2);
                    Thread.sleep(500);
                    robot.turnLeft(.3);
                    robot.driveForward(.4);
                    Thread.sleep(1000);
                    robot.openClaw(1);
                    Thread.sleep(1000);

                }
                stop();

            } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
                 /* Found an instance of the template. The following is for CENTER or UNKNOWN. */
                telemetry.addData("VuMark", "%s visible", vuMark);
                telemetry.update();
                if (robot.isRedLeft()) {
                    robot.closeClaw(.5);
                    Thread.sleep(1000);
                    robot.driveForward(.5);
                    Thread.sleep(500);
                    robot.raiseArms();
                    robot.liftGlyph(1);
                    Thread.sleep(1000);
                    robot.driveForward(.2);
                    Thread.sleep(500);
                    robot.turnLeft(.3);
                    robot.driveForward(.4);
                    Thread.sleep(1000);
                    robot.openClaw(1);
                    Thread.sleep(1000);


                } else {
                    robot.driveBackward(.1);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);
                    robot.closeClaw(.5);
                    Thread.sleep(1000);
                    robot.driveForward(.5);
                    Thread.sleep(500);
                    robot.raiseArms();
                    robot.liftGlyph(1);
                    Thread.sleep(1000);
                    robot.driveForward(.2);
                    Thread.sleep(500);
                    robot.turnLeft(.3);
                    robot.driveForward(.4);
                    Thread.sleep(1000);
                    robot.openClaw(1);
                    Thread.sleep(1000);

                }
                stop();

            } else {
                telemetry.addData("VuMark", "%s visible", vuMark);

                robot.lowerLeftArm();
                sleep(1000);
                if (robot.isRedLeft()) {
                    robot.closeClaw(.5);
                    Thread.sleep(1000);
                    robot.driveForward(.5);
                    Thread.sleep(500);
                    robot.raiseArms();
                    robot.liftGlyph(1);
                    Thread.sleep(1000);
                    robot.driveForward(.2);
                    Thread.sleep(500);
                    robot.turnLeft(.3);
                    robot.driveForward(.4);
                    Thread.sleep(1000);
                    robot.openClaw(1);
                    Thread.sleep(1000);


                } else {
                    robot.driveBackward(.1);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);
                    robot.closeClaw(.5);
                    Thread.sleep(1000);
                    robot.driveForward(.5);
                    Thread.sleep(500);
                    robot.raiseArms();
                    robot.liftGlyph(1);
                    Thread.sleep(1000);
                    robot.driveForward(.2);
                    Thread.sleep(500);
                    robot.turnLeft(.3);
                    robot.driveForward(.4);
                    Thread.sleep(1000);
                    robot.openClaw(1);
                    Thread.sleep(1000);

                }
                stop();

            }
        }
    }
}
