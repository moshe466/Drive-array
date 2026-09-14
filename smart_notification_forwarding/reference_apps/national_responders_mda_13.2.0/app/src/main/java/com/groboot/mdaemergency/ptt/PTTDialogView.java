package com.groboot.mdaemergency.ptt;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.groboot.mdaemergency.ptt.PTTDialogView;
import com.groboot.mdaemergency.ptt.p;
import com.groboot.mdaemergency.ptt.s;
import g5.e;
import il.org.mda.health.R;
import w6.d0;
import w6.g;
import w6.l0;
import x6.h;

/* loaded from: classes.dex */
public class PTTDialogView extends LinearLayout implements View.OnClickListener, View.OnTouchListener {
    View A;
    int B;
    i C;
    boolean D;
    private x6.h E;
    j F;
    k G;
    int H;
    int I;

    /* renamed from: f, reason: collision with root package name */
    Context f7719f;

    /* renamed from: g, reason: collision with root package name */
    View f7720g;

    /* renamed from: h, reason: collision with root package name */
    p f7721h;

    /* renamed from: i, reason: collision with root package name */
    public h f7722i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7723j;

    /* renamed from: k, reason: collision with root package name */
    TextView f7724k;

    /* renamed from: l, reason: collision with root package name */
    TextView f7725l;

    /* renamed from: m, reason: collision with root package name */
    TextView f7726m;

    /* renamed from: n, reason: collision with root package name */
    TextView f7727n;

    /* renamed from: o, reason: collision with root package name */
    SeekBar f7728o;

    /* renamed from: p, reason: collision with root package name */
    ImageView f7729p;

    /* renamed from: q, reason: collision with root package name */
    LinearLayout f7730q;

    /* renamed from: r, reason: collision with root package name */
    TextView f7731r;

    /* renamed from: s, reason: collision with root package name */
    ImageView f7732s;

    /* renamed from: t, reason: collision with root package name */
    ImageView f7733t;

    /* renamed from: u, reason: collision with root package name */
    ImageView f7734u;

    /* renamed from: v, reason: collision with root package name */
    ImageView f7735v;

    /* renamed from: w, reason: collision with root package name */
    ProgressBar f7736w;

    /* renamed from: x, reason: collision with root package name */
    View f7737x;

    /* renamed from: y, reason: collision with root package name */
    View f7738y;

