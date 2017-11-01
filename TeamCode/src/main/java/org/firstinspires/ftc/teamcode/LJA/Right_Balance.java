package org.firstinspires.ftc.teamcode.LJA;


        import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
        import com.qualcomm.robotcore.eventloop.opmode.Disabled;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * Created by Jack on 10/21/2017.
 */

@Autonomous (name="Right_Balance", group= "Linear OpMode")
//@Disabled

public class Right_Balance extends LinearOpMode{

    private ElapsedTime runtime = new ElapsedTime();

    DcMotor leftMotor;
    DcMotor rightMotor;

    double power = 0.5;
    double powerTurn = 0.3;

    @Override
    public void runOpMode () {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftMotor = hardwareMap.dcMotor.get("leftMotor");
        rightMotor = hardwareMap.dcMotor.get("rightMotor");
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        runtime.reset();

        // this makes a loop
        //for (int i=0; i<1; i++) {

        //makes robot go forward for 500 miliseconds seconds
        leftMotor.setPower(power);
        rightMotor.setPower(power);
        sleep(500);

        leftMotor.setPower(-powerTurn);
        rightMotor.setPower(powerTurn);
        sleep(1000);

        leftMotor.setPower(power);
        rightMotor.setPower(power);
        sleep(200);

    }

}
