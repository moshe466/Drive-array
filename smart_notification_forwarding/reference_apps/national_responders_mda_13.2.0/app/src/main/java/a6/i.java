package a6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.w;
import f6.x2;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class i extends androidx.fragment.app.e {

    /* renamed from: u0, reason: collision with root package name */
    x2 f321u0;

    /* renamed from: v0, reason: collision with root package name */
    String f322v0;

    /* renamed from: w0, reason: collision with root package name */
    String f323w0;

    /* renamed from: x0, reason: collision with root package name */
    int f324x0;

    /* renamed from: y0, reason: collision with root package name */
    TextView f325y0;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.f321u0.a();
            i.this.W1();
        }
    }

    public static void k2(w wVar, String str, String str2, int i10) {
        i iVar = new i();
        iVar.j2(str, str2, i10);
        iVar.i2(wVar, "VideoDialog");
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog, viewGroup, false);
        f2(false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_main);
        View inflate2 = layoutInflater.inflate(R.layout.fragment_video, viewGroup, false);
        linearLayout.addView(inflate2);
        this.f321u0 = new x2(t(), inflate2);
        this.f325y0 = (TextView) inflate.findViewById(R.id.title);
        inflate.findViewById(R.id.close).setOnClickListener(new a());
        Z1().getWindow().requestFeature(1);
        Z1().getWindow().addFlags(128);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void R0() {
        super.R0();
        this.f321u0.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        this.f321u0.c(this.f322v0, this.f323w0, this.f324x0);
        this.f321u0.d();
        this.f325y0.setText(this.f323w0);
    }

    public void j2(String str, String str2, int i10) {
        this.f322v0 = str;
        this.f323w0 = str2;
        this.f324x0 = i10;
    }
}
