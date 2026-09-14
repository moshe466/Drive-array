package com.groboot.mdaemergency.ui.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.j;
import com.groboot.mdaemergency.models.Kv;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class f extends androidx.fragment.app.e implements View.OnClickListener {

    /* renamed from: u0, reason: collision with root package name */
    String f8460u0;

    /* renamed from: v0, reason: collision with root package name */
    String f8461v0;

    /* renamed from: w0, reason: collision with root package name */
    a f8462w0;

    /* renamed from: x0, reason: collision with root package name */
    EditText f8463x0;

    /* renamed from: y0, reason: collision with root package name */
    TextView f8464y0;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b(String str);

        void c();
    }

    public f(String str, String str2, a aVar) {
        this.f8462w0 = aVar;
        this.f8461v0 = str2 == null ? "" : str2;
        str = str == null ? "" : str;
        this.f8460u0 = str;
        if (str.equals(Kv.OTHER_TEXT)) {
            this.f8460u0 = "";
        }
    }

    public static void j2(j jVar, String str, String str2, a aVar) {
        new f(str, str2, aVar).i2(jVar.d0(), "TextDialog");
    }

    @Override // androidx.fragment.app.e, androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Z1().getWindow().requestFeature(1);
        View inflate = layoutInflater.inflate(R.layout.dialog_fragment_text, viewGroup, false);
        inflate.findViewById(R.id.btn_next).setOnClickListener(this);
        inflate.findViewById(R.id.btn_clear).setOnClickListener(this);
        inflate.findViewById(R.id.btn_back).setOnClickListener(this);
        this.f8463x0 = (EditText) inflate.findViewById(R.id.et_text);
        this.f8464y0 = (TextView) inflate.findViewById(R.id.tv_title);
        this.f8463x0.setText(this.f8460u0);
        this.f8464y0.setText(this.f8461v0);
        this.f8463x0.setSelection(this.f8460u0.length());
        TextView textView = this.f8464y0;
        textView.setVisibility(textView.length() <= 0 ? 8 : 0);
        return inflate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_next) {
            if (this.f8463x0.length() > 0) {
                this.f8462w0.b(((Object) this.f8463x0.getText()) + "");
            } else {
                this.f8462w0.c();
            }
            W1();
        }
        if (view.getId() == R.id.btn_clear) {
            this.f8463x0.setText("");
        }
        if (view.getId() == R.id.btn_back) {
            this.f8462w0.a();
            W1();
        }
    }
}
