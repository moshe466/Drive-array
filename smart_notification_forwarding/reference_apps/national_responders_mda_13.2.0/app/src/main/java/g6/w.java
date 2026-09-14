package g6;

import android.app.ProgressDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.ExpoDescriptionFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.ExposureLocationFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.SetIsolationPeriodButtonFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views.SaveCancelFormView;
import g6.w;
import il.org.mda.health.R;
import java.util.Calendar;
import java.util.Date;
import p6.d;

/* loaded from: classes.dex */
public class w extends a6.a {
    private final p6.f A0 = new p6.f();
    private SaveCancelFormView B0;
    private SetIsolationPeriodButtonFragment C0;
    private ProgressDialog D0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements o6.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f9897a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Button f9898b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LinearLayout f9899c;

        a(TextView textView, Button button, LinearLayout linearLayout) {
            this.f9897a = textView;
            this.f9898b = button;
            this.f9899c = linearLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(TextView textView, b.a aVar) {
            if (!aVar.f7614b) {
                w.this.E2(false);
                Toast.makeText(w.this.A(), w.this.g0(R.string.an_error_occurred), 0).show();
                return;
            }
            w.this.E2(false);
            textView.setVisibility(8);
            w.this.A0.i(Integer.parseInt(aVar.a().getResult()));
            i6.b.f().c(w.this.A0);
            Toast.makeText(w.this.A(), w.this.g0(R.string.positive_result_added_text), 0).show();
            w.this.o(new i(), true);
        }

        @Override // o6.f
        public void a() {
            this.f9898b.setEnabled(true);
            this.f9899c.setVisibility(8);
        }

        @Override // o6.f
        public void b() {
            w.this.E2(true);
            if (w.this.A2()) {
                i6.a aVar = new i6.a(j6.a.ADD_VERIFIED_PATIENT, w.this.A0);
                final TextView textView = this.f9897a;
                aVar.d(new b.InterfaceC0098b() { // from class: g6.v
                    @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                    public final void a(b.a aVar2) {
                        w.a.this.d(textView, aVar2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            w.this.A0.f(charSequence.toString());
            w.this.F2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            w.this.A0.g(charSequence.toString());
            w.this.F2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements o6.g {
        d() {
        }

        @Override // o6.g
        public void a(boolean z10) {
        }

        @Override // o6.g
        public void b(Date date, Date date2) {
            w.this.A0.j(new p6.c(date, date2));
            w.this.F2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A2() {
        boolean z10;
        boolean z11 = (this.A0.e() == null || !this.A0.e().before(new Date()) || this.A0.a() == null || this.A0.a().equals("")) ? false : true;
        if (this.A0.c() != null) {
            d.a c10 = this.A0.c();
            d.a aVar = d.a.OTHER;
            if (c10 != aVar || (this.A0.c() == aVar && this.A0.b() != null && !this.A0.b().equals(""))) {
                z10 = true;
                return !z11 && z10 && (this.A0.d() == null && w2(this.A0.d().b(), this.A0.d().a()));
            }
        }
        z10 = false;
        if (z11) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B2(int i10, int i11, int i12, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i10);
        calendar.set(2, i11);
        calendar.set(5, i12);
        this.A0.k(calendar.getTime());
        F2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C2(d.a aVar) {
        this.A0.h(aVar);
        F2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D2(LinearLayout linearLayout, Button button, View view) {
        if (linearLayout.getVisibility() == 8) {
            linearLayout.setVisibility(0);
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
            linearLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E2(boolean z10) {
        this.B0.setEnabled(!z10);
        if (!z10) {
            this.D0.dismiss();
            return;
        }
        this.D0.setCancelable(false);
        this.D0.setMessage(g0(R.string.loading));
        this.D0.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F2() {
        this.B0.setSaveEnabled(A2());
    }

    private boolean w2(Date date, Date date2) {
        return (date == null || date2 == null || !date.before(date2)) ? false : true;
    }

    private void x2() {
        ExpoDescriptionFragment expoDescriptionFragment = (ExpoDescriptionFragment) z().h0(R.id.frg_pos_exposure_description);
        if (expoDescriptionFragment != null) {
            expoDescriptionFragment.X1(new o6.d() { // from class: g6.t
                @Override // o6.d
                public final void a(int i10, int i11, int i12, String str) {
                    w.this.B2(i10, i11, i12, str);
                }
            });
            expoDescriptionFragment.V1(new b());
        }
    }

    private void y2() {
        SetIsolationPeriodButtonFragment setIsolationPeriodButtonFragment = this.C0;
        if (setIsolationPeriodButtonFragment != null) {
            setIsolationPeriodButtonFragment.d2(new d());
        }
    }

    private void z2() {
        ExposureLocationFragment exposureLocationFragment = (ExposureLocationFragment) z().h0(R.id.frg_pos_exposure_location);
        if (exposureLocationFragment != null) {
            exposureLocationFragment.Y1(new o6.e() { // from class: g6.u
                @Override // o6.e
                public final void a(d.a aVar) {
                    w.this.C2(aVar);
                }
            });
            exposureLocationFragment.X1(new c());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void G0() {
        this.D0.dismiss();
        super.G0();
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        SetIsolationPeriodButtonFragment setIsolationPeriodButtonFragment = (SetIsolationPeriodButtonFragment) z().h0(R.id.frg_pos_set_isolation_period);
        this.C0 = setIsolationPeriodButtonFragment;
        if (setIsolationPeriodButtonFragment != null) {
            setIsolationPeriodButtonFragment.e2(true);
        }
        ExpoDescriptionFragment expoDescriptionFragment = (ExpoDescriptionFragment) z().h0(R.id.frg_pos_exposure_description);
        if (expoDescriptionFragment != null) {
            expoDescriptionFragment.W1(true);
        }
        x2();
        y2();
        z2();
    }

    @Override // a6.a
    public void n2() {
        super.B0(this.f307x0);
        l2(R.layout.fragment_report_positive_covid_result);
        setTitle(R.string.report_positive_result_title);
        final LinearLayout linearLayout = (LinearLayout) k2(R.id.linv_add_positive_report_form);
        RecyclerView recyclerView = (RecyclerView) k2(R.id.rcv_positive_reports_history);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(A(), 1, false);
        h6.f fVar = new h6.f((p6.f[]) i6.b.f().g().toArray(new p6.f[0]));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.m0();
        recyclerView.setAdapter(fVar);
        this.D0 = new ProgressDialog(A());
        final Button button = (Button) k2(R.id.btn_add_positive_report);
        button.setOnClickListener(new View.OnClickListener() { // from class: g6.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                w.D2(linearLayout, button, view);
            }
        });
        TextView textView = (TextView) k2(R.id.txv_no_isolation_history);
        if (i6.b.f().g().size() == 0) {
            textView.setVisibility(0);
            recyclerView.setVisibility(8);
        } else {
            textView.setVisibility(8);
            recyclerView.setVisibility(0);
        }
        SaveCancelFormView saveCancelFormView = (SaveCancelFormView) k2(R.id.scf_save_cancel_pos_form);
        this.B0 = saveCancelFormView;
        saveCancelFormView.setSaveEnabled(false);
        this.B0.setOnSaveCancelListener(new a(textView, button, linearLayout));
    }

    @Override // a6.a
    public void o2() {
    }
}
