package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by emmab on 9/20/2017.
 */
@TeleOp (name = "Arm testing", group = "Testing")
public class servo_testing extends OpMode {
    DcMotor Arm;
    Servo Left;
    Servo Right;
    //DcMotor LeftForward;
    //DcMotor LeftBack;
    //DcMotor RightForward;
    //DcMotor RightBack;
//test mine


    @Override
    public void init(){
        Arm = hardwareMap.dcMotor.get("A");
        Left = hardwareMap.servo.get("LC");
        Right = hardwareMap.servo.get("RC");


       Left.setDirection(Servo.Direction.FORWARD);
    }

    @Override
    public void loop() {
        float Lclaw = gamepad1.left_stick_y;
        float Rclaw = gamepad1.left_stick_y;
        float ArmTest = gamepad1.right_stick_y;

        Left.setPosition(Lclaw);
        Right.setPosition(Rclaw);
        Arm.setPower(ArmTest);

        Right.setDirection(Servo.Direction.REVERSE);
    }


}
