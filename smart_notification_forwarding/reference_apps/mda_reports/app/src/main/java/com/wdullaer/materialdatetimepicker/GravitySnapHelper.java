package com.wdullaer.materialdatetimepicker;

import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class GravitySnapHelper extends LinearSnapHelper {
    private int gravity;
    private OrientationHelper horizontalHelper;
    private boolean isRtlHorizontal;
    private SnapListener listener;
    private RecyclerView.OnScrollListener mScrollListener;
    private boolean snapping;
    private OrientationHelper verticalHelper;

    /* loaded from: classes2.dex */
    public interface SnapListener {
        void onSnap(int i);
    }

    public GravitySnapHelper(int i) {
        this(i, null);
    }

    public GravitySnapHelper(int i, SnapListener snapListener) {
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.wdullaer.materialdatetimepicker.GravitySnapHelper.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 2) {
                    GravitySnapHelper.this.snapping = false;
                }
                if (i2 != 0 || GravitySnapHelper.this.listener == null) {
                    return;
                }
                int snappedPosition = GravitySnapHelper.this.getSnappedPosition(recyclerView);
                if (snappedPosition != -1) {
                    GravitySnapHelper.this.listener.onSnap(snappedPosition);
                }
                GravitySnapHelper.this.snapping = false;
            }
        };
        if (i != 8388611 && i != 8388613 && i != 80 && i != 48) {
            throw new IllegalArgumentException("Invalid gravity value. Use START | END | BOTTOM | TOP constants");
        }
        this.gravity = i;
        this.listener = snapListener;
    }

    private int distanceToEnd(View view, OrientationHelper orientationHelper, boolean z) {
        return (!this.isRtlHorizontal || z) ? orientationHelper.getDecoratedEnd(view) - orientationHelper.getEndAfterPadding() : distanceToStart(view, orientationHelper, true);
    }

    private int distanceToStart(View view, OrientationHelper orientationHelper, boolean z) {
        return (!this.isRtlHorizontal || z) ? orientationHelper.getDecoratedStart(view) - orientationHelper.getStartAfterPadding() : distanceToEnd(view, orientationHelper, true);
    }

    private View findEndView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        LinearLayoutManager linearLayoutManager;
        int findLastVisibleItemPosition;
        if (!(layoutManager instanceof LinearLayoutManager) || (findLastVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) layoutManager).findLastVisibleItemPosition()) == -1) {
            return null;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findLastVisibleItemPosition);
        float decoratedEnd = (this.isRtlHorizontal ? orientationHelper.getDecoratedEnd(findViewByPosition) : orientationHelper.getTotalSpace() - orientationHelper.getDecoratedStart(findViewByPosition)) / orientationHelper.getDecoratedMeasurement(findViewByPosition);
        boolean z = linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0;
        if (decoratedEnd > 0.5f && !z) {
            return findViewByPosition;
        }
        if (z) {
            return null;
        }
        return layoutManager.findViewByPosition(findLastVisibleItemPosition - 1);
    }

    private View findStartView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        LinearLayoutManager linearLayoutManager;
        int findFirstVisibleItemPosition;
        if (!(layoutManager instanceof LinearLayoutManager) || (findFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) layoutManager).findFirstVisibleItemPosition()) == -1) {
            return null;
        }
        View findViewByPosition = layoutManager.findViewByPosition(findFirstVisibleItemPosition);
        float totalSpace = (this.isRtlHorizontal ? orientationHelper.getTotalSpace() - orientationHelper.getDecoratedStart(findViewByPosition) : orientationHelper.getDecoratedEnd(findViewByPosition)) / orientationHelper.getDecoratedMeasurement(findViewByPosition);
        boolean z = linearLayoutManager.findLastCompletelyVisibleItemPosition() == layoutManager.getItemCount() - 1;
        if (totalSpace > 0.5f && !z) {
            return findViewByPosition;
        }
        if (z) {
            return null;
        }
        return layoutManager.findViewByPosition(findFirstVisibleItemPosition + 1);
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.horizontalHelper == null) {
            this.horizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.horizontalHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSnappedPosition(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return -1;
        }
        int i = this.gravity;
        if (i == 8388611 || i == 48) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        }
        if (i == 8388613 || i == 80) {
            return ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        }
        return -1;
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        if (this.verticalHelper == null) {
            this.verticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.verticalHelper;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) {
        if (recyclerView != null) {
            int i = this.gravity;
            if ((i == 8388611 || i == 8388613) && Build.VERSION.SDK_INT >= 17) {
                this.isRtlHorizontal = recyclerView.getContext().getResources().getConfiguration().getLayoutDirection() == 1;
            }
            if (this.listener != null) {
                recyclerView.addOnScrollListener(this.mScrollListener);
            }
        }
        super.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (!layoutManager.canScrollHorizontally()) {
            iArr[0] = 0;
        } else if (this.gravity == 8388611) {
            iArr[0] = distanceToStart(view, getHorizontalHelper(layoutManager), false);
        } else {
            iArr[0] = distanceToEnd(view, getHorizontalHelper(layoutManager), false);
        }
        if (layoutManager.canScrollVertically()) {
            int i = this.gravity;
            OrientationHelper verticalHelper = getVerticalHelper(layoutManager);
            if (i == 48) {
                iArr[1] = distanceToStart(view, verticalHelper, false);
            } else {
                iArr[1] = distanceToEnd(view, verticalHelper, false);
            }
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    @Override // androidx.recyclerview.widget.LinearSnapHelper, androidx.recyclerview.widget.SnapHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View findSnapView(androidx.recyclerview.widget.RecyclerView.LayoutManager r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof androidx.recyclerview.widget.LinearLayoutManager
            if (r0 == 0) goto L35
            int r0 = r2.gravity
            r1 = 48
            if (r0 == r1) goto L2c
            r1 = 80
            if (r0 == r1) goto L23
            r1 = 8388611(0x800003, float:1.1754948E-38)
            if (r0 == r1) goto L1e
            r1 = 8388613(0x800005, float:1.175495E-38)
            if (r0 == r1) goto L19
            goto L35
        L19:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getHorizontalHelper(r3)
            goto L27
        L1e:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getHorizontalHelper(r3)
            goto L30
        L23:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getVerticalHelper(r3)
        L27:
            android.view.View r3 = r2.findEndView(r3, r0)
            goto L36
        L2c:
            androidx.recyclerview.widget.OrientationHelper r0 = r2.getVerticalHelper(r3)
        L30:
            android.view.View r3 = r2.findStartView(r3, r0)
            goto L36
        L35:
            r3 = 0
        L36:
            if (r3 == 0) goto L3a
            r0 = 1
            goto L3b
        L3a:
            r0 = 0
        L3b:
            r2.snapping = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wdullaer.materialdatetimepicker.GravitySnapHelper.findSnapView(androidx.recyclerview.widget.RecyclerView$LayoutManager):android.view.View");
    }
}
