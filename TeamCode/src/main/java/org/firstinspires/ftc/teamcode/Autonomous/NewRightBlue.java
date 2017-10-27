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
    DcMotor RelicClaw;
    DcMotor RelicArm;
    ColorSensor LColor_Sensor;
    ColorSensor RColor_Sensor;
    Servo LJewel_Arm;
    Servo RJewel_Arm;
    Servo LeftB_Claw;
    Servo LeftT_Claw;
    Servo RightB_Claw;
    Servo RightT_Claw;
    Servo Relic_Servo;

    public void hardwareMapping() {
        Front_Left = hardwareMap.dcMotor.get("FL");
        Front_Right = hardwareMap.dcMotor.get("FR");
        Back_Left = hardwareMap.dcMotor.get("BL");
        Back_Right = hardwareMap.dcMotor.get("BR");
        Glyph_Lift = hardwareMap.dcMotor.get("GL");
        //RelicClaw = hardwareMap.dcMotor.get("REC");
        //RelicArm = hardwareMap.dcMotor.get("RA");
        LColor_Sensor = hardwareMap.colorSensor.get("LCS");
        RColor_Sensor =hardwareMap.colorSensor.get("RCS");
        LJewel_Arm = hardwareMap.servo.get("LJA");
        RJewel_Arm = hardwareMap.servo.get("RJA");
        LeftB_Claw = hardwareMap.servo.get("LBC");
        LeftT_Claw =hardwareMap.servo.get("LTC");
        RightB_Claw = hardwareMap.servo.get("RBC");
        RightT_Claw = hardwareMap.servo.get("RTC");
        //Relic_Servo = hardwareMap.servo.get("RS");

        Front_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        Back_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        LColor_Sensor.enableLed(true);
        RColor_Sensor.enableLed(true);
    }

    public void driveBackward(double driveBackward) throws InterruptedException {
        Front_Left.setPower(.20);
        Front_Right.setPower(.20);
        Back_Left.setPower(.20);
        Back_Right.setPower(.20);

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
        LJewel_Arm.setPosition(-1);
        sleep(2000);

        if (LColor_Sensor.red() >= 4 ) {
            driveBackward_Slo2((long).3);
            sleep(1000);
            LJewel_Arm.setPosition(1);
            driveBackward(.3);
            driveForward_Slo((long).2);
            sleep(500);

        } else {
            driveForward_Slo((long).01);
            sleep(1000);
            LJewel_Arm.setPosition(1);
            sleep(500);
            turnright(.005);
            driveForward_Slo2((long).2);
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
    public void driveBackward_Slo2(double backward_slo) throws InterruptedException {
        Front_Left.setPower(-.09);
        Front_Right.setPower(-.09);
        Back_Left.setPower(-.09);
        Back_Right.setPower(-.09);

        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void driveForward_Slo2(double backward2) throws InterruptedException {
        Front_Left.setPower(.09);
        Front_Right.setPower(.09);
        Back_Left.setPower(.09);
        Back_Right.setPower(.09);

        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }


    public void driveForward_Slo(long forward_slo) throws InterruptedException {
        Front_Left.setPower(.15);
        Front_Right.setPower(.15);
        Back_Left.setPower(.15);
        Back_Right.setPower(.15);

        sleep(1000);
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void closeClaw (double claw) throws InterruptedException {
        LeftB_Claw.setPosition(1);
        LeftT_Claw.setPosition(1);

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
