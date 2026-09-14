package o9;

import n9.u0;
import y8.k;

/* loaded from: classes.dex */
public interface c {

    /* loaded from: classes.dex */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f12630a = new a();

        private a() {
        }

        @Override // o9.c
        public boolean c(n9.e eVar, u0 u0Var) {
            k.e(eVar, "classDescriptor");
            k.e(u0Var, "functionDescriptor");
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f12631a = new b();

        private b() {
        }

        @Override // o9.c
        public boolean c(n9.e eVar, u0 u0Var) {
            k.e(eVar, "classDescriptor");
            k.e(u0Var, "functionDescriptor");
            return !u0Var.u().r(d.a());
        }
    }

    boolean c(n9.e eVar, u0 u0Var);
}
