package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.MurmurHash3;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.UnsupportedEncodingException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzqs {
    public static int zzbx(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes(HttpRequest.CHARSET_UTF8);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        return MurmurHash3.murmurhash3_x86_32(bytes, 0, bytes.length, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x007f, code lost:
    
        if (((r6 >= 65382 && r6 <= 65437) || (r6 >= 65441 && r6 <= 65500)) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c4, code lost:
    
        if (r4 == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00d4, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00d3, code lost:
    
        r5 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d1, code lost:
    
        if (r4 == false) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] zzd(@androidx.annotation.Nullable java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqs.zzd(java.lang.String, boolean):java.lang.String[]");
    }
}
