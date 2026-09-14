package f6;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import c6.c;
import com.groboot.mdaemergency.app_authorization.ConfigurationAuthActivity;
import com.groboot.mdaemergency.async.FloatViewService;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.enums.b;
import com.groboot.mdaemergency.models.AppUser;
import com.groboot.mdaemergency.models.Event;
import com.groboot.mdaemergency.models.Feature;
import com.groboot.mdaemergency.models.Message;
import com.groboot.mdaemergency.models.OnCallParameterAnswer;
import com.groboot.mdaemergency.models.ShortcutButtons;
import com.groboot.mdaemergency.models.poc.Device;
import com.groboot.mdaemergency.ptt.b;
import com.groboot.mdaemergency.ui.main.MainActivity;
import com.groboot.mdaemergency.ui.views.DynamicGridView;
import com.groboot.mdaemergency.ui.views.WebViewMDA;
import d6.a;
import d6.t;
import f6.h2;
import f6.q0;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import s5.d;

/* loaded from: classes.dex */
public class q0 extends a6.a {
    ImageView A0;
    ImageView B0;
    WebViewMDA C0;
    Button D0;
    TextView E0;
    TextView F0;
    View G0;
    ProgressBar H0;
    ProgressBar I0;
    SwipeRefreshLayout J0;
    c6.c K0;
    TextView L0;
    TextView M0;
    TextView N0;
    TextView O0;
    GridView P0;
    List<Message> Q0;
    List<Event> R0;
    ShortcutButtons S0;
    private BroadcastReceiver T0;
    private m0.a U0;
    c6.e W0;
    com.groboot.mdaemergency.enums.a X0;
    RelativeLayout Y0;
    RelativeLayout Z0;

    /* renamed from: b1, reason: collision with root package name */
    WebViewMDA.k f9556b1;

    /* renamed from: h1, reason: collision with root package name */
    private Dialog f9562h1;

    /* renamed from: i1, reason: collision with root package name */
    private View.OnClickListener f9563i1;
    com.groboot.mdaemergency.enums.c V0 = com.groboot.mdaemergency.enums.c.NONE;

    /* renamed from: a1, reason: collision with root package name */
    String f9555a1 = "MainFragment";

    /* renamed from: c1, reason: collision with root package name */
    BroadcastReceiver f9557c1 = new c();

