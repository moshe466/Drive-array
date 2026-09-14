package f6;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.groboot.mdaemergency.async.FloatViewService;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.models.Event;
import com.groboot.mdaemergency.models.Feature;
import com.groboot.mdaemergency.models.Message;
import com.groboot.mdaemergency.ui.views.WebViewMDA;
import f6.v;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class v extends a6.a {
    WebViewMDA A0;
    ImageView B0;
    ImageView C0;
    SwipeRefreshLayout D0;
    ProgressBar E0;
    Button F0;
    WebViewMDA.k G0;
    private BroadcastReceiver H0;
    List<Event> I0;
    List<Message> J0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            v.this.E2();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (((a6.a) v.this).f309z0) {
                v.this.t().runOnUiThread(new Runnable() { // from class: f6.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.b();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements d.u {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            v.this.E0.setVisibility(8);
            v vVar = v.this;
            vVar.F0.setVisibility(vVar.y2() ? 8 : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(List list, List list2, String str) {
            if (v.this.t0()) {
                v.this.E0.setVisibility(8);
                v.this.z2(list, list2, str);
            }
        }

        @Override // com.groboot.mdaemergency.async.d.u
        public void a(String str) {
            if (v.this.t() != null) {
                v.this.t().runOnUiThread(new Runnable() { // from class: f6.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.b.this.f();
                    }
                });
            }
        }

        @Override // com.groboot.mdaemergency.async.d.u
        public void b(List<Feature> list) {
            v.this.t();
        }

        @Override // com.groboot.mdaemergency.async.d.u
        public void c(final List<Event> list, final List<Message> list2, final String str, boolean z10) {
            if (v.this.t() == null) {
                return;
            }
            v.this.t().runOnUiThread(new Runnable() { // from class: f6.x
                @Override // java.lang.Runnable
                public final void run() {
                    v.b.this.g(list, list2, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements d.w {
        c() {
        }

        @Override // com.groboot.mdaemergency.async.d.w
        public void a(String str) {
        }

        @Override // com.groboot.mdaemergency.async.d.w
        public void b(Message message) {
            if (message == null) {
                return;
            }
            v.this.G0.n(message);
            w6.m.o0("");
        }
    }

    public v() {
        new Date(new Date().getTime() - 100000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A2(String str) {
        com.groboot.mdaemergency.async.d.v().B(t(), str, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B2(Message message, b.a aVar) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MainFragment Message Content id:");
            sb2.append(w6.l0.o(message.MessageID, 12));
        } catch (Exception e10) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("MainFragment Message Content error:");
            sb3.append(e10.getMessage());
        }
        a6.h.c();
        if (aVar.f("UpdateRequired") && !aVar.h("UpdateRequired") && aVar.b("UpdateRequired")) {
            String packageName = t().getPackageName();
            try {
                P1(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
                return;
            } catch (ActivityNotFoundException unused) {
                P1(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + packageName)));
                return;
            }
        }
        if (aVar.b("TokenIsInvalid")) {
            w6.m.c();
            a6.h.n(t());
            t().finish();
        } else if (!aVar.b("Success")) {
            a6.h.d(t(), R.string.general_error_message);
        } else if (aVar.f("HtmlContent")) {
            message.HtmlContent = aVar.e("HtmlContent");
            this.G0.n(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C2(View view) {
        this.A0.zoomIn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D2(View view) {
        this.A0.zoomOut();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F2(View view) {
        E2();
    }

    private void G2(final String str) {
        for (Message message : this.J0) {
            w6.e.a("eventid " + message.MessageID + " id " + str);
            if (message.MessageID.equals(str)) {
                if (message.HtmlType == 3) {
                    H2(message);
                    return;
                } else {
                    this.G0.n(message);
                    return;
                }
            }
        }
        new Thread(new Runnable() { // from class: f6.t
            @Override // java.lang.Runnable
            public final void run() {
                v.this.A2(str);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I2, reason: merged with bridge method [inline-methods] */
    public void E2() {
        new Date();
        this.F0.setVisibility(8);
        this.E0.setVisibility(y2() ? 8 : 0);
        com.groboot.mdaemergency.async.d.v().D(t());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z2(List<Event> list, List<Message> list2, String str) {
        String x10;
        E();
        if (str == null || str.length() == 0) {
            return;
        }
        w6.l0.l0(str);
        this.A0.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
        K2(list, list2);
        if (m2() && (x10 = w6.m.x()) != null && !x10.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MainFragment id:");
            sb2.append(w6.l0.o(x10, 12));
            L2(x10);
        }
        this.D0.setRefreshing(false);
    }

    public void H2(final Message message) {
        a6.h.m(t());
        com.groboot.mdaemergency.async.d.v().C(t(), message.MessageID, new b.InterfaceC0098b() { // from class: f6.s
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                v.this.B2(message, aVar);
            }
        });
    }

    public void J2(WebViewMDA.k kVar) {
        this.G0 = kVar;
        WebViewMDA webViewMDA = this.A0;
        if (webViewMDA != null) {
            webViewMDA.setClickHandler(kVar);
        }
    }

    public void K2(List<Event> list, List<Message> list2) {
        ArrayList arrayList = new ArrayList();
        this.I0 = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        ArrayList arrayList2 = new ArrayList();
        this.J0 = arrayList2;
        if (list2 != null) {
            arrayList2.addAll(list2);
        }
    }

    public void L2(String str) {
        G2(str);
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void R0() {
        super.R0();
        com.groboot.mdaemergency.async.d.v().X("MainFragment");
        a6.h.c();
        t().unregisterReceiver(this.H0);
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        t().registerReceiver(this.H0, new IntentFilter("com.groboot.mdaemergency.gcm.reseivedMessage"));
        E2();
        FloatViewService.l(t());
        com.groboot.mdaemergency.async.d.v().g("MainFragment", new b());
        com.groboot.mdaemergency.async.d.v().z();
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.fragment_event_log);
        this.A0 = (WebViewMDA) k2(R.id.messages_list);
        this.D0 = (SwipeRefreshLayout) k2(R.id.swipe_container);
        this.E0 = (ProgressBar) k2(R.id.progress_bar);
        this.F0 = (Button) k2(R.id.btn_refresh);
        this.B0 = (ImageView) k2(R.id.iv_zoom_plus);
        this.C0 = (ImageView) k2(R.id.iv_zoom_minus);
        this.A0.setClickHandler(this.G0);
        this.B0.setOnClickListener(new View.OnClickListener() { // from class: f6.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.this.C2(view);
            }
        });
        this.C0.setOnClickListener(new View.OnClickListener() { // from class: f6.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.this.D2(view);
            }
        });
        this.D0.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: f6.r
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                v.this.E2();
            }
        });
        this.F0.setOnClickListener(new View.OnClickListener() { // from class: f6.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.this.F2(view);
            }
        });
        g(true);
        setTitle(R.string.event_log);
        this.H0 = new a();
    }

    @Override // a6.a
    public void o2() {
    }

    public boolean y2() {
        List<Message> list = this.J0;
        return (list == null || list.isEmpty()) ? false : true;
    }
}
