package g0;

import android.app.Fragment;
import android.os.Build;

@Deprecated
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final e f9747a;

    /* renamed from: g0.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0174a extends d {
        C0174a() {
        }

        @Override // g0.a.d, g0.a.e
        public void a(Fragment fragment, boolean z10) {
            fragment.setUserVisibleHint(z10);
        }
    }

    /* loaded from: classes.dex */
    static class b extends C0174a {
        b() {
        }
    }

    /* loaded from: classes.dex */
    static class c extends b {
        c() {
        }

        @Override // g0.a.C0174a, g0.a.d, g0.a.e
        public void a(Fragment fragment, boolean z10) {
            fragment.setUserVisibleHint(z10);
        }
    }

    /* loaded from: classes.dex */
    static class d implements e {
        d() {
        }

        @Override // g0.a.e
        public void a(Fragment fragment, boolean z10) {
        }
    }

    /* loaded from: classes.dex */
    interface e {
        void a(Fragment fragment, boolean z10);
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f9747a = i10 >= 24 ? new c() : i10 >= 23 ? new b() : i10 >= 15 ? new C0174a() : new d();
    }

    @Deprecated
    public static void a(Fragment fragment, boolean z10) {
        f9747a.a(fragment, z10);
    }
}
