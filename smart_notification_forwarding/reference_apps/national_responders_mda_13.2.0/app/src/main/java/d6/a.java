package d6;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import c6.o;
import com.google.android.gms.maps.model.LatLng;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.AppUser;
import com.groboot.mdaemergency.models.location.ReportLocationParams;
import com.groboot.mdaemergency.ui.views.ClearableAutoCompleteTextView;
import d6.a;
import il.org.mda.health.R;
import s5.d;
import w6.l0;

@SuppressLint({"ValidFragment"})
/* loaded from: classes.dex */
public class a extends androidx.fragment.app.e {
    Context A0;
    Activity B0;
    View C0;

    /* renamed from: u0, reason: collision with root package name */
    f f8670u0;

    /* renamed from: v0, reason: collision with root package name */
    com.groboot.mdaemergency.enums.b f8671v0;

    /* renamed from: w0, reason: collision with root package name */
    String f8672w0;

    /* renamed from: x0, reason: collision with root package name */
    ClearableAutoCompleteTextView f8673x0;

    /* renamed from: y0, reason: collision with root package name */
    ProgressBar f8674y0;

    /* renamed from: z0, reason: collision with root package name */
    ProgressBar f8675z0;

    /* renamed from: d6.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0142a implements o.b {
        C0142a() {
        }

        @Override // c6.o.b
        public void a(int i10) {
            if (i10 != 0 || a.this.f8673x0.length() <= 0) {
                return;
            }
            a.this.f8673x0.setText(a.this.f8673x0.getText().toString().substring(0, r4.length() - 1));
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnClickListener {

        /* renamed from: d6.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0143a implements b.InterfaceC0098b {
            C0143a() {
            }

            @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
            public void a(b.a aVar) {
                if (aVar == null) {
                    return;
                }
                if (!aVar.f7614b) {
                    a aVar2 = a.this;
                    a6.h.o(aVar2.B0, aVar2.e0(R.string.unhandled_address));
                    return;
                }
                ReportLocationParams reportLocationParams = (ReportLocationParams) new com.google.gson.e().i(aVar.e("Location"), ReportLocationParams.class);
                Location location = new Location("");
                location.setLatitude(reportLocationParams.Lat);
                location.setLongitude(reportLocationParams.Lon);
                a.this.m2(location);
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f8673x0.length() == 0) {
                a aVar = a.this;
                a6.h.o(aVar.B0, aVar.e0(R.string.address_must_specified));
                return;
            }
            String obj = a.this.f8673x0.getText().toString();
            LatLng b10 = w6.o.b(a.this.A(), obj);
            if (b10 == null || b10.f5781f == 0.0d) {
                com.groboot.mdaemergency.async.d.v().l(obj, new C0143a());
                return;
            }
            Location location = new Location("");
            location.setLatitude(b10.f5781f);
            location.setLongitude(b10.f5782g);
            a.this.m2(location);
        }
    }

    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.n2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements d.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Location f8680a;

        d(Location location) {
            this.f8680a = location;
        }

        @Override // s5.d.e
        public void a(Location location) {
        }

        @Override // s5.d.e
        public void b(Location location) {
            a aVar;
            Activity activity;
            a.this.f8675z0.setVisibility(8);
            if (location == null && (activity = (aVar = a.this).B0) != null) {
                a6.h.o(activity, aVar.Y().getString(R.string.placement_failed));
                return;
            }
            if (this.f8680a.distanceTo(location) > a.this.f8671v0.getDistance()) {
                a aVar2 = a.this;
                a6.h.o(aVar2.B0, aVar2.Y().getString(R.string.incorrect_address));
                a.this.f8673x0.setText("");
                return;
            }
            AppUser k10 = w6.m.k();
            AppUser.Location location2 = new AppUser.Location();
            location2.setAddress(a.this.f8673x0.getText().toString());
            location2.setLat(this.f8680a.getLatitude());
            location2.setLon(this.f8680a.getLongitude());
            k10.setLocation(a.this.f8671v0, location2);
            w6.m.U(k10);
            if (!l0.l(a.this.f8673x0.getText().toString(), location2.getAddress())) {
                a.this.f8673x0.setText(location2.getAddress());
                return;
            }
            a aVar3 = a.this;
            aVar3.f8670u0.a(aVar3.f8671v0, location2);
            a.this.W1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements d.e {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(b.a aVar) {
            if (aVar == null || !aVar.f7614b) {
                return;
            }
            ReportLocationParams reportLocationParams = (ReportLocationParams) new com.google.gson.e().i(aVar.e("Location"), ReportLocationParams.class);
            a.this.f8672w0 = reportLocationParams.Street + ", " + reportLocationParams.City;
            a aVar2 = a.this;
            aVar2.o2(aVar2.f8673x0, aVar2.f8672w0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Location location, String str, Location location2) {
            if (str == null) {
                com.groboot.mdaemergency.async.d.v().A(new ReportLocationParams(location), new b.InterfaceC0098b() { // from class: d6.b
                    @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                    public final void a(b.a aVar) {
                        a.e.this.e(aVar);
                    }
                });
                return;
            }
            a aVar = a.this;
            aVar.f8672w0 = str;
            aVar.o2(aVar.f8673x0, str);
        }

        @Override // s5.d.e
        public void a(Location location) {
        }

        @Override // s5.d.e
        public void b(final Location location) {
            a.this.f8674y0.setVisibility(8);
            w6.o.a(a.this.A(), location, new o5.e() { // from class: d6.c
                @Override // o5.e
                public final void a(String str, Location location2) {
                    a.e.this.f(location, str, location2);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(com.groboot.mdaemergency.enums.b bVar, AppUser.Location location);
    }

    /* loaded from: classes.dex */
    private class g {
        g(a aVar) {
        }
    }

