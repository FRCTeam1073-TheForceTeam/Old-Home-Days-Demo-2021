package frc.robot.subsystems;

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

    
}