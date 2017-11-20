package org.firstinspires.ftc.teamcode.Luke.Suggestions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous (name = "Right BlueNew", group = "Main")
//@Disabled
public class NewRightBlue extends LinearOpMode {

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
            sleep(100);
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(robot.relicTemplate);
                /* Found an instance of the template.  */
            if (vuMark == RelicRecoveryVuMark.LEFT) {
                telemetry.addData("VuMark", "%s visible", vuMark);
                sleep(1000);
                robot.closeClaw(1);
                Thread.sleep(500);
                robot.liftGlyph(.5);
                Thread.sleep(500);
                robot.lowerLeftArm();
                Thread.sleep(1000);
                if (robot.isRedLeft()) {
                    sleep(1000);
                    robot.driveBackward(.3);
                    Thread.sleep(500);
                    robot.raiseArms();
                    robot.driveForward(.5);
                    Thread.sleep(500);
                    robot.slewRight(6);
                    Thread.sleep(500);

                } else {
                    sleep(1000);
                    robot.driveForward(.3);
                    Thread.sleep(500);
                    robot.raiseArms();
                    Thread.sleep(500);
                    robot.slewRight(6);
                    Thread.sleep(500);

                }
                robot.turnRight(.15);
                Thread.sleep(500);
                robot.driveForward(.5);
                Thread.sleep(500);
                robot.openClaw(1);
                Thread.sleep(500);
                robot.driveBackward(.3);
                robot.raiseArms();
                robot.raiseArms();
                Thread.sleep(500);
                stop();

            } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
                 /* Found an instance of the template. The following is for CENTER or UNKNOWN. */
                telemetry.addData("VuMark", "%s visible", vuMark);
                sleep(1000);
                robot.closeClaw(1);
                Thread.sleep(500);
                robot.liftGlyph(.5);
                Thread.sleep(500);
                robot.lowerLeftArm();
                sleep(1000);sleep(1000);
                robot.driveBackward(.3);
                Thread.sleep(500);
                robot.raiseArms();
                robot.driveForward(.5);
                Thread.sleep(500);
                robot.slewRight(6);
                Thread.sleep(500);
                if (robot.isRedLeft()) {


                } else {
                    sleep(1000);
                    robot.driveForward(.3);
                    Thread.sleep(500);
                    robot.raiseArms();
                    Thread.sleep(500);
                    robot.slewRight(6);
                    Thread.sleep(500);

                }
                robot.turnRight(.3);
                Thread.sleep(500);
                robot.driveForward(.5);
                Thread.sleep(500);
                robot.openClaw(1);
                Thread.sleep(500);
                robot.driveBackward(.5);
                robot.raiseArms();
                robot.raiseArms();
                Thread.sleep(500);
                stop();

            } else {
                telemetry.addData("VuMark", "%s visible", vuMark);
                sleep(1000);
                robot.closeClaw(1);
                Thread.sleep(500);
                robot.liftGlyph(.5);
                Thread.sleep(500);
                robot.lowerLeftArm();
                Thread.sleep(1000); sleep(1000);
                robot.driveBackward(.3);
                Thread.sleep(500);
                robot.raiseArms();
                robot.driveForward(.5);
                Thread.sleep(500);
                robot.slewRight(6);
                Thread.sleep(500);
                if (robot.isRedLeft()) {


                } else {
                    sleep(1000);
                    robot.driveForward(.3);
                    Thread.sleep(500);
                    robot.raiseArms();
                    Thread.sleep(500);
                    robot.slewRight(6);
                    Thread.sleep(500);

                }

                robot.turnRight(.2);
                Thread.sleep(500);
                robot.driveForward(.2);
                Thread.sleep(500);
                robot.openClaw(1);
                Thread.sleep(500);
                robot.driveBackward(.1);
                robot.raiseArms();
                robot.raiseArms();
                Thread.sleep(500);
                stop();
            }
        }

    }
}
