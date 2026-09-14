package com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_test.CovidTestItemFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.views.covid_test.CovidTestResultView;
import com.groboot.mdaemergency.ui.isolation_report_system.views.covid_test.CovidTestTypeView;
import com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views.NativeDatePickerView;
import com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views.SaveCancelFormView;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import o6.c;
import o6.d;
import o6.f;
import o6.i;
import p6.b;

/* loaded from: classes.dex */
public class CovidTestItemFragment extends Fragment {

    /* renamed from: f0, reason: collision with root package name */
    private TextView f8176f0;

    /* renamed from: g0, reason: collision with root package name */
    private CovidTestTypeView f8177g0;

    /* renamed from: h0, reason: collision with root package name */
    private NativeDatePickerView f8178h0;

    /* renamed from: i0, reason: collision with root package name */
    private CovidTestResultView f8179i0;

    /* renamed from: j0, reason: collision with root package name */
    private SaveCancelFormView f8180j0;

    /* renamed from: e0, reason: collision with root package name */
    private b f8175e0 = new b();

    /* renamed from: k0, reason: collision with root package name */
    Calendar f8181k0 = Calendar.getInstance();

    /* renamed from: l0, reason: collision with root package name */
    private ArrayList<f> f8182l0 = new ArrayList<>();

    /* loaded from: classes.dex */
    class a implements f {
        a() {
        }

        @Override // o6.f
        public void a() {
            CovidTestItemFragment.this.Y1();
        }

        @Override // o6.f
        public void b() {
            CovidTestItemFragment.this.Z1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y1() {
        Iterator<f> it = this.f8182l0.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1() {
        Iterator<f> it = this.f8182l0.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private boolean c2() {
        return (this.f8175e0.b() == null || this.f8175e0.a() == null || !this.f8181k0.getTime().before(new Date()) || this.f8175e0.c() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d2(b.EnumC0271b enumC0271b) {
        this.f8175e0.g(enumC0271b);
        this.f8180j0.setSaveEnabled(c2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e2(int i10, int i11, int i12, String str) {
        this.f8181k0.set(1, i10);
        this.f8181k0.set(2, i11);
        this.f8181k0.set(5, i12);
        this.f8175e0.d(this.f8181k0.getTime());
        this.f8180j0.setSaveEnabled(c2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f2(b.a aVar) {
        this.f8175e0.f(aVar);
        this.f8180j0.setSaveEnabled(c2());
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_item_covid_test, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0() {
        super.Y0();
        this.f8176f0 = (TextView) D1().findViewById(R.id.txv_covid_test_serial_number);
        this.f8177g0 = (CovidTestTypeView) D1().findViewById(R.id.ctt_select_test_type);
        this.f8178h0 = (NativeDatePickerView) D1().findViewById(R.id.ndp_select_test_date);
        this.f8179i0 = (CovidTestResultView) D1().findViewById(R.id.ctr_select_test_result);
        SaveCancelFormView saveCancelFormView = (SaveCancelFormView) D1().findViewById(R.id.scf_save_test_form);
        this.f8180j0 = saveCancelFormView;
        saveCancelFormView.setSaveEnabled(false);
        this.f8177g0.setOnTestTypeSelectedListener(new c() { // from class: m6.a
            @Override // o6.c
            public final void a(b.EnumC0271b enumC0271b) {
                CovidTestItemFragment.this.d2(enumC0271b);
            }
        });
        this.f8178h0.setOnDateSelectedListener(new d() { // from class: m6.b
            @Override // o6.d
            public final void a(int i10, int i11, int i12, String str) {
                CovidTestItemFragment.this.e2(i10, i11, i12, str);
            }
        });
        this.f8179i0.setOnTestResultSelectedListener(new i() { // from class: m6.c
            @Override // o6.i
            public final void a(b.a aVar) {
                CovidTestItemFragment.this.f2(aVar);
            }
        });
        this.f8180j0.setOnSaveCancelListener(new a());
    }

    public void a2() {
        this.f8177g0.C();
        this.f8179i0.G();
        this.f8178h0.d();
        this.f8180j0.setEnabled(true);
        this.f8180j0.setLoading(false);
        this.f8175e0 = new b();
    }

    public b b2() {
        return this.f8175e0;
    }

    public void g2(String str) {
        this.f8176f0.setText(str);
    }

    public void h2(boolean z10) {
        this.f8176f0.setEnabled(z10);
        this.f8177g0.setEnabled(z10);
        this.f8178h0.setEnabled(z10);
        this.f8179i0.setEnabled(z10);
        this.f8180j0.setEnabled(z10);
    }

    public void i2(boolean z10) {
        this.f8180j0.setLoading(z10);
    }

    public void j2(f fVar) {
        this.f8182l0.add(fVar);
    }
}
