package com.google.android.recaptcha.internal;

import T.b;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.j;
import s2.C0682g;
import s2.InterfaceC0678c;

/* loaded from: classes.dex */
public final class zzfm {
    private final InterfaceC0678c zza;

    public zzfm() {
        int i = zzav.zza;
        this.zza = b.A(zzfl.zza);
    }

    public final HttpURLConnection zza(String str) {
        if (((zzfk) ((C0682g) this.zza).a()).zzb(str)) {
            URLConnection openConnection = new URL(str).openConnection();
            j.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            return (HttpURLConnection) openConnection;
        }
        throw new zzbd(zzbb.zzc, zzba.zzQ, null);
    }
}
