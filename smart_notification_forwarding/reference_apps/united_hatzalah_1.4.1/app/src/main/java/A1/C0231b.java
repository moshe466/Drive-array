package a1;

import A.n;
import android.app.Activity;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import w.AbstractC0744b;

/* renamed from: a1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0231b implements MethodChannel.MethodCallHandler {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2752a;

    /* renamed from: b, reason: collision with root package name */
    public final C0233d f2753b;

    public C0231b(Context context, n nVar, C0233d c0233d, n nVar2) {
        this.f2752a = context;
        this.f2753b = c0233d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        int i;
        boolean isLocationEnabled;
        List<ResolveInfo> queryIntentActivities;
        PackageManager.ResolveInfoFlags of;
        int i3 = 1;
        String str = methodCall.method;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1544053025:
                if (str.equals("checkServiceStatus")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1017315255:
                if (str.equals("shouldShowRequestPermissionRationale")) {
                    c4 = 1;
                    break;
                }
                break;
            case -576207927:
                if (str.equals("checkPermissionStatus")) {
                    c4 = 2;
                    break;
                }
                break;
            case 347240634:
                if (str.equals("openAppSettings")) {
                    c4 = 3;
                    break;
                }
                break;
            case 1669188213:
                if (str.equals("requestPermissions")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        Context context = this.f2752a;
        C0233d c0233d = this.f2753b;
        switch (c4) {
            case 0:
                int parseInt = Integer.parseInt(methodCall.arguments.toString());
                Objects.requireNonNull(result);
                if (context == null) {
                    result.error("PermissionHandler.ServiceManager", "Android context cannot be null.", null);
                    return;
                }
                if (parseInt != 3 && parseInt != 4 && parseInt != 5) {
                    if (parseInt == 21) {
                        result.success(Integer.valueOf(((BluetoothManager) context.getSystemService("bluetooth")).getAdapter().isEnabled() ? 1 : 0));
                        return;
                    }
                    if (parseInt == 8) {
                        PackageManager packageManager = context.getPackageManager();
                        if (!packageManager.hasSystemFeature("android.hardware.telephony")) {
                            result.success(2);
                            return;
                        }
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager != null && telephonyManager.getPhoneType() != 0) {
                            Intent intent = new Intent("android.intent.action.CALL");
                            intent.setData(Uri.parse("tel:123123"));
                            if (Build.VERSION.SDK_INT >= 33) {
                                of = PackageManager.ResolveInfoFlags.of(0L);
                                queryIntentActivities = packageManager.queryIntentActivities(intent, of);
                            } else {
                                queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                            }
                            if (queryIntentActivities.isEmpty()) {
                                result.success(2);
                                return;
                            } else if (telephonyManager.getSimState() != 5) {
                                result.success(0);
                                return;
                            } else {
                                result.success(1);
                                return;
                            }
                        }
                        result.success(2);
                        return;
                    }
                    if (parseInt == 16) {
                        result.success(1);
                        return;
                    } else {
                        result.success(2);
                        return;
                    }
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    LocationManager locationManager = (LocationManager) context.getSystemService(LocationManager.class);
                    if (locationManager != null) {
                        isLocationEnabled = locationManager.isLocationEnabled();
                        i = isLocationEnabled;
                    }
                    i = 0;
                } else {
                    try {
                        if (Settings.Secure.getInt(context.getContentResolver(), "location_mode") != 0) {
                            i = 1;
                        }
                    } catch (Settings.SettingNotFoundException e4) {
                        e4.printStackTrace();
                    }
                    i = 0;
                }
                result.success(Integer.valueOf(i));
                return;
            case 1:
                int parseInt2 = Integer.parseInt(methodCall.arguments.toString());
                Objects.requireNonNull(result);
                Activity activity = c0233d.f2759c;
                if (activity == null) {
                    result.error("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.", null);
                    return;
                }
                ArrayList w3 = T.b.w(activity, parseInt2);
                if (w3 == null) {
                    result.success(Boolean.FALSE);
                    return;
                } else if (w3.isEmpty()) {
                    result.success(Boolean.FALSE);
                    return;
                } else {
                    result.success(Boolean.valueOf(AbstractC0744b.e((String) w3.get(0), c0233d.f2759c)));
                    return;
                }
            case 2:
                int parseInt3 = Integer.parseInt(methodCall.arguments.toString());
                Objects.requireNonNull(result);
                result.success(Integer.valueOf(c0233d.a(parseInt3)));
                return;
            case 3:
                Objects.requireNonNull(result);
                if (context == null) {
                    result.error("PermissionHandler.AppSettingsManager", "Android context cannot be null.", null);
                    return;
                }
                try {
                    Intent intent2 = new Intent();
                    intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.addCategory("android.intent.category.DEFAULT");
                    intent2.setData(Uri.parse("package:" + context.getPackageName()));
                    intent2.addFlags(268435456);
                    intent2.addFlags(1073741824);
                    intent2.addFlags(8388608);
                    context.startActivity(intent2);
                    result.success(Boolean.TRUE);
                    return;
                } catch (Exception unused) {
                    result.success(Boolean.FALSE);
                    return;
                }
            case 4:
                List<Integer> list = (List) methodCall.arguments();
                Objects.requireNonNull(result);
                C0230a c0230a = new C0230a(0, result);
                if (c0233d.f2760d > 0) {
                    result.error("PermissionHandler.PermissionManager", "A request for permissions is already running, please wait for it to finish before doing another request (note that you can request multiple permissions at the same time).", null);
                    return;
                }
                if (c0233d.f2759c == null) {
                    result.error("PermissionHandler.PermissionManager", "Unable to detect current Android Activity.", null);
                    return;
                }
                c0233d.f2758b = c0230a;
                c0233d.f2761e = new HashMap();
                c0233d.f2760d = 0;
                ArrayList arrayList = new ArrayList();
                for (Integer num : list) {
                    if (c0233d.a(num.intValue()) == i3) {
                        if (!c0233d.f2761e.containsKey(num)) {
                            c0233d.f2761e.put(num, 1);
                        }
                    } else {
                        ArrayList w4 = T.b.w(c0233d.f2759c, num.intValue());
                        if (w4 != null && !w4.isEmpty()) {
                            int i4 = Build.VERSION.SDK_INT;
                            if (num.intValue() == 16) {
                                c0233d.c(209, "android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                            } else if (i4 >= 30 && num.intValue() == 22) {
                                c0233d.c(210, "android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                            } else if (num.intValue() == 23) {
                                c0233d.c(211, "android.settings.action.MANAGE_OVERLAY_PERMISSION");
                            } else if (i4 >= 26 && num.intValue() == 24) {
                                c0233d.c(212, "android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                            } else if (num.intValue() == 27) {
                                c0233d.c(213, "android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS");
                            } else if (i4 >= 31 && num.intValue() == 34) {
                                c0233d.c(214, "android.settings.REQUEST_SCHEDULE_EXACT_ALARM");
                            } else if (num.intValue() != 37 && num.intValue() != 0) {
                                arrayList.addAll(w4);
                                c0233d.f2760d = w4.size() + c0233d.f2760d;
                            } else if (c0233d.b()) {
                                arrayList.add("android.permission.WRITE_CALENDAR");
                                arrayList.add("android.permission.READ_CALENDAR");
                                c0233d.f2760d += 2;
                            } else {
                                c0233d.f2761e.put(num, 0);
                            }
                        } else if (!c0233d.f2761e.containsKey(num)) {
                            c0233d.f2761e.put(num, 0);
                            if (num.intValue() == 22 && Build.VERSION.SDK_INT < 30) {
                                c0233d.f2761e.put(num, 2);
                            } else {
                                c0233d.f2761e.put(num, 0);
                            }
                        }
                        i3 = 1;
                    }
                }
                if (arrayList.size() > 0) {
                    AbstractC0744b.d(c0233d.f2759c, (String[]) arrayList.toArray(new String[0]), 24);
                }
                C0230a c0230a2 = c0233d.f2758b;
                if (c0230a2 != null && c0233d.f2760d == 0) {
                    c0230a2.f2751b.success(c0233d.f2761e);
                    return;
                }
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
