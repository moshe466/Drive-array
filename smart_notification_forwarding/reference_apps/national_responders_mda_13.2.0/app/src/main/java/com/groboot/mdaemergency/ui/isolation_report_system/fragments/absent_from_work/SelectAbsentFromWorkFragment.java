package com.groboot.mdaemergency.ui.isolation_report_system.fragments.absent_from_work;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.absent_from_work.SelectAbsentFromWorkFragment;
import il.org.mda.health.R;
import o6.h;

/* loaded from: classes.dex */
public class SelectAbsentFromWorkFragment extends Fragment {

    /* renamed from: e0, reason: collision with root package name */
    private h f8154e0;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1(RadioGroup radioGroup, int i10) {
        boolean z10 = i10 == R.id.rdb_is_absent;
        h hVar = this.f8154e0;
        if (hVar != null) {
            hVar.a(z10);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_select_absent_from_work, viewGroup, false);
    }

    public void V1(h hVar) {
        this.f8154e0 = hVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0() {
        super.Y0();
        ((RadioGroup) D1().findViewById(R.id.rdg_set_is_absent)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: k6.c
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i10) {
                SelectAbsentFromWorkFragment.this.U1(radioGroup, i10);
            }
        });
    }
}
