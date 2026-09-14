package com.groboot.mdaemergency.ui.fragments;

import com.groboot.mdaemergency.models.PDFFile;
import com.groboot.mdaemergency.ui.fragments.b;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class PDFFragment extends a6.a implements b.c {
    b A0;
    PDFFile B0;

    @Override // a6.a, androidx.fragment.app.Fragment
    public void R0() {
        super.R0();
        this.A0.i();
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        this.A0.j(this.B0);
        this.A0.l();
    }

    @Override // com.groboot.mdaemergency.ui.fragments.b.c
    public void k(String str) {
        a(str);
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.fragment_pdf);
        this.A0 = new b(t(), this.f306w0, this);
    }

    @Override // a6.a
    public void o2() {
    }

    public void p2(PDFFile pDFFile) {
        this.B0 = pDFFile;
    }
}
