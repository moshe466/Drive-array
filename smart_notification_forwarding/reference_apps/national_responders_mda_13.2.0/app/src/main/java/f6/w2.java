package f6;

import il.org.mda.health.R;

/* loaded from: classes.dex */
public class w2 extends a6.a {
    x2 A0;
    String B0;
    String C0;
    int D0;

    @Override // a6.a, androidx.fragment.app.Fragment
    public void R0() {
        super.R0();
        this.A0.a();
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        this.A0.c(this.B0, this.C0, this.D0);
        this.A0.d();
        a(this.C0);
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.fragment_video);
        this.A0 = new x2(t(), this.f306w0);
    }

    @Override // a6.a
    public void o2() {
    }

    public void p2(String str, String str2, int i10) {
        this.B0 = str;
        this.C0 = str2;
        this.D0 = i10;
    }
}
