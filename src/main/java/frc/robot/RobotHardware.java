package frc.robot;

/** 
 * This class is where you Define Your robot hardware E.D Motor controlers , sensors , can sensors etc
 */

import com.analog.adis16448.frc.ADIS16448_IMU;

public class RobotHardware {
    // ADIS16448_IMU -> analog devices imu in robox XMP port
    public static ADIS16448_IMU Imu = new ADIS16448_IMU();
   
    public static void HardwareInit() {
        // calabrates imu
        Imu.calibrate();
    }
}