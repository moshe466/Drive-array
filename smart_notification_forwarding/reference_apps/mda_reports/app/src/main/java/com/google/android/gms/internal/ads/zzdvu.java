package com.google.android.gms.internal.ads;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class zzdvu {
    private static final Charset UTF_8 = Charset.forName(HttpRequest.CHARSET_UTF8);
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Object zzhtt = new Object();

    public static void zza(zzdvq zzdvqVar, zzdvq zzdvqVar2) {
        zzdvs zzdvsVar = zzdvqVar.b;
        if (zzdvsVar != null) {
            zzdvqVar2.b = (zzdvs) zzdvsVar.clone();
        }
    }
}