    public a() {
    }

    public a(com.groboot.mdaemergency.enums.b bVar, String str, f fVar) {
        this.f8670u0 = fVar;
        this.f8671v0 = bVar;
        this.f8672w0 = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m2(Location location) {
        this.f8675z0.setVisibility(0);
        s5.d.j().g(this.B0, new d(location));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2() {
        this.f8674y0.setVisibility(0);
        s5.d.j().g(this.B0, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o2(AutoCompleteTextView autoCompleteTextView, String str) {
        c6.o oVar = (c6.o) autoCompleteTextView.getAdapter();
        autoCompleteTextView.setAdapter(null);
        autoCompleteTextView.setText(str);
        autoCompleteTextView.setAdapter(oVar);
        autoCompleteTextView.setSelection(autoCompleteTextView.getText().length());
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(this.A0).inflate(R.layout.set_address_dialog, (ViewGroup) null, false);
        this.C0 = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.address_title);
        new g(this);
        this.f8673x0 = (ClearableAutoCompleteTextView) this.C0.findViewById(R.id.autocomplete);
        c6.o oVar = new c6.o(this.A0, R.layout.autocomplete_list_item);
        oVar.f4447i = new C0142a();
        this.f8673x0.setAdapter(oVar);
        this.f8673x0.setThreshold(1);
        this.f8674y0 = (ProgressBar) this.C0.findViewById(R.id.pb_getLocation);
        this.f8675z0 = (ProgressBar) this.C0.findViewById(R.id.pb_save);
        textView.setText(e0(R.string.set_address_title_other));
        o2(this.f8673x0, this.f8672w0);
        ((LinearLayout) this.C0.findViewById(R.id.save_address)).setOnClickListener(new b());
        ((TextView) this.C0.findViewById(R.id.tv_current_place)).setOnClickListener(new c());
        return this.C0;
    }

    @Override // androidx.fragment.app.Fragment
    public void x0(Activity activity) {
        super.x0(activity);
        this.B0 = activity;
    }

    @Override // androidx.fragment.app.e, androidx.fragment.app.Fragment
    public void y0(Context context) {
        super.y0(context);
        this.A0 = context;
    }
}
