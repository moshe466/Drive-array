package x6;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.j;
import il.org.mda.health.R;
import w6.d0;
import w6.m;

/* loaded from: classes.dex */
public class g extends androidx.fragment.app.e {
    public static boolean B0;
    static g C0;

    /* renamed from: u0, reason: collision with root package name */
    d f15464u0;

    /* renamed from: v0, reason: collision with root package name */
    x6.c f15465v0;

    /* renamed from: w0, reason: collision with root package name */
    x6.d f15466w0;

    /* renamed from: x0, reason: collision with root package name */
    String f15467x0;

    /* renamed from: y0, reason: collision with root package name */
    e f15468y0;

    /* renamed from: z0, reason: collision with root package name */
    f f15469z0 = f.onClick;
    int A0 = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements x6.d {

        /* renamed from: x6.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0329a implements Runnable {
            RunnableC0329a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.f15464u0.f15478i.setText("מקליט\n" + g.this.f15465v0.b());
            }
        }

        a() {
        }

        @Override // x6.d
        public void a(int i10) {
            g.this.t().runOnUiThread(new RunnableC0329a());
            x6.d dVar = g.this.f15466w0;
            if (dVar != null) {
                dVar.a(i10);
            }
        }

        @Override // x6.d
        public void b() {
            g.this.t2();
            x6.d dVar = g.this.f15466w0;
            if (dVar != null) {
                dVar.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f15464u0.c();
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
                g.this.f15464u0.f15477h.setText("");
            }
        }

        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                g gVar = g.this;
                int i10 = gVar.A0;
                if (i10 <= -1) {
                    return;
                }
                gVar.A0 = i10 - 1;
                d0.a(1000L);
                if (!g.B0) {
                    return;
                }
                if (g.this.A0 < 0) {
                    new Handler(Looper.getMainLooper()).post(new a());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener, View.OnTouchListener {

        /* renamed from: f, reason: collision with root package name */
        View f15475f;

        /* renamed from: g, reason: collision with root package name */
        TextView f15476g;

        /* renamed from: h, reason: collision with root package name */
        TextView f15477h;

        /* renamed from: i, reason: collision with root package name */
        TextView f15478i;

        /* renamed from: j, reason: collision with root package name */
        ImageView f15479j;

        /* renamed from: k, reason: collision with root package name */
        View f15480k;

        /* renamed from: l, reason: collision with root package name */
        ImageView f15481l;

        /* renamed from: m, reason: collision with root package name */
        View f15482m;

        /* renamed from: n, reason: collision with root package name */
        View f15483n;

        /* renamed from: o, reason: collision with root package name */
        ProgressBar f15484o;

        /* renamed from: p, reason: collision with root package name */
        View f15485p;

        /* renamed from: q, reason: collision with root package name */
        EditText f15486q;

        /* renamed from: r, reason: collision with root package name */
        RelativeLayout f15487r;

        /* renamed from: s, reason: collision with root package name */
        boolean f15488s = false;

        public d(View view) {
            this.f15475f = view;
            this.f15476g = (TextView) view.findViewById(R.id.tv_caption);
            this.f15477h = (TextView) view.findViewById(R.id.tv_message);
            this.f15478i = (TextView) view.findViewById(R.id.tv_status);
            this.f15482m = view.findViewById(R.id.iv_upload);
            this.f15480k = view.findViewById(R.id.iv_pause);
            this.f15479j = (ImageView) view.findViewById(R.id.iv_close);
            this.f15481l = (ImageView) view.findViewById(R.id.iv_play);
            this.f15483n = (ImageView) view.findViewById(R.id.iv_permission);
            this.f15484o = (ProgressBar) view.findViewById(R.id.pb_wait);
            this.f15485p = view.findViewById(R.id.ll_main);
            this.f15479j.setOnClickListener(this);
            if (g.this.f15469z0 == f.onTouch) {
                this.f15481l.setOnTouchListener(this);
            } else {
                this.f15481l.setOnClickListener(this);
                this.f15480k.setOnClickListener(this);
            }
            this.f15486q = (EditText) view.findViewById(R.id.et_result);
            this.f15487r = (RelativeLayout) view.findViewById(R.id.ll_result);
            this.f15482m.setOnClickListener(this);
            this.f15483n.setOnClickListener(this);
            this.f15487r.setVisibility(8);
            view.findViewById(R.id.iv_record_again).setOnClickListener(this);
            view.findViewById(R.id.tv_ok).setOnClickListener(this);
            view.findViewById(R.id.tv_cancel).setOnClickListener(this);
        }

        private void a() {
            g.this.A0 = -1;
            b("");
        }

        public void b(String str) {
            this.f15477h.setText(str);
            g.this.n2();
        }

        public void c() {
            View view;
            Resources resources;
            int i10;
            this.f15476g.setText(g.this.f15467x0);
            this.f15482m.setVisibility(8);
            this.f15483n.setVisibility(8);
            this.f15481l.setVisibility(8);
            this.f15480k.setVisibility(8);
            this.f15484o.setVisibility(8);
            if (g.this.p2()) {
                this.f15483n.setVisibility(0);
                this.f15478i.setText("חסרות הרשאות מערכת!\nיש ללחוץ לשינוי ההרשאות או X לביטול הפעולה");
                view = this.f15485p;
                resources = g.this.A().getResources();
                i10 = R.color.ptt_play_gray;
            } else if (g.this.f15465v0.e() == x6.e.FILE_RECORDING) {
                this.f15480k.setVisibility(0);
                this.f15478i.setText("מקליט\n" + g.this.f15465v0.b());
                view = this.f15485p;
                resources = g.this.A().getResources();
                i10 = R.color.ptt_play_red;
            } else if (g.this.f15465v0.e() == x6.e.FILE_UPLOADING) {
                this.f15482m.setVisibility(0);
                this.f15482m.setEnabled(false);
                this.f15484o.setVisibility(0);
                this.f15478i.setText(R.string.uploading_file);
                view = this.f15485p;
                resources = g.this.A().getResources();
                i10 = R.color.ptt_play_yellow;
            } else if (g.this.f15465v0.c() == x6.f.Exist) {
                this.f15482m.setVisibility(0);
                this.f15482m.setEnabled(true);
                this.f15478i.setText(R.string.upload);
                view = this.f15485p;
                resources = g.this.A().getResources();
                i10 = R.color.ptt_play_blue;
            } else {
                this.f15481l.setVisibility(0);
                this.f15478i.setText(R.string.start_recording);
                view = this.f15485p;
                resources = g.this.A().getResources();
                i10 = R.color.ptt_play_green;
            }
            view.setBackgroundColor(resources.getColor(i10));
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.iv_close /* 2131296743 */:
                    g.this.W1();
                    return;
                case R.id.iv_pause /* 2131296751 */:
                    g.this.f15465v0.l();
                    g gVar = g.this;
                    x6.c cVar = gVar.f15465v0;
                    if (cVar.f15461f < 4) {
                        gVar.f15464u0.b("הקלטה קצרה מידי");
                        g.this.o2();
                    } else {
                        cVar.o();
                    }
                    c();
                    return;
                case R.id.iv_permission /* 2131296752 */:
                    g.this.m2();
                    return;
                case R.id.iv_play /* 2131296753 */:
                    g.this.f15465v0.f();
                    c();
                    return;
                case R.id.iv_record_again /* 2131296754 */:
                    this.f15487r.setVisibility(8);
                    onClick(this.f15481l);
                    return;
                case R.id.iv_upload /* 2131296766 */:
                    g.this.f15465v0.o();
                    g.this.f15464u0.c();
                    return;
                case R.id.tv_cancel /* 2131297261 */:
                    g.this.f15468y0.a();
                    g.this.W1();
                    return;
                case R.id.tv_ok /* 2131297298 */:
                    g.this.f15468y0.b(this.f15486q.getText());
                    g.this.W1();
                    return;
                case R.id.v_v /* 2131297418 */:
                    if (m.q()) {
                        this.f15475f.findViewById(R.id.ll_log).setVisibility(this.f15475f.findViewById(R.id.ll_log).getVisibility() == 8 ? 0 : 8);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("action:");
            sb2.append(motionEvent.getAction());
            if (view.getId() == R.id.iv_play) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        this.f15488s = false;
                    } else {
                        g.this.f15465v0.l();
                        this.f15488s = false;
                        g gVar = g.this;
                        x6.c cVar = gVar.f15465v0;
                        if (cVar.f15461f < 3) {
                            gVar.f15464u0.b("הקלטה קצרה מידי");
                            g.this.o2();
                        } else {
                            cVar.o();
                        }
                        g.this.t2();
                    }
                } else if (!this.f15488s) {
                    this.f15488s = true;
                    g.this.f15465v0.f();
                    g.this.f15464u0.a();
                    g.this.t2();
                }
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();

        void b(Editable editable);
    }

