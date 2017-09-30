package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by emmab on 9/29/2017.
 */
@TeleOp (name = "Relic Arm", group = "Arms")
public class RelicArm extends OpMode {

    DcMotor RelicArm;

    @Override
    public void init(){
        RelicArm = hardwareMap.dcMotor.get("relic_arm");

    }

    @Override
    public void loop() {
        float relicarm = gamepad1.left_stick_y;

        RelicArm.setPower(relicarm);

    }
}
