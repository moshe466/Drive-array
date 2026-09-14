package i0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final int f4961a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4962b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4963c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4964d;

    public h(int i, int i3, long j2, long j3) {
        this.f4961a = i;
        this.f4962b = i3;
        this.f4963c = j2;
        this.f4964d = j3;
    }

    public static h a(File file) {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            h hVar = new h(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return hVar;
        } finally {
        }
    }

    public final void b(File file) {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f4961a);
            dataOutputStream.writeInt(this.f4962b);
            dataOutputStream.writeLong(this.f4963c);
            dataOutputStream.writeLong(this.f4964d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof h)) {
            h hVar = (h) obj;
            if (this.f4962b == hVar.f4962b && this.f4963c == hVar.f4963c && this.f4961a == hVar.f4961a && this.f4964d == hVar.f4964d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f4962b), Long.valueOf(this.f4963c), Integer.valueOf(this.f4961a), Long.valueOf(this.f4964d));
    }
}
