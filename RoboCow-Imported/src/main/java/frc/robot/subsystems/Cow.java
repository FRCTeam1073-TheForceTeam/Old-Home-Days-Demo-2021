package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Cow extends SubsystemBase {

    private DigitalOutput mooer, pooper;

  public Cow() {
    this.mooer = new DigitalOutput(1);
    this.pooper = new DigitalOutput(2);
    init();
}

public void init(){
    mooer.set(true);
    pooper.set(true);
}

  /**
   * Tells the Raspberry Pi to make the moo sound
   */
  public void moo(boolean mooControl) {
    mooer.set(mooControl);
    /*
    if (mooer.isPulsing() == false)
    mooer.pulse(5); //What units is pulse length?
    */
  }

  /**
   * Tells the Raspberry Pi to drop the poop
   */
  public void poop(boolean poopControl) {
    // if (pooper.isPulsing() == false)
    // pooper.pulse(5);//What units is pulse length?
    pooper.set(poopControl);
  }

  public void poopOnCommand(boolean poopControl) {
    // if (pooper.isPulsing() == false)
    // pooper.pulse(5);//What units is pulse length?
    pooper.set(poopControl);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}