package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;

/* loaded from: classes.dex */
public class g {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f2458a;

        /* renamed from: b, reason: collision with root package name */
        private final b[] f2459b;

        @Deprecated
        public a(int i10, b[] bVarArr) {
            this.f2458a = i10;
            this.f2459b = bVarArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a(int i10, b[] bVarArr) {
            return new a(i10, bVarArr);
        }

        public b[] b() {
            return this.f2459b;
        }

        public int c() {
            return this.f2458a;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f2460a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2461b;

        /* renamed from: c, reason: collision with root package name */
        private final int f2462c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f2463d;

        /* renamed from: e, reason: collision with root package name */
        private final int f2464e;

        @Deprecated
        public b(Uri uri, int i10, int i11, boolean z10, int i12) {
            this.f2460a = (Uri) androidx.core.util.h.f(uri);
            this.f2461b = i10;
            this.f2462c = i11;
            this.f2463d = z10;
            this.f2464e = i12;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(Uri uri, int i10, int i11, boolean z10, int i12) {
            return new b(uri, i10, i11, z10, i12);
        }

        public int b() {
            return this.f2464e;
        }

        public int c() {
            return this.f2461b;
        }

        public Uri d() {
            return this.f2460a;
        }

        public int e() {
            return this.f2462c;
        }

        public boolean f() {
            return this.f2463d;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public void a(int i10) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return androidx.core.graphics.e.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, e eVar) {
        return d.e(context, eVar, cancellationSignal);
    }

    public static Typeface c(Context context, e eVar, int i10, boolean z10, int i11, Handler handler, c cVar) {
        androidx.core.provider.a aVar = new androidx.core.provider.a(cVar, handler);
        return z10 ? f.e(context, eVar, aVar, i10, i11) : f.d(context, eVar, i10, null, aVar);
    }
}
