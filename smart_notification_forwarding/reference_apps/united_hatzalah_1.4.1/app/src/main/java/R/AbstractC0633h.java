package r;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import b.InterfaceC0319d;
import java.util.ArrayList;
import java.util.List;

/* renamed from: r.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0633h {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0319d f6183a;

    /* renamed from: b, reason: collision with root package name */
    public final ComponentName f6184b;

    public AbstractC0633h(InterfaceC0319d interfaceC0319d, ComponentName componentName) {
        this.f6183a = interfaceC0319d;
        this.f6184b = componentName;
    }

    public static String a(Context context, List list, boolean z3) {
        List<String> list2;
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        if (list == null) {
            list2 = new ArrayList();
        } else {
            list2 = list;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z3 && (resolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveActivity.activityInfo.packageName;
            ArrayList arrayList = new ArrayList(list2.size() + 1);
            arrayList.add(str);
            if (list != null) {
                arrayList.addAll(list);
            }
            list2 = arrayList;
        }
        Intent intent2 = new Intent("android.support.customtabs.action.CustomTabsService");
        for (String str2 : list2) {
            intent2.setPackage(str2);
            if (packageManager.resolveService(intent2, 0) != null) {
                return str2;
            }
        }
        return null;
    }
}
