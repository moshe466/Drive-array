package v6;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.opentok.android.PublisherKit;
import com.opentok.android.Session;
import il.org.mda.health.R;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class k extends LinearLayout {

    /* renamed from: f, reason: collision with root package name */
    public Map<Integer, View> f14678f;

    /* renamed from: g, reason: collision with root package name */
    private final Activity f14679g;

    /* renamed from: h, reason: collision with root package name */
    private final w5.a f14680h;

    /* renamed from: i, reason: collision with root package name */
    private final l f14681i;

    /* renamed from: j, reason: collision with root package name */
    private final String f14682j;

    /* renamed from: k, reason: collision with root package name */
    private ConstraintLayout f14683k;

    /* renamed from: l, reason: collision with root package name */
    private Session f14684l;

    /* renamed from: m, reason: collision with root package name */
    private com.opentok.android.k f14685m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f14686n;

    /* renamed from: o, reason: collision with root package name */
    private final d f14687o;

    /* renamed from: p, reason: collision with root package name */
    private final View.OnClickListener f14688p;

    /* renamed from: q, reason: collision with root package name */
    private final b f14689q;

    /* renamed from: r, reason: collision with root package name */
    private final PublisherKit.d f14690r;

    /* loaded from: classes.dex */
    public static final class a implements PublisherKit.d {
        a() {
        }

        @Override // com.opentok.android.PublisherKit.d
        public void a(PublisherKit publisherKit, com.opentok.android.i iVar) {
            k.this.getTAG();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onError: ");
            y8.k.b(iVar);
            sb2.append(iVar.b());
            sb2.append(" : ");
            sb2.append(iVar.a());
            sb2.append(" - ");
            sb2.append((Object) iVar.c());
            k.this.p(iVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Session.c {
        b() {
        }

        @Override // com.opentok.android.Session.c
        public void a(Session session, com.opentok.android.i iVar) {
            y8.k.e(session, "session");
            y8.k.e(iVar, "opentokError");
            k.this.getTAG();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onError: ");
            sb2.append(iVar.b());
            sb2.append(" : ");
            sb2.append(iVar.a());
            sb2.append(" - ");
            sb2.append((Object) iVar.c());
            sb2.append(" in session: ");
            sb2.append((Object) session.c());
            k.this.p(iVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        c(k kVar) {
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends m {
        d() {
        }

        @Override // v6.m
        public void a() {
            super.a();
            k.this.getTAG();
            k.this.k(false);
        }

        @Override // v6.m
        public void d() {
            super.d();
            k.this.getTAG();
            k.this.k(true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Activity activity, w5.a aVar, l lVar) {
        super(activity.getApplicationContext());
        y8.k.e(activity, "activity");
        y8.k.e(aVar, "openTokConfig");
        y8.k.e(lVar, "callBack");
        this.f14678f = new LinkedHashMap();
        this.f14679g = activity;
        this.f14680h = aVar;
        this.f14681i = lVar;
        this.f14682j = "OpenTok";
        View inflate = View.inflate(getContext(), R.layout.open_tok_view, null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        this.f14683k = (ConstraintLayout) inflate;
        d dVar = new d();
        this.f14687o = dVar;
        this.f14683k.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        addView(this.f14683k);
        ((RelativeLayout) this.f14683k.findViewById(g5.h.I)).setOnClickListener(new View.OnClickListener() { // from class: v6.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.f(k.this, view);
            }
        });
        ((RelativeLayout) this.f14683k.findViewById(g5.h.J)).setOnClickListener(new View.OnClickListener() { // from class: v6.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.g(k.this, view);
            }
        });
        ((RelativeLayout) this.f14683k.findViewById(g5.h.K)).setOnClickListener(new View.OnClickListener() { // from class: v6.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.h(k.this, view);
            }
        });
        setOnTouchListener(dVar);
        this.f14688p = new View.OnClickListener() { // from class: v6.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.m(k.this, view);
            }
        };
        this.f14689q = new b();
        this.f14690r = new a();
        new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(k kVar, View view) {
        y8.k.e(kVar, "this$0");
        com.opentok.android.k kVar2 = kVar.f14685m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(k kVar, View view) {
        y8.k.e(kVar, "this$0");
        com.opentok.android.k kVar2 = kVar.f14685m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(k kVar, View view) {
        y8.k.e(kVar, "this$0");
        kVar.q();
        kVar.f14681i.a();
    }

    private final void j() {
        Session session = this.f14684l;
        if (session == null) {
            return;
        }
        y8.k.b(session);
        session.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(k kVar, View view) {
        y8.k.e(kVar, "this$0");
        kVar.k(!kVar.f14686n);
    }

    private final void n() {
        com.groboot.mdaemergency.a.e(this.f14679g, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(com.opentok.android.i iVar) {
    }

    public View e(int i10) {
        Map<Integer, View> map = this.f14678f;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final Activity getActivity() {
        return this.f14679g;
    }

    public final l getCallBack() {
        return this.f14681i;
    }

    public final PublisherKit.d getPublisherListener() {
        return this.f14690r;
    }

    public final String getTAG() {
        return this.f14682j;
    }

    public final void k(boolean z10) {
        this.f14681i.b(z10 ? -1 : ((RelativeLayout) e(g5.h.G)).getHeight());
        this.f14686n = z10;
    }

    public final void l() {
        try {
            Session a10 = new Session.b(getContext(), this.f14680h.a(), this.f14680h.b()).a();
            this.f14684l = a10;
            if (a10 == null) {
                return;
            }
            a10.g(this.f14689q);
            a10.a(this.f14680h.c());
        } catch (Exception e10) {
            e10.getMessage();
        }
    }

    public final void o() {
        Session session = this.f14684l;
        if (session == null) {
            return;
        }
        session.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((RelativeLayout) e(g5.h.H)).setOnClickListener(this.f14688p);
        k(true);
        n();
        l();
    }

    public final void q() {
        Session session = this.f14684l;
        if (session == null) {
            return;
        }
        session.d();
        j();
    }

    public final void setShow(boolean z10) {
        this.f14686n = z10;
    }
}