    /* loaded from: classes.dex */
    enum f {
        onTouch,
        onClick
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2() {
        int i10 = this.A0;
        this.A0 = 4;
        if (i10 > -1) {
            return;
        }
        new Thread(new c()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o2() {
        x6.c a10 = x6.c.a();
        this.f15465v0 = a10;
        a10.h(u2());
    }

    private void q2(String str) {
        this.f15467x0 = str;
    }

    private void r2(e eVar) {
        this.f15468y0 = eVar;
    }

    public static void s2(j jVar, e eVar, String str) {
        g gVar = C0;
        if (gVar == null) {
            gVar = new g();
        }
        gVar.r2(eVar);
        gVar.q2(str);
        if (B0) {
            return;
        }
        gVar.i2(jVar.d0(), "PTTDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2() {
        if (this.f15464u0 == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new b());
    }

    private x6.d u2() {
        return new a();
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.voice_record_dialog, viewGroup, false);
        f2(false);
        this.f15464u0 = new d(inflate);
        Z1().getWindow().requestFeature(1);
        o2();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void R0() {
        this.f15465v0.h(null);
        this.f15465v0.l();
        super.R0();
        C0 = null;
        B0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void V0(int i10, String[] strArr, int[] iArr) {
        super.V0(i10, strArr, iArr);
        t2();
    }

    @Override // androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        C0 = this;
        B0 = true;
        this.A0 = -1;
        o2();
        this.f15464u0.c();
        this.f15464u0.f15477h.setText("");
    }

    void m2() {
        String[] strArr = {"android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        if (androidx.core.content.a.a(A(), "android.permission.RECORD_AUDIO") == 0) {
            strArr = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        }
        if (androidx.core.content.a.a(A(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            strArr = new String[]{"android.permission.RECORD_AUDIO"};
        }
        androidx.core.app.b.n(t(), strArr, 12212);
    }

    boolean p2() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return (androidx.core.content.a.a(A(), "android.permission.RECORD_AUDIO") == 0 && androidx.core.content.a.a(A(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && androidx.core.content.a.a(A(), "android.permission.READ_EXTERNAL_STORAGE") == 0) ? false : true;
    }
}
