package org.firstinspires.ftc.teamcode.Luke.Suggestions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous (name = "Right RedNew", group = "Red")
public class NewRightRed extends LinearOpMode {

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
                robot.lowerRightArm();
                if (robot.isRedRight()) {
                    robot.driveBackward(.1);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);
                    robot.driveForward(.2);


                } else {
                    robot.driveForward(.1);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);

                }
                robot.driveForward(.5);
                robot.slewLeft(.5);
                stop();

            }else if(vuMark == RelicRecoveryVuMark.RIGHT){
                 /* Found an instance of the template. The following is for CENTER or UNKNOWN. */
                telemetry.addData("VuMark", "%s visible", vuMark);
                telemetry.update();
                robot.lowerRightArm();
                if (robot.isRedRight()) {
                    robot.driveBackward(.9);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);
                    robot.driveForward(.9);
                    sleep(1000);


                } else {
                    robot.driveForward(.9);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);

                }
                robot.driveForward(1);
                robot.slewLeft(.5);
                stop();
            }else {
                telemetry.addData("VuMark", "%s visible", vuMark);
                telemetry.update();
                robot.lowerRightArm();
                if (robot.isRedRight()) {
                    robot.driveBackward(.1);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);
                    robot.driveForward(.2);


                } else {
                    robot.driveForward(.1);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);

                }
                robot.driveForward(.5);
                robot.slewRight(.5);
                stop();
            }
        }

    }
}