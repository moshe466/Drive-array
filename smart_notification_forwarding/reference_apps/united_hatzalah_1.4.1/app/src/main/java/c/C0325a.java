package c;

import J.A;
import android.os.Build;
import android.window.BackEvent;

/* renamed from: c.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0325a {

    /* renamed from: a, reason: collision with root package name */
    public final float f3809a;

    /* renamed from: b, reason: collision with root package name */
    public final float f3810b;

    /* renamed from: c, reason: collision with root package name */
    public final float f3811c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3812d;

    /* renamed from: e, reason: collision with root package name */
    public final long f3813e;

    public C0325a(BackEvent backEvent) {
        long j2;
        float k4 = A.k(backEvent);
        float l3 = A.l(backEvent);
        float h2 = A.h(backEvent);
        int j3 = A.j(backEvent);
        if (Build.VERSION.SDK_INT >= 36) {
            j2 = K.e.b(backEvent);
        } else {
            j2 = 0;
        }
        this.f3809a = k4;
        this.f3810b = l3;
        this.f3811c = h2;
        this.f3812d = j3;
        this.f3813e = j2;
    }

    public final String toString() {
        return "BackEventCompat{touchX=" + this.f3809a + ", touchY=" + this.f3810b + ", progress=" + this.f3811c + ", swipeEdge=" + this.f3812d + ", frameTimeMillis=" + this.f3813e + '}';
    }
}
