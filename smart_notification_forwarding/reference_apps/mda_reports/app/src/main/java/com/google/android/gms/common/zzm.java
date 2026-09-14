package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public class zzm {
    private static final zzm zzac = new zzm(true, null, null);
    final boolean a;
    private final Throwable cause;
    private final String zzae;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.a = z;
        this.zzae = str;
        this.cause = th;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzm a(@NonNull String str) {
        return new zzm(false, str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzm a(@NonNull String str, @NonNull Throwable th) {
        return new zzm(false, str, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzm a(Callable<String> callable) {
        return new zzo(callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, zze zzeVar, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", z2 ? "debug cert rejected" : "not whitelisted", str, Hex.bytesToStringLowercase(AndroidUtilsLight.zzj(CommonUtils.SHA1_INSTANCE).digest(zzeVar.c())), Boolean.valueOf(z), "12451009.false");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzm c() {
        return zzac;
    }

    @Nullable
    String a() {
        return this.zzae;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        if (this.a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.cause != null) {
            Log.d("GoogleCertificatesRslt", a(), this.cause);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
