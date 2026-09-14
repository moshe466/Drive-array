package com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.FamilyMemberIsolationConfirmationFragment;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import o6.g;

/* loaded from: classes.dex */
public class FamilyMemberIsolationConfirmationFragment extends Fragment {

    /* renamed from: e0, reason: collision with root package name */
    private final ArrayList<g> f8165e0 = new ArrayList<>();

    private void U1(boolean z10) {
        Iterator<g> it = this.f8165e0.iterator();
        while (it.hasNext()) {
            g next = it.next();
            next.a(z10);
            next.b(null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V1(RadioGroup radioGroup, int i10) {
        U1(i10 == R.id.rdb_confirm_family_isolation);
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_family_member_isolation_confirmation, viewGroup, false);
    }

    public void W1(g gVar) {
        this.f8165e0.add(gVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0() {
        super.Y0();
        ((RadioGroup) D1().findViewById(R.id.rdg_family_member_isolation_confirmatio_options)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: l6.d
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i10) {
                FamilyMemberIsolationConfirmationFragment.this.V1(radioGroup, i10);
            }
        });
    }
}
