package i5;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import f0.b;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f10737a;

    /* renamed from: i5.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0198a {
        public static void a(View view, Runnable runnable) {
            view.animate().alpha(0.0f).setDuration(300L).setInterpolator(new b());
            new Handler().postDelayed(runnable, 150L);
        }
    }

    public static boolean a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean b(Context context) {
        ComponentName componentName = new ComponentName(context, (Class<?>) j5.a.class);
        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) context.getSystemService("device_policy");
        return devicePolicyManager != null && devicePolicyManager.isAdminActive(componentName);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 22;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static boolean e(Context context, String str) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.MAIN");
        intentFilter.addCategory("android.intent.category.HOME");
        ArrayList arrayList = new ArrayList();
        arrayList.add(intentFilter);
        ArrayList arrayList2 = new ArrayList();
        context.getPackageManager().getPreferredActivities(arrayList, arrayList2, null);
        Iterator<ComponentName> it = arrayList2.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(Context context) {
        Boolean bool = f10737a;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(e(context, "com.sec.android.app.launcher"));
        f10737a = valueOf;
        return valueOf.booleanValue();
    }

    public static void g(String str, String str2) {
    }

    public static void h(String str, String str2) {
    }
}
