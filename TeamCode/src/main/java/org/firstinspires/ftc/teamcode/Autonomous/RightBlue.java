package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by emmab on 9/28/2017.
 */
@Autonomous (name = "RightBlue", group = "Blue")
@Disabled
public class RightBlue extends LinearOpMode {

    DcMotor Front_Left;
    DcMotor Front_Right;
    DcMotor Back_Left;
    DcMotor Back_Right;
   // DcMotor Glyph_Lift;
    ColorSensor Color_Sensor;
    Servo Jewel_Arm;
   // Servo Left_Grabber;
    //Servo Right_Grabber;

    private ElapsedTime runtime = new ElapsedTime();
    private ElapsedTime timeAfterReset = new ElapsedTime();

    public void hardwareMapping() {
        Front_Left = hardwareMap.dcMotor.get("FL");
        Front_Right = hardwareMap.dcMotor.get("FR");
        Back_Left = hardwareMap.dcMotor.get("BL");
       // Glyph_Lift = hardwareMap.dcMotor.get("GL");
        Color_Sensor = hardwareMap.colorSensor.get("CS");
        Jewel_Arm = hardwareMap.servo.get("JA");
       // Left_Grabber = hardwareMap.servo.get("LG");
       // Right_Grabber = hardwareMap.servo.get("RG");

        Front_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        Back_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        Color_Sensor.enableLed(true);
    }

    public void driveForward(double driveForward) throws InterruptedException {
        Front_Left.setPower(1);
        Front_Right.setPower(1);
        Back_Left.setPower(1);
        Back_Right.setPower(1 );

        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void driveBackward(long backward) throws InterruptedException {
        Front_Left.setPower(-1);
        Front_Right.setPower(-1);
        Back_Left.setPower(-1);
        Back_Right.setPower(-1 );

        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);

    }

    protected void senseRed(double sense) throws InterruptedException {
        Jewel_Arm.setPosition(1);
        sleep(2000);

        if (Color_Sensor.red() >= 4 && Color_Sensor.blue() >= 0) {
            driveBackward(1);

            sleep(500);
        } else {
            driveForward(1);

            sleep(500);
        }

        Jewel_Arm.setPosition(0);

    }


    public void close(double close) throws InterruptedException {
        //close the two servos around the glyph
    }

    public void rise(double rise) throws InterruptedException {
        //gotta turn at some point, so we'll make it turn
    }



    //The above is all we'll need for now, we can add more as the plan develops more

    @Override
    public void runOpMode() throws InterruptedException {
        //gotta let names be known...
        hardwareMapping();


        //patiently waiting
        waitForStart();
        if (opModeIsActive()) {

            sleep(100);
            //servos close around glyph
            senseRed(1); //servo arm is lowered, color sensor scans for red/blue, moves in certain direction,lifts servo arm
            //drives forward

        }

    }
}