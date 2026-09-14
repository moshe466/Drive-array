package com.groboot.mdaemergency.ptt;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ptt.s;
import g5.e;
import il.org.mda.health.R;
import w6.d0;
import w6.g;
import w6.l0;
import x6.h;

/* loaded from: classes.dex */
public class m implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: f, reason: collision with root package name */
    private x6.h f7866f;

    /* renamed from: g, reason: collision with root package name */
    f f7867g;

    /* renamed from: h, reason: collision with root package name */
    Context f7868h;

    /* renamed from: i, reason: collision with root package name */
    boolean f7869i;

    /* renamed from: j, reason: collision with root package name */
    com.groboot.mdaemergency.ptt.a f7870j;

    /* renamed from: k, reason: collision with root package name */
    p f7871k;

    /* renamed from: l, reason: collision with root package name */
    s f7872l;

    /* renamed from: m, reason: collision with root package name */
    public View f7873m;

    /* renamed from: n, reason: collision with root package name */
    TextView f7874n;

    /* renamed from: o, reason: collision with root package name */
    TextView f7875o;

    /* renamed from: p, reason: collision with root package name */
    TextView f7876p;

    /* renamed from: q, reason: collision with root package name */
    TextView f7877q;

    /* renamed from: r, reason: collision with root package name */
    ImageView f7878r;

    /* renamed from: s, reason: collision with root package name */
    ProgressBar f7879s;

    /* renamed from: t, reason: collision with root package name */
    View f7880t;

    /* renamed from: u, reason: collision with root package name */
    View.OnClickListener f7881u;

    /* renamed from: v, reason: collision with root package name */
    SeekBar f7882v;

    /* renamed from: w, reason: collision with root package name */
    boolean f7883w = false;

    /* renamed from: x, reason: collision with root package name */
    int f7884x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends f {
        a(int i10) {
            super(m.this, i10);
        }

        @Override // x6.h.b
        public void a(int i10, int i11, int i12) {
            if (Build.VERSION.SDK_INT >= 24) {
                m.this.f7882v.setProgress(i11, true);
            } else {
                m.this.f7882v.setProgress(i11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            m.this.f(x6.b.VOICE_CALL, i10, seekBar);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements s {

        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f7888f;

            a(String str) {
                this.f7888f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                m.this.i(this.f7888f);
            }
        }

        c() {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void a(String str) {
            new Handler(Looper.getMainLooper()).post(new a(str));
            m.this.k();
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public boolean b(com.groboot.mdaemergency.ptt.a aVar) {
            m mVar = m.this;
            if (!mVar.f7869i) {
                return false;
            }
            mVar.g(aVar);
            return true;
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void c(com.groboot.mdaemergency.ptt.a aVar) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void d(p.a0 a0Var, p.a0 a0Var2) {
            m.this.k();
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void e(w6.p pVar) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void f(com.groboot.mdaemergency.ptt.a aVar) {
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
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                m mVar = m.this;
                if (mVar.f7869i) {
                    mVar.f7876p.setText("");
                }
            }
        }

        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                m mVar = m.this;
                int i10 = mVar.f7884x;
                if (i10 <= -1) {
                    return;
                }
                mVar.f7884x = i10 - 1;
                d0.a(1000L);
                if (m.this.f7884x < 0) {
                    new Handler(Looper.getMainLooper()).post(new a());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class f implements h.b {

        /* renamed from: a, reason: collision with root package name */
        public final int f7893a;

        protected f(m mVar, int i10) {
            this.f7893a = i10;
        }
    }

    public m(Context context, View view, View.OnClickListener onClickListener) {
        this.f7884x = -1;
        this.f7873m = view;
        this.f7868h = context;
        this.f7881u = onClickListener;
        this.f7874n = (TextView) view.findViewById(R.id.tv_name);
        this.f7875o = (TextView) view.findViewById(R.id.tv_name2);
        this.f7876p = (TextView) view.findViewById(R.id.tv_message);
        this.f7877q = (TextView) view.findViewById(R.id.tv_status);
        this.f7878r = (ImageView) view.findViewById(R.id.iv_play);
        this.f7879s = (ProgressBar) view.findViewById(R.id.pb_wait);
        this.f7880t = view.findViewById(R.id.ll_main);
        this.f7878r.setOnTouchListener(this);
        this.f7882v = (SeekBar) view.findViewById(R.id.sb_volume);
        h();
        view.findViewById(R.id.btn_send).setOnClickListener(this);
        p c02 = p.c0();
        this.f7871k = c02;
        if (c02 != null) {
            this.f7872l = c();
            com.groboot.mdaemergency.ptt.a aVar = this.f7870j;
            if (aVar != null && l0.l0(aVar.f7787a)) {
                e();
            }
            this.f7871k.E(s.a.lockScreenView, this.f7872l);
            this.f7884x = -1;
        }
    }

    private void b() {
        int i10 = this.f7884x;
        this.f7884x = 4;
        if (i10 > -1) {
            return;
        }
        new Thread(new e()).start();
    }

    private s c() {
        return new c();
    }

    private g.d d() {
        return g.d.getByInt(l0.U(w6.m.G()));
    }

    private void e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(x6.b bVar, int i10, SeekBar seekBar) {
        try {
            this.f7866f.e(bVar.audioStreamName, i10);
        } catch (Throwable th) {
            Toast.makeText(this.f7868h, th.getMessage(), 0).show();
            th.printStackTrace();
            seekBar.setProgress(this.f7866f.b(bVar.audioStreamName));
        }
    }

    private void h() {
        if (d() != g.d.NONE) {
            this.f7882v.setVisibility(4);
            return;
        }
        this.f7882v.setVisibility(0);
        x6.h hVar = new x6.h(this.f7868h);
        this.f7866f = hVar;
        SeekBar seekBar = this.f7882v;
        x6.b bVar = x6.b.VOICE_CALL;
        seekBar.setMax(hVar.c(bVar.audioStreamName));
        this.f7882v.setProgress(this.f7866f.b(bVar.audioStreamName));
        a aVar = new a(bVar.audioStreamName);
        this.f7867g = aVar;
        this.f7866f.d(aVar.f7893a, aVar, true);
        this.f7882v.setOnSeekBarChangeListener(new b());
    }

    public void g(com.groboot.mdaemergency.ptt.a aVar) {
        this.f7870j = aVar;
        k();
    }

    public void i(String str) {
        this.f7876p.setText(str);
        b();
    }

    public void j() {
        View view;
        int color;
        try {
            this.f7876p.setText("");
            com.groboot.mdaemergency.ptt.a aVar = this.f7870j;
            if (aVar != null && aVar.a() != null) {
                this.f7874n.setText(this.f7870j.a().f15238d);
                com.groboot.mdaemergency.ptt.a aVar2 = this.f7870j;
                String str = aVar2.f7789c == null ? "" : aVar2.f7788b.f15238d;
                this.f7875o.setText(str);
                this.f7875o.setVisibility(l0.l0(str) ? 8 : 0);
                p.a0 a0Var = this.f7871k.f7910j;
                if (a0Var == p.a0.requestPttSession) {
                    this.f7878r.setEnabled(true);
                    this.f7878r.setImageResource(R.drawable.ptt_play_0_red);
                    this.f7879s.setVisibility(0);
                    this.f7877q.setText(R.string.connecting);
                    view = this.f7880t;
                    color = this.f7868h.getResources().getColor(R.color.ptt_play_red);
                } else if (a0Var == p.a0.ptt) {
                    this.f7878r.setImageResource(R.drawable.ptt_play_0);
                    this.f7878r.setEnabled(true);
                    this.f7877q.setText(R.string.connected);
                    this.f7879s.setVisibility(8);
                    view = this.f7880t;
                    color = this.f7868h.getResources().getColor(R.color.ptt_play_green);
                } else if (a0Var == p.a0.readyToPtt) {
                    this.f7878r.setImageResource(R.drawable.ptt_play_0_yellow);
                    this.f7879s.setVisibility(8);
                    this.f7878r.setEnabled(true);
                    this.f7877q.setText(R.string.available);
                    view = this.f7880t;
                    color = this.f7868h.getResources().getColor(R.color.ptt_play_yellow);
                } else if (a0Var == p.a0.ending) {
                    this.f7878r.setImageResource(R.drawable.ptt_play_0_blue);
                    this.f7879s.setVisibility(0);
                    this.f7878r.setEnabled(true);
                    this.f7877q.setText(R.string.bracket);
                    view = this.f7880t;
                    color = this.f7868h.getResources().getColor(R.color.ptt_play_blue);
                } else {
                    if (a0Var == p.a0.openChanel) {
                        this.f7877q.setText(R.string.open_channel);
                    } else {
                        this.f7877q.setText("");
                    }
                    this.f7878r.setImageResource(R.drawable.ptt_play_0_gray);
                    this.f7878r.setEnabled(true);
                    this.f7879s.setVisibility(8);
                    view = this.f7880t;
                    color = this.f7868h.getResources().getColor(R.color.ptt_play_gray);
                }
                view.setBackgroundColor(color);
            }
        } catch (Exception unused) {
        }
    }

    public void k() {
        new Handler(Looper.getMainLooper()).post(new d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btn_send) {
            if (id != R.id.iv_close) {
                return;
            }
            this.f7881u.onClick(view);
        } else {
            String obj = ((EditText) this.f7873m.findViewById(R.id.et_message)).getText().toString();
            if (l0.l0(obj)) {
                return;
            }
            this.f7871k.U0(this.f7870j.f7787a, obj);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("action:");
        sb2.append(motionEvent.getAction());
        try {
            if (view.getId() == R.id.iv_play) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1) {
                        this.f7871k.e1();
                    }
                    this.f7883w = false;
                } else if (!this.f7883w) {
                    this.f7883w = true;
                    if (this.f7871k.i0() == p.a0.ready) {
                        e();
                    } else {
                        this.f7871k.P(this.f7870j, 0);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }
}
