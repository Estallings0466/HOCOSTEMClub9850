package org.firstinspires.ftc.teamcode.Luke.Suggestions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous (name = "Right BlueNew", group = "Use These")
//@Disabled
public class NewRightBlue extends LinearOpMode {

    xBotRobot robot = new xBotRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.initVuforia(hardwareMap);

        telemetry.addData(">", "Press Play to start");
        telemetry.update();

        VuforiaTrackables relicTrackables = robot.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        waitForStart();
        //patiently waiting
        waitForStart();
        relicTrackables.activate();

        while (opModeIsActive()) {
            /*close the arm initially to hold glyph*/
            robot.closeClaw(1);
            sleep(100);
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
                /* Found an instance of the template.  */
            if (vuMark == RelicRecoveryVuMark.LEFT) {
                telemetry.addData("VuMark", "%s visible", vuMark);
                telemetry.update();
                robot.lowerLeftArm();
                if (robot.isRedLeft()) {
                    robot.driveForward(.45);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);


                } else {
                    robot.driveBackward(.45);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);
                    robot.driveForward(.45);

                }
                robot.driveForward(.3);
                robot.slewRight(1);
                stop();
            } else if (vuMark == RelicRecoveryVuMark.RIGHT) {
                 /* Found an instance of the template. The following is for CENTER or UNKNOWN. */
                telemetry.addData("VuMark", "%s visible", vuMark);
                telemetry.update();
                robot.lowerLeftArm();
                if (robot.isRedLeft()) {
                    robot.driveForward(.45);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);


                } else {
                    robot.driveBackward(.45);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);



                    robot.driveForward(1);

                }
                robot.driveForward(.3);
                robot.slewRight(1);
                stop();
            } else {
                telemetry.addData("VuMark", "%s visible", vuMark);
                telemetry.update();
                robot.lowerLeftArm();
                if (robot.isRedLeft()) {
                    robot.driveForward(.45);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);


                } else {
                    robot.driveBackward(.45);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);



                    robot.driveForward(1);

                }
                robot.driveForward(.3);
                robot.slewRight(1);
                stop();
            }
        }

    }
}



