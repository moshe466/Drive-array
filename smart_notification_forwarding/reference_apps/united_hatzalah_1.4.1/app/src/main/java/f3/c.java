package f3;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c extends OutputStream {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f4619f = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4620a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public int f4621b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f4622c;

    /* renamed from: d, reason: collision with root package name */
    public int f4623d;

    /* renamed from: e, reason: collision with root package name */
    public int f4624e;

    public c() {
        a(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void a(int i) {
        int i3 = this.f4623d;
        ArrayList arrayList = this.f4620a;
        if (i3 < arrayList.size() - 1) {
            this.f4624e += this.f4622c.length;
            int i4 = this.f4623d + 1;
            this.f4623d = i4;
            this.f4622c = (byte[]) arrayList.get(i4);
            return;
        }
        byte[] bArr = this.f4622c;
        if (bArr == null) {
            this.f4624e = 0;
        } else {
            i = Math.max(bArr.length << 1, i - this.f4624e);
            this.f4624e += this.f4622c.length;
        }
        this.f4623d++;
        byte[] bArr2 = a3.c.f2765a;
        byte[] bArr3 = new byte[i];
        this.f4622c = bArr3;
        arrayList.add(bArr3);
    }

    public final byte[] b() {
        int i = this.f4621b;
        if (i == 0) {
            return a3.c.f2765a;
        }
        byte[] bArr = a3.c.f2765a;
        byte[] bArr2 = new byte[i];
        ArrayList arrayList = this.f4620a;
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            byte[] bArr3 = (byte[]) obj;
            int min = Math.min(bArr3.length, i);
            System.arraycopy(bArr3, 0, bArr2, i3, min);
            i3 += min;
            i -= min;
            if (i == 0) {
                break;
            }
        }
        return bArr2;
    }

    public final String toString() {
        return new String(b(), Charset.defaultCharset());
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i3) {
        int i4;
        if (i < 0 || i > bArr.length || i3 < 0 || (i4 = i + i3) > bArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException(String.format("offset=%,d, length=%,d", Integer.valueOf(i), Integer.valueOf(i3)));
        }
        if (i3 == 0) {
            return;
        }
        int i5 = this.f4621b;
        int i6 = i5 + i3;
        int i7 = i5 - this.f4624e;
        while (i3 > 0) {
            int min = Math.min(i3, this.f4622c.length - i7);
            System.arraycopy(bArr, i4 - i3, this.f4622c, i7, min);
            i3 -= min;
            if (i3 > 0) {
                a(i6);
                i7 = 0;
            }
        }
        this.f4621b = i6;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        int i3 = this.f4621b;
        int i4 = i3 - this.f4624e;
        if (i4 == this.f4622c.length) {
            a(i3 + 1);
            i4 = 0;
        }
        this.f4622c[i4] = (byte) i;
        this.f4621b++;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
