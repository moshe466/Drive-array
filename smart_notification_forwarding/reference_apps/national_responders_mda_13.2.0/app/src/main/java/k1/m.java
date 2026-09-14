package k1;

import android.util.Base64;
import com.google.auto.value.AutoValue;
import k1.c;

@AutoValue
/* loaded from: classes.dex */
public abstract class m {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract m a();

        public abstract a b(String str);

        public abstract a c(byte[] bArr);

        public abstract a d(i1.d dVar);
    }

    public static a a() {
        return new c.b().d(i1.d.DEFAULT);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract i1.d d();

    public m e(i1.d dVar) {
        return a().b(b()).d(dVar).c(c()).a();
    }

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        objArr[2] = c() == null ? "" : Base64.encodeToString(c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
