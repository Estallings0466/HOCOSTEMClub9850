package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by emmab on 9/21/2017.
 */
@Autonomous
@Disabled
public class ColorSensor_Test2 extends LinearOpMode {

    ColorSensor color_sensor;
    Servo jewel_arm;

    public void hardwareMapping() {
        color_sensor = hardwareMap.colorSensor.get("color");
        jewel_arm = hardwareMap.servo.get("jewel");

    }


    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        {
            color_sensor.red();
            color_sensor.blue();

            color_sensor.alpha();
            color_sensor.argb();
        }
        while (color_sensor.alpha() < 20) {
            //Make the thing go down

        }
    }
}
