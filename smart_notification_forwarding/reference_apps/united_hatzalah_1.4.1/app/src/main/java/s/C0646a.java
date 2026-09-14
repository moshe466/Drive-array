package s;

import android.os.Bundle;

/* renamed from: s.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0646a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6217a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6218b;

    public C0646a(boolean z3, int i) {
        this.f6217a = z3;
        this.f6218b = i;
    }

    @Override // s.b
    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("androidx.browser.trusted.displaymode.KEY_ID", 1);
        bundle.putBoolean("androidx.browser.trusted.displaymode.KEY_STICKY", this.f6217a);
        bundle.putInt("androidx.browser.trusted.displaymode.KEY_CUTOUT_MODE", this.f6218b);
        return bundle;
    }
}
