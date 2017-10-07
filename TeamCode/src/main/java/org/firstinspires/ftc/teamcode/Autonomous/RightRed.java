package org.firstinspires.ftc.teamcode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by emmab on 9/15/2017.
 */
@Autonomous (name = "Right", group = "Red")
public class RightRed extends LinearOpMode {

    DcMotor Front_Left;
    DcMotor Front_Right;
    DcMotor Back_Left;
    DcMotor Back_Right;
    ColorSensor Color_Sensor;
    Servo Jewel_Arm;

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
        Front_Left.setPower(.2);
        Front_Right.setPower(.2);
        Back_Left.setPower(.2);
        Back_Right.setPower(.2);

        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void driveBackward(long backward) throws InterruptedException {
        Front_Left.setPower(-.2);
        Front_Right.setPower(-.2);
        Back_Left.setPower(-.2);
        Back_Right.setPower(-.2);

        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);

    }

    protected void senseRed(double sense) throws InterruptedException {
        Jewel_Arm.setPosition(-1);
        sleep(2000);

        if (Color_Sensor.red() >= 4 ) {
            turnright(2);
            sleep(1000);
            Jewel_Arm.setPosition(1);
            sleep(500);
        } else {
           turnleft(1);
            sleep(1000);
            Jewel_Arm.setPosition(1);
            sleep(500);
        }

    }

    public void turnleft(double turnleft) throws InterruptedException {
        Front_Left.setPower(-.1);
        Front_Right.setPower(.1);
        Back_Left.setPower(-.1);
        Back_Right.setPower(.1);

        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void turnright(double turnright) throws InterruptedException{
        Front_Left.setPower(.1);
        Front_Right.setPower(-.1);
        Back_Left.setPower(.1);
        Back_Right.setPower(-.1);

        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
        }

public void driveBackward_Slo(double backward_slo) throws InterruptedException {
    Front_Left.setPower(-.1);
    Front_Right.setPower(-.1);
    Back_Left.setPower(-.1);
    Back_Right.setPower(-.1);

    sleep(1000);
    Front_Left.setPower(0);
    Front_Right.setPower(0);
    Back_Left.setPower(0);
    Back_Right.setPower(0);
        }

public void driveForward_Slo(long forward_slo) throws InterruptedException {
    Front_Left.setPower(.1);
    Front_Right.setPower(.1);
    Back_Left.setPower(.1);
    Back_Right.setPower(.1);

    sleep(1000);
    Front_Left.setPower(0);
    Front_Right.setPower(0);
    Back_Left.setPower(0);
    Back_Right.setPower(0);
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
            senseRed(1);
            driveBackward_Slo(.2);
            turnleft(2);


        }

     }
}