    /* renamed from: d1, reason: collision with root package name */
    private View.OnClickListener f9558d1 = new View.OnClickListener() { // from class: f6.j0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            q0.this.f3(view);
        }
    };

    /* renamed from: e1, reason: collision with root package name */
    private View.OnClickListener f9559e1 = new View.OnClickListener() { // from class: f6.l0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            q0.this.g3(view);
        }
    };

    /* renamed from: f1, reason: collision with root package name */
    d.f f9560f1 = new d.f() { // from class: f6.g0
        @Override // s5.d.f
        public final void a(boolean z10) {
            q0.this.d3(z10);
        }
    };

    /* renamed from: g1, reason: collision with root package name */
    private View.OnClickListener f9561g1 = new g();

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(q0.this.A(), (Class<?>) ConfigurationAuthActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("failedConfig", "mockLocation");
            q0.this.A().startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            q0.this.k3();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (((a6.a) q0.this).f309z0) {
                q0.this.t().runOnUiThread(new Runnable() { // from class: f6.r0
                    @Override // java.lang.Runnable
                    public final void run() {
                        q0.b.this.b();
                    }
                });
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.groboot.mdaemergency.CHANGE_STATUS")) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[Location]");
                sb2.append(q0.this.f9555a1);
                com.groboot.mdaemergency.enums.b statusAvailability = w6.m.k().getLocation().getStatusAvailability();
                com.groboot.mdaemergency.enums.b bVar = (com.groboot.mdaemergency.enums.b) intent.getSerializableExtra("new_status");
                if (w6.m.k().getLocation().getStatusAvailability().getTrackingType() == b.a.SLEEPY) {
                    String str = context.getResources().getString(R.string.address) + " " + context.getResources().getString(statusAvailability.getResTitle()) + " " + context.getResources().getString(R.string.not_accurate);
                    a6.h.o(q0.this.t(), str + ",\n " + context.getResources().getString(R.string.status_change_to_availability));
                    w6.l0.A0(str, context.getResources().getString(R.string.status_change_to_availability), true, 12345655);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("[Location]");
                    sb3.append(q0.this.f9555a1);
                    q0.this.w3(bVar, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements d.u {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g() {
            q0.this.H0.setVisibility(8);
            q0 q0Var = q0.this;
            q0Var.D0.setVisibility(q0Var.S2() ? 8 : 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(List list, List list2, String str, boolean z10) {
            if (q0.this.t0()) {
                q0.this.H0.setVisibility(8);
                q0.this.E3();
                q0.this.U2(list, list2, str);
                if (z10) {
                    q0.this.D3();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(List list) {
            q0 q0Var = q0.this;
            ShortcutButtons shortcutButtons = q0Var.S0;
            if (shortcutButtons == null) {
                q0Var.V2();
                return;
            }
            shortcutButtons.checkUpdateList(list);
            q0 q0Var2 = q0.this;
            q0Var2.I3(q0Var2.S0);
        }

        @Override // com.groboot.mdaemergency.async.d.u
        public void a(String str) {
            if (q0.this.t() != null) {
                q0.this.t().runOnUiThread(new Runnable() { // from class: f6.s0
                    @Override // java.lang.Runnable
                    public final void run() {
                        q0.d.this.g();
                    }
                });
            }
        }

        @Override // com.groboot.mdaemergency.async.d.u
        public void b(final List<Feature> list) {
            if (q0.this.t() != null && q0.this.X0.displayShortcut() && q0.this.t0()) {
                q0.this.t().runOnUiThread(new Runnable() { // from class: f6.t0
                    @Override // java.lang.Runnable
                    public final void run() {
                        q0.d.this.i(list);
                    }
                });
            }
        }

        @Override // com.groboot.mdaemergency.async.d.u
        public void c(final List<Event> list, final List<Message> list2, final String str, final boolean z10) {
            if (q0.this.t() == null) {
                return;
            }
            q0.this.t().runOnUiThread(new Runnable() { // from class: f6.u0
                @Override // java.lang.Runnable
                public final void run() {
                    q0.d.this.h(list, list2, str, z10);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements DynamicGridView.c {
        e() {
        }

        @Override // com.groboot.mdaemergency.ui.views.DynamicGridView.c
        public void a(List<Feature> list) {
            q0.this.S0.updateShortcut(list);
            q0.this.I3(list);
        }

        @Override // com.groboot.mdaemergency.ui.views.DynamicGridView.c
        public void b(int i10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements d.w {
        f() {
        }

        @Override // com.groboot.mdaemergency.async.d.w
        public void a(String str) {
        }

        @Override // com.groboot.mdaemergency.async.d.w
        public void b(Message message) {
            if (message == null) {
                return;
            }
            q0.this.f9556b1.n(message);
            w6.m.o0("");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Dialog dialog, com.groboot.mdaemergency.enums.b bVar) {
            dialog.dismiss();
            if (bVar == com.groboot.mdaemergency.enums.b.NOT_AVAILABLE || s5.d.j().p()) {
                q0.this.w3(bVar, true);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.groboot.mdaemergency.a.m(q0.this.A())) {
                View inflate = LayoutInflater.from(q0.this.t()).inflate(R.layout.listview_layout, (ViewGroup) null, false);
                final Dialog k10 = a6.h.k(q0.this.t(), inflate);
                k10.setCancelable(false);
                ListView listView = (ListView) inflate.findViewById(R.id.listview);
                inflate.findViewById(R.id.tv_close).setOnClickListener(new View.OnClickListener() { // from class: f6.v0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        k10.dismiss();
                    }
                });
                q0.this.K0 = new c6.c(q0.this.t(), new c.b() { // from class: f6.w0
                    @Override // c6.c.b
                    public final void a(com.groboot.mdaemergency.enums.b bVar) {
                        q0.g.this.d(k10, bVar);
                    }
                });
                listView.setAdapter((ListAdapter) q0.this.K0);
                k10.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements d.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.groboot.mdaemergency.enums.b f9571a;

        h(com.groboot.mdaemergency.enums.b bVar) {
            this.f9571a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(com.groboot.mdaemergency.enums.b bVar, DialogInterface dialogInterface, int i10) {
            q0.this.w3(bVar, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void k(DialogInterface dialogInterface, int i10) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(DialogInterface dialogInterface, int i10) {
            d("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(DialogInterface dialogInterface, int i10) {
            a("");
        }

        @Override // s5.d.g
        public void a(String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(q0.this.f9555a1);
            sb2.append(" callback error");
            q0.this.I0.setVisibility(8);
            q0.this.E0.setEnabled(true);
            if (str == null || str.isEmpty()) {
                return;
            }
            a6.h.o(q0.this.t(), str);
        }

        @Override // s5.d.g
        public void b() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(q0.this.f9555a1);
            sb2.append(" callback notAtStaticAddress");
            w6.l0.I0(q0.this.t(), q0.this.e0(R.string.location_doesnot_match_address) + " " + this.f9571a.getTitle(), q0.this.e0(R.string.is_want_update_address_for_status) + " " + this.f9571a.getTitle() + "?", R.string.changeAddress, R.string.cancel, new DialogInterface.OnClickListener() { // from class: f6.x0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    q0.h.this.l(dialogInterface, i10);
                }
            }, new DialogInterface.OnClickListener() { // from class: f6.y0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    q0.h.this.m(dialogInterface, i10);
                }
            });
        }

        @Override // s5.d.g
        public void c(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(q0.this.f9555a1);
            sb2.append(" callback errorDialog");
            q0.this.I0.setVisibility(8);
            q0.this.E0.setEnabled(true);
            Context A = q0.this.A();
            final com.groboot.mdaemergency.enums.b bVar = this.f9571a;
            w6.l0.G0(A, i10, R.string.try_again, R.string.cancel, new DialogInterface.OnClickListener() { // from class: f6.z0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    q0.h.this.j(bVar, dialogInterface, i11);
                }
            }, new DialogInterface.OnClickListener() { // from class: f6.a1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    q0.h.k(dialogInterface, i11);
                }
            });
        }

        @Override // s5.d.g
        public void d(String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(q0.this.f9555a1);
            sb2.append(" callback addressRequired");
            q0.this.I0.setVisibility(8);
            q0.this.E0.setEnabled(true);
            q0.this.B3(this.f9571a, str);
        }

        @Override // s5.d.g
        public void e() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(q0.this.f9555a1);
            sb2.append(" callback success");
            q0.this.I0.setVisibility(8);
            q0.this.E0.setEnabled(true);
            q0.this.x3(this.f9571a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements b.g {
        i(q0 q0Var) {
        }

        @Override // com.groboot.mdaemergency.ptt.b.g
        public void a(w6.p pVar) {
            com.groboot.mdaemergency.ptt.p.c0().d1(pVar);
        }

        @Override // com.groboot.mdaemergency.ptt.b.g
        public void b(String str) {
        }
    }

    public q0() {
        new Date(new Date().getTime() - 100000);
        this.f9563i1 = new View.OnClickListener() { // from class: f6.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q0.this.e3(view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B3(com.groboot.mdaemergency.enums.b bVar, String str) {
        new d6.a(bVar, str, new a.f() { // from class: f6.a0
            @Override // d6.a.f
            public final void a(com.groboot.mdaemergency.enums.b bVar2, AppUser.Location location) {
                q0.this.n3(bVar2, location);
            }
        }).i2(t().d0(), "AddressDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D3() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E3() {
        if (com.groboot.mdaemergency.async.d.v().f7636f == null || com.groboot.mdaemergency.async.d.v().f7636f.MainScreenFeatureType == -1) {
            return;
        }
        ((MainActivity) t()).s(new Feature(com.groboot.mdaemergency.async.d.v().f7636f.MainScreenFeatureType), false);
        I(false);
    }

    private void H3() {
        if (this.X0 != com.groboot.mdaemergency.enums.a.MADA || w6.l0.m0(t())) {
            this.N0.setVisibility(8);
        } else {
            this.N0.setVisibility(w6.m.N() > 0 ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I3(List<Feature> list) {
        if (t() == null) {
            return;
        }
        c6.e eVar = new c6.e(t().getApplicationContext(), list);
        this.W0 = eVar;
        eVar.notifyDataSetChanged();
        this.P0.setAdapter((ListAdapter) this.W0);
        H3();
    }

    private void P2(com.groboot.mdaemergency.enums.b bVar) {
        r5.a.a().h(A(), bVar);
    }

    private void R2(com.groboot.mdaemergency.enums.b bVar) {
        if (bVar.getTrackingType() == b.a.FULL) {
            this.F0.setVisibility(8);
            return;
        }
        this.F0.setVisibility(0);
        AppUser.Location location = w6.m.k().getLocation(bVar);
        if (location == null) {
            this.F0.setVisibility(8);
            return;
        }
        this.E0.setText(bVar.getTitle() + " - " + location.getAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U2(List<Event> list, List<Message> list2, String str) {
        String x10;
        E();
        if (str == null || str.length() == 0) {
            return;
        }
        w6.l0.l0(str);
        this.C0.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
        A3(list, list2);
        if (m2() && (x10 = w6.m.x()) != null && !x10.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MainFragment id:");
            sb2.append(w6.l0.o(x10, 12));
            F3(x10);
        }
        this.J0.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V2() {
        if (t() == null) {
            return;
        }
        if (!this.X0.displayShortcut() || (w6.l0.m0(t()) && this.X0 != com.groboot.mdaemergency.enums.a.POC)) {
            this.P0.setVisibility(8);
        } else {
            if (com.groboot.mdaemergency.async.d.v().f7635e == null) {
                return;
            }
            t().runOnUiThread(new Runnable() { // from class: f6.d0
                @Override // java.lang.Runnable
                public final void run() {
                    q0.this.Z2();
                }
            });
        }
    }

    private void W2() {
        if (w6.m.t() && !com.groboot.mdaemergency.a.m(A())) {
            z3(com.groboot.mdaemergency.enums.c.GpsNoPermission);
        } else {
            com.groboot.mdaemergency.a.z(t());
            z3(!s5.d.j().p() ? com.groboot.mdaemergency.enums.c.GpsNotEnabled : s5.d.j().i() ? com.groboot.mdaemergency.enums.c.GpsNotAvailable : com.groboot.mdaemergency.enums.c.NONE);
        }
    }

    private void X2() {
        TextView textView;
        int i10 = 8;
        if (w6.m.t() && l5.a.d(s5.d.j().l())) {
            textView = this.O0;
            i10 = 0;
        } else {
            textView = this.O0;
        }
        textView.setVisibility(i10);
    }

    private void Y2() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[Location]");
        sb2.append(this.f9555a1);
        AppUser k10 = w6.m.k();
        if (k10 == null) {
            return;
        }
        x3(!com.groboot.mdaemergency.a.m(A()) ? com.groboot.mdaemergency.enums.b.NOT_AVAILABLE : k10.getLocation().getStatusAvailability());
        this.I0.setVisibility(8);
        W2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z2() {
        ShortcutButtons shortcutButtons = new ShortcutButtons(A());
        this.S0 = shortcutButtons;
        if (this.X0 != com.groboot.mdaemergency.enums.a.POC) {
            shortcutButtons.sortByShortcutId(w6.m.L());
            if (this.S0.isEmpty() && com.groboot.mdaemergency.async.d.v().f7635e != null) {
                this.S0.updateShortcut(com.groboot.mdaemergency.async.d.v().f7635e.subList(0, 5));
            }
        }
        H3();
        c6.e eVar = new c6.e(A(), this.S0);
        this.W0 = eVar;
        this.P0.setAdapter((ListAdapter) eVar);
        this.P0.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: f6.m0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                q0.this.b3(adapterView, view, i10, j10);
            }
        });
        this.P0.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: f6.n0
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView adapterView, View view, int i10, long j10) {
                boolean c32;
                c32 = q0.this.c3(adapterView, view, i10, j10);
                return c32;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a3(com.groboot.mdaemergency.enums.b bVar) {
        ShortcutButtons shortcutButtons = new ShortcutButtons(A());
        this.S0 = shortcutButtons;
        shortcutButtons.sortByShortcutId(w6.m.L());
        c6.e eVar = new c6.e(A(), this.S0);
        this.W0 = eVar;
        this.P0.setAdapter((ListAdapter) eVar);
        P2(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b3(AdapterView adapterView, View view, int i10, long j10) {
        Feature feature = this.S0.get(i10);
        if (feature.FeatureType == Feature.eFeatureType.Disabled.getId()) {
            return;
        }
        if (feature.FeatureType == Feature.eFeatureType.Availability.getId()) {
            d6.t.C2(t(), new t.c() { // from class: f6.b0
                @Override // d6.t.c
                public final void a(com.groboot.mdaemergency.enums.b bVar) {
                    q0.this.a3(bVar);
                }
            });
        } else if (feature.FeatureType == Feature.eFeatureType.Bike.getId()) {
            C3();
        } else {
            ((MainActivity) t()).s(this.S0.get(i10), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean c3(AdapterView adapterView, View view, int i10, long j10) {
        G3();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d3(boolean z10) {
        W2();
        J3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e3(View view) {
        AppUser k10 = w6.m.k();
        if (w6.m.O().getTrackingType() != b.a.SLEEPY) {
            return;
        }
        B3(k10.getLocation().getStatusAvailability(), k10.getLocation(w6.m.O()).getAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f3(View view) {
        ((MainActivity) t()).h1(new s2(true), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g3(View view) {
        A().startActivity(new Intent(this.V0.getAction()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h3(String str) {
        com.groboot.mdaemergency.async.d.v().B(t(), str, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i3(Message message, b.a aVar) {
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
            this.f9556b1.n(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j3(View view) {
        k3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l3(View view) {
        this.C0.zoomIn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m3(View view) {
        this.C0.zoomOut();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n3(com.groboot.mdaemergency.enums.b bVar, AppUser.Location location) {
        w3(bVar, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p3(OnCallParameterAnswer onCallParameterAnswer) {
        if (onCallParameterAnswer == null || !onCallParameterAnswer.Success) {
            return;
        }
        h2.D2(t(), onCallParameterAnswer.Result, new h2.c() { // from class: f6.c0
            @Override // f6.h2.c
            public final void a() {
                q0.this.o3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q3(final OnCallParameterAnswer onCallParameterAnswer) {
        if (m0()) {
            t().runOnUiThread(new Runnable() { // from class: f6.e0
                @Override // java.lang.Runnable
                public final void run() {
                    q0.this.p3(onCallParameterAnswer);
                }
            });
        }
    }

    private void r3(final String str) {
        for (Message message : this.Q0) {
            w6.e.a("eventid " + message.MessageID + " id " + str);
            if (message.MessageID.equals(str)) {
                if (message.HtmlType == 3) {
                    s3(message);
                    return;
                } else {
                    this.f9556b1.n(message);
                    return;
                }
            }
        }
        new Thread(new Runnable() { // from class: f6.f0
            @Override // java.lang.Runnable
            public final void run() {
                q0.this.h3(str);
            }
        }).start();
    }

    private b.g t3() {
        return new i(this);
    }

    private void v3() {
        this.U0 = m0.a.b(A());
        this.U0.c(this.f9557c1, new IntentFilter("com.groboot.mdaemergency.CHANGE_STATUS"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w3(com.groboot.mdaemergency.enums.b bVar, boolean z10) {
        this.I0.setVisibility(0);
        this.E0.setEnabled(false);
        s5.d.j().v(t(), bVar, z10, new h(bVar));
    }

    public void A3(List<Event> list, List<Message> list2) {
        ArrayList arrayList = new ArrayList();
        this.R0 = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        ArrayList arrayList2 = new ArrayList();
        this.Q0 = arrayList2;
        if (list2 != null) {
            arrayList2.addAll(list2);
        }
    }

    public void C3() {
        com.groboot.mdaemergency.async.d.v().o(new d.r() { // from class: f6.z
            @Override // com.groboot.mdaemergency.async.d.r
            public final void a(OnCallParameterAnswer onCallParameterAnswer) {
                q0.this.q3(onCallParameterAnswer);
            }
        });
    }

    public void F3(String str) {
        r3(str);
    }

    public void G3() {
        new v2(new e()).i2(t().d0(), "shortcutButtons");
    }

    public void J3() {
        boolean z10 = this.X0 == com.groboot.mdaemergency.enums.a.CREW;
        if (s5.d.j() != null) {
            if (s5.d.j().p()) {
                this.E0.setCompoundDrawablesRelativeWithIntrinsicBounds(z10 ? R.drawable.icon_blue_gps : R.drawable.icon_gps, 0, R.drawable.main_drop_down_icon, 0);
            } else {
                this.E0.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.icon_gps_no_signal, 0, R.drawable.main_drop_down_icon, 0);
            }
        }
    }

    public void Q2() {
        this.Y0 = (RelativeLayout) k2(R.id.rl_webView);
        this.Z0 = (RelativeLayout) k2(R.id.rl_content);
        this.Y0.setVisibility(8);
        this.Z0.setVisibility(0);
        com.groboot.mdaemergency.ptt.l lVar = new com.groboot.mdaemergency.ptt.l();
        lVar.c2(b.h.LastUsers);
        lVar.b2(t3());
        j2(lVar, R.id.rl_content);
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void R0() {
        super.R0();
        com.groboot.mdaemergency.async.d.v().X("MainFragment");
        a6.h.c();
        t().unregisterReceiver(this.T0);
    }

    public boolean S2() {
        List<Message> list = this.Q0;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public void T2() {
        Dialog dialog = this.f9562h1;
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public void o3() {
        TextView textView;
        super.o3();
        setTitle(R.string.title_main);
        t().registerReceiver(this.T0, new IntentFilter("com.groboot.mdaemergency.gcm.reseivedMessage"));
        k3();
        FloatViewService.l(t());
        E3();
        X2();
        com.groboot.mdaemergency.async.d.v().g("MainFragment", new d());
        com.groboot.mdaemergency.async.d.v().z();
        int i10 = 8;
        this.F0.setVisibility(8);
        Y2();
        s5.d.j().w(this.f9560f1);
        Device.getActiveDevice(t());
        if (Device.isTC25()) {
            textView = this.M0;
        } else {
            textView = this.M0;
            if (l2.s2(A())) {
                i10 = 0;
            }
        }
        textView.setVisibility(i10);
    }

    @Override // a6.a
    protected void n2() {
        this.X0 = w6.m.m();
        l2(R.layout.main_fragment);
        this.H0 = (ProgressBar) k2(R.id.progress_bar);
        this.I0 = (ProgressBar) k2(R.id.pb_status);
        this.C0 = (WebViewMDA) k2(R.id.messages_list);
        TextView textView = (TextView) k2(R.id.tv_availability);
        this.E0 = textView;
        textView.setOnClickListener(this.f9561g1);
        TextView textView2 = (TextView) k2(R.id.tv_change_address);
        this.F0 = textView2;
        textView2.setOnClickListener(this.f9563i1);
        this.J0 = (SwipeRefreshLayout) k2(R.id.swipe_container);
        this.G0 = k2(R.id.konan_layout);
        this.D0 = (Button) k2(R.id.btn_refresh);
        this.O0 = (TextView) k2(R.id.tv_mockLocation);
        TextView textView3 = (TextView) k2(R.id.tv_gpsNotAvailable);
        this.L0 = textView3;
        textView3.setOnClickListener(this.f9559e1);
        this.A0 = (ImageView) k2(R.id.iv_zoom_plus);
        this.B0 = (ImageView) k2(R.id.iv_zoom_minus);
        this.P0 = (GridView) k2(R.id.gv_buttons);
        this.N0 = (TextView) k2(R.id.tv_shortcutDescription);
        TextView textView4 = (TextView) k2(R.id.tv_missingPermission);
        this.M0 = textView4;
        textView4.setOnClickListener(this.f9558d1);
        com.groboot.mdaemergency.a.f7541c = false;
        this.C0.setClickHandler(this.f9556b1);
        g(false);
        q(false);
        J(true);
        l(false);
        this.D0.setOnClickListener(new View.OnClickListener() { // from class: f6.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q0.this.j3(view);
            }
        });
        V2();
        this.O0.setOnClickListener(new a());
        this.T0 = new b();
        this.J0.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: f6.o0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void a() {
                q0.this.k3();
            }
        });
        this.P0.setVisibility(((w6.l0.m0(t()) && this.X0 != com.groboot.mdaemergency.enums.a.POC) || !this.X0.displayShortcut()) ? 8 : 0);
        this.A0.setOnClickListener(new View.OnClickListener() { // from class: f6.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q0.this.l3(view);
            }
        });
        this.B0.setOnClickListener(new View.OnClickListener() { // from class: f6.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q0.this.m3(view);
            }
        });
        v3();
        if (w6.m.m() == com.groboot.mdaemergency.enums.a.POC) {
            Q2();
        }
    }

    @Override // a6.a
    public void o2() {
    }

    public void s3(final Message message) {
        a6.h.m(t());
        com.groboot.mdaemergency.async.d.v().C(t(), message.MessageID, new b.InterfaceC0098b() { // from class: f6.p0
            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public final void a(b.a aVar) {
                q0.this.i3(message, aVar);
            }
        });
    }

    /* renamed from: u3, reason: merged with bridge method [inline-methods] */
    public void k3() {
        new Date();
        this.D0.setVisibility(8);
        this.H0.setVisibility(S2() ? 8 : 0);
        com.groboot.mdaemergency.async.d.v().D(t());
    }

    @Override // androidx.fragment.app.Fragment
    public void w0(int i10, int i11, Intent intent) {
        super.w0(i10, i11, intent);
        if (i10 == 1) {
        }
    }

    public void x3(com.groboot.mdaemergency.enums.b bVar) {
        if (bVar != com.groboot.mdaemergency.enums.b.NOT_AVAILABLE) {
            this.E0.setTextColor(-16777216);
            this.E0.setText(bVar.getResTitle());
            R2(bVar);
            J3();
            return;
        }
        if (A() != null) {
            this.E0.setTextColor(androidx.core.content.a.d(A(), R.color.red_text));
        }
        this.E0.setCompoundDrawablesWithIntrinsicBounds(R.drawable.main_drop_down_icon, 0, this.X0 == com.groboot.mdaemergency.enums.a.CREW ? R.drawable.icon_blue_gps_no_avilble : R.drawable.icon_gps_no_avilble, 0);
        this.E0.setText(bVar.getResTitle());
    }

    public void y3(WebViewMDA.k kVar) {
        this.f9556b1 = kVar;
        WebViewMDA webViewMDA = this.C0;
        if (webViewMDA != null) {
            webViewMDA.setClickHandler(kVar);
        }
    }

    public void z3(com.groboot.mdaemergency.enums.c cVar) {
        this.V0 = cVar;
        if (cVar == com.groboot.mdaemergency.enums.c.NONE) {
            this.L0.setVisibility(8);
            return;
        }
        this.L0.setVisibility(0);
        this.L0.setText(cVar.getResId());
        this.L0.setEnabled(cVar.hasAction());
    }
}
