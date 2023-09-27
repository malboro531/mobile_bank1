package utils.mobile;

public class GPSTools {
    public static void switchONGPSConnection(String androidSdkToolPath, String deviceId) {
        try {
            Runtime.getRuntime()
                    .exec(androidSdkToolPath
                            + "/adb -s" + deviceId
                            + " shell settings put secure location_providers_allowed gps ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void switchOffGPSConnection(String androidSdkToolPath, String deviceId) {
        try {
            Runtime.getRuntime().
                    exec(androidSdkToolPath
                            + "/adb -s" + deviceId
                            + " shell settings put secure location_providers_allowed ' '");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
