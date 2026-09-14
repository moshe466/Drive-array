package com.google.android.material.transformation;

import a3.a;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.a0;
import b3.h;
import b3.j;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: g, reason: collision with root package name */
    private Map<View, Integer> f7043g;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void c0(View view, boolean z10) {
        int intValue;
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z10) {
                this.f7043g = new HashMap(childCount);
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                boolean z11 = (childAt.getLayoutParams() instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z11) {
                    if (!z10) {
                        Map<View, Integer> map = this.f7043g;
                        intValue = (map != null && map.containsKey(childAt)) ? this.f7043g.get(childAt).intValue() : 4;
                    } else if (Build.VERSION.SDK_INT >= 16) {
                        this.f7043g.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    }
                    a0.u0(childAt, intValue);
                }
            }
            if (z10) {
                return;
            }
            this.f7043g = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    public boolean G(View view, View view2, boolean z10, boolean z11) {
        c0(view2, z10);
        return super.G(view, view2, z10, z11);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    protected FabTransformationBehavior.e a0(Context context, boolean z10) {
        int i10 = z10 ? a.f93d : a.f92c;
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.f7037a = h.b(context, i10);
        eVar.f7038b = new j(17, 0.0f, 0.0f);
        return eVar;
    }
}
