package g6;

import android.app.ProgressDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.groboot.mdaemergency.async.b;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.absent_from_work.AbsenceOptionsFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.absent_from_work.SelectAbsentFromWorkFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.absent_from_work.WorkAbsenceRangeFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.ExpoDescriptionFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.ExposureLocationFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.FamilyMemberAgeGroupFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.FamilyMemberIsolationConfirmationFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.FamilyMemberIsolationPeriodFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.SetIsolationPeriodButtonFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views.SaveCancelFormView;
import g6.q;
import il.org.mda.health.R;
import java.util.Calendar;
import java.util.Date;
import o6.a;
import p6.a;
import p6.d;
import p6.e;

/* loaded from: classes.dex */
public class q extends a6.a {
    private final p6.d A0 = new p6.d();
    private final p6.e B0 = new p6.e();
    private final p6.a C0 = new p6.a();
    private ProgressDialog D0;
    private SaveCancelFormView E0;

    /* loaded from: classes.dex */
    class a implements AdapterView.OnItemSelectedListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LinearLayout f9880f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ LinearLayout f9881g;

        a(LinearLayout linearLayout, LinearLayout linearLayout2) {
            this.f9880f = linearLayout;
            this.f9881g = linearLayout2;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
            p6.d dVar;
            p6.e eVar;
            if (i10 != 0) {
                if (i10 == 1) {
                    this.f9880f.setVisibility(0);
                    this.f9881g.setVisibility(8);
                    q.this.A0.m(d.b.FAMILY_MEMBER);
                    dVar = q.this.A0;
                    eVar = q.this.B0;
                }
                q.this.Y2();
            }
            this.f9880f.setVisibility(8);
            this.f9881g.setVisibility(0);
            q.this.A0.m(d.b.PATIENT);
            dVar = q.this.A0;
            eVar = null;
            dVar.n(eVar);
            q.this.Y2();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements o6.f {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(p6.d dVar, b.a aVar) {
            String str = aVar.f7616d;
            if (!aVar.f7614b) {
                Toast.makeText(q.this.A(), q.this.g0(R.string.an_error_occurred), 0).show();
                q.this.X2(false);
                return;
            }
            dVar.o(Integer.parseInt(aVar.a().getResult()));
            i6.b.f().b(dVar);
            Toast.makeText(q.this.A(), q.this.g0(R.string.exposure_added_text), 0).show();
            q.this.X2(false);
            q.this.E2();
        }

        @Override // o6.f
        public void a() {
            q.this.E2();
        }

        @Override // o6.f
        public void b() {
            if (q.this.M2()) {
                q.this.X2(true);
                final p6.d dVar = q.this.A0;
                dVar.h(q.this.C0);
                dVar.n(q.this.A0.e() == d.b.FAMILY_MEMBER ? q.this.B0 : null);
                i6.a aVar = new i6.a(j6.a.ADD_EXPOSURE, dVar);
                aVar.c().toString();
                try {
                    aVar.d(new b.InterfaceC0098b() { // from class: g6.r
                        @Override // com.groboot.mdaemergency.async.b.InterfaceC0098b
                        public final void a(b.a aVar2) {
                            q.b.this.d(dVar, aVar2);
                        }
                    });
                } catch (Exception e10) {
                    e10.toString();
                    q.this.X2(false);
                }
            }
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
            q.this.A0.j(charSequence.toString());
            q.this.Y2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            q.this.A0.k(charSequence.toString());
            q.this.Y2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements o6.g {
        e() {
        }

        @Override // o6.g
        public void a(boolean z10) {
            q.this.A0.p(z10);
            q.this.Y2();
        }

        @Override // o6.g
        public void b(Date date, Date date2) {
            q.this.A0.q(new p6.c(date, date2));
            q.this.Y2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements o6.g {
        f() {
        }

        @Override // o6.g
        public void a(boolean z10) {
        }

        @Override // o6.g
        public void b(Date date, Date date2) {
            q.this.B0.e(new p6.c(date, date2));
            q.this.Y2();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements o6.g {
        g() {
        }

        @Override // o6.g
        public void a(boolean z10) {
            q.this.B0.f(z10);
            q.this.Y2();
        }

        @Override // o6.g
        public void b(Date date, Date date2) {
        }
    }

    private boolean D2(Date date, Date date2) {
        return (date == null || date2 == null || !date.before(date2)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E2() {
        if (t() != null) {
            t().onBackPressed();
        }
    }

    private void F2() {
        ExpoDescriptionFragment expoDescriptionFragment = (ExpoDescriptionFragment) z().h0(R.id.frg_exposure_description);
        if (expoDescriptionFragment != null) {
            expoDescriptionFragment.X1(new o6.d() { // from class: g6.l
                @Override // o6.d
                public final void a(int i10, int i11, int i12, String str) {
                    q.this.Q2(i10, i11, i12, str);
                }
            });
            expoDescriptionFragment.V1(new c());
        }
    }

    private void G2() {
        FamilyMemberAgeGroupFragment familyMemberAgeGroupFragment = (FamilyMemberAgeGroupFragment) z().h0(R.id.frg_family_member_age_group);
        FamilyMemberIsolationPeriodFragment familyMemberIsolationPeriodFragment = (FamilyMemberIsolationPeriodFragment) z().h0(R.id.frg_family_member_isolation_period);
        FamilyMemberIsolationConfirmationFragment familyMemberIsolationConfirmationFragment = (FamilyMemberIsolationConfirmationFragment) z().h0(R.id.frg_family_member_isolation_confirmation);
        if (familyMemberAgeGroupFragment != null) {
            familyMemberAgeGroupFragment.W1(new o6.b() { // from class: g6.k
                @Override // o6.b
                public final void a(e.a aVar) {
                    q.this.R2(aVar);
                }
            });
        }
        if (familyMemberIsolationPeriodFragment != null) {
            familyMemberIsolationPeriodFragment.Y1(new f());
        }
        if (familyMemberIsolationConfirmationFragment != null) {
            familyMemberIsolationConfirmationFragment.W1(new g());
        }
    }

    private void H2() {
        SetIsolationPeriodButtonFragment setIsolationPeriodButtonFragment = (SetIsolationPeriodButtonFragment) z().h0(R.id.frg_set_isolation_period);
        if (setIsolationPeriodButtonFragment != null) {
            setIsolationPeriodButtonFragment.d2(new e());
        }
    }

    private void I2() {
        ExposureLocationFragment exposureLocationFragment = (ExposureLocationFragment) z().h0(R.id.frg_exposure_location);
        if (exposureLocationFragment != null) {
            exposureLocationFragment.Y1(new o6.e() { // from class: g6.o
                @Override // o6.e
                public final void a(d.a aVar) {
                    q.this.S2(aVar);
                }
            });
            exposureLocationFragment.X1(new d());
        }
    }

    private void J2() {
        AbsenceOptionsFragment absenceOptionsFragment = (AbsenceOptionsFragment) z().h0(R.id.frg_select_absent_options);
        WorkAbsenceRangeFragment workAbsenceRangeFragment = (WorkAbsenceRangeFragment) z().h0(R.id.frg_work_absence_range);
        if (absenceOptionsFragment != null) {
            absenceOptionsFragment.a2(new o6.a() { // from class: g6.j
                @Override // o6.a
                public final void a(a.C0264a c0264a) {
                    q.this.T2(c0264a);
                }
            });
        }
        final p6.c cVar = new p6.c();
        if (workAbsenceRangeFragment != null) {
            workAbsenceRangeFragment.U1(new o6.d() { // from class: g6.m
                @Override // o6.d
                public final void a(int i10, int i11, int i12, String str) {
                    q.this.U2(cVar, i10, i11, i12, str);
                }
            });
            workAbsenceRangeFragment.T1(new o6.d() { // from class: g6.n
                @Override // o6.d
                public final void a(int i10, int i11, int i12, String str) {
                    q.this.V2(cVar, i10, i11, i12, str);
                }
            });
        }
    }

    private boolean K2() {
        return (!(this.C0.b() == null || this.C0.b() == a.EnumC0270a.IMOH || this.C0.b() == a.EnumC0270a.OTHER) || ((this.C0.b() == a.EnumC0270a.IMOH && this.C0.c() != null && this.C0.c().before(new Date())) || !(this.C0.b() != a.EnumC0270a.OTHER || this.C0.d() == null || this.C0.d().equals("")))) && this.C0.a() != null && D2(this.C0.a().b(), this.C0.a().a());
    }

    private boolean L2() {
        return (this.A0.a() == null || !this.A0.a().before(new Date()) || this.A0.b() == null || this.A0.b().equals("")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M2() {
        return L2() && ((this.A0.e() == d.b.PATIENT && P2()) || (this.A0.e() == d.b.FAMILY_MEMBER && N2())) && ((!this.A0.g() || (this.A0.g() && O2())) && (!this.C0.e() || (this.C0.e() && K2())));
    }

    private boolean N2() {
        return this.B0.c() && this.B0.a() != null && this.B0.b() != null && D2(this.B0.b().b(), this.B0.b().a());
    }

    private boolean O2() {
        return this.A0.f() != null && D2(this.A0.f().b(), this.A0.f().a());
    }

    private boolean P2() {
        if (this.A0.d() != null) {
            d.a d10 = this.A0.d();
            d.a aVar = d.a.OTHER;
            if (d10 != aVar || (this.A0.d() == aVar && this.A0.c() != null && !this.A0.c().equals(""))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q2(int i10, int i11, int i12, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i10);
        calendar.set(2, i11);
        calendar.set(5, i12);
        this.A0.i(calendar.getTime());
        Y2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R2(e.a aVar) {
        this.B0.d(aVar);
        Y2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S2(d.a aVar) {
        this.A0.l(aVar);
        Y2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T2(a.C0264a c0264a) {
        if (c0264a.c() != null) {
            this.C0.g(c0264a.c());
        }
        this.C0.i(c0264a.a());
        this.C0.j(c0264a.b());
        Y2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U2(p6.c cVar, int i10, int i11, int i12, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i10);
        calendar.set(2, i11);
        calendar.set(5, i12);
        cVar.d(calendar.getTime());
        if (D2(cVar.b(), cVar.a())) {
            this.C0.f(cVar);
            Y2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V2(p6.c cVar, int i10, int i11, int i12, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i10);
        calendar.set(2, i11);
        calendar.set(5, i12);
        cVar.c(calendar.getTime());
        if (D2(cVar.b(), cVar.a())) {
            this.C0.f(cVar);
            Y2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W2(LinearLayout linearLayout, boolean z10) {
        this.C0.h(z10);
        linearLayout.setVisibility(z10 ? 0 : 8);
        Y2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X2(boolean z10) {
        this.E0.setEnabled(!z10);
        if (!z10) {
            this.D0.dismiss();
            return;
        }
        this.D0.setCancelable(false);
        this.D0.setMessage(g0(R.string.loading));
        this.D0.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y2() {
        this.E0.setSaveEnabled(M2());
    }

    @Override // androidx.fragment.app.Fragment
    public void G0() {
        this.D0.dismiss();
        super.G0();
    }

    @Override // a6.a, androidx.fragment.app.Fragment
    public void W0() {
        super.W0();
        F2();
        I2();
        H2();
        G2();
        J2();
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.fragment_report_exposure);
        setTitle(R.string.report_exposure_title);
        this.E0 = (SaveCancelFormView) k2(R.id.scf_save_cancel_expo_form);
        this.D0 = new ProgressDialog(A());
        LinearLayout linearLayout = (LinearLayout) k2(R.id.linv_family_member_exposure);
        LinearLayout linearLayout2 = (LinearLayout) k2(R.id.linv_patient_exposure);
        ((TextView) k2(R.id.txv_expo_counter)).setText(String.valueOf(i6.b.f().e().size() + 1));
        ((Spinner) k2(R.id.spn_exposure_type)).setOnItemSelectedListener(new a(linearLayout, linearLayout2));
        final LinearLayout linearLayout3 = (LinearLayout) k2(R.id.linv_absent_from_work);
        SelectAbsentFromWorkFragment selectAbsentFromWorkFragment = (SelectAbsentFromWorkFragment) z().h0(R.id.frg_select_is_absent_from_work);
        if (selectAbsentFromWorkFragment != null) {
            selectAbsentFromWorkFragment.V1(new o6.h() { // from class: g6.p
                @Override // o6.h
                public final void a(boolean z10) {
                    q.this.W2(linearLayout3, z10);
                }
            });
        }
        this.E0.setOnSaveCancelListener(new b());
    }

    @Override // a6.a
    public void o2() {
    }
}
