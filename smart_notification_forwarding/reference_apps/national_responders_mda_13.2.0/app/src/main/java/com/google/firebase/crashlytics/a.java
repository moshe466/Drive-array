package com.google.firebase.crashlytics;

import android.os.Bundle;
import p3.a;

/* loaded from: classes.dex */
class a implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private t3.b f7053a;

    /* renamed from: b, reason: collision with root package name */
    private t3.b f7054b;

    private static void b(t3.b bVar, String str, Bundle bundle) {
        if (bVar == null) {
            return;
        }
        bVar.o(str, bundle);
    }

    private void c(String str, Bundle bundle) {
        b("clx".equals(bundle.getString("_o")) ? this.f7053a : this.f7054b, str, bundle);
    }

    @Override // p3.a.b
    public void a(int i10, Bundle bundle) {
        String string;
        s3.b.f().b("Received Analytics message: " + i10 + " " + bundle);
        if (bundle == null || (string = bundle.getString("name")) == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("params");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        c(string, bundle2);
    }

    public void d(t3.b bVar) {
        this.f7054b = bVar;
    }

    public void e(t3.b bVar) {
        this.f7053a = bVar;
    }
}
