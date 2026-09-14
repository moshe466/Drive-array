package com.groboot.mdaemergency.ui.isolation_report_system.fragments.generic_components;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.groboot.mdaemergency.ui.isolation_report_system.fragments.generic_components.NativeDatePickerFragment;
import il.org.mda.health.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@Deprecated
/* loaded from: classes.dex */
public class NativeDatePickerFragment extends Fragment {

    /* renamed from: e0, reason: collision with root package name */
    final Calendar f8184e0 = Calendar.getInstance();

    /* renamed from: f0, reason: collision with root package name */
    String f8185f0 = "";

    /* renamed from: g0, reason: collision with root package name */
    EditText f8186g0;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V1(DatePicker datePicker, int i10, int i11, int i12) {
        this.f8184e0.set(1, i10);
        this.f8184e0.set(2, i11);
        this.f8184e0.set(5, i12);
        X1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(DatePickerDialog.OnDateSetListener onDateSetListener, View view) {
        new DatePickerDialog(t(), onDateSetListener, this.f8184e0.get(1), this.f8184e0.get(2), this.f8184e0.get(5)).show();
    }

    private void X1() {
        String format = new SimpleDateFormat("dd/MM/yyyy", Locale.UK).format(this.f8184e0.getTime());
        this.f8185f0 = format;
        this.f8186g0.setText(format);
    }

    @Override // androidx.fragment.app.Fragment
    public void B0(Bundle bundle) {
        super.B0(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View F0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.component_native_date_picker, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void Y0() {
        super.Y0();
        this.f8186g0 = (EditText) D1().findViewById(R.id.edt_set_master_date);
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: n6.a
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i10, int i11, int i12) {
                NativeDatePickerFragment.this.V1(datePicker, i10, i11, i12);
            }
        };
        this.f8186g0.setOnClickListener(new View.OnClickListener() { // from class: n6.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NativeDatePickerFragment.this.W1(onDateSetListener, view);
            }
        });
    }
}
