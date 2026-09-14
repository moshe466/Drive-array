package Y;

import io.flutter.embedding.android.KeyboardMap;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class c extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final DataOutputStream f2637a;

    /* renamed from: b, reason: collision with root package name */
    public ByteOrder f2638b;

    public c(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.f2637a = new DataOutputStream(outputStream);
        this.f2638b = byteOrder;
    }

    public final void a(int i) {
        this.f2637a.write(i);
    }

    public final void b(int i) {
        ByteOrder byteOrder = this.f2638b;
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        DataOutputStream dataOutputStream = this.f2637a;
        if (byteOrder == byteOrder2) {
            dataOutputStream.write(i & 255);
            dataOutputStream.write((i >>> 8) & 255);
            dataOutputStream.write((i >>> 16) & 255);
            dataOutputStream.write((i >>> 24) & 255);
            return;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            dataOutputStream.write((i >>> 24) & 255);
            dataOutputStream.write((i >>> 16) & 255);
            dataOutputStream.write((i >>> 8) & 255);
            dataOutputStream.write(i & 255);
        }
    }

    public final void c(short s3) {
        ByteOrder byteOrder = this.f2638b;
        ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
        DataOutputStream dataOutputStream = this.f2637a;
        if (byteOrder == byteOrder2) {
            dataOutputStream.write(s3 & 255);
            dataOutputStream.write((s3 >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            dataOutputStream.write((s3 >>> 8) & 255);
            dataOutputStream.write(s3 & 255);
        }
    }

    public final void d(long j2) {
        if (j2 <= KeyboardMap.kValueMask) {
            b((int) j2);
            return;
        }
        throw new IllegalArgumentException("val is larger than the maximum value of a 32-bit unsigned integer");
    }

    public final void e(int i) {
        if (i <= 65535) {
            c((short) i);
            return;
        }
        throw new IllegalArgumentException("val is larger than the maximum value of a 16-bit unsigned integer");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) {
        this.f2637a.write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i3) {
        this.f2637a.write(bArr, i, i3);
    }
}
