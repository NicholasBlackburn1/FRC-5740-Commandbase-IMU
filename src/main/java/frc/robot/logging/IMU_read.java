package frc.robot.logging;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.SimpleWidget;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;
import frc.robot.*;

public class IMU_read {
    // creates shuffleboard tab
    private static ShuffleboardTab imuTab = Shuffleboard.getTab("IMU_JAVA");

    // Creates and sets networktable Entry data for shufflenboard
    private static NetworkTableEntry AngleXEntry =
    
            imuTab.add("GyroX", RobotHardware.Imu.getAngleX())
                .withPosition(0,0)
                .withSize(2,2)
                .getEntry();
        
    private static NetworkTableEntry AngleYEntry =
            imuTab.add("GyroY", RobotHardware.Imu.getAngleY())
                 .withPosition(0,1)
                 .withSize(1,2)
                 .getEntry();

    private static NetworkTableEntry AngleZEntry =
            imuTab.add("GyroZ", RobotHardware.Imu.getAngleZ())
                .withPosition(0,2)
                .withSize(1,2)
                 .getEntry();
        
    private static SimpleWidget gyroWidget =
            imuTab.add("XYZ",RobotHardware.Imu.getAngle())
                .withPosition(5,0)
                .withSize(4, 4)
                .withWidget(BuiltInWidgets.kGyro)
                .withProperties(Map.of("min", 0, "max", 360));
        

    private static NetworkTableEntry MagXEntry =
            imuTab.add("MagX", RobotHardware.Imu.getMagX())
                .withPosition(3, 1)
                .withSize(1,2)
                .getEntry();
        
    private static NetworkTableEntry MagYEntry =
            imuTab.add("MagY",RobotHardware.Imu.getMagY())
                .withPosition(3, 2)
                .withSize(1, 2)
                .getEntry();

    private static NetworkTableEntry magZEntry =
            imuTab.add("MagZ",RobotHardware.Imu.getMagZ())
                .withPosition(3, 3)
                .withSize(1, 2)
                .getEntry();


    public static void Peroidic() {
        // Data type to grab a 64 bit mumber from Imu
        double AngleX = RobotHardware.Imu.getAngleX();
        double AngleY = RobotHardware.Imu.getAngleY();
        double AngleZ = RobotHardware.Imu.getAngleZ();

        // Converts Data from Mag sensor in Imu 
        double MagX = RobotHardware.Imu.getMagX();
        double MagY = RobotHardware.Imu.getMagY();
        double MagZ = RobotHardware.Imu.getMagZ();

        // Sets Data from IMU -> to networktable -> Shuffleboard
        AngleXEntry.setDouble(AngleX);
        AngleYEntry.setDouble(AngleY);
        AngleZEntry.setDouble(AngleZ);

        MagXEntry.setDouble(MagX);
        MagYEntry.setDouble(MagY);
        magZEntry.setDouble(MagZ);
       

    }
}