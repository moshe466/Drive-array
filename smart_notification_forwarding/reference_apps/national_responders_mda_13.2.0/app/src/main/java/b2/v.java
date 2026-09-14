package b2;

import a2.a;
import android.os.Bundle;

/* loaded from: classes.dex */
public class v implements a.d {

    /* renamed from: c, reason: collision with root package name */
    public static final v f4078c = c().a();

    /* renamed from: b, reason: collision with root package name */
    private final String f4079b;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f4080a;

        /* synthetic */ a(y yVar) {
        }

        public v a() {
            return new v(this.f4080a, null);
        }
    }

    /* synthetic */ v(String str, z zVar) {
        this.f4079b = str;
    }

    public static a c() {
        return new a(null);
    }

    public final Bundle d() {
        Bundle bundle = new Bundle();
        String str = this.f4079b;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            return o.a(this.f4079b, ((v) obj).f4079b);
        }
        return false;
    }

    public final int hashCode() {
        return o.b(this.f4079b);
    }
}
