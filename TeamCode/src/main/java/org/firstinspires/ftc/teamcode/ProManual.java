package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
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
@Disabled
public class ProManual extends OpMode{
    DcMotor Front_Left;
    DcMotor Front_Right;
    DcMotor Back_Left;
    DcMotor Back_Right;
    DcMotor Glyph_Lift ;
    DcMotor RelicClaw;
    DcMotor RelicArm;
    ColorSensor Color_Sensor;
    Servo Jewel_Arm;
    Servo LeftB_Claw;
    Servo LeftT_Claw;
    Servo RightB_Claw;
    Servo RightT_Claw;
    Servo Relic_Servo;

    @Override
    public void init() {
        Front_Left = hardwareMap.dcMotor.get("FL");
        Front_Right = hardwareMap.dcMotor.get("FR");
        Back_Left = hardwareMap.dcMotor.get("BL");
        Back_Right = hardwareMap.dcMotor.get("BR");
        Glyph_Lift = hardwareMap.dcMotor.get("GL");
        RelicClaw = hardwareMap.dcMotor.get("REC");
        RelicArm = hardwareMap.dcMotor.get("RA");
        Color_Sensor = hardwareMap.colorSensor.get("CS");
        Jewel_Arm = hardwareMap.servo.get("JA");
        LeftB_Claw = hardwareMap.servo.get("LBC");
        LeftT_Claw =hardwareMap.servo.get("LTC");
        RightB_Claw = hardwareMap.servo.get("RBC");
        RightT_Claw = hardwareMap.servo.get("RTC");
        Relic_Servo = hardwareMap.servo.get("RS");

        Front_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        Back_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        RightT_Claw.setDirection(Servo.Direction.REVERSE);
        RightB_Claw.setDirection(Servo.Direction.REVERSE);


    }

    @Override
    public void loop() {
        float left = gamepad1.left_stick_y;
        float right = gamepad1.right_stick_y;
        float arm = gamepad1.right_trigger;
        float lift = gamepad2.left_stick_y;
        float Grip = gamepad2.right_stick_y;

        Front_Left.setPower(left);
        Back_Left.setPower(left);
        Front_Right.setPower(right);
        Back_Right.setPower(right);
        Glyph_Lift.setPower(lift);
        RelicArm.setPower(arm);
        LeftT_Claw.setPosition(Grip);
        LeftB_Claw.setPosition(Grip);
        RightT_Claw.setPosition(Grip);
        RightB_Claw.setPosition(Grip);

    }
}
