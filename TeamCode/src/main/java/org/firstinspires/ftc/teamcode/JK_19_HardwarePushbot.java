/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
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
 * Motor channel:  Left drive              "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
public class JK_19_HardwarePushbot
{
    /* Public OpMode members. */
    public DcMotor     leftDrive           = null;
    public DcMotor     rightDrive          = null;
    public DcMotor     horizontalMotor           = null;
    public DcMotor     armMotor          = null;
    public Servo       ColorSensingServo     =null;
    public ColorSensor MineralColorSensor    =null;
    public CRServo     PaddleServo           =null;
    //public Servo       arm                 = null;
   // public DcMotor     leftRear            = null;
    //public DcMotor     rightRear           = null;
   // public DcMotor     rampMotor           = null;
    //public TouchSensor extensionTouch      = null;  // Ramp Deployment
    //public DcMotor     extensionMotor      = null;
    //public DcMotor     loaderMotor         = null;
    //public GyroSensor  gyro                = null;
    //Testing relic
    //public Servo       relicPivotServo     = null;
    //public Servo       relicClawServo      = null;
    //public DcMotor     relicExtendMotorCmd = null;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public JK_19_HardwarePushbot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftDrive  = hwMap.get(DcMotor.class, "left");
        rightDrive = hwMap.get(DcMotor.class, "right");
        horizontalMotor  = hwMap.get(DcMotor.class, "horiz");
        armMotor = hwMap.get(DcMotor.class, "arm");
      //  rampMotor  = hwMap.get(DcMotor.class, "beltmotor");
       // loaderMotor= hwMap.get(DcMotor.class, "loadermotor");
      //  extensionMotor = hwMap.get(DcMotor.class, "pullymotor");
        //relic test
     //   relicExtendMotorCmd = hwMap.get(DcMotor.class, "relicExtendMotor");
       // relicClawServo = hwMap.get(Servo.class, "relicClawServo");
      //  relicPivotServo = hwMap.get(Servo.class, "relicPivotServo");
      //  relicExtendMotorCmd.setPower(0);
       // relicClawServo.setPosition(0);
      //  relicPivotServo.setPosition(0);

        //leftArm    = hwMap.get(DcMotor.class, "left_arm");
        leftDrive.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightDrive.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        //arm.setDirection(Servo.Direction.REVERSE);
      //  leftRear.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
       // rightRear.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
       // rampMotor.setDirection(DcMotor.Direction.FORWARD);
      //  loaderMotor.setDirection(DcMotor.Direction.FORWARD);
      //  extensionMotor.setDirection(DcMotor.Direction.FORWARD);

        // Set all motors to zero power
        leftDrive.setPower(0);
        rightDrive.setPower(0);
        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
      //  rampMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
     //   loaderMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
     //   extensionMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //test
    //    relicExtendMotorCmd.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        ColorSensingServo = hwMap.get(Servo.class, "ColorSensingServo");
        MineralColorSensor = hwMap.get(ColorSensor.class, "MineralColorSensor");
        PaddleServo = hwMap.get(CRServo.class, "PaddleServo");
        MineralColorSensor.enableLed(false);
        ColorSensingServo.setDirection(Servo.Direction.FORWARD);
        ColorSensingServo.setPosition(0.0);
        PaddleServo.setDirection(DcMotorSimple.Direction.FORWARD);
        PaddleServo.setPower(0);


        //Define and Initialize Sensors
     //   gyro = hwMap.get(GyroSensor.class, "gyro");
     //   extensionTouch = hwMap.get(TouchSensor.class, "ext_touch");
    }
 }

















