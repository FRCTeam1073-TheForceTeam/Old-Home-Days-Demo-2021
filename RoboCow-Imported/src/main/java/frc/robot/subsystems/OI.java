package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.Debouncer;
import edu.wpi.first.wpilibj.XboxController;

public class OI {

    public static XboxController driverController;
    //Operator Controller is not used
    //public static XboxController operatorController;

    public Debouncer cruiseControlDebouncer = new Debouncer(0.05);
    

    public static void init() {
        driverController = new XboxController(0);
        //operatorController = new XboxController(1);
    }

    public boolean getCruiseControlButton(){
        //placeholder button
        return cruiseControlDebouncer.calculate(driverController.getAButton());
    }

    public void zeroController(){
        LEFT_X_ZERO = 0;
        LEFT_Y_ZERO = 0;
        RIGHT_X_ZERO = 0;
        RIGHT_Y_ZERO = 0;
        LEFT_X_ZERO = getDriverLeftX();
        LEFT_Y_ZERO = getDriverLeftY();
        RIGHT_X_ZERO = getDriverRightX();
        RIGHT_Y_ZERO = getDriverRightY();
    }

    private final double LEFT_X_MIN = -1;
    private final double LEFT_X_MAX = 1;
    private double LEFT_X_ZERO = 0;
    public double getDriverLeftX() {
        return MathUtil.clamp(2.0 * (driverController.getRawAxis(0) - (LEFT_X_MAX + LEFT_X_MIN) * 0.5) / (LEFT_X_MAX - LEFT_X_MIN) - LEFT_X_ZERO, -1, 1);
    }

    private final double LEFT_Y_MIN = -1;
    private final double LEFT_Y_MAX = 1;
    private double LEFT_Y_ZERO = 0;
    public double getDriverLeftY() {
        return MathUtil.clamp(2.0 * (driverController.getRawAxis(1) - (LEFT_Y_MAX + LEFT_Y_MIN) * 0.5) / (LEFT_Y_MAX - LEFT_Y_MIN) - LEFT_Y_ZERO, -1, 1);
    }

    private final double RIGHT_X_MIN=-1;
    private final double RIGHT_X_MAX = 1;
    private double RIGHT_X_ZERO = 0;
    public double getDriverRightX() {
        return MathUtil.clamp(2.0 * (driverController.getRawAxis(4) - (RIGHT_X_MAX + RIGHT_X_MIN) * 0.5) / (RIGHT_X_MAX - RIGHT_X_MIN) - RIGHT_X_ZERO, -1, 1);
    }
    private final double RIGHT_Y_MIN = -1;
    private final double RIGHT_Y_MAX = 1;
    private double RIGHT_Y_ZERO = 0;
    public double getDriverRightY() {
        return MathUtil.clamp(2.0 * (driverController.getRawAxis(5) - (RIGHT_Y_MAX + RIGHT_Y_MIN) * 0.5) / (RIGHT_Y_MAX - RIGHT_Y_MIN) - RIGHT_Y_ZERO, -1, 1);
    }
    
}