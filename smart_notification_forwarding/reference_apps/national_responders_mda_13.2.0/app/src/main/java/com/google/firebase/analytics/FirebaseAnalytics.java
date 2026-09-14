package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import b2.p;
import com.google.android.gms.internal.measurement.h;
import com.google.firebase.installations.f;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import v2.m;
import z2.o;

/* loaded from: classes.dex */
public final class FirebaseAnalytics {

    /* renamed from: b, reason: collision with root package name */
    private static volatile FirebaseAnalytics f7047b;

    /* renamed from: a, reason: collision with root package name */
    private final h f7048a;

    private FirebaseAnalytics(h hVar) {
        p.k(hVar);
        this.f7048a = hVar;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (f7047b == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f7047b == null) {
                    f7047b = new FirebaseAnalytics(h.a(context));
                }
            }
        }
        return f7047b;
    }

    @Keep
    public static m getScionFrontendApiImplementation(Context context, Bundle bundle) {
        h b10 = h.b(context, null, null, null, bundle);
        if (b10 == null) {
            return null;
        }
        return new a(b10);
    }

    @Keep
    public final String getFirebaseInstanceId() {
        try {
            return (String) o.b(f.l().e(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw new IllegalStateException(e10);
        } catch (ExecutionException e11) {
            throw new IllegalStateException(e11.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @Deprecated
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        this.f7048a.h(activity, str, str2);
    }
}
