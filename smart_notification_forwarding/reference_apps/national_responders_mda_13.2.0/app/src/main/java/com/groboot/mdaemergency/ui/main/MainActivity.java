package com.groboot.mdaemergency.ui.main;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f0;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import com.groboot.mdaemergency.a;
import com.groboot.mdaemergency.async.FloatViewService;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.models.AppUser;
import com.groboot.mdaemergency.models.Feature;
import com.groboot.mdaemergency.models.Message;
import com.groboot.mdaemergency.models.NotificationData;
import com.groboot.mdaemergency.models.PDFFile;
import com.groboot.mdaemergency.models.SerologyQuestionnaire;
import com.groboot.mdaemergency.models.poc.Device;
import com.groboot.mdaemergency.ptt.PTTDialogView;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ptt.s;
import com.groboot.mdaemergency.services.FileDownloaderService;
import com.groboot.mdaemergency.services.GoogleTokenService;
import com.groboot.mdaemergency.services.PttFloatDialogViewService;
import com.groboot.mdaemergency.ui.LockPatternActivity;
import com.groboot.mdaemergency.ui.VolumeView;
import com.groboot.mdaemergency.ui.activities.OpenCameraActivity;
import com.groboot.mdaemergency.ui.activities.ZebraPrinterActivity;
import com.groboot.mdaemergency.ui.fragments.PDFFragment;
import com.groboot.mdaemergency.ui.main.MainActivity;
import com.groboot.mdaemergency.ui.views.DynamicGridView;
import com.groboot.mdaemergency.ui.views.WebViewMDA;
import d6.t;
import f6.a3;
import f6.b3;
import f6.f1;
import f6.h1;
import f6.j1;
import f6.q0;
import f6.q1;
import f6.s2;
import f6.v;
import f6.v2;
import f6.w2;
import f6.x1;
import g5.e;
import il.org.mda.health.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import w6.c0;
import w6.d0;
import w6.g;
import w6.h0;
import w6.l0;
import w6.z;
import x6.g;

/* loaded from: classes.dex */
public class MainActivity extends androidx.appcompat.app.c implements a6.b, f1.b {

    /* renamed from: b0, reason: collision with root package name */
    public static String f8235b0 = "showFragment";

