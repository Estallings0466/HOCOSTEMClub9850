package org.firstinspires.ftc.teamcode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "RightBNew", group = "Blue")
public class NewRightBlue extends LinearOpMode {

    DcMotor Front_Left;
    DcMotor Front_Right;
    DcMotor Back_Left;
    DcMotor Back_Right;
    DcMotor Glyph_Lift ;
    ColorSensor Color_Sensor;
    Servo Jewel_Arm;
    Servo Left_Claw;
    Servo Right_Claw;

    public void hardwareMapping() {
        Front_Left = hardwareMap.dcMotor.get("FL");
        Front_Right = hardwareMap.dcMotor.get("FR");
        Back_Left = hardwareMap.dcMotor.get("BL");
        Back_Right = hardwareMap.dcMotor.get("BR");
        Glyph_Lift = hardwareMap.dcMotor.get("GL");
        Color_Sensor = hardwareMap.colorSensor.get("CS");
        Jewel_Arm = hardwareMap.servo.get("JA");
        Left_Claw = hardwareMap.servo.get("LC");
        Right_Claw = hardwareMap.servo.get("RC");

        Front_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        Back_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        Color_Sensor.enableLed(true);
    }

    public void driveBackward(double driveBackward) throws InterruptedException {
        Front_Left.setPower(1);
        Front_Right.setPower(1);
        Back_Left.setPower(1);
        Back_Right.setPower(1);

        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void driveForward(long Forward) throws InterruptedException {
        Front_Left.setPower(-1);
        Front_Right.setPower(-1);
        Back_Left.setPower(-1);
        Back_Right.setPower(-1);

        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);

    }

    protected void senseBlue(double sense) throws InterruptedException {
        Jewel_Arm.setPosition(-1);
        sleep(2000);

        if (Color_Sensor.red() >= 4 ) {
            driveForward_Slo((long).04);
            sleep(1000);
            Jewel_Arm.setPosition(1);
            driveBackward_Slo((long).04);
            sleep(500);
            turnright(2);
        } else {
            driveBackward_Slo(2);
            sleep(1000);
            Jewel_Arm.setPosition(1);
            sleep(500);
            driveBackward_Slo((long).0005);
            turnleft(.5);
            driveForward_Slo(2);

            sleep(500);
        }

    }

    public void turnleft(double turnleft) throws InterruptedException {
        Front_Left.setPower(-.2);
        Front_Right.setPower(.2);
        Back_Left.setPower(-.2);
        Back_Right.setPower(.2);


        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void turnright(double turnright) throws InterruptedException{
        Front_Left.setPower(.2);
        Front_Right.setPower(-.2);
        Back_Left.setPower(.2);
        Back_Right.setPower(-.2);

        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void driveBackward_Slo(double backward_slo) throws InterruptedException {
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

    public void closeClaw (double claw) throws InterruptedException {
        Left_Claw.setPosition(1);

    }

//The above is all we'll need for now, we can add more as the plan develops more

    @Override
    public void runOpMode() throws InterruptedException {
        //gotta let names be known...
        hardwareMapping();


        //patiently waiting
        waitForStart();
        if (opModeIsActive()) {
            closeClaw(1);
            sleep(100);
            senseBlue(1);




        }

    }
}
