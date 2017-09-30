package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by emmab on 9/20/2017.
 */
@TeleOp (name = "Relic Test", group = "Testing")
public class servo_testing extends OpMode {

    Servo Left;
   // Servo Right;
   // DcMotor RelicArm;

    @Override
    public void init(){
        Left = hardwareMap.servo.get("left_claw");
        //Right = hardwareMap.servo.get("right_claw");
        //RelicArm = hardwareMap.dcMotor.get("relic_arm");

        Left.setDirection(Servo.Direction.REVERSE);
    }

    @Override
    public void loop() {
        float Lclaw = gamepad1.left_stick_y;
       // float Rclaw = gamepad1.left_stick_y;
       // float relicarm = gamepad1.right_stick_y;

        Left.setPosition(Lclaw);
       // Right.setPosition(Rclaw);
        //RelicArm.setPower(relicarm);
    }


}
