package a1;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.provider.Settings;
import com.google.android.gms.common.ConnectionResult;
import com.google.firebase.remoteconfig.internal.Code;
import io.flutter.Build;
import io.flutter.plugin.common.PluginRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* renamed from: a1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0233d implements PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2757a;

    /* renamed from: b, reason: collision with root package name */
    public C0230a f2758b;

    /* renamed from: c, reason: collision with root package name */
    public Activity f2759c;

    /* renamed from: d, reason: collision with root package name */
    public int f2760d;

    /* renamed from: e, reason: collision with root package name */
    public HashMap f2761e;

    public C0233d(Context context) {
        this.f2757a = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0021, code lost:
    
        if (new w.p(r6).f6677a.areNotificationsEnabled() != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(int r18) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.C0233d.a(int):int");
    }

    public final boolean b() {
        boolean z3;
        boolean z4;
        ArrayList w3 = T.b.w(this.f2757a, 37);
        if (w3 != null && w3.contains("android.permission.WRITE_CALENDAR")) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (w3 != null && w3.contains("android.permission.READ_CALENDAR")) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z3 || !z4) {
            return false;
        }
        return true;
    }

    public final void c(int i, String str) {
        if (this.f2759c == null) {
            return;
        }
        Intent intent = new Intent(str);
        if (!str.equals("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS")) {
            intent.setData(Uri.parse("package:" + this.f2759c.getPackageName()));
        }
        this.f2759c.startActivityForResult(intent, i);
        this.f2760d++;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public final boolean onActivityResult(int i, int i3, Intent intent) {
        boolean z3;
        int i4;
        boolean canScheduleExactAlarms;
        boolean canRequestPackageInstalls;
        boolean isExternalStorageManager;
        int i5;
        Activity activity = this.f2759c;
        boolean z4 = false;
        z4 = false;
        if (activity != null) {
            if (this.f2761e == null) {
                this.f2760d = 0;
                return false;
            }
            if (i == 209) {
                Context context = this.f2757a;
                String packageName = context.getPackageName();
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null && powerManager.isIgnoringBatteryOptimizations(packageName)) {
                    z4 = true;
                }
                i4 = 16;
                i5 = z4;
            } else if (i == 210) {
                if (Build.VERSION.SDK_INT >= 30) {
                    isExternalStorageManager = Environment.isExternalStorageManager();
                    i4 = 22;
                    i5 = isExternalStorageManager;
                }
            } else if (i == 211) {
                i4 = 23;
                i5 = Settings.canDrawOverlays(activity);
            } else if (i == 212) {
                if (Build.VERSION.SDK_INT >= 26) {
                    canRequestPackageInstalls = activity.getPackageManager().canRequestPackageInstalls();
                    i4 = 24;
                    i5 = canRequestPackageInstalls;
                }
            } else if (i == 213) {
                i4 = 27;
                i5 = ((NotificationManager) activity.getSystemService("notification")).isNotificationPolicyAccessGranted();
            } else if (i == 214) {
                AlarmManager alarmManager = (AlarmManager) activity.getSystemService("alarm");
                if (Build.VERSION.SDK_INT >= 31) {
                    canScheduleExactAlarms = alarmManager.canScheduleExactAlarms();
                    z3 = canScheduleExactAlarms;
                } else {
                    z3 = true;
                }
                i4 = 34;
                i5 = z3;
            }
            this.f2761e.put(Integer.valueOf(i4), Integer.valueOf(i5));
            int i6 = this.f2760d - 1;
            this.f2760d = i6;
            C0230a c0230a = this.f2758b;
            if (c0230a != null && i6 == 0) {
                c0230a.f2751b.success(this.f2761e);
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x00c1. Please report as an issue. */
    @Override // io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener
    public final boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i3;
        int i4 = 8;
        if (i != 24) {
            this.f2760d = 0;
            return false;
        }
        if (this.f2761e == null) {
            return false;
        }
        if (strArr.length == 0 && iArr.length == 0) {
            this.f2760d = 0;
            return false;
        }
        List asList = Arrays.asList(strArr);
        int indexOf = asList.indexOf("android.permission.WRITE_CALENDAR");
        if (indexOf >= 0) {
            int O3 = T.b.O(this.f2759c, "android.permission.WRITE_CALENDAR", iArr[indexOf]);
            this.f2761e.put(36, Integer.valueOf(O3));
            int indexOf2 = asList.indexOf("android.permission.READ_CALENDAR");
            if (indexOf2 >= 0) {
                int O4 = T.b.O(this.f2759c, "android.permission.READ_CALENDAR", iArr[indexOf2]);
                Integer valueOf = Integer.valueOf(O3);
                Integer valueOf2 = Integer.valueOf(O4);
                HashSet hashSet = new HashSet();
                hashSet.add(valueOf);
                hashSet.add(valueOf2);
                Integer J3 = T.b.J(hashSet);
                this.f2761e.put(37, J3);
                this.f2761e.put(0, J3);
            }
        }
        int i5 = 0;
        while (i5 < strArr.length) {
            String str = strArr[i5];
            if (!str.equals("android.permission.WRITE_CALENDAR") && !str.equals("android.permission.READ_CALENDAR")) {
                int i6 = -1;
                switch (str.hashCode()) {
                    case -2062386608:
                        if (str.equals("android.permission.READ_SMS")) {
                            i6 = 0;
                            break;
                        }
                        break;
                    case -1928411001:
                        if (str.equals("android.permission.READ_CALENDAR")) {
                            i6 = 1;
                            break;
                        }
                        break;
                    case -1925850455:
                        if (str.equals("android.permission.POST_NOTIFICATIONS")) {
                            i6 = 2;
                            break;
                        }
                        break;
                    case -1921431796:
                        if (str.equals("android.permission.READ_CALL_LOG")) {
                            i6 = 3;
                            break;
                        }
                        break;
                    case -1888586689:
                        if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                            i6 = 4;
                            break;
                        }
                        break;
                    case -1813079487:
                        if (str.equals("android.permission.MANAGE_EXTERNAL_STORAGE")) {
                            i6 = 5;
                            break;
                        }
                        break;
                    case -1783097621:
                        if (str.equals("android.permission.ACCESS_NOTIFICATION_POLICY")) {
                            i6 = 6;
                            break;
                        }
                        break;
                    case -1561629405:
                        if (str.equals("android.permission.SYSTEM_ALERT_WINDOW")) {
                            i6 = 7;
                            break;
                        }
                        break;
                    case -1479758289:
                        if (str.equals("android.permission.RECEIVE_WAP_PUSH")) {
                            i6 = i4;
                            break;
                        }
                        break;
                    case -1238066820:
                        if (str.equals("android.permission.BODY_SENSORS")) {
                            i6 = 9;
                            break;
                        }
                        break;
                    case -1164582768:
                        if (str.equals("android.permission.READ_PHONE_NUMBERS")) {
                            i6 = 10;
                            break;
                        }
                        break;
                    case -909527021:
                        if (str.equals("android.permission.NEARBY_WIFI_DEVICES")) {
                            i6 = 11;
                            break;
                        }
                        break;
                    case -895679497:
                        if (str.equals("android.permission.RECEIVE_MMS")) {
                            i6 = 12;
                            break;
                        }
                        break;
                    case -895673731:
                        if (str.equals("android.permission.RECEIVE_SMS")) {
                            i6 = 13;
                            break;
                        }
                        break;
                    case -798669607:
                        if (str.equals("android.permission.BLUETOOTH_CONNECT")) {
                            i6 = 14;
                            break;
                        }
                        break;
                    case -406040016:
                        if (str.equals("android.permission.READ_EXTERNAL_STORAGE")) {
                            i6 = 15;
                            break;
                        }
                        break;
                    case -63024214:
                        if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                            i6 = 16;
                            break;
                        }
                        break;
                    case -5573545:
                        if (str.equals("android.permission.READ_PHONE_STATE")) {
                            i6 = 17;
                            break;
                        }
                        break;
                    case 52602690:
                        if (str.equals("android.permission.SEND_SMS")) {
                            i6 = 18;
                            break;
                        }
                        break;
                    case 112197485:
                        if (str.equals("android.permission.CALL_PHONE")) {
                            i6 = 19;
                            break;
                        }
                        break;
                    case 175802396:
                        if (str.equals("android.permission.READ_MEDIA_IMAGES")) {
                            i6 = 20;
                            break;
                        }
                        break;
                    case 214526995:
                        if (str.equals("android.permission.WRITE_CONTACTS")) {
                            i6 = 21;
                            break;
                        }
                        break;
                    case 361658321:
                        if (str.equals("android.permission.BODY_SENSORS_BACKGROUND")) {
                            i6 = 22;
                            break;
                        }
                        break;
                    case 463403621:
                        if (str.equals("android.permission.CAMERA")) {
                            i6 = 23;
                            break;
                        }
                        break;
                    case 603653886:
                        if (str.equals("android.permission.WRITE_CALENDAR")) {
                            i6 = 24;
                            break;
                        }
                        break;
                    case 610633091:
                        if (str.equals("android.permission.WRITE_CALL_LOG")) {
                            i6 = 25;
                            break;
                        }
                        break;
                    case 691260818:
                        if (str.equals("android.permission.READ_MEDIA_AUDIO")) {
                            i6 = 26;
                            break;
                        }
                        break;
                    case 710297143:
                        if (str.equals("android.permission.READ_MEDIA_VIDEO")) {
                            i6 = 27;
                            break;
                        }
                        break;
                    case 784519842:
                        if (str.equals("android.permission.USE_SIP")) {
                            i6 = 28;
                            break;
                        }
                        break;
                    case 970694249:
                        if (str.equals("android.permission.SCHEDULE_EXACT_ALARM")) {
                            i6 = 29;
                            break;
                        }
                        break;
                    case 1166454870:
                        if (str.equals("android.permission.BLUETOOTH_ADVERTISE")) {
                            i6 = 30;
                            break;
                        }
                        break;
                    case 1271781903:
                        if (str.equals("android.permission.GET_ACCOUNTS")) {
                            i6 = 31;
                            break;
                        }
                        break;
                    case 1365911975:
                        if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                            i6 = 32;
                            break;
                        }
                        break;
                    case 1777263169:
                        if (str.equals("android.permission.REQUEST_INSTALL_PACKAGES")) {
                            i6 = 33;
                            break;
                        }
                        break;
                    case 1780337063:
                        if (str.equals("android.permission.ACTIVITY_RECOGNITION")) {
                            i6 = 34;
                            break;
                        }
                        break;
                    case 1831139720:
                        if (str.equals("android.permission.RECORD_AUDIO")) {
                            i6 = 35;
                            break;
                        }
                        break;
                    case 1977429404:
                        if (str.equals("android.permission.READ_CONTACTS")) {
                            i6 = 36;
                            break;
                        }
                        break;
                    case 2024715147:
                        if (str.equals("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                            i6 = 37;
                            break;
                        }
                        break;
                    case 2062356686:
                        if (str.equals("android.permission.BLUETOOTH_SCAN")) {
                            i6 = 38;
                            break;
                        }
                        break;
                    case 2114579147:
                        if (str.equals("android.permission.ACCESS_MEDIA_LOCATION")) {
                            i6 = 39;
                            break;
                        }
                        break;
                    case 2133799037:
                        if (str.equals("com.android.voicemail.permission.ADD_VOICEMAIL")) {
                            i6 = 40;
                            break;
                        }
                        break;
                }
                switch (i6) {
                    case 0:
                    case 8:
                    case Code.UNIMPLEMENTED /* 12 */:
                    case 13:
                    case ConnectionResult.SERVICE_UPDATING /* 18 */:
                        i3 = 13;
                        break;
                    case 1:
                    case 24:
                        i3 = 0;
                        break;
                    case 2:
                        i3 = 17;
                        break;
                    case 3:
                    case 10:
                    case 17:
                    case 19:
                    case Build.API_LEVELS.API_25 /* 25 */:
                    case Build.API_LEVELS.API_28 /* 28 */:
                    case 40:
                        i3 = i4;
                        break;
                    case 4:
                    case 16:
                        i3 = 3;
                        break;
                    case 5:
                        i3 = 22;
                        break;
                    case 6:
                        i3 = 27;
                        break;
                    case 7:
                        i3 = 23;
                        break;
                    case 9:
                        i3 = 12;
                        break;
                    case 11:
                        i3 = 31;
                        break;
                    case 14:
                        i3 = 30;
                        break;
                    case 15:
                    case 32:
                        i3 = 15;
                        break;
                    case 20:
                        i3 = 9;
                        break;
                    case 21:
                    case Build.API_LEVELS.API_31 /* 31 */:
                    case Build.API_LEVELS.API_36 /* 36 */:
                        i3 = 2;
                        break;
                    case 22:
                        i3 = 35;
                        break;
                    case 23:
                        i3 = 1;
                        break;
                    case Build.API_LEVELS.API_26 /* 26 */:
                        i3 = 33;
                        break;
                    case Build.API_LEVELS.API_27 /* 27 */:
                        i3 = 32;
                        break;
                    case Build.API_LEVELS.API_29 /* 29 */:
                        i3 = 34;
                        break;
                    case Build.API_LEVELS.API_30 /* 30 */:
                        i3 = 29;
                        break;
                    case Build.API_LEVELS.API_33 /* 33 */:
                        i3 = 24;
                        break;
                    case Build.API_LEVELS.API_34 /* 34 */:
                        i3 = 19;
                        break;
                    case Build.API_LEVELS.API_35 /* 35 */:
                        i3 = 7;
                        break;
                    case 37:
                        i3 = 4;
                        break;
                    case 38:
                        i3 = 28;
                        break;
                    case 39:
                        i3 = 18;
                        break;
                    default:
                        i3 = 20;
                        break;
                }
                if (i3 != 20) {
                    int i7 = iArr[i5];
                    if (i3 == i4) {
                        Integer num = (Integer) this.f2761e.get(8);
                        Integer valueOf3 = Integer.valueOf(T.b.O(this.f2759c, str, i7));
                        HashSet hashSet2 = new HashSet();
                        hashSet2.add(num);
                        hashSet2.add(valueOf3);
                        this.f2761e.put(8, T.b.J(hashSet2));
                    } else if (i3 == 7) {
                        if (!this.f2761e.containsKey(7)) {
                            this.f2761e.put(7, Integer.valueOf(T.b.O(this.f2759c, str, i7)));
                        }
                        if (!this.f2761e.containsKey(14)) {
                            this.f2761e.put(14, Integer.valueOf(T.b.O(this.f2759c, str, i7)));
                        }
                    } else if (i3 == 4) {
                        int O5 = T.b.O(this.f2759c, str, i7);
                        if (!this.f2761e.containsKey(4)) {
                            this.f2761e.put(4, Integer.valueOf(O5));
                        }
                    } else if (i3 == 3) {
                        int O6 = T.b.O(this.f2759c, str, i7);
                        if (Build.VERSION.SDK_INT < 29 && !this.f2761e.containsKey(4)) {
                            this.f2761e.put(4, Integer.valueOf(O6));
                        }
                        if (!this.f2761e.containsKey(5)) {
                            this.f2761e.put(5, Integer.valueOf(O6));
                        }
                        this.f2761e.put(Integer.valueOf(i3), Integer.valueOf(O6));
                    } else if (i3 != 9 && i3 != 32) {
                        if (!this.f2761e.containsKey(Integer.valueOf(i3))) {
                            this.f2761e.put(Integer.valueOf(i3), Integer.valueOf(T.b.O(this.f2759c, str, i7)));
                        }
                    } else {
                        this.f2761e.put(Integer.valueOf(i3), Integer.valueOf(a(i3)));
                    }
                }
            }
            i5++;
            i4 = 8;
        }
        int length = this.f2760d - iArr.length;
        this.f2760d = length;
        C0230a c0230a = this.f2758b;
        if (c0230a != null && length == 0) {
            c0230a.f2751b.success(this.f2761e);
        }
        return true;
    }
}
