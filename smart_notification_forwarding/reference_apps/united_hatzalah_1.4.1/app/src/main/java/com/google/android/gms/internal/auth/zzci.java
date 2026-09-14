package com.google.android.gms.internal.auth;

import android.net.Uri;
import t.C0694j;

/* loaded from: classes.dex */
public final class zzci {
    private final C0694j zza;

    public zzci(C0694j c0694j) {
        this.zza = c0694j;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        if (uri == null) {
            return null;
        }
        C0694j c0694j = (C0694j) this.zza.get(uri.toString());
        if (c0694j == null) {
            return null;
        }
        return (String) c0694j.get("".concat(String.valueOf(str3)));
    }
}
