package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import static com.qualcomm.robotcore.hardware.configuration.BuiltInConfigurationType.COLOR_SENSOR;

/**
 * Created by emmab on 9/15/2017.
 */
@Autonomous (name = "RedAuto", group = "Red")
@Disabled
public class Octopus_BR extends LinearOpMode {

    DcMotor Front_Left;
    DcMotor Front_Right;
    DcMotor Back_Left;
    DcMotor Back_Right;
    ColorSensor Color_Sensor;
    Servo Jewel_Arm;

    private ElapsedTime runtime = new ElapsedTime();
    private ElapsedTime timeAfterReset = new ElapsedTime();

    public void hardwareMapping() {
        Front_Left = hardwareMap.dcMotor.get("FL");
        Front_Right = hardwareMap.dcMotor.get("FR");
        Back_Left = hardwareMap.dcMotor.get("BL");
        Back_Right = hardwareMap.dcMotor.get("BR");
        Color_Sensor = hardwareMap.colorSensor.get("CS");
        Jewel_Arm = hardwareMap.servo.get("JA");

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


    }

    protected void senseRed(double sense) throws InterruptedException {
        runtime.reset();

        if (opModeIsActive()) {

            Jewel_Arm.setPosition(1);

            while ((Color_Sensor.red() >= 8)){
                driveForward(1);
                stopmotors(1);
            }

            }


            if (!opModeIsActive()) {

                return;


        }
    }


    private void driveByTime(double v, double v1) {
    }




    public void down(double down) throws InterruptedException {
        //May combine this with scan, not sure...but this is where teh slidey thing hits the ball

    }

    public void turn(double turn) throws InterruptedException {
        //gotta turn at some point, so we'll make it turn
    }

    public void arm(double arm) throws InterruptedException {
        //Gonna change name, this is for the arm thing that puts the glyph down
    }

    public void stopmotors(long stopmotors) throws InterruptedException {
        //just stop motion and stuff
    }

    //The above is all we'll need for now, we can add more as the plan develops more

    @Override
    public void runOpMode() throws InterruptedException {
        //gotta let names be known...
        hardwareMapping();


        //patiently waiting
        waitForStart();
        if (opModeIsActive()) {
            senseRed(1);

        }

    }
}

