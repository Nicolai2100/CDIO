public class MainStop {

    public static void main(String[] args) {

        Beast.getMotorB().close();
        Beast.getMotorC().close();
        Beast.getSensorUS().close();
    }
}