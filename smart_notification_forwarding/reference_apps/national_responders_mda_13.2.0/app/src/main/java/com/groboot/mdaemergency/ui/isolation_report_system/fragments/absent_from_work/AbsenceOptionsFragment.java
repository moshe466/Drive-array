package com.groboot.mdaemergency.ui.isolation_report_system.fragments.absent_from_work;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.absent_from_work.AbsenceOptionsFragment;
import com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views.NativeDatePickerView;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import o6.a;
import o6.d;
import p6.a;

/* loaded from: classes.dex */
public class AbsenceOptionsFragment extends Fragment {

    /* renamed from: e0, reason: collision with root package name */
    private final ArrayList<o6.a> f8151e0 = new ArrayList<>();

    /* renamed from: f0, reason: collision with root package name */
    private final a.C0264a f8152f0 = new a.C0264a();

    /* loaded from: classes.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            AbsenceOptionsFragment.this.f8152f0.e(charSequence.toString());
            AbsenceOptionsFragment absenceOptionsFragment = AbsenceOptionsFragment.this;
            absenceOptionsFragment.X1(absenceOptionsFragment.f8152f0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X1(a.C0264a c0264a) {
        Iterator<o6.a> it = this.f8151e0.iterator();
        while (it.hasNext()) {
            it.next().a(c0264a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y1(NativeDatePickerView nativeDatePickerView, EditText editText, RadioGroup radioGroup, int i10) {
        a.C0264a c0264a;
        a.EnumC0270a enumC0270a;
        if (i10 == R.id.rdb_because_imoh) {
            this.f8152f0.f(a.EnumC0270a.IMOH);
            nativeDatePickerView.setEnabled(true);
        } else {
            if (i10 == R.id.rdb_because_family_member) {
                c0264a = this.f8152f0;
                enumC0270a = a.EnumC0270a.FAMILY_MEMBER;
            } else {
                if (i10 != R.id.rdb_because_mda) {
                    this.f8152f0.f(a.EnumC0270a.OTHER);
                    nativeDatePickerView.setEnabled(false);
                    nativeDatePickerView.d();
                    this.f8152f0.d(null);
                    editText.setEnabled(true);
                    X1(this.f8152f0);
                }
                c0264a = this.f8152f0;
                enumC0270a = a.EnumC0270a.MDA_REQUIREMENT;
            }
            c0264a.f(enumC0270a);
            nativeDatePickerView.setEnabled(false);
            nativeDatePickerView.d();
            this.f8152f0.d(null);
        }
        editText.setText("");
        editText.setEnabled(false);
        X1(this.f8152f0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z1(int i10, int i11, int i12, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i10);
        calendar.set(2, i11);
        calendar.set(5, i12);
        this.f8152f0.d(calendar.getTime());
        X1(this.f8152f0);
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_absence_options, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0() {
        super.Y0();
        final NativeDatePickerView nativeDatePickerView = (NativeDatePickerView) D1().findViewById(R.id.ndp_select_imoh_message_date);
        final EditText editText = (EditText) D1().findViewById(R.id.edt_other_reason);
        RadioGroup radioGroup = (RadioGroup) D1().findViewById(R.id.rdg_absence_reason);
        nativeDatePickerView.setEnabled(false);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: k6.a
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i10) {
                AbsenceOptionsFragment.this.Y1(nativeDatePickerView, editText, radioGroup2, i10);
            }
        });
        editText.addTextChangedListener(new a());
        nativeDatePickerView.setOnDateSelectedListener(new d() { // from class: k6.b
            @Override // o6.d
            public final void a(int i10, int i11, int i12, String str) {
                AbsenceOptionsFragment.this.Z1(i10, i11, i12, str);
            }
        });
    }

    public void a2(o6.a aVar) {
        this.f8151e0.add(aVar);
    }
}
