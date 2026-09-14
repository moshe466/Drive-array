package com.groboot.mdaemergency.ui.isolation_report_system.fragments.absent_from_work;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views.NativeDatePickerView;
import il.org.mda.health.R;
import o6.d;

/* loaded from: classes.dex */
public class WorkAbsenceRangeFragment extends Fragment {

    /* renamed from: e0, reason: collision with root package name */
    NativeDatePickerView f8155e0;

    /* renamed from: f0, reason: collision with root package name */
    NativeDatePickerView f8156f0;

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_work_absence_range, viewGroup, false);
    }

    public void T1(d dVar) {
        this.f8156f0.setOnDateSelectedListener(dVar);
    }

    public void U1(d dVar) {
        this.f8155e0.setOnDateSelectedListener(dVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0() {
        super.Y0();
        this.f8155e0 = (NativeDatePickerView) D1().findViewById(R.id.ndp_set_abs_from_date);
        this.f8156f0 = (NativeDatePickerView) D1().findViewById(R.id.ndp_set_abs_until_date);
    }
}
