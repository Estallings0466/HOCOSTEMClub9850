package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by emmab on 10/6/2017.
 */
@TeleOp (name = "ProManual", group = "Omni manual" )
public class ProManual extends OpMode{
    DcMotor Front_Left;
    DcMotor Front_Right;
    DcMotor Back_Left;
    DcMotor Back_Right;
    DcMotor Glyph_Lift;
    Servo Left_Claw;
    Servo Right_Claw;
    Servo Jewel_Arm;

    @Override
    public void init() {
        Front_Left = hardwareMap.dcMotor.get("FL");
        Front_Right = hardwareMap.dcMotor.get("FR");
        Back_Left = hardwareMap.dcMotor.get("BL");
        Back_Right = hardwareMap.dcMotor.get("BR");
        Glyph_Lift = hardwareMap.dcMotor.get("GL");
        Jewel_Arm = hardwareMap.servo.get("JA");
        Left_Claw = hardwareMap.servo.get("LC");
        Right_Claw = hardwareMap.servo.get("RC");

        Front_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        Back_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        Right_Claw.setDirection(Servo.Direction.REVERSE);


    }

    @Override
    public void loop() {
        float left = gamepad1.left_stick_y;
        float right = gamepad1.right_stick_y;
        float arm = gamepad1.right_trigger;
        float lift = gamepad2.left_stick_y;
        float claw = gamepad2.right_stick_y;

        Front_Left.setPower(left);
        Back_Left.setPower(left);
        Front_Right.setPower(right);
        Back_Right.setPower(right);
        Glyph_Lift.setPower(lift);
        Left_Claw.setPosition(claw);
        Right_Claw.setPosition(claw);

    }
}
