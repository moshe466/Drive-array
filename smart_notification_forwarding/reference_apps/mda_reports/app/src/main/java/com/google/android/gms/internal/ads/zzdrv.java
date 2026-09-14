package com.google.android.gms.internal.ads;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class zzdrv {
    public static final byte[] zzhng;
    private static final ByteBuffer zzhnh;
    private static final zzdqw zzhni;
    static final Charset a = Charset.forName(HttpRequest.CHARSET_UTF8);
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    static {
        byte[] bArr = new byte[0];
        zzhng = bArr;
        zzhnh = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzhng;
        zzhni = zzdqw.a(bArr2, 0, bArr2.length, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Object obj, Object obj2) {
        return ((zzdte) obj).zzazx().zzf((zzdte) obj2).zzbae();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(zzdte zzdteVar) {
        if (!(zzdteVar instanceof zzdqc)) {
            return false;
        }
        return false;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int a2 = a(length, bArr, 0, length);
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }

    public static int zzbp(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzfq(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static boolean zzy(byte[] bArr) {
        return zzdva.zzy(bArr);
    }

    public static String zzz(byte[] bArr) {
        return new String(bArr, a);
    }
}
