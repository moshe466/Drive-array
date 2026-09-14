package ua;

import ua.d;

/* loaded from: classes.dex */
public abstract class c {

    /* loaded from: classes.dex */
    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public static final a f14502a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final int f14503b;

        static {
            d.a aVar = d.f14505c;
            f14503b = (~(aVar.k() | aVar.e())) & aVar.b();
        }

        private a() {
        }

        @Override // ua.c
        public int a() {
            return f14503b;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f14504a = new b();

        private b() {
        }

        @Override // ua.c
        public int a() {
            return 0;
        }
    }

    public abstract int a();

    public String toString() {
        return getClass().getSimpleName();
    }
}
