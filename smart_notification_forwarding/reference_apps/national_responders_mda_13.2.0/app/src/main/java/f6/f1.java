package f6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.async.d;
import com.groboot.mdaemergency.models.AppUser;
import com.groboot.mdaemergency.models.Feature;
import com.groboot.mdaemergency.models.OnCallParameterAnswer;
import com.groboot.mdaemergency.models.poc.Device;
import d6.t;
import f6.h2;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f1 extends Fragment {

    /* renamed from: e0, reason: collision with root package name */
    View f9483e0;

    /* renamed from: f0, reason: collision with root package name */
    GridView f9484f0;

    /* renamed from: g0, reason: collision with root package name */
    public DrawerLayout f9485g0;

    /* renamed from: h0, reason: collision with root package name */
    public LinearLayout f9486h0;

    /* renamed from: i0, reason: collision with root package name */
    b f9487i0;

    /* renamed from: j0, reason: collision with root package name */
    c6.m f9488j0;

    /* renamed from: k0, reason: collision with root package name */
    com.groboot.mdaemergency.enums.a f9489k0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9490a;

        static {
            int[] iArr = new int[Feature.eFeatureType.values().length];
            f9490a = iArr;
            try {
                iArr[Feature.eFeatureType.Home.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9490a[Feature.eFeatureType.Bike.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9490a[Feature.eFeatureType.Settings.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9490a[Feature.eFeatureType.Availability.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9490a[Feature.eFeatureType.WhatApp.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void c();

        void j(Feature feature);

        void k();

        void s(Feature feature, boolean z10);

        void y();
    }

    private void X1() {
        if (com.groboot.mdaemergency.a.m(A())) {
            d6.t.C2(t(), new t.c() { // from class: f6.d1
                @Override // d6.t.c
                public final void a(com.groboot.mdaemergency.enums.b bVar) {
                    f1.this.c2(bVar);
                }
            });
        }
    }

    private void Y1() {
        com.groboot.mdaemergency.async.d.v().o(new d.r() { // from class: f6.c1
            @Override // com.groboot.mdaemergency.async.d.r
            public final void a(OnCallParameterAnswer onCallParameterAnswer) {
                f1.this.e2(onCallParameterAnswer);
            }
        });
    }

    private void Z1(com.groboot.mdaemergency.enums.b bVar) {
        r5.a.a().h(A(), bVar);
    }

    private ArrayList<Feature> a2() {
        if (!m0()) {
            return null;
        }
        ArrayList<Feature> arrayList = new ArrayList<>();
        arrayList.add(new Feature(e0(R.string.main_screen), 1, Feature.eFeatureType.Home));
        if (w6.m.t() && !Device.isTC25()) {
            arrayList.add(b2());
        }
        arrayList.add(new Feature(e0(R.string.settings), 2, Feature.eFeatureType.Settings));
        if (w6.m.m() == com.groboot.mdaemergency.enums.a.POC) {
            arrayList.add(new Feature(e0(R.string.event_log), 29, Feature.eFeatureType.Events));
        }
        List<Feature> list = com.groboot.mdaemergency.async.d.v().f7635e;
        if (list != null) {
            arrayList.addAll(list);
        }
        if (this.f9489k0 == com.groboot.mdaemergency.enums.a.MADA) {
            arrayList.add(new Feature(e0(R.string.report_isolation), 100, Feature.eFeatureType.ReportCovidIsolation));
            arrayList.add(new Feature(e0(R.string.whats_new), 90, Feature.eFeatureType.WhatsNew));
            arrayList.add(new Feature(e0(R.string.corona_barcode), 91, Feature.eFeatureType.CoronaBarcode));
            arrayList.add(new Feature("מדפסת זברה", 93, Feature.eFeatureType.PrintCoronaBarcode));
        }
        arrayList.add(new Feature(e0(R.string.logout), 99));
        return arrayList;
    }

    private Feature b2() {
        AppUser k10 = w6.m.k();
        if (k10 == null) {
            return null;
        }
        com.groboot.mdaemergency.enums.b statusAvailability = !com.groboot.mdaemergency.a.m(A()) ? com.groboot.mdaemergency.enums.b.NOT_AVAILABLE : k10.getLocation().getStatusAvailability();
        return new Feature(statusAvailability.getTitle(), statusAvailability.getNum(), Feature.eFeatureType.Availability);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(com.groboot.mdaemergency.enums.b bVar) {
        h2(a2());
        Z1(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2(OnCallParameterAnswer onCallParameterAnswer) {
        if (onCallParameterAnswer == null || !onCallParameterAnswer.Success) {
            return;
        }
        h2.D2(t(), onCallParameterAnswer.Result, new h2.c() { // from class: f6.e1
            @Override // f6.h2.c
            public final void a() {
                f1.d2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2(AdapterView adapterView, View view, int i10, long j10) {
        ArrayList<Feature> a22 = a2();
        if (a22 == null) {
            return;
        }
        boolean z10 = true;
        if (a22.size() - 1 == i10) {
            this.f9487i0.c();
        }
        Feature feature = a22.get(i10);
        Feature.eFeatureType byId = feature != null ? Feature.eFeatureType.getById(feature.FeatureType) : null;
        if (byId != null) {
            int i11 = a.f9490a[byId.ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    Y1();
                } else if (i11 == 3) {
                    this.f9487i0.y();
                } else if (i11 == 4) {
                    X1();
                } else if (i11 == 5) {
                    this.f9487i0.j(a22.get(i10));
                }
                z10 = false;
            } else {
                this.f9487i0.k();
            }
            if (z10 || !this.f9485g0.A(this.f9486h0)) {
            }
            this.f9485g0.d(this.f9486h0);
            return;
        }
        g2(a22.get(i10));
        if (z10) {
        }
    }

    private void g2(Feature feature) {
        this.f9487i0.s(feature, true);
        if (feature.Close == Feature.eClose.CloseMenue.toInt()) {
            k2();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f9489k0 = w6.m.m();
        View inflate = layoutInflater.inflate(R.layout.fragment_menu, viewGroup, false);
        this.f9483e0 = inflate;
        this.f9484f0 = (GridView) inflate.findViewById(R.id.lv_items);
        DrawerLayout drawerLayout = (DrawerLayout) t().findViewById(R.id.drawer_layout);
        this.f9485g0 = drawerLayout;
        drawerLayout.O(R.drawable.drawer_shadow, 8388611);
        this.f9486h0 = (LinearLayout) t().findViewById(R.id.drawerContent);
        this.f9484f0.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: f6.b1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                f1.this.f2(adapterView, view, i10, j10);
            }
        });
        return this.f9483e0;
    }

    public void h2(ArrayList<Feature> arrayList) {
        if (arrayList != null) {
            c6.m mVar = new c6.m(t(), arrayList);
            this.f9488j0 = mVar;
            this.f9484f0.setAdapter((ListAdapter) mVar);
        }
    }

    public void i2(b bVar) {
        this.f9487i0 = bVar;
    }

    public void j2(androidx.fragment.app.j jVar, int i10) {
        androidx.fragment.app.f0 o10 = jVar.d0().o();
        o10.o(i10, this);
        o10.h();
    }

    public void k2() {
        if (this.f9485g0.A(this.f9486h0)) {
            this.f9485g0.d(this.f9486h0);
        } else {
            h2(a2());
            this.f9485g0.G(this.f9486h0);
        }
    }
}
