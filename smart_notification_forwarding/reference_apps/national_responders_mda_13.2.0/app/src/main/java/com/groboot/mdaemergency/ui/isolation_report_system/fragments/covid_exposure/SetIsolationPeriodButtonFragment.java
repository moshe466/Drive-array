package com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.SetIsolationPeriodButtonFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views.NativeDatePickerView;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import o6.d;
import o6.g;

/* loaded from: classes.dex */
public class SetIsolationPeriodButtonFragment extends Fragment {

    /* renamed from: e0, reason: collision with root package name */
    private final ArrayList<g> f8169e0 = new ArrayList<>();

    /* renamed from: f0, reason: collision with root package name */
    private Date f8170f0;

    /* renamed from: g0, reason: collision with root package name */
    private Date f8171g0;

    /* renamed from: h0, reason: collision with root package name */
    private Button f8172h0;

    /* renamed from: i0, reason: collision with root package name */
    private Button f8173i0;

    /* renamed from: j0, reason: collision with root package name */
    private ConstraintLayout f8174j0;

    private void X1(Date date, Date date2) {
        Iterator<g> it = this.f8169e0.iterator();
        while (it.hasNext()) {
            it.next().b(date, date2);
        }
    }

    private void Y1(boolean z10) {
        Iterator<g> it = this.f8169e0.iterator();
        while (it.hasNext()) {
            it.next().a(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(View view) {
        this.f8174j0.setVisibility(0);
        this.f8172h0.setVisibility(8);
        Y1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a2(NativeDatePickerView nativeDatePickerView, NativeDatePickerView nativeDatePickerView2, View view) {
        if (nativeDatePickerView != null && nativeDatePickerView2 != null) {
            nativeDatePickerView.d();
            nativeDatePickerView2.d();
        }
        this.f8170f0 = null;
        this.f8171g0 = null;
        this.f8174j0.setVisibility(8);
        this.f8172h0.setVisibility(0);
        Y1(false);
        X1(this.f8170f0, this.f8171g0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b2(int i10, int i11, int i12, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i10);
        calendar.set(2, i11);
        calendar.set(5, i12);
        Date time = calendar.getTime();
        this.f8170f0 = time;
        X1(time, this.f8171g0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c2(int i10, int i11, int i12, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i10);
        calendar.set(2, i11);
        calendar.set(5, i12);
        Date time = calendar.getTime();
        this.f8171g0 = time;
        X1(this.f8170f0, time);
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_set_isolation_period_button, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0() {
        super.Y0();
        this.f8174j0 = (ConstraintLayout) D1().findViewById(R.id.csl_isolation_period_picker);
        this.f8172h0 = (Button) D1().findViewById(R.id.btn_enter_isolation);
        this.f8173i0 = (Button) D1().findViewById(R.id.btn_cancel_date_selection);
        final NativeDatePickerView nativeDatePickerView = (NativeDatePickerView) D1().findViewById(R.id.ndp_set_iso_from_date);
        final NativeDatePickerView nativeDatePickerView2 = (NativeDatePickerView) D1().findViewById(R.id.ndp_set_iso_until_date);
        this.f8172h0.setOnClickListener(new View.OnClickListener() { // from class: l6.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetIsolationPeriodButtonFragment.this.Z1(view);
            }
        });
        this.f8173i0.setOnClickListener(new View.OnClickListener() { // from class: l6.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SetIsolationPeriodButtonFragment.this.a2(nativeDatePickerView, nativeDatePickerView2, view);
            }
        });
        nativeDatePickerView.setOnDateSelectedListener(new d() { // from class: l6.j
            @Override // o6.d
            public final void a(int i10, int i11, int i12, String str) {
                SetIsolationPeriodButtonFragment.this.b2(i10, i11, i12, str);
            }
        });
        nativeDatePickerView2.setOnDateSelectedListener(new d() { // from class: l6.i
            @Override // o6.d
            public final void a(int i10, int i11, int i12, String str) {
                SetIsolationPeriodButtonFragment.this.c2(i10, i11, i12, str);
            }
        });
    }

    public void d2(g gVar) {
        this.f8169e0.add(gVar);
    }

    public void e2(boolean z10) {
        if (z10) {
            this.f8172h0.setVisibility(8);
            this.f8173i0.setVisibility(8);
            this.f8174j0.setVisibility(0);
        } else {
            this.f8172h0.setVisibility(0);
            this.f8173i0.setVisibility(0);
            this.f8174j0.setVisibility(8);
        }
    }
}
