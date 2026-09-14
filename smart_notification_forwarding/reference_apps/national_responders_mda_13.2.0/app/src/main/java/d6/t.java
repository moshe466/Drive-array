package d6;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import c6.b;
import c6.o;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.models.location.ReportLocationParams;
import com.groboot.mdaemergency.ui.views.ClearableAutoCompleteTextView;
import d6.t;
import il.org.mda.health.R;
import s5.d;
import w6.l0;

/* loaded from: classes.dex */
public class t extends androidx.fragment.app.e {
    TextView A0;
    ProgressBar B0;
    ProgressBar C0;
    LinearLayout D0;
    com.groboot.mdaemergency.enums.b E0;
    c F0;
    Activity G0;
    View.OnClickListener H0 = new View.OnClickListener() { // from class: d6.e
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            t.this.u2(view);
        }
    };

    /* renamed from: u0, reason: collision with root package name */
    GridView f8728u0;

    /* renamed from: v0, reason: collision with root package name */
    ConstraintLayout f8729v0;

    /* renamed from: w0, reason: collision with root package name */
    ClearableAutoCompleteTextView f8730w0;

    /* renamed from: x0, reason: collision with root package name */
    String f8731x0;

    /* renamed from: y0, reason: collision with root package name */
    TextView f8732y0;

    /* renamed from: z0, reason: collision with root package name */
    TextView f8733z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements d.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.groboot.mdaemergency.enums.b f8734a;

        a(com.groboot.mdaemergency.enums.b bVar) {
            this.f8734a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o() {
            t.this.E2(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(String str) {
            t.this.E2(false);
            if (str == null || str.isEmpty()) {
                return;
            }
            a6.h.o(t.this.G0, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(com.groboot.mdaemergency.enums.b bVar, DialogInterface dialogInterface, int i10) {
            t.this.z2(bVar, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void r(DialogInterface dialogInterface, int i10) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(int i10, final com.groboot.mdaemergency.enums.b bVar) {
            t.this.E2(false);
            l0.G0(t.this.A(), i10, R.string.try_again, R.string.cancel, new DialogInterface.OnClickListener() { // from class: d6.m
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    t.a.this.q(bVar, dialogInterface, i11);
                }
            }, new DialogInterface.OnClickListener() { // from class: d6.n
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    t.a.r(dialogInterface, i11);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(DialogInterface dialogInterface, int i10) {
            d("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(DialogInterface dialogInterface, int i10) {
            a("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(com.groboot.mdaemergency.enums.b bVar) {
            l0.I0(t.this.G0, t.this.e0(R.string.location_doesnot_match_address) + " " + bVar.getTitle(), t.this.e0(R.string.is_want_update_address_for_status) + " " + bVar.getTitle() + "?", R.string.changeAddress, R.string.cancel, new DialogInterface.OnClickListener() { // from class: d6.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    t.a.this.t(dialogInterface, i10);
                }
            }, new DialogInterface.OnClickListener() { // from class: d6.k
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    t.a.this.u(dialogInterface, i10);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w() {
            t.this.E2(false);
            t tVar = t.this;
            c cVar = tVar.F0;
            if (cVar != null) {
                cVar.a(tVar.E0);
            }
            if (t.this.Z1() == null || !t.this.Z1().isShowing()) {
                return;
            }
            t.this.X1();
        }

        @Override // s5.d.g
        public void a(final String str) {
            l0.x0(new l0.g() { // from class: d6.s
                @Override // w6.l0.g
                public final void run() {
                    t.a.this.p(str);
                }
            });
        }

        @Override // s5.d.g
        public void b() {
            final com.groboot.mdaemergency.enums.b bVar = this.f8734a;
            l0.x0(new l0.g() { // from class: d6.r
                @Override // w6.l0.g
                public final void run() {
                    t.a.this.v(bVar);
                }
            });
        }

        @Override // s5.d.g
        public void c(final int i10) {
            final com.groboot.mdaemergency.enums.b bVar = this.f8734a;
            l0.x0(new l0.g() { // from class: d6.q
                @Override // w6.l0.g
                public final void run() {
                    t.a.this.s(i10, bVar);
                }
            });
        }

        @Override // s5.d.g
        public void d(String str) {
            l0.x0(new l0.g() { // from class: d6.p
                @Override // w6.l0.g
                public final void run() {
                    t.a.this.o();
                }
            });
        }

        @Override // s5.d.g
        public void e() {
            if (t.this.t() == null) {
                return;
            }
            l0.x0(new l0.g() { // from class: d6.o
                @Override // w6.l0.g
                public final void run() {
                    t.a.this.w();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements d.e {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(b.a aVar) {
            t.this.C0.setVisibility(8);
            if (aVar == null || !aVar.f7614b) {
                Toast.makeText(t.this.G0, R.string.try_again, 0);
                return;
            }
            ReportLocationParams reportLocationParams = (ReportLocationParams) new com.google.gson.e().i(aVar.e("Location"), ReportLocationParams.class);
            t.this.f8731x0 = reportLocationParams.Street + ", " + reportLocationParams.City;
            t tVar = t.this;
            tVar.B2(tVar.f8730w0, tVar.f8731x0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Location location, String str, Location location2) {
            if (str == null) {
                com.groboot.mdaemergency.async.d.v().A(new ReportLocationParams(location), new b.InterfaceC0098b() { // from class: d6.u
                    @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                    public final void a(b.a aVar) {
                        t.b.this.e(aVar);
                    }
                });
                return;
            }
            t.this.C0.setVisibility(8);
            t tVar = t.this;
            tVar.f8731x0 = str;
            tVar.B2(tVar.f8730w0, str);
        }

        @Override // s5.d.e
        public void a(Location location) {
        }

        @Override // s5.d.e
        public void b(final Location location) {
            w6.o.a(t.this.A(), location, new o5.e() { // from class: d6.v
                @Override // o5.e
                public final void a(String str, Location location2) {
                    t.b.this.f(location, str, location2);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(com.groboot.mdaemergency.enums.b bVar);
    }

    private void A2() {
        this.C0.setVisibility(0);
        s5.d.j().g(this.G0, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B2(AutoCompleteTextView autoCompleteTextView, String str) {
        c6.o oVar = (c6.o) autoCompleteTextView.getAdapter();
        autoCompleteTextView.setAdapter(null);
        autoCompleteTextView.setText(str);
        autoCompleteTextView.setAdapter(oVar);
        autoCompleteTextView.setSelection(autoCompleteTextView.getText().length());
    }

    public static void C2(androidx.fragment.app.j jVar, c cVar) {
        if (com.groboot.mdaemergency.a.m(jVar)) {
            try {
                t tVar = new t();
                tVar.i2(jVar.d0(), "StatusAvailabilityDialog");
                tVar.F0 = cVar;
            } catch (IllegalStateException unused) {
            }
        }
    }

    private void D2() {
        boolean m02 = w6.m.m() == com.groboot.mdaemergency.enums.a.POC ? true : l0.m0(this.G0);
        this.f8733z0.setVisibility(m02 ? 8 : 0);
        this.A0.setTextSize(2, m02 ? 16.0f : 18.0f);
        WindowManager.LayoutParams attributes = Z1().getWindow().getAttributes();
        ((ViewGroup.LayoutParams) attributes).width = l0.W0(A(), m02 ? 300 : 350);
        ((ViewGroup.LayoutParams) attributes).height = -2;
        Z1().getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E2(boolean z10) {
        this.B0.setVisibility(z10 ? 0 : 8);
        this.D0.setEnabled(!z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t2(int i10) {
        if (i10 != 0 || this.f8730w0.length() <= 0) {
            return;
        }
        this.f8730w0.setText(this.f8730w0.getText().toString().substring(0, r4.length() - 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u2(View view) {
        z2(this.E0, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v2(View view) {
        W1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w2(com.groboot.mdaemergency.enums.b bVar) {
        this.E0 = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x2(View view) {
        A2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y2(com.groboot.mdaemergency.enums.b bVar, boolean z10) {
        s5.d.j().v(this.G0, bVar, z10, new a(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z2(final com.groboot.mdaemergency.enums.b bVar, final boolean z10) {
        E2(true);
        new Thread(new Runnable() { // from class: d6.j
            @Override // java.lang.Runnable
            public final void run() {
                t.this.y2(bVar, z10);
            }
        }).start();
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_status_availability, viewGroup, false);
        if (Z1() != null && Z1().getWindow() != null) {
            Z1().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            Z1().getWindow().requestFeature(1);
        }
        this.f8728u0 = (GridView) inflate.findViewById(R.id.grd_items);
        this.f8729v0 = (ConstraintLayout) inflate.findViewById(R.id.cl_enterAddress);
        this.f8730w0 = (ClearableAutoCompleteTextView) inflate.findViewById(R.id.autocomplete);
        this.B0 = (ProgressBar) inflate.findViewById(R.id.pb_save);
        this.C0 = (ProgressBar) inflate.findViewById(R.id.pb_getLocation);
        this.f8733z0 = (TextView) inflate.findViewById(R.id.choose_status_explanation);
        this.A0 = (TextView) inflate.findViewById(R.id.choose_status);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_save);
        this.D0 = linearLayout;
        linearLayout.setOnClickListener(this.H0);
        inflate.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() { // from class: d6.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.this.v2(view);
            }
        });
        this.E0 = w6.m.k().getLocation().getStatusAvailability();
        this.f8728u0.setAdapter((ListAdapter) new c6.b(A(), this.E0, new b.a() { // from class: d6.h
            @Override // c6.b.a
            public final void a(com.groboot.mdaemergency.enums.b bVar) {
                t.this.w2(bVar);
            }
        }));
        s2();
        TextView textView = (TextView) inflate.findViewById(R.id.tv_userLocation);
        this.f8732y0 = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: d6.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.this.x2(view);
            }
        });
        this.f8729v0.setVisibility(8);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        D2();
    }

    public void s2() {
        c6.o oVar = new c6.o(A(), R.layout.autocomplete_list_item);
        oVar.f4447i = new o.b() { // from class: d6.i
            @Override // c6.o.b
            public final void a(int i10) {
                t.this.t2(i10);
            }
        };
        this.f8730w0.setAdapter(oVar);
        this.f8730w0.setThreshold(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void x0(Activity activity) {
        super.x0(activity);
        this.G0 = activity;
    }
}
