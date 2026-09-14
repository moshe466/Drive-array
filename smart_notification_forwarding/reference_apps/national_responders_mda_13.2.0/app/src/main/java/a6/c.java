package a6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.w;
import com.groboot.mdaemergency.models.PDFFile;
import com.groboot.mdaemergency.ui.fragments.b;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class c extends androidx.fragment.app.e implements b.c {

    /* renamed from: u0, reason: collision with root package name */
    com.groboot.mdaemergency.ui.fragments.b f310u0;

    /* renamed from: v0, reason: collision with root package name */
    PDFFile f311v0;

    /* renamed from: w0, reason: collision with root package name */
    TextView f312w0;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.f310u0.i();
            c.this.W1();
        }
    }

    public static void k2(w wVar, PDFFile pDFFile) {
        c cVar = new c();
        cVar.j2(pDFFile);
        cVar.i2(wVar, "PDFDialog");
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog, viewGroup, false);
        f2(false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_main);
        View inflate2 = layoutInflater.inflate(R.layout.fragment_pdf, viewGroup, false);
        linearLayout.addView(inflate2);
        this.f310u0 = new com.groboot.mdaemergency.ui.fragments.b(t(), inflate2, this);
        this.f312w0 = (TextView) inflate.findViewById(R.id.title);
        inflate.findViewById(R.id.close).setOnClickListener(new a());
        Z1().getWindow().requestFeature(1);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        this.f310u0.j(this.f311v0);
        this.f310u0.l();
    }

    public void j2(PDFFile pDFFile) {
        this.f311v0 = pDFFile;
    }

    @Override // com.groboot.mdaemergency.ui.fragments.b.c
    public void k(String str) {
        this.f312w0.setText(str);
    }
}
