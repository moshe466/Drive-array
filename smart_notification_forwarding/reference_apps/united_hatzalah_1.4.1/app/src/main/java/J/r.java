package J;

import android.view.View;

/* loaded from: classes.dex */
public interface r {
    void onNestedPreScroll(View view, int i, int i3, int[] iArr, int i4);

    void onNestedScroll(View view, int i, int i3, int i4, int i5, int i6);

    void onNestedScrollAccepted(View view, View view2, int i, int i3);

    boolean onStartNestedScroll(View view, View view2, int i, int i3);

    void onStopNestedScroll(View view, int i);
}
