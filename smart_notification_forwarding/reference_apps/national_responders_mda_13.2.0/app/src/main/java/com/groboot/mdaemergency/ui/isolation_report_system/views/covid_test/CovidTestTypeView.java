package com.groboot.mdaemergency.ui.isolation_report_system.views.covid_test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.groboot.mdaemergency.ui.isolation_report_system.views.covid_test.CovidTestTypeView;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import o6.c;
import p6.b;

/* loaded from: classes.dex */
public class CovidTestTypeView extends ConstraintLayout {
    private RadioGroup A;
    private RadioButton B;
    private RadioButton C;
    private final ArrayList<c> D;

    /* renamed from: z, reason: collision with root package name */
    Context f8190z;

    public CovidTestTypeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new ArrayList<>();
        this.f8190z = context;
        D(attributeSet, 0);
    }

    private void B(b.EnumC0271b enumC0271b) {
        Iterator<c> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().a(enumC0271b);
        }
    }

    private void D(AttributeSet attributeSet, int i10) {
        View inflate = ViewGroup.inflate(this.f8190z, R.layout.component_covid_test_type, null);
        inflate.setLayoutParams(new ConstraintLayout.b(-1, -1));
        addView(inflate);
        F(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(RadioGroup radioGroup, int i10) {
        B(i10 == R.id.rdb_pcr_test ? b.EnumC0271b.PCR : b.EnumC0271b.ANTIBODY);
    }

    private void F(View view) {
        this.A = (RadioGroup) view.findViewById(R.id.rdg_covid_test_type);
        this.B = (RadioButton) view.findViewById(R.id.rdb_pcr_test);
        this.C = (RadioButton) view.findViewById(R.id.rdb_antibody_test);
        this.A.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: q6.a
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i10) {
                CovidTestTypeView.this.E(radioGroup, i10);
            }
        });
    }

    public void C() {
        this.C.setChecked(false);
        this.B.setChecked(false);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.B.isEnabled() && this.C.isEnabled();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        this.B.setEnabled(z10);
        this.C.setEnabled(z10);
    }

    public void setOnTestTypeSelectedListener(c cVar) {
        this.D.add(cVar);
    }

    public void setTestType(b.EnumC0271b enumC0271b) {
        (enumC0271b == b.EnumC0271b.PCR ? this.B : this.C).setChecked(true);
    }
}
