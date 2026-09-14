package Y;

import F0.AbstractC0008a;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class b extends InputStream implements DataInput {

    /* renamed from: a, reason: collision with root package name */
    public final DataInputStream f2632a;

    /* renamed from: b, reason: collision with root package name */
    public int f2633b;

    /* renamed from: c, reason: collision with root package name */
    public ByteOrder f2634c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f2635d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2636e;

    public b(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        this.f2636e = bArr.length;
    }

    public final void a(int i) {
        int i3 = 0;
        while (i3 < i) {
            int i4 = i - i3;
            DataInputStream dataInputStream = this.f2632a;
            int skip = (int) dataInputStream.skip(i4);
            if (skip <= 0) {
                if (this.f2635d == null) {
                    this.f2635d = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
                }
                skip = dataInputStream.read(this.f2635d, 0, Math.min(UserMetadata.MAX_INTERNAL_KEY_SIZE, i4));
                if (skip == -1) {
                    throw new EOFException(AbstractC0008a.j(i, "Reached EOF while skipping ", " bytes."));
                }
            }
            i3 += skip;
        }
        this.f2633b += i3;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f2632a.available();
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override // java.io.InputStream
    public final int read() {
        this.f2633b++;
        return this.f2632a.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.f2633b++;
        return this.f2632a.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        this.f2633b++;
        int read = this.f2632a.read();
        if (read >= 0) {
            return (byte) read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.f2633b += 2;
        return this.f2632a.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i3) {
        this.f2633b += i3;
        this.f2632a.readFully(bArr, i, i3);
    }

    @Override // java.io.DataInput
    public final int readInt() {
        this.f2633b += 4;
        DataInputStream dataInputStream = this.f2632a;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        if ((read | read2 | read3 | read4) >= 0) {
            ByteOrder byteOrder = this.f2634c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            }
            throw new IOException("Invalid byte order: " + this.f2634c);
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final String readLine() {
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() {
        long j2;
        long j3;
        this.f2633b += 8;
        DataInputStream dataInputStream = this.f2632a;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        int read5 = dataInputStream.read();
        int read6 = dataInputStream.read();
        int read7 = dataInputStream.read();
        int read8 = dataInputStream.read();
        if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
            ByteOrder byteOrder = this.f2634c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                j2 = (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8);
                j3 = read;
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                j2 = (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8);
                j3 = read8;
            } else {
                throw new IOException("Invalid byte order: " + this.f2634c);
            }
            return j2 + j3;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final short readShort() {
        this.f2633b += 2;
        DataInputStream dataInputStream = this.f2632a;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) >= 0) {
            ByteOrder byteOrder = this.f2634c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (short) ((read2 << 8) + read);
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (short) ((read << 8) + read2);
            }
            throw new IOException("Invalid byte order: " + this.f2634c);
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.f2633b += 2;
        return this.f2632a.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.f2633b++;
        return this.f2632a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        this.f2633b += 2;
        DataInputStream dataInputStream = this.f2632a;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) >= 0) {
            ByteOrder byteOrder = this.f2634c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (read2 << 8) + read;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (read << 8) + read2;
            }
            throw new IOException("Invalid byte order: " + this.f2634c);
        }
        throw new EOFException();
    }

    @Override // java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    public b(InputStream inputStream) {
        this(inputStream, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i3) {
        int read = this.f2632a.read(bArr, i, i3);
        this.f2633b += read;
        return read;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        this.f2633b += bArr.length;
        this.f2632a.readFully(bArr);
    }

    public b(InputStream inputStream, ByteOrder byteOrder) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f2632a = dataInputStream;
        dataInputStream.mark(0);
        this.f2633b = 0;
        this.f2634c = byteOrder;
        this.f2636e = inputStream instanceof b ? ((b) inputStream).f2636e : -1;
    }
}
