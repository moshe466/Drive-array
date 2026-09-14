package e3;

import com.google.firebase.messaging.Constants;
import java.io.InputStream;
import java.util.Objects;
import org.apache.tika.fork.ForkServer;
import org.apache.tika.mime.MimeTypesReaderMetKeys;

/* loaded from: classes.dex */
public final class i extends InputStream {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f4469e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f4470a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4471b;

    /* renamed from: c, reason: collision with root package name */
    public int f4472c;

    /* renamed from: d, reason: collision with root package name */
    public int f4473d;

    public i(byte[] bArr) {
        int length = bArr.length;
        this.f4470a = bArr;
        this.f4471b = length;
        this.f4472c = 0;
        this.f4473d = 0;
    }

    public static void a(int i, String str) {
        if (i >= 0) {
        } else {
            throw new IllegalArgumentException(str.concat(" cannot be negative"));
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        int i = this.f4472c;
        int i3 = this.f4471b;
        if (i < i3) {
            return i3 - i;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        this.f4473d = this.f4472c;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        int i = this.f4472c;
        if (i >= this.f4471b) {
            return -1;
        }
        this.f4472c = i + 1;
        return this.f4470a[i] & ForkServer.ERROR;
    }

    @Override // java.io.InputStream
    public final void reset() {
        this.f4472c = this.f4473d;
    }

    @Override // java.io.InputStream
    public final long skip(long j2) {
        if (j2 >= 0) {
            int i = this.f4472c;
            long j3 = this.f4471b - i;
            if (j2 < j3) {
                j3 = j2;
            }
            this.f4472c = Math.addExact(i, Math.toIntExact(j2));
            return j3;
        }
        throw new IllegalArgumentException("Skipping backward is not supported");
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        Objects.requireNonNull(bArr, "dest");
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i3) {
        Objects.requireNonNull(bArr, "dest");
        if (i >= 0 && i3 >= 0 && i + i3 <= bArr.length) {
            int i4 = this.f4472c;
            int i5 = this.f4471b;
            if (i4 >= i5) {
                return -1;
            }
            int i6 = i5 - i4;
            if (i3 >= i6) {
                i3 = i6;
            }
            if (i3 <= 0) {
                return 0;
            }
            System.arraycopy(this.f4470a, i4, bArr, i, i3);
            this.f4472c += i3;
            return i3;
        }
        throw new IndexOutOfBoundsException();
    }

    public i(byte[] bArr, int i) {
        a(0, MimeTypesReaderMetKeys.MATCH_OFFSET_ATTR);
        a(i, "length");
        Objects.requireNonNull(bArr, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        this.f4470a = bArr;
        a(0, "defaultValue");
        this.f4471b = Math.min(Math.min(0, bArr.length > 0 ? bArr.length : 0) + i, bArr.length);
        a(0, "defaultValue");
        this.f4472c = Math.min(0, bArr.length > 0 ? bArr.length : 0);
        a(0, "defaultValue");
        this.f4473d = Math.min(0, bArr.length > 0 ? bArr.length : 0);
    }
}
