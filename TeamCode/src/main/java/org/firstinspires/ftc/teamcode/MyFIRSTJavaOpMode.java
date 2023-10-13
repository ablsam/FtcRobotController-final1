package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;



@TeleOp(name="MecanumDrive", group="Iterative OpMode")

public class MyFIRSTJavaOpMode extends OpMode {

    public DcMotor leftFront   = null;
    public DcMotor rightFront  = null;
    public DcMotor leftBack   = null;
    public DcMotor rightBack  = null;

    @Override
    public void init() {
        leftFront  = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        leftBack   = hardwareMap.get(DcMotor.class, "leftBack");
        rightBack   = hardwareMap.get(DcMotor.class, "rightBack");

        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.FORWARD);

        telemetry.addData(">", "Hardware Initialized");
        telemetry.update();
    }
    @Override
    public void loop() {
        double vertical  = -gamepad1.left_stick_y;
        double horizontal = gamepad1.left_stick_x;
        double pivot  = gamepad1.right_stick_x;
        vertical = gamepad1.left_stick_y;
        horizontal = gamepad1.left_stick_x;
        pivot = gamepad1.right_stick_x;


        rightFront.setPower(pivot + (-vertical + horizontal));
        rightBack.setPower(pivot + (-vertical - horizontal));
        leftFront.setPower(pivot + (-vertical - horizontal));
        leftBack.setPower(pivot + (-vertical +  horizontal));

    }

    @Override
    public void init_loop() {

    }

}