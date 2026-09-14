package com.groboot.mdaemergency.models.poc;

import android.content.Context;
import android.os.Build;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import w6.f;
import w6.l0;

/* loaded from: classes.dex */
public class Device {
    public String imei;
    public String ip;
    public String name;
    public String osVersion;
    public String version;

    public static Device getActiveDevice(Context context) {
        Device device = new Device();
        device.imei = f.a(context);
        device.version = MdaEmergencyApplication.f7530g;
        device.name = Build.MODEL;
        device.osVersion = Build.VERSION.RELEASE;
        return device;
    }

    public static boolean isTC25() {
        return l0.l(Build.MODEL, "TC25");
    }
}
