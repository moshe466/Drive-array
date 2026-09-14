package com.google.android.recaptcha.internal;

import java.net.HttpURLConnection;
import kotlin.jvm.internal.f;
import org.apache.tika.metadata.HttpHeaders;

/* loaded from: classes.dex */
public final class zzex {
    private final zzfm zza;

    /* JADX WARN: Multi-variable type inference failed */
    public zzex() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final zzew zza(String str) {
        try {
            HttpURLConnection zza = this.zza.zza(str);
            zza.setRequestMethod("POST");
            zza.setDoOutput(true);
            zza.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-protobuffer");
            return new zzew(zza);
        } catch (zzbd e4) {
            throw e4;
        } catch (Exception e5) {
            throw new zzbd(zzbb.zzc, zzba.zzai, e5.getMessage());
        }
    }

    public /* synthetic */ zzex(zzfm zzfmVar, int i, f fVar) {
        this.zza = new zzfm();
    }
}
