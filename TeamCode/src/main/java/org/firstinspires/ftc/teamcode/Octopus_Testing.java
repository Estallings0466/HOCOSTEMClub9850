package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by emmab on 9/6/2017.
 */


@TeleOp(name = "Octopus_Testing", group = "Teleop")
@Disabled
public class Octopus_Testing extends OpMode
{

    DcMotor North;
    DcMotor South;
    DcMotor East;
    DcMotor West;
    @Override
    public void init() {
        North = hardwareMap.dcMotor.get("North_Drive");
        South = hardwareMap.dcMotor.get("South_Drive");
        East = hardwareMap.dcMotor.get("East_Drive");
        West = hardwareMap.dcMotor.get("West_Drive");

    }

    @Override
    public void loop() {
        float N = gamepad1.left_stick_x;
        float S = gamepad1.right_stick_x;
        float W = gamepad1.left_stick_y;
        float E = gamepad1.right_stick_x;

        North.setPower(N);
        South.setPower(S);
        West.setPower(W);
        East.setPower(E);

        North.setDirection(DcMotorSimple.Direction.REVERSE);
        West.setDirection(DcMotorSimple.Direction.REVERSE);

    }
}
