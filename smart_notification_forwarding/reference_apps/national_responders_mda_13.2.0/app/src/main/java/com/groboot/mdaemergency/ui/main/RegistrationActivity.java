package com.groboot.mdaemergency.ui.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.b;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import com.groboot.mdaemergency.a;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.AppUser;
import com.groboot.mdaemergency.models.poc.Device;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.services.GoogleTokenService;
import com.groboot.mdaemergency.services.OpenSocketService;
import com.groboot.mdaemergency.ui.LockPatternActivity;
import com.groboot.mdaemergency.ui.activities.PermissionActivity;
import com.groboot.mdaemergency.ui.activities.ZebraPrinterActivity;
import com.groboot.mdaemergency.ui.main.RegistrationActivity;
import d6.d;
import il.org.mda.health.R;
import java.util.Date;
import p5.d;
import t6.e;
import w6.d0;
import w6.g0;
import w6.l0;
import w6.t;
import w6.z;

/* loaded from: classes.dex */
public class RegistrationActivity extends androidx.appcompat.app.c implements a6.b {
    TextView A;
    LinearLayout B;
    RelativeLayout C;
    TextView D;
    TextView E;
    EditText F;
    EditText G;
    EditText H;
    EditText I;
    EditText J;
    EditText K;
    RelativeLayout L;
    EditText M;
    RelativeLayout N;
    RelativeLayout O;
    com.groboot.mdaemergency.async.d P;
    AppUser R;
    boolean S;
    View T;
    View U;
    TextView V;
    TextView W;
    boolean X;
    TextView Y;

    /* renamed from: a0, reason: collision with root package name */
    View f8268a0;

    /* renamed from: b0, reason: collision with root package name */
    com.groboot.mdaemergency.enums.a f8269b0;

    /* renamed from: e0, reason: collision with root package name */
    Boolean f8272e0;

    /* renamed from: j0, reason: collision with root package name */
    Date f8277j0;

