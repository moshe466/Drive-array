package com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.FamilyMemberIsolationPeriodFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views.NativeDatePickerView;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import o6.d;
import o6.g;

/* loaded from: classes.dex */
public class FamilyMemberIsolationPeriodFragment extends Fragment {

    /* renamed from: e0, reason: collision with root package name */
    private final ArrayList<g> f8166e0 = new ArrayList<>();

    /* renamed from: f0, reason: collision with root package name */
    private Date f8167f0;

    /* renamed from: g0, reason: collision with root package name */
    private Date f8168g0;

    private void V1(Date date, Date date2) {
        Iterator<g> it = this.f8166e0.iterator();
        while (it.hasNext()) {
            g next = it.next();
            next.a(true);
            next.b(date, date2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(int i10, int i11, int i12, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i10);
        calendar.set(2, i11);
        calendar.set(5, i12);
        Date time = calendar.getTime();
        this.f8167f0 = time;
        V1(time, this.f8168g0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X1(int i10, int i11, int i12, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i10);
        calendar.set(2, i11);
        calendar.set(5, i12);
        Date time = calendar.getTime();
        this.f8168g0 = time;
        V1(this.f8167f0, time);
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_family_member_isolation_period, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0() {
        super.Y0();
        NativeDatePickerView nativeDatePickerView = (NativeDatePickerView) D1().findViewById(R.id.ndp_set_fam_iso_from_date);
        NativeDatePickerView nativeDatePickerView2 = (NativeDatePickerView) D1().findViewById(R.id.ndp_set_fam_iso_until_date);
        nativeDatePickerView.setOnDateSelectedListener(new d() { // from class: l6.f
            @Override // o6.d
            public final void a(int i10, int i11, int i12, String str) {
                FamilyMemberIsolationPeriodFragment.this.W1(i10, i11, i12, str);
            }
        });
        nativeDatePickerView2.setOnDateSelectedListener(new d() { // from class: l6.e
            @Override // o6.d
            public final void a(int i10, int i11, int i12, String str) {
                FamilyMemberIsolationPeriodFragment.this.X1(i10, i11, i12, str);
            }
        });
    }

    public void Y1(g gVar) {
        this.f8166e0.add(gVar);
    }
}
