package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by emmab on 9/20/2017.
 */
@Disabled
@TeleOp (name = "Arm testing", group = "Testing")
public class servo_testing extends OpMode {
    DcMotor Front_Left;
    DcMotor Front_Right;
    DcMotor Back_Left;
    DcMotor Back_Right;
    DcMotor Glyph_Lift ;
    DcMotor RelicClaw;
    DcMotor RelicArm;
    ColorSensor Color_Sensor;
    Servo Jewel_Arm;
    Servo Left_Claw;
    Servo Right_Claw;
    Servo Relic_Servo;

    @Override
    public void init(){
        Front_Left = hardwareMap.dcMotor.get("FL");
        Front_Right = hardwareMap.dcMotor.get("FR");
        Back_Left = hardwareMap.dcMotor.get("BL");
        Back_Right = hardwareMap.dcMotor.get("BR");
        Glyph_Lift = hardwareMap.dcMotor.get("GL");
        RelicClaw = hardwareMap.dcMotor.get("REC");
        RelicArm = hardwareMap.dcMotor.get("RA");
        Color_Sensor = hardwareMap.colorSensor.get("CS");
        Jewel_Arm = hardwareMap.servo.get("JA");
        Left_Claw = hardwareMap.servo.get("LC");
        Right_Claw = hardwareMap.servo.get("RC");
        Relic_Servo = hardwareMap.servo.get("RS");
    }

    @Override
    public void loop() {
        float Lclaw = gamepad1.left_stick_y;
       // float Rclaw = gamepad1.left_stick_y;
        float ArmTest = gamepad1.right_stick_y;

        RelicClaw.setPower(Lclaw);
       // Right.setPosition(Rclaw);
        RelicArm.setPower(ArmTest);

      //  Right.setDirection(Servo.Direction.REVERSE);
    }


}
