package androidx.lifecycle;

import F0.C0047j2;
import F0.Q2;
import android.os.Handler;

/* loaded from: classes.dex */
public final class G implements InterfaceC0309t {

    /* renamed from: l, reason: collision with root package name */
    public static final G f3549l = new G();

    /* renamed from: a, reason: collision with root package name */
    public int f3550a;

    /* renamed from: b, reason: collision with root package name */
    public int f3551b;

    /* renamed from: e, reason: collision with root package name */
    public Handler f3554e;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3552c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3553d = true;

    /* renamed from: f, reason: collision with root package name */
    public final C0311v f3555f = new C0311v(this);

    /* renamed from: j, reason: collision with root package name */
    public final Q2 f3556j = new Q2(this, 2);

    /* renamed from: k, reason: collision with root package name */
    public final C0047j2 f3557k = new C0047j2(this, 11);

    public final void a() {
        int i = this.f3551b + 1;
        this.f3551b = i;
        if (i == 1) {
            if (this.f3552c) {
                this.f3555f.e(EnumC0303m.ON_RESUME);
                this.f3552c = false;
            } else {
                Handler handler = this.f3554e;
                kotlin.jvm.internal.j.b(handler);
                handler.removeCallbacks(this.f3556j);
            }
        }
    }

    @Override // androidx.lifecycle.InterfaceC0309t
    public final AbstractC0305o getLifecycle() {
        return this.f3555f;
    }
}
