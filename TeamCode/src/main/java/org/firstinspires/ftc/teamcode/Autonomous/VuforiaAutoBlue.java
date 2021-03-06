package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
@Disabled
@Autonomous (name = "VuforiaBlueRight", group = "Blue")
public class VuforiaAutoBlue extends LinearOpMode{
    OpenGLMatrix lastLocation = null; // WARNING: VERY INACCURATE, USE ONLY TO ADJUST TO FIND IMAGE AGAIN! DO NOT BASE MAJOR MOVEMENTS OFF OF THIS!!
    double tX; // X value extracted from our the offset of the traget relative to the robot.
    double tZ; // Same as above but for Z
    double tY; // Same as above but for Y
    // -----------------------------------
    double rX; // X value extracted from the rotational components of the tartget relitive to the robot
    double rY; // Same as above but for Y
    double rZ; // Same as above but for Z
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
    VuforiaLocalizer vuforia;

    public void runOpMode() throws InterruptedException {
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
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        parameters.vuforiaLicenseKey = "ARMl4sr/////AAAAGW7XCTx7E0rTsT4i0g6I9E8IY/EGEWdA5QHmgcnvsPFeuf+2cafgFWlJht6/m4ps4hdqUeDgqSaHurLTDfSET8oOvZUEOiMYDq2xVxNDQzW4Puz+Tl8pOFb1EfCrP28aBkcBkDfXDADiws03Ap/mD///h0HK5rVbe3KYhnefc0odh1F7ZZ1oxJy+A1w2Zb8JCXM/SWzAVvB1KEAnz87XRNeaJAon4c0gi9nLAdZlG0jnC6bx+m0140C76l14CTthmzSIdZMBkIb8/03aQIouFzLzz+K1fvXauT72TlDAbumhEak/s5pkN6L555F28Jf8KauwCnGyLnePxTm9/NKBQ4xW/bzWNpEdfY4CrBxFoSkq";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT; // Use FRONT Camera (Change to BACK if you want to use that one)
        parameters.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES; // Display Axes

        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        waitForStart();

        relicTrackables.activate(); // Activate Vuforia

        while (opModeIsActive())
        {
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
            if (vuMark != RelicRecoveryVuMark.UNKNOWN) { // Test to see if image is visable
                OpenGLMatrix pose = ((VuforiaTrackableDefaultListener) relicTemplate.getListener()).getPose(); // Get Positional value to use later
                telemetry.addData("Pose", format(pose));
                if (pose != null)
                {
                    VectorF trans = pose.getTranslation();
                    Orientation rot = Orientation.getOrientation(pose, AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);

                    // Extract the X, Y, and Z components of the offset of the target relative to the robot
                    tX = trans.get(0);
                    tY = trans.get(1);
                    tZ = trans.get(2);

                    // Extract the rotational components of the target relative to the robot. NOTE: VERY IMPORTANT IF BASING MOVEMENT OFF OF THE IMAGE!!!!
                    rX = rot.firstAngle;
                    rY = rot.secondAngle;
                    rZ = rot.thirdAngle;
                }
                if (vuMark == RelicRecoveryVuMark.LEFT)
                { // Test to see if Image is the "LEFT" image and display value.
                    telemetry.addData("VuMark is", "Left");
                    telemetry.addData("X =", tX);
                    telemetry.addData("Y =", tY);
                    telemetry.addData("Z =", tZ);
                    LJewel_Arm.setPosition(-1);
                    RJewel_Arm.setPosition(1);
                    sleep(2000);

                    if (LColor_Sensor.red() >= 1 ) {
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
                        driveForward_Slo((long).2);
                        sleep(500);
                    }

                } else if (vuMark == RelicRecoveryVuMark.RIGHT)
                { // Test to see if Image is the "RIGHT" image and display values.
                    telemetry.addData("VuMark is", "Right");
                    telemetry.addData("X =", tX);
                    telemetry.addData("Y =", tY);
                    telemetry.addData("Z =", tZ);
                    if (LColor_Sensor.red() >= 1 ) {
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
                        driveForward_Slo((long).2);
                        sleep(500);
                    }
                } else if (vuMark == RelicRecoveryVuMark.CENTER)
                { // Test to see if Image is the "CENTER" image and display values.
                    telemetry.addData("VuMark is", "Center");
                    telemetry.addData("X =", tX);
                    telemetry.addData("Y =", tY);
                    telemetry.addData("Z =", tZ);
                    if (LColor_Sensor.red() >= 1 ) {
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
                    driveForward_Slo((long).2);
                    sleep(500);
                }

                }
            } else
            {
                telemetry.addData("VuMark", "not visible");
            }
            telemetry.update();
        }
    }
    String format(OpenGLMatrix transformationMatrix)
    {
        return (transformationMatrix != null) ? transformationMatrix.formatAsTransform() : "null";
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
        Front_Left.setPower(.3);
        Front_Right.setPower(.3);
        Back_Left.setPower(.3);
        Back_Right.setPower(.3);

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
}

