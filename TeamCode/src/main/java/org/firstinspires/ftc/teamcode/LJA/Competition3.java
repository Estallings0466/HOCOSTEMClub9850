package org.firstinspires.ftc.teamcode.LJA;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
@Disabled
@TeleOp(name="Competition3", group="Linear Opmode")
//Disabled

public class Competition3 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();

    DcMotor leftMotor;
    DcMotor rightMotor;
    DcMotor ElevatorMotor;
    Servo BarLeft;
    Servo BarRight;

    double xMode = 0;
    double yMode = 0;
    @Override
    public void runOpMode(){
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        BarRight = hardwareMap.servo.get("BarRight");
        BarLeft = hardwareMap.servo.get("BarLeft");
        ElevatorMotor = hardwareMap.dcMotor.get("ElevatorMotor");

        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();

            if (gamepad1.left_stick_y != 0) {
                leftMotor.setPower(-gamepad1.left_stick_y/3);
                rightMotor.setPower(-gamepad1.left_stick_y/3);
            } else {
                leftMotor.setPower(0.0);
                rightMotor.setPower(0.0);

                double power = 1;

                if (gamepad1.left_stick_x <0) {
                    leftMotor.setPower(-power);
                    rightMotor.setPower(power);
                } else {
                    leftMotor.setPower(0.0);
                    rightMotor.setPower(0.0);

                    if (gamepad1.left_stick_x >0) {
                        leftMotor.setPower(power);
                        rightMotor.setPower(-power);
                    }
                    else {
                        leftMotor.setPower(0.0);
                        rightMotor.setPower(0.0);

                        if (gamepad1.right_stick_y !=0) {
                            leftMotor.setPower(-gamepad1.right_stick_y);
                            rightMotor.setPower(-gamepad1.right_stick_y);
                        }
                        else {
                            leftMotor.setPower(0.0);
                            rightMotor.setPower(0.0);
                        }
                    }
                }
            }
            //drive

            //elevator

            double powerS = 0.4;

            if (gamepad1.a == true) {
                ElevatorMotor.setPower(powerS);
            }
            else {
                ElevatorMotor.setPower(0.0);
            }

            double powerE = 0.7;

            if (gamepad1.y == true) {
                ElevatorMotor.setPower(-powerE);
            }
            else {
                ElevatorMotor.setPower(0.0);
            }
            //elevator

            //BlockGrabber

            if (gamepad1.left_bumper == true) {
                BarRight.setPosition(0);
                BarLeft.setPosition(0);
            }

            if (gamepad1.right_bumper == true) {
                BarLeft.setPosition(1);
                BarRight.setPosition(1);
            }
            //BlockGrabber
        }
    }

}