    /* renamed from: c0, reason: collision with root package name */
    public static boolean f8236c0;
    private ValueCallback A;
    WebViewMDA B;
    com.groboot.mdaemergency.ptt.s C;
    androidx.appcompat.app.a D;
    TextView E;
    TextView F;
    ImageView G;
    ImageView H;
    Button I;
    VolumeView J;
    f1 L;
    q0 M;
    v N;
    h1 O;
    a3 P;
    private boolean Q;
    private boolean R;
    Fragment S;
    PTTDialogView U;
    j1 V;
    Uri X;
    boolean K = false;
    boolean T = false;
    BroadcastReceiver W = new o();
    a6.f Y = new a6.f(this) { // from class: u6.a
    };
    View.OnClickListener Z = new View.OnClickListener() { // from class: u6.b
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MainActivity.this.S0(view);
        }
    };

    /* renamed from: a0, reason: collision with root package name */
    View.OnClickListener f8237a0 = new j();

    /* loaded from: classes.dex */
    class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f8238a;

        a(int i10) {
            this.f8238a = i10;
        }

        @Override // com.groboot.mdaemergency.a.b
        public void a(String str) {
        }

        @Override // com.groboot.mdaemergency.a.b
        public void b() {
            if (this.f8238a == 1021) {
                MainActivity.this.Z0();
            }
        }

        @Override // com.groboot.mdaemergency.a.b
        public void c(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements p.b0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.groboot.mdaemergency.ptt.a f8240a;

        b(MainActivity mainActivity, com.groboot.mdaemergency.ptt.a aVar) {
            this.f8240a = aVar;
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void a() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void b(com.groboot.mdaemergency.ptt.p pVar) {
            pVar.W0(this.f8240a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MainActivity.this.Z0();
            }
        }

        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d0.a(200L);
            new Handler(Looper.getMainLooper()).post(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements p.b0 {
        d() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void a() {
            a6.h.j(MainActivity.this.getApplicationContext(), MainActivity.this.getString(R.string.message_ptt_not_available2), true, null);
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void b(com.groboot.mdaemergency.ptt.p pVar) {
            if (pVar.i0() == p.a0.notReady || pVar.i0() == p.a0.login) {
                a6.h.j(MainActivity.this.getApplicationContext(), MainActivity.this.getString(R.string.message_ptt_not_available), true, null);
                pVar.v0();
                return;
            }
            com.groboot.mdaemergency.ptt.j jVar = new com.groboot.mdaemergency.ptt.j(MainActivity.this.Y);
            if (MainActivity.this.R) {
                jVar.u2();
                MainActivity.this.R = false;
            }
            MainActivity.this.o(jVar, true);
            x5.j.o2(MainActivity.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.L.k2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MainActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f8246f;

        g(View view) {
            this.f8246f = view;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i10) {
            if ((i10 & 4) == 0) {
                this.f8246f.setSystemUiVisibility(MainActivity.this.L0());
            }
        }
    }

    /* loaded from: classes.dex */
    class h implements p.b0 {
        h(MainActivity mainActivity) {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void a() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void b(com.groboot.mdaemergency.ptt.p pVar) {
            pVar.f1();
            pVar.Q0(s.a.main);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements b.InterfaceC0098b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8248a;

        i(String str) {
            this.f8248a = str;
        }

        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
        public void a(b.a aVar) {
            AppUser k10 = w6.m.k();
            k10.setDeviceID(this.f8248a);
            w6.m.U(k10);
            GoogleTokenService.c(MainActivity.this.getApplicationContext());
            MainActivity mainActivity = MainActivity.this;
            a6.h.o(mainActivity, mainActivity.getString(R.string.push_notification_start_work));
        }
    }

    /* loaded from: classes.dex */
    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, (Class<?>) HelpActivity.class);
            intent.addFlags(603979776);
            MainActivity.this.startActivity(intent);
        }
    }

    /* loaded from: classes.dex */
    class k implements DynamicGridView.c {
        k(MainActivity mainActivity) {
        }

        @Override // com.groboot.mdaemergency.ui.views.DynamicGridView.c
        public void a(List<Feature> list) {
        }

        @Override // com.groboot.mdaemergency.ui.views.DynamicGridView.c
        public void b(int i10) {
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class l {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8251a;

        static {
            int[] iArr = new int[a.c.values().length];
            f8251a = iArr;
            try {
                iArr[a.c.ALLOWED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8251a[a.c.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8251a[a.c.NEVER_AGAIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m implements y5.c {
        m(MainActivity mainActivity) {
        }

        @Override // y5.c
        public void a(IOException iOException) {
        }

        @Override // y5.c
        public void b(String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[CheckMockLocation] is updated to be ");
            sb2.append(str);
        }
    }

    /* loaded from: classes.dex */
    class n implements p.b0 {
        n() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void a() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void b(com.groboot.mdaemergency.ptt.p pVar) {
            pVar.E(s.a.main, MainActivity.this.C);
        }
    }

    /* loaded from: classes.dex */
    class o extends BroadcastReceiver {
        o() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() != null) {
                String action = intent.getAction();
                a3.a aVar = a3.L0;
                if (action.equals(aVar.b())) {
                    String stringExtra = intent.hasExtra(aVar.a()) ? intent.getStringExtra(aVar.a()) : "";
                    MainActivity mainActivity = MainActivity.this;
                    Fragment fragment = mainActivity.S;
                    a3 a3Var = mainActivity.P;
                    if (fragment == a3Var) {
                        a3Var.H2(stringExtra);
                    } else {
                        p5.d.o(context, (NotificationData) new com.google.gson.e().i(stringExtra, NotificationData.class));
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class p implements p.b0 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Feature f8254a;

        p(MainActivity mainActivity, Feature feature) {
            this.f8254a = feature;
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void b(com.groboot.mdaemergency.ptt.p pVar) {
            pVar.c1((com.groboot.mdaemergency.ptt.a) this.f8254a.object);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q implements com.groboot.mdaemergency.ptt.s {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a(q qVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        q() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(com.groboot.mdaemergency.ptt.a aVar) {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.U.p(mainActivity, aVar, mainActivity.findViewById(R.id.v_under_ptt));
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void a(String str) {
            MainActivity.this.runOnUiThread(new a(this));
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public boolean b(final com.groboot.mdaemergency.ptt.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("open dialog Description:");
            sb2.append(aVar.f7788b.f15238d);
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.groboot.mdaemergency.ui.main.a
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.q.this.j(aVar);
                }
            });
            return true;
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void c(com.groboot.mdaemergency.ptt.a aVar) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void d(p.a0 a0Var, p.a0 a0Var2) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void e(w6.p pVar) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void f(com.groboot.mdaemergency.ptt.a aVar) {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.U.v(mainActivity, aVar, mainActivity.findViewById(R.id.v_under_ptt));
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void g(w6.r rVar) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void h(e.a aVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class r implements PTTDialogView.h {
        r() {
        }

        @Override // com.groboot.mdaemergency.ptt.PTTDialogView.h
        public void a() {
            MainActivity.this.Q0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class s implements WebViewMDA.k {

        /* loaded from: classes.dex */
        class a implements OpenCameraActivity.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ h0 f8258a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ WebViewMDA.j f8259b;

            /* renamed from: com.groboot.mdaemergency.ui.main.MainActivity$s$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0129a implements l0.f {

                /* renamed from: com.groboot.mdaemergency.ui.main.MainActivity$s$a$a$a, reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class C0130a implements d.x {

                    /* renamed from: com.groboot.mdaemergency.ui.main.MainActivity$s$a$a$a$a, reason: collision with other inner class name */
                    /* loaded from: classes.dex */
                    class RunnableC0131a implements Runnable {
                        RunnableC0131a() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            a6.h.j(MainActivity.this.getApplicationContext(), MainActivity.this.getString(R.string.file_upload_to_server_success), true, null);
                        }
                    }

                    C0130a() {
                    }

                    @Override // com.groboot.mdaemergency.async.d.x
                    public void a(String str) {
                        MainActivity.this.f1(str);
                    }

                    @Override // com.groboot.mdaemergency.async.d.x
                    public void b(String str) {
                        MainActivity.this.runOnUiThread(new RunnableC0131a());
                        a.this.f8259b.a(str);
                    }
                }

                C0129a() {
                }

                @Override // w6.l0.f
                public void a(String str) {
                    a.this.f8258a.f15176f = str;
                    com.groboot.mdaemergency.async.d.v().w0(a.this.f8258a, new C0130a());
                }

                @Override // w6.l0.f
                public void b(String str) {
                    MainActivity.this.f1(str);
                    a aVar = a.this;
                    aVar.f8259b.a(w6.j.b(aVar.f8258a));
                }
            }

            a(h0 h0Var, WebViewMDA.j jVar) {
                this.f8258a = h0Var;
                this.f8259b = jVar;
            }

            @Override // com.groboot.mdaemergency.ui.activities.OpenCameraActivity.a
            public void a(Uri uri) {
                l0.p(uri, MainActivity.this, new C0129a());
            }

            @Override // com.groboot.mdaemergency.ui.activities.OpenCameraActivity.a
            public void cancel() {
            }
        }

        /* loaded from: classes.dex */
        class b implements g.e {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8264a;

            b(String str) {
                this.f8264a = str;
            }

            @Override // x6.g.e
            public void a() {
            }

            @Override // x6.g.e
            public void b(Editable editable) {
                MainActivity.this.B.k(this.f8264a, ((Object) editable) + "");
            }
        }

        /* loaded from: classes.dex */
        class c implements a.InterfaceC0096a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ GeolocationPermissions.Callback f8266a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f8267b;

            c(s sVar, GeolocationPermissions.Callback callback, String str) {
                this.f8266a = callback;
                this.f8267b = str;
            }

            @Override // com.groboot.mdaemergency.a.InterfaceC0096a
            public void a(a.c cVar) {
                int i10 = l.f8251a[cVar.ordinal()];
                if (i10 == 1) {
                    this.f8266a.invoke(this.f8267b, true, true);
                } else if (i10 == 2 || i10 == 3) {
                    this.f8266a.invoke(this.f8267b, false, false);
                }
            }
        }

        s() {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void a() {
            MainActivity.this.k();
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void b(WebViewMDA.j jVar) {
            MainActivity.this.i1(new q1(jVar), true);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void c(Uri uri) {
            MainActivity.this.startActivity(new Intent("android.intent.action.DIAL", uri));
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void d(String str, String str2) {
            com.groboot.mdaemergency.ui.fragments.a aVar = new com.groboot.mdaemergency.ui.fragments.a();
            aVar.w2(str, Environment.getExternalStorageDirectory() + "/" + str2);
            MainActivity.this.h1(aVar, true);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void e(String str, String str2, int i10, int i11) {
            if (i11 == 1) {
                a6.i.k2(MainActivity.this.d0(), str, str2, i10);
                return;
            }
            w2 w2Var = new w2();
            w2Var.p2(str, str2, i10);
            MainActivity.this.o(w2Var, true);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void f(String str, String str2, int i10) {
            PDFFile pDFFile = new PDFFile();
            pDFFile.url = str;
            pDFFile.name = str2;
            if (i10 == 1) {
                a6.c.k2(MainActivity.this.d0(), pDFFile);
                return;
            }
            PDFFragment pDFFragment = new PDFFragment();
            pDFFragment.p2(pDFFile);
            MainActivity.this.o(pDFFragment, true);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void g(com.groboot.mdaemergency.ptt.a aVar) {
            if (com.groboot.mdaemergency.ptt.p.c0() == null) {
                a6.h.j(MainActivity.this.getApplicationContext(), "PTT לא זמין", true, null);
            } else {
                com.groboot.mdaemergency.ptt.p.c0().c1(aVar);
            }
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void h(String str, String str2, String str3) {
            MainActivity.this.b1(str, str2, str3);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void i(String str) {
            a6.h.j(MainActivity.this.getApplicationContext(), str, true, null);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void j(String str, String str2, String str3, String str4) {
            FileDownloaderService.c(MainActivity.this.getApplicationContext(), str, str2, str3, str4);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void k(String str) {
            h1 h1Var = MainActivity.this.O;
            if (h1Var != null) {
                h1Var.y2();
            }
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public boolean l(ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            MainActivity.this.A = valueCallback;
            MainActivity.this.X0();
            return true;
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void m(String str, String str2) {
            h1 h1Var = MainActivity.this.O;
            if (h1Var != null) {
                h1Var.x2(new w5.a(str, str2));
            }
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void n(Message message) {
            int i10 = message.HtmlOpen;
            if (i10 == 0) {
                return;
            }
            if (i10 == 1) {
                MainActivity.this.O = new h1(message, MainActivity.this.W0());
                try {
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.O.i2(mainActivity.d0(), "l");
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            if (i10 == 2) {
                MainActivity.this.O = new h1(message, MainActivity.this.W0());
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.h1(mainActivity2.O, true);
            }
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void o(String str, GeolocationPermissions.Callback callback) {
            if (com.groboot.mdaemergency.a.m(MainActivity.this)) {
                callback.invoke(str, true, true);
                return;
            }
            MainActivity.this.T = true;
            LockPatternActivity.B();
            com.groboot.mdaemergency.a.c(MainActivity.this, new c(this, callback, str));
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void p(Message message, String str, String str2) {
            com.groboot.mdaemergency.async.d.v().d0(MainActivity.this, str, message.MessageID, str2);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void q(String str, String str2) {
            x6.g.s2(MainActivity.this, new b(str2), str);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void r(SerologyQuestionnaire serologyQuestionnaire) {
            MainActivity.this.o(new x1(serologyQuestionnaire), true);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void s(String str) {
            MainActivity.this.g1(str);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void t(WebViewMDA webViewMDA) {
            MainActivity.this.B = webViewMDA;
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void u(String str, String str2) {
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void v(String str) {
            c0.e(str);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void w(String str, String str2, String str3, String str4, String str5) {
            a6.h.j(MainActivity.this.getApplicationContext(), "לא זמין. ERROR: 998", true, null);
        }

        @Override // com.groboot.mdaemergency.ui.views.WebViewMDA.k
        public void x(h0 h0Var, WebViewMDA.j jVar) {
            MainActivity mainActivity = MainActivity.this;
            mainActivity.T = true;
            OpenCameraActivity.h(mainActivity, 5, new a(h0Var, jVar));
        }
    }

    private void K0() {
        try {
            String str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            if (!w6.m.P().equals(str)) {
                V0();
            }
            w6.m.G0(str);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int L0() {
        return 5638;
    }

    private com.groboot.mdaemergency.ptt.s M0() {
        return new q();
    }

    private PTTDialogView.h N0() {
        return new r();
    }

    private void O0() {
        if (e1()) {
            View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new g(decorView));
        }
    }

    private void P0() {
        androidx.appcompat.app.a o02 = o0();
        this.D = o02;
        o02.w(false);
        this.D.v(true);
        this.D.x(false);
        this.D.s(R.layout.action_bar);
        this.D.r(getResources().getDrawable(R.drawable.actionbar_background));
        this.H = (ImageView) findViewById(R.id.action_bar_back_button);
        this.I = (Button) findViewById(R.id.btn_help);
        this.J = (VolumeView) findViewById(R.id.btn_ptt_volume);
        this.G = (ImageView) findViewById(R.id.btn_menu);
        Q0();
        findViewById(R.id.btn_menu).setOnClickListener(new e());
        this.F = (TextView) findViewById(R.id.action_bar_url);
        TextView textView = (TextView) findViewById(R.id.action_bar_title);
        this.E = textView;
        textView.setText(w6.m.l());
        this.H.setOnClickListener(new f());
        this.I.setOnClickListener(this.f8237a0);
        this.J.setOnClickListener(this.Z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        VolumeView volumeView;
        VolumeView.c cVar;
        if (this.J == null) {
            return;
        }
        try {
            g.d byInt = g.d.getByInt(l0.U(w6.m.G()));
            if (byInt == g.d.Silence) {
                volumeView = this.J;
                cVar = VolumeView.c.off;
            } else if (byInt == g.d.NONE) {
                volumeView = this.J;
                cVar = VolumeView.c.on;
            } else {
                volumeView = this.J;
                cVar = VolumeView.c.none;
            }
            volumeView.setMode(cVar);
        } catch (Exception unused) {
        }
    }

    private void R0() {
        AppUser k10 = w6.m.k();
        if (k10 != null && Device.isTC25()) {
            if (w6.m.t() && k10.getLocation().getStatusAvailability() == com.groboot.mdaemergency.enums.b.AVAILABLE) {
                return;
            }
            w6.m.k0(true);
            k10.getLocation().setStatusAvailability(com.groboot.mdaemergency.enums.b.AVAILABLE);
            w6.m.U(k10);
            s5.d.n(getApplicationContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(View view) {
        c1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T0(com.groboot.mdaemergency.enums.b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U0(String str, b.a aVar) {
        if (aVar != null && aVar.f7614b) {
            w6.m.k().setPushID(str);
        }
    }

    private void V0() {
        s5.d.j().t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WebViewMDA.k W0() {
        return new s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        if (com.groboot.mdaemergency.a.y(this, null)) {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MDA");
            if (!file.exists()) {
                file.mkdirs();
            }
            this.X = Uri.fromFile(new File(file + File.separator + "IMG_" + String.valueOf(System.currentTimeMillis()) + ".jpg"));
            ArrayList arrayList = new ArrayList();
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            for (ResolveInfo resolveInfo : getPackageManager().queryIntentActivities(intent, 0)) {
                String str = resolveInfo.activityInfo.packageName;
                Intent intent2 = new Intent(intent);
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                intent2.setPackage(str);
                intent2.putExtra("output", this.X);
                arrayList.add(intent2);
            }
            Intent intent3 = new Intent();
            intent3.setType("*/*");
            intent3.setAction("android.intent.action.GET_CONTENT");
            Intent createChooser = Intent.createChooser(intent3, "Select Source");
            createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
            startActivityForResult(createChooser, 4);
        }
    }

    private void Y0(Intent intent) {
        com.groboot.mdaemergency.enums.d dVar;
        if (intent.hasExtra("FloatViewType") && (dVar = (com.groboot.mdaemergency.enums.d) intent.getSerializableExtra("FloatViewType")) != null && dVar != com.groboot.mdaemergency.enums.d.BACK_TO_APP && dVar == com.groboot.mdaemergency.enums.d.PTT && com.groboot.mdaemergency.ptt.p.n0()) {
            if (!intent.hasExtra(com.groboot.mdaemergency.ptt.p.f7897w)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("intent no extra: EXTRA_CONTACT_TYPE (");
                sb2.append(com.groboot.mdaemergency.ptt.p.f7897w);
                sb2.append(")");
                return;
            }
            String stringExtra = intent.getStringExtra(com.groboot.mdaemergency.ptt.p.f7897w);
            if (l0.l0(stringExtra)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("intent extra: EXTRA_CONTACT_TYPE (");
                sb3.append(com.groboot.mdaemergency.ptt.p.f7897w);
                sb3.append(") is empty");
                return;
            }
            this.R = false;
            this.Q = false;
            if (!stringExtra.equals(com.groboot.mdaemergency.ptt.p.f7898x)) {
                if (stringExtra.equals(com.groboot.mdaemergency.ptt.p.f7899y)) {
                    this.Q = true;
                    return;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("intent extra: EXTRA_CONTACT_TYPE: ");
                sb4.append(stringExtra);
                return;
            }
            com.groboot.mdaemergency.ptt.a aVar = (com.groboot.mdaemergency.ptt.a) new com.google.gson.e().i(intent.getStringExtra(com.groboot.mdaemergency.ptt.p.f7896v), com.groboot.mdaemergency.ptt.a.class);
            if (aVar != null) {
                this.R = true;
                com.groboot.mdaemergency.ptt.p.d0(getApplicationContext(), new b(this, aVar));
            }
            this.Q = true;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("set contact:");
            sb5.append(aVar.f7788b.f15238d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        if (com.groboot.mdaemergency.ptt.p.n0()) {
            com.groboot.mdaemergency.ptt.p.d0(getApplicationContext(), new d());
        } else {
            a6.h.j(getApplicationContext(), "מערכת הPTT אינה פעילה. ניתן לשנות במסך הגדרות", true, null);
        }
    }

    private void a1() {
        new Thread(new c()).start();
    }

    private void d1() {
        String a10;
        if (w6.m.k() == null) {
            return;
        }
        String deviceID = w6.m.k() == null ? null : w6.m.k().getDeviceID();
        if ((deviceID == null || deviceID.isEmpty()) && com.groboot.mdaemergency.a.o(getApplicationContext()) && (a10 = a6.h.a(this)) != null) {
            com.groboot.mdaemergency.async.d.v().k0(a10, new i(a10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(String str) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    private void j1() {
        h1(this.M, false);
    }

    private void m1() {
        y5.d.e().c("CheckMockLocation", new m(this));
    }

    private void n1() {
        AppUser k10 = w6.m.k();
        if (k10 == null) {
            return;
        }
        String pushID = k10.getPushID();
        final String j10 = p5.d.j();
        if (j10 == null) {
            return;
        }
        if (pushID == null || !pushID.equals(j10)) {
            com.groboot.mdaemergency.async.d.v().n0(j10, new b.InterfaceC0098b() { // from class: u6.c
                @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                public final void a(b.a aVar) {
                    MainActivity.U0(j10, aVar);
                }
            });
        }
    }

    @Override // a6.b
    public void E() {
        a6.h.c();
    }

    @Override // a6.b
    public void I(boolean z10) {
        ImageView imageView;
        int i10;
        if (z10) {
            imageView = this.G;
            i10 = 0;
        } else {
            imageView = this.G;
            i10 = 4;
        }
        imageView.setVisibility(i10);
    }

    @Override // a6.b
    public void J(boolean z10) {
        com.groboot.mdaemergency.enums.a m10 = w6.m.m();
        if (!z10 || m10 != com.groboot.mdaemergency.enums.a.MADA) {
            this.I.setVisibility(8);
        } else {
            this.H.setVisibility(8);
            this.I.setVisibility(0);
        }
    }

    @Override // a6.b
    public void a(String str) {
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // androidx.appcompat.app.c, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(w6.n.c(context));
    }

    public void b1(String str, String str2, String str3) {
        a6.h.j(getApplicationContext(), "לא זמין. ERROR: 998", true, null);
    }

    @Override // f6.f1.b
    public void c() {
        LockPatternActivity.C(this, false);
    }

    public void c1() {
        com.groboot.mdaemergency.ptt.p.c0().U();
        this.U.s();
        Q0();
    }

    public boolean e1() {
        if (w6.m.m() != com.groboot.mdaemergency.enums.a.POC || Build.VERSION.SDK_INT < 19) {
            return false;
        }
        getWindow().getDecorView().setSystemUiVisibility(L0());
        return true;
    }

    public void f1(String str) {
        a6.h.g(this, str);
    }

    @Override // a6.b
    public void g(boolean z10) {
        if (!z10) {
            this.H.setVisibility(4);
        } else {
            this.H.setVisibility(0);
            this.I.setVisibility(8);
        }
    }

    public void h1(Fragment fragment, boolean z10) {
        if (isFinishing()) {
            return;
        }
        this.S = fragment;
        f0 o10 = d0().o();
        o10.p(R.id.content, fragment, "tag");
        if (z10) {
            o10.g(null);
        }
        o10.i();
    }

    public void i1(a6.a aVar, boolean z10) {
        if (isFinishing()) {
            return;
        }
        this.S = aVar;
        f0 o10 = d0().o();
        o10.c(R.id.content, aVar, "tag");
        if (z10) {
            o10.g(null);
        }
        o10.i();
    }

    @Override // f6.f1.b
    public void j(Feature feature) {
        a3 a3Var = new a3((Feature<Object>) feature, W0());
        this.P = a3Var;
        o(a3Var, true);
    }

    @Override // f6.f1.b
    public void k() {
        Fragment fragment = this.S;
        q0 q0Var = this.M;
        if (fragment == q0Var) {
            q0Var.k3();
        } else {
            o(q0Var, false);
        }
    }

    public void k1() {
        new v2(new k(this)).i2(d0(), "shortcutButtons");
    }

    @Override // a6.b
    public void l(boolean z10) {
        VolumeView volumeView;
        int i10;
        if (z10) {
            volumeView = this.J;
            i10 = 0;
        } else {
            volumeView = this.J;
            i10 = 8;
        }
        volumeView.setVisibility(i10);
    }

    public void l1() {
        b1("", "", "");
    }

    @Override // a6.b
    public void o(Fragment fragment, boolean z10) {
        this.M.T2();
        h1(fragment, z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        boolean equals;
        Uri uri;
        super.onActivityResult(i10, i11, intent);
        this.K = true;
        if (i10 != 1) {
            if (i10 != 2) {
                if ((i10 == 3 || i10 == 4) && this.A != null) {
                    if (intent == null) {
                        equals = true;
                    } else {
                        String action = intent.getAction();
                        equals = action == null ? false : action.equals("android.media.action.IMAGE_CAPTURE");
                    }
                    Uri[] uriArr = new Uri[1];
                    if (equals) {
                        uriArr[0] = this.X;
                    } else {
                        uriArr[0] = intent == null ? null : intent.getData();
                    }
                    if (uriArr[0] == null && (uri = this.X) != null) {
                        uriArr[0] = uri;
                    }
                    if (uriArr[0] == null) {
                        return;
                    }
                    this.A.onReceiveValue(uriArr);
                    this.A = null;
                    return;
                }
                return;
            }
            if (i11 != 0 && i11 != 2 && i11 != 3) {
                return;
            }
        }
        finish();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().getDecorView().setLayoutDirection("iw".equals(w6.n.a(this)) ? 1 : 0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        try {
            try {
                WebViewMDA webViewMDA = this.B;
                if (webViewMDA != null && webViewMDA.canGoBack()) {
                    this.B.goBack();
                    return;
                }
                d0();
                this.S = null;
                super.onBackPressed();
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.j, androidx.activity.ComponentActivity, androidx.core.app.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        K0();
        l0.C0(this);
        if (!w6.m.i()) {
            getWindow().setFlags(8192, 8192);
        }
        setContentView(R.layout.activity_main);
        this.C = M0();
        n1();
        f1 f1Var = new f1();
        this.L = f1Var;
        f1Var.i2(this);
        this.L.j2(this, R.id.drawerFragment);
        PTTDialogView pTTDialogView = (PTTDialogView) findViewById(R.id.pttv);
        this.U = pTTDialogView;
        pTTDialogView.f7722i = N0();
        q0 q0Var = new q0();
        this.M = q0Var;
        q0Var.y3(W0());
        if (w6.m.m() == com.groboot.mdaemergency.enums.a.POC) {
            v vVar = new v();
            this.N = vVar;
            vVar.J2(W0());
        }
        P0();
        l0.E0(this);
        Y0(getIntent());
        j1();
        O0();
        this.U.i();
        findViewById(R.id.v_under_ptt).setVisibility(8);
        R0();
        registerReceiver(this.W, new IntentFilter(a3.L0.b()));
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.W);
    }

    @Override // androidx.appcompat.app.c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (w6.m.m() == com.groboot.mdaemergency.enums.a.POC) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("OnKeyDown:");
            sb2.append(i10);
            if (i10 == 82) {
                if (!this.N.t0()) {
                    h1(this.N, true);
                }
                return true;
            }
        }
        if (w6.m.s() && w6.m.r() && com.groboot.mdaemergency.ptt.p.c0() != null && com.groboot.mdaemergency.ptt.p.c0().A0(getApplicationContext(), i10, keyEvent.getAction())) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (w6.m.s() && w6.m.r() && com.groboot.mdaemergency.ptt.p.c0() != null && com.groboot.mdaemergency.ptt.p.c0().A0(getApplicationContext(), i10, keyEvent.getAction())) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try {
            Y0(intent);
        } catch (Exception unused) {
        }
    }

    @Override // androidx.fragment.app.j, android.app.Activity
    public void onPause() {
        super.onPause();
        f8236c0 = false;
        WebViewMDA webViewMDA = this.B;
        if (webViewMDA != null) {
            webViewMDA.q();
        }
        ((MdaEmergencyApplication) getApplication()).f7536f = false;
        if (com.groboot.mdaemergency.ptt.p.n0()) {
            com.groboot.mdaemergency.ptt.p.d0(getApplicationContext(), new h(this));
        }
    }

    @Override // androidx.fragment.app.j, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (strArr.length == 0 && iArr.length == 0) {
            return;
        }
        super.onRequestPermissionsResult(i10, strArr, iArr);
        com.groboot.mdaemergency.a.v(this, i10, strArr, iArr, new a(i10));
    }

    @Override // androidx.fragment.app.j, android.app.Activity
    public void onResume() {
        j1 j1Var;
        super.onResume();
        f8236c0 = true;
        sendBroadcast(new Intent("appOpen"));
        com.groboot.mdaemergency.async.d.w(getApplicationContext()).j0(getApplicationContext());
        d1();
        PTTDialogView pTTDialogView = this.U;
        if (pTTDialogView.f7723j) {
            pTTDialogView.r();
        }
        m1();
        String x10 = w6.m.x();
        int y10 = w6.m.y();
        String w10 = w6.m.w();
        if (this.T) {
            this.T = false;
        } else if (com.groboot.mdaemergency.enums.f.getById(y10) == com.groboot.mdaemergency.enums.f.whatApp) {
            w6.m.p0(-1);
            w6.m.o0("");
            a3 a3Var = new a3(w10, W0());
            this.P = a3Var;
            h1(a3Var, true);
        } else if (x10 != null && !x10.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MainActivity onResume messageID:");
            sb2.append(getIntent().getStringExtra(p5.d.f13069e));
            j1();
        }
        if (getIntent().hasExtra(f8235b0) && getIntent().getStringExtra(f8235b0).equals(s2.class.getName())) {
            h1(new s2(), true);
        }
        if (j1.q2(getApplicationContext()) && ((j1Var = this.V) == null || j1Var.Z1() == null || !this.V.Z1().isShowing())) {
            j1 j1Var2 = new j1();
            this.V = j1Var2;
            try {
                j1Var2.i2(d0(), "l");
            } catch (Exception unused) {
            }
        }
        s5.d.n(getApplicationContext());
        s5.d.j().s(this);
        K0();
        com.groboot.mdaemergency.ptt.p.d0(getApplicationContext(), new n());
        if (com.groboot.mdaemergency.async.d.v().Q()) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(0);
            this.F.setText(com.groboot.mdaemergency.async.d.v().K());
        }
        ((MdaEmergencyApplication) getApplication()).f7536f = true;
        if (this.K) {
            this.K = false;
        } else if (getIntent().getBooleanExtra("AfterRegistration", false) || getIntent().getBooleanExtra("recreateInApp", false)) {
            getIntent().putExtra("AfterRegistration", false);
            getIntent().removeExtra(f8235b0);
            getIntent().putExtra("recreateInApp", false);
        } else if (z.b().d()) {
            LockPatternActivity.C(this, true);
        } else {
            w6.m.c();
            a6.h.n(this);
            finish();
        }
        if (this.Q) {
            this.Q = false;
            a1();
        }
        PttFloatDialogViewService.l(getApplicationContext());
        Q0();
        FloatViewService.l(getApplicationContext());
        v5.a.b(getApplicationContext());
    }

    public void onTestZoomClick(View view) {
        l1();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    @SuppressLint({"NewApi"})
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            e1();
        }
    }

    @Override // a6.b
    public void q(boolean z10) {
    }

    @Override // f6.f1.b
    public void s(Feature feature, boolean z10) {
        Fragment fVar;
        Fragment fragment;
        if (MdaEmergencyApplication.a() == com.groboot.mdaemergency.enums.a.MADA && Device.isTC25() && feature.IconID == 92) {
            feature.FeatureType = Feature.eFeatureType.CoronaTester.getId();
        }
        if (feature.getHtmlType() == 4) {
            PDFFile pDFFile = new PDFFile();
            pDFFile.url = feature.URL;
            pDFFile.name = feature.getDescription();
            PDFFragment pDFFragment = new PDFFragment();
            pDFFragment.p2(pDFFile);
            o(pDFFragment, true);
            return;
        }
        if (feature.getHtmlType() == 5) {
            w2 w2Var = new w2();
            w2Var.p2(feature.URL, feature.getDescription(), 20);
            o(w2Var, true);
            return;
        }
        if (feature.getHtmlType() == 6) {
            g1(feature.URL);
            return;
        }
        if (feature.getHtmlType() == 7) {
            return;
        }
        if (feature.FeatureType == Feature.eFeatureType.GetMessage.getId()) {
            h1 h1Var = new h1(feature, W0());
            this.O = h1Var;
            int i10 = feature.HtmlOpen;
            if (i10 == 1) {
                try {
                    h1Var.i2(d0(), "l");
                    return;
                } catch (Exception unused) {
                    return;
                }
            } else {
                fragment = h1Var;
                if (i10 != 2) {
                    return;
                }
            }
        } else {
            if (feature.FeatureType == Feature.eFeatureType.PTT.getId()) {
                if (feature.isAdded) {
                    com.groboot.mdaemergency.ptt.p.d0(this, new p(this, feature));
                    return;
                } else {
                    Z0();
                    return;
                }
            }
            if (feature.FeatureType != Feature.eFeatureType.FileExplorer.getId()) {
                if (feature.FeatureType == Feature.eFeatureType.ReportMessage.getId()) {
                    com.groboot.mdaemergency.async.d.v().d0(this, feature.Data, feature.MessageID, feature.Refresh + "");
                    if (feature.Close == Feature.eClose.CloseApp.toInt()) {
                        l0.z0(this);
                        return;
                    }
                    return;
                }
                if (feature.FeatureType == Feature.eFeatureType.WhatsNew.getId()) {
                    fVar = new b3();
                } else {
                    if (feature.FeatureType == Feature.eFeatureType.Settings.getId()) {
                        o(new s2(), z10);
                        return;
                    }
                    if (feature.FeatureType == Feature.eFeatureType.Availability.getId()) {
                        t.C2(this, new t.c() { // from class: u6.d
                            @Override // d6.t.c
                            public final void a(com.groboot.mdaemergency.enums.b bVar) {
                                MainActivity.T0(bVar);
                            }
                        });
                        return;
                    }
                    if (feature.FeatureType == Feature.eFeatureType.Events.getId()) {
                        fVar = this.N;
                    } else if (feature.FeatureType == Feature.eFeatureType.CoronaBarcode.getId()) {
                        fVar = new f6.d();
                    } else if (feature.FeatureType == Feature.eFeatureType.CoronaTester.getId()) {
                        fVar = new f6.e();
                    } else if (feature.FeatureType == Feature.eFeatureType.PrintCoronaBarcode.getId()) {
                        startActivity(new Intent(getApplicationContext(), (Class<?>) ZebraPrinterActivity.class));
                        return;
                    } else if (feature.FeatureType == Feature.eFeatureType.SamplesSummeryCorona.getId()) {
                        fVar = new com.groboot.mdaemergency.ui.fragments.c();
                    } else if (feature.FeatureType == Feature.eFeatureType.EligibilityCheck.getId()) {
                        fVar = new f6.n();
                    } else if (feature.FeatureType != Feature.eFeatureType.ReportCovidIsolation.getId()) {
                        return;
                    } else {
                        fVar = new g6.f();
                    }
                }
                h1(fVar, z10);
                return;
            }
            if (l0.l0(feature.Data)) {
                feature.Data = "MADA";
            }
            com.groboot.mdaemergency.ui.fragments.a aVar = new com.groboot.mdaemergency.ui.fragments.a();
            aVar.w2(feature.Description, Environment.getExternalStorageDirectory() + "/" + feature.Data);
            fragment = aVar;
        }
        h1(fragment, z10);
    }

    @Override // android.app.Activity, a6.b
    public void setTitle(int i10) {
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(i10);
        }
    }

    @Override // f6.f1.b
    public void y() {
        if (com.groboot.mdaemergency.async.d.v().i() == null) {
            return;
        }
        o(new s2(), true);
    }
}
