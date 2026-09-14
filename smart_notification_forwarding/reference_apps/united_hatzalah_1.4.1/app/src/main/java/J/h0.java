package J;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: classes.dex */
public class h0 extends g0 {
    public h0(p0 p0Var, WindowInsets windowInsets) {
        super(p0Var, windowInsets);
    }

    @Override // J.m0
    public p0 a() {
        WindowInsets consumeDisplayCutout;
        consumeDisplayCutout = this.f987c.consumeDisplayCutout();
        return p0.c(consumeDisplayCutout, null);
    }

    @Override // J.m0
    public C0121i e() {
        DisplayCutout displayCutout;
        displayCutout = this.f987c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new C0121i(displayCutout);
    }

    @Override // J.f0, J.m0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) obj;
        if (Objects.equals(this.f987c, h0Var.f987c) && Objects.equals(this.f991g, h0Var.f991g) && f0.y(this.f992h, h0Var.f992h)) {
            return true;
        }
        return false;
    }

    @Override // J.m0
    public int hashCode() {
        return this.f987c.hashCode();
    }
}
