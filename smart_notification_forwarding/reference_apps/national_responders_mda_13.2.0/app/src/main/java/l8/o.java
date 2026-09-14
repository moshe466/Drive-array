package l8;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class o<T> implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    public static final a f11812f = new a(null);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Serializable {

        /* renamed from: f, reason: collision with root package name */
        public final Throwable f11813f;

        public b(Throwable th) {
            y8.k.e(th, "exception");
            this.f11813f = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && y8.k.a(this.f11813f, ((b) obj).f11813f);
        }

        public int hashCode() {
            return this.f11813f.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f11813f + ')';
        }
    }

    public static <T> Object a(Object obj) {
        return obj;
    }

    public static final Throwable b(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f11813f;
        }
        return null;
    }

    public static final boolean c(Object obj) {
        return obj instanceof b;
    }

    public static final boolean d(Object obj) {
        return !(obj instanceof b);
    }
}
