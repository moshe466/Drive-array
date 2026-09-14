package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.res.e;
import androidx.core.content.res.h;
import androidx.core.provider.g;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final k f2400a;

    /* renamed from: b, reason: collision with root package name */
    private static final l.e<String, Typeface> f2401b;

    /* loaded from: classes.dex */
    public static class a extends g.c {

        /* renamed from: a, reason: collision with root package name */
        private h.f f2402a;

        public a(h.f fVar) {
            this.f2402a = fVar;
        }

        @Override // androidx.core.provider.g.c
        public void a(int i10) {
            h.f fVar = this.f2402a;
            if (fVar != null) {
                fVar.f(i10);
            }
        }

        @Override // androidx.core.provider.g.c
        public void b(Typeface typeface) {
            h.f fVar = this.f2402a;
            if (fVar != null) {
                fVar.g(typeface);
            }
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f2400a = i10 >= 29 ? new j() : i10 >= 28 ? new i() : i10 >= 26 ? new h() : (i10 < 24 || !g.n()) ? i10 >= 21 ? new f() : new k() : new g();
        f2401b = new l.e<>(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i10) {
        Typeface g10;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (g10 = g(context, typeface, i10)) == null) ? Typeface.create(typeface, i10) : g10;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i10) {
        return f2400a.c(context, cancellationSignal, bVarArr, i10);
    }

    public static Typeface c(Context context, e.b bVar, Resources resources, int i10, String str, int i11, int i12, h.f fVar, Handler handler, boolean z10) {
        Typeface b10;
        if (bVar instanceof e.C0031e) {
            e.C0031e c0031e = (e.C0031e) bVar;
            Typeface h10 = h(c0031e.c());
            if (h10 != null) {
                if (fVar != null) {
                    fVar.d(h10, handler);
                }
                return h10;
            }
            b10 = androidx.core.provider.g.c(context, c0031e.b(), i12, !z10 ? fVar != null : c0031e.a() != 0, z10 ? c0031e.d() : -1, h.f.e(handler), new a(fVar));
        } else {
            b10 = f2400a.b(context, (e.c) bVar, resources, i12);
            if (fVar != null) {
                if (b10 != null) {
                    fVar.d(b10, handler);
                } else {
                    fVar.c(-3, handler);
                }
            }
        }
        if (b10 != null) {
            f2401b.d(e(resources, i10, str, i11, i12), b10);
        }
        return b10;
    }

    public static Typeface d(Context context, Resources resources, int i10, String str, int i11, int i12) {
        Typeface e10 = f2400a.e(context, resources, i10, str, i12);
        if (e10 != null) {
            f2401b.d(e(resources, i10, str, i11, i12), e10);
        }
        return e10;
    }

    private static String e(Resources resources, int i10, String str, int i11, int i12) {
        return resources.getResourcePackageName(i10) + '-' + str + '-' + i11 + '-' + i10 + '-' + i12;
    }

    public static Typeface f(Resources resources, int i10, String str, int i11, int i12) {
        return f2401b.c(e(resources, i10, str, i11, i12));
    }

    private static Typeface g(Context context, Typeface typeface, int i10) {
        k kVar = f2400a;
        e.c j10 = kVar.j(typeface);
        if (j10 == null) {
            return null;
        }
        return kVar.b(context, j10, context.getResources(), i10);
    }

    private static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
