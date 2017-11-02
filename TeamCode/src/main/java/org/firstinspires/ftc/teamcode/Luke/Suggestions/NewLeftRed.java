package org.firstinspires.ftc.teamcode.Luke.Suggestions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous (name = "Left RedNew", group = "Red")
//@Disabled
public class NewLeftRed extends LinearOpMode {

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

        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);

        if (opModeIsActive()) {
            /*close the arm initially to hold glyph*/
            robot.closeClaw(1);
            sleep(100);

                /* Found an instance of the template.  */
            if (vuMark == RelicRecoveryVuMark.LEFT) {


                telemetry.addData("VuMark", "%s visible", vuMark);
                telemetry.update();

            }else if(vuMark == RelicRecoveryVuMark.RIGHT){
                 /* Found an instance of the template. The following is for CENTER or UNKNOWN. */
                telemetry.addData("VuMark", "%s visible", vuMark);
                telemetry.update();
            }else {
                telemetry.addData("VuMark", "%s visible", vuMark);
                telemetry.update();

                robot.lowerRightArm();
                if (robot.isRedRight()) {
                    robot.driveBackward(.01);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);
                    robot.turnLeft(.005);
                    robot.driveForward(.2);
                    sleep(500);

                } else {
                    robot.driveForward(.01);
                    sleep(1000);
                    robot.raiseArms();
                    sleep(500);

                }
            }
        }

    }
}