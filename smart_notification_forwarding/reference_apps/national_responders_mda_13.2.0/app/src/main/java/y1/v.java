package y1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.List;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private final Context f15884a;

    /* renamed from: b, reason: collision with root package name */
    private int f15885b;

    /* renamed from: c, reason: collision with root package name */
    private int f15886c = 0;

    public v(Context context) {
        this.f15884a = context;
    }

    private final PackageInfo b(String str) {
        try {
            return i2.c.a(this.f15884a).e(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            String valueOf = String.valueOf(e10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
            sb2.append("Failed to find package ");
            sb2.append(valueOf);
            return null;
        }
    }

    public final synchronized int a() {
        int i10 = this.f15886c;
        if (i10 != 0) {
            return i10;
        }
        PackageManager packageManager = this.f15884a.getPackageManager();
        if (i2.c.a(this.f15884a).b("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            return 0;
        }
        if (!g2.l.h()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f15886c = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.f15886c = 2;
            return 2;
        }
        if (g2.l.h()) {
            this.f15886c = 2;
        } else {
            this.f15886c = 1;
        }
        return this.f15886c;
    }

    public final synchronized int c() {
        PackageInfo b10;
        if (this.f15885b == 0 && (b10 = b("com.google.android.gms")) != null) {
            this.f15885b = b10.versionCode;
        }
        return this.f15885b;
    }
}
