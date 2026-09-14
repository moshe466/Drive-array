package o7;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class a {
    public abstract void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(byte[] bArr, String str, String str2) {
        String a10 = m7.a.a(m7.a.b(bArr, b.Z), b.f12527n0);
        String str3 = new String(m7.a.c(bArr, b.f12514a0), "UTF-8");
        String str4 = new String(m7.a.c(bArr, b.f12516c0), "UTF-8");
        String str5 = new String(m7.a.c(bArr, b.f12517d0), "UTF-8");
        Double valueOf = Double.valueOf(ByteBuffer.wrap(m7.a.b(bArr, b.f12518e0)).getDouble());
        Double valueOf2 = Double.valueOf(ByteBuffer.wrap(m7.a.b(bArr, b.f12519f0)).getDouble());
        Short valueOf3 = Short.valueOf(ByteBuffer.wrap(m7.a.b(bArr, b.f12520g0)).getShort());
        Long valueOf4 = Long.valueOf(ByteBuffer.wrap(m7.a.b(bArr, b.f12521h0)).getLong());
        a(str, a10, str3, str2, str4, str5, valueOf3 + ":" + valueOf + "," + valueOf2 + ":" + valueOf4, valueOf4.longValue());
    }

    public abstract boolean c(String str);
}
