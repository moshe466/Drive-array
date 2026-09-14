package com.groboot.mdaemergency.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.ui.TestLogActivity;
import g5.e;
import il.org.mda.health.R;
import java.util.Arrays;
import p5.d;
import w6.d0;
import w6.l0;

/* loaded from: classes.dex */
public class TestLogActivity extends Activity {

    /* renamed from: g, reason: collision with root package name */
    com.groboot.mdaemergency.enums.a f8052g;

    /* renamed from: h, reason: collision with root package name */
    e.a f8053h;

    /* renamed from: j, reason: collision with root package name */
    c6.l f8055j;

    /* renamed from: f, reason: collision with root package name */
    boolean f8051f = false;

    /* renamed from: i, reason: collision with root package name */
    String f8054i = "";

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: com.groboot.mdaemergency.ui.TestLogActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0119a implements d.f {

            /* renamed from: com.groboot.mdaemergency.ui.TestLogActivity$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0120a implements Runnable {

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f8058f;

                RunnableC0120a(String str) {
                    this.f8058f = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Token:\n");
                    sb2.append(this.f8058f);
                    TestLogActivity.this.f8055j.notifyDataSetChanged();
                }
            }

            C0119a() {
            }

            @Override // p5.d.f
            public void a(String str) {
                TestLogActivity.this.runOnUiThread(new RunnableC0120a(str));
            }
        }

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p5.d.i(TestLogActivity.this, new C0119a());
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestLogActivity testLogActivity = TestLogActivity.this;
            testLogActivity.h(testLogActivity.findViewById(R.id.ll_sendToken));
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestLogActivity.this.finish();
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestLogActivity.this.findViewById(R.id.rl_filter).setVisibility(TestLogActivity.this.f8054i.length() > 0 ? 0 : 8);
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnClickListener {

        /* loaded from: classes.dex */
        class a implements l0.i {
            a() {
            }

            @Override // w6.l0.i
            public void a() {
            }

            @Override // w6.l0.i
            public void b() {
                ((TextView) TestLogActivity.this.findViewById(R.id.tv_filter)).setText("");
                TestLogActivity testLogActivity = TestLogActivity.this;
                testLogActivity.f8054i = "";
                testLogActivity.d();
            }

            @Override // w6.l0.i
            public void c(String str, int i10) {
                g5.b.i(TestLogActivity.this).e("LogFilter", str);
                ((TextView) TestLogActivity.this.findViewById(R.id.tv_filter)).setText(str);
                TestLogActivity testLogActivity = TestLogActivity.this;
                testLogActivity.f8054i = ((TextView) testLogActivity.findViewById(R.id.tv_filter)).getText().toString();
                TestLogActivity.this.d();
            }
        }

        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l0.K0(TestLogActivity.this, "filter", "Clear", "Back", g5.e.d(), new a());
        }
    }

    /* loaded from: classes.dex */
    class f implements TextWatcher {
        f(TestLogActivity testLogActivity) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            com.groboot.mdaemergency.async.d.v().s0(((Object) editable) + "");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* loaded from: classes.dex */
    class g implements Runnable {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                TestLogActivity.this.f8053h = g5.e.a();
                TestLogActivity.this.d();
            }
        }

        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (TestLogActivity.this.f8051f) {
                d0.a(700L);
                e.a aVar = TestLogActivity.this.f8053h;
                if (aVar == null || !aVar.equals(g5.e.a())) {
                    TestLogActivity.this.runOnUiThread(new a());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class h implements AdapterView.OnItemLongClickListener {
        h() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            String charSequence = ((TextView) view.findViewById(R.id.tv_text)).getText().toString();
            if (charSequence.indexOf("ocation: ") <= -1) {
                return false;
            }
            String[] split = charSequence.substring(charSequence.indexOf("ocation: ") + 9).split(",");
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + split[0] + "," + split[1]));
            intent.addFlags(268435456);
            TestLogActivity.this.startActivity(intent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestLogActivity.this.f(l0.U0((String) view.getTag(), Integer.valueOf(d.v.MADA.ordinal())));
        }
    }

    /* loaded from: classes.dex */
    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestLogActivity.this.findViewById(R.id.ll_sendToken).setVisibility(0);
        }
    }

    /* loaded from: classes.dex */
    class k implements View.OnClickListener {

        /* loaded from: classes.dex */
        class a implements d.f {

            /* renamed from: com.groboot.mdaemergency.ui.TestLogActivity$k$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0121a implements Runnable {

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f8072f;

                RunnableC0121a(String str) {
                    this.f8072f = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    q5.a.e(((Object) ((EditText) TestLogActivity.this.findViewById(R.id.et_push_message)).getText()) + "", TestLogActivity.this.getString(R.string.google_push_notification_test), this.f8072f);
                }
            }

            a() {
            }

            @Override // p5.d.f
            public void a(String str) {
                TestLogActivity.this.runOnUiThread(new RunnableC0121a(str));
            }
        }

        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p5.d.i(TestLogActivity.this, new a());
        }
    }

    /* loaded from: classes.dex */
    class l implements View.OnClickListener {

        /* loaded from: classes.dex */
        class a implements d.f {

            /* renamed from: com.groboot.mdaemergency.ui.TestLogActivity$l$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0122a implements Runnable {

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f8076f;

                RunnableC0122a(String str) {
                    this.f8076f = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    q5.a.f(Arrays.asList("tzevet", "a4000", "a1", "go", "nonurgent", "code1"), ((Object) ((EditText) TestLogActivity.this.findViewById(R.id.et_push_message)).getText()) + "", TestLogActivity.this.getString(R.string.google_push_notification_test), this.f8076f);
                    TestLogActivity.this.findViewById(R.id.ll_sendToken).setVisibility(8);
                }
            }

            a() {
            }

            @Override // p5.d.f
            public void a(String str) {
                TestLogActivity.this.runOnUiThread(new RunnableC0122a(str));
            }
        }

        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p5.d.i(TestLogActivity.this, new a());
        }
    }

    /* loaded from: classes.dex */
    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestLogActivity.this.d();
        }
    }

    /* loaded from: classes.dex */
    class n implements View.OnClickListener {
        n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestLogActivity.this.d();
        }
    }

    /* loaded from: classes.dex */
    class o implements View.OnClickListener {
        o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestLogActivity.this.findViewById(R.id.rl_filter).setVisibility(0);
            TestLogActivity.this.findViewById(R.id.ll_server).setVisibility(8);
            TestLogActivity.this.findViewById(R.id.ll_log).setVisibility(8);
            TestLogActivity.this.findViewById(R.id.ll_sendToken).setVisibility(8);
            ((TextView) TestLogActivity.this.findViewById(R.id.tv_filter)).setText(TestLogActivity.this.f8054i);
        }
    }

    /* loaded from: classes.dex */
    class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestLogActivity testLogActivity = TestLogActivity.this;
            testLogActivity.h(testLogActivity.findViewById(R.id.ll_log));
        }
    }

    /* loaded from: classes.dex */
    class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TestLogActivity testLogActivity = TestLogActivity.this;
            testLogActivity.h(testLogActivity.findViewById(R.id.ll_server));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            this.f8055j = new c6.l(this, g5.e.b(this.f8054i));
            ((ListView) findViewById(R.id.lv_test_log)).setAdapter((ListAdapter) this.f8055j);
            ((ListView) findViewById(R.id.lv_test_log)).requestLayout();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(TextView textView, View view) {
        com.groboot.mdaemergency.enums.a aVar = this.f8052g;
        com.groboot.mdaemergency.enums.a aVar2 = com.groboot.mdaemergency.enums.a.MADA;
        com.groboot.mdaemergency.enums.a aVar3 = aVar == aVar2 ? com.groboot.mdaemergency.enums.a.CREW : aVar2;
        w6.m.c0(aVar3);
        textView.setText(aVar3 == aVar2 ? R.string.app_name : R.string.app_name_ih);
    }

    private View.OnClickListener g() {
        return new i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(View view) {
        view.setVisibility(view.getVisibility() == 0 ? 8 : 0);
    }

    public void f(int i10) {
        com.groboot.mdaemergency.async.d.v().r0(i10);
        ((EditText) findViewById(R.id.et_server)).setText(com.groboot.mdaemergency.async.d.v().K());
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8052g = w6.m.m();
        requestWindowFeature(1);
        setContentView(R.layout.test_log_activity);
        l0.C0(this);
        l0.E0(this);
        ((EditText) findViewById(R.id.et_server)).setText(com.groboot.mdaemergency.async.d.v().K());
        findViewById(R.id.btn_check_token).setOnClickListener(new a());
        findViewById(R.id.btn_send_token).setOnClickListener(new j());
        findViewById(R.id.btn_send_token2).setOnClickListener(new k());
        findViewById(R.id.btn_send_ptt_sound).setOnClickListener(new l());
        findViewById(R.id.btn_test_log_clear).setOnClickListener(new m());
        findViewById(R.id.btn_test_log_refresh).setOnClickListener(new n());
        findViewById(R.id.btn_filter).setOnClickListener(new o());
        findViewById(R.id.btn_log).setOnClickListener(new p());
        findViewById(R.id.btn_server).setOnClickListener(new q());
        findViewById(R.id.btn_send_token).setOnClickListener(new b());
        findViewById(R.id.tv_close).setOnClickListener(new c());
        findViewById(R.id.btn_server_1).setOnClickListener(g());
        findViewById(R.id.btn_server_2).setOnClickListener(g());
        findViewById(R.id.btn_server_3).setOnClickListener(g());
        findViewById(R.id.btn_server_4).setOnClickListener(g());
        findViewById(R.id.btn_server_5).setOnClickListener(g());
        findViewById(R.id.btn_server_6).setOnClickListener(g());
        findViewById(R.id.rl_filter).setVisibility(this.f8054i.length() > 0 ? 0 : 8);
        findViewById(R.id.btn_filter_ok).setOnClickListener(new d());
        ((TextView) findViewById(R.id.tv_filter)).setText(g5.b.i(this).a("LogFilter", ""));
        findViewById(R.id.tv_filter).setOnClickListener(new e());
        ((EditText) findViewById(R.id.et_server)).addTextChangedListener(new f(this));
        findViewById(R.id.ll_server).setVisibility(8);
        findViewById(R.id.ll_log).setVisibility(8);
        findViewById(R.id.ll_sendToken).setVisibility(8);
        new Thread(new g()).start();
        ((ListView) findViewById(R.id.lv_test_log)).setOnItemLongClickListener(new h());
        final TextView textView = (TextView) findViewById(R.id.btn_app_type);
        textView.setText(this.f8052g == com.groboot.mdaemergency.enums.a.MADA ? R.string.app_name : R.string.app_name_ih);
        textView.setOnClickListener(new View.OnClickListener() { // from class: a6.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TestLogActivity.this.e(textView, view);
            }
        });
        d();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f8051f = false;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f8051f = true;
    }
}
