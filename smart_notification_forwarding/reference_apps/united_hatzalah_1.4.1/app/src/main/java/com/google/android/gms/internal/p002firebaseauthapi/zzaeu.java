package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.LibraryVersion;
import e0.a;
import java.util.List;

/* loaded from: classes.dex */
public final class zzaeu {
    private final int zza;

    private zzaeu(String str) {
        this.zza = zza(str);
    }

    private static int zza(String str) {
        try {
            List<String> zza = zzv.zza("[.-]").zza((CharSequence) str);
            if (zza.size() == 1) {
                return Integer.parseInt(str);
            }
            if (zza.size() < 3) {
                return -1;
            }
            return (Integer.parseInt(zza.get(1)) * 1000) + (Integer.parseInt(zza.get(0)) * 1000000) + Integer.parseInt(zza.get(2));
        } catch (IllegalArgumentException e4) {
            if (!Log.isLoggable("LibraryVersionContainer", 3)) {
                return -1;
            }
            String.format("Version code parsing failed for: %s with exception %s.", str, e4);
            return -1;
        }
    }

    public final String zzb() {
        return a.d("X", Integer.toString(this.zza));
    }

    public static zzaeu zza() {
        String version = LibraryVersion.getInstance().getVersion("firebase-auth");
        if (TextUtils.isEmpty(version) || version.equals("UNKNOWN")) {
            version = "-1";
        }
        return new zzaeu(version);
    }
}
