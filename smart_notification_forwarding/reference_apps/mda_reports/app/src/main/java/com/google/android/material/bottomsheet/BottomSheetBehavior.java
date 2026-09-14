package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    int a;
    int b;
    int c;
    private BottomSheetCallback callback;
    boolean d;
    private final ViewDragHelper.Callback dragCallback;
    int e;
    ViewDragHelper f;
    private boolean fitToContents;
    int g;
    WeakReference<V> h;
    WeakReference<View> i;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    int j;
    boolean k;
    private int lastNestedScrollDy;
    private int lastPeekHeight;
    private float maximumVelocity;
    private boolean nestedScrolled;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private boolean skipCollapsed;
    private VelocityTracker velocityTracker;

    /* loaded from: classes.dex */
    public static abstract class BottomSheetCallback {
        public abstract void onSlide(@NonNull View view, float f);

        public abstract void onStateChanged(@NonNull View view, int i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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
        final int a;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.a = i;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SettleRunnable implements Runnable {
        private final int targetState;
        private final View view;

        SettleRunnable(View view, int i) {
            this.view = view;
            this.targetState = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.f;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                BottomSheetBehavior.this.b(this.targetState);
            } else {
                ViewCompat.postOnAnimation(this.view, this);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface State {
    }

    public BottomSheetBehavior() {
        this.fitToContents = true;
        this.e = 4;
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view, int i, int i2) {
                int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return MathUtils.clamp(i, expandedOffset, bottomSheetBehavior.d ? bottomSheetBehavior.g : bottomSheetBehavior.c);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(@NonNull View view) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return bottomSheetBehavior.d ? bottomSheetBehavior.g : bottomSheetBehavior.c;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i) {
                if (i == 1) {
                    BottomSheetBehavior.this.b(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.a(i2);
            }

            /* JADX WARN: Code restructure failed: missing block: B:42:0x00a2, code lost:
            
                if (r9 < java.lang.Math.abs(r9 - r10.c)) goto L12;
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:0x00b4, code lost:
            
                if (java.lang.Math.abs(r9 - r1) < java.lang.Math.abs(r9 - r7.a.c)) goto L41;
             */
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onViewReleased(@androidx.annotation.NonNull android.view.View r8, float r9, float r10) {
                /*
                    Method dump skipped, instructions count: 226
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass2.onViewReleased(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view, int i) {
                WeakReference<V> weakReference;
                View view2;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i2 = bottomSheetBehavior.e;
                if (i2 == 1 || bottomSheetBehavior.k) {
                    return false;
                }
                return ((i2 == 3 && bottomSheetBehavior.j == i && (view2 = bottomSheetBehavior.i.get()) != null && view2.canScrollVertically(-1)) || (weakReference = BottomSheetBehavior.this.h) == null || weakReference.get() != view) ? false : true;
            }
        };
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        this.fitToContents = true;
        this.e = 4;
        this.dragCallback = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(@NonNull View view, int i2, int i22) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(@NonNull View view, int i2, int i22) {
                int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return MathUtils.clamp(i2, expandedOffset, bottomSheetBehavior.d ? bottomSheetBehavior.g : bottomSheetBehavior.c);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(@NonNull View view) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return bottomSheetBehavior.d ? bottomSheetBehavior.g : bottomSheetBehavior.c;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i2) {
                if (i2 == 1) {
                    BottomSheetBehavior.this.b(1);
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(@NonNull View view, int i2, int i22, int i3, int i4) {
                BottomSheetBehavior.this.a(i22);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(@NonNull View view, float f, float f2) {
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                    	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    */
                /*
                    Method dump skipped, instructions count: 226
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass2.onViewReleased(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(@NonNull View view, int i2) {
                WeakReference<V> weakReference;
                View view2;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i22 = bottomSheetBehavior.e;
                if (i22 == 1 || bottomSheetBehavior.k) {
                    return false;
                }
                return ((i22 == 3 && bottomSheetBehavior.j == i2 && (view2 = bottomSheetBehavior.i.get()) != null && view2.canScrollVertically(-1)) || (weakReference = BottomSheetBehavior.this.h) == null || weakReference.get() != view) ? false : true;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        setPeekHeight((peekValue == null || (i = peekValue.data) != -1) ? obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1) : i);
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void calculateCollapsedOffset() {
        this.c = this.fitToContents ? Math.max(this.g - this.lastPeekHeight, this.a) : this.g - this.lastPeekHeight;
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behavior;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getExpandedOffset() {
        if (this.fitToContents) {
            return this.a;
        }
        return 0;
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.j);
    }

    private void reset() {
        this.j = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void updateImportantForAccessibility(boolean z) {
        int intValue;
        WeakReference<V> weakReference = this.h;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.importantForAccessibilityMap != null) {
                    return;
                } else {
                    this.importantForAccessibilityMap = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.h.get()) {
                    if (!z) {
                        Map<View, Integer> map = this.importantForAccessibilityMap;
                        intValue = (map != null && map.containsKey(childAt)) ? this.importantForAccessibilityMap.get(childAt).intValue() : 4;
                    } else if (Build.VERSION.SDK_INT >= 16) {
                        this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    }
                    ViewCompat.setImportantForAccessibility(childAt, intValue);
                }
            }
            if (z) {
                return;
            }
            this.importantForAccessibilityMap = null;
        }
    }

    @VisibleForTesting
    View a(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View a = a(viewGroup.getChildAt(i));
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    void a(int i) {
        BottomSheetCallback bottomSheetCallback;
        float f;
        float expandedOffset;
        V v = this.h.get();
        if (v == null || (bottomSheetCallback = this.callback) == null) {
            return;
        }
        int i2 = this.c;
        if (i > i2) {
            f = i2 - i;
            expandedOffset = this.g - i2;
        } else {
            f = i2 - i;
            expandedOffset = i2 - getExpandedOffset();
        }
        bottomSheetCallback.onSlide(v, f / expandedOffset);
    }

    void a(View view, int i) {
        int i2;
        int i3;
        if (i == 4) {
            i2 = this.c;
        } else if (i == 6) {
            int i4 = this.b;
            if (!this.fitToContents || i4 > (i3 = this.a)) {
                i2 = i4;
            } else {
                i2 = i3;
                i = 3;
            }
        } else if (i == 3) {
            i2 = getExpandedOffset();
        } else {
            if (!this.d || i != 5) {
                throw new IllegalArgumentException("Illegal state argument: " + i);
            }
            i2 = this.g;
        }
        if (!this.f.smoothSlideViewTo(view, view.getLeft(), i2)) {
            b(i);
        } else {
            b(2);
            ViewCompat.postOnAnimation(view, new SettleRunnable(view, i));
        }
    }

    boolean a(View view, float f) {
        if (this.skipCollapsed) {
            return true;
        }
        return view.getTop() >= this.c && Math.abs((((float) view.getTop()) + (f * HIDE_FRICTION)) - ((float) this.c)) / ((float) this.peekHeight) > HIDE_THRESHOLD;
    }

    void b(int i) {
        boolean z;
        V v;
        BottomSheetCallback bottomSheetCallback;
        if (this.e == i) {
            return;
        }
        this.e = i;
        if (i != 6 && i != 3) {
            z = (i == 5 || i == 4) ? false : true;
            v = this.h.get();
            if (v != null || (bottomSheetCallback = this.callback) == null) {
            }
            bottomSheetCallback.onStateChanged(v, i);
            return;
        }
        updateImportantForAccessibility(z);
        v = this.h.get();
        if (v != null) {
        }
    }

    public final int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public final int getState() {
        return this.e;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isHideable() {
        return this.d;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!v.isShown()) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.i;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.initialY)) {
                this.j = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.k = true;
            }
            this.ignoreEvents = this.j == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.initialY);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.k = false;
            this.j = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents && (viewDragHelper = this.f) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.i;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.ignoreEvents || this.e == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f == null || Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.f.getTouchSlop())) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0093  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, int r7) {
        /*
            r4 = this;
            boolean r0 = androidx.core.view.ViewCompat.getFitsSystemWindows(r5)
            r1 = 1
            if (r0 == 0) goto L10
            boolean r0 = androidx.core.view.ViewCompat.getFitsSystemWindows(r6)
            if (r0 != 0) goto L10
            r6.setFitsSystemWindows(r1)
        L10:
            int r0 = r6.getTop()
            r5.onLayoutChild(r6, r7)
            int r7 = r5.getHeight()
            r4.g = r7
            boolean r7 = r4.peekHeightAuto
            if (r7 == 0) goto L43
            int r7 = r4.peekHeightMin
            if (r7 != 0) goto L31
            android.content.res.Resources r7 = r5.getResources()
            int r2 = com.google.android.material.R.dimen.design_bottom_sheet_peek_height_min
            int r7 = r7.getDimensionPixelSize(r2)
            r4.peekHeightMin = r7
        L31:
            int r7 = r4.peekHeightMin
            int r2 = r4.g
            int r3 = r5.getWidth()
            int r3 = r3 * 9
            int r3 = r3 / 16
            int r2 = r2 - r3
            int r7 = java.lang.Math.max(r7, r2)
            goto L45
        L43:
            int r7 = r4.peekHeight
        L45:
            r4.lastPeekHeight = r7
            r7 = 0
            int r2 = r4.g
            int r3 = r6.getHeight()
            int r2 = r2 - r3
            int r7 = java.lang.Math.max(r7, r2)
            r4.a = r7
            int r7 = r4.g
            r2 = 2
            int r7 = r7 / r2
            r4.b = r7
            r4.calculateCollapsedOffset()
            int r7 = r4.e
            r3 = 3
            if (r7 != r3) goto L6b
            int r7 = r4.getExpandedOffset()
        L67:
            androidx.core.view.ViewCompat.offsetTopAndBottom(r6, r7)
            goto L8f
        L6b:
            r3 = 6
            if (r7 != r3) goto L71
            int r7 = r4.b
            goto L67
        L71:
            boolean r3 = r4.d
            if (r3 == 0) goto L7b
            r3 = 5
            if (r7 != r3) goto L7b
            int r7 = r4.g
            goto L67
        L7b:
            int r7 = r4.e
            r3 = 4
            if (r7 != r3) goto L83
            int r7 = r4.c
            goto L67
        L83:
            if (r7 == r1) goto L87
            if (r7 != r2) goto L8f
        L87:
            int r7 = r6.getTop()
            int r0 = r0 - r7
            androidx.core.view.ViewCompat.offsetTopAndBottom(r6, r0)
        L8f:
            androidx.customview.widget.ViewDragHelper r7 = r4.f
            if (r7 != 0) goto L9b
            androidx.customview.widget.ViewDragHelper$Callback r7 = r4.dragCallback
            androidx.customview.widget.ViewDragHelper r5 = androidx.customview.widget.ViewDragHelper.create(r5, r7)
            r4.f = r5
        L9b:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            r5.<init>(r6)
            r4.h = r5
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            android.view.View r6 = r4.a(r6)
            r5.<init>(r6)
            r4.i = r5
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onLayoutChild(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f, float f2) {
        return view == this.i.get() && (this.e != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
        int i4;
        if (i3 != 1 && view == this.i.get()) {
            int top = v.getTop();
            int i5 = top - i2;
            if (i2 > 0) {
                if (i5 < getExpandedOffset()) {
                    iArr[1] = top - getExpandedOffset();
                    ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                    i4 = 3;
                    b(i4);
                } else {
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    b(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                int i6 = this.c;
                if (i5 <= i6 || this.d) {
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    b(1);
                } else {
                    iArr[1] = top - i6;
                    ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                    i4 = 4;
                    b(i4);
                }
            }
            a(v.getTop());
            this.lastNestedScrollDy = i2;
            this.nestedScrolled = true;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        int i = savedState.a;
        if (i == 1 || i == 2) {
            i = 4;
        }
        this.e = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.e);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i, int i2) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
    
        if (java.lang.Math.abs(r4 - r1) < java.lang.Math.abs(r4 - r3.c)) goto L33;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onStopNestedScroll(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r4, @androidx.annotation.NonNull V r5, @androidx.annotation.NonNull android.view.View r6, int r7) {
        /*
            r3 = this;
            int r4 = r5.getTop()
            int r7 = r3.getExpandedOffset()
            r0 = 3
            if (r4 != r7) goto Lf
            r3.b(r0)
            return
        Lf:
            java.lang.ref.WeakReference<android.view.View> r4 = r3.i
            java.lang.Object r4 = r4.get()
            if (r6 != r4) goto L9f
            boolean r4 = r3.nestedScrolled
            if (r4 != 0) goto L1d
            goto L9f
        L1d:
            int r4 = r3.lastNestedScrollDy
            r6 = 0
            r7 = 4
            if (r4 <= 0) goto L28
            int r4 = r3.getExpandedOffset()
            goto L81
        L28:
            boolean r4 = r3.d
            if (r4 == 0) goto L3a
            float r4 = r3.getYVelocity()
            boolean r4 = r3.a(r5, r4)
            if (r4 == 0) goto L3a
            int r4 = r3.g
            r0 = 5
            goto L81
        L3a:
            int r4 = r3.lastNestedScrollDy
            if (r4 != 0) goto L7e
            int r4 = r5.getTop()
            boolean r1 = r3.fitToContents
            r2 = 6
            if (r1 == 0) goto L5b
            int r1 = r3.a
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.c
            int r4 = r4 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r1 >= r4) goto L7e
            int r4 = r3.a
            goto L81
        L5b:
            int r1 = r3.b
            if (r4 >= r1) goto L6b
            int r7 = r3.c
            int r7 = r4 - r7
            int r7 = java.lang.Math.abs(r7)
            if (r4 >= r7) goto L7a
            r4 = 0
            goto L81
        L6b:
            int r0 = r4 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r3.c
            int r4 = r4 - r1
            int r4 = java.lang.Math.abs(r4)
            if (r0 >= r4) goto L7e
        L7a:
            int r4 = r3.b
            r0 = 6
            goto L81
        L7e:
            int r4 = r3.c
            r0 = 4
        L81:
            androidx.customview.widget.ViewDragHelper r7 = r3.f
            int r1 = r5.getLeft()
            boolean r4 = r7.smoothSlideViewTo(r5, r1, r4)
            if (r4 == 0) goto L9a
            r4 = 2
            r3.b(r4)
            com.google.android.material.bottomsheet.BottomSheetBehavior$SettleRunnable r4 = new com.google.android.material.bottomsheet.BottomSheetBehavior$SettleRunnable
            r4.<init>(r5, r0)
            androidx.core.view.ViewCompat.postOnAnimation(r5, r4)
            goto L9d
        L9a:
            r3.b(r0)
        L9d:
            r3.nestedScrolled = r6
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.e == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.f;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - motionEvent.getY()) > this.f.getTouchSlop()) {
            this.f.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.callback = bottomSheetCallback;
    }

    public void setFitToContents(boolean z) {
        if (this.fitToContents == z) {
            return;
        }
        this.fitToContents = z;
        if (this.h != null) {
            calculateCollapsedOffset();
        }
        b((this.fitToContents && this.e == 6) ? 3 : this.e);
    }

    public void setHideable(boolean z) {
        this.d = z;
    }

    public final void setPeekHeight(int i) {
        WeakReference<V> weakReference;
        V v;
        boolean z = true;
        if (i == -1) {
            if (!this.peekHeightAuto) {
                this.peekHeightAuto = true;
            }
            z = false;
        } else {
            if (this.peekHeightAuto || this.peekHeight != i) {
                this.peekHeightAuto = false;
                this.peekHeight = Math.max(0, i);
                this.c = this.g - i;
            }
            z = false;
        }
        if (!z || this.e != 4 || (weakReference = this.h) == null || (v = weakReference.get()) == null) {
            return;
        }
        v.requestLayout();
    }

    public void setSkipCollapsed(boolean z) {
        this.skipCollapsed = z;
    }

    public final void setState(final int i) {
        if (i == this.e) {
            return;
        }
        WeakReference<V> weakReference = this.h;
        if (weakReference == null) {
            if (i == 4 || i == 3 || i == 6 || (this.d && i == 5)) {
                this.e = i;
                return;
            }
            return;
        }
        final V v = weakReference.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v)) {
            v.post(new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    BottomSheetBehavior.this.a(v, i);
                }
            });
        } else {
            a((View) v, i);
        }
    }
}
