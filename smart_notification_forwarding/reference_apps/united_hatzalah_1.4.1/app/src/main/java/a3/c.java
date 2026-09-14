package a3;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import java.util.function.Supplier;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f2765a;

    static {
        char c4 = File.separatorChar;
        f2765a = new byte[0];
        System.lineSeparator();
        d.f2767b.getClass();
        d.f2766a.getClass();
        final int i = 0;
        final Supplier supplier = new Supplier() { // from class: a3.a
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i) {
                    case 0:
                        return new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
                    default:
                        return new char[UserMetadata.MAX_INTERNAL_KEY_SIZE];
                }
            }
        };
        final int i3 = 0;
        new ThreadLocal() { // from class: a3.b
            @Override // java.lang.ThreadLocal
            public final Object initialValue() {
                switch (i3) {
                    case 0:
                        ((a) supplier).getClass();
                        return new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
                    default:
                        ((a) supplier).getClass();
                        return new char[UserMetadata.MAX_INTERNAL_KEY_SIZE];
                }
            }
        };
        final int i4 = 1;
        final Supplier supplier2 = new Supplier() { // from class: a3.a
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i4) {
                    case 0:
                        return new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
                    default:
                        return new char[UserMetadata.MAX_INTERNAL_KEY_SIZE];
                }
            }
        };
        final int i5 = 1;
        new ThreadLocal() { // from class: a3.b
            @Override // java.lang.ThreadLocal
            public final Object initialValue() {
                switch (i5) {
                    case 0:
                        ((a) supplier2).getClass();
                        return new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
                    default:
                        ((a) supplier2).getClass();
                        return new char[UserMetadata.MAX_INTERNAL_KEY_SIZE];
                }
            }
        };
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static int b(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
        Objects.requireNonNull(inputStream, "inputStream");
        Objects.requireNonNull(outputStream, "outputStream");
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                break;
            }
            outputStream.write(bArr, 0, read);
            j2 += read;
        }
        if (j2 > 2147483647L) {
            return -1;
        }
        return (int) j2;
    }
}
