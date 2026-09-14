package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import com.google.common.primitives.Ints;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    static final boolean G;
    static final boolean H;
    public static final int HORIZONTAL = 0;
    static final boolean I;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    static final boolean J;
    static final Interpolator K;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    boolean A;
    boolean B;
    boolean C;
    RecyclerViewAccessibilityDelegate D;
    final int[] E;

    @VisibleForTesting
    final List<ViewHolder> F;
    final Recycler a;
    AdapterHelper b;
    ChildHelper c;
    final ViewInfoStore d;
    boolean e;
    final Runnable f;
    final Rect g;
    final RectF h;
    Adapter i;

    @VisibleForTesting
    LayoutManager j;
    RecyclerListener k;
    final ArrayList<ItemDecoration> l;
    boolean m;
    private final AccessibilityManager mAccessibilityManager;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;

    @NonNull
    private EdgeEffectFactory mEdgeEffectFactory;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    private int mLastTouchX;
    private int mLastTouchY;
    private int mLayoutOrScrollCounter;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    private SavedState mPendingSavedState;
    private boolean mPreserveFocusAfterLayout;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    private final Rect mTempRect2;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    boolean n;
    boolean o;

    @VisibleForTesting
    boolean p;
    boolean q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    ItemAnimator v;
    final ViewFlinger w;
    GapWorker x;
    GapWorker.LayoutPrefetchRegistryImpl y;
    final State z;

    /* loaded from: classes.dex */
    public static abstract class Adapter<VH extends ViewHolder> {
        private final AdapterDataObservable mObservable = new AdapterDataObservable();
        private boolean mHasStableIds = false;

        public final void bindViewHolder(@NonNull VH vh, int i) {
            vh.b = i;
            if (hasStableIds()) {
                vh.d = getItemId(i);
            }
            vh.a(1, 519);
            TraceCompat.beginSection("RV OnBindView");
            onBindViewHolder(vh, i, vh.f());
            vh.b();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).c = true;
            }
            TraceCompat.endSection();
        }

        @NonNull
        public final VH createViewHolder(@NonNull ViewGroup viewGroup, int i) {
            try {
                TraceCompat.beginSection("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                onCreateViewHolder.e = i;
                return onCreateViewHolder;
            } finally {
                TraceCompat.endSection();
            }
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.notifyItemRangeChanged(i, 1);
        }

        public final void notifyItemChanged(int i, @Nullable Object obj) {
            this.mObservable.notifyItemRangeChanged(i, 1, obj);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.notifyItemRangeInserted(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.notifyItemMoved(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.notifyItemRangeChanged(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
            this.mObservable.notifyItemRangeChanged(i, i2, obj);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.notifyItemRangeInserted(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.notifyItemRangeRemoved(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.notifyItemRangeRemoved(i, 1);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(@NonNull VH vh, int i);

        public void onBindViewHolder(@NonNull VH vh, int i, @NonNull List<Object> list) {
            onBindViewHolder(vh, i);
        }

        @NonNull
        public abstract VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(@NonNull VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(@NonNull VH vh) {
        }

        public void onViewDetachedFromWindow(@NonNull VH vh) {
        }

        public void onViewRecycled(@NonNull VH vh) {
        }

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public void unregisterAdapterDataObserver(@NonNull AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void notifyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public void notifyItemMoved(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }

        public void notifyItemRangeChanged(int i, int i2) {
            notifyItemRangeChanged(i, i2, null);
        }

        public void notifyItemRangeChanged(int i, int i2, @Nullable Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        public void notifyItemRangeInserted(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public void notifyItemRangeRemoved(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
            onItemRangeChanged(i, i2);
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i, int i2);
    }

    /* loaded from: classes.dex */
    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface EdgeDirection {
        }

        @NonNull
        protected EdgeEffect a(@NonNull RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private ItemAnimatorListener mListener = null;
        private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList<>();
        private long mAddDuration = 120;
        private long mRemoveDuration = 120;
        private long mMoveDuration = 250;
        private long mChangeDuration = 250;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface AdapterChanges {
        }

        /* loaded from: classes.dex */
        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public interface ItemAnimatorListener {
            void onAnimationFinished(@NonNull ViewHolder viewHolder);
        }

        /* loaded from: classes.dex */
        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder) {
                return setFrom(viewHolder, 0);
            }

            @NonNull
            public ItemHolderInfo setFrom(@NonNull ViewHolder viewHolder, int i) {
                View view = viewHolder.itemView;
                this.left = view.getLeft();
                this.top = view.getTop();
                this.right = view.getRight();
                this.bottom = view.getBottom();
                return this;
            }
        }

        static int a(ViewHolder viewHolder) {
            int i = viewHolder.i & 14;
            if (viewHolder.j()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = viewHolder.getOldPosition();
            int adapterPosition = viewHolder.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
        }

        void a(ItemAnimatorListener itemAnimatorListener) {
            this.mListener = itemAnimatorListener;
        }

        public abstract boolean animateAppearance(@NonNull ViewHolder viewHolder, @Nullable ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateDisappearance(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @Nullable ItemHolderInfo itemHolderInfo2);

        public abstract boolean animatePersistence(@NonNull ViewHolder viewHolder, @NonNull ItemHolderInfo itemHolderInfo, @NonNull ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder) {
            return true;
        }

        public boolean canReuseUpdatedViewHolder(@NonNull ViewHolder viewHolder, @NonNull List<Object> list) {
            return canReuseUpdatedViewHolder(viewHolder);
        }

        public final void dispatchAnimationFinished(@NonNull ViewHolder viewHolder) {
            onAnimationFinished(viewHolder);
            ItemAnimatorListener itemAnimatorListener = this.mListener;
            if (itemAnimatorListener != null) {
                itemAnimatorListener.onAnimationFinished(viewHolder);
            }
        }

        public final void dispatchAnimationStarted(@NonNull ViewHolder viewHolder) {
            onAnimationStarted(viewHolder);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i = 0; i < size; i++) {
                this.mFinishedListeners.get(i).onAnimationsFinished();
            }
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(@NonNull ViewHolder viewHolder);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(@Nullable ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean isRunning = isRunning();
            if (itemAnimatorFinishedListener != null) {
                if (isRunning) {
                    this.mFinishedListeners.add(itemAnimatorFinishedListener);
                } else {
                    itemAnimatorFinishedListener.onAnimationsFinished();
                }
            }
            return isRunning;
        }

        @NonNull
        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        public void onAnimationFinished(@NonNull ViewHolder viewHolder) {
        }

        public void onAnimationStarted(@NonNull ViewHolder viewHolder) {
        }

        @NonNull
        public ItemHolderInfo recordPostLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        @NonNull
        public ItemHolderInfo recordPreLayoutInformation(@NonNull State state, @NonNull ViewHolder viewHolder, int i, @NonNull List<Object> list) {
            return obtainHolderInfo().setFrom(viewHolder);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j) {
            this.mAddDuration = j;
        }

        public void setChangeDuration(long j) {
            this.mChangeDuration = j;
        }

        public void setMoveDuration(long j) {
            this.mMoveDuration = j;
        }

        public void setRemoveDuration(long j) {
            this.mRemoveDuration = j;
        }
    }

    /* loaded from: classes.dex */
    private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        ItemAnimatorRestoreListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void onAnimationFinished(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.g != null && viewHolder.h == null) {
                viewHolder.g = null;
            }
            viewHolder.h = null;
            if (viewHolder.r() || RecyclerView.this.d(viewHolder.itemView) || !viewHolder.m()) {
                return;
            }
            RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemDecoration {
        @Deprecated
        public void getItemOffsets(@NonNull Rect rect, int i, @NonNull RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        }

        public void onDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull State state) {
            onDrawOver(canvas, recyclerView);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class LayoutManager {
        ChildHelper a;
        RecyclerView b;

        @Nullable
        SmoothScroller e;
        int i;
        boolean j;
        private int mHeight;
        private int mHeightMode;
        private int mWidth;
        private int mWidthMode;
        private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.1
            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public View getChildAt(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getChildEnd(View view) {
                return LayoutManager.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getChildStart(View view) {
                return LayoutManager.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getParentEnd() {
                return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getParentStart() {
                return LayoutManager.this.getPaddingLeft();
            }
        };
        private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback = new ViewBoundsCheck.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.LayoutManager.2
            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public View getChildAt(int i) {
                return LayoutManager.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getChildEnd(View view) {
                return LayoutManager.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getChildStart(View view) {
                return LayoutManager.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getParentEnd() {
                return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getParentStart() {
                return LayoutManager.this.getPaddingTop();
            }
        };
        ViewBoundsCheck c = new ViewBoundsCheck(this.mHorizontalBoundCheckCallback);
        ViewBoundsCheck d = new ViewBoundsCheck(this.mVerticalBoundCheckCallback);
        boolean f = false;
        boolean g = false;
        boolean h = false;
        private boolean mMeasurementCacheEnabled = true;
        private boolean mItemPrefetchEnabled = true;

        /* loaded from: classes.dex */
        public interface LayoutPrefetchRegistry {
            void addPosition(int i, int i2);
        }

        /* loaded from: classes.dex */
        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        private void addViewInt(View view, int i, boolean z) {
            ViewHolder f = RecyclerView.f(view);
            if (z || f.k()) {
                this.b.d.a(f);
            } else {
                this.b.d.f(f);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (f.v() || f.l()) {
                if (f.l()) {
                    f.u();
                } else {
                    f.c();
                }
                this.a.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.b) {
                int b = this.a.b(view);
                if (i == -1) {
                    i = this.a.a();
                }
                if (b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.b.indexOfChild(view) + this.b.i());
                }
                if (b != i) {
                    this.b.j.moveView(b, i);
                }
            } else {
                this.a.a(view, i, false);
                layoutParams.c = true;
                SmoothScroller smoothScroller = this.e;
                if (smoothScroller != null && smoothScroller.isRunning()) {
                    this.e.a(view);
                }
            }
            if (layoutParams.d) {
                f.itemView.invalidate();
                layoutParams.d = false;
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
        }

        private void detachViewInternal(int i, @NonNull View view) {
            this.a.a(i);
        }

        public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z) {
            int i5;
            int i6 = i - i3;
            int i7 = 0;
            int max = Math.max(0, i6);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == Integer.MIN_VALUE || (i2 != 0 && i2 == 1073741824)) {
                            i5 = max;
                        } else {
                            i2 = 0;
                            i5 = 0;
                        }
                        i7 = i2;
                        max = i5;
                    }
                    max = 0;
                }
                max = i4;
                i7 = Ints.MAX_POWER_OF_TWO;
            } else {
                if (i4 < 0) {
                    if (i4 == -1) {
                        i7 = i2;
                    } else {
                        if (i4 == -2) {
                            if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                                i7 = Integer.MIN_VALUE;
                            }
                        }
                        max = 0;
                    }
                }
                max = i4;
                i7 = Ints.MAX_POWER_OF_TWO;
            }
            return View.MeasureSpec.makeMeasureSpec(max, i7);
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000a, code lost:
        
            if (r3 >= 0) goto L8;
         */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto Lf
                if (r3 < 0) goto Ld
                goto L11
            Ld:
                r1 = 0
                goto L1e
            Lf:
                if (r3 < 0) goto L15
            L11:
                r1 = r3
            L12:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L1e
            L15:
                r4 = -1
                if (r3 != r4) goto L19
                goto L12
            L19:
                r4 = -2
                if (r3 != r4) goto Ld
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
            L1e:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, boolean):int");
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i2 = top - paddingTop;
            int min2 = Math.min(0, i2);
            int i3 = width2 - width;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public static Properties getProperties(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i, i2);
            properties.orientation = obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.b.g;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i < width && rect.right - i > paddingLeft && rect.top - i2 < height && rect.bottom - i2 > paddingTop;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        private void scrapOrRecycleView(Recycler recycler, int i, View view) {
            ViewHolder f = RecyclerView.f(view);
            if (f.s()) {
                return;
            }
            if (f.j() && !f.k() && !this.b.i.hasStableIds()) {
                removeViewAt(i);
                recycler.b(f);
            } else {
                detachViewAt(i);
                recycler.b(view);
                this.b.d.onViewDetached(f);
            }
        }

        void a(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            this.mWidthMode = View.MeasureSpec.getMode(i);
            if (this.mWidthMode == 0 && !RecyclerView.H) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            this.mHeightMode = View.MeasureSpec.getMode(i2);
            if (this.mHeightMode != 0 || RecyclerView.H) {
                return;
            }
            this.mHeight = 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder f = RecyclerView.f(view);
            if (f == null || f.k() || this.a.c(f.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.b;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.a, recyclerView.z, view, accessibilityNodeInfoCompat);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.b;
            onInitializeAccessibilityNodeInfo(recyclerView.a, recyclerView.z, accessibilityNodeInfoCompat);
        }

        void a(Recycler recycler) {
            int d = recycler.d();
            for (int i = d - 1; i >= 0; i--) {
                View b = recycler.b(i);
                ViewHolder f = RecyclerView.f(b);
                if (!f.s()) {
                    f.setIsRecyclable(false);
                    if (f.m()) {
                        this.b.removeDetachedView(b, false);
                    }
                    ItemAnimator itemAnimator = this.b.v;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(f);
                    }
                    f.setIsRecyclable(true);
                    recycler.a(b);
                }
            }
            recycler.b();
            if (d > 0) {
                this.b.invalidate();
            }
        }

        void a(SmoothScroller smoothScroller) {
            if (this.e == smoothScroller) {
                this.e = null;
            }
        }

        void a(RecyclerView recyclerView) {
            this.g = true;
            onAttachedToWindow(recyclerView);
        }

        void a(RecyclerView recyclerView, Recycler recycler) {
            this.g = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(int i, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.b;
            return performAccessibilityAction(recyclerView.a, recyclerView.z, i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(@NonNull View view, int i, @Nullable Bundle bundle) {
            RecyclerView recyclerView = this.b;
            return performAccessibilityActionForItem(recyclerView.a, recyclerView.z, view, i, bundle);
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.a(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.b(str);
            }
        }

        public void attachView(@NonNull View view) {
            attachView(view, -1);
        }

        public void attachView(@NonNull View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public void attachView(@NonNull View view, int i, LayoutParams layoutParams) {
            ViewHolder f = RecyclerView.f(view);
            if (f.k()) {
                this.b.d.a(f);
            } else {
                this.b.d.f(f);
            }
            this.a.a(view, i, layoutParams, f.k());
        }

        void b(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.b.c(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.b.g;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left;
                if (i8 < i3) {
                    i3 = i8;
                }
                int i9 = rect.right;
                if (i9 > i5) {
                    i5 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i6) {
                    i6 = i11;
                }
            }
            this.b.g.set(i3, i4, i5, i6);
            setMeasuredDimension(this.b.g, i, i2);
        }

        void b(RecyclerView recyclerView) {
            a(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), Ints.MAX_POWER_OF_TWO));
        }

        boolean b() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean b(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        void c() {
            SmoothScroller smoothScroller = this.e;
            if (smoothScroller != null) {
                smoothScroller.c();
            }
        }

        void c(RecyclerView recyclerView) {
            int height;
            if (recyclerView == null) {
                this.b = null;
                this.a = null;
                height = 0;
                this.mWidth = 0;
            } else {
                this.b = recyclerView;
                this.a = recyclerView.c;
                this.mWidth = recyclerView.getWidth();
                height = recyclerView.getHeight();
            }
            this.mHeight = height;
            this.mWidthMode = Ints.MAX_POWER_OF_TWO;
            this.mHeightMode = Ints.MAX_POWER_OF_TWO;
        }

        public void calculateItemDecorationsForChild(@NonNull View view, @NonNull Rect rect) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.c(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void collectInitialPrefetchPositions(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public int computeHorizontalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(@NonNull State state) {
            return 0;
        }

        public int computeVerticalScrollRange(@NonNull State state) {
            return 0;
        }

        public void detachAndScrapAttachedViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(@NonNull View view, @NonNull Recycler recycler) {
            scrapOrRecycleView(recycler, this.a.b(view), view);
        }

        public void detachAndScrapViewAt(int i, @NonNull Recycler recycler) {
            scrapOrRecycleView(recycler, i, getChildAt(i));
        }

        public void detachView(@NonNull View view) {
            int b = this.a.b(view);
            if (b >= 0) {
                detachViewInternal(b, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        public void endAnimation(View view) {
            ItemAnimator itemAnimator = this.b.v;
            if (itemAnimator != null) {
                itemAnimator.endAnimation(RecyclerView.f(view));
            }
        }

        @Nullable
        public View findContainingItemView(@NonNull View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.a.c(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        @Nullable
        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder f = RecyclerView.f(childAt);
                if (f != null && f.getLayoutPosition() == i && !f.s() && (this.b.z.isPreLayout() || !f.k())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).b.bottom;
        }

        @Nullable
        public View getChildAt(int i) {
            ChildHelper childHelper = this.a;
            if (childHelper != null) {
                return childHelper.c(i);
            }
            return null;
        }

        public int getChildCount() {
            ChildHelper childHelper = this.a;
            if (childHelper != null) {
                return childHelper.a();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.b;
            return recyclerView != null && recyclerView.e;
        }

        public int getColumnCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || recyclerView.i == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.b.i.getItemCount();
        }

        public int getDecoratedBottom(@NonNull View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
            RecyclerView.a(view, rect);
        }

        public int getDecoratedLeft(@NonNull View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(@NonNull View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(@NonNull View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        @Nullable
        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.a.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        @Px
        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.b;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(@NonNull View view) {
            return RecyclerView.f(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.b);
        }

        public int getLeftDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).b.left;
        }

        @Px
        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.b);
        }

        @Px
        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.b);
        }

        @Px
        public int getPaddingBottom() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        @Px
        public int getPaddingEnd() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return ViewCompat.getPaddingEnd(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingLeft() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        @Px
        public int getPaddingRight() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        @Px
        public int getPaddingStart() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return ViewCompat.getPaddingStart(recyclerView);
            }
            return 0;
        }

        @Px
        public int getPaddingTop() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).b.right;
        }

        public int getRowCountForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || recyclerView.i == null || !canScrollVertically()) {
                return 1;
            }
            return this.b.i.getItemCount();
        }

        public int getSelectionModeForAccessibility(@NonNull Recycler recycler, @NonNull State state) {
            return 0;
        }

        public int getTopDecorationHeight(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).b.top;
        }

        public void getTransformedBoundingBox(@NonNull View view, boolean z, @NonNull Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.b.h;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        @Px
        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.b;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(@NonNull View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.b;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.b.i());
            }
            ViewHolder f = RecyclerView.f(view);
            f.a(128);
            this.b.d.g(f);
        }

        public boolean isAttachedToWindow() {
            return this.g;
        }

        public boolean isAutoMeasureEnabled() {
            return this.h;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.b;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(@NonNull Recycler recycler, @NonNull State state) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.e;
            return smoothScroller != null && smoothScroller.isRunning();
        }

        public boolean isViewPartiallyVisible(@NonNull View view, boolean z, boolean z2) {
            boolean z3 = this.c.a(view, 24579) && this.d.a(view, 24579);
            return z ? z3 : !z3;
        }

        public void layoutDecorated(@NonNull View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).b;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public void measureChild(@NonNull View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect c = this.b.c(view);
            int i3 = i + c.left + c.right;
            int i4 = i2 + c.top + c.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (a(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(@NonNull View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect c = this.b.c(view);
            int i3 = i + c.left + c.right;
            int i4 = i2 + c.top + c.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (a(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.b.toString());
            }
        }

        public void offsetChildrenHorizontal(@Px int i) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(@Px int i) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(@Nullable Adapter adapter, @Nullable Adapter adapter2) {
        }

        public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        @CallSuper
        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View view, int i, @NonNull Recycler recycler, @NonNull State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            onInitializeAccessibilityEvent(recyclerView.a, recyclerView.z, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.b.canScrollVertically(-1) && !this.b.canScrollHorizontally(-1) && !this.b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            Adapter adapter = this.b.i;
            if (adapter != null) {
                accessibilityEvent.setItemCount(adapter.getItemCount());
            }
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull Recycler recycler, @NonNull State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.b.canScrollVertically(-1) || this.b.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            if (this.b.canScrollVertically(1) || this.b.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View view, int i) {
            return null;
        }

        public void onItemsAdded(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(@NonNull RecyclerView recyclerView) {
        }

        public void onItemsMoved(@NonNull RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2, @Nullable Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(State state) {
        }

        public void onMeasure(@NonNull Recycler recycler, @NonNull State state, int i, int i2) {
            this.b.c(i, i2);
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull View view, @Nullable View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull State state, @NonNull View view, @Nullable View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public boolean performAccessibilityAction(@NonNull Recycler recycler, @NonNull State state, int i, @Nullable Bundle bundle) {
            int height;
            int width;
            int i2;
            int i3;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.b.canScrollHorizontally(1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    i2 = height;
                    i3 = width;
                }
                i2 = height;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.b.canScrollHorizontally(-1)) {
                    width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    i2 = height;
                    i3 = width;
                }
                i2 = height;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.b.a(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean performAccessibilityActionForItem(@NonNull Recycler recycler, @NonNull State state, @NonNull View view, int i, @Nullable Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                ViewCompat.postOnAnimation(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.a.e(childCount);
            }
        }

        public void removeAndRecycleAllViews(@NonNull Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.f(getChildAt(childCount)).s()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        public void removeAndRecycleView(@NonNull View view, @NonNull Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i, @NonNull Recycler recycler) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            recycler.recycleView(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(@NonNull View view) {
            this.b.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            this.a.d(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.a.e(i);
            }
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.f = true;
        }

        public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, Recycler recycler, State state) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.h = z;
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.i = 0;
                RecyclerView recyclerView = this.b;
                if (recyclerView != null) {
                    recyclerView.a.h();
                }
            }
        }

        public void setMeasuredDimension(int i, int i2) {
            this.b.setMeasuredDimension(i, i2);
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.e;
            if (smoothScroller2 != null && smoothScroller != smoothScroller2 && smoothScroller2.isRunning()) {
                this.e.c();
            }
            this.e = smoothScroller;
            this.e.a(this.b, this);
        }

        public void stopIgnoringView(@NonNull View view) {
            ViewHolder f = RecyclerView.f(view);
            f.t();
            f.p();
            f.a(4);
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        ViewHolder a;
        final Rect b;
        boolean c;
        boolean d;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public int getViewAdapterPosition() {
            return this.a.getAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.a.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.a.getPosition();
        }

        public boolean isItemChanged() {
            return this.a.n();
        }

        public boolean isItemRemoved() {
            return this.a.k();
        }

        public boolean isViewInvalid() {
            return this.a.j();
        }

        public boolean viewNeedsUpdate() {
            return this.a.o();
        }
    }

    /* loaded from: classes.dex */
    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View view);

        void onChildViewDetachedFromWindow(@NonNull View view);
    }

    /* loaded from: classes.dex */
    public static abstract class OnFlingListener {
        public abstract boolean onFling(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class OnScrollListener {
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        }

        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface Orientation {
    }

    /* loaded from: classes.dex */
    public static class RecycledViewPool {
        private static final int DEFAULT_MAX_SCRAP = 5;
        SparseArray<ScrapData> a = new SparseArray<>();
        private int mAttachCount = 0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class ScrapData {
            final ArrayList<ViewHolder> a = new ArrayList<>();
            int b = 5;
            long c = 0;
            long d = 0;

            ScrapData() {
            }
        }

        private ScrapData getScrapDataForType(int i) {
            ScrapData scrapData = this.a.get(i);
            if (scrapData != null) {
                return scrapData;
            }
            ScrapData scrapData2 = new ScrapData();
            this.a.put(i, scrapData2);
            return scrapData2;
        }

        long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        void a() {
            this.mAttachCount++;
        }

        void a(int i, long j) {
            ScrapData scrapDataForType = getScrapDataForType(i);
            scrapDataForType.d = a(scrapDataForType.d, j);
        }

        void a(Adapter adapter, Adapter adapter2, boolean z) {
            if (adapter != null) {
                b();
            }
            if (!z && this.mAttachCount == 0) {
                clear();
            }
            if (adapter2 != null) {
                a();
            }
        }

        boolean a(int i, long j, long j2) {
            long j3 = getScrapDataForType(i).d;
            return j3 == 0 || j + j3 < j2;
        }

        void b() {
            this.mAttachCount--;
        }

        void b(int i, long j) {
            ScrapData scrapDataForType = getScrapDataForType(i);
            scrapDataForType.c = a(scrapDataForType.c, j);
        }

        boolean b(int i, long j, long j2) {
            long j3 = getScrapDataForType(i).c;
            return j3 == 0 || j + j3 < j2;
        }

        public void clear() {
            for (int i = 0; i < this.a.size(); i++) {
                this.a.valueAt(i).a.clear();
            }
        }

        @Nullable
        public ViewHolder getRecycledView(int i) {
            ScrapData scrapData = this.a.get(i);
            if (scrapData == null || scrapData.a.isEmpty()) {
                return null;
            }
            ArrayList<ViewHolder> arrayList = scrapData.a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).h()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public int getRecycledViewCount(int i) {
            return getScrapDataForType(i).a.size();
        }

        public void putRecycledView(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = getScrapDataForType(itemViewType).a;
            if (this.a.get(itemViewType).b <= arrayList.size()) {
                return;
            }
            viewHolder.p();
            arrayList.add(viewHolder);
        }

        public void setMaxRecycledViews(int i, int i2) {
            ScrapData scrapDataForType = getScrapDataForType(i);
            scrapDataForType.b = i2;
            ArrayList<ViewHolder> arrayList = scrapDataForType.a;
            while (arrayList.size() > i2) {
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Recycler {
        RecycledViewPool e;
        private ViewCacheExtension mViewCacheExtension;
        final ArrayList<ViewHolder> a = new ArrayList<>();
        ArrayList<ViewHolder> b = null;
        final ArrayList<ViewHolder> c = new ArrayList<>();
        private final List<ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.a);
        private int mRequestedCacheMax = 2;
        int d = 2;

        public Recycler() {
        }

        private void attachAccessibilityDelegateOnBind(ViewHolder viewHolder) {
            if (RecyclerView.this.l()) {
                View view = viewHolder.itemView;
                if (ViewCompat.getImportantForAccessibility(view) == 0) {
                    ViewCompat.setImportantForAccessibility(view, 1);
                }
                RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.D;
                if (recyclerViewAccessibilityDelegate == null) {
                    return;
                }
                AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).c(view);
                }
                ViewCompat.setAccessibilityDelegate(view, itemDelegate);
            }
        }

        private void invalidateDisplayListInt(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    invalidateDisplayListInt((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        private void invalidateDisplayListInt(ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                invalidateDisplayListInt((ViewGroup) view, false);
            }
        }

        private boolean tryBindViewHolderByDeadline(@NonNull ViewHolder viewHolder, int i, int i2, long j) {
            viewHolder.o = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.e.a(itemViewType, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.i.bindViewHolder(viewHolder, i);
            this.e.a(viewHolder.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            attachAccessibilityDelegateOnBind(viewHolder);
            if (!RecyclerView.this.z.isPreLayout()) {
                return true;
            }
            viewHolder.f = i2;
            return true;
        }

        ViewHolder a(int i) {
            int size;
            int a;
            ArrayList<ViewHolder> arrayList = this.b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    ViewHolder viewHolder = this.b.get(i2);
                    if (!viewHolder.v() && viewHolder.getLayoutPosition() == i) {
                        viewHolder.a(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.this.i.hasStableIds() && (a = RecyclerView.this.b.a(i)) > 0 && a < RecyclerView.this.i.getItemCount()) {
                    long itemId = RecyclerView.this.i.getItemId(a);
                    for (int i3 = 0; i3 < size; i3++) {
                        ViewHolder viewHolder2 = this.b.get(i3);
                        if (!viewHolder2.v() && viewHolder2.getItemId() == itemId) {
                            viewHolder2.a(32);
                            return viewHolder2;
                        }
                    }
                }
            }
            return null;
        }

        ViewHolder a(int i, boolean z) {
            View b;
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                ViewHolder viewHolder = this.a.get(i2);
                if (!viewHolder.v() && viewHolder.getLayoutPosition() == i && !viewHolder.j() && (RecyclerView.this.z.g || !viewHolder.k())) {
                    viewHolder.a(32);
                    return viewHolder;
                }
            }
            if (z || (b = RecyclerView.this.c.b(i)) == null) {
                int size2 = this.c.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ViewHolder viewHolder2 = this.c.get(i3);
                    if (!viewHolder2.j() && viewHolder2.getLayoutPosition() == i && !viewHolder2.h()) {
                        if (!z) {
                            this.c.remove(i3);
                        }
                        return viewHolder2;
                    }
                }
                return null;
            }
            ViewHolder f = RecyclerView.f(b);
            RecyclerView.this.c.f(b);
            int b2 = RecyclerView.this.c.b(b);
            if (b2 != -1) {
                RecyclerView.this.c.a(b2);
                b(b);
                f.a(8224);
                return f;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + f + RecyclerView.this.i());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0184  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01a1  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x01c4  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01fd  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0220 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x020b  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x01d3  */
        @androidx.annotation.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.ViewHolder a(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 609
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        ViewHolder a(long j, int i, boolean z) {
            for (int size = this.a.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.a.get(size);
                if (viewHolder.getItemId() == j && !viewHolder.v()) {
                    if (i == viewHolder.getItemViewType()) {
                        viewHolder.a(32);
                        if (viewHolder.k() && !RecyclerView.this.z.isPreLayout()) {
                            viewHolder.a(2, 14);
                        }
                        return viewHolder;
                    }
                    if (!z) {
                        this.a.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        a(viewHolder.itemView);
                    }
                }
            }
            int size2 = this.c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ViewHolder viewHolder2 = this.c.get(size2);
                if (viewHolder2.getItemId() == j && !viewHolder2.h()) {
                    if (i == viewHolder2.getItemViewType()) {
                        if (!z) {
                            this.c.remove(size2);
                        }
                        return viewHolder2;
                    }
                    if (!z) {
                        c(size2);
                        return null;
                    }
                }
            }
        }

        void a() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                this.c.get(i).a();
            }
            int size2 = this.a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.a.get(i2).a();
            }
            ArrayList<ViewHolder> arrayList = this.b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.b.get(i3).a();
                }
            }
        }

        void a(int i, int i2) {
            int size = this.c.size();
            for (int i3 = 0; i3 < size; i3++) {
                ViewHolder viewHolder = this.c.get(i3);
                if (viewHolder != null && viewHolder.b >= i) {
                    viewHolder.a(i2, true);
                }
            }
        }

        void a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.c.get(size);
                if (viewHolder != null) {
                    int i4 = viewHolder.b;
                    if (i4 >= i3) {
                        viewHolder.a(-i2, z);
                    } else if (i4 >= i) {
                        viewHolder.a(8);
                        c(size);
                    }
                }
            }
        }

        void a(View view) {
            ViewHolder f = RecyclerView.f(view);
            f.l = null;
            f.m = false;
            f.c();
            b(f);
        }

        void a(Adapter adapter, Adapter adapter2, boolean z) {
            clear();
            c().a(adapter, adapter2, z);
        }

        void a(RecycledViewPool recycledViewPool) {
            RecycledViewPool recycledViewPool2 = this.e;
            if (recycledViewPool2 != null) {
                recycledViewPool2.b();
            }
            this.e = recycledViewPool;
            if (this.e == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.e.a();
        }

        void a(ViewCacheExtension viewCacheExtension) {
            this.mViewCacheExtension = viewCacheExtension;
        }

        void a(@NonNull ViewHolder viewHolder) {
            RecyclerListener recyclerListener = RecyclerView.this.k;
            if (recyclerListener != null) {
                recyclerListener.onViewRecycled(viewHolder);
            }
            Adapter adapter = RecyclerView.this.i;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.z != null) {
                recyclerView.d.g(viewHolder);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(@NonNull ViewHolder viewHolder, boolean z) {
            RecyclerView.d(viewHolder);
            View view = viewHolder.itemView;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = RecyclerView.this.D;
            if (recyclerViewAccessibilityDelegate != null) {
                AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                ViewCompat.setAccessibilityDelegate(view, itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate ? ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).b(view) : null);
            }
            if (z) {
                a(viewHolder);
            }
            viewHolder.o = null;
            c().putRecycledView(viewHolder);
        }

        View b(int i) {
            return this.a.get(i).itemView;
        }

        View b(int i, boolean z) {
            return a(i, z, Long.MAX_VALUE).itemView;
        }

        void b() {
            this.a.clear();
            ArrayList<ViewHolder> arrayList = this.b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        void b(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i4 = i;
                i3 = i2;
                i5 = -1;
            } else {
                i3 = i;
                i4 = i2;
                i5 = 1;
            }
            int size = this.c.size();
            for (int i7 = 0; i7 < size; i7++) {
                ViewHolder viewHolder = this.c.get(i7);
                if (viewHolder != null && (i6 = viewHolder.b) >= i4 && i6 <= i3) {
                    if (i6 == i) {
                        viewHolder.a(i2 - i, false);
                    } else {
                        viewHolder.a(i5, false);
                    }
                }
            }
        }

        void b(View view) {
            ArrayList<ViewHolder> arrayList;
            ViewHolder f = RecyclerView.f(view);
            if (!f.b(12) && f.n() && !RecyclerView.this.a(f)) {
                if (this.b == null) {
                    this.b = new ArrayList<>();
                }
                f.a(this, true);
                arrayList = this.b;
            } else {
                if (f.j() && !f.k() && !RecyclerView.this.i.hasStableIds()) {
                    throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.i());
                }
                f.a(this, false);
                arrayList = this.a;
            }
            arrayList.add(f);
        }

        void b(ViewHolder viewHolder) {
            boolean z;
            if (viewHolder.l() || viewHolder.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(viewHolder.l());
                sb.append(" isAttached:");
                sb.append(viewHolder.itemView.getParent() != null);
                sb.append(RecyclerView.this.i());
                throw new IllegalArgumentException(sb.toString());
            }
            if (viewHolder.m()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + RecyclerView.this.i());
            }
            if (viewHolder.s()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.i());
            }
            boolean e = viewHolder.e();
            Adapter adapter = RecyclerView.this.i;
            if ((adapter != null && e && adapter.onFailedToRecycleView(viewHolder)) || viewHolder.isRecyclable()) {
                if (this.d <= 0 || viewHolder.b(526)) {
                    z = false;
                } else {
                    int size = this.c.size();
                    if (size >= this.d && size > 0) {
                        c(0);
                        size--;
                    }
                    if (RecyclerView.J && size > 0 && !RecyclerView.this.y.a(viewHolder.b)) {
                        int i = size - 1;
                        while (i >= 0) {
                            if (!RecyclerView.this.y.a(this.c.get(i).b)) {
                                break;
                            } else {
                                i--;
                            }
                        }
                        size = i + 1;
                    }
                    this.c.add(size, viewHolder);
                    z = true;
                }
                if (!z) {
                    a(viewHolder, true);
                    r1 = true;
                }
            } else {
                z = false;
            }
            RecyclerView.this.d.g(viewHolder);
            if (z || r1 || !e) {
                return;
            }
            viewHolder.o = null;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void bindViewToPosition(@androidx.annotation.NonNull android.view.View r7, int r8) {
            /*
                r6 = this;
                androidx.recyclerview.widget.RecyclerView$ViewHolder r7 = androidx.recyclerview.widget.RecyclerView.f(r7)
                if (r7 == 0) goto L96
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.AdapterHelper r0 = r0.b
                int r2 = r0.a(r8)
                if (r2 < 0) goto L5e
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r0 = r0.i
                int r0 = r0.getItemCount()
                if (r2 >= r0) goto L5e
                r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r0 = r6
                r1 = r7
                r3 = r8
                r0.tryBindViewHolderByDeadline(r1, r2, r3, r4)
                android.view.View r8 = r7.itemView
                android.view.ViewGroup$LayoutParams r8 = r8.getLayoutParams()
                if (r8 != 0) goto L3b
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r8 = r8.generateDefaultLayoutParams()
            L33:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r8 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r8
                android.view.View r0 = r7.itemView
                r0.setLayoutParams(r8)
                goto L4c
            L3b:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                boolean r0 = r0.checkLayoutParams(r8)
                if (r0 != 0) goto L4a
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r8 = r0.generateLayoutParams(r8)
                goto L33
            L4a:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r8 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r8
            L4c:
                r0 = 1
                r8.c = r0
                r8.a = r7
                android.view.View r7 = r7.itemView
                android.view.ViewParent r7 = r7.getParent()
                if (r7 != 0) goto L5a
                goto L5b
            L5a:
                r0 = 0
            L5b:
                r8.d = r0
                return
            L5e:
                java.lang.IndexOutOfBoundsException r7 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Inconsistency detected. Invalid item position "
                r0.append(r1)
                r0.append(r8)
                java.lang.String r8 = "(offset:"
                r0.append(r8)
                r0.append(r2)
                java.lang.String r8 = ").state:"
                r0.append(r8)
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r8 = r8.z
                int r8 = r8.getItemCount()
                r0.append(r8)
                androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r8 = r8.i()
                r0.append(r8)
                java.lang.String r8 = r0.toString()
                r7.<init>(r8)
                throw r7
            L96:
                java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r0 = "The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter"
                r8.append(r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r0 = r0.i()
                r8.append(r0)
                java.lang.String r8 = r8.toString()
                r7.<init>(r8)
                goto Lb4
            Lb3:
                throw r7
            Lb4:
                goto Lb3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.bindViewToPosition(android.view.View, int):void");
        }

        RecycledViewPool c() {
            if (this.e == null) {
                this.e = new RecycledViewPool();
            }
            return this.e;
        }

        void c(int i) {
            a(this.c.get(i), true);
            this.c.remove(i);
        }

        void c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.c.get(size);
                if (viewHolder != null && (i3 = viewHolder.b) >= i && i3 < i4) {
                    viewHolder.a(2);
                    c(size);
                }
            }
        }

        void c(ViewHolder viewHolder) {
            (viewHolder.m ? this.b : this.a).remove(viewHolder);
            viewHolder.l = null;
            viewHolder.m = false;
            viewHolder.c();
        }

        public void clear() {
            this.a.clear();
            g();
        }

        public int convertPreLayoutPositionToPostLayout(int i) {
            if (i >= 0 && i < RecyclerView.this.z.getItemCount()) {
                return !RecyclerView.this.z.isPreLayout() ? i : RecyclerView.this.b.a(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.z.getItemCount() + RecyclerView.this.i());
        }

        int d() {
            return this.a.size();
        }

        boolean d(ViewHolder viewHolder) {
            if (viewHolder.k()) {
                return RecyclerView.this.z.isPreLayout();
            }
            int i = viewHolder.b;
            if (i >= 0 && i < RecyclerView.this.i.getItemCount()) {
                if (RecyclerView.this.z.isPreLayout() || RecyclerView.this.i.getItemViewType(viewHolder.b) == viewHolder.getItemViewType()) {
                    return !RecyclerView.this.i.hasStableIds() || viewHolder.getItemId() == RecyclerView.this.i.getItemId(viewHolder.b);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + RecyclerView.this.i());
        }

        void e() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.c.get(i).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.c = true;
                }
            }
        }

        void f() {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                ViewHolder viewHolder = this.c.get(i);
                if (viewHolder != null) {
                    viewHolder.a(6);
                    viewHolder.a((Object) null);
                }
            }
            Adapter adapter = RecyclerView.this.i;
            if (adapter == null || !adapter.hasStableIds()) {
                g();
            }
        }

        void g() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                c(size);
            }
            this.c.clear();
            if (RecyclerView.J) {
                RecyclerView.this.y.a();
            }
        }

        @NonNull
        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        @NonNull
        public View getViewForPosition(int i) {
            return b(i, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void h() {
            LayoutManager layoutManager = RecyclerView.this.j;
            this.d = this.mRequestedCacheMax + (layoutManager != null ? layoutManager.i : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.d; size--) {
                c(size);
            }
        }

        public void recycleView(@NonNull View view) {
            ViewHolder f = RecyclerView.f(view);
            if (f.m()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (f.l()) {
                f.u();
            } else if (f.v()) {
                f.c();
            }
            b(f);
            if (RecyclerView.this.v == null || f.isRecyclable()) {
                return;
            }
            RecyclerView.this.v.endAnimation(f);
        }

        public void setViewCacheSize(int i) {
            this.mRequestedCacheMax = i;
            h();
        }
    }

    /* loaded from: classes.dex */
    public interface RecyclerListener {
        void onViewRecycled(@NonNull ViewHolder viewHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class RecyclerViewDataObserver extends AdapterDataObserver {
        RecyclerViewDataObserver() {
        }

        void a() {
            if (RecyclerView.I) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.n && recyclerView.m) {
                    ViewCompat.postOnAnimation(recyclerView, recyclerView.f);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.s = true;
            recyclerView2.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerView.this.b((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.z.f = true;
            recyclerView.b(true);
            if (RecyclerView.this.b.c()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.b((String) null);
            if (RecyclerView.this.b.a(i, i2, obj)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.b((String) null);
            if (RecyclerView.this.b.b(i, i2)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.b((String) null);
            if (RecyclerView.this.b.a(i, i2, i3)) {
                a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.b((String) null);
            if (RecyclerView.this.b.c(i, i2)) {
                a();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.recyclerview.widget.RecyclerView.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        Parcelable a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        void a(SavedState savedState) {
            this.a = savedState.a;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, 0);
        }
    }

    /* loaded from: classes.dex */
    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private boolean mRunning;
        private boolean mStarted;
        private View mTargetView;
        private int mTargetPosition = -1;
        private final Action mRecyclingAction = new Action(0, 0);

        /* loaded from: classes.dex */
        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            private boolean mChanged;
            private int mConsecutiveUpdates;
            private int mDuration;
            private int mDx;
            private int mDy;
            private Interpolator mInterpolator;
            private int mJumpToPosition;

            public Action(@Px int i, @Px int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public Action(@Px int i, @Px int i2, int i3) {
                this(i, i2, i3, null);
            }

            public Action(@Px int i, @Px int i2, int i3, @Nullable Interpolator interpolator) {
                this.mJumpToPosition = -1;
                this.mChanged = false;
                this.mConsecutiveUpdates = 0;
                this.mDx = i;
                this.mDy = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
            }

            private void validate() {
                if (this.mInterpolator != null && this.mDuration < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.mDuration < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            void a(RecyclerView recyclerView) {
                int i = this.mJumpToPosition;
                if (i >= 0) {
                    this.mJumpToPosition = -1;
                    recyclerView.b(i);
                    this.mChanged = false;
                } else {
                    if (!this.mChanged) {
                        this.mConsecutiveUpdates = 0;
                        return;
                    }
                    validate();
                    recyclerView.w.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                    this.mConsecutiveUpdates++;
                    if (this.mConsecutiveUpdates > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.mChanged = false;
                }
            }

            boolean a() {
                return this.mJumpToPosition >= 0;
            }

            public int getDuration() {
                return this.mDuration;
            }

            @Px
            public int getDx() {
                return this.mDx;
            }

            @Px
            public int getDy() {
                return this.mDy;
            }

            @Nullable
            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            public void jumpTo(int i) {
                this.mJumpToPosition = i;
            }

            public void setDuration(int i) {
                this.mChanged = true;
                this.mDuration = i;
            }

            public void setDx(@Px int i) {
                this.mChanged = true;
                this.mDx = i;
            }

            public void setDy(@Px int i) {
                this.mChanged = true;
                this.mDy = i;
            }

            public void setInterpolator(@Nullable Interpolator interpolator) {
                this.mChanged = true;
                this.mInterpolator = interpolator;
            }

            public void update(@Px int i, @Px int i2, int i3, @Nullable Interpolator interpolator) {
                this.mDx = i;
                this.mDy = i2;
                this.mDuration = i3;
                this.mInterpolator = interpolator;
                this.mChanged = true;
            }
        }

        /* loaded from: classes.dex */
        public interface ScrollVectorProvider {
            @Nullable
            PointF computeScrollVectorForPosition(int i);
        }

        protected abstract void a();

        void a(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                c();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null && (computeScrollVectorForPosition.x != 0.0f || computeScrollVectorForPosition.y != 0.0f)) {
                recyclerView.a((int) Math.signum(computeScrollVectorForPosition.x), (int) Math.signum(computeScrollVectorForPosition.y), (int[]) null);
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    a(this.mTargetView, recyclerView.z, this.mRecyclingAction);
                    this.mRecyclingAction.a(recyclerView);
                    c();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                a(i, i2, recyclerView.z, this.mRecyclingAction);
                boolean a = this.mRecyclingAction.a();
                this.mRecyclingAction.a(recyclerView);
                if (a && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.w.a();
                }
            }
        }

        protected abstract void a(@Px int i, @Px int i2, @NonNull State state, @NonNull Action action);

        /* JADX INFO: Access modifiers changed from: protected */
        public void a(@NonNull PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float sqrt = (float) Math.sqrt((f * f) + (f2 * f2));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        protected void a(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        protected abstract void a(@NonNull View view, @NonNull State state, @NonNull Action action);

        void a(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.w.stop();
            if (this.mStarted) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            int i = this.mTargetPosition;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.mRecyclerView.z.a = i;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            a();
            this.mRecyclerView.w.a();
            this.mStarted = true;
        }

        protected abstract void b();

        /* JADX INFO: Access modifiers changed from: protected */
        public final void c() {
            if (this.mRunning) {
                this.mRunning = false;
                b();
                this.mRecyclerView.z.a = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.a(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }

        @Nullable
        public PointF computeScrollVectorForPosition(int i) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.j.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.mRecyclerView.j.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        @Nullable
        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }
    }

    /* loaded from: classes.dex */
    public static class State {
        int a = -1;
        int b = 0;
        int c = 0;
        int d = 1;
        int e = 0;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        int l;
        long m;
        private SparseArray<Object> mData;
        int n;
        int o;
        int p;

        void a(int i) {
            if ((this.d & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.d));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Adapter adapter) {
            this.d = 1;
            this.e = adapter.getItemCount();
            this.g = false;
            this.h = false;
            this.i = false;
        }

        public boolean didStructureChange() {
            return this.f;
        }

        public <T> T get(int i) {
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray == null) {
                return null;
            }
            return (T) sparseArray.get(i);
        }

        public int getItemCount() {
            return this.g ? this.b - this.c : this.e;
        }

        public int getRemainingScrollHorizontal() {
            return this.o;
        }

        public int getRemainingScrollVertical() {
            return this.p;
        }

        public int getTargetScrollPosition() {
            return this.a;
        }

        public boolean hasTargetScrollPosition() {
            return this.a != -1;
        }

        public boolean isMeasuring() {
            return this.i;
        }

        public boolean isPreLayout() {
            return this.g;
        }

        public void put(int i, Object obj) {
            if (this.mData == null) {
                this.mData = new SparseArray<>();
            }
            this.mData.put(i, obj);
        }

        public void remove(int i) {
            SparseArray<Object> sparseArray = this.mData;
            if (sparseArray == null) {
                return;
            }
            sparseArray.remove(i);
        }

        public String toString() {
            return "State{mTargetPosition=" + this.a + ", mData=" + this.mData + ", mItemCount=" + this.e + ", mIsMeasuring=" + this.i + ", mPreviousLayoutItemCount=" + this.b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.c + ", mStructureChanged=" + this.f + ", mInPreLayout=" + this.g + ", mRunSimpleAnimations=" + this.j + ", mRunPredictiveAnimations=" + this.k + '}';
        }

        public boolean willRunPredictiveAnimations() {
            return this.k;
        }

        public boolean willRunSimpleAnimations() {
            return this.j;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewCacheExtension {
        @Nullable
        public abstract View getViewForPositionAndType(@NonNull Recycler recycler, int i, int i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewFlinger implements Runnable {
        OverScroller a;
        private int mLastFlingX;
        private int mLastFlingY;
        Interpolator b = RecyclerView.K;
        private boolean mEatRunOnAnimationRequest = false;
        private boolean mReSchedulePostAnimationCallback = false;

        ViewFlinger() {
            this.a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.K);
        }

        private int computeScrollDuration(int i, int i2, int i3, int i4) {
            int i5;
            int abs = Math.abs(i);
            int abs2 = Math.abs(i2);
            boolean z = abs > abs2;
            int sqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int sqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f = width;
            float f2 = i6;
            float distanceInfluenceForSnapDuration = f2 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (sqrt2 * 1.0f) / f)) * f2);
            if (sqrt > 0) {
                i5 = Math.round(Math.abs(distanceInfluenceForSnapDuration / sqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    abs = abs2;
                }
                i5 = (int) (((abs / f) + 1.0f) * 300.0f);
            }
            return Math.min(i5, 2000);
        }

        private float distanceInfluenceForSnapDuration(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private void internalPostOnAnimation() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.postOnAnimation(RecyclerView.this, this);
        }

        void a() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
            } else {
                internalPostOnAnimation();
            }
        }

        public void fling(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            Interpolator interpolator = this.b;
            Interpolator interpolator2 = RecyclerView.K;
            if (interpolator != interpolator2) {
                this.b = interpolator2;
                this.a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.K);
            }
            this.a.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.j == null) {
                stop();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            recyclerView.b();
            OverScroller overScroller = this.a;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.mLastFlingX;
                int i4 = currY - this.mLastFlingY;
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.E;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i3, i4, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.E;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.b(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.i != null) {
                    int[] iArr3 = recyclerView3.E;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.a(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.E;
                    i2 = iArr4[0];
                    i = iArr4[1];
                    i3 -= i2;
                    i4 -= i;
                    SmoothScroller smoothScroller = recyclerView4.j.e;
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int itemCount = RecyclerView.this.z.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.c();
                        } else {
                            if (smoothScroller.getTargetPosition() >= itemCount) {
                                smoothScroller.setTargetPosition(itemCount - 1);
                            }
                            smoothScroller.a(i2, i);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.l.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.E;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i2, i, i3, i4, null, 1, iArr5);
                int[] iArr6 = RecyclerView.this.E;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (i2 != 0 || i != 0) {
                    RecyclerView.this.d(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                SmoothScroller smoothScroller2 = RecyclerView.this.j.e;
                if ((smoothScroller2 != null && smoothScroller2.isPendingInitialRun()) || !z) {
                    a();
                    RecyclerView recyclerView6 = RecyclerView.this;
                    GapWorker gapWorker = recyclerView6.x;
                    if (gapWorker != null) {
                        gapWorker.a(recyclerView6, i2, i);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i7, currVelocity);
                    }
                    if (RecyclerView.J) {
                        RecyclerView.this.y.a();
                    }
                }
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.j.e;
            if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                smoothScroller3.a(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                internalPostOnAnimation();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }

        public void smoothScrollBy(int i, int i2, int i3, @Nullable Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = computeScrollDuration(i, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.K;
            }
            if (this.b != interpolator) {
                this.b = interpolator;
                this.a = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            RecyclerView.this.setScrollState(2);
            this.a.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.a.computeScrollOffset();
            }
            a();
        }

        public void stop() {
            RecyclerView.this.removeCallbacks(this);
            this.a.abortAnimation();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ViewHolder {
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        WeakReference<RecyclerView> a;
        int i;

        @NonNull
        public final View itemView;
        RecyclerView o;
        int b = -1;
        int c = -1;
        long d = -1;
        int e = -1;
        int f = -1;
        ViewHolder g = null;
        ViewHolder h = null;
        List<Object> j = null;
        List<Object> k = null;
        private int mIsRecyclableCount = 0;
        Recycler l = null;
        boolean m = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        @VisibleForTesting
        int n = -1;

        public ViewHolder(@NonNull View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        private void createPayloadsIfNeeded() {
            if (this.j == null) {
                this.j = new ArrayList();
                this.k = Collections.unmodifiableList(this.j);
            }
        }

        void a() {
            this.c = -1;
            this.f = -1;
        }

        void a(int i) {
            this.i = i | this.i;
        }

        void a(int i, int i2) {
            this.i = (i & i2) | (this.i & (i2 ^ (-1)));
        }

        void a(int i, int i2, boolean z) {
            a(8);
            a(i2, z);
            this.b = i;
        }

        void a(int i, boolean z) {
            if (this.c == -1) {
                this.c = this.b;
            }
            if (this.f == -1) {
                this.f = this.b;
            }
            if (z) {
                this.f += i;
            }
            this.b += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).c = true;
            }
        }

        void a(Recycler recycler, boolean z) {
            this.l = recycler;
            this.m = z;
        }

        void a(RecyclerView recyclerView) {
            int i = this.n;
            if (i == -1) {
                i = ViewCompat.getImportantForAccessibility(this.itemView);
            }
            this.mWasImportantForAccessibilityBeforeHidden = i;
            recyclerView.a(this, 4);
        }

        void a(Object obj) {
            if (obj == null) {
                a(1024);
            } else if ((1024 & this.i) == 0) {
                createPayloadsIfNeeded();
                this.j.add(obj);
            }
        }

        void b() {
            List<Object> list = this.j;
            if (list != null) {
                list.clear();
            }
            this.i &= -1025;
        }

        void b(RecyclerView recyclerView) {
            recyclerView.a(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        boolean b(int i) {
            return (i & this.i) != 0;
        }

        void c() {
            this.i &= -33;
        }

        void d() {
            this.i &= -257;
        }

        boolean e() {
            return (this.i & 16) == 0 && ViewCompat.hasTransientState(this.itemView);
        }

        List<Object> f() {
            if ((this.i & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.j;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.k;
        }

        boolean g() {
            return (this.i & 512) != 0 || j();
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.o;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.b(this);
        }

        public final long getItemId() {
            return this.d;
        }

        public final int getItemViewType() {
            return this.e;
        }

        public final int getLayoutPosition() {
            int i = this.f;
            return i == -1 ? this.b : i;
        }

        public final int getOldPosition() {
            return this.c;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.f;
            return i == -1 ? this.b : i;
        }

        boolean h() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.o) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean i() {
            return (this.i & 1) != 0;
        }

        public final boolean isRecyclable() {
            return (this.i & 16) == 0 && !ViewCompat.hasTransientState(this.itemView);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean j() {
            return (this.i & 4) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean k() {
            return (this.i & 8) != 0;
        }

        boolean l() {
            return this.l != null;
        }

        boolean m() {
            return (this.i & 256) != 0;
        }

        boolean n() {
            return (this.i & 2) != 0;
        }

        boolean o() {
            return (this.i & 2) != 0;
        }

        void p() {
            this.i = 0;
            this.b = -1;
            this.c = -1;
            this.d = -1L;
            this.f = -1;
            this.mIsRecyclableCount = 0;
            this.g = null;
            this.h = null;
            b();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.n = -1;
            RecyclerView.d(this);
        }

        void q() {
            if (this.c == -1) {
                this.c = this.b;
            }
        }

        boolean r() {
            return (this.i & 16) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean s() {
            return (this.i & 128) != 0;
        }

        public final void setIsRecyclable(boolean z) {
            int i;
            int i2 = this.mIsRecyclableCount;
            this.mIsRecyclableCount = z ? i2 - 1 : i2 + 1;
            int i3 = this.mIsRecyclableCount;
            if (i3 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i3 == 1) {
                i = this.i | 16;
            } else if (!z || this.mIsRecyclableCount != 0) {
                return;
            } else {
                i = this.i & (-17);
            }
            this.i = i;
        }

        void t() {
            this.i &= -129;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.b + " id=" + this.d + ", oldPos=" + this.c + ", pLpos:" + this.f);
            if (l()) {
                sb.append(" scrap ");
                sb.append(this.m ? "[changeScrap]" : "[attachedScrap]");
            }
            if (j()) {
                sb.append(" invalid");
            }
            if (!i()) {
                sb.append(" unbound");
            }
            if (o()) {
                sb.append(" update");
            }
            if (k()) {
                sb.append(" removed");
            }
            if (s()) {
                sb.append(" ignored");
            }
            if (m()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (g()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        void u() {
            this.l.c(this);
        }

        boolean v() {
            return (this.i & 32) != 0;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        G = i == 18 || i == 19 || i == 20;
        H = Build.VERSION.SDK_INT >= 23;
        I = Build.VERSION.SDK_INT >= 16;
        J = Build.VERSION.SDK_INT >= 21;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = Build.VERSION.SDK_INT <= 15;
        IGNORE_DETACHED_FOCUSED_CHILD = Build.VERSION.SDK_INT <= 15;
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        K = new Interpolator() { // from class: androidx.recyclerview.widget.RecyclerView.3
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        };
    }

    public RecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.recyclerview.R.attr.recyclerViewStyle);
    }

    public RecyclerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mObserver = new RecyclerViewDataObserver();
        this.a = new Recycler();
        this.d = new ViewInfoStore();
        this.f = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                RecyclerView recyclerView = RecyclerView.this;
                if (!recyclerView.p || recyclerView.isLayoutRequested()) {
                    return;
                }
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.m) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.r) {
                    recyclerView2.q = true;
                } else {
                    recyclerView2.b();
                }
            }
        };
        this.g = new Rect();
        this.mTempRect2 = new Rect();
        this.h = new RectF();
        this.l = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.t = false;
        this.u = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        this.v = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.w = new ViewFlinger();
        this.y = J ? new GapWorker.LayoutPrefetchRegistryImpl() : null;
        this.z = new State();
        this.A = false;
        this.B = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
        this.C = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.E = new int[2];
        this.F = new ArrayList();
        this.mItemAnimatorRunner = new Runnable() { // from class: androidx.recyclerview.widget.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                ItemAnimator itemAnimator = RecyclerView.this.v;
                if (itemAnimator != null) {
                    itemAnimator.runPendingAnimations();
                }
                RecyclerView.this.C = false;
            }
        };
        this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback() { // from class: androidx.recyclerview.widget.RecyclerView.4
            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processAppeared(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.a(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processDisappeared(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                RecyclerView.this.a.c(viewHolder);
                RecyclerView.this.b(viewHolder, itemHolderInfo, itemHolderInfo2);
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void processPersistent(ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
                viewHolder.setIsRecyclable(false);
                RecyclerView recyclerView = RecyclerView.this;
                boolean z2 = recyclerView.t;
                ItemAnimator itemAnimator = recyclerView.v;
                if (z2) {
                    if (!itemAnimator.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                        return;
                    }
                } else if (!itemAnimator.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    return;
                }
                RecyclerView.this.q();
            }

            @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
            public void unused(ViewHolder viewHolder) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.j.removeAndRecycleView(viewHolder.itemView, recyclerView.a);
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.v.a(this.mItemAnimatorListener);
        j();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, androidx.recyclerview.R.styleable.RecyclerView, attributeSet, obtainStyledAttributes, i, 0);
        }
        String string = obtainStyledAttributes.getString(androidx.recyclerview.R.styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.e = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_android_clipToPadding, true);
        this.o = obtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false);
        if (this.o) {
            a((StateListDrawable) obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i, 0);
            if (Build.VERSION.SDK_INT >= 29) {
                saveAttributeDataForStyleable(context, NESTED_SCROLLING_ATTRS, attributeSet, obtainStyledAttributes2, i, 0);
            }
            z = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z);
    }

    static void a(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z = view.getParent() == this;
        this.a.c(getChildViewHolder(view));
        if (viewHolder.m()) {
            this.c.a(view, -1, view.getLayoutParams(), true);
            return;
        }
        ChildHelper childHelper = this.c;
        if (z) {
            childHelper.a(view);
        } else {
            childHelper.a(view, true);
        }
    }

    private void animateChange(@NonNull ViewHolder viewHolder, @NonNull ViewHolder viewHolder2, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z, boolean z2) {
        viewHolder.setIsRecyclable(false);
        if (z) {
            addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z2) {
                addAnimatingView(viewHolder2);
            }
            viewHolder.g = viewHolder2;
            addAnimatingView(viewHolder);
            this.a.c(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.h = viewHolder;
        }
        if (this.v.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            q();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, trim);
            try {
                Class<? extends U> asSubclass = Class.forName(fullClassName, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(LayoutManager.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                } catch (NoSuchMethodException e) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((LayoutManager) constructor.newInstance(objArr));
            } catch (ClassCastException e3) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e3);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e4);
            } catch (IllegalAccessException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e5);
            } catch (InstantiationException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e6);
            } catch (InvocationTargetException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
            }
        }
    }

    static void d(@NonNull ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.a;
        if (weakReference != null) {
            Object obj = weakReference.get();
            while (true) {
                for (View view = (View) obj; view != null; view = null) {
                    if (view == viewHolder.itemView) {
                        return;
                    }
                    obj = view.getParent();
                    if (obj instanceof View) {
                        break;
                    }
                }
                viewHolder.a = null;
                return;
            }
        }
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i == 0 || !l()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(obtain, i);
        sendAccessibilityEventUnchecked(obtain);
    }

    private void dispatchLayoutStep1() {
        this.z.a(1);
        a(this.z);
        this.z.i = false;
        u();
        this.d.a();
        o();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State state = this.z;
        state.h = state.j && this.B;
        this.B = false;
        this.A = false;
        State state2 = this.z;
        state2.g = state2.k;
        state2.e = this.i.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.z.j) {
            int a = this.c.a();
            for (int i = 0; i < a; i++) {
                ViewHolder f = f(this.c.c(i));
                if (!f.s() && (!f.j() || this.i.hasStableIds())) {
                    this.d.c(f, this.v.recordPreLayoutInformation(this.z, f, ItemAnimator.a(f), f.f()));
                    if (this.z.h && f.n() && !f.k() && !f.s() && !f.j()) {
                        this.d.a(c(f), f);
                    }
                }
            }
        }
        if (this.z.k) {
            t();
            State state3 = this.z;
            boolean z = state3.f;
            state3.f = false;
            this.j.onLayoutChildren(this.a, state3);
            this.z.f = z;
            for (int i2 = 0; i2 < this.c.a(); i2++) {
                ViewHolder f2 = f(this.c.c(i2));
                if (!f2.s() && !this.d.c(f2)) {
                    int a2 = ItemAnimator.a(f2);
                    boolean b = f2.b(8192);
                    if (!b) {
                        a2 |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo recordPreLayoutInformation = this.v.recordPreLayoutInformation(this.z, f2, a2, f2.f());
                    if (b) {
                        a(f2, recordPreLayoutInformation);
                    } else {
                        this.d.a(f2, recordPreLayoutInformation);
                    }
                }
            }
        }
        a();
        p();
        c(false);
        this.z.d = 2;
    }

    private void dispatchLayoutStep2() {
        u();
        o();
        this.z.a(6);
        this.b.b();
        this.z.e = this.i.getItemCount();
        State state = this.z;
        state.c = 0;
        state.g = false;
        this.j.onLayoutChildren(this.a, state);
        State state2 = this.z;
        state2.f = false;
        this.mPendingSavedState = null;
        state2.j = state2.j && this.v != null;
        this.z.d = 4;
        p();
        c(false);
    }

    private void dispatchLayoutStep3() {
        this.z.a(4);
        u();
        o();
        State state = this.z;
        state.d = 1;
        if (state.j) {
            for (int a = this.c.a() - 1; a >= 0; a--) {
                ViewHolder f = f(this.c.c(a));
                if (!f.s()) {
                    long c = c(f);
                    ItemAnimator.ItemHolderInfo recordPostLayoutInformation = this.v.recordPostLayoutInformation(this.z, f);
                    ViewHolder a2 = this.d.a(c);
                    if (a2 != null && !a2.s()) {
                        boolean b = this.d.b(a2);
                        boolean b2 = this.d.b(f);
                        if (!b || a2 != f) {
                            ItemAnimator.ItemHolderInfo e = this.d.e(a2);
                            this.d.b(f, recordPostLayoutInformation);
                            ItemAnimator.ItemHolderInfo d = this.d.d(f);
                            if (e == null) {
                                handleMissingPreInfoForChangeError(c, f, a2);
                            } else {
                                animateChange(a2, f, e, d, b, b2);
                            }
                        }
                    }
                    this.d.b(f, recordPostLayoutInformation);
                }
            }
            this.d.a(this.mViewInfoProcessCallback);
        }
        this.j.a(this.a);
        State state2 = this.z;
        state2.b = state2.e;
        this.t = false;
        this.u = false;
        state2.j = false;
        state2.k = false;
        this.j.f = false;
        ArrayList<ViewHolder> arrayList = this.a.b;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.j;
        if (layoutManager.j) {
            layoutManager.i = 0;
            layoutManager.j = false;
            this.a.h();
        }
        this.j.onLayoutCompleted(this.z);
        p();
        c(false);
        this.d.a();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            d(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        OnItemTouchListener onItemTouchListener = this.mInterceptingOnItemTouchListener;
        if (onItemTouchListener == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        onItemTouchListener.onTouchEvent(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    @Nullable
    static RecyclerView e(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView e = e(viewGroup.getChildAt(i));
            if (e != null) {
                return e;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewHolder f(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).a;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            OnItemTouchListener onItemTouchListener = this.mOnItemTouchListeners.get(i);
            if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int a = this.c.a();
        if (a == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < a; i3++) {
            ViewHolder f = f(this.c.c(i3));
            if (!f.s()) {
                int layoutPosition = f.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    @Nullable
    private View findNextViewToFocus() {
        ViewHolder findViewHolderForAdapterPosition;
        int i = this.z.l;
        if (i == -1) {
            i = 0;
        }
        int itemCount = this.z.getItemCount();
        for (int i2 = i; i2 < itemCount; i2++) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(itemCount, i);
        do {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
        } while (!findViewHolderForAdapterPosition.itemView.hasFocusable());
        return findViewHolderForAdapterPosition.itemView;
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id;
        loop0: while (true) {
            id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    break;
                }
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int a = this.c.a();
        for (int i = 0; i < a; i++) {
            ViewHolder f = f(this.c.c(i));
            if (f != viewHolder && c(f) == j) {
                Adapter adapter = this.i;
                if (adapter == null || !adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + f + " \n View Holder 2:" + viewHolder + i());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + f + " \n View Holder 2:" + viewHolder + i());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + i());
    }

    private boolean hasUpdatedView() {
        int a = this.c.a();
        for (int i = 0; i < a; i++) {
            ViewHolder f = f(this.c.c(i));
            if (f != null && !f.s() && f.n()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) == 0) {
            ViewCompat.setImportantForAutofill(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.c = new ChildHelper(new ChildHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.5
            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void addView(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.a(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams) {
                ViewHolder f = RecyclerView.f(view);
                if (f != null) {
                    if (!f.m() && !f.s()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + f + RecyclerView.this.i());
                    }
                    f.d();
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void detachViewFromParent(int i) {
                ViewHolder f;
                View childAt = getChildAt(i);
                if (childAt != null && (f = RecyclerView.f(childAt)) != null) {
                    if (f.m() && !f.s()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + f + RecyclerView.this.i());
                    }
                    f.a(256);
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public View getChildAt(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public ViewHolder getChildViewHolder(View view) {
                return RecyclerView.f(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public int indexOfChild(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void onEnteredHiddenState(View view) {
                ViewHolder f = RecyclerView.f(view);
                if (f != null) {
                    f.a(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void onLeftHiddenState(View view) {
                ViewHolder f = RecyclerView.f(view);
                if (f != null) {
                    f.b(RecyclerView.this);
                }
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void removeAllViews() {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    RecyclerView.this.b(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // androidx.recyclerview.widget.ChildHelper.Callback
            public void removeViewAt(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.b(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }
        });
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.g.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.g);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c = 65535;
        int i3 = this.j.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.g;
        int i4 = rect.left;
        int i5 = this.mTempRect2.left;
        if ((i4 < i5 || rect.right <= i5) && this.g.right < this.mTempRect2.right) {
            i2 = 1;
        } else {
            Rect rect2 = this.g;
            int i6 = rect2.right;
            int i7 = this.mTempRect2.right;
            i2 = ((i6 > i7 || rect2.left >= i7) && this.g.left > this.mTempRect2.left) ? -1 : 0;
        }
        Rect rect3 = this.g;
        int i8 = rect3.top;
        int i9 = this.mTempRect2.top;
        if ((i8 < i9 || rect3.bottom <= i9) && this.g.bottom < this.mTempRect2.bottom) {
            c = 1;
        } else {
            Rect rect4 = this.g;
            int i10 = rect4.bottom;
            int i11 = this.mTempRect2.bottom;
            if ((i10 <= i11 && rect4.top < i11) || this.g.top <= this.mTempRect2.top) {
                c = 0;
            }
        }
        if (i == 1) {
            return c < 0 || (c == 0 && i2 * i3 <= 0);
        }
        if (i == 2) {
            return c > 0 || (c == 0 && i2 * i3 >= 0);
        }
        if (i == 17) {
            return i2 < 0;
        }
        if (i == 33) {
            return c < 0;
        }
        if (i == 66) {
            return i2 > 0;
        }
        if (i == 130) {
            return c > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i + i());
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.v != null && this.j.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.t) {
            this.b.f();
            if (this.u) {
                this.j.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.b.e();
        } else {
            this.b.b();
        }
        boolean z = false;
        boolean z2 = this.A || this.B;
        this.z.j = this.p && this.v != null && (this.t || z2 || this.j.f) && (!this.t || this.i.hasStableIds());
        State state = this.z;
        if (state.j && z2 && !this.t && predictiveItemAnimationsEnabled()) {
            z = true;
        }
        state.k = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.f()
            android.widget.EdgeEffect r3 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
        L1c:
            androidx.core.widget.EdgeEffectCompat.onPull(r3, r4, r9)
            r9 = 1
            goto L39
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L38
            r6.g()
            android.widget.EdgeEffect r3 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L1c
        L38:
            r9 = 0
        L39:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L53
            r6.h()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.EdgeEffectCompat.onPull(r9, r0, r7)
            goto L6f
        L53:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L6e
            r6.e()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.EdgeEffectCompat.onPull(r9, r3, r0)
            goto L6f
        L6e:
            r1 = r9
        L6f:
            if (r1 != 0) goto L79
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L79
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7c
        L79:
            androidx.core.view.ViewCompat.postInvalidateOnAnimation(r6)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recoverFocusFromState() {
        View view;
        if (!this.mPreserveFocusAfterLayout || this.i == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.c.c(focusedChild)) {
                    return;
                }
            } else if (this.c.a() == 0) {
                requestFocus();
                return;
            }
        }
        View view2 = null;
        ViewHolder findViewHolderForItemId = (this.z.m == -1 || !this.i.hasStableIds()) ? null : findViewHolderForItemId(this.z.m);
        if (findViewHolderForItemId != null && !this.c.c(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
            view2 = findViewHolderForItemId.itemView;
        } else if (this.c.a() > 0) {
            view2 = findNextViewToFocus();
        }
        if (view2 != null) {
            int i = this.z.n;
            if (i == -1 || (view = view2.findViewById(i)) == null || !view.isFocusable()) {
                view = view2;
            }
            view.requestFocus();
        }
    }

    private void releaseGlows() {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void requestChildOnScreen(@NonNull View view, @Nullable View view2) {
        View view3 = view2 != null ? view2 : view;
        this.g.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.c) {
                Rect rect = layoutParams2.b;
                Rect rect2 = this.g;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.g);
            offsetRectIntoDescendantCoords(view, this.g);
        }
        this.j.requestChildRectangleOnScreen(this, view, this.g, !this.p, view2 == null);
    }

    private void resetFocusInfo() {
        State state = this.z;
        state.m = -1L;
        state.l = -1;
        state.n = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.i != null) ? getFocusedChild() : null;
        ViewHolder findContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (findContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.z.m = this.i.hasStableIds() ? findContainingViewHolder.getItemId() : -1L;
        this.z.l = this.t ? -1 : findContainingViewHolder.k() ? findContainingViewHolder.c : findContainingViewHolder.getAdapterPosition();
        this.z.n = getDeepestFocusedViewWithId(findContainingViewHolder.itemView);
    }

    private void setAdapterInternal(@Nullable Adapter adapter, boolean z, boolean z2) {
        Adapter adapter2 = this.i;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.i.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            r();
        }
        this.b.f();
        Adapter adapter3 = this.i;
        this.i = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.j;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.i);
        }
        this.a.a(adapter3, this.i, z);
        this.z.f = true;
    }

    private void stopScrollersInternal() {
        this.w.stop();
        LayoutManager layoutManager = this.j;
        if (layoutManager != null) {
            layoutManager.c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.recyclerview.widget.RecyclerView.ViewHolder a(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.ChildHelper r0 = r5.c
            int r0 = r0.b()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.ChildHelper r3 = r5.c
            android.view.View r3 = r3.d(r2)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = f(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.k()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.b
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.ChildHelper r1 = r5.c
            android.view.View r4 = r3.itemView
            boolean r1 = r1.c(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(int, boolean):androidx.recyclerview.widget.RecyclerView$ViewHolder");
    }

    void a() {
        int b = this.c.b();
        for (int i = 0; i < b; i++) {
            ViewHolder f = f(this.c.d(i));
            if (!f.s()) {
                f.a();
            }
        }
        this.a.a();
    }

    void a(int i) {
        LayoutManager layoutManager = this.j;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    void a(int i, int i2) {
        if (i < 0) {
            f();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i);
            }
        } else if (i > 0) {
            g();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            h();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            e();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i2);
            }
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    void a(@Px int i, @Px int i2, @Nullable Interpolator interpolator, int i3, boolean z) {
        LayoutManager layoutManager = this.j;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.r) {
            return;
        }
        if (!layoutManager.canScrollHorizontally()) {
            i = 0;
        }
        if (!this.j.canScrollVertically()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        if (!(i3 == Integer.MIN_VALUE || i3 > 0)) {
            scrollBy(i, i2);
            return;
        }
        if (z) {
            int i4 = i != 0 ? 1 : 0;
            if (i2 != 0) {
                i4 |= 2;
            }
            startNestedScroll(i4, 1);
        }
        this.w.smoothScrollBy(i, i2, i3, interpolator);
    }

    void a(int i, int i2, Object obj) {
        int i3;
        int b = this.c.b();
        int i4 = i + i2;
        for (int i5 = 0; i5 < b; i5++) {
            View d = this.c.d(i5);
            ViewHolder f = f(d);
            if (f != null && !f.s() && (i3 = f.b) >= i && i3 < i4) {
                f.a(2);
                f.a(obj);
                ((LayoutParams) d.getLayoutParams()).c = true;
            }
        }
        this.a.c(i, i2);
    }

    void a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int b = this.c.b();
        for (int i4 = 0; i4 < b; i4++) {
            ViewHolder f = f(this.c.d(i4));
            if (f != null && !f.s()) {
                int i5 = f.b;
                if (i5 >= i3) {
                    f.a(-i2, z);
                } else if (i5 >= i) {
                    f.a(i - 1, -i2, z);
                }
                this.z.f = true;
            }
        }
        this.a.a(i, i2, z);
        requestLayout();
    }

    void a(int i, int i2, @Nullable int[] iArr) {
        u();
        o();
        TraceCompat.beginSection("RV Scroll");
        a(this.z);
        int scrollHorizontallyBy = i != 0 ? this.j.scrollHorizontallyBy(i, this.a, this.z) : 0;
        int scrollVerticallyBy = i2 != 0 ? this.j.scrollVerticallyBy(i2, this.a, this.z) : 0;
        TraceCompat.endSection();
        s();
        p();
        c(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    @VisibleForTesting
    void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(androidx.recyclerview.R.dimen.fastscroll_margin));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + i());
        }
    }

    void a(View view) {
        ViewHolder f = f(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.i;
        if (adapter != null && f != null) {
            adapter.onViewAttachedToWindow(f);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    final void a(State state) {
        if (getScrollState() != 2) {
            state.o = 0;
            state.p = 0;
        } else {
            OverScroller overScroller = this.w.a;
            state.o = overScroller.getFinalX() - overScroller.getCurrX();
            state.p = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    void a(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.a(0, 8192);
        if (this.z.h && viewHolder.n() && !viewHolder.k() && !viewHolder.s()) {
            this.d.a(c(viewHolder), viewHolder);
        }
        this.d.c(viewHolder, itemHolderInfo);
    }

    void a(@NonNull ViewHolder viewHolder, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.v.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            q();
        }
    }

    void a(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + i());
        }
        throw new IllegalStateException(str + i());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.mLayoutOrScrollCounter--;
        if (this.mLayoutOrScrollCounter < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                d();
            }
        }
    }

    boolean a(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        b();
        if (this.i != null) {
            int[] iArr = this.E;
            iArr[0] = 0;
            iArr[1] = 0;
            a(i, i2, iArr);
            int[] iArr2 = this.E;
            int i7 = iArr2[0];
            int i8 = iArr2[1];
            i4 = i8;
            i3 = i7;
            i5 = i - i7;
            i6 = i2 - i8;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.l.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.E;
        iArr3[0] = 0;
        iArr3[1] = 0;
        int i9 = i3;
        dispatchNestedScroll(i3, i4, i5, i6, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.E;
        int i10 = i5 - iArr4[0];
        int i11 = i6 - iArr4[1];
        boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i12 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i12 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !MotionEventCompat.isFromSource(motionEvent, 8194)) {
                pullGlows(motionEvent.getX(), i10, motionEvent.getY(), i11);
            }
            b(i, i2);
        }
        if (i9 != 0 || i4 != 0) {
            d(i9, i4);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z && i9 == 0 && i4 == 0) ? false : true;
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? AccessibilityEventCompat.getContentChangeTypes(accessibilityEvent) : 0;
        if (contentChangeTypes == 0) {
            contentChangeTypes = 0;
        }
        this.mEatenAccessibilityChangeFlags = contentChangeTypes | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    boolean a(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.v;
        return itemAnimator == null || itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.f());
    }

    @VisibleForTesting
    boolean a(ViewHolder viewHolder, int i) {
        if (!isComputingLayout()) {
            ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
            return true;
        }
        viewHolder.n = i;
        this.F.add(viewHolder);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        LayoutManager layoutManager = this.j;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    public void addItemDecoration(@NonNull ItemDecoration itemDecoration, int i) {
        LayoutManager layoutManager = this.j;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.l.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.l.add(itemDecoration);
        } else {
            this.l.add(i, itemDecoration);
        }
        m();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void addOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    int b(ViewHolder viewHolder) {
        if (viewHolder.b(524) || !viewHolder.i()) {
            return -1;
        }
        return this.b.applyPendingUpdatesToPosition(viewHolder.b);
    }

    void b() {
        if (!this.p || this.t) {
            TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            c();
            TraceCompat.endSection();
            return;
        }
        if (this.b.c()) {
            if (this.b.b(4) && !this.b.b(11)) {
                TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                u();
                o();
                this.b.e();
                if (!this.q) {
                    if (hasUpdatedView()) {
                        c();
                    } else {
                        this.b.a();
                    }
                }
                c(true);
                p();
            } else {
                if (!this.b.c()) {
                    return;
                }
                TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                c();
            }
            TraceCompat.endSection();
        }
    }

    void b(int i) {
        if (this.j == null) {
            return;
        }
        setScrollState(2);
        this.j.scrollToPosition(i);
        awakenScrollBars();
    }

    void b(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    void b(View view) {
        ViewHolder f = f(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.i;
        if (adapter != null && f != null) {
            adapter.onViewDetachedFromWindow(f);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    void b(@NonNull ViewHolder viewHolder, @NonNull ItemAnimator.ItemHolderInfo itemHolderInfo, @Nullable ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.v.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            q();
        }
    }

    void b(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + i());
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + i()));
        }
    }

    void b(boolean z) {
        this.u = z | this.u;
        this.t = true;
        n();
    }

    long c(ViewHolder viewHolder) {
        return this.i.hasStableIds() ? viewHolder.getItemId() : viewHolder.b;
    }

    Rect c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.c) {
            return layoutParams.b;
        }
        if (this.z.isPreLayout() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return layoutParams.b;
        }
        Rect rect = layoutParams.b;
        rect.set(0, 0, 0, 0);
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            this.g.set(0, 0, 0, 0);
            this.l.get(i).getItemOffsets(this.g, view, this, this.z);
            int i2 = rect.left;
            Rect rect2 = this.g;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.c = false;
        return rect;
    }

    void c() {
        String str;
        if (this.i == null) {
            str = "No adapter attached; skipping layout";
        } else {
            if (this.j != null) {
                State state = this.z;
                state.i = false;
                if (state.d == 1) {
                    dispatchLayoutStep1();
                } else if (!this.b.d() && this.j.getWidth() == getWidth() && this.j.getHeight() == getHeight()) {
                    this.j.b(this);
                    dispatchLayoutStep3();
                    return;
                }
                this.j.b(this);
                dispatchLayoutStep2();
                dispatchLayoutStep3();
                return;
            }
            str = "No layout manager attached; skipping layout";
        }
        Log.e("RecyclerView", str);
    }

    void c(int i, int i2) {
        setMeasuredDimension(LayoutManager.chooseSize(i, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    void c(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.r) {
            this.q = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.q && !this.r && this.j != null && this.i != null) {
                c();
            }
            if (!this.r) {
                this.q = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.j.checkLayoutParams((LayoutParams) layoutParams);
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.j;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.j.computeHorizontalScrollExtent(this.z);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.j;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.j.computeHorizontalScrollOffset(this.z);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.j;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.j.computeHorizontalScrollRange(this.z);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.j;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.j.computeVerticalScrollExtent(this.z);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.j;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.j.computeVerticalScrollOffset(this.z);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.j;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.j.computeVerticalScrollRange(this.z);
        }
        return 0;
    }

    void d() {
        int i;
        for (int size = this.F.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.F.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.s() && (i = viewHolder.n) != -1) {
                ViewCompat.setImportantForAccessibility(viewHolder.itemView, i);
                viewHolder.n = -1;
            }
        }
        this.F.clear();
    }

    void d(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled(i, i2);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i, i2);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    boolean d(View view) {
        u();
        boolean e = this.c.e(view);
        if (e) {
            ViewHolder f = f(view);
            this.a.c(f);
            this.a.b(f);
        }
        c(!e);
        return e;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, @NonNull int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        float f;
        int i;
        super.draw(canvas);
        int size = this.l.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.l.get(i2).onDrawOver(canvas, this, this.z);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.e ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.e) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.e ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z2 = z;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.e) {
                f = (-getWidth()) + getPaddingRight();
                i = (-getHeight()) + getPaddingBottom();
            } else {
                f = -getWidth();
                i = -getHeight();
            }
            canvas.translate(f, i);
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(save4);
        }
        if (!z2 && this.v != null && this.l.size() > 0 && this.v.isRunning()) {
            z2 = true;
        }
        if (z2) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    void e() {
        EdgeEffect edgeEffect;
        int measuredWidth;
        int measuredHeight;
        if (this.mBottomGlow != null) {
            return;
        }
        this.mBottomGlow = this.mEdgeEffectFactory.a(this, 3);
        if (this.e) {
            edgeEffect = this.mBottomGlow;
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            edgeEffect = this.mBottomGlow;
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        edgeEffect.setSize(measuredWidth, measuredHeight);
    }

    void e(int i, int i2) {
        int b = this.c.b();
        for (int i3 = 0; i3 < b; i3++) {
            ViewHolder f = f(this.c.d(i3));
            if (f != null && !f.s() && f.b >= i) {
                f.a(i2, false);
                this.z.f = true;
            }
        }
        this.a.a(i, i2);
        requestLayout();
    }

    void f() {
        EdgeEffect edgeEffect;
        int measuredHeight;
        int measuredWidth;
        if (this.mLeftGlow != null) {
            return;
        }
        this.mLeftGlow = this.mEdgeEffectFactory.a(this, 0);
        if (this.e) {
            edgeEffect = this.mLeftGlow;
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            edgeEffect = this.mLeftGlow;
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        edgeEffect.setSize(measuredHeight, measuredWidth);
    }

    void f(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int b = this.c.b();
        if (i < i2) {
            i4 = i;
            i3 = i2;
            i5 = -1;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i7 = 0; i7 < b; i7++) {
            ViewHolder f = f(this.c.d(i7));
            if (f != null && (i6 = f.b) >= i4 && i6 <= i3) {
                if (i6 == i) {
                    f.a(i2 - i, false);
                } else {
                    f.a(i5, false);
                }
                this.z.f = true;
            }
        }
        this.a.b(i, i2);
        requestLayout();
    }

    @Nullable
    public View findChildViewUnder(float f, float f2) {
        for (int a = this.c.a() - 1; a >= 0; a--) {
            View c = this.c.c(a);
            float translationX = c.getTranslationX();
            float translationY = c.getTranslationY();
            if (f >= c.getLeft() + translationX && f <= c.getRight() + translationX && f2 >= c.getTop() + translationY && f2 <= c.getBottom() + translationY) {
                return c;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return r3;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View findContainingItemView(@androidx.annotation.NonNull android.view.View r3) {
        /*
            r2 = this;
        L0:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L10
            if (r0 == r2) goto L10
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L10
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L0
        L10:
            if (r0 != r2) goto L13
            goto L14
        L13:
            r3 = 0
        L14:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    @Nullable
    public ViewHolder findContainingViewHolder(@NonNull View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    @Nullable
    public ViewHolder findViewHolderForAdapterPosition(int i) {
        ViewHolder viewHolder = null;
        if (this.t) {
            return null;
        }
        int b = this.c.b();
        for (int i2 = 0; i2 < b; i2++) {
            ViewHolder f = f(this.c.d(i2));
            if (f != null && !f.k() && b(f) == i) {
                if (!this.c.c(f.itemView)) {
                    return f;
                }
                viewHolder = f;
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j) {
        Adapter adapter = this.i;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int b = this.c.b();
            for (int i = 0; i < b; i++) {
                ViewHolder f = f(this.c.d(i));
                if (f != null && !f.k() && f.getItemId() == j) {
                    if (!this.c.c(f.itemView)) {
                        return f;
                    }
                    viewHolder = f;
                }
            }
        }
        return viewHolder;
    }

    @Nullable
    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return a(i, false);
    }

    @Nullable
    @Deprecated
    public ViewHolder findViewHolderForPosition(int i) {
        return a(i, false);
    }

    public boolean fling(int i, int i2) {
        LayoutManager layoutManager = this.j;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.r) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.j.canScrollVertically();
        if (!canScrollHorizontally || Math.abs(i) < this.mMinFlingVelocity) {
            i = 0;
        }
        if (!canScrollVertically || Math.abs(i2) < this.mMinFlingVelocity) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        if (!dispatchNestedPreFling(f, f2)) {
            boolean z = canScrollHorizontally || canScrollVertically;
            dispatchNestedFling(f, f2, z);
            OnFlingListener onFlingListener = this.mOnFlingListener;
            if (onFlingListener != null && onFlingListener.onFling(i, i2)) {
                return true;
            }
            if (z) {
                int i3 = canScrollHorizontally ? 1 : 0;
                if (canScrollVertically) {
                    i3 |= 2;
                }
                startNestedScroll(i3, 1);
                int i4 = this.mMaxFlingVelocity;
                int max = Math.max(-i4, Math.min(i, i4));
                int i5 = this.mMaxFlingVelocity;
                this.w.fling(max, Math.max(-i5, Math.min(i2, i5)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        View onInterceptFocusSearch = this.j.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z2 = (this.i == null || this.j == null || isComputingLayout() || this.r) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.j.canScrollVertically()) {
                int i2 = i == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.j.canScrollHorizontally()) {
                int i3 = (this.j.getLayoutDirection() == 1) ^ (i == 2) ? 66 : 17;
                z = focusFinder.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i3;
                }
            }
            if (z) {
                b();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                u();
                this.j.onFocusSearchFailed(view, i, this.a, this.z);
                c(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i);
            if (findNextFocus == null && z2) {
                b();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                u();
                view2 = this.j.onFocusSearchFailed(view, i, this.a, this.z);
                c(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return isPreferredNextFocus(view, view2, i) ? view2 : super.focusSearch(view, i);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        }
        requestChildOnScreen(view2, null);
        return view;
    }

    void g() {
        EdgeEffect edgeEffect;
        int measuredHeight;
        int measuredWidth;
        if (this.mRightGlow != null) {
            return;
        }
        this.mRightGlow = this.mEdgeEffectFactory.a(this, 2);
        if (this.e) {
            edgeEffect = this.mRightGlow;
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            edgeEffect = this.mRightGlow;
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        edgeEffect.setSize(measuredHeight, measuredWidth);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.j;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.j;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.j;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + i());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.i;
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.j;
        return layoutManager != null ? layoutManager.getBaseline() : super.getBaseline();
    }

    public int getChildAdapterPosition(@NonNull View view) {
        ViewHolder f = f(view);
        if (f != null) {
            return f.getAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        ChildDrawingOrderCallback childDrawingOrderCallback = this.mChildDrawingOrderCallback;
        return childDrawingOrderCallback == null ? super.getChildDrawingOrder(i, i2) : childDrawingOrderCallback.onGetChildDrawingOrder(i, i2);
    }

    public long getChildItemId(@NonNull View view) {
        ViewHolder f;
        Adapter adapter = this.i;
        if (adapter == null || !adapter.hasStableIds() || (f = f(view)) == null) {
            return -1L;
        }
        return f.getItemId();
    }

    public int getChildLayoutPosition(@NonNull View view) {
        ViewHolder f = f(view);
        if (f != null) {
            return f.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(@NonNull View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(@NonNull View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return f(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.e;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.D;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        a(view, rect);
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.v;
    }

    @NonNull
    public ItemDecoration getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return this.l.get(i);
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.l.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.j;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getNanoTime() {
        if (J) {
            return System.nanoTime();
        }
        return 0L;
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.a.c();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void h() {
        EdgeEffect edgeEffect;
        int measuredWidth;
        int measuredHeight;
        if (this.mTopGlow != null) {
            return;
        }
        this.mTopGlow = this.mEdgeEffectFactory.a(this, 1);
        if (this.e) {
            edgeEffect = this.mTopGlow;
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            edgeEffect = this.mTopGlow;
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        edgeEffect.setSize(measuredWidth, measuredHeight);
    }

    public boolean hasFixedSize() {
        return this.n;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().hasNestedScrollingParent(i);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.p || this.t || this.b.c();
    }

    String i() {
        return " " + super.toString() + ", adapter:" + this.i + ", layout:" + this.j + ", context:" + getContext();
    }

    public void invalidateItemDecorations() {
        if (this.l.size() == 0) {
            return;
        }
        LayoutManager layoutManager = this.j;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        m();
        requestLayout();
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.v;
        return itemAnimator != null && itemAnimator.isRunning();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.m;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.r;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    void j() {
        this.b = new AdapterHelper(new AdapterHelper.Callback() { // from class: androidx.recyclerview.widget.RecyclerView.6
            void a(AdapterHelper.UpdateOp updateOp) {
                int i = updateOp.a;
                if (i == 1) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.j.onItemsAdded(recyclerView, updateOp.b, updateOp.d);
                    return;
                }
                if (i == 2) {
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.j.onItemsRemoved(recyclerView2, updateOp.b, updateOp.d);
                } else if (i == 4) {
                    RecyclerView recyclerView3 = RecyclerView.this;
                    recyclerView3.j.onItemsUpdated(recyclerView3, updateOp.b, updateOp.d, updateOp.c);
                } else {
                    if (i != 8) {
                        return;
                    }
                    RecyclerView recyclerView4 = RecyclerView.this;
                    recyclerView4.j.onItemsMoved(recyclerView4, updateOp.b, updateOp.d, 1);
                }
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public ViewHolder findViewHolder(int i) {
                ViewHolder a = RecyclerView.this.a(i, true);
                if (a == null || RecyclerView.this.c.c(a.itemView)) {
                    return null;
                }
                return a;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void markViewHoldersUpdated(int i, int i2, Object obj) {
                RecyclerView.this.a(i, i2, obj);
                RecyclerView.this.B = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForAdd(int i, int i2) {
                RecyclerView.this.e(i, i2);
                RecyclerView.this.A = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForMove(int i, int i2) {
                RecyclerView.this.f(i, i2);
                RecyclerView.this.A = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForRemovingInvisible(int i, int i2) {
                RecyclerView.this.a(i, i2, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.A = true;
                recyclerView.z.c += i2;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2) {
                RecyclerView.this.a(i, i2, false);
                RecyclerView.this.A = true;
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void onDispatchFirstPass(AdapterHelper.UpdateOp updateOp) {
                a(updateOp);
            }

            @Override // androidx.recyclerview.widget.AdapterHelper.Callback
            public void onDispatchSecondPass(AdapterHelper.UpdateOp updateOp) {
                a(updateOp);
            }
        });
    }

    void k() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    boolean l() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    void m() {
        int b = this.c.b();
        for (int i = 0; i < b; i++) {
            ((LayoutParams) this.c.d(i).getLayoutParams()).c = true;
        }
        this.a.e();
    }

    void n() {
        int b = this.c.b();
        for (int i = 0; i < b; i++) {
            ViewHolder f = f(this.c.d(i));
            if (f != null && !f.s()) {
                f.a(6);
            }
        }
        m();
        this.a.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.mLayoutOrScrollCounter++;
    }

    public void offsetChildrenHorizontal(@Px int i) {
        int a = this.c.a();
        for (int i2 = 0; i2 < a; i2++) {
            this.c.c(i2).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(@Px int i) {
        int a = this.c.a();
        for (int i2 = 0; i2 < a; i2++) {
            this.c.c(i2).offsetTopAndBottom(i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
    
        if (r0 >= 30.0f) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.mLayoutOrScrollCounter = r0
            r1 = 1
            r4.m = r1
            boolean r2 = r4.p
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r4.p = r1
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r4.j
            if (r1 == 0) goto L1e
            r1.a(r4)
        L1e:
            r4.C = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.J
            if (r0 == 0) goto L67
            java.lang.ThreadLocal<androidx.recyclerview.widget.GapWorker> r0 = androidx.recyclerview.widget.GapWorker.d
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.GapWorker r0 = (androidx.recyclerview.widget.GapWorker) r0
            r4.x = r0
            androidx.recyclerview.widget.GapWorker r0 = r4.x
            if (r0 != 0) goto L62
            androidx.recyclerview.widget.GapWorker r0 = new androidx.recyclerview.widget.GapWorker
            r0.<init>()
            r4.x = r0
            android.view.Display r0 = androidx.core.view.ViewCompat.getDisplay(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L52
            if (r0 == 0) goto L52
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L52
            goto L54
        L52:
            r0 = 1114636288(0x42700000, float:60.0)
        L54:
            androidx.recyclerview.widget.GapWorker r1 = r4.x
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.c = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.GapWorker> r0 = androidx.recyclerview.widget.GapWorker.d
            r0.set(r1)
        L62:
            androidx.recyclerview.widget.GapWorker r0 = r4.x
            r0.add(r4)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(@NonNull View view) {
    }

    public void onChildDetachedFromWindow(@NonNull View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.v;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        this.m = false;
        LayoutManager layoutManager = this.j;
        if (layoutManager != null) {
            layoutManager.a(this, this.a);
        }
        this.F.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.d.b();
        if (!J || (gapWorker = this.x) == null) {
            return;
        }
        gapWorker.remove(this);
        this.x = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.l.size();
        for (int i = 0; i < size; i++) {
            this.l.get(i).onDraw(canvas, this, this.z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.j
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.r
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.j
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r5.j
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r5.j
            boolean r3 = r3.canScrollVertically()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r5.j
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.a(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.r) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.j;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.j.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = canScrollHorizontally ? 1 : 0;
            if (canScrollVertically) {
                i |= 2;
            }
            startNestedScroll(i, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i2 = x2 - this.mInitialTouchX;
                int i3 = y2 - this.mInitialTouchY;
                if (!canScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                    z = false;
                } else {
                    this.mLastTouchX = x2;
                    z = true;
                }
                if (canScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                    this.mLastTouchY = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        c();
        TraceCompat.endSection();
        this.p = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        LayoutManager layoutManager = this.j;
        if (layoutManager == null) {
            c(i, i2);
            return;
        }
        boolean z = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.j.onMeasure(this.a, this.z, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.i == null) {
                return;
            }
            if (this.z.d == 1) {
                dispatchLayoutStep1();
            }
            this.j.a(i, i2);
            this.z.i = true;
            dispatchLayoutStep2();
            this.j.b(i, i2);
            if (this.j.b()) {
                this.j.a(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Ints.MAX_POWER_OF_TWO));
                this.z.i = true;
                dispatchLayoutStep2();
                this.j.b(i, i2);
                return;
            }
            return;
        }
        if (this.n) {
            this.j.onMeasure(this.a, this.z, i, i2);
            return;
        }
        if (this.s) {
            u();
            o();
            processAdapterUpdatesAndSetAnimationFlags();
            p();
            State state = this.z;
            if (state.k) {
                state.g = true;
            } else {
                this.b.b();
                this.z.g = false;
            }
            this.s = false;
            c(false);
        } else if (this.z.k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        Adapter adapter = this.i;
        if (adapter != null) {
            this.z.e = adapter.getItemCount();
        } else {
            this.z.e = 0;
        }
        u();
        this.j.onMeasure(this.a, this.z, i, i2);
        c(false);
        this.z.g = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.mPendingSavedState = (SavedState) parcelable;
        super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
        LayoutManager layoutManager = this.j;
        if (layoutManager == null || (parcelable2 = this.mPendingSavedState.a) == null) {
            return;
        }
        layoutManager.onRestoreInstanceState(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.a(savedState2);
        } else {
            LayoutManager layoutManager = this.j;
            savedState.a = layoutManager != null ? layoutManager.onSaveInstanceState() : null;
        }
        return savedState;
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(@Px int i, @Px int i2) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        k();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void p() {
        a(true);
    }

    void q() {
        if (this.C || !this.m) {
            return;
        }
        ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
        this.C = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        ItemAnimator itemAnimator = this.v;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        LayoutManager layoutManager = this.j;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.a);
            this.j.a(this.a);
        }
        this.a.clear();
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        ViewHolder f = f(view);
        if (f != null) {
            if (f.m()) {
                f.d();
            } else if (!f.s()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + f + i());
            }
        }
        view.clearAnimation();
        b(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(@NonNull ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.j;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.l.remove(itemDecoration);
        if (this.l.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        m();
        requestLayout();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i));
            return;
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(onChildAttachStateChangeListener);
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mInterceptingOnItemTouchListener == onItemTouchListener) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(@NonNull OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.j.onRequestChildFocus(this, this.z, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.j.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.r) {
            this.q = true;
        } else {
            super.requestLayout();
        }
    }

    void s() {
        ViewHolder viewHolder;
        int a = this.c.a();
        for (int i = 0; i < a; i++) {
            View c = this.c.c(i);
            ViewHolder childViewHolder = getChildViewHolder(c);
            if (childViewHolder != null && (viewHolder = childViewHolder.h) != null) {
                View view = viewHolder.itemView;
                int left = c.getLeft();
                int top = c.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        LayoutManager layoutManager = this.j;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.r) {
            return;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.j.canScrollVertically();
        if (canScrollHorizontally || canScrollVertically) {
            if (!canScrollHorizontally) {
                i = 0;
            }
            if (!canScrollVertically) {
                i2 = 0;
            }
            a(i, i2, (MotionEvent) null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i) {
        if (this.r) {
            return;
        }
        stopScroll();
        LayoutManager layoutManager = this.j;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (a(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.D = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, this.D);
    }

    public void setAdapter(@Nullable Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        b(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = childDrawingOrderCallback;
        setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.e) {
            k();
        }
        this.e = z;
        super.setClipToPadding(z);
        if (this.p) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory edgeEffectFactory) {
        Preconditions.checkNotNull(edgeEffectFactory);
        this.mEdgeEffectFactory = edgeEffectFactory;
        k();
    }

    public void setHasFixedSize(boolean z) {
        this.n = z;
    }

    public void setItemAnimator(@Nullable ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.v;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.v.a((ItemAnimator.ItemAnimatorListener) null);
        }
        this.v = itemAnimator;
        ItemAnimator itemAnimator3 = this.v;
        if (itemAnimator3 != null) {
            itemAnimator3.a(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.a.setViewCacheSize(i);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(@Nullable LayoutManager layoutManager) {
        if (layoutManager == this.j) {
            return;
        }
        stopScroll();
        if (this.j != null) {
            ItemAnimator itemAnimator = this.v;
            if (itemAnimator != null) {
                itemAnimator.endAnimations();
            }
            this.j.removeAndRecycleAllViews(this.a);
            this.j.a(this.a);
            this.a.clear();
            if (this.m) {
                this.j.a(this, this.a);
            }
            this.j.c(null);
            this.j = null;
        } else {
            this.a.clear();
        }
        this.c.c();
        this.j = layoutManager;
        if (layoutManager != null) {
            if (layoutManager.b != null) {
                throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.b.i());
            }
            this.j.c(this);
            if (this.m) {
                this.j.a(this);
            }
        }
        this.a.h();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().setNestedScrollingEnabled(z);
    }

    public void setOnFlingListener(@Nullable OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool recycledViewPool) {
        this.a.a(recycledViewPool);
    }

    public void setRecyclerListener(@Nullable RecyclerListener recyclerListener) {
        this.k = recyclerListener;
    }

    void setScrollState(int i) {
        if (i == this.mScrollState) {
            return;
        }
        this.mScrollState = i;
        if (i != 2) {
            stopScrollersInternal();
        }
        a(i);
    }

    public void setScrollingTouchSlop(int i) {
        int scaledTouchSlop;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i == 1) {
                scaledTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                this.mTouchSlop = scaledTouchSlop;
            } else {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
            }
        }
        scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mTouchSlop = scaledTouchSlop;
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension viewCacheExtension) {
        this.a.a(viewCacheExtension);
    }

    public void smoothScrollBy(@Px int i, @Px int i2) {
        smoothScrollBy(i, i2, null);
    }

    public void smoothScrollBy(@Px int i, @Px int i2, @Nullable Interpolator interpolator) {
        smoothScrollBy(i, i2, interpolator, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(@Px int i, @Px int i2, @Nullable Interpolator interpolator, int i3) {
        a(i, i2, interpolator, i3, false);
    }

    public void smoothScrollToPosition(int i) {
        if (this.r) {
            return;
        }
        LayoutManager layoutManager = this.j;
        if (layoutManager == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            layoutManager.smoothScrollToPosition(this, this.z, i);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().startNestedScroll(i, i2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        getScrollingChildHelper().stopNestedScroll(i);
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.r) {
            b("Do not suppressLayout in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.r = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.r = false;
            if (this.q && this.j != null && this.i != null) {
                requestLayout();
            }
            this.q = false;
        }
    }

    public void swapAdapter(@Nullable Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z);
        b(true);
        requestLayout();
    }

    void t() {
        int b = this.c.b();
        for (int i = 0; i < b; i++) {
            ViewHolder f = f(this.c.d(i));
            if (!f.s()) {
                f.q();
            }
        }
    }

    void u() {
        this.mInterceptRequestLayoutDepth++;
        if (this.mInterceptRequestLayoutDepth != 1 || this.r) {
            return;
        }
        this.q = false;
    }
}
