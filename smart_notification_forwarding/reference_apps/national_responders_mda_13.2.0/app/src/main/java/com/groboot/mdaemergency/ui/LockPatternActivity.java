package com.groboot.mdaemergency.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.andrognito.patternlockview.PatternLockView;
import com.groboot.mdaemergency.MdaEmergencyApplication;
import com.groboot.mdaemergency.async.FloatViewService;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.enums.a;
import com.groboot.mdaemergency.locations.SchedulingLocationsService;
import com.groboot.mdaemergency.locations.geofencing.GeofenceService;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.services.PttFloatDialogViewService;
import il.org.mda.health.R;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import t6.e;
import w6.d0;
import w6.g0;
import w6.l0;
import w6.m;
import w6.n;

/* loaded from: classes.dex */
public class LockPatternActivity extends Activity {
    public static final String A;
    public static final String B;
    public static final String C;
    public static final String D;
    static boolean E;
    public static Date F;

    /* renamed from: y, reason: collision with root package name */
    public static final String f8009y;

    /* renamed from: z, reason: collision with root package name */
    public static final String f8010z;

    /* renamed from: f, reason: collision with root package name */
    private int f8011f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8013h;

    /* renamed from: i, reason: collision with root package name */
    private t6.a f8014i;

    /* renamed from: j, reason: collision with root package name */
    private l f8015j;

    /* renamed from: k, reason: collision with root package name */
    private Intent f8016k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f8017l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f8018m;

    /* renamed from: n, reason: collision with root package name */
    LinearLayout f8019n;

    /* renamed from: o, reason: collision with root package name */
    LinearLayout f8020o;

    /* renamed from: p, reason: collision with root package name */
    private com.groboot.mdaemergency.async.d f8021p;

    /* renamed from: q, reason: collision with root package name */
    private Context f8022q;

    /* renamed from: r, reason: collision with root package name */
    private PatternLockView f8023r;

    /* renamed from: g, reason: collision with root package name */
    private int f8012g = 0;

    /* renamed from: s, reason: collision with root package name */
    String f8024s = "123";

    /* renamed from: t, reason: collision with root package name */
    String f8025t = "";

    /* renamed from: u, reason: collision with root package name */
    int f8026u = 0;

    /* renamed from: v, reason: collision with root package name */
    private View.OnClickListener f8027v = new e();

    /* renamed from: w, reason: collision with root package name */
    private v0.a f8028w = new i();

