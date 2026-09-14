package b2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class i1 {

    /* renamed from: f, reason: collision with root package name */
    private static final Uri f4014f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a, reason: collision with root package name */
    private final String f4015a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4016b;

    /* renamed from: c, reason: collision with root package name */
    private final ComponentName f4017c;

    /* renamed from: d, reason: collision with root package name */
    private final int f4018d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f4019e;

    public i1(String str, String str2, int i10, boolean z10) {
        p.g(str);
        this.f4015a = str;
        p.g(str2);
        this.f4016b = str2;
        this.f4017c = null;
        this.f4018d = i10;
        this.f4019e = z10;
    }

    public final int a() {
        return this.f4018d;
    }

    public final ComponentName b() {
        return this.f4017c;
    }

    public final Intent c(Context context) {
        Bundle bundle;
        if (this.f4015a == null) {
            return new Intent().setComponent(this.f4017c);
        }
        if (this.f4019e) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", this.f4015a);
            try {
                bundle = context.getContentResolver().call(f4014f, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e10) {
                "Dynamic intent resolution failed: ".concat(e10.toString());
                bundle = null;
            }
            r1 = bundle != null ? (Intent) bundle.getParcelable("serviceResponseIntentKey") : null;
            if (r1 == null) {
                "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f4015a));
            }
        }
        return r1 != null ? r1 : new Intent(this.f4015a).setPackage(this.f4016b);
    }

    public final String d() {
        return this.f4016b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i1)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        return o.a(this.f4015a, i1Var.f4015a) && o.a(this.f4016b, i1Var.f4016b) && o.a(this.f4017c, i1Var.f4017c) && this.f4018d == i1Var.f4018d && this.f4019e == i1Var.f4019e;
    }

    public final int hashCode() {
        return o.b(this.f4015a, this.f4016b, this.f4017c, Integer.valueOf(this.f4018d), Boolean.valueOf(this.f4019e));
    }

    public final String toString() {
        String str = this.f4015a;
        if (str != null) {
            return str;
        }
        p.k(this.f4017c);
        return this.f4017c.flattenToString();
    }
}
