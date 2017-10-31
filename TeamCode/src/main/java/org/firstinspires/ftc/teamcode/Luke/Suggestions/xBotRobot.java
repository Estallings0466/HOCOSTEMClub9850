package org.firstinspires.ftc.teamcode.Luke.Suggestions;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motors:        "Front_Left", "Back_Left"
 * Motor channel:  Right drive motor:        "Front_Right", "Back_Right"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
public class xBotRobot
{
    /* Public OpMode members. */
    DcMotor Front_Left;
    DcMotor Front_Right;
    DcMotor Back_Left;
    DcMotor Back_Right;
    DcMotor Glyph_Lift;
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

    public static final double MID_SERVO       =  0.5 ;
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public xBotRobot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize MotorsFront_Left = hardwareMap.dcMotor.get("FL");
        Front_Right = hwMap.dcMotor.get("FR");
        Back_Left = hwMap.dcMotor.get("BL");
        Back_Right = hwMap.dcMotor.get("BR");
        Glyph_Lift = hwMap.dcMotor.get("GL");
        //RelicClaw = hardwareMap.dcMotor.get("REC");
        //RelicArm = hardwareMap.dcMotor.get("RA");
        Front_Right.setDirection(DcMotorSimple.Direction.FORWARD);
        Back_Right.setDirection(DcMotorSimple.Direction.FORWARD);
        Front_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        Back_Left.setDirection(DcMotorSimple.Direction.REVERSE);


        // Set all motors to zero power
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);

        // Set all motors to run without encoders.
        // No encoders on our motors to my knowledge - Luke Sullivan
        // May want to use RUN_USING_ENCODERS if encoders are installed.
       // leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       // rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize ALL installed servos.

        LJewel_Arm = hwMap.servo.get("LJA");
        RJewel_Arm = hwMap.servo.get("RJA");
        LeftB_Claw = hwMap.servo.get("LBC");
        LeftT_Claw = hwMap.servo.get("LTC");
        RightB_Claw = hwMap.servo.get("RBC");
        RightT_Claw = hwMap.servo.get("RTC");
        //Relic_Servo = hardwareMap.servo.get("RS");

        RJewel_Arm.setPosition(1);
        LJewel_Arm.setPosition(1);

        // Define and initialize ALL other sensors.
        LColor_Sensor = hwMap.colorSensor.get("LCS");
        RColor_Sensor = hwMap.colorSensor.get("RCS");

        LColor_Sensor.enableLed(true);
        RColor_Sensor.enableLed(true);
    }


    public void driveBackward(double speed) throws InterruptedException {
        Front_Left.setPower(-speed);
        Front_Right.setPower(-speed);
        Back_Left.setPower(-speed);
        Back_Right.setPower(-speed);

        Thread.sleep(1000);

        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void driveForward(double speed) throws InterruptedException {
        Front_Left.setPower(speed);
        Front_Right.setPower(speed);
        Back_Left.setPower(speed);
        Back_Right.setPower(speed);

        Thread.sleep(1000);

        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void turnLeft(double speed) throws InterruptedException {
        Front_Left.setPower(-speed);
        Front_Right.setPower(speed);
        Back_Left.setPower(-speed);
        Back_Right.setPower(speed);

        Thread.sleep(1000);

        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void turnRight(double speed) throws InterruptedException {
        Front_Left.setPower(speed);
        Front_Right.setPower(-speed);
        Back_Left.setPower(speed);
        Back_Right.setPower(-speed);

        Thread.sleep(1000);

        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void slewLeft(double speed) throws InterruptedException {
        Front_Left.setPower(speed);
        Front_Right.setPower(speed);
        Back_Left.setPower(-speed);
        Back_Right.setPower(-speed);

        Thread.sleep(1000);

        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void slewRight(double speed) throws InterruptedException {
        Front_Left.setPower(-speed);
        Front_Right.setPower(-speed);
        Back_Left.setPower(speed);
        Back_Right.setPower(speed);

        Thread.sleep(1000);

        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }


    public void closeClaw(double claw) throws InterruptedException {
        LeftB_Claw.setPosition(1);
        LeftT_Claw.setPosition(1);
        RightB_Claw.setPosition(-1);
        RightT_Claw.setPosition(-1);

    }

    public void lowerJewelArm() throws InterruptedException {
        RJewel_Arm.setPosition(-1);
        LJewel_Arm.setPosition(1);
    }

    public void raiseJewelArm() throws InterruptedException {
        RJewel_Arm.setPosition(1);
        LJewel_Arm.setPosition(1);
    }

    protected boolean isRed() throws InterruptedException {

        Thread.sleep(2000);
        if (RColor_Sensor.red() >= 4) {
            return true;
        } else
            {
                return false;
            }
        }



    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     */
    public void waitForTick(long periodMs) {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}
