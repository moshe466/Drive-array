package com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.groboot.mdaemergency.ui.isolation_report_system.views.generic_views.SaveCancelFormView;
import il.org.mda.health.R;
import java.util.ArrayList;
import java.util.Iterator;
import o6.f;

/* loaded from: classes.dex */
public class SaveCancelFormView extends ConstraintLayout {
    private final ArrayList<f> A;
    private Button B;
    private Button C;
    private ProgressBar D;

    /* renamed from: z, reason: collision with root package name */
    private final Context f8196z;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8197a;

        static {
            int[] iArr = new int[b.values().length];
            f8197a = iArr;
            try {
                iArr[b.PROMPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8197a[b.SAVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8197a[b.CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        SAVE,
        CANCEL,
        PROMPT
    }

    public SaveCancelFormView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.A = new ArrayList<>();
        this.f8196z = context;
        E(attributeSet, 0);
    }

    private void C() {
        Iterator<f> it = this.A.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    private void D() {
        Iterator<f> it = this.A.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void E(AttributeSet attributeSet, int i10) {
        View inflate = ViewGroup.inflate(this.f8196z, R.layout.component_save_cancel_form, null);
        inflate.setLayoutParams(new ConstraintLayout.b(-1, -1));
        addView(inflate);
        H(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(View view) {
        D();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        C();
    }

    private void H(View view) {
        this.B = (Button) view.findViewById(R.id.btn_save_form);
        this.C = (Button) view.findViewById(R.id.btn_cancel_form);
        this.D = (ProgressBar) view.findViewById(R.id.prg_loading_submit_form);
        this.B.setOnClickListener(new View.OnClickListener() { // from class: r6.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SaveCancelFormView.this.F(view2);
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() { // from class: r6.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SaveCancelFormView.this.G(view2);
            }
        });
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.C.isEnabled() && this.B.isEnabled();
    }

    @Override // android.view.View
    public boolean isSaveEnabled() {
        return this.B.isEnabled();
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        this.B.setEnabled(z10);
        this.C.setEnabled(z10);
    }

    public void setLoading(boolean z10) {
        if (z10) {
            this.D.setVisibility(0);
            this.C.setVisibility(8);
            this.B.setVisibility(8);
        } else {
            this.D.setVisibility(8);
            this.C.setVisibility(0);
            this.B.setVisibility(0);
        }
    }

    public void setMode(b bVar) {
        int i10 = a.f8197a[bVar.ordinal()];
        if (i10 == 1) {
            this.B.setVisibility(0);
        } else if (i10 == 2) {
            this.B.setVisibility(0);
            this.C.setVisibility(8);
            return;
        } else if (i10 != 3) {
            return;
        } else {
            this.B.setVisibility(8);
        }
        this.C.setVisibility(0);
    }

    public void setOnSaveCancelListener(f fVar) {
        this.A.add(fVar);
    }

    @Override // android.view.View
    public void setSaveEnabled(boolean z10) {
        this.B.setEnabled(z10);
    }
}
