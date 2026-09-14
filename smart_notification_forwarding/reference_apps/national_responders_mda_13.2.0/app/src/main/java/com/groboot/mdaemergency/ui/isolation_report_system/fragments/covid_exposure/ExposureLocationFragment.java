package com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.ExposureLocationFragment;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import o6.e;
import p6.d;

/* loaded from: classes.dex */
public class ExposureLocationFragment extends Fragment {

    /* renamed from: e0, reason: collision with root package name */
    private EditText f8161e0;

    /* renamed from: f0, reason: collision with root package name */
    private final ArrayList<e> f8162f0 = new ArrayList<>();

    private void U1(d.a aVar) {
        Iterator<e> it = this.f8162f0.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    private void V1(d.a aVar) {
        if (aVar == d.a.HOME || aVar == d.a.WORK) {
            this.f8161e0.setEnabled(false);
            this.f8161e0.setText("");
        } else {
            this.f8161e0.setEnabled(true);
        }
        U1(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(RadioGroup radioGroup, int i10) {
        V1(i10 == R.id.rdb_home_location ? d.a.HOME : i10 == R.id.rdb_work_location ? d.a.WORK : d.a.OTHER);
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_exposure_location, viewGroup, false);
    }

    public void X1(TextWatcher textWatcher) {
        this.f8161e0.addTextChangedListener(textWatcher);
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0() {
        super.Y0();
        RadioGroup radioGroup = (RadioGroup) D1().findViewById(R.id.rdg_select_expo_locations);
        this.f8161e0 = (EditText) D1().findViewById(R.id.edt_exposure_location_description);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: l6.b
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i10) {
                ExposureLocationFragment.this.W1(radioGroup2, i10);
            }
        });
    }

    public void Y1(e eVar) {
        this.f8162f0.add(eVar);
    }
}
