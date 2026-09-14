package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f7283c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static f0 f7284d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f7285a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f7286b;

    public f(Context context) {
        this.f7285a = context;
        this.f7286b = a.f7269f;
    }

    public f(Context context, ExecutorService executorService) {
        this.f7285a = context;
        this.f7286b = executorService;
    }

    private static z2.l<Integer> a(Context context, Intent intent) {
        return b(context, "com.google.firebase.MESSAGING_EVENT").c(intent).h(h.a(), d.f7279a);
    }

    private static f0 b(Context context, String str) {
        f0 f0Var;
        synchronized (f7283c) {
            if (f7284d == null) {
                f7284d = new f0(context, "com.google.firebase.MESSAGING_EVENT");
            }
            f0Var = f7284d;
        }
        return f0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Integer c(z2.l lVar) {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Integer e(z2.l lVar) {
        return 403;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ z2.l f(Context context, Intent intent, z2.l lVar) {
        return (g2.l.h() && ((Integer) lVar.l()).intValue() == 402) ? a(context, intent).h(h.a(), e.f7281a) : lVar;
    }

    public z2.l<Integer> g(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return h(this.f7285a, intent);
    }

    @SuppressLint({"InlinedApi"})
    public z2.l<Integer> h(final Context context, final Intent intent) {
        boolean z10 = false;
        if (g2.l.h() && context.getApplicationInfo().targetSdkVersion >= 26) {
            z10 = true;
        }
        return (z10 && (intent.getFlags() & 268435456) == 0) ? a(context, intent) : z2.o.c(this.f7286b, new Callable(context, intent) { // from class: com.google.firebase.iid.b

            /* renamed from: a, reason: collision with root package name */
            private final Context f7273a;

            /* renamed from: b, reason: collision with root package name */
            private final Intent f7274b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7273a = context;
                this.f7274b = intent;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                Integer valueOf;
                valueOf = Integer.valueOf(x.b().g(this.f7273a, this.f7274b));
                return valueOf;
            }
        }).j(this.f7286b, new z2.c(context, intent) { // from class: com.google.firebase.iid.c

            /* renamed from: a, reason: collision with root package name */
            private final Context f7276a;

            /* renamed from: b, reason: collision with root package name */
            private final Intent f7277b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f7276a = context;
                this.f7277b = intent;
            }

            @Override // z2.c
            public Object a(z2.l lVar) {
                return f.f(this.f7276a, this.f7277b, lVar);
            }
        });
    }
}
