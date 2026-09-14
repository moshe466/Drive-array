package com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.covid_exposure.ExpoDescriptionFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views.NativeDatePickerView;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import o6.d;

/* loaded from: classes.dex */
public class ExpoDescriptionFragment extends Fragment {

    /* renamed from: e0, reason: collision with root package name */
    private TextView f8157e0;

    /* renamed from: f0, reason: collision with root package name */
    private EditText f8158f0;

    /* renamed from: g0, reason: collision with root package name */
    private NativeDatePickerView f8159g0;

    /* renamed from: h0, reason: collision with root package name */
    private final ArrayList<d> f8160h0 = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void U1(int i10, int i11, int i12, String str) {
        Iterator<d> it = this.f8160h0.iterator();
        while (it.hasNext()) {
            it.next().a(i10, i11, i12, str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_expo_description, viewGroup, false);
    }

    public void V1(TextWatcher textWatcher) {
        this.f8158f0.addTextChangedListener(textWatcher);
    }

    public void W1(boolean z10) {
        TextView textView;
        int i10;
        if (z10) {
            textView = this.f8157e0;
            i10 = R.string.master_date_positive_title_text;
        } else {
            textView = this.f8157e0;
            i10 = R.string.master_date_title_text;
        }
        textView.setText(i10);
    }

    public void X1(d dVar) {
        this.f8160h0.add(dVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0() {
        super.Y0();
        this.f8157e0 = (TextView) D1().findViewById(R.id.txv_master_date_title);
        this.f8158f0 = (EditText) D1().findViewById(R.id.edt_expo_description);
        NativeDatePickerView nativeDatePickerView = (NativeDatePickerView) D1().findViewById(R.id.ndp_set_expo_date);
        this.f8159g0 = nativeDatePickerView;
        nativeDatePickerView.setOnDateSelectedListener(new d() { // from class: l6.a
            @Override // o6.d
            public final void a(int i10, int i11, int i12, String str) {
                ExpoDescriptionFragment.this.U1(i10, i11, i12, str);
            }
        });
    }
}
