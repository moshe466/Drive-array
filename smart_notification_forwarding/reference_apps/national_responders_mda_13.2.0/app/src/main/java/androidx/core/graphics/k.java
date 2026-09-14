package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.res.e;
import androidx.core.provider.g;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    private ConcurrentHashMap<Long, e.c> f2419a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements c<g.b> {
        a(k kVar) {
        }

        @Override // androidx.core.graphics.k.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(g.b bVar) {
            return bVar.e();
        }

        @Override // androidx.core.graphics.k.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(g.b bVar) {
            return bVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements c<e.d> {
        b(k kVar) {
        }

        @Override // androidx.core.graphics.k.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(e.d dVar) {
            return dVar.e();
        }

        @Override // androidx.core.graphics.k.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(e.d dVar) {
            return dVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c<T> {
        int a(T t10);

        boolean b(T t10);
    }

    private void a(Typeface typeface, e.c cVar) {
        long k10 = k(typeface);
        if (k10 != 0) {
            this.f2419a.put(Long.valueOf(k10), cVar);
        }
    }

    private e.d f(e.c cVar, int i10) {
        return (e.d) g(cVar.a(), i10, new b(this));
    }

    private static <T> T g(T[] tArr, int i10, c<T> cVar) {
        return (T) h(tArr, (i10 & 1) == 0 ? 400 : 700, (i10 & 2) != 0, cVar);
    }

    private static <T> T h(T[] tArr, int i10, boolean z10, c<T> cVar) {
        T t10 = null;
        int i11 = Integer.MAX_VALUE;
        for (T t11 : tArr) {
            int abs = (Math.abs(cVar.a(t11) - i10) * 2) + (cVar.b(t11) == z10 ? 0 : 1);
            if (t10 == null || i11 > abs) {
                t10 = t11;
                i11 = abs;
            }
        }
        return t10;
    }

    private static long k(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return 0L;
        }
    }

    public Typeface b(Context context, e.c cVar, Resources resources, int i10) {
        e.d f10 = f(cVar, i10);
        if (f10 == null) {
            return null;
        }
        Typeface d10 = e.d(context, resources, f10.b(), f10.a(), 0, i10);
        a(d10, cVar);
        return d10;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, g.b[] bVarArr, int i10) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(i(bVarArr, i10).d());
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface d10 = d(context, inputStream);
            l.a(inputStream);
            return d10;
        } catch (IOException unused2) {
            l.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            l.a(inputStream2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface d(Context context, InputStream inputStream) {
        File e10 = l.e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (l.d(e10, inputStream)) {
                return Typeface.createFromFile(e10.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e10.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i10, String str, int i11) {
        File e10 = l.e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (l.c(e10, resources, i10)) {
                return Typeface.createFromFile(e10.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e10.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g.b i(g.b[] bVarArr, int i10) {
        return (g.b) g(bVarArr, i10, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e.c j(Typeface typeface) {
        long k10 = k(typeface);
        if (k10 == 0) {
            return null;
        }
        return this.f2419a.get(Long.valueOf(k10));
    }
}
