package com.samsung.android.sbrowser.ext.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class SysUtils {
    private static Boolean a;
    private static Integer b;
    private static Boolean c;

    private static int a() {
        FileReader fileReader;
        String str;
        Pattern compile = Pattern.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                fileReader = new FileReader("/proc/meminfo");
            } catch (Exception e) {
                Log.w("SysUtils", "Cannot get total physical size from /proc/meminfo", e);
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            str = "/proc/meminfo lacks a MemTotal entry?";
                            break;
                        }
                        Matcher matcher = compile.matcher(readLine);
                        if (matcher.find()) {
                            int parseInt = Integer.parseInt(matcher.group(1));
                            if (parseInt > 1024) {
                                return parseInt;
                            }
                            str = "Invalid /proc/meminfo total size in kB: " + matcher.group(1);
                        }
                    } finally {
                        bufferedReader.close();
                    }
                }
                Log.w("SysUtils", str);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return 0;
            } finally {
                fileReader.close();
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static int amountOfPhysicalMemoryKB() {
        if (b == null) {
            b = Integer.valueOf(a());
        }
        return b.intValue();
    }

    private static boolean b() {
        try {
            StrictModeContext allowDiskReads = StrictModeContext.allowDiskReads();
            try {
                boolean z = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getTotalBytes() / 1073741824 >= 24;
                if (allowDiskReads != null) {
                    allowDiskReads.close();
                }
                return z;
            } finally {
            }
        } catch (IllegalArgumentException e) {
            Log.v("SysUtils", "Cannot get disk data capacity", e);
            return false;
        }
    }

    private static boolean c() {
        Integer valueOf = Integer.valueOf(a());
        b = valueOf;
        boolean z = valueOf.intValue() > 0 && b.intValue() / 1024 <= 1024;
        if (ContextUtils.getApplicationContext() != null) {
            ((ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity")).isLowRamDevice();
        }
        return z;
    }

    public static boolean hasCamera(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager.hasSystemFeature("android.hardware.camera") || packageManager.hasSystemFeature("android.hardware.camera.any");
    }

    public static boolean isAndroidGo() {
        return isLowEndDevice();
    }

    public static boolean isCurrentlyLowMemory() {
        ActivityManager activityManager = (ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    public static boolean isFlagShip() {
        return amountOfPhysicalMemoryKB() / 1024 >= 5120 && isHighEndDiskDevice();
    }

    public static boolean isHighEndDiskDevice() {
        if (c == null) {
            c = Boolean.valueOf(b());
        }
        return c.booleanValue();
    }

    public static boolean isLowEndDevice() {
        if (a == null) {
            a = Boolean.valueOf(c());
        }
        return a.booleanValue();
    }
}
