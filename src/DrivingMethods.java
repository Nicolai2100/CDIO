import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class DrivingMethods {


    public void driveBackAndForth(UnregulatedMotor motorB, UnregulatedMotor motorC) {
        //kør lige ud
        //motor C
        motorC.forward();
        motorC.setPower(50);
        //motor B
        motorB.forward();
        motorB.setPower(50);
        Delay.msDelay(4000);
        //Dreje
        //motor C
        motorC.backward();
        motorC.setPower(50);
        Delay.msDelay(3800);

        //kør lige ud
        //motor C
        motorC.forward();
        motorC.setPower(50);
        //motor B
        Delay.msDelay(4000);

        motorB.stop();
        motorC.stop();

        // free up motor resources.
        motorB.close();
        motorC.close();
        Sound.beepSequence(); // we are done.
    }

    public void driveTest(UnregulatedMotor motorB, UnregulatedMotor motorC) {
        motorB.forward();
        motorB.setPower(50);
        motorC.forward();
        motorC.setPower(50);
        Delay.msDelay(200);
        motorB.stop();
        motorC.stop();
        motorB.close();
        motorC.close();
        Sound.beepSequence(); // we are done.
    }
}
