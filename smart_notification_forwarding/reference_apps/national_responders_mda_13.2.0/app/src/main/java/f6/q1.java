package f6;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.groboot.mdaemergency.ui.views.WebViewMDA;
import rb.c;

/* loaded from: classes.dex */
public class q1 extends a6.a implements c.b {
    WebViewMDA.j A0;
    private v6.a B0;

    public q1() {
    }

    @SuppressLint({"ValidFragment"})
    public q1(WebViewMDA.j jVar) {
        this.A0 = jVar;
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        v6.a aVar = new v6.a(A());
        this.B0 = aVar;
        aVar.setResultHandler(this);
        return this.B0;
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void R0() {
        super.R0();
        this.B0.h();
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        this.B0.f();
    }

    @Override // rb.c.b
    public void d(rb.b bVar) {
        if (t() == null) {
            return;
        }
        this.B0.l(this);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rawResult.getText(): ");
        sb2.append(bVar.b());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("rawResult.getBarcodeFormat().toString(): ");
        sb3.append(bVar.a().toString());
        t().onBackPressed();
        WebViewMDA.j jVar = this.A0;
        if (jVar != null) {
            jVar.a(bVar.b());
        }
    }

    @Override // a6.a
    protected void n2() {
    }

    @Override // a6.a
    public void o2() {
    }
}
