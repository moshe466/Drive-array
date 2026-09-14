package q;

import F0.C0021d0;
import F0.C0110z2;
import android.os.Looper;
import androidx.lifecycle.V;
import java.util.concurrent.Executor;

/* renamed from: q.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0601A extends V {

    /* renamed from: b, reason: collision with root package name */
    public Executor f5990b;

    /* renamed from: c, reason: collision with root package name */
    public t f5991c;

    /* renamed from: d, reason: collision with root package name */
    public v f5992d;

    /* renamed from: e, reason: collision with root package name */
    public K1.m f5993e;

    /* renamed from: f, reason: collision with root package name */
    public C0110z2 f5994f;

    /* renamed from: g, reason: collision with root package name */
    public C0021d0 f5995g;

    /* renamed from: h, reason: collision with root package name */
    public z f5996h;
    public String i;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5998k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5999l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6000m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f6001n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f6002o;
    public androidx.lifecycle.B p;

    /* renamed from: q, reason: collision with root package name */
    public androidx.lifecycle.B f6003q;

    /* renamed from: r, reason: collision with root package name */
    public androidx.lifecycle.B f6004r;

    /* renamed from: s, reason: collision with root package name */
    public androidx.lifecycle.B f6005s;

    /* renamed from: t, reason: collision with root package name */
    public androidx.lifecycle.B f6006t;

    /* renamed from: v, reason: collision with root package name */
    public androidx.lifecycle.B f6008v;

    /* renamed from: x, reason: collision with root package name */
    public androidx.lifecycle.B f6010x;
    public androidx.lifecycle.B y;

    /* renamed from: j, reason: collision with root package name */
    public int f5997j = 0;

    /* renamed from: u, reason: collision with root package name */
    public boolean f6007u = true;

    /* renamed from: w, reason: collision with root package name */
    public int f6009w = 0;

    public static void h(androidx.lifecycle.B b4, Object obj) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            b4.h(obj);
        } else {
            b4.i(obj);
        }
    }

    public final int c() {
        v vVar = this.f5992d;
        if (vVar != null) {
            K1.m mVar = this.f5993e;
            int i = vVar.f6047f;
            if (i != 0) {
                return i;
            }
            if (mVar != null) {
                return 15;
            }
            return 255;
        }
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    public final void d(C0608e c0608e) {
        if (this.f6003q == null) {
            this.f6003q = new androidx.lifecycle.A();
        }
        h(this.f6003q, c0608e);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    public final void e(CharSequence charSequence) {
        if (this.y == null) {
            this.y = new androidx.lifecycle.A();
        }
        h(this.y, charSequence);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    public final void f(int i) {
        if (this.f6010x == null) {
            this.f6010x = new androidx.lifecycle.A();
        }
        h(this.f6010x, Integer.valueOf(i));
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.lifecycle.B, androidx.lifecycle.A] */
    public final void g(boolean z3) {
        if (this.f6006t == null) {
            this.f6006t = new androidx.lifecycle.A();
        }
        h(this.f6006t, Boolean.valueOf(z3));
    }
}
