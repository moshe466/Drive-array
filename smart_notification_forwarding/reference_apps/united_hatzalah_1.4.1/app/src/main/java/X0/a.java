package X0;

import F0.AbstractC0008a;
import io.flutter.embedding.android.KeyboardMap;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import p3.h;

/* loaded from: classes.dex */
public final class a {
    public static final M0.a i = new M0.a(2);

    /* renamed from: a, reason: collision with root package name */
    public final short f2575a;

    /* renamed from: b, reason: collision with root package name */
    public final short f2576b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2577c;

    /* renamed from: d, reason: collision with root package name */
    public final long f2578d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2579e;

    /* renamed from: f, reason: collision with root package name */
    public final long f2580f;

    /* renamed from: g, reason: collision with root package name */
    public final String f2581g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2582h;

    public a(short s3, short s4, long j2, long j3, long j4, long j5, String str, int i3) {
        this.f2575a = s3;
        this.f2576b = s4;
        this.f2577c = j2;
        this.f2578d = j3;
        this.f2579e = j4;
        this.f2580f = j5;
        this.f2581g = str;
        this.f2582h = i3;
    }

    public static String a(int i3, ByteBuffer byteBuffer, int i4) {
        byte[] bArr;
        int i5;
        if (byteBuffer.hasArray()) {
            bArr = byteBuffer.array();
            i5 = byteBuffer.arrayOffset() + i3;
        } else {
            bArr = new byte[i4];
            int position = byteBuffer.position();
            try {
                byteBuffer.position(i3);
                byteBuffer.get(bArr);
                byteBuffer.position(position);
                i5 = 0;
            } catch (Throwable th) {
                byteBuffer.position(position);
                throw th;
            }
        }
        return new String(bArr, i5, i4, StandardCharsets.UTF_8);
    }

    public static a b(ByteBuffer byteBuffer) {
        h.d(byteBuffer);
        if (byteBuffer.remaining() >= 46) {
            int position = byteBuffer.position();
            int i3 = byteBuffer.getInt();
            if (i3 == 33639248) {
                byteBuffer.position(position + 8);
                short s3 = byteBuffer.getShort();
                short s4 = byteBuffer.getShort();
                byteBuffer.getShort();
                byteBuffer.getShort();
                long j2 = byteBuffer.getInt() & KeyboardMap.kValueMask;
                long j3 = byteBuffer.getInt() & KeyboardMap.kValueMask;
                long j4 = byteBuffer.getInt() & KeyboardMap.kValueMask;
                int i4 = byteBuffer.getShort() & 65535;
                int i5 = byteBuffer.getShort() & 65535;
                int i6 = byteBuffer.getShort() & 65535;
                byteBuffer.position(position + 42);
                long j5 = byteBuffer.getInt() & KeyboardMap.kValueMask;
                byteBuffer.position(position);
                int i7 = i4 + 46 + i5 + i6;
                if (i7 <= byteBuffer.remaining()) {
                    String a2 = a(position + 46, byteBuffer, i4);
                    byteBuffer.position(position);
                    int limit = byteBuffer.limit();
                    int i8 = position + i7;
                    try {
                        byteBuffer.limit(i8);
                        byteBuffer.slice();
                        byteBuffer.limit(limit);
                        byteBuffer.position(i8);
                        return new a(s3, s4, j2, j3, j4, j5, a2, i4);
                    } catch (Throwable th) {
                        byteBuffer.limit(limit);
                        throw th;
                    }
                }
                StringBuilder w3 = AbstractC0008a.w(i7, "Input too short. Need: ", " bytes, available: ");
                w3.append(byteBuffer.remaining());
                w3.append(" bytes");
                throw new Exception(w3.toString(), new BufferUnderflowException());
            }
            throw new Exception("Not a Central Directory record. Signature: 0x" + Long.toHexString(i3 & KeyboardMap.kValueMask));
        }
        throw new Exception("Input too short. Need at least: 46 bytes, available: " + byteBuffer.remaining() + " bytes", new BufferUnderflowException());
    }
}
