package com.google.android.gms.internal.auth;

import android.net.Uri;
import t.C0689e;
import t.C0694j;

/* loaded from: classes.dex */
public final class zzcr {
    private static final C0689e zza = new C0694j(0);

    public static synchronized Uri zza(String str) {
        synchronized (zzcr.class) {
            C0689e c0689e = zza;
            Uri uri = (Uri) c0689e.get("com.google.android.gms.auth_account");
            if (uri == null) {
                Uri parse = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(Uri.encode("com.google.android.gms.auth_account"))));
                c0689e.put("com.google.android.gms.auth_account", parse);
                return parse;
            }
            return uri;
        }
    }
}
