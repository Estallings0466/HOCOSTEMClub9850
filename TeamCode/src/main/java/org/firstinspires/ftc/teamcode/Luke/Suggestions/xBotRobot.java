package org.firstinspires.ftc.teamcode.Luke.Suggestions;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;


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
    DcMotor Glyph_Claw;
    ColorSensor LColor_Sensor;
    ColorSensor RColor_Sensor;
    Servo LJewel_Arm;
    Servo RJewel_Arm;
    Servo Relic_Servo;

    public static final double MID_SERVO       =  0.5 ;
    public static final double ARM_UP_POWER    =  0.45 ;
    public static final double ARM_DOWN_POWER  = -0.45 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Vuforia members. */

    public static final String TAG = "Vuforia VuMark Sample";

    OpenGLMatrix lastLocation = null;

    /**
     * {@link #vuforia} is the variable we will use to store our instance of the Vuforia
     * localization engine.
     */
    VuforiaLocalizer vuforia;
    VuforiaTrackables relicTrackables;
    VuforiaTrackable relicTemplate;

    /* Constructor */
    public xBotRobot(){


    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize MotorsFront_Left = hardwareMap.dcMotor.get("FL");
        Front_Right = hwMap.dcMotor.get("FR");
        Front_Left = hwMap.dcMotor.get("FL");
        Back_Left = hwMap.dcMotor.get("BL");
        Back_Right = hwMap.dcMotor.get("BR");
        Glyph_Lift = hwMap.dcMotor.get("GL");
        Glyph_Claw = hwMap.dcMotor.get("GC");
        LJewel_Arm = hwMap.servo.get("LJA");
        RJewel_Arm = hwMap.servo.get("RJA");
        Relic_Servo = hwMap.servo.get("RS");
        LColor_Sensor = hwMap.colorSensor.get("LCS");
        RColor_Sensor = hwMap.colorSensor.get("RCS");


        Front_Right.setDirection(DcMotorSimple.Direction.FORWARD);
        Back_Right.setDirection(DcMotorSimple.Direction.FORWARD);
        Front_Left.setDirection(DcMotorSimple.Direction.REVERSE);
        Back_Left.setDirection(DcMotorSimple.Direction.REVERSE);


        // Set all motors to zero power
        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
        RJewel_Arm.setPosition(1);
        LJewel_Arm.setPosition(1);
        LColor_Sensor.enableLed(true);
        RColor_Sensor.enableLed(true);
        // Set all motors to run without encoders.
        // No encoders on our motors to my knowledge - Luke Sullivan
        // May want to use RUN_USING_ENCODERS if encoders are installed.
       // leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
       // rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize ALL installed servos.





        // Define and initialize ALL other sensors.





    }

    public void initVuforia(HardwareMap ahwMap) {
        hwMap = ahwMap;
        /*
         * To start up Vuforia, tell it the view that we wish to use for camera monitor (on the RC phone);
         * If no camera monitor is desired, use the parameterless constructor instead (commented out below).
         */
        int cameraMonitorViewId = hwMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hwMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        // OR...  Do Not Activate the Camera Monitor View, to save power
        // VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        /*
         * IMPORTANT: You need to obtain your own license key to use Vuforia. The string below with which
         * 'parameters.vuforiaLicenseKey' is initialized is for illustration only, and will not function.
         * A Vuforia 'Development' license key, can be obtained free of charge from the Vuforia developer
         * web site at https://developer.vuforia.com/license-manager.
         *
         * Vuforia license keys are always 380 characters long, and look as if they contain mostly
         * random data. As an example, here is a example of a fragment of a valid key:
         *      ... yIgIzTqZ4mWjk9wd3cZO9T1axEqzuhxoGlfOOI2dRzKS4T0hQ8kT ...
         * Once you've obtained a license key, copy the string from the Vuforia web site
         * and paste it in to your code onthe next line, between the double quotes.
         */
        parameters.vuforiaLicenseKey = "ARMl4sr/////AAAAGW7XCTx7E0rTsT4i0g6I9E8IY/EGEWdA5QHmgcnvsPFeuf+2cafgFWlJht6/m4ps4hdqUeDgqSaHurLTDfSET8oOvZUEOiMYDq2xVxNDQzW4Puz+Tl8pOFb1EfCrP28aBkcBkDfXDADiws03Ap/mD///h0HK5rVbe3KYhnefc0odh1F7ZZ1oxJy+A1w2Zb8JCXM/SWzAVvB1KEAnz87XRNeaJAon4c0gi9nLAdZlG0jnC6bx+m0140C76l14CTthmzSIdZMBkIb8/03aQIouFzLzz+K1fvXauT72TlDAbumhEak/s5pkN6L555F28Jf8KauwCnGyLnePxTm9/NKBQ4xW/bzWNpEdfY4CrBxFoSkq";

        /*
         * We also indicate which camera on the RC that we wish to use.
         * Here we chose the back (HiRes) camera (for greater range), but
         * for a competition robot, the front camera might be more convenient.
         */
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT;
        parameters.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES; // Display Axes

        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);

        /**
         * Load the data set containing the VuMarks for Relic Recovery. There's only one trackable
         * in this data set: all three of the VuMarks in the game were created from this one template,
         * but differ in their instance id information.
         * @see VuMarkInstanceId
         */
        relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary

        relicTrackables.activate();


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
        Front_Left.setPower(-speed);
        Front_Right.setPower(speed);
        Back_Left.setPower(speed);
        Back_Right.setPower(-speed);

        Thread.sleep(500);

        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }

    public void slewRight(double speed) throws InterruptedException {
        Front_Left.setPower(speed);
        Front_Right.setPower(-speed);
        Back_Left.setPower(-speed);
        Back_Right.setPower(speed);

        Thread.sleep(500);

        Front_Left.setPower(0);
        Front_Right.setPower(0);
        Back_Left.setPower(0);
        Back_Right.setPower(0);
    }


    public void closeClaw(double speed) throws InterruptedException {
        Glyph_Claw.setPower(speed);
    }

    public void lowerRightArm() throws InterruptedException {
        LJewel_Arm.setPosition(-1);

    }

    public void lowerLeftArm() throws InterruptedException {

        RJewel_Arm.setPosition(-1);
    }

    public void raiseArms() throws InterruptedException {
        RJewel_Arm.setPosition(1);
        LJewel_Arm.setPosition(1);
    }

    protected boolean isRedLeft() throws InterruptedException {
        Thread.sleep(2000);
        if (LColor_Sensor.red() >= 4) {
            return true;
        } else
        {
            return false;
        }
    }


    protected boolean isRedRight() throws InterruptedException {

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
