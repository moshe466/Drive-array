package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class zzax extends zzq<String> {
    private final Object mLock;

    @Nullable
    @GuardedBy("mLock")
    private zzab<String> zzcn;

    public zzax(int i, String str, zzab<String> zzabVar, @Nullable zzy zzyVar) {
        super(i, str, zzyVar);
        this.mLock = new Object();
        this.zzcn = zzabVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzq
    public final zzz<String> a(zzo zzoVar) {
        String str;
        try {
            byte[] bArr = zzoVar.data;
            String str2 = "ISO-8859-1";
            String str3 = zzoVar.zzab.get("Content-Type");
            if (str3 != null) {
                String[] split = str3.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    String[] split2 = split[i].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals(HttpRequest.PARAM_CHARSET)) {
                        str2 = split2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzoVar.data);
        }
        return zzz.zza(str, zzas.zzb(zzoVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzq
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(String str) {
        zzab<String> zzabVar;
        synchronized (this.mLock) {
            zzabVar = this.zzcn;
        }
        if (zzabVar != null) {
            zzabVar.zzb(str);
        }
    }
}
