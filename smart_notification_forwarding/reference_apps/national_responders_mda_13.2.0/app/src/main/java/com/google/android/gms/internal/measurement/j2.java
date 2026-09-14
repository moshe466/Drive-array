package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j2 implements i2 {

    /* renamed from: c, reason: collision with root package name */
    private static j2 f5406c;

    /* renamed from: a, reason: collision with root package name */
    private final Context f5407a;

    /* renamed from: b, reason: collision with root package name */
    private final ContentObserver f5408b;

    private j2() {
        this.f5407a = null;
        this.f5408b = null;
    }

    private j2(Context context) {
        this.f5407a = context;
        m2 m2Var = new m2(this, null);
        this.f5408b = m2Var;
        context.getContentResolver().registerContentObserver(a2.f5156a, true, m2Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j2 a(Context context) {
        j2 j2Var;
        synchronized (j2.class) {
            if (f5406c == null) {
                f5406c = androidx.core.content.d.b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new j2(context) : new j2();
            }
            j2Var = f5406c;
        }
        return j2Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void b() {
        Context context;
        synchronized (j2.class) {
            j2 j2Var = f5406c;
            if (j2Var != null && (context = j2Var.f5407a) != null && j2Var.f5408b != null) {
                context.getContentResolver().unregisterContentObserver(f5406c.f5408b);
            }
            f5406c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.i2
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final String e(final String str) {
        if (this.f5407a == null) {
            return null;
        }
        try {
            return (String) h2.a(new k2(this, str) { // from class: com.google.android.gms.internal.measurement.n2

                /* renamed from: a, reason: collision with root package name */
                private final j2 f5489a;

                /* renamed from: b, reason: collision with root package name */
                private final String f5490b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f5489a = this;
                    this.f5490b = str;
                }

                @Override // com.google.android.gms.internal.measurement.k2
                public final Object zza() {
                    return this.f5489a.c(this.f5490b);
                }
            });
        } catch (IllegalStateException | SecurityException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Unable to read GServices for: ".concat(valueOf);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String c(String str) {
        return a2.a(this.f5407a.getContentResolver(), str, null);
    }
}
