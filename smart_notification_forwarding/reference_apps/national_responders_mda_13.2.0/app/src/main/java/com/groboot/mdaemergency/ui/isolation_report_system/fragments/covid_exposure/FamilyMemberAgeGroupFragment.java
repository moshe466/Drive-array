package com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.FamilyMemberAgeGroupFragment;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import o6.b;
import p6.e;

/* loaded from: classes.dex */
public class FamilyMemberAgeGroupFragment extends Fragment {

    /* renamed from: e0, reason: collision with root package name */
    private final ArrayList<b> f8163e0 = new ArrayList<>();

    /* renamed from: f0, reason: collision with root package name */
    private RadioGroup f8164f0;

    private void U1(e.a aVar) {
        Iterator<b> it = this.f8163e0.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V1(RadioGroup radioGroup, int i10) {
        U1(i10 == R.id.rdb_upto_11 ? e.a.ZERO_TO_ELEVEN : i10 == R.id.rdb_upto_14 ? e.a.TWELVE_TO_FOURTEEN : e.a.OLDER_THAN_FOURTEEN);
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_family_member_age_group, viewGroup, false);
    }

    public void W1(b bVar) {
        this.f8163e0.add(bVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0() {
        super.Y0();
        RadioGroup radioGroup = (RadioGroup) D1().findViewById(R.id.rdg_age_group);
        this.f8164f0 = radioGroup;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: l6.c
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i10) {
                FamilyMemberAgeGroupFragment.this.V1(radioGroup2, i10);
            }
        });
    }
}
