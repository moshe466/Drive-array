package com.groboot.mdaemergency.ui.isolation_report_system.views.covid_test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import o6.i;
import p6.b;

/* loaded from: classes.dex */
public class CovidTestResultView extends ConstraintLayout {
    private final ArrayList<i> A;
    private RadioGroup B;
    private RadioGroup C;
    private RadioButton D;
    private RadioButton E;
    private RadioButton F;
    private RadioButton G;
    private final RadioGroup.OnCheckedChangeListener H;
    private final RadioGroup.OnCheckedChangeListener I;

    /* renamed from: z, reason: collision with root package name */
    private final Context f8187z;

    /* loaded from: classes.dex */
    class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i10) {
            CovidTestResultView covidTestResultView;
            b.a aVar;
            if (i10 != -1) {
                CovidTestResultView.this.C.setOnCheckedChangeListener(null);
                CovidTestResultView.this.C.clearCheck();
                CovidTestResultView.this.C.setOnCheckedChangeListener(CovidTestResultView.this.I);
                if (i10 == R.id.rdb_positive_test_res) {
                    covidTestResultView = CovidTestResultView.this;
                    aVar = b.a.POSITIVE;
                } else {
                    covidTestResultView = CovidTestResultView.this;
                    aVar = b.a.NONE;
                }
                covidTestResultView.F(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements RadioGroup.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i10) {
            CovidTestResultView covidTestResultView;
            b.a aVar;
            if (i10 != -1) {
                CovidTestResultView.this.B.setOnCheckedChangeListener(null);
                CovidTestResultView.this.B.clearCheck();
                CovidTestResultView.this.B.setOnCheckedChangeListener(CovidTestResultView.this.H);
                if (i10 == R.id.rdb_negative_test_res) {
                    covidTestResultView = CovidTestResultView.this;
                    aVar = b.a.NEGATIVE;
                } else {
                    covidTestResultView = CovidTestResultView.this;
                    aVar = b.a.MARGINAL_POSITIVE;
                }
                covidTestResultView.F(aVar);
            }
        }
    }

    public CovidTestResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = new ArrayList<>();
        this.H = new a();
        this.I = new b();
        this.f8187z = context;
        H(attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(b.a aVar) {
        Iterator<i> it = this.A.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
    }

    private void H(AttributeSet attributeSet, int i10) {
        View inflate = ViewGroup.inflate(this.f8187z, R.layout.component_covid_test_result, null);
        inflate.setLayoutParams(new ConstraintLayout.b(-1, -1));
        addView(inflate);
        I(inflate);
    }

    private void I(View view) {
        this.B = (RadioGroup) view.findViewById(R.id.rdg_covid_result_col_a);
        this.C = (RadioGroup) view.findViewById(R.id.rdg_covid_result_col_b);
        this.D = (RadioButton) view.findViewById(R.id.rdb_no_test_res);
        this.E = (RadioButton) view.findViewById(R.id.rdb_positive_test_res);
        this.F = (RadioButton) view.findViewById(R.id.rdb_negative_test_res);
        this.G = (RadioButton) view.findViewById(R.id.rdb_marginal_test_res);
        this.B.clearCheck();
        this.C.clearCheck();
        this.B.setOnCheckedChangeListener(this.H);
        this.C.setOnCheckedChangeListener(this.I);
    }

    public void G() {
        this.D.setChecked(false);
        this.F.setChecked(false);
        this.G.setChecked(false);
        this.E.setChecked(false);
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.D.isEnabled() && this.E.isEnabled() && this.F.isEnabled() && this.G.isEnabled();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        this.D.setEnabled(z10);
        this.E.setEnabled(z10);
        this.F.setEnabled(z10);
        this.G.setEnabled(z10);
    }

    public void setOnTestResultSelectedListener(i iVar) {
        this.A.add(iVar);
    }

    public void setTestResult(b.a aVar) {
        RadioButton radioButton;
        if (aVar == b.a.POSITIVE) {
            this.C.clearCheck();
            radioButton = this.E;
        } else if (aVar == b.a.NEGATIVE) {
            this.B.clearCheck();
            radioButton = this.F;
        } else if (aVar == b.a.MARGINAL_POSITIVE) {
            this.B.clearCheck();
            radioButton = this.G;
        } else {
            this.C.clearCheck();
            radioButton = this.D;
        }
        radioButton.setChecked(true);
    }
}