    /* renamed from: k0, reason: collision with root package name */
    boolean f8278k0;
    String Q = "";
    boolean Z = false;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f8270c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    private View.OnClickListener f8271d0 = new View.OnClickListener() { // from class: u6.k
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RegistrationActivity.this.h1(view);
        }
    };

    /* renamed from: f0, reason: collision with root package name */
    private View.OnClickListener f8273f0 = new a();

    /* renamed from: g0, reason: collision with root package name */
    private View.OnClickListener f8274g0 = new b();

    /* renamed from: h0, reason: collision with root package name */
    private View.OnClickListener f8275h0 = new c();

    /* renamed from: i0, reason: collision with root package name */
    Boolean f8276i0 = null;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: com.groboot.mdaemergency.ui.main.RegistrationActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0132a implements d.b {
            C0132a() {
            }

            @Override // d6.d.b
            public void a() {
            }

            @Override // d6.d.b
            public void b(Date date) {
                RegistrationActivity registrationActivity = RegistrationActivity.this;
                registrationActivity.K.setText(l0.c0(date, registrationActivity.f8269b0 == com.groboot.mdaemergency.enums.a.PHILIPINE ? l0.f15197j : l0.f15195h));
                RegistrationActivity.this.K.setTag(l0.c0(date, l0.f15200m));
            }
        }

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Date A = RegistrationActivity.this.K.getTag() != null ? l0.A(RegistrationActivity.this.K.getTag().toString()) : null;
            RegistrationActivity registrationActivity = RegistrationActivity.this;
            d6.d.n2(registrationActivity, A, registrationActivity.getResources().getString(R.string.birthday), new C0132a());
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RegistrationActivity.this.E.setSelected(!r2.isSelected());
            RegistrationActivity.this.p1();
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RegistrationActivity.this.m1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            RegistrationActivity registrationActivity;
            boolean z10;
            if (i10 == -2) {
                registrationActivity = RegistrationActivity.this;
                z10 = false;
            } else {
                if (i10 != -1) {
                    return;
                }
                registrationActivity = RegistrationActivity.this;
                z10 = true;
            }
            registrationActivity.n1(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements d.f {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f8285f;

            a(String str) {
                this.f8285f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!RegistrationActivity.this.isFinishing()) {
                    RegistrationActivity.this.w1();
                }
                RegistrationActivity.this.R.setPushID(this.f8285f);
                com.groboot.mdaemergency.enums.e u10 = w6.m.u();
                RegistrationActivity registrationActivity = RegistrationActivity.this;
                registrationActivity.R.setSMSCode(registrationActivity.M.getText().toString());
                w6.m.U(RegistrationActivity.this.R);
                RegistrationActivity registrationActivity2 = RegistrationActivity.this;
                registrationActivity2.P.W(registrationActivity2.R, registrationActivity2.Q, this.f8285f, registrationActivity2.M.getText().toString(), u10, RegistrationActivity.this.U0());
            }
        }

        e() {
        }

        @Override // p5.d.f
        public void a(String str) {
            if (str == null || str.length() == 0) {
                RegistrationActivity registrationActivity = RegistrationActivity.this;
                if (!registrationActivity.X) {
                    GoogleTokenService.c(registrationActivity.getApplicationContext());
                }
            }
            RegistrationActivity.this.runOnUiThread(new a(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* loaded from: classes.dex */
        class a implements p.b0 {
            a() {
            }

            @Override // com.groboot.mdaemergency.ptt.p.b0
            public void a() {
                a6.h.j(RegistrationActivity.this.getApplicationContext(), RegistrationActivity.this.getString(R.string.message_ptt_not_available2), true, null);
            }

            @Override // com.groboot.mdaemergency.ptt.p.b0
            public void b(com.groboot.mdaemergency.ptt.p pVar) {
                if (pVar != null) {
                    pVar.u0();
                }
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.groboot.mdaemergency.ptt.p.d0(RegistrationActivity.this, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    RegistrationActivity.this.V.setVisibility(0);
                    RegistrationActivity.this.W.setVisibility(4);
                } catch (Exception unused) {
                }
            }
        }

        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.a(13000L);
            try {
                RegistrationActivity.this.runOnUiThread(new a());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class h {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8291a;

        static {
            int[] iArr = new int[com.groboot.mdaemergency.enums.a.values().length];
            f8291a = iArr;
            try {
                iArr[com.groboot.mdaemergency.enums.a.MADA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8291a[com.groboot.mdaemergency.enums.a.CREW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8291a[com.groboot.mdaemergency.enums.a.PHILIPINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(a.c cVar) {
            RegistrationActivity.this.startActivity(new Intent(RegistrationActivity.this.getApplicationContext(), (Class<?>) ZebraPrinterActivity.class));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RegistrationActivity registrationActivity = RegistrationActivity.this;
            if (!registrationActivity.Z) {
                com.groboot.mdaemergency.a.d(registrationActivity, true, new a.InterfaceC0096a() { // from class: com.groboot.mdaemergency.ui.main.b
                    @Override // com.groboot.mdaemergency.a.InterfaceC0096a
                    public final void a(a.c cVar) {
                        RegistrationActivity.i.this.b(cVar);
                    }
                });
                RegistrationActivity.this.Z = true;
            }
            RegistrationActivity.this.startActivity(new Intent(RegistrationActivity.this.getApplicationContext(), (Class<?>) ZebraPrinterActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(RegistrationActivity.this, (Class<?>) HelpActivity.class);
            intent.addFlags(603979776);
            RegistrationActivity.this.startActivity(intent);
        }
    }

    /* loaded from: classes.dex */
    class k implements a.b {
        k() {
        }

        @Override // com.groboot.mdaemergency.a.b
        public void a(String str) {
            a6.h.o(RegistrationActivity.this, str);
        }

        @Override // com.groboot.mdaemergency.a.b
        public void b() {
        }

        @Override // com.groboot.mdaemergency.a.b
        public void c(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l implements TextView.OnEditorActionListener {
        l() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
            if (i10 != 6) {
                return false;
            }
            RegistrationActivity.this.f8273f0.onClick(null);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RegistrationActivity.this.L.setVisibility(8);
            RegistrationActivity.this.V.setVisibility(8);
            RegistrationActivity registrationActivity = RegistrationActivity.this;
            registrationActivity.Q = "";
            registrationActivity.m1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RegistrationActivity.this.W.setVisibility(4);
            RegistrationActivity.this.S0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o implements View.OnClickListener {
        o(RegistrationActivity registrationActivity) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RegistrationActivity.this.T.setVisibility(8);
            RegistrationActivity.this.v1(false);
            l0.k(RegistrationActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RegistrationActivity.this.U.setVisibility(8);
        }
    }

    private void R0() {
        this.f8277j0 = new Date();
        this.f8278k0 = true;
        PermissionActivity.o(this, PermissionActivity.c.First);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        com.groboot.mdaemergency.async.d.v().h();
    }

    private void T0() {
        this.F.setText("");
        this.F.setText("");
        this.G.setText("");
        this.H.setText("");
        this.K.setText("");
        this.K.setTag("");
        this.E.setSelected(false);
        this.M.setText("");
        this.I.setText("");
        this.J.setText("");
        this.f8272e0 = null;
        W0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b.InterfaceC0098b U0() {
        return new b.InterfaceC0098b() { // from class: u6.p
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                RegistrationActivity.this.b1(aVar);
            }
        };
    }

    private void V0() {
        o0().w(false);
        o0().x(false);
        o0().r(new ColorDrawable(-1));
        View inflate = LayoutInflater.from(this).inflate(R.layout.action_bar, (ViewGroup) null);
        o0().t(inflate);
        o0().v(true);
        ((Toolbar) inflate.getParent()).L(0, 0);
        TextView textView = (TextView) findViewById(R.id.action_bar_title);
        this.A = textView;
        textView.setVisibility(8);
        findViewById(R.id.action_bar_back_button).setVisibility(8);
        ((ImageView) findViewById(R.id.btn_menu)).setVisibility(4);
        TextView textView2 = (TextView) findViewById(R.id.action_bar_title1);
        this.Y = textView2;
        textView2.setText(w6.m.l());
        this.B = (LinearLayout) findViewById(R.id.ll_action_bar_welcome);
        this.C = (RelativeLayout) findViewById(R.id.action_bar_normal);
        v1(true);
        findViewById(R.id.img_languageHebrew).setOnClickListener(this.f8271d0);
        findViewById(R.id.img_languageEnglish).setOnClickListener(this.f8271d0);
        View findViewById = findViewById(R.id.img_languageHebrew);
        com.groboot.mdaemergency.enums.a aVar = this.f8269b0;
        com.groboot.mdaemergency.enums.a aVar2 = com.groboot.mdaemergency.enums.a.PHILIPINE;
        findViewById.setVisibility(aVar == aVar2 ? 8 : 0);
        findViewById(R.id.img_languageEnglish).setVisibility(this.f8269b0 == aVar2 ? 8 : 0);
        ((Button) findViewById(R.id.img_help)).setVisibility(this.f8269b0 != com.groboot.mdaemergency.enums.a.MADA ? 8 : 0);
        findViewById(R.id.img_help).setOnClickListener(new j());
    }

    private void W0() {
        TextView textView;
        int i10;
        int i11 = h.f8291a[this.f8269b0.ordinal()];
        if (i11 == 1) {
            ((ImageView) findViewById(R.id.iv_logo)).setImageDrawable(getResources().getDrawable(R.drawable.sign_up_logo));
            this.T.setVisibility(0);
            findViewById(R.id.id_layout).setVisibility(0);
            findViewById(R.id.is_konan).setVisibility(0);
            findViewById(R.id.v_ih).setVisibility(8);
            textView = (TextView) findViewById(R.id.thank_you_title);
            i10 = R.string.registration_thank_you;
        } else {
            if (i11 != 2) {
                if (i11 == 3) {
                    ((ImageView) findViewById(R.id.iv_logo)).setImageDrawable(getResources().getDrawable(R.drawable.red_cross_logo));
                    this.T.setVisibility(8);
                    findViewById(R.id.id_layout).setVisibility(8);
                    findViewById(R.id.is_konan).setVisibility(8);
                    findViewById(R.id.v_ih).setVisibility(0);
                    textView = (TextView) findViewById(R.id.thank_you_title);
                    i10 = R.string.registration_thank_you_ph;
                }
                Y0();
                p1();
            }
            ((ImageView) findViewById(R.id.iv_logo)).setImageDrawable(getResources().getDrawable(R.drawable.ih_logo));
            this.T.setVisibility(8);
            findViewById(R.id.id_layout).setVisibility(8);
            findViewById(R.id.is_konan).setVisibility(8);
            findViewById(R.id.v_ih).setVisibility(0);
            textView = (TextView) findViewById(R.id.thank_you_title);
            i10 = R.string.registration_thank_you_ih;
        }
        textView.setText(i10);
        Y0();
        p1();
    }

    private void X0() {
        if (this.f8270c0) {
            setContentView(R.layout.activity_splash);
            findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() { // from class: u6.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RegistrationActivity.this.c1(view);
                }
            });
            V0();
            m1();
        }
    }

    private void Y0() {
        int i10 = h.f8291a[this.f8269b0.ordinal()];
        if (i10 == 1 || i10 == 2) {
            findViewById(R.id.rl_crew).setVisibility(0);
            findViewById(R.id.ll_buttons).setVisibility(0);
            findViewById(R.id.rl_vehicle).setVisibility(8);
            findViewById(R.id.ll_registration_buttons).setVisibility(8);
            findViewById(R.id.iv_registrationByVehicle).setVisibility(8);
            findViewById(R.id.iv_registrationByUser).setVisibility(8);
            this.f8272e0 = Boolean.FALSE;
            return;
        }
        if (i10 != 3) {
            return;
        }
        findViewById(R.id.rl_crew).setVisibility(l0.i0(this.f8272e0) ? 0 : 8);
        findViewById(R.id.ll_buttons).setVisibility(this.f8272e0 != null ? 0 : 8);
        findViewById(R.id.rl_vehicle).setVisibility(l0.n0(this.f8272e0) ? 0 : 8);
        findViewById(R.id.ll_registration_buttons).setVisibility(this.f8272e0 == null ? 0 : 8);
        findViewById(R.id.iv_registrationByVehicle).setVisibility(0);
        findViewById(R.id.iv_registrationByUser).setVisibility(0);
        ((ImageView) findViewById(R.id.iv_registrationByVehicle)).setColorFilter(l0.u(getApplicationContext(), R.color.white));
        ((ImageView) findViewById(R.id.iv_registrationByUser)).setColorFilter(l0.u(getApplicationContext(), R.color.white));
        ((ImageView) findViewById(R.id.iv_registrationByVehicle2)).setColorFilter(l0.u(getApplicationContext(), R.color.white));
        ((ImageView) findViewById(R.id.iv_registrationByUser2)).setColorFilter(l0.u(getApplicationContext(), R.color.white));
        findViewById(R.id.iv_registrationByVehicle2).setOnClickListener(new View.OnClickListener() { // from class: u6.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationActivity.this.d1(view);
            }
        });
        findViewById(R.id.iv_registrationByVehicle).setOnClickListener(new View.OnClickListener() { // from class: u6.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationActivity.this.e1(view);
            }
        });
        findViewById(R.id.iv_registrationByUser).setOnClickListener(new View.OnClickListener() { // from class: u6.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationActivity.this.f1(view);
            }
        });
        findViewById(R.id.iv_registrationByUser2).setOnClickListener(new View.OnClickListener() { // from class: u6.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationActivity.this.g1(view);
            }
        });
    }

    private void Z0() {
        setContentView(R.layout.registration);
        V0();
        s1();
        l0.E0(this);
        l0.C0(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a1(b.a aVar) {
        E();
        if (aVar == null) {
            t1(R.string.connection_error);
            return;
        }
        if (!aVar.f7614b) {
            u1(aVar.f7617e);
            return;
        }
        w6.m.U(this.R);
        if (l0.n0(this.f8272e0)) {
            r1(getApplicationContext(), 1800000);
        }
        try {
            androidx.core.app.n.d(this).b(l5.c.f11787c);
        } catch (Exception unused) {
        }
        if (aVar.b("GPS") || Device.isTC25()) {
            this.R.getLocation().setStatus(1);
            this.R.getLocation().setStatusAvailability(com.groboot.mdaemergency.enums.b.AVAILABLE);
            w6.m.U(this.R);
            s5.d.n(getApplicationContext());
            s5.d.j().o();
        }
        w6.m.g0(aVar.f("DisplayStatus") ? aVar.b("DisplayStatus") : true);
        w6.m.f0(aVar.f("IsDevUser") ? aVar.b("IsDevUser") : false);
        w6.m.h0(aVar.f("IsEnablePTT") ? aVar.b("IsEnablePTT") : false);
        w6.m.b0(aVar.f("PrintScreen") ? aVar.b("PrintScreen") : false);
        w6.m.I0(MdaEmergencyApplication.f7530g);
        if (com.groboot.mdaemergency.ptt.p.n0()) {
            if (this.f8269b0 == com.groboot.mdaemergency.enums.a.POC) {
                this.R.setPttUser(aVar.f("PttUser") ? aVar.e("PttUser") : "");
                this.R.setPttPassword(aVar.f("PttPassword") ? aVar.e("PttPassword") : "");
                w6.m.U(this.R);
            }
            new Thread(new f()).start();
        }
        String e10 = aVar.e("Token");
        z.b().e(Device.isTC25() ? true : aVar.b("GPS"));
        z.b().f(e10);
        OpenSocketService.u(getApplicationContext());
        if (!com.groboot.mdaemergency.a.f7539a) {
            Intent intent = new Intent(getBaseContext(), (Class<?>) MainActivity.class);
            intent.putExtra("AfterRegistration", true);
            startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(getBaseContext(), (Class<?>) MainActivity.class);
        intent2.putExtra("AfterRegistration", true);
        startActivity(intent2);
        finish();
        Intent intent3 = new Intent(LockPatternActivity.f8009y, null, getBaseContext(), LockPatternActivity.class);
        e.b.d(getApplicationContext(), true);
        startActivityForResult(intent3, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b1(final b.a aVar) {
        runOnUiThread(new Runnable() { // from class: u6.g
            @Override // java.lang.Runnable
            public final void run() {
                RegistrationActivity.this.a1(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1(View view) {
        m1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d1(View view) {
        this.f8272e0 = Boolean.TRUE;
        Y0();
        this.I.setFocusable(true);
        this.I.requestFocus();
        setRequestedOrientation(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1(View view) {
        this.f8272e0 = Boolean.TRUE;
        Y0();
        this.I.setFocusable(true);
        this.I.requestFocus();
        setRequestedOrientation(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f1(View view) {
        this.f8272e0 = Boolean.FALSE;
        Y0();
        this.F.setFocusable(true);
        this.F.requestFocus();
        setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g1(View view) {
        this.f8272e0 = Boolean.FALSE;
        Y0();
        this.F.setFocusable(true);
        this.F.requestFocus();
        setRequestedOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(View view) {
        w6.n.f(this, view.getTag().toString());
        o1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i1(View view) {
        PermissionActivity.o(this, PermissionActivity.c.First);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j1(DialogInterface dialogInterface, int i10) {
        LockPatternActivity.B();
        startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 12344);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k1(DialogInterface dialogInterface, int i10) {
        this.f8276i0 = Boolean.FALSE;
        m1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1(b.a aVar) {
        E();
        if (aVar == null) {
            return;
        }
        if (!aVar.f7614b) {
            u1(aVar.f7617e);
            return;
        }
        String e10 = aVar.e("TempToken");
        this.Q = e10;
        this.R.setTempToken(e10);
        w6.m.U(this.R);
        this.L.setVisibility(0);
        new Thread(new g()).start();
        this.F.setEnabled(false);
        this.G.setEnabled(false);
        this.K.setEnabled(false);
        this.N.setEnabled(false);
        this.H.setEnabled(false);
        this.E.setEnabled(false);
        this.f8268a0.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        new Throwable();
        if (!this.f8278k0) {
            boolean z10 = com.groboot.mdaemergency.a.m(getApplicationContext()) && com.groboot.mdaemergency.a.o(getApplicationContext());
            this.Z = z10;
            if (!z10) {
                PermissionActivity.o(this, PermissionActivity.c.First);
                R0();
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 33) {
            if (androidx.core.content.a.a(this, "android.permission.POST_NOTIFICATIONS") != 0) {
                androidx.core.app.b.n(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 101);
                return;
            }
            v5.a.a(this);
        }
        if (!l0.i0(this.f8276i0)) {
            if (!t.a(getApplicationContext())) {
                l0.F0(this, R.string.permission, this.f8269b0 != com.groboot.mdaemergency.enums.a.MADA ? R.string.permission_view_over_apps_description_2 : R.string.permission_view_over_apps_description, R.string.ok, R.string.no_thanks, new DialogInterface.OnClickListener() { // from class: u6.h
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        RegistrationActivity.this.j1(dialogInterface, i10);
                    }
                }, new DialogInterface.OnClickListener() { // from class: u6.e
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        RegistrationActivity.this.k1(dialogInterface, i10);
                    }
                });
                return;
            }
            this.f8276i0 = Boolean.TRUE;
        }
        if (l0.n0(this.f8272e0)) {
            if (this.I.length() == 0 || this.J.length() == 0) {
                Toast.makeText(getBaseContext(), R.string.not_all_fields_filled, 1).show();
                return;
            }
            w1();
            q1();
            this.R.setVehicleCode(((Object) this.J.getText()) + "");
            this.R.setRegistrationNumber(this.I.getText().toString());
            this.R.setIsVehicle(true);
        } else if (this.Q.length() == 0) {
            if (this.f8270c0) {
                q1();
                this.R.setIP(w6.f.b());
                return;
            }
            if (this.F.length() == 0 || this.G.length() == 0 || this.K.length() == 0 || (this.H.length() == 0 && this.E.isSelected())) {
                Toast.makeText(getBaseContext(), R.string.not_all_fields_filled, 1).show();
                return;
            }
            w1();
            q1();
            this.R.setIsVehicle(false);
            this.R.setPhone(((Object) this.F.getText()) + "");
            this.R.setID(this.G.getText().toString());
            this.R.setDateOfBirth(this.K.getTag() == null ? "" : this.K.getTag().toString());
            this.R.setType(this.E.isSelected() ? 1 : 0);
            AppUser appUser = this.R;
            appUser.setCode(appUser.getType() == 1 ? this.H.getText().toString() : "");
            d dVar = new d();
            new b.a(this).g("כדי לאמת את זהותך ישלח אליך קוד אימות באמצעות מסרון.\nניתן לקבל את הקוד גם בשיחת טלפון").j("קוד בשיחת טלפון", dVar).h("קוד באמצעות מסרון", dVar).d(false).m();
            return;
        }
        p5.d.i(getApplicationContext(), new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(boolean z10) {
        w6.m.U(this.R);
        this.P.V(this.R, z10, new b.InterfaceC0098b() { // from class: u6.f
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                RegistrationActivity.this.l1(aVar);
            }
        });
    }

    private void o1() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1() {
        if (!this.E.isSelected()) {
            this.E.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.sign_up_check_box, 0, 0, 0);
            this.O.setVisibility(8);
        } else {
            this.E.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.sign_up_check_box_on, 0, 0, 0);
            this.O.setVisibility(0);
            this.H.setFocusable(true);
            this.H.requestFocus();
        }
    }

    private void q1() {
        String a10 = a6.h.a(this);
        AppUser appUser = new AppUser();
        this.R = appUser;
        appUser.setDeviceID(a10);
        this.R.setOSVersion(Build.VERSION.RELEASE);
        this.R.setDeviceName(Build.MODEL);
        try {
            this.R.setAppVersion(getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException unused) {
            this.R.setAppVersion("");
        }
    }

    private void s1() {
        this.F = (EditText) findViewById(R.id.et_phone);
        EditText editText = (EditText) findViewById(R.id.et_pid);
        this.G = editText;
        editText.setOnEditorActionListener(new l());
        this.H = (EditText) findViewById(R.id.et_konan_id);
        this.I = (EditText) findViewById(R.id.et_vehicle_number);
        this.J = (EditText) findViewById(R.id.et_vehicle_coce);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.id_layout);
        this.O = relativeLayout;
        relativeLayout.setVisibility(8);
        this.K = (EditText) findViewById(R.id.et_birthday);
        this.N = (RelativeLayout) findViewById(R.id.birthday_layout);
        View findViewById = findViewById(R.id.view_birthday);
        this.f8268a0 = findViewById;
        findViewById.setOnClickListener(this.f8273f0);
        TextView textView = (TextView) findViewById(R.id.sign_up_again_btn);
        this.V = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) findViewById(R.id.btn_callMe);
        this.W = textView2;
        textView2.setVisibility(4);
        TextView textView3 = (TextView) findViewById(R.id.is_konan);
        this.E = textView3;
        textView3.setOnClickListener(this.f8274g0);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.sms_code_layout);
        this.L = relativeLayout2;
        relativeLayout2.setVisibility(8);
        this.V.setVisibility(8);
        this.V.setOnClickListener(new m());
        this.W.setOnClickListener(new n());
        EditText editText2 = (EditText) findViewById(R.id.sms_code_edit_text);
        this.M = editText2;
        if (Build.VERSION.SDK_INT >= 21) {
            editText2.setBackgroundTintList(getResources().getColorStateList(this.f8269b0.getColors().d()));
        }
        TextView textView4 = (TextView) findViewById(R.id.sign_up_btn);
        this.D = textView4;
        textView4.setOnClickListener(this.f8275h0);
        this.T = findViewById(R.id.ll_welcome);
        this.U = findViewById(R.id.rl_life_register);
        this.T.setOnClickListener(new o(this));
        findViewById(R.id.btn_hide_welcome).setOnClickListener(new p());
        findViewById(R.id.btn_end_register).setOnClickListener(new q());
        W0();
        ((ImageView) findViewById(R.id.phone_icon)).setColorFilter(l0.u(getApplicationContext(), R.color.mada_red_dark));
        ((ImageView) findViewById(R.id.pid_icon)).setColorFilter(l0.u(getApplicationContext(), R.color.mada_red_dark));
        ((ImageView) findViewById(R.id.birthday_icon)).setColorFilter(l0.u(getApplicationContext(), R.color.mada_red_dark));
        ((ImageView) findViewById(R.id.vehicle_icon)).setColorFilter(l0.u(getApplicationContext(), R.color.mada_red_dark));
        ((ImageView) findViewById(R.id.vehicle_coce_icon)).setColorFilter(l0.u(getApplicationContext(), R.color.mada_red_dark));
        l0.j(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(boolean z10) {
        if (z10) {
            this.B.setVisibility(0);
            this.C.setVisibility(8);
        } else {
            this.B.setVisibility(8);
            this.C.setVisibility(0);
        }
    }

    @Override // a6.b
    public void E() {
        a6.h.c();
    }

    @Override // a6.b
    public void I(boolean z10) {
    }

    @Override // a6.b
    public void J(boolean z10) {
    }

    @Override // a6.b
    public void a(String str) {
        TextView textView = this.A;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(w6.n.c(context));
    }

    @Override // a6.b
    public void g(boolean z10) {
    }

    @Override // a6.b
    public void l(boolean z10) {
    }

    @Override // a6.b
    public void o(Fragment fragment, boolean z10) {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().getDecorView().setLayoutDirection("iw".equals(w6.n.a(this)) ? 1 : 0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.U.getVisibility() == 0) {
            this.U.setVisibility(8);
            return;
        }
        if (this.f8269b0 == com.groboot.mdaemergency.enums.a.MADA && this.T.getVisibility() == 8) {
            this.T.setVisibility(0);
            v1(true);
            l0.j(this);
        } else if (this.F.length() > 0 || this.I.length() > 0) {
            T0();
        } else if (this.f8269b0 != com.groboot.mdaemergency.enums.a.PHILIPINE || this.f8272e0 == null) {
            super.onBackPressed();
        } else {
            this.f8272e0 = null;
            W0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Z = false;
        this.f8269b0 = w6.m.m();
        this.f8270c0 = this.f8269b0 == com.groboot.mdaemergency.enums.a.POC;
        this.P = com.groboot.mdaemergency.async.d.v();
        if (this.f8270c0) {
            X0();
        } else {
            Z0();
        }
        Device.getActiveDevice(getApplicationContext());
        if (!Device.isTC25()) {
            findViewById(R.id.ll_printer).setVisibility(8);
        } else {
            findViewById(R.id.ll_printer).setVisibility(0);
            findViewById(R.id.ll_printer).setOnClickListener(new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.j, android.app.Activity
    public void onDestroy() {
        a6.h.c();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, android.app.Activity
    public void onPause() {
        a6.h.c();
        super.onPause();
    }

    @Override // androidx.fragment.app.j, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        com.groboot.mdaemergency.a.v(this, i10, strArr, iArr, new k());
        if (i10 == 101) {
            if (iArr[0] == 0) {
                v5.a.a(this);
            } else {
                Toast.makeText(this, "יש לאפשר הרשאת התראות לצורך קבלת אירועים", 1).show();
            }
        }
    }

    @Override // androidx.fragment.app.j, android.app.Activity
    public void onResume() {
        if (this.S) {
            Intent intent = new Intent(getBaseContext(), (Class<?>) MainActivity.class);
            intent.putExtra("AfterRegistration", true);
            startActivity(intent);
            finish();
        }
        super.onResume();
        findViewById(R.id.btn_permission).setVisibility(this.f8278k0 ? 0 : 8);
        findViewById(R.id.btn_permission).setOnClickListener(new View.OnClickListener() { // from class: u6.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RegistrationActivity.this.i1(view);
            }
        });
        if (g0.b(this.f8277j0).f15162f > 2.0d) {
            m1();
        }
        this.f8277j0 = null;
    }

    @Override // a6.b
    public void q(boolean z10) {
    }

    public boolean r1(Context context, int i10) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setScreenOffTimeout:");
            sb2.append(i10);
            Settings.System.putInt(context.getContentResolver(), "screen_off_timeout", i10);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.app.Activity, a6.b
    public void setTitle(int i10) {
        TextView textView = this.A;
        if (textView != null) {
            textView.setText(i10);
        }
    }

    public void t1(int i10) {
        a6.h.d(this, i10);
    }

    public void u1(String str) {
        a6.h.g(this, str);
    }

    public void w1() {
        a6.h.m(this);
    }
}
