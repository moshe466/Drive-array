package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* renamed from: androidx.datastore.preferences.protobuf.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0255w {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f3236a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f3237b;

    static {
        Charset.forName("US-ASCII");
        f3236a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f3237b = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new C0241h(bArr, 0, 0, false).l(0);
        } catch (InvalidProtocolBufferException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new NullPointerException(str);
        }
    }

    public static int b(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }
}
