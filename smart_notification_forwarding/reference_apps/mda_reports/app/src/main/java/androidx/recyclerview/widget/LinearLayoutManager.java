package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    int k;
    OrientationHelper l;
    boolean m;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;
    int n;
    int o;
    SavedState p;
    final AnchorInfo q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnchorInfo {
        OrientationHelper a;
        int b;
        int c;
        boolean d;
        boolean e;

        AnchorInfo() {
            b();
        }

        void a() {
            this.c = this.d ? this.a.getEndAfterPadding() : this.a.getStartAfterPadding();
        }

        boolean a(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount();
        }

        public void assignFromView(View view, int i) {
            this.c = this.d ? this.a.getDecoratedEnd(view) + this.a.getTotalSpaceChange() : this.a.getDecoratedStart(view);
            this.b = i;
        }

        public void assignFromViewAndKeepVisibleRect(View view, int i) {
            int totalSpaceChange = this.a.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                assignFromView(view, i);
                return;
            }
            this.b = i;
            if (this.d) {
                int endAfterPadding = (this.a.getEndAfterPadding() - totalSpaceChange) - this.a.getDecoratedEnd(view);
                this.c = this.a.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.c - this.a.getDecoratedMeasurement(view);
                    int startAfterPadding = this.a.getStartAfterPadding();
                    int min = decoratedMeasurement - (startAfterPadding + Math.min(this.a.getDecoratedStart(view) - startAfterPadding, 0));
                    if (min < 0) {
                        this.c += Math.min(endAfterPadding, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = this.a.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - this.a.getStartAfterPadding();
            this.c = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (this.a.getEndAfterPadding() - Math.min(0, (this.a.getEndAfterPadding() - totalSpaceChange) - this.a.getDecoratedEnd(view))) - (decoratedStart + this.a.getDecoratedMeasurement(view));
                if (endAfterPadding2 < 0) {
                    this.c -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        void b() {
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.b + ", mCoordinate=" + this.c + ", mLayoutFromEnd=" + this.d + ", mValid=" + this.e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        protected LayoutChunkResult() {
        }

        void a() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LayoutState {
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        boolean j;
        int k;
        boolean m;
        boolean a = true;
        int h = 0;
        int i = 0;
        List<RecyclerView.ViewHolder> l = null;

        LayoutState() {
        }

        private View nextViewFromScrapList() {
            int size = this.l.size();
            for (int i = 0; i < size; i++) {
                View view = this.l.get(i).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.d == layoutParams.getViewLayoutPosition()) {
                    assignPositionFromScrapList(view);
                    return view;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View a(RecyclerView.Recycler recycler) {
            if (this.l != null) {
                return nextViewFromScrapList();
            }
            View viewForPosition = recycler.getViewForPosition(this.d);
            this.d += this.e;
            return viewForPosition;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(RecyclerView.State state) {
            int i = this.d;
            return i >= 0 && i < state.getItemCount();
        }

        public void assignPositionFromScrapList() {
            assignPositionFromScrapList(null);
        }

        public void assignPositionFromScrapList(View view) {
            View nextViewInLimitedList = nextViewInLimitedList(view);
            this.d = nextViewInLimitedList == null ? -1 : ((RecyclerView.LayoutParams) nextViewInLimitedList.getLayoutParams()).getViewLayoutPosition();
        }

        public View nextViewInLimitedList(View view) {
            int viewLayoutPosition;
            int size = this.l.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.l.get(i2).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.d) * this.e) >= 0 && viewLayoutPosition < i) {
                    view2 = view3;
                    if (viewLayoutPosition == 0) {
                        break;
                    }
                    i = viewLayoutPosition;
                }
            }
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.LinearLayoutManager.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int a;
        int b;
        boolean c;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.a = savedState.a;
            this.b = savedState.b;
            this.c = savedState.c;
        }

        boolean a() {
            return this.a >= 0;
        }

        void b() {
            this.a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.k = 1;
        this.mReverseLayout = false;
        this.m = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.n = -1;
        this.o = Integer.MIN_VALUE;
        this.p = null;
        this.q = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.k = 1;
        this.mReverseLayout = false;
        this.m = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.n = -1;
        this.o = Integer.MIN_VALUE;
        this.p = null;
        this.q = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        e();
        return ScrollbarHelper.a(state, this.l, b(!this.mSmoothScrollbarEnabled, true), a(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        e();
        return ScrollbarHelper.a(state, this.l, b(!this.mSmoothScrollbarEnabled, true), a(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.m);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        e();
        return ScrollbarHelper.b(state, this.l, b(!this.mSmoothScrollbarEnabled, true), a(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return c(0, getChildCount());
    }

    private View findFirstReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(recycler, state, 0, getChildCount(), state.getItemCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return c(getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(recycler, state, getChildCount() - 1, -1, state.getItemCount());
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.m ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.m ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findReferenceChildClosestToEnd(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.m ? findFirstReferenceChild(recycler, state) : findLastReferenceChild(recycler, state);
    }

    private View findReferenceChildClosestToStart(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.m ? findLastReferenceChild(recycler, state) : findFirstReferenceChild(recycler, state);
    }

    private int fixLayoutEndGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int endAfterPadding2 = this.l.getEndAfterPadding() - i;
        if (endAfterPadding2 <= 0) {
            return 0;
        }
        int i2 = -a(-endAfterPadding2, recycler, state);
        int i3 = i + i2;
        if (!z || (endAfterPadding = this.l.getEndAfterPadding() - i3) <= 0) {
            return i2;
        }
        this.l.offsetChildren(endAfterPadding);
        return endAfterPadding + i2;
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int startAfterPadding2 = i - this.l.getStartAfterPadding();
        if (startAfterPadding2 <= 0) {
            return 0;
        }
        int i2 = -a(startAfterPadding2, recycler, state);
        int i3 = i + i2;
        if (!z || (startAfterPadding = i3 - this.l.getStartAfterPadding()) <= 0) {
            return i2;
        }
        this.l.offsetChildren(-startAfterPadding);
        return i2 - startAfterPadding;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.m ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.m ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        if (!state.willRunPredictiveAnimations() || getChildCount() == 0 || state.isPreLayout() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
        int size = scrapList.size();
        int position = getPosition(getChildAt(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.ViewHolder viewHolder = scrapList.get(i5);
            if (!viewHolder.k()) {
                char c = (viewHolder.getLayoutPosition() < position) != this.m ? (char) 65535 : (char) 1;
                int decoratedMeasurement = this.l.getDecoratedMeasurement(viewHolder.itemView);
                if (c == 65535) {
                    i3 += decoratedMeasurement;
                } else {
                    i4 += decoratedMeasurement;
                }
            }
        }
        this.mLayoutState.l = scrapList;
        if (i3 > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
            LayoutState layoutState = this.mLayoutState;
            layoutState.h = i3;
            layoutState.c = 0;
            layoutState.assignPositionFromScrapList();
            a(recycler, this.mLayoutState, state, false);
        }
        if (i4 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.h = i4;
            layoutState2.c = 0;
            layoutState2.assignPositionFromScrapList();
            a(recycler, this.mLayoutState, state, false);
        }
        this.mLayoutState.l = null;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.l.getDecoratedStart(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (!layoutState.a || layoutState.m) {
            return;
        }
        int i = layoutState.g;
        int i2 = layoutState.i;
        if (layoutState.f == -1) {
            recycleViewsFromEnd(recycler, i, i2);
        } else {
            recycleViewsFromStart(recycler, i, i2);
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                removeAndRecycleViewAt(i, recycler);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                removeAndRecycleViewAt(i3, recycler);
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int i, int i2) {
        int childCount = getChildCount();
        if (i < 0) {
            return;
        }
        int end = (this.l.getEnd() - i) + i2;
        if (this.m) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (this.l.getDecoratedStart(childAt) < end || this.l.getTransformedStartWithDecoration(childAt) < end) {
                    recycleChildren(recycler, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = childCount - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            if (this.l.getDecoratedStart(childAt2) < end || this.l.getTransformedStartWithDecoration(childAt2) < end) {
                recycleChildren(recycler, i4, i5);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int childCount = getChildCount();
        if (!this.m) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (this.l.getDecoratedEnd(childAt) > i3 || this.l.getTransformedEndWithDecoration(childAt) > i3) {
                    recycleChildren(recycler, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = childCount - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            if (this.l.getDecoratedEnd(childAt2) > i3 || this.l.getTransformedEndWithDecoration(childAt2) > i3) {
                recycleChildren(recycler, i5, i6);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        this.m = (this.k == 1 || !f()) ? this.mReverseLayout : !this.mReverseLayout;
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && anchorInfo.a(focusedChild, state)) {
            anchorInfo.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
            return true;
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        View findReferenceChildClosestToEnd = anchorInfo.d ? findReferenceChildClosestToEnd(recycler, state) : findReferenceChildClosestToStart(recycler, state);
        if (findReferenceChildClosestToEnd == null) {
            return false;
        }
        anchorInfo.assignFromView(findReferenceChildClosestToEnd, getPosition(findReferenceChildClosestToEnd));
        if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
            if (this.l.getDecoratedStart(findReferenceChildClosestToEnd) >= this.l.getEndAfterPadding() || this.l.getDecoratedEnd(findReferenceChildClosestToEnd) < this.l.getStartAfterPadding()) {
                anchorInfo.c = anchorInfo.d ? this.l.getEndAfterPadding() : this.l.getStartAfterPadding();
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i;
        if (!state.isPreLayout() && (i = this.n) != -1) {
            if (i >= 0 && i < state.getItemCount()) {
                anchorInfo.b = this.n;
                SavedState savedState = this.p;
                if (savedState != null && savedState.a()) {
                    anchorInfo.d = this.p.c;
                    anchorInfo.c = anchorInfo.d ? this.l.getEndAfterPadding() - this.p.b : this.l.getStartAfterPadding() + this.p.b;
                    return true;
                }
                if (this.o != Integer.MIN_VALUE) {
                    boolean z = this.m;
                    anchorInfo.d = z;
                    anchorInfo.c = z ? this.l.getEndAfterPadding() - this.o : this.l.getStartAfterPadding() + this.o;
                    return true;
                }
                View findViewByPosition = findViewByPosition(this.n);
                if (findViewByPosition == null) {
                    if (getChildCount() > 0) {
                        anchorInfo.d = (this.n < getPosition(getChildAt(0))) == this.m;
                    }
                    anchorInfo.a();
                } else {
                    if (this.l.getDecoratedMeasurement(findViewByPosition) > this.l.getTotalSpace()) {
                        anchorInfo.a();
                        return true;
                    }
                    if (this.l.getDecoratedStart(findViewByPosition) - this.l.getStartAfterPadding() < 0) {
                        anchorInfo.c = this.l.getStartAfterPadding();
                        anchorInfo.d = false;
                        return true;
                    }
                    if (this.l.getEndAfterPadding() - this.l.getDecoratedEnd(findViewByPosition) < 0) {
                        anchorInfo.c = this.l.getEndAfterPadding();
                        anchorInfo.d = true;
                        return true;
                    }
                    anchorInfo.c = anchorInfo.d ? this.l.getDecoratedEnd(findViewByPosition) + this.l.getTotalSpaceChange() : this.l.getDecoratedStart(findViewByPosition);
                }
                return true;
            }
            this.n = -1;
            this.o = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        if (updateAnchorFromPendingData(state, anchorInfo) || updateAnchorFromChildren(recycler, state, anchorInfo)) {
            return;
        }
        anchorInfo.a();
        anchorInfo.b = this.mStackFromEnd ? state.getItemCount() - 1 : 0;
    }

    private void updateLayoutState(int i, int i2, boolean z, RecyclerView.State state) {
        int startAfterPadding;
        this.mLayoutState.m = g();
        this.mLayoutState.f = i;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        a(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z2 = i == 1;
        this.mLayoutState.h = z2 ? max2 : max;
        LayoutState layoutState = this.mLayoutState;
        if (!z2) {
            max = max2;
        }
        layoutState.i = max;
        if (z2) {
            this.mLayoutState.h += this.l.getEndPadding();
            View childClosestToEnd = getChildClosestToEnd();
            this.mLayoutState.e = this.m ? -1 : 1;
            LayoutState layoutState2 = this.mLayoutState;
            int position = getPosition(childClosestToEnd);
            LayoutState layoutState3 = this.mLayoutState;
            layoutState2.d = position + layoutState3.e;
            layoutState3.b = this.l.getDecoratedEnd(childClosestToEnd);
            startAfterPadding = this.l.getDecoratedEnd(childClosestToEnd) - this.l.getEndAfterPadding();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.h += this.l.getStartAfterPadding();
            this.mLayoutState.e = this.m ? 1 : -1;
            LayoutState layoutState4 = this.mLayoutState;
            int position2 = getPosition(childClosestToStart);
            LayoutState layoutState5 = this.mLayoutState;
            layoutState4.d = position2 + layoutState5.e;
            layoutState5.b = this.l.getDecoratedStart(childClosestToStart);
            startAfterPadding = (-this.l.getDecoratedStart(childClosestToStart)) + this.l.getStartAfterPadding();
        }
        LayoutState layoutState6 = this.mLayoutState;
        layoutState6.c = i2;
        if (z) {
            layoutState6.c -= startAfterPadding;
        }
        this.mLayoutState.g = startAfterPadding;
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.c = this.l.getEndAfterPadding() - i2;
        this.mLayoutState.e = this.m ? -1 : 1;
        LayoutState layoutState = this.mLayoutState;
        layoutState.d = i;
        layoutState.f = 1;
        layoutState.b = i2;
        layoutState.g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        updateLayoutStateToFillEnd(anchorInfo.b, anchorInfo.c);
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.c = i2 - this.l.getStartAfterPadding();
        LayoutState layoutState = this.mLayoutState;
        layoutState.d = i;
        layoutState.e = this.m ? 1 : -1;
        LayoutState layoutState2 = this.mLayoutState;
        layoutState2.f = -1;
        layoutState2.b = i2;
        layoutState2.g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        updateLayoutStateToFillStart(anchorInfo.b, anchorInfo.c);
    }

    int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        e();
        this.mLayoutState.a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        updateLayoutState(i2, abs, true, state);
        LayoutState layoutState = this.mLayoutState;
        int a = layoutState.g + a(recycler, layoutState, state, false);
        if (a < 0) {
            return 0;
        }
        if (abs > a) {
            i = i2 * a;
        }
        this.l.offsetChildren(-i);
        this.mLayoutState.k = i;
        return i;
    }

    int a(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z) {
        int i = layoutState.c;
        int i2 = layoutState.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                layoutState.g = i2 + i;
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int i3 = layoutState.c + layoutState.h;
        LayoutChunkResult layoutChunkResult = this.mLayoutChunkResult;
        while (true) {
            if ((!layoutState.m && i3 <= 0) || !layoutState.a(state)) {
                break;
            }
            layoutChunkResult.a();
            a(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                layoutState.b += layoutChunkResult.mConsumed * layoutState.f;
                if (!layoutChunkResult.mIgnoreConsumed || layoutState.l != null || !state.isPreLayout()) {
                    int i4 = layoutState.c;
                    int i5 = layoutChunkResult.mConsumed;
                    layoutState.c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = layoutState.g;
                if (i6 != Integer.MIN_VALUE) {
                    layoutState.g = i6 + layoutChunkResult.mConsumed;
                    int i7 = layoutState.c;
                    if (i7 < 0) {
                        layoutState.g += i7;
                    }
                    recycleByLayoutState(recycler, layoutState);
                }
                if (z && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - layoutState.c;
    }

    @Deprecated
    protected int a(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return this.l.getTotalSpace();
        }
        return 0;
    }

    View a(int i, int i2, boolean z, boolean z2) {
        e();
        return (this.k == 0 ? this.c : this.d).a(i, i2, z ? 24579 : 320, z2 ? 320 : 0);
    }

    View a(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3) {
        e();
        int startAfterPadding = this.l.getStartAfterPadding();
        int endAfterPadding = this.l.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.l.getDecoratedStart(childAt) < endAfterPadding && this.l.getDecoratedEnd(childAt) >= startAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(boolean z, boolean z2) {
        int childCount;
        int i;
        if (this.m) {
            childCount = 0;
            i = getChildCount();
        } else {
            childCount = getChildCount() - 1;
            i = -1;
        }
        return a(childCount, i, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i) {
    }

    void a(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int decoratedMeasurementInOther;
        View a = layoutState.a(recycler);
        if (a == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) a.getLayoutParams();
        if (layoutState.l == null) {
            if (this.m == (layoutState.f == -1)) {
                addView(a);
            } else {
                addView(a, 0);
            }
        } else {
            if (this.m == (layoutState.f == -1)) {
                addDisappearingView(a);
            } else {
                addDisappearingView(a, 0);
            }
        }
        measureChildWithMargins(a, 0, 0);
        layoutChunkResult.mConsumed = this.l.getDecoratedMeasurement(a);
        if (this.k == 1) {
            if (f()) {
                decoratedMeasurementInOther = getWidth() - getPaddingRight();
                i4 = decoratedMeasurementInOther - this.l.getDecoratedMeasurementInOther(a);
            } else {
                i4 = getPaddingLeft();
                decoratedMeasurementInOther = this.l.getDecoratedMeasurementInOther(a) + i4;
            }
            int i5 = layoutState.f;
            int i6 = layoutState.b;
            if (i5 == -1) {
                i3 = i6;
                i2 = decoratedMeasurementInOther;
                i = i6 - layoutChunkResult.mConsumed;
            } else {
                i = i6;
                i2 = decoratedMeasurementInOther;
                i3 = layoutChunkResult.mConsumed + i6;
            }
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther2 = this.l.getDecoratedMeasurementInOther(a) + paddingTop;
            int i7 = layoutState.f;
            int i8 = layoutState.b;
            if (i7 == -1) {
                i2 = i8;
                i = paddingTop;
                i3 = decoratedMeasurementInOther2;
                i4 = i8 - layoutChunkResult.mConsumed;
            } else {
                i = paddingTop;
                i2 = layoutChunkResult.mConsumed + i8;
                i3 = decoratedMeasurementInOther2;
                i4 = i8;
            }
        }
        layoutDecoratedWithMargins(a, i4, i, i2, i3);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = a.hasFocusable();
    }

    void a(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = layoutState.d;
        if (i < 0 || i >= state.getItemCount()) {
            return;
        }
        layoutPrefetchRegistry.addPosition(i, Math.max(0, layoutState.g));
    }

    protected void a(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
        int i;
        int a = a(state);
        if (this.mLayoutState.f == -1) {
            i = 0;
        } else {
            i = a;
            a = 0;
        }
        iArr[0] = a;
        iArr[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.p == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(boolean z, boolean z2) {
        int i;
        int childCount;
        if (this.m) {
            i = getChildCount() - 1;
            childCount = -1;
        } else {
            i = 0;
            childCount = getChildCount();
        }
        return a(i, childCount, z, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    boolean b() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !a()) ? false : true;
    }

    View c(int i, int i2) {
        int i3;
        int i4;
        e();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return getChildAt(i);
        }
        if (this.l.getDecoratedStart(getChildAt(i)) < this.l.getStartAfterPadding()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        return (this.k == 0 ? this.c : this.d).a(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.k == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.k == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.k != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        e();
        updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), true, state);
        a(state, this.mLayoutState, layoutPrefetchRegistry);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectInitialPrefetchPositions(int i, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z;
        int i2;
        SavedState savedState = this.p;
        if (savedState == null || !savedState.a()) {
            resolveShouldLayoutReverse();
            z = this.m;
            i2 = this.n;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.p;
            z = savedState2.c;
            i2 = savedState2.a;
        }
        int i3 = z ? -1 : 1;
        int i4 = i2;
        for (int i5 = 0; i5 < this.mInitialPrefetchItemCount && i4 >= 0 && i4 < i; i5++) {
            layoutPrefetchRegistry.addPosition(i4, 0);
            i4 += i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (i < getPosition(getChildAt(0))) != this.m ? -1 : 1;
        return this.k == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.k == 1) ? 1 : Integer.MIN_VALUE : this.k == 0 ? 1 : Integer.MIN_VALUE : this.k == 1 ? -1 : Integer.MIN_VALUE : this.k == 0 ? -1 : Integer.MIN_VALUE : (this.k != 1 && f()) ? -1 : 1 : (this.k != 1 && f()) ? 1 : -1;
    }

    LayoutState d() {
        return new LayoutState();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.mLayoutState == null) {
            this.mLayoutState = d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f() {
        return getLayoutDirection() == 1;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View a = a(0, getChildCount(), true, false);
        if (a == null) {
            return -1;
        }
        return getPosition(a);
    }

    public int findFirstVisibleItemPosition() {
        View a = a(0, getChildCount(), false, true);
        if (a == null) {
            return -1;
        }
        return getPosition(a);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View a = a(getChildCount() - 1, -1, true, false);
        if (a == null) {
            return -1;
        }
        return getPosition(a);
    }

    public int findLastVisibleItemPosition() {
        View a = a(getChildCount() - 1, -1, false, true);
        if (a == null) {
            return -1;
        }
        return getPosition(a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    boolean g() {
        return this.l.getMode() == 0 && this.l.getEnd() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.k;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        e();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (this.l.getTotalSpace() * MAX_SCROLL_FACTOR), false, state);
        LayoutState layoutState = this.mLayoutState;
        layoutState.g = Integer.MIN_VALUE;
        layoutState.a = false;
        a(recycler, layoutState, state, true);
        View findPartiallyOrCompletelyInvisibleChildClosestToStart = convertFocusDirectionToLayoutDirection == -1 ? findPartiallyOrCompletelyInvisibleChildClosestToStart() : findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        View childClosestToStart = convertFocusDirectionToLayoutDirection == -1 ? getChildClosestToStart() : getChildClosestToEnd();
        if (!childClosestToStart.hasFocusable()) {
            return findPartiallyOrCompletelyInvisibleChildClosestToStart;
        }
        if (findPartiallyOrCompletelyInvisibleChildClosestToStart == null) {
            return null;
        }
        return childClosestToStart;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        int fixLayoutEndGap;
        int i5;
        View findViewByPosition;
        int decoratedStart;
        int i6;
        int i7 = -1;
        if (!(this.p == null && this.n == -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        SavedState savedState = this.p;
        if (savedState != null && savedState.a()) {
            this.n = this.p.a;
        }
        e();
        this.mLayoutState.a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        if (!this.q.e || this.n != -1 || this.p != null) {
            this.q.b();
            AnchorInfo anchorInfo = this.q;
            anchorInfo.d = this.m ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(recycler, state, anchorInfo);
            this.q.e = true;
        } else if (focusedChild != null && (this.l.getDecoratedStart(focusedChild) >= this.l.getEndAfterPadding() || this.l.getDecoratedEnd(focusedChild) <= this.l.getStartAfterPadding())) {
            this.q.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
        }
        LayoutState layoutState = this.mLayoutState;
        layoutState.f = layoutState.k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        a(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.l.getStartAfterPadding();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.l.getEndPadding();
        if (state.isPreLayout() && (i5 = this.n) != -1 && this.o != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i5)) != null) {
            if (this.m) {
                i6 = this.l.getEndAfterPadding() - this.l.getDecoratedEnd(findViewByPosition);
                decoratedStart = this.o;
            } else {
                decoratedStart = this.l.getDecoratedStart(findViewByPosition) - this.l.getStartAfterPadding();
                i6 = this.o;
            }
            int i8 = i6 - decoratedStart;
            if (i8 > 0) {
                max += i8;
            } else {
                max2 -= i8;
            }
        }
        if (!this.q.d ? !this.m : this.m) {
            i7 = 1;
        }
        a(recycler, state, this.q, i7);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.m = g();
        this.mLayoutState.j = state.isPreLayout();
        this.mLayoutState.i = 0;
        AnchorInfo anchorInfo2 = this.q;
        if (anchorInfo2.d) {
            updateLayoutStateToFillStart(anchorInfo2);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.h = max;
            a(recycler, layoutState2, state, false);
            LayoutState layoutState3 = this.mLayoutState;
            i2 = layoutState3.b;
            int i9 = layoutState3.d;
            int i10 = layoutState3.c;
            if (i10 > 0) {
                max2 += i10;
            }
            updateLayoutStateToFillEnd(this.q);
            LayoutState layoutState4 = this.mLayoutState;
            layoutState4.h = max2;
            layoutState4.d += layoutState4.e;
            a(recycler, layoutState4, state, false);
            LayoutState layoutState5 = this.mLayoutState;
            i = layoutState5.b;
            int i11 = layoutState5.c;
            if (i11 > 0) {
                updateLayoutStateToFillStart(i9, i2);
                LayoutState layoutState6 = this.mLayoutState;
                layoutState6.h = i11;
                a(recycler, layoutState6, state, false);
                i2 = this.mLayoutState.b;
            }
        } else {
            updateLayoutStateToFillEnd(anchorInfo2);
            LayoutState layoutState7 = this.mLayoutState;
            layoutState7.h = max2;
            a(recycler, layoutState7, state, false);
            LayoutState layoutState8 = this.mLayoutState;
            i = layoutState8.b;
            int i12 = layoutState8.d;
            int i13 = layoutState8.c;
            if (i13 > 0) {
                max += i13;
            }
            updateLayoutStateToFillStart(this.q);
            LayoutState layoutState9 = this.mLayoutState;
            layoutState9.h = max;
            layoutState9.d += layoutState9.e;
            a(recycler, layoutState9, state, false);
            LayoutState layoutState10 = this.mLayoutState;
            i2 = layoutState10.b;
            int i14 = layoutState10.c;
            if (i14 > 0) {
                updateLayoutStateToFillEnd(i12, i);
                LayoutState layoutState11 = this.mLayoutState;
                layoutState11.h = i14;
                a(recycler, layoutState11, state, false);
                i = this.mLayoutState.b;
            }
        }
        if (getChildCount() > 0) {
            if (this.m ^ this.mStackFromEnd) {
                int fixLayoutEndGap2 = fixLayoutEndGap(i, recycler, state, true);
                i3 = i2 + fixLayoutEndGap2;
                i4 = i + fixLayoutEndGap2;
                fixLayoutEndGap = fixLayoutStartGap(i3, recycler, state, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i2, recycler, state, true);
                i3 = i2 + fixLayoutStartGap;
                i4 = i + fixLayoutStartGap;
                fixLayoutEndGap = fixLayoutEndGap(i4, recycler, state, false);
            }
            i2 = i3 + fixLayoutEndGap;
            i = i4 + fixLayoutEndGap;
        }
        layoutForPredictiveAnimations(recycler, state, i2, i);
        if (state.isPreLayout()) {
            this.q.b();
        } else {
            this.l.onLayoutComplete();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.p = null;
        this.n = -1;
        this.o = Integer.MIN_VALUE;
        this.q.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.p = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.p;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            e();
            boolean z = this.mLastStackFromEnd ^ this.m;
            savedState2.c = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState2.b = this.l.getEndAfterPadding() - this.l.getDecoratedEnd(childClosestToEnd);
                savedState2.a = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState2.a = getPosition(childClosestToStart);
                savedState2.b = this.l.getDecoratedStart(childClosestToStart) - this.l.getStartAfterPadding();
            }
        } else {
            savedState2.b();
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void prepareForDrop(@NonNull View view, @NonNull View view2, int i, int i2) {
        int decoratedStart;
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        e();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c = position < position2 ? (char) 1 : (char) 65535;
        if (this.m) {
            if (c == 1) {
                scrollToPositionWithOffset(position2, this.l.getEndAfterPadding() - (this.l.getDecoratedStart(view2) + this.l.getDecoratedMeasurement(view)));
                return;
            }
            decoratedStart = this.l.getEndAfterPadding() - this.l.getDecoratedEnd(view2);
        } else {
            if (c != 65535) {
                scrollToPositionWithOffset(position2, this.l.getDecoratedEnd(view2) - this.l.getDecoratedMeasurement(view));
                return;
            }
            decoratedStart = this.l.getDecoratedStart(view2);
        }
        scrollToPositionWithOffset(position2, decoratedStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.k == 1) {
            return 0;
        }
        return a(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.n = i;
        this.o = Integer.MIN_VALUE;
        SavedState savedState = this.p;
        if (savedState != null) {
            savedState.b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.n = i;
        this.o = i2;
        SavedState savedState = this.p;
        if (savedState != null) {
            savedState.b();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.k == 0) {
            return 0;
        }
        return a(i, recycler, state);
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.k || this.l == null) {
            this.l = OrientationHelper.createOrientationHelper(this, i);
            this.q.a = this.l;
            this.k = i;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.p == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }
}
