package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by emmab on 11/1/2017.
 */
@TeleOp (name = "Glyph Test")
public class GlyphTest extends OpMode{
    DcMotor Glyph_Lift ;
    DcMotor Glyph_Claw;

    @Override
    public void init(){

        Glyph_Lift = hardwareMap.dcMotor.get("GL");
        Glyph_Claw =hardwareMap.dcMotor.get("GC");
    }
    @Override
    public void loop() {

        float Lift = gamepad1.right_stick_y;
        float Claw = gamepad1.left_stick_y;

        Glyph_Lift.setPower(Lift);
        Glyph_Claw.setPower(Claw);
    }
}


