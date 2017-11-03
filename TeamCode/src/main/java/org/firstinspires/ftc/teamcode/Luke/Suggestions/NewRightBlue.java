package org.firstinspires.ftc.teamcode.Luke.Suggestions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous (name = "Right BlueNew", group = "Blue")
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
                robot.closeClaw(1);
                sleep(100);
                RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(robot.relicTemplate);
                /* Found an instance of the template.  */
                if (vuMark == RelicRecoveryVuMark.LEFT) {


                    telemetry.addData("VuMark", "%s visible", vuMark);

                }else if(vuMark == RelicRecoveryVuMark.RIGHT){
                 /* Found an instance of the template. The following is for CENTER or UNKNOWN. */
                    telemetry.addData("VuMark", "%s visible", vuMark);
                }else if(vuMark == RelicRecoveryVuMark.CENTER){
                    telemetry.addData("VuMark", "%s visible", vuMark);

                    robot.lowerLeftArm();
                    if (robot.isRedLeft()) {
                        robot.driveForward(.01);
                        sleep(1000);
                        robot.raiseArms();
                        sleep(500);
                        robot.driveForward(.06);
                        sleep(1000);
                        robot.driveBackward(.03);
                        sleep(1000);


                    } else {
                        robot.driveBackward(.01);
                        sleep(1000);
                        robot.raiseArms();
                        sleep(500);
                        robot.driveForward(.03);
                        sleep(1000);

                    }
                }
            }

        }
    }

