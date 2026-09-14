package com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views.NativeDatePickerView;
import il.org.mda.health.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import o6.d;

/* loaded from: classes.dex */
public class NativeDatePickerView extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    private final Context f8191f;

    /* renamed from: g, reason: collision with root package name */
    private final Calendar f8192g;

    /* renamed from: h, reason: collision with root package name */
    private String f8193h;

    /* renamed from: i, reason: collision with root package name */
    private EditText f8194i;

    /* renamed from: j, reason: collision with root package name */
    private final ArrayList<d> f8195j;

    public NativeDatePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8192g = Calendar.getInstance();
        this.f8193h = "";
        this.f8195j = new ArrayList<>();
        this.f8191f = context;
        e(attributeSet, 0);
    }

    private void c(int i10, int i11, int i12, String str) {
        Iterator<d> it = this.f8195j.iterator();
        while (it.hasNext()) {
            it.next().a(i10, i11, i12, str);
        }
    }

    private void e(AttributeSet attributeSet, int i10) {
        View inflate = FrameLayout.inflate(this.f8191f, R.layout.component_native_date_picker, null);
        inflate.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        addView(inflate);
        this.f8194i = (EditText) inflate.findViewById(R.id.edt_set_master_date);
        final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() { // from class: r6.a
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i11, int i12, int i13) {
                NativeDatePickerView.this.f(datePicker, i11, i12, i13);
            }
        };
        this.f8194i.setOnClickListener(new View.OnClickListener() { // from class: r6.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NativeDatePickerView.this.g(onDateSetListener, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(DatePicker datePicker, int i10, int i11, int i12) {
        this.f8192g.set(1, i10);
        this.f8192g.set(2, i11);
        this.f8192g.set(5, i12);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(DatePickerDialog.OnDateSetListener onDateSetListener, View view) {
        new DatePickerDialog(this.f8191f, onDateSetListener, this.f8192g.get(1), this.f8192g.get(2), this.f8192g.get(5)).show();
    }

    private void i() {
        String format = new SimpleDateFormat("dd/MM/yyyy", Locale.UK).format(this.f8192g.getTime());
        this.f8193h = format;
        this.f8194i.setText(format);
        c(this.f8192g.get(1), this.f8192g.get(2), this.f8192g.get(5), this.f8193h);
    }

    public void d() {
        this.f8193h = "";
        this.f8194i.setText("");
    }

    public void h(int i10, int i11, int i12) {
        this.f8192g.set(1, i10);
        this.f8192g.set(2, i11);
        this.f8192g.set(5, i12);
        i();
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.f8194i.isEnabled();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        this.f8194i.setEnabled(z10);
    }

    public void setOnDateSelectedListener(d dVar) {
        this.f8195j.add(dVar);
    }
}
