package k1;

import com.google.auto.value.AutoValue;
import k1.b;

/* JADX INFO: Access modifiers changed from: package-private */
@AutoValue
/* loaded from: classes.dex */
public abstract class l {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract l a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a b(i1.b bVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a c(i1.c<?> cVar);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract a d(i1.e<?, byte[]> eVar);

        public abstract a e(m mVar);

        public abstract a f(String str);
    }

    public static a a() {
        return new b.C0226b();
    }

    public abstract i1.b b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract i1.c<?> c();

    public byte[] d() {
        return e().apply(c().b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract i1.e<?, byte[]> e();

    public abstract m f();

    public abstract String g();
}
