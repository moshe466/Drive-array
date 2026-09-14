package com.google.firebase.messaging;

import android.R;
import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.k;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f7400a = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* renamed from: com.google.firebase.messaging.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0093a {

        /* renamed from: a, reason: collision with root package name */
        public final k.e f7401a;

        /* renamed from: b, reason: collision with root package name */
        public final String f7402b;

        /* renamed from: c, reason: collision with root package name */
        public final int f7403c = 0;

        C0093a(k.e eVar, String str, int i10) {
            this.f7401a = eVar;
            this.f7402b = str;
        }
    }

    private static PendingIntent a(Context context, v vVar, String str, PackageManager packageManager) {
        Intent f10 = f(str, vVar, packageManager);
        if (f10 == null) {
            return null;
        }
        f10.addFlags(67108864);
        f10.putExtras(vVar.y());
        PendingIntent activity = PendingIntent.getActivity(context, g(), f10, 1073741824);
        return p(vVar) ? q(context, vVar, activity) : activity;
    }

    private static PendingIntent b(Context context, v vVar) {
        if (p(vVar)) {
            return c(context, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(vVar.x()));
        }
        return null;
    }

    private static PendingIntent c(Context context, Intent intent) {
        return PendingIntent.getBroadcast(context, g(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(context, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), 1073741824);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C0093a d(Context context, v vVar) {
        Bundle j10 = j(context.getPackageManager(), context.getPackageName());
        return e(context, context.getPackageName(), vVar, k(context, vVar.k(), j10), context.getResources(), context.getPackageManager(), j10);
    }

    public static C0093a e(Context context, String str, v vVar, String str2, Resources resources, PackageManager packageManager, Bundle bundle) {
        k.e eVar = new k.e(context, str2);
        String n10 = vVar.n(resources, str, "gcm.n.title");
        if (!TextUtils.isEmpty(n10)) {
            eVar.k(n10);
        }
        String n11 = vVar.n(resources, str, "gcm.n.body");
        if (!TextUtils.isEmpty(n11)) {
            eVar.j(n11);
            eVar.y(new k.c().h(n11));
        }
        eVar.w(l(packageManager, resources, str, vVar.p("gcm.n.icon"), bundle));
        Uri m10 = m(str, vVar, resources);
        if (m10 != null) {
            eVar.x(m10);
        }
        eVar.i(a(context, vVar, str, packageManager));
        PendingIntent b10 = b(context, vVar);
        if (b10 != null) {
            eVar.m(b10);
        }
        Integer h10 = h(context, vVar.p("gcm.n.color"), bundle);
        if (h10 != null) {
            eVar.h(h10.intValue());
        }
        eVar.f(!vVar.a("gcm.n.sticky"));
        eVar.q(vVar.a("gcm.n.local_only"));
        String p10 = vVar.p("gcm.n.ticker");
        if (p10 != null) {
            eVar.z(p10);
        }
        Integer m11 = vVar.m();
        if (m11 != null) {
            eVar.t(m11.intValue());
        }
        Integer r10 = vVar.r();
        if (r10 != null) {
            eVar.B(r10.intValue());
        }
        Integer l10 = vVar.l();
        if (l10 != null) {
            eVar.r(l10.intValue());
        }
        Long j10 = vVar.j("gcm.n.event_time");
        if (j10 != null) {
            eVar.v(true);
            eVar.C(j10.longValue());
        }
        long[] q10 = vVar.q();
        if (q10 != null) {
            eVar.A(q10);
        }
        int[] e10 = vVar.e();
        if (e10 != null) {
            eVar.p(e10[0], e10[1], e10[2]);
        }
        eVar.l(i(vVar));
        return new C0093a(eVar, n(vVar), 0);
    }

    private static Intent f(String str, v vVar, PackageManager packageManager) {
        String p10 = vVar.p("gcm.n.click_action");
        if (!TextUtils.isEmpty(p10)) {
            Intent intent = new Intent(p10);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri f10 = vVar.f();
        if (f10 == null) {
            return packageManager.getLaunchIntentForPackage(str);
        }
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setPackage(str);
        intent2.setData(f10);
        return intent2;
    }

    private static int g() {
        return f7400a.incrementAndGet();
    }

    private static Integer h(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 56);
                sb2.append("Color is invalid: ");
                sb2.append(str);
                sb2.append(". Notification will use default color.");
            }
        }
        int i10 = bundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i10 != 0) {
            try {
                return Integer.valueOf(androidx.core.content.a.d(context, i10));
            } catch (Resources.NotFoundException unused2) {
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    private static int i(v vVar) {
        boolean a10 = vVar.a("gcm.n.default_sound");
        ?? r02 = a10;
        if (vVar.a("gcm.n.default_vibrate_timings")) {
            r02 = (a10 ? 1 : 0) | 2;
        }
        return vVar.a("gcm.n.default_light_settings") ? r02 | 4 : r02;
    }

    private static Bundle j(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle;
                }
            }
        } catch (PackageManager.NameNotFoundException e10) {
            String valueOf = String.valueOf(e10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 35);
            sb2.append("Couldn't get own application info: ");
            sb2.append(valueOf);
        }
        return Bundle.EMPTY;
    }

    @TargetApi(26)
    public static String k(Context context, String str, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion >= 26) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                if (!TextUtils.isEmpty(str)) {
                    if (notificationManager.getNotificationChannel(str) != null) {
                        return str;
                    }
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 122);
                    sb2.append("Notification Channel requested (");
                    sb2.append(str);
                    sb2.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                }
                String string = bundle.getString("com.google.firebase.messaging.default_notification_channel_id");
                if (!TextUtils.isEmpty(string) && notificationManager.getNotificationChannel(string) != null) {
                    return string;
                }
                if (notificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
                    int identifier = context.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", context.getPackageName());
                    notificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", identifier == 0 ? "Misc" : context.getString(identifier), 3));
                }
                return "fcm_fallback_notification_channel";
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static int l(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && o(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && o(resources, identifier2)) {
                return identifier2;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 61);
            sb2.append("Icon resource ");
            sb2.append(str2);
            sb2.append(" not found. Notification will use default icon.");
        }
        int i10 = bundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i10 == 0 || !o(resources, i10)) {
            try {
                i10 = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e10) {
                String valueOf = String.valueOf(e10);
                StringBuilder sb3 = new StringBuilder(valueOf.length() + 35);
                sb3.append("Couldn't get own application info: ");
                sb3.append(valueOf);
            }
        }
        return (i10 == 0 || !o(resources, i10)) ? R.drawable.sym_def_app_icon : i10;
    }

    private static Uri m(String str, v vVar, Resources resources) {
        String o10 = vVar.o();
        if (TextUtils.isEmpty(o10)) {
            return null;
        }
        if ("default".equals(o10) || resources.getIdentifier(o10, "raw", str) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(o10).length());
        sb2.append("android.resource://");
        sb2.append(str);
        sb2.append("/raw/");
        sb2.append(o10);
        return Uri.parse(sb2.toString());
    }

    private static String n(v vVar) {
        String p10 = vVar.p("gcm.n.tag");
        if (!TextUtils.isEmpty(p10)) {
            return p10;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("FCM-Notification:");
        sb2.append(uptimeMillis);
        return sb2.toString();
    }

    @TargetApi(26)
    private static boolean o(Resources resources, int i10) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(resources.getDrawable(i10, null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb2 = new StringBuilder(77);
            sb2.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb2.append(i10);
            return false;
        } catch (Resources.NotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(66);
            sb3.append("Couldn't find resource ");
            sb3.append(i10);
            sb3.append(", treating it as an invalid icon");
            return false;
        }
    }

    static boolean p(v vVar) {
        return vVar.a("google.c.a.e");
    }

    private static PendingIntent q(Context context, v vVar, PendingIntent pendingIntent) {
        return c(context, new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN").putExtras(vVar.x()).putExtra("pending_intent", pendingIntent));
    }
}
