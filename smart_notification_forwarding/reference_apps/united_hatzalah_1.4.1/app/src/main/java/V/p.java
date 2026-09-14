package V;

import J.G;
import java.nio.ByteBuffer;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: d, reason: collision with root package name */
    public static final ThreadLocal f2409d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final int f2410a;

    /* renamed from: b, reason: collision with root package name */
    public final K1.m f2411b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f2412c = 0;

    public p(K1.m mVar, int i) {
        this.f2411b = mVar;
        this.f2410a = i;
    }

    public final int a(int i) {
        W.a b4 = b();
        int a2 = b4.a(16);
        if (a2 != 0) {
            ByteBuffer byteBuffer = (ByteBuffer) b4.f946d;
            int i3 = a2 + b4.f943a;
            return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i3) + i3 + 4);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [J.G, java.lang.Object] */
    public final W.a b() {
        ThreadLocal threadLocal = f2409d;
        W.a aVar = (W.a) threadLocal.get();
        W.a aVar2 = aVar;
        if (aVar == null) {
            ?? g3 = new G();
            threadLocal.set(g3);
            aVar2 = g3;
        }
        W.b bVar = (W.b) this.f2411b.f1102a;
        int a2 = bVar.a(6);
        if (a2 != 0) {
            int i = a2 + bVar.f943a;
            int i3 = (this.f2410a * 4) + ((ByteBuffer) bVar.f946d).getInt(i) + i + 4;
            int i4 = ((ByteBuffer) bVar.f946d).getInt(i3) + i3;
            ByteBuffer byteBuffer = (ByteBuffer) bVar.f946d;
            aVar2.f946d = byteBuffer;
            if (byteBuffer != null) {
                aVar2.f943a = i4;
                int i5 = i4 - byteBuffer.getInt(i4);
                aVar2.f944b = i5;
                aVar2.f945c = ((ByteBuffer) aVar2.f946d).getShort(i5);
                return aVar2;
            }
            aVar2.f943a = 0;
            aVar2.f944b = 0;
            aVar2.f945c = 0;
        }
        return aVar2;
    }

    public final String toString() {
        int i;
        int i3;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        W.a b4 = b();
        int a2 = b4.a(4);
        if (a2 != 0) {
            i = ((ByteBuffer) b4.f946d).getInt(a2 + b4.f943a);
        } else {
            i = 0;
        }
        sb.append(Integer.toHexString(i));
        sb.append(", codepoints:");
        W.a b5 = b();
        int a4 = b5.a(16);
        if (a4 != 0) {
            int i4 = a4 + b5.f943a;
            i3 = ((ByteBuffer) b5.f946d).getInt(((ByteBuffer) b5.f946d).getInt(i4) + i4);
        } else {
            i3 = 0;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            sb.append(Integer.toHexString(a(i5)));
            sb.append(StringUtils.SPACE);
        }
        return sb.toString();
    }
}
