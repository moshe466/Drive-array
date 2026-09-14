package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

/* loaded from: classes.dex */
public final class w9 {

    /* renamed from: a, reason: collision with root package name */
    private final t4 f6609a;

    public w9(t4 t4Var) {
        this.f6609a = t4Var;
    }

    private final boolean d() {
        return e() && this.f6609a.f().a() - this.f6609a.x().B.a() > this.f6609a.a().q(null, s.E0);
    }

    private final boolean e() {
        return this.f6609a.x().B.a() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        this.f6609a.e().c();
        if (e()) {
            if (d()) {
                this.f6609a.x().A.b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                this.f6609a.F().R("auto", "_cmpx", bundle);
            } else {
                String a10 = this.f6609a.x().A.a();
                if (TextUtils.isEmpty(a10)) {
                    this.f6609a.h().G().a("Cache still valid but referrer not found");
                } else {
                    long a11 = ((this.f6609a.x().B.a() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(a10);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String str : parse.getQueryParameterNames()) {
                        bundle2.putString(str, parse.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", a11);
                    this.f6609a.F().R((String) pair.first, "_cmp", (Bundle) pair.second);
                }
                this.f6609a.x().A.b(null);
            }
            this.f6609a.x().B.b(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str, Bundle bundle) {
        String str2;
        this.f6609a.e().c();
        if (this.f6609a.p()) {
            return;
        }
        if (bundle == null || bundle.isEmpty()) {
            str2 = null;
        } else {
            if (str == null || str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str3 : bundle.keySet()) {
                builder.appendQueryParameter(str3, bundle.getString(str3));
            }
            str2 = builder.build().toString();
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f6609a.x().A.b(str2);
        this.f6609a.x().B.b(this.f6609a.f().a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        if (e() && d()) {
            this.f6609a.x().A.b(null);
        }
    }
}
