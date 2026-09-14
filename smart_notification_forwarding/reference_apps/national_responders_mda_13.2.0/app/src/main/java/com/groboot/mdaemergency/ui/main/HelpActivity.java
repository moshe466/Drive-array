package com.groboot.mdaemergency.ui.main;

import a6.h;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.FilingComplaint;
import d6.d;
import il.org.mda.health.R;
import java.util.Date;
import w6.l0;
import w6.n;

/* loaded from: classes.dex */
public class HelpActivity extends androidx.appcompat.app.c {
    EditText A;
    EditText B;
    EditText C;
    EditText D;
    EditText E;
    EditText F;
    EditText G;
    EditText H;
    View.OnClickListener I = new b();
    View.OnClickListener J = new c();
    View.OnClickListener K = new d();
    TextView.OnEditorActionListener L = new e();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HelpActivity.this.onBackPressed();
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HelpActivity.this.z0();
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {

        /* loaded from: classes.dex */
        class a implements b.InterfaceC0098b {

            /* renamed from: com.groboot.mdaemergency.ui.main.HelpActivity$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class DialogInterfaceOnClickListenerC0128a implements DialogInterface.OnClickListener {
                DialogInterfaceOnClickListenerC0128a() {
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    HelpActivity.this.onBackPressed();
                }
            }

            a() {
            }

            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public void a(b.a aVar) {
                HelpActivity helpActivity = HelpActivity.this;
                h.i(helpActivity, helpActivity.getString(R.string.yourRequestSuccess), HelpActivity.this.getString(R.string.yourRequestSuccessDescription), new DialogInterfaceOnClickListenerC0128a());
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String obj = HelpActivity.this.A.getText().toString();
            String obj2 = HelpActivity.this.B.getText().toString();
            String obj3 = HelpActivity.this.C.getText().toString();
            String obj4 = HelpActivity.this.D.getText().toString();
            String obj5 = HelpActivity.this.E.getText().toString();
            String obj6 = HelpActivity.this.F.getText().toString();
            String obj7 = HelpActivity.this.G.getText().toString();
            String obj8 = HelpActivity.this.H.getText().toString();
            if (l0.l0(obj) || l0.l0(obj2) || l0.l0(obj3) || l0.l0(obj4) || l0.l0(obj5) || l0.l0(obj8)) {
                HelpActivity helpActivity = HelpActivity.this;
                h.o(helpActivity, helpActivity.getString(R.string.fillAllFeilds));
            } else if (l0.o0(obj6)) {
                com.groboot.mdaemergency.async.d.v().k(new FilingComplaint(obj, obj2, obj3, obj4, l0.A(obj5), obj6, obj7, obj8), new a());
            } else {
                HelpActivity helpActivity2 = HelpActivity.this;
                h.o(helpActivity2, helpActivity2.getString(R.string.invalidMail));
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnClickListener {

        /* loaded from: classes.dex */
        class a implements d.b {
            a() {
            }

            @Override // d6.d.b
            public void a() {
            }

            @Override // d6.d.b
            public void b(Date date) {
                HelpActivity.this.E.setText(l0.c0(date, l0.f15195h));
                HelpActivity.this.F.requestFocus();
                ((InputMethodManager) HelpActivity.this.getSystemService("input_method")).showSoftInput(HelpActivity.this.F, 1);
            }
        }

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Date A = !l0.l0(HelpActivity.this.E.getText().toString()) ? l0.A(HelpActivity.this.E.getText().toString()) : null;
            HelpActivity helpActivity = HelpActivity.this;
            d6.d.n2(helpActivity, A, helpActivity.getResources().getString(R.string.birthday), new a());
        }
    }

    /* loaded from: classes.dex */
    class e implements TextView.OnEditorActionListener {
        e() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            if (i10 == 5) {
                HelpActivity.this.K.onClick(null);
                ((InputMethodManager) textView.getContext().getSystemService("input_method")).hideSoftInputFromWindow(textView.getWindowToken(), 0);
            }
            return false;
        }
    }

    private void A0() {
        androidx.appcompat.app.a o02 = o0();
        o02.w(false);
        o02.v(true);
        o02.x(false);
        o02.s(R.layout.action_bar);
        o02.r(getResources().getDrawable(R.drawable.actionbar_background));
        ((TextView) findViewById(R.id.action_bar_title)).setText(getString(R.string.help));
        findViewById(R.id.action_bar_back_button).setVisibility(8);
        findViewById(R.id.btn_menu).setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.btn_close);
        imageView.setVisibility(0);
        imageView.setOnClickListener(new a());
    }

    private void B0() {
        findViewById(R.id.btn_phone).setOnClickListener(this.I);
        findViewById(R.id.btn_send).setOnClickListener(this.J);
        this.A = (EditText) findViewById(R.id.et_firstName);
        this.B = (EditText) findViewById(R.id.et_lastName);
        this.C = (EditText) findViewById(R.id.et_id);
        this.D = (EditText) findViewById(R.id.et_phone);
        this.E = (EditText) findViewById(R.id.et_birthDay);
        this.F = (EditText) findViewById(R.id.et_mail);
        this.G = (EditText) findViewById(R.id.et_conanCode);
        this.H = (EditText) findViewById(R.id.et_description);
        this.E.setInputType(0);
        this.E.setOnClickListener(this.K);
        this.D.setOnEditorActionListener(this.L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        if (androidx.core.content.a.a(this, "android.permission.CALL_PHONE") != 0) {
            androidx.core.app.b.n(this, new String[]{"android.permission.CALL_PHONE"}, 101);
            return;
        }
        startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + getString(R.string.phone_help))));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(n.c(context));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().getDecorView().setLayoutDirection("iw".equals(n.a(this)) ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setSoftInputMode(2);
        l0.C0(this);
        setContentView(R.layout.activity_help);
        B0();
        A0();
        l0.E0(this);
    }

    @Override // androidx.fragment.app.j, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 101 && iArr[0] == 0) {
            z0();
        }
    }
}
