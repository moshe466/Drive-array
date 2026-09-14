package f6;

import android.view.View;
import il.org.mda.health.R;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class b3 extends a6.a implements View.OnClickListener {
    public Map<Integer, View> A0 = new LinkedHashMap();
    private int B0;

    @Override // androidx.fragment.app.e, androidx.fragment.app.Fragment
    public /* synthetic */ void I0() {
        super.I0();
        p2();
    }

    @Override // a6.a
    protected void n2() {
        l2(R.layout.whats_new_fragment);
        setTitle(R.string.whats_new);
        k2(R.id.tv_1).setOnClickListener(this);
        k2(R.id.tv_2).setOnClickListener(this);
        k2(R.id.tv_3).setOnClickListener(this);
    }

    @Override // a6.a
    public void o2() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        y8.k.e(view, "view");
        switch (view.getId()) {
            case R.id.tv_1 /* 2131297241 */:
                int i10 = this.B0;
                if (i10 == 0 || i10 == 2 || i10 == 4) {
                    this.B0 = i10 + 1;
                    return;
                } else {
                    this.B0 = 0;
                    return;
                }
            case R.id.tv_2 /* 2131297247 */:
                int i11 = this.B0;
                if (i11 == 1 || i11 == 3 || i11 == 5) {
                    this.B0 = i11 + 1;
                    return;
                } else {
                    this.B0 = 0;
                    return;
                }
            case R.id.tv_3 /* 2131297248 */:
                int i12 = this.B0;
                if (i12 > 10) {
                    w6.m.b0(true);
                    w6.l0.L0(w6.l0.v(), "בוצע", true);
                    return;
                } else if (i12 > 5) {
                    this.B0 = i12 + 1;
                    return;
                } else {
                    this.B0 = 0;
                    return;
                }
            default:
                return;
        }
    }

    public void p2() {
        this.A0.clear();
    }
}
