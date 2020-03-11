import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.utility.Delay;

public class DrivingMethods {
    UnregulatedMotor motorB;
    UnregulatedMotor motorC;

    public DrivingMethods() {
        motorB = Beast.getMotorB();
        motorC = Beast.getMotorC();
    }

    public void driveInCircle(int times) {
        float range = Beast.getSensorUS().getRange();
        int i = 0;
        while (i < times) {
            //Kør lige ud indtil afstanden bliver for lille
            backWards();
            driveContinuously();
            while (range > Beast.critialRange) {
                System.out.println("Range: " + range * 100 + " cm");
                Delay.msDelay(10);
                range = Beast.getSensorUS().getRange();
                //Bak hvis du sidder fast
                backWards();
            }
            //Drej til højre indtil afstanden bliver stor nok
            Beast.getMotorC().stop();
            while (range < Beast.critialRange - 0.8) {
                System.out.println("Range: " + range * 100 + " cm");
                Delay.msDelay(10);
                range = Beast.getSensorUS().getRange();

                //Bak hvis du sidder fast
                backWards();
            }
            driveContinuously();
            i++;
            System.out.println(i);
            range = Beast.getSensorUS().getRange();

        }
        stopDriving();
    }

    public void backWards() {
        if ((Beast.getMotorC().isMoving() || Beast.getMotorB().isMoving()) && Beast.hasNoForwardMotion()) {
            float range = Beast.getSensorUS().getRange();
            while (range < Beast.critialRange) {
                System.out.println("Range: " + range * 100 + " cm");
                Delay.msDelay(10);
                range = Beast.getSensorUS().getRange();

                motorB.backward();
                motorB.setPower(50);
                motorC.backward();
                motorC.setPower(50);
            }
        }
    }

    public void driveContinuously() {
        motorB.forward();
        motorB.setPower(50);
        motorC.forward();
        motorC.setPower(50);
    }

    public void stopDriving() {
        motorB.stop();
        motorC.stop();
    }

    public void turnRightUntil() {
        motorC.stop();
    }


    public void turn90DGRight() {
        motorC.stop();

        Delay.msDelay(4000);

    }

    public void turn90DGRightAroundAxis() {
        motorC.backward();
        motorC.setPower(50);
        Delay.msDelay(1900);

    }


    public void driveBackAndForth() {
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
        Sound.beepSequence(); // we are done.
    }

    public void driveTest() {
        motorB.forward();
        motorB.setPower(50);
        motorC.forward();
        motorC.setPower(50);
        Delay.msDelay(200);
        motorB.stop();
        motorC.stop();
        Sound.beepSequence(); // we are done.
    }

    public void detectAndGrab() {
        if (Beast.getSensorUS().getRange() < Beast.critialRange) {
            Beast.grabAndLift();
        }
    }
}