    /* renamed from: z, reason: collision with root package name */
    com.groboot.mdaemergency.ptt.a f7739z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements s {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(w6.p pVar) {
            PTTDialogView.this.z(PTTDialogView.this.f7721h.f7903c.j(pVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(String str) {
            PTTDialogView.this.u(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p() {
            PTTDialogView.this.g();
            PTTDialogView.this.m();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q() {
            PTTDialogView.this.g();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r() {
            PTTDialogView.this.m();
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void a(final String str) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.groboot.mdaemergency.ptt.h
                @Override // java.lang.Runnable
                public final void run() {
                    PTTDialogView.a.this.o(str);
                }
            });
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public boolean b(com.groboot.mdaemergency.ptt.a aVar) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.groboot.mdaemergency.ptt.f
                @Override // java.lang.Runnable
                public final void run() {
                    PTTDialogView.a.this.p();
                }
            });
            return false;
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void c(com.groboot.mdaemergency.ptt.a aVar) {
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void d(p.a0 a0Var, p.a0 a0Var2) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.groboot.mdaemergency.ptt.g
                @Override // java.lang.Runnable
                public final void run() {
                    PTTDialogView.a.this.r();
                }
            });
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void e(final w6.p pVar) {
            PTTDialogView.this.f7720g.post(new Runnable() { // from class: com.groboot.mdaemergency.ptt.i
                @Override // java.lang.Runnable
                public final void run() {
                    PTTDialogView.a.this.n(pVar);
                }
            });
        }

        @Override // com.groboot.mdaemergency.ptt.s
        public void f(com.groboot.mdaemergency.ptt.a aVar) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.groboot.mdaemergency.ptt.e
                @Override // java.lang.Runnable
                public final void run() {
                    PTTDialogView.a.this.q();
                }
            });
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
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PTTDialogView.this.r();
            PTTDialogView.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PTTDialogView.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends j {
        d(int i10) {
            super(PTTDialogView.this, i10);
        }

        @Override // x6.h.b
        public void a(int i10, int i11, int i12) {
            if (Build.VERSION.SDK_INT >= 24) {
                PTTDialogView.this.f7728o.setProgress(i11, true);
            } else {
                PTTDialogView.this.f7728o.setProgress(i11);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements SeekBar.OnSeekBarChangeListener {
        e() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            PTTDialogView.this.q(x6.b.VOICE_CALL, i10, seekBar);
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
    public class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            PTTDialogView.this.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements p.b0 {
        g() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void a() {
        }

        @Override // com.groboot.mdaemergency.ptt.p.b0
        public void b(p pVar) {
            com.groboot.mdaemergency.ptt.a aVar = PTTDialogView.this.f7739z;
            if (aVar == null) {
                return;
            }
            l0.l0(aVar.f7787a);
            com.groboot.mdaemergency.ptt.a aVar2 = PTTDialogView.this.f7739z;
            if (aVar2.f7789c == null && aVar2.a().f15239e == 1) {
                pVar.l0();
            } else {
                PTTDialogView.this.f7739z.h(j7.a.ONLINE);
            }
            PTTDialogView.this.r();
        }
    }

    /* loaded from: classes.dex */
    public interface h {
        void a();
    }

    /* loaded from: classes.dex */
    public interface i {
        void a();
    }

    /* loaded from: classes.dex */
    public abstract class j implements h.b {

        /* renamed from: a, reason: collision with root package name */
        public final int f7747a;

        protected j(PTTDialogView pTTDialogView, int i10) {
            this.f7747a = i10;
        }
    }

    /* loaded from: classes.dex */
    public enum k {
        horizontal,
        normal,
        lock_screen,
        float_view;

        public int getResourceId() {
            return this == horizontal ? R.layout.ptt_dialog_view_center : this == float_view ? R.layout.ptt_float_view_new : R.layout.ptt_dialog;
        }
    }

    public PTTDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = -1;
        this.D = false;
        this.G = k.horizontal;
        this.f7719f = context;
        k(attributeSet);
    }

    public PTTDialogView(Context context, k kVar) {
        super(context);
        this.B = -1;
        this.D = false;
        this.G = k.horizontal;
        this.f7719f = context;
        this.G = kVar;
        k(null);
        if (kVar == k.float_view) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            int applyDimension = (int) TypedValue.applyDimension(1, 80.0f, context.getResources().getDisplayMetrics());
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(280, 140, 2005, 8, -3);
            layoutParams.gravity = 53;
            layoutParams.x = 0;
            layoutParams.y = point.y - applyDimension;
            setLayoutParams(layoutParams);
        }
    }

    private void e() {
        j7.a d10;
        if (this.D) {
            return;
        }
        this.D = true;
        com.groboot.mdaemergency.ptt.a aVar = this.f7739z;
        if (aVar == null || (d10 = aVar.d(getContext())) == null) {
            return;
        }
        if (d10 == j7.a.ONLINE) {
            this.f7721h.B0();
        } else {
            this.f7739z.e(getContext());
            m();
        }
    }

    private void f() {
        this.f7721h.C0();
        this.D = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f7726m.setText("");
        this.f7726m.setVisibility(4);
        if (this.G == k.horizontal) {
            this.f7724k.setVisibility(0);
            this.f7725l.setVisibility(0);
        }
        this.B = -1;
    }

    private s getManagerCallBackInterface() {
        return new a();
    }

    private void h() {
        if (this.B > -1) {
            this.B = 4;
        } else {
            this.B = 1;
            new Thread(new Runnable() { // from class: x5.c
                @Override // java.lang.Runnable
                public final void run() {
                    PTTDialogView.this.l();
                }
            }).start();
        }
    }

    private void j() {
        this.f7730q.setVisibility(8);
    }

    private void k(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.f7719f.getTheme().obtainStyledAttributes(attributeSet, g5.i.f9847c, 0, 0);
            try {
                int integer = obtainStyledAttributes.getInteger(0, -1);
                if (integer > -1) {
                    this.G = k.values()[integer];
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        View inflate = LinearLayout.inflate(this.f7719f, this.G.getResourceId(), null);
        this.f7720g = inflate;
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        addView(this.f7720g);
        this.f7724k = (TextView) this.f7720g.findViewById(R.id.tv_name);
        this.f7725l = (TextView) this.f7720g.findViewById(R.id.tv_name2);
        this.f7726m = (TextView) this.f7720g.findViewById(R.id.tv_message);
        this.f7727n = (TextView) this.f7720g.findViewById(R.id.tv_status);
        this.f7732s = (ImageView) this.f7720g.findViewById(R.id.iv_close);
        this.f7733t = (ImageView) this.f7720g.findViewById(R.id.iv_play);
        this.f7736w = (ProgressBar) this.f7720g.findViewById(R.id.pb_wait);
        this.f7730q = (LinearLayout) this.f7720g.findViewById(R.id.ll_error);
        this.f7731r = (TextView) this.f7720g.findViewById(R.id.tv_error);
        this.f7728o = (SeekBar) this.f7720g.findViewById(R.id.sb_volume);
        this.f7729p = (ImageView) this.f7720g.findViewById(R.id.img_silence);
        this.f7734u = (ImageView) this.f7720g.findViewById(R.id.img_verification1);
        this.f7735v = (ImageView) this.f7720g.findViewById(R.id.img_verification2);
        this.f7737x = this.f7720g.findViewById(R.id.ll_main);
        this.f7732s.setOnClickListener(this);
        this.f7733t.setOnTouchListener(this);
        this.f7729p.setOnClickListener(this);
        k kVar = this.G;
        k kVar2 = k.float_view;
        if (kVar == kVar2) {
            this.f7728o.getProgressDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_IN);
            this.f7728o.getThumb().setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        }
        k kVar3 = this.G;
        if (kVar3 == k.horizontal || kVar3 == kVar2) {
            this.f7738y = this.f7720g.findViewById(R.id.rl_background);
        }
        this.f7734u.setVisibility(4);
        this.f7735v.setVisibility(4);
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        while (true) {
            int i10 = this.B;
            if (i10 <= -1) {
                return;
            }
            this.B = i10 - 1;
            d0.a(1000L);
            if (!this.f7723j) {
                return;
            }
            if (this.B < 0) {
                new Handler(Looper.getMainLooper()).post(new c());
            }
        }
    }

    private void n() {
        this.f7723j = false;
        p pVar = this.f7721h;
        if (pVar != null) {
            pVar.Q0(s.a.floatView);
        }
        j jVar = this.F;
        if (jVar != null) {
            this.E.f(jVar.f7747a, jVar);
        }
        this.F = null;
        this.E = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(x6.b bVar, int i10, SeekBar seekBar) {
        x6.h hVar = this.E;
        if (hVar == null) {
            return;
        }
        try {
            hVar.e(bVar.audioStreamName, i10);
        } catch (Throwable th) {
            Toast.makeText(this.f7719f, th.getMessage(), 0).show();
            th.printStackTrace();
            seekBar.setProgress(this.E.b(bVar.audioStreamName));
        }
    }

    private void setBackgroundViewColor(int i10) {
        k kVar = this.G;
        if (kVar == k.horizontal || kVar == k.float_view) {
            this.f7738y.setBackgroundColor(i10);
        }
    }

    private void setMainBackgroundColor(int i10) {
        if (this.G != k.float_view) {
            this.f7737x.setBackgroundColor(i10);
        }
    }

    private void t(int i10) {
        TextView textView;
        String str;
        this.f7730q.setVisibility(0);
        this.f7730q.setOnClickListener(new b());
        if (i10 == 0) {
            textView = this.f7731r;
            str = "בעייה במערכת";
        } else if (i10 == 1) {
            textView = this.f7731r;
            str = "בעייה בפתיחת ערוץ תקשורת";
        } else if (i10 != 2) {
            textView = this.f7731r;
            str = "תקלה לא מזוהה";
        } else {
            textView = this.f7731r;
            str = "המערכת לא זמינה לשימוש";
        }
        textView.setText(str);
    }

    private void w() {
        animate().alpha(1.0f).setDuration(1000L).setListener(new f());
    }

    public com.groboot.mdaemergency.ptt.a getChanelData() {
        return this.f7739z;
    }

    @Override // android.view.View
    public View getRootView() {
        return this.f7720g;
    }

    public void i() {
        setVisibility(8);
        View view = this.A;
        if (view != null) {
            view.setVisibility(8);
        }
        n();
    }

    public void o(Context context, com.groboot.mdaemergency.ptt.a aVar) {
        p(context, aVar, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_silence /* 2131296724 */:
                this.f7721h.U();
                s();
                h hVar = this.f7722i;
                if (hVar != null) {
                    hVar.a();
                    return;
                }
                return;
            case R.id.iv_close /* 2131296743 */:
                i iVar = this.C;
                if (iVar != null) {
                    iVar.a();
                }
                i();
                return;
            case R.id.iv_play /* 2131296753 */:
                j7.a c10 = this.f7739z.c();
                if (c10 == null || c10 == j7.a.ONLINE) {
                    return;
                }
                this.f7721h.l0();
                m();
                return;
            case R.id.iv_send /* 2131296761 */:
                String obj = ((EditText) this.f7720g.findViewById(R.id.et_message)).getText().toString();
                if (l0.l0(obj)) {
                    return;
                }
                this.f7721h.T0(obj);
                return;
            case R.id.v_v /* 2131297418 */:
                if (w6.m.q()) {
                    this.f7720g.findViewById(R.id.ll_log).setVisibility(this.f7720g.findViewById(R.id.ll_log).getVisibility() == 8 ? 0 : 8);
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
            if (action == 0) {
                e();
            } else if (action != 1) {
                if (action != 2) {
                    this.D = false;
                } else {
                    if (this.H == 0) {
                        this.H = this.f7733t.getWidth();
                        this.I = this.G == k.float_view ? 20 : 0;
                    }
                    if (this.H > 0 && (motionEvent.getX() < this.I || motionEvent.getY() < this.I || motionEvent.getX() > this.H - this.I || motionEvent.getY() > this.H - this.I)) {
                        f();
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("x:");
                    sb3.append(motionEvent.getX());
                    sb3.append(" y:");
                    sb3.append(motionEvent.getY());
                }
            } else {
                f();
            }
        }
        return true;
    }

    public void p(Context context, com.groboot.mdaemergency.ptt.a aVar, View view) {
        if (!this.f7723j) {
            v(context, aVar, view);
        } else {
            this.f7739z = aVar;
            m();
        }
    }

    public void r() {
        this.f7723j = true;
        p c02 = p.c0();
        this.f7721h = c02;
        if (c02 == null) {
            t(0);
            return;
        }
        c02.E(s.a.view, getManagerCallBackInterface());
        m();
        s();
    }

    public void s() {
        p pVar = this.f7721h;
        if (pVar == null) {
            return;
        }
        if (pVar.h0() != g.d.NONE) {
            this.f7728o.setVisibility(4);
            this.f7729p.setVisibility(0);
            return;
        }
        this.f7728o.setVisibility(0);
        this.f7729p.setVisibility(8);
        x6.h hVar = new x6.h(this.f7719f);
        this.E = hVar;
        SeekBar seekBar = this.f7728o;
        x6.b bVar = x6.b.VOICE_CALL;
        seekBar.setMax(hVar.c(bVar.audioStreamName));
        this.f7728o.setProgress(this.E.b(bVar.audioStreamName));
        d dVar = new d(bVar.audioStreamName);
        this.F = dVar;
        this.E.d(dVar.f7747a, dVar, true);
        this.f7728o.setOnSeekBarChangeListener(new e());
    }

    public void u(String str) {
        if (l0.l0(str)) {
            g();
            return;
        }
        this.f7726m.setVisibility(0);
        if (this.G == k.horizontal) {
            this.f7724k.setVisibility(4);
            this.f7725l.setVisibility(4);
        }
        this.f7726m.setText(str);
        h();
    }

    public void v(Context context, com.groboot.mdaemergency.ptt.a aVar, View view) {
        this.f7739z = aVar;
        this.A = view;
        w();
        setVisibility(0);
        if (view != null) {
            view.setVisibility(0);
        }
        p.d0(context, new g());
    }

    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void m() {
        int i10;
        int i11;
        Resources resources;
        int i12;
        Resources resources2;
        p pVar = this.f7721h;
        if (pVar == null) {
            i10 = 0;
        } else {
            if (pVar.i0() != p.a0.notReady && this.f7721h.i0() != p.a0.login) {
                if (this.f7739z == null) {
                    t(1);
                    return;
                }
                j();
                try {
                    this.f7724k.setText(this.f7739z.a().f15238d);
                    com.groboot.mdaemergency.ptt.a aVar = this.f7739z;
                    this.f7725l.setText(aVar.f7789c == null ? "" : aVar.f7788b.f15238d);
                    if (this.f7721h.i0() != p.a0.ready && this.f7721h.i0() != p.a0.readyToPtt) {
                        if (this.f7721h.i0() != p.a0.ptt) {
                            if (this.f7721h.i0() == p.a0.requestPttSession) {
                                this.f7733t.setEnabled(true);
                                this.f7733t.setImageResource(R.drawable.ptt_play_yellow);
                                this.f7736w.setVisibility(4);
                                this.f7727n.setText(R.string.connecting);
                                setMainBackgroundColor(getContext().getResources().getColor(R.color.ptt_play_yellow));
                                resources2 = getContext().getResources();
                            } else if (this.f7721h.i0() == p.a0.ending) {
                                this.f7733t.setImageResource(R.drawable.ptt_play_yellow);
                                this.f7736w.setVisibility(4);
                                this.f7733t.setEnabled(true);
                                this.f7727n.setText(R.string.ending);
                                setMainBackgroundColor(getContext().getResources().getColor(R.color.ptt_play_yellow));
                                resources2 = getContext().getResources();
                            } else {
                                if (this.f7721h.i0() == p.a0.openChanel) {
                                    this.f7727n.setText(R.string.open_channel);
                                } else {
                                    this.f7727n.setText("");
                                }
                                this.f7733t.setImageResource(R.drawable.ptt_play_gray);
                                this.f7733t.setEnabled(true);
                                this.f7736w.setVisibility(4);
                                Resources resources3 = getContext().getResources();
                                i11 = R.color.ptt_play_gray;
                                setMainBackgroundColor(resources3.getColor(R.color.ptt_play_gray));
                                resources = getContext().getResources();
                            }
                            i12 = resources2.getColor(R.color.ptt_play_yellow);
                            setBackgroundViewColor(i12);
                            this.f7736w.setVisibility(4);
                            return;
                        }
                        this.f7733t.setImageResource(R.drawable.ptt_play_green);
                        this.f7733t.setEnabled(true);
                        this.f7727n.setText(R.string.dispatch);
                        this.f7736w.setVisibility(4);
                        Resources resources4 = getContext().getResources();
                        i11 = R.color.ptt_play_green;
                        setMainBackgroundColor(resources4.getColor(R.color.ptt_play_green));
                        resources = getContext().getResources();
                        i12 = resources.getColor(i11);
                        setBackgroundViewColor(i12);
                        this.f7736w.setVisibility(4);
                        return;
                    }
                    this.f7733t.setImageResource(R.drawable.ptt_play_record);
                    this.f7733t.setEnabled(true);
                    this.f7727n.setText(R.string.ready);
                    this.f7736w.setVisibility(4);
                    Resources resources5 = getContext().getResources();
                    i11 = R.color.red_buttons;
                    setMainBackgroundColor(resources5.getColor(R.color.red_buttons));
                    resources = getContext().getResources();
                    i12 = resources.getColor(i11);
                    setBackgroundViewColor(i12);
                    this.f7736w.setVisibility(4);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            i10 = 2;
        }
        t(i10);
    }

    public void y() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: x5.d
            @Override // java.lang.Runnable
            public final void run() {
                PTTDialogView.this.m();
            }
        });
    }

    public void z(w6.q qVar) {
        int i10;
        if (qVar.f15244h == w6.q.f15243p) {
            r2 = qVar.f15247k != null ? 0 : 4;
            i10 = qVar.f15248l > 0 ? 0 : 4;
        } else {
            i10 = 4;
        }
        this.f7734u.setImageDrawable(this.f7719f.getResources().getDrawable(qVar.f15248l > 0 ? R.drawable.verification_blue : R.drawable.verification));
        this.f7734u.setVisibility(r2);
        this.f7735v.setVisibility(i10);
    }
}
