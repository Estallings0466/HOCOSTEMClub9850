package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import static com.qualcomm.robotcore.hardware.Servo.MIN_POSITION;


/*
	Holonomic concepts from:
	http://www.vexforum.com/index.php/12370-holonomic-drives-2-0-a-video-tutorial-by-cody/0
   Robot wheel mapping:
          X FRONT X
        X           X
      X  FL       FR  X
              X
             XXX
              X
      X  BL       BR  X
        X           X
          X       X
*/
@TeleOp(name = "New Test Manual", group = "Manual")
//@Disabled
public class ManualNewTest extends OpMode {

    DcMotor FrontRight;
    DcMotor FrontLeft;
    DcMotor BackRight;
    DcMotor BackLeft;
    DcMotor Glyph_Lift;
    Servo LJewel_Arm;
    Servo RJewel_Arm;
    Servo LeftB_Claw;
    Servo LeftT_Claw;
    Servo RightB_Claw;
    Servo RightT_Claw;
    /**
     * Constructor
     */
    public ManualNewTest() {

    }

    @Override
    public void init() {


		/*
		 * Use the hardwareMap to get the dc motors and servos by name. Note
		 * that the names of the devices must match the names used when you
		 * configured your robot and created the configuration file.
		 */


        FrontRight = hardwareMap.dcMotor.get("FR");
        FrontLeft = hardwareMap.dcMotor.get("FL");
        BackLeft = hardwareMap.dcMotor.get("BL");
        BackRight = hardwareMap.dcMotor.get("BR");
        Glyph_Lift = hardwareMap.dcMotor.get("GL");
        LeftB_Claw = hardwareMap.servo.get("LBC");
        LeftT_Claw =hardwareMap.servo.get("LTC");
        RightB_Claw = hardwareMap.servo.get("RBC");
        RightT_Claw = hardwareMap.servo.get("RTC");
        LJewel_Arm = hardwareMap.servo.get("LJA");
        RJewel_Arm = hardwareMap.servo.get("RJA");
        //These work without reversing (Tetrix motors).
        //AndyMark motors may be opposite, in which case uncomment these lines:
        //motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        //motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
        //motorFrontRight.setDirection(DcMotor.Direction.REVERSE);
        //motorBackRight.setDirection(DcMotor.Direction.REVERSE);


    }

    @Override
    public void loop() {


        // left stick controls direction
        // right stick X controls rotation

        float gamepad1LeftY = -gamepad1.left_stick_y;
        float gamepad1LeftX = gamepad1.left_stick_x;
        float gamepad1RightX = gamepad1.right_stick_x;
        float Lclaw = gamepad2.left_trigger;
        float LBClaw = gamepad2.left_trigger;
        float Rclaw = gamepad2.left_trigger;
        float RBClaw = gamepad2.left_trigger;
        float Slide = gamepad2.right_stick_y;
        // holonomic formulas

        float FrontL = -gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float FrontR = gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float BackR = gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        float BackL = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;



        // clip the right/left values so that the values never exceed +/- 1
        FrontR = Range.clip(FrontR, -1, 1);
        FrontL = Range.clip(FrontL, -1, 1);
        BackL = Range.clip(BackL, -1, 1);
        BackR = Range.clip(BackR, -1, 1);

        // write the values to the motors
        BackRight.setPower(BackR);
        FrontLeft.setPower(FrontL);
        BackLeft.setPower(BackL);
        BackRight.setPower(BackR);
        LeftB_Claw.setPosition(LBClaw);
        LeftT_Claw.setPosition(Lclaw);
        RightB_Claw.setPosition(RBClaw);
        RightT_Claw.setPosition(Rclaw);
        Glyph_Lift.setPower(Slide);

        LeftB_Claw.setDirection(Servo.Direction.FORWARD);
        LeftT_Claw.setDirection(Servo.Direction.FORWARD);
        // Left_ClawBot.setDirection(Servo.Direction.REVERSE);
        RightB_Claw.setDirection(Servo.Direction.REVERSE);
        RightT_Claw.setDirection(Servo.Direction.REVERSE);
        // Right_ClawBot.setDirection(Servo.Direction.REVERSE);
        Glyph_Lift.setDirection(DcMotor.Direction.FORWARD);
        LJewel_Arm.setDirection(Servo.Direction.REVERSE);
        RJewel_Arm.setDirection(Servo.Direction.REVERSE);


		/*
		 * Telemetry for debugging
		 */
        telemetry.addData("Text", "*** Robot Data***");
        telemetry.addData("Joy XL YL XR",  String.format("%.2f", gamepad1LeftX) + " " +
                String.format("%.2f", gamepad1LeftY) + " " +  String.format("%.2f", gamepad1RightX));
        telemetry.addData("f left pwr",  "front left  pwr: " + String.format("%.2f", FrontLeft));
        telemetry.addData("f right pwr", "front right pwr: " + String.format("%.2f", FrontRight));
        telemetry.addData("b right pwr", "back right pwr: " + String.format("%.2f", BackRight));
        telemetry.addData("b left pwr", "back left pwr: " + String.format("%.2f", BackLeft));

    }

    @Override
    public void stop() {

    }

    /*
     * This method scales the joystick input so for low joystick values, the
     * scaled value is less than linear.  This is to make it easier to drive
     * the robot more precisely at slower speeds.
     */
    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }

}