    /* renamed from: x, reason: collision with root package name */
    private final Runnable f8029x = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends t6.c<Void, Void, char[]> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f8030e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, boolean z10, List list) {
            super(context, z10);
            this.f8030e = list;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public char[] doInBackground(Void... voidArr) {
            return LockPatternActivity.this.f8014i != null ? LockPatternActivity.this.f8014i.a(LockPatternActivity.this, this.f8030e) : com.groboot.mdaemergency.ui.lockpattern.widget.a.a(this.f8030e).toCharArray();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // t6.c, android.os.AsyncTask
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(char[] cArr) {
            super.onPostExecute(cArr);
            LockPatternActivity.this.getIntent().putExtra("com.groboot.mda.extraparern", cArr);
            LockPatternActivity.this.f8023r.l();
            LockPatternActivity.this.f8020o.setVisibility(0);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LockPatternActivity.this.f8023r.l();
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnLongClickListener {
        c() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            LockPatternActivity lockPatternActivity = LockPatternActivity.this;
            lockPatternActivity.f8025t = "";
            lockPatternActivity.f8026u = 0;
            return true;
        }
    }

    /* loaded from: classes.dex */
    class d implements View.OnClickListener {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: com.groboot.mdaemergency.ui.LockPatternActivity$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class RunnableC0116a implements Runnable {
                RunnableC0116a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    LockPatternActivity.this.startActivity(new Intent(LockPatternActivity.this.getApplicationContext(), (Class<?>) TestLogActivity.class));
                }
            }

            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d0.a(1000L);
                if (LockPatternActivity.this.f8026u > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    LockPatternActivity lockPatternActivity = LockPatternActivity.this;
                    sb2.append(lockPatternActivity.f8025t);
                    sb2.append("");
                    sb2.append(LockPatternActivity.this.f8026u);
                    lockPatternActivity.f8025t = sb2.toString();
                    LockPatternActivity.this.f8026u = 0;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("logUserCode:");
                sb3.append(LockPatternActivity.this.f8025t);
                sb3.append(" logUserCodeCounter:");
                sb3.append(LockPatternActivity.this.f8026u);
                LockPatternActivity lockPatternActivity2 = LockPatternActivity.this;
                if (lockPatternActivity2.f8025t.equals(lockPatternActivity2.f8024s)) {
                    LockPatternActivity.this.runOnUiThread(new RunnableC0116a());
                }
            }
        }

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.q()) {
                LockPatternActivity.this.startActivity(new Intent(LockPatternActivity.this.getApplicationContext(), (Class<?>) TestLogActivity.class));
                return;
            }
            if (!l0.l0(LockPatternActivity.this.f8025t)) {
                LockPatternActivity lockPatternActivity = LockPatternActivity.this;
                if (!lockPatternActivity.f8025t.equals(lockPatternActivity.f8024s)) {
                    int i10 = 1;
                    while (true) {
                        if (i10 > LockPatternActivity.this.f8024s.length() || i10 > LockPatternActivity.this.f8025t.length()) {
                            break;
                        }
                        LockPatternActivity lockPatternActivity2 = LockPatternActivity.this;
                        if (!lockPatternActivity2.f8025t.startsWith(lockPatternActivity2.f8024s.substring(0, i10))) {
                            LockPatternActivity.this.f8025t = "";
                            break;
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("logUserCode:");
                        sb2.append(LockPatternActivity.this.f8025t);
                        sb2.append(" logUserCodeCounter:");
                        sb2.append(LockPatternActivity.this.f8026u);
                        i10++;
                    }
                } else {
                    LockPatternActivity.this.startActivity(new Intent(LockPatternActivity.this.getApplicationContext(), (Class<?>) TestLogActivity.class));
                    return;
                }
            }
            LockPatternActivity lockPatternActivity3 = LockPatternActivity.this;
            int i11 = lockPatternActivity3.f8026u + 1;
            lockPatternActivity3.f8026u = i11;
            if (i11 == 1) {
                new Thread(new a()).start();
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("logUserCode:");
            sb3.append(LockPatternActivity.this.f8025t);
            sb3.append(" logUserCodeCounter:");
            sb3.append(LockPatternActivity.this.f8026u);
        }
    }

    /* loaded from: classes.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LockPatternActivity.this.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements DialogInterface.OnClickListener {

        /* loaded from: classes.dex */
        class a implements b.InterfaceC0098b {

            /* renamed from: com.groboot.mdaemergency.ui.LockPatternActivity$f$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0117a implements p.b0 {

                /* renamed from: com.groboot.mdaemergency.ui.LockPatternActivity$f$a$a$a, reason: collision with other inner class name */
                /* loaded from: classes.dex */
                class C0118a extends u7.m {
                    C0118a(C0117a c0117a) {
                    }

                    @Override // u7.a
                    public void a(int i10, String str) {
                    }

                    @Override // u7.a
                    public void c() {
                    }

                    @Override // u7.m
                    public void d() {
                    }
                }

                C0117a(a aVar) {
                }

                @Override // com.groboot.mdaemergency.ptt.p.b0
                public void a() {
                }

                @Override // com.groboot.mdaemergency.ptt.p.b0
                public void b(p pVar) {
                    pVar.z0(new C0118a(this));
                }
            }

            a() {
            }

            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public void a(b.a aVar) {
                a6.h.c();
                if (aVar == null) {
                    return;
                }
                if (!aVar.f7614b) {
                    a6.h.g(LockPatternActivity.this, LockPatternActivity.this.getString(R.string.logout_not_success) + "\n" + aVar.f7617e);
                    return;
                }
                s5.d.j().D();
                m.c();
                LockPatternActivity lockPatternActivity = LockPatternActivity.this;
                LockPatternActivity.this.stopService(new Intent(LockPatternActivity.this, (Class<?>) GeofenceService.class));
                r5.a.a().g(LockPatternActivity.this);
                SchedulingLocationsService.b(LockPatternActivity.this);
                a6.h.n(LockPatternActivity.this);
                p.d0(LockPatternActivity.this.getApplicationContext(), new C0117a(this));
                LockPatternActivity.this.finish();
            }
        }

        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            a6.h.m(LockPatternActivity.this);
            LockPatternActivity.this.f8021p.S(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements e8.c<y0.b> {
        g(LockPatternActivity lockPatternActivity) {
        }

        @Override // e8.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(y0.b bVar) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Complete: ");
            sb2.append(bVar.a().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements e8.c<y0.c> {
        h() {
        }

        @Override // e8.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(y0.c cVar) {
            StringBuilder sb2;
            String str;
            if (cVar.b() == 0) {
                return;
            }
            if (cVar.b() == 1) {
                sb2 = new StringBuilder();
                str = "Pattern progress: ";
            } else if (cVar.b() != 2) {
                cVar.b();
                return;
            } else {
                sb2 = new StringBuilder();
                str = "Pattern complete: ";
            }
            sb2.append(str);
            sb2.append(w0.a.a(LockPatternActivity.this.f8023r, cVar.a()));
        }
    }

    /* loaded from: classes.dex */
    class i implements v0.a {
        i() {
        }

        @Override // v0.a
        public void a(List<PatternLockView.f> list) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Pattern complete: ");
            sb2.append(w0.a.a(LockPatternActivity.this.f8023r, list));
            if (LockPatternActivity.f8009y.equals(LockPatternActivity.this.getIntent().getAction())) {
                LockPatternActivity.this.s(list);
            } else if (LockPatternActivity.f8010z.equals(LockPatternActivity.this.getIntent().getAction())) {
                LockPatternActivity.this.t(list);
            }
        }

        @Override // v0.a
        public void b(List<PatternLockView.f> list) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Pattern progress: ");
            sb2.append(w0.a.a(LockPatternActivity.this.f8023r, list));
        }

        @Override // v0.a
        public void c() {
        }

        @Override // v0.a
        public void d() {
            LockPatternActivity.this.f8023r.removeCallbacks(LockPatternActivity.this.f8029x);
            LockPatternActivity.this.f8023r.setViewMode(0);
            if (!LockPatternActivity.f8009y.equals(LockPatternActivity.this.getIntent().getAction())) {
                LockPatternActivity.f8010z.equals(LockPatternActivity.this.getIntent().getAction());
            } else if (LockPatternActivity.this.f8015j == l.CONTINUE) {
                LockPatternActivity.this.getIntent().removeExtra("com.groboot.mda.extraparern");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends t6.c<Void, Void, Boolean> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f8042e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(Context context, boolean z10, List list) {
            super(context, z10);
            this.f8042e = list;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            if (LockPatternActivity.f8010z.equals(LockPatternActivity.this.getIntent().getAction())) {
                char[] charArrayExtra = LockPatternActivity.this.getIntent().getCharArrayExtra("com.groboot.mda.extraparern");
                if (charArrayExtra == null) {
                    charArrayExtra = e.b.b(LockPatternActivity.this);
                }
                if (charArrayExtra != null) {
                    return Boolean.valueOf(LockPatternActivity.this.f8014i != null ? this.f8042e.equals(LockPatternActivity.this.f8014i.b(LockPatternActivity.this, charArrayExtra)) : Arrays.equals(charArrayExtra, com.groboot.mdaemergency.ui.lockpattern.widget.a.a(this.f8042e).toCharArray()));
                }
            }
            return Boolean.FALSE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // t6.c, android.os.AsyncTask
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                LockPatternActivity.this.w(null);
                return;
            }
            LockPatternActivity.q(LockPatternActivity.this);
            LockPatternActivity.this.f8016k.putExtra(LockPatternActivity.A, LockPatternActivity.this.f8012g);
            if (LockPatternActivity.this.f8012g >= LockPatternActivity.this.f8011f) {
                LockPatternActivity.this.v(2);
            } else {
                LockPatternActivity.this.f8023r.setViewMode(2);
                LockPatternActivity.this.f8023r.postDelayed(LockPatternActivity.this.f8029x, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends t6.c<Void, Void, Boolean> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f8044e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(Context context, boolean z10, List list) {
            super(context, z10);
            this.f8044e = list;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            boolean equals;
            if (LockPatternActivity.this.f8014i != null) {
                List list = this.f8044e;
                t6.a aVar = LockPatternActivity.this.f8014i;
                LockPatternActivity lockPatternActivity = LockPatternActivity.this;
                equals = list.equals(aVar.b(lockPatternActivity, lockPatternActivity.getIntent().getCharArrayExtra("com.groboot.mda.extraparern")));
            } else {
                equals = Arrays.equals(LockPatternActivity.this.getIntent().getCharArrayExtra("com.groboot.mda.extraparern"), com.groboot.mdaemergency.ui.lockpattern.widget.a.a(this.f8044e).toCharArray());
            }
            return Boolean.valueOf(equals);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // t6.c, android.os.AsyncTask
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                char[] charArrayExtra = LockPatternActivity.this.getIntent().getCharArrayExtra("com.groboot.mda.extraparern");
                if (LockPatternActivity.this.getIntent().getAction().equals(LockPatternActivity.f8009y) && LockPatternActivity.this.f8013h) {
                    e.b.e(LockPatternActivity.this, charArrayExtra);
                }
                LockPatternActivity.this.w(charArrayExtra);
                return;
            }
            LockPatternActivity.this.f8023r.setViewMode(2);
            LockPatternActivity.this.f8023r.postDelayed(LockPatternActivity.this.f8029x, 1000L);
            Toast.makeText(LockPatternActivity.this.f8022q, R.string.passwords_not_same, 0).show();
            LockPatternActivity.this.y();
            LockPatternActivity.this.getIntent().removeExtra("com.groboot.mda.extraparern");
        }
    }

    /* loaded from: classes.dex */
    private enum l {
        CONTINUE,
        FORGOT_PATTERN,
        DONE
    }

    static {
        String name = LockPatternActivity.class.getName();
        f8009y = name + ".create_pattern";
        f8010z = name + ".compare_pattern";
        A = name + ".retry_count";
        B = name + ".result_receiver";
        C = name + ".pending_intent_ok";
        D = name + ".pending_intent_cancelled";
        StringBuilder sb2 = new StringBuilder();
        sb2.append(name);
        sb2.append(".pending_intent_forgot_pattern");
        F = l0.y(2016, 4, 3);
    }

    private void A() {
        Bundle bundle;
        try {
            bundle = getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            bundle = null;
        }
        this.f8011f = (bundle == null || !bundle.containsKey("maxRetries")) ? e.a.a(this) : e.a.b(this, bundle.getInt("maxRetries"));
        this.f8013h = (bundle == null || !bundle.containsKey("autoSavePattern")) ? e.b.c(this) : bundle.getBoolean("autoSavePattern");
        char[] a10 = (bundle == null || !bundle.containsKey("encrypterClass")) ? e.b.a(this) : bundle.getString("encrypterClass").toCharArray();
        if (a10 != null) {
            this.f8014i = (t6.a) Class.forName(new String(a10), false, getClassLoader()).newInstance();
        }
    }

    public static void B() {
        F = new Date();
    }

    public static void C(Activity activity, boolean z10) {
        if (E) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("TimeSpan.fromNow(lastFinishTime).totalSeconds: ");
        sb2.append(g0.a(F).f15161e);
        if ((m.K() || z10) && g0.a(F).f15161e <= 20.0d) {
            return;
        }
        char[] b10 = e.b.b(activity);
        Intent intent = new Intent(f8010z, null, activity, LockPatternActivity.class);
        intent.putExtra("com.groboot.mda.extraparern", b10);
        intent.setFlags(536870912);
        if (com.groboot.mdaemergency.a.f7539a) {
            activity.startActivityForResult(intent, 2);
            E = true;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("lockPatternActivityShow: ");
            sb3.append(E);
        }
    }

    static /* synthetic */ int q(LockPatternActivity lockPatternActivity) {
        int i10 = lockPatternActivity.f8012g;
        lockPatternActivity.f8012g = i10 + 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        a6.h.e(this, R.string.logout_alert_text, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(List<PatternLockView.f> list) {
        if (list.size() < 4 || list.size() > 8) {
            this.f8023r.setViewMode(2);
            this.f8023r.postDelayed(this.f8029x, 1000L);
        } else if (getIntent().hasExtra("com.groboot.mda.extraparern")) {
            new k(this, false, list).execute(new Void[0]);
        } else {
            new a(this, false, list).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(List<PatternLockView.f> list) {
        if (list == null) {
            return;
        }
        new j(this, false, list).execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(int i10) {
        String str = f8010z;
        if (str.equals(getIntent().getAction())) {
            this.f8016k.putExtra(A, this.f8012g);
        }
        setResult(i10, this.f8016k);
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra(B);
        if (resultReceiver != null) {
            Bundle bundle = null;
            if (str.equals(getIntent().getAction())) {
                bundle = new Bundle();
                bundle.putInt(A, this.f8012g);
            }
            resultReceiver.send(i10, bundle);
        }
        PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra(D);
        if (pendingIntent != null) {
            try {
                pendingIntent.send(this, i10, this.f8016k);
            } catch (Throwable unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error sending PendingIntent: ");
                sb2.append(pendingIntent);
            }
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(char[] cArr) {
        String str = f8009y;
        if (str.equals(getIntent().getAction())) {
            this.f8016k.putExtra("com.groboot.mda.extraparern", cArr);
        } else {
            this.f8016k.putExtra(A, this.f8012g + 1);
        }
        setResult(-1, this.f8016k);
        ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra(B);
        if (resultReceiver != null) {
            Bundle bundle = new Bundle();
            if (str.equals(getIntent().getAction())) {
                bundle.putCharArray("com.groboot.mda.extraparern", cArr);
            } else {
                bundle.putInt(A, this.f8012g + 1);
            }
            resultReceiver.send(-1, bundle);
        }
        PendingIntent pendingIntent = (PendingIntent) getIntent().getParcelableExtra(C);
        if (pendingIntent != null) {
            try {
                pendingIntent.send(this, -1, this.f8016k);
            } catch (Throwable unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error sending PendingIntent: ");
                sb2.append(pendingIntent);
            }
        }
        u();
    }

    private void x() {
        this.f8019n.setVisibility(8);
        this.f8017l.setText(R.string.enter_password_title);
        this.f8018m.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        this.f8019n.setVisibility(0);
        this.f8017l.setText(R.string.new_password_title);
        this.f8020o.setVisibility(4);
    }

    private void z() {
        PatternLockView patternLockView = (PatternLockView) findViewById(R.id.patter_lock_view);
        this.f8023r = patternLockView;
        patternLockView.setDotCount(3);
        this.f8023r.setDotNormalSize((int) w0.b.b(this, R.dimen.pattern_lock_dot_size));
        this.f8023r.setDotSelectedSize((int) w0.b.b(this, R.dimen.pattern_lock_dot_selected_size));
        this.f8023r.setPathWidth((int) w0.b.b(this, R.dimen.pattern_lock_path_width));
        this.f8023r.setAspectRatioEnabled(true);
        this.f8023r.setAspectRatio(2);
        this.f8023r.setViewMode(0);
        this.f8023r.setDotAnimationDuration(150);
        this.f8023r.setPathEndAnimationDuration(100);
        this.f8023r.setInStealthMode(false);
        this.f8023r.setTactileFeedbackEnabled(true);
        this.f8023r.setInputEnabled(true);
        this.f8023r.h(this.f8028w);
        a.d colors = m.m().getColors();
        this.f8023r.setCorrectStateColor(w0.b.a(this, colors.a()));
        this.f8023r.setNormalStateColor(w0.b.a(this, colors.b()));
        this.f8023r.setWrongStateColor(w0.b.a(this, colors.c()));
        PatternLockView patternLockView2 = this.f8023r;
        Integer valueOf = patternLockView2 != null ? Integer.valueOf(patternLockView2.getPatternViewMode()) : null;
        PatternLockView patternLockView3 = this.f8023r;
        List<PatternLockView.f> pattern = patternLockView3 != null ? patternLockView3.getPattern() : null;
        t6.f.a(getWindow());
        try {
            Settings.System.getInt(getContentResolver(), "haptic_feedback_enabled", 0);
        } catch (Throwable unused) {
        }
        if (pattern != null && valueOf != null) {
            this.f8023r.K(valueOf.intValue(), pattern);
        }
        x0.a.b(this.f8023r).a(new g(this));
        x0.a.a(this.f8023r).a(new h());
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(n.c(context));
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        E = true;
        l0.C0(this);
        this.f8022q = this;
        requestWindowFeature(1);
        setContentView(R.layout.lock_pattern_activity);
        A();
        Intent intent = new Intent();
        this.f8016k = intent;
        setResult(0, intent);
        z();
        l0.E0(this);
        ((ImageView) findViewById(R.id.title_image)).setColorFilter(l0.u(getApplicationContext(), R.color.mada_red_dark));
        this.f8017l = (TextView) findViewById(R.id.title);
        TextView textView = (TextView) findViewById(R.id.logout);
        this.f8018m = textView;
        textView.setOnClickListener(this.f8027v);
        this.f8020o = (LinearLayout) findViewById(R.id.password_saved_layout);
        this.f8019n = (LinearLayout) findViewById(R.id.new_password_layout);
        if (f8009y.equals(getIntent().getAction())) {
            y();
        } else if (f8010z.equals(getIntent().getAction())) {
            x();
        }
        String b10 = a6.h.b(getApplicationContext());
        if (b10.length() > 0) {
            String id = m.k() != null ? m.k().getID() : "";
            TextView textView2 = (TextView) findViewById(R.id.top_title);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ver: ");
            sb2.append(b10);
            if (m.q()) {
                str = " userID:" + id;
            } else {
                str = "";
            }
            sb2.append(str);
            sb2.append(l0.l0(this.f8025t) ? "" : " *");
            textView2.setText(sb2.toString());
        }
        findViewById(R.id.top_title).setOnLongClickListener(new c());
        findViewById(R.id.top_title).setOnClickListener(new d());
        this.f8021p = com.groboot.mdaemergency.async.d.v();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4 && f8010z.equals(getIntent().getAction())) {
            v(0);
            return true;
        }
        if (!m.s() || !m.r() || p.c0() == null || !p.c0().A0(getApplicationContext(), i10, keyEvent.getAction())) {
            return super.onKeyDown(i10, keyEvent);
        }
        w(null);
        return true;
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        E = false;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("lockPatternActivityShow: ");
        sb2.append(E);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        PttFloatDialogViewService.l(getApplicationContext());
        FloatViewService.l(getApplicationContext());
        if (MdaEmergencyApplication.f7533j) {
            finish();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 11 && motionEvent.getAction() == 0 && getWindow().peekDecorView() != null) {
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            int scaledWindowTouchSlop = ViewConfiguration.get(this).getScaledWindowTouchSlop();
            View decorView = getWindow().getDecorView();
            int i10 = -scaledWindowTouchSlop;
            if (x10 < i10 || y10 < i10 || x10 > decorView.getWidth() + scaledWindowTouchSlop || y10 > decorView.getHeight() + scaledWindowTouchSlop) {
                v(0);
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void u() {
        B();
        finish();
    }
}
