package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


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
@TeleOp(name = "new Main Manual", group = "Mcanum Program")
//@Disabled

public class Mcanum extends OpMode {

    DcMotor RelicArm;
    Servo Jewel_Arm;
    Servo Left_Claw;
    Servo Right_Claw;
    DcMotor Front_Left;
    DcMotor Back_Right;
    DcMotor Front_Right;
    DcMotor Back_Left;
      Servo RelicClaw;
    DcMotor Glyph_Lift;
     Servo SwivelClaw;

    /**
     * Constructor
     */
    public Mcanum() {

    }

    @Override
    public void init() {


      /*
       * Use the hardwareMap to get the dc motors and servos by name. Note
       * that the names of the devices must match the names used when you
       * configured your robot and created the configuration file.
       */
         RelicArm = hardwareMap.dcMotor.get("RA");
         RelicClaw = hardwareMap.servo.get("REC");
        Left_Claw = hardwareMap.servo.get("LC");
        Right_Claw = hardwareMap.servo.get("RC");
        Front_Left = hardwareMap.dcMotor.get("FL");
        Back_Right = hardwareMap.dcMotor.get("BR");
        Front_Right = hardwareMap.dcMotor.get("FR");
        Back_Left = hardwareMap.dcMotor.get("BL");
        Glyph_Lift = hardwareMap.dcMotor.get("GL");
        Jewel_Arm = hardwareMap.servo.get("JA");
        //SwivelClaw = hardwareMap.servo.get("swivel_claw");
        //These work without reversing (Tetrix motors).
        //AndyMark motors may be opposite, in which case uncomment these lines:
        //motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        //motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
        //motorFrontRight.setDirection(DcMotor.Direction.REVERSE);
        //motorBackRight.setDirection(DcMotor.Direction.REVERSE);
        Left_Claw.setDirection(Servo.Direction.REVERSE);
        Right_Claw.setDirection(Servo.Direction.REVERSE);
        Jewel_Arm.setPosition(1);
        //reverse lifts autonomous arm up

    }

    @Override
    public void loop() {


        // left stick controls direction
        // right stick X controls rotation

        float gamepad1LeftY = gamepad1.left_stick_y;
        float gamepad1LeftX = gamepad1.left_stick_x;
        float gamepad1RightX = gamepad1.right_stick_x;
        float Lclaw = gamepad2.left_stick_y;
        float Rclaw = gamepad2.left_stick_y;
        //  float Claw = gamepad2.right_trigger;
        //  float Arm = gamepad2.right_stick_x;
        float Chain = gamepad2.right_stick_y;
        // float Swivel = gamepad2.left_trigger;
        float JewelA = gamepad1.right_trigger;

        // holonomic formulas

        float FrontLeft = -gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float FrontRight = gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float BackRight = gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        float BackLeft = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;

        // clip the right/left values so that the values never exceed +/- 1
        FrontRight = Range.clip(FrontRight, -1, 1);
        FrontLeft = Range.clip(FrontLeft, -1, 1);
        BackLeft = Range.clip(BackLeft, -1, 1);
        BackRight = Range.clip(BackRight, -1, 1);

        // write the values to the motors
        Front_Left.setPower(FrontLeft);
        Back_Right.setPower(BackRight);
        Front_Right.setPower(FrontRight);
        Back_Left.setPower(BackLeft);
        Left_Claw.setPosition(Lclaw);
        Right_Claw.setPosition(Rclaw);
        //  RelicArm.setPower(Arm);
        //  RelicClaw.setPosition(Claw);
        Glyph_Lift.setPower(Chain);
        //  SwivelClaw.setPosition(Swivel);
        Right_Claw.setDirection(Servo.Direction.FORWARD);


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