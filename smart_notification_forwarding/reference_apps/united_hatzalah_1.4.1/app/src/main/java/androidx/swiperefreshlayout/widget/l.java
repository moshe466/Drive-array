package androidx.swiperefreshlayout.widget;

import J.C0129q;
import J.C0131t;
import J.InterfaceC0130s;
import J.J;
import J.S;
import J.r;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ListView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.WeakHashMap;
import o0.AbstractC0597a;

/* loaded from: classes.dex */
public abstract class l extends ViewGroup implements InterfaceC0130s, r {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    static final int CIRCLE_DIAMETER = 40;
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS = {R.attr.enabled};
    private static final String LOG_TAG = "l";
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private i mChildScrollUpCallback;
    private int mCircleDiameter;
    a mCircleView;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    int mCustomSlingshotDistance;
    private final DecelerateInterpolator mDecelerateInterpolator;
    private boolean mEnableLegacyRequestDisallowInterceptTouch;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    j mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final C0129q mNestedScrollingChildHelper;
    private final C0131t mNestedScrollingParentHelper;
    private final int[] mNestedScrollingV2ConsumedCompat;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    e mProgress;
    private Animation.AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;

    /* JADX WARN: Type inference failed for: r1v18, types: [J.t, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.widget.ImageView, androidx.swiperefreshlayout.widget.a, android.view.View] */
    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new f(this, 0);
        this.mAnimateToCorrectPosition = new h(this, 0);
        this.mAnimateToStartPosition = new h(this, 4);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(DECELERATE_INTERPOLATION_FACTOR);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        ?? imageView = new ImageView(getContext());
        float f4 = imageView.getContext().getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = imageView.getContext().obtainStyledAttributes(AbstractC0597a.f5910a);
        imageView.f3741b = obtainStyledAttributes.getColor(0, -328966);
        obtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        WeakHashMap weakHashMap = S.f954a;
        J.i(imageView, f4 * 4.0f);
        shapeDrawable.getPaint().setColor(imageView.f3741b);
        imageView.setBackground(shapeDrawable);
        this.mCircleView = imageView;
        e eVar = new e(getContext());
        this.mProgress = eVar;
        eVar.c(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
        setChildrenDrawingOrderEnabled(true);
        int i = (int) (displayMetrics.density * 64.0f);
        this.mSpinnerOffsetEnd = i;
        this.mTotalDragDistance = i;
        this.mNestedScrollingParentHelper = new Object();
        this.mNestedScrollingChildHelper = new C0129q(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = i3;
        this.mOriginalOffsetTop = i3;
        moveToStart(1.0f);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes2.getBoolean(0, true));
        obtainStyledAttributes2.recycle();
    }

    private void setColorViewAlpha(int i) {
        this.mCircleView.getBackground().setAlpha(i);
        this.mProgress.setAlpha(i);
    }

    public final void a() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.mCircleView)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    public final void b(float f4) {
        f fVar;
        if (f4 > this.mTotalDragDistance) {
            d(true, true);
            return;
        }
        this.mRefreshing = false;
        e eVar = this.mProgress;
        d dVar = eVar.f3768a;
        dVar.f3750e = 0.0f;
        dVar.f3751f = 0.0f;
        eVar.invalidateSelf();
        boolean z3 = this.mScale;
        if (!z3) {
            fVar = new f(this, 1);
        } else {
            fVar = null;
        }
        int i = this.mCurrentTargetOffsetTop;
        if (z3) {
            this.mFrom = i;
            this.mStartingScale = this.mCircleView.getScaleX();
            h hVar = new h(this, 1);
            this.mScaleDownToStartAnimation = hVar;
            hVar.setDuration(150L);
            if (fVar != null) {
                this.mCircleView.f3740a = fVar;
            }
            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
        } else {
            this.mFrom = i;
            this.mAnimateToStartPosition.reset();
            this.mAnimateToStartPosition.setDuration(200L);
            this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
            if (fVar != null) {
                this.mCircleView.f3740a = fVar;
            }
            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(this.mAnimateToStartPosition);
        }
        e eVar2 = this.mProgress;
        d dVar2 = eVar2.f3768a;
        if (dVar2.f3758n) {
            dVar2.f3758n = false;
        }
        eVar2.invalidateSelf();
    }

    public final void c(float f4) {
        Animation animation;
        Animation animation2;
        e eVar = this.mProgress;
        d dVar = eVar.f3768a;
        if (!dVar.f3758n) {
            dVar.f3758n = true;
        }
        eVar.invalidateSelf();
        float min = Math.min(1.0f, Math.abs(f4 / this.mTotalDragDistance));
        float max = (((float) Math.max(min - 0.4d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) * 5.0f) / 3.0f;
        float abs = Math.abs(f4) - this.mTotalDragDistance;
        int i = this.mCustomSlingshotDistance;
        if (i <= 0) {
            if (this.mUsingCustomStart) {
                i = this.mSpinnerOffsetEnd - this.mOriginalOffsetTop;
            } else {
                i = this.mSpinnerOffsetEnd;
            }
        }
        float f5 = i;
        double max2 = Math.max(0.0f, Math.min(abs, f5 * DECELERATE_INTERPOLATION_FACTOR) / f5) / 4.0f;
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * DECELERATE_INTERPOLATION_FACTOR;
        int i3 = this.mOriginalOffsetTop + ((int) ((f5 * min) + (f5 * pow * DECELERATE_INTERPOLATION_FACTOR)));
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            this.mCircleView.setScaleX(1.0f);
            this.mCircleView.setScaleY(1.0f);
        }
        if (this.mScale) {
            setAnimationProgress(Math.min(1.0f, f4 / this.mTotalDragDistance));
        }
        if (f4 < this.mTotalDragDistance) {
            if (this.mProgress.f3768a.f3763t > STARTING_PROGRESS_ALPHA && ((animation2 = this.mAlphaStartAnimation) == null || !animation2.hasStarted() || animation2.hasEnded())) {
                g gVar = new g(this, this.mProgress.f3768a.f3763t, STARTING_PROGRESS_ALPHA);
                gVar.setDuration(300L);
                a aVar = this.mCircleView;
                aVar.f3740a = null;
                aVar.clearAnimation();
                this.mCircleView.startAnimation(gVar);
                this.mAlphaStartAnimation = gVar;
            }
        } else if (this.mProgress.f3768a.f3763t < MAX_ALPHA && ((animation = this.mAlphaMaxAnimation) == null || !animation.hasStarted() || animation.hasEnded())) {
            g gVar2 = new g(this, this.mProgress.f3768a.f3763t, MAX_ALPHA);
            gVar2.setDuration(300L);
            a aVar2 = this.mCircleView;
            aVar2.f3740a = null;
            aVar2.clearAnimation();
            this.mCircleView.startAnimation(gVar2);
            this.mAlphaMaxAnimation = gVar2;
        }
        float f6 = max * MAX_PROGRESS_ANGLE;
        e eVar2 = this.mProgress;
        float min2 = Math.min(MAX_PROGRESS_ANGLE, f6);
        d dVar2 = eVar2.f3768a;
        dVar2.f3750e = 0.0f;
        dVar2.f3751f = min2;
        eVar2.invalidateSelf();
        e eVar3 = this.mProgress;
        float min3 = Math.min(1.0f, max);
        d dVar3 = eVar3.f3768a;
        if (min3 != dVar3.p) {
            dVar3.p = min3;
        }
        eVar3.invalidateSelf();
        float f7 = ((pow * DECELERATE_INTERPOLATION_FACTOR) + ((max * 0.4f) - 0.25f)) * DRAG_RATE;
        e eVar4 = this.mProgress;
        eVar4.f3768a.f3752g = f7;
        eVar4.invalidateSelf();
        setTargetOffsetTopAndBottom(i3 - this.mCurrentTargetOffsetTop);
    }

    public boolean canChildScrollUp() {
        i iVar = this.mChildScrollUpCallback;
        if (iVar != null) {
            return iVar.canChildScrollUp(this, this.mTarget);
        }
        View view = this.mTarget;
        if (view instanceof ListView) {
            return ((ListView) view).canScrollList(-1);
        }
        return view.canScrollVertically(-1);
    }

    public final void d(boolean z3, boolean z4) {
        if (this.mRefreshing != z3) {
            this.mNotify = z4;
            a();
            this.mRefreshing = z3;
            if (z3) {
                int i = this.mCurrentTargetOffsetTop;
                Animation.AnimationListener animationListener = this.mRefreshListener;
                this.mFrom = i;
                this.mAnimateToCorrectPosition.reset();
                this.mAnimateToCorrectPosition.setDuration(200L);
                this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
                if (animationListener != null) {
                    this.mCircleView.f3740a = animationListener;
                }
                this.mCircleView.clearAnimation();
                this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
                return;
            }
            startScaleDownAnimation(this.mRefreshListener);
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f4, float f5, boolean z3) {
        return this.mNestedScrollingChildHelper.a(f4, f5, z3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f4, float f5) {
        return this.mNestedScrollingChildHelper.b(f4, f5);
    }

    public boolean dispatchNestedPreScroll(int i, int i3, int[] iArr, int[] iArr2, int i4) {
        return i4 == 0 && dispatchNestedPreScroll(i, i3, iArr, iArr2);
    }

    public void dispatchNestedScroll(int i, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        if (i6 == 0) {
            this.mNestedScrollingChildHelper.d(i, i3, i4, i5, iArr, i6, iArr2);
        }
    }

    public final void e(float f4) {
        float f5 = this.mInitialDownY;
        float f6 = f4 - f5;
        int i = this.mTouchSlop;
        if (f6 > i && !this.mIsBeingDragged) {
            this.mInitialMotionY = f5 + i;
            this.mIsBeingDragged = true;
            this.mProgress.setAlpha(STARTING_PROGRESS_ALPHA);
        }
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i3) {
        int i4 = this.mCircleViewIndex;
        if (i4 >= 0) {
            if (i3 == i - 1) {
                return i4;
            }
            if (i3 >= i4) {
                return i3 + 1;
            }
            return i3;
        }
        return i3;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0131t c0131t = this.mNestedScrollingParentHelper;
        return c0131t.f1032b | c0131t.f1031a;
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public boolean hasNestedScrollingParent(int i) {
        return i == 0 && hasNestedScrollingParent();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.f1026d;
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    public void moveToStart(float f4) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) ((this.mOriginalOffsetTop - r0) * f4))) - this.mCircleView.getTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a();
        int actionMasked = motionEvent.getActionMasked();
        int i = 0;
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (isEnabled() && !this.mReturningToStart && !canChildScrollUp() && !this.mRefreshing && !this.mNestedScrollInProgress) {
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
                                    if (actionIndex == 0) {
                                        i = 1;
                                    }
                                    this.mActivePointerId = motionEvent.getPointerId(i);
                                }
                            }
                        }
                    } else {
                        int i3 = this.mActivePointerId;
                        if (i3 == -1) {
                            Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                            return false;
                        }
                        int findPointerIndex = motionEvent.findPointerIndex(i3);
                        if (findPointerIndex >= 0) {
                            e(motionEvent.getY(findPointerIndex));
                        }
                    }
                    return this.mIsBeingDragged;
                }
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                return this.mIsBeingDragged;
            }
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.mActivePointerId = pointerId;
            this.mIsBeingDragged = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 >= 0) {
                this.mInitialDownY = motionEvent.getY(findPointerIndex2);
                return this.mIsBeingDragged;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.mTarget == null) {
                a();
            }
            View view = this.mTarget;
            if (view == null) {
                return;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
            int measuredWidth2 = this.mCircleView.getMeasuredWidth();
            int measuredHeight2 = this.mCircleView.getMeasuredHeight();
            int i6 = measuredWidth / 2;
            int i7 = measuredWidth2 / 2;
            int i8 = this.mCurrentTargetOffsetTop;
            this.mCircleView.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i3) {
        super.onMeasure(i, i3);
        if (this.mTarget == null) {
            a();
        }
        View view = this.mTarget;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
            this.mCircleViewIndex = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.mCircleView) {
                    this.mCircleViewIndex = i4;
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f4, float f5, boolean z3) {
        return dispatchNestedFling(f4, f5, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f4, float f5) {
        return dispatchNestedPreFling(f4, f5);
    }

    @Override // J.r
    public void onNestedPreScroll(View view, int i, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i, i3, iArr);
        }
    }

    @Override // J.InterfaceC0130s
    public void onNestedScroll(View view, int i, int i3, int i4, int i5, int i6, int[] iArr) {
        if (i6 != 0) {
            return;
        }
        int i7 = iArr[1];
        dispatchNestedScroll(i, i3, i4, i5, this.mParentOffsetInWindow, i6, iArr);
        int i8 = i5 - (iArr[1] - i7);
        if ((i8 == 0 ? i5 + this.mParentOffsetInWindow[1] : i8) >= 0 || canChildScrollUp()) {
            return;
        }
        float abs = this.mTotalUnconsumed + Math.abs(r14);
        this.mTotalUnconsumed = abs;
        c(abs);
        iArr[1] = iArr[1] + i8;
    }

    @Override // J.r
    public void onNestedScrollAccepted(View view, View view2, int i, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        k kVar = (k) parcelable;
        super.onRestoreInstanceState(kVar.getSuperState());
        setRefreshing(kVar.f3781a);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return new k(super.onSaveInstanceState(), this.mRefreshing);
    }

    @Override // J.r
    public boolean onStartNestedScroll(View view, View view2, int i, int i3) {
        if (i3 == 0) {
            return onStartNestedScroll(view, view2, i);
        }
        return false;
    }

    @Override // J.r
    public void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int i = 0;
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (isEnabled() && !this.mReturningToStart && !canChildScrollUp() && !this.mRefreshing && !this.mNestedScrollInProgress) {
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked != 5) {
                                if (actionMasked == 6) {
                                    int actionIndex = motionEvent.getActionIndex();
                                    if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
                                        if (actionIndex == 0) {
                                            i = 1;
                                        }
                                        this.mActivePointerId = motionEvent.getPointerId(i);
                                        return true;
                                    }
                                }
                                return true;
                            }
                            int actionIndex2 = motionEvent.getActionIndex();
                            if (actionIndex2 < 0) {
                                Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                                return false;
                            }
                            this.mActivePointerId = motionEvent.getPointerId(actionIndex2);
                            return true;
                        }
                    } else {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (findPointerIndex < 0) {
                            Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                            return false;
                        }
                        float y = motionEvent.getY(findPointerIndex);
                        e(y);
                        if (this.mIsBeingDragged) {
                            float f4 = (y - this.mInitialMotionY) * DRAG_RATE;
                            if (f4 > 0.0f) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                c(f4);
                            }
                        }
                        return true;
                    }
                } else {
                    int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex2 < 0) {
                        Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                        return false;
                    }
                    if (this.mIsBeingDragged) {
                        float y3 = (motionEvent.getY(findPointerIndex2) - this.mInitialMotionY) * DRAG_RATE;
                        this.mIsBeingDragged = false;
                        b(y3);
                    }
                    this.mActivePointerId = -1;
                    return false;
                }
            } else {
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z3) {
        ViewParent parent;
        View view = this.mTarget;
        if (view != null) {
            WeakHashMap weakHashMap = S.f954a;
            if (!J.f(view)) {
                if (!this.mEnableLegacyRequestDisallowInterceptTouch && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(z3);
                    return;
                }
                return;
            }
        }
        super.requestDisallowInterceptTouchEvent(z3);
    }

    public void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(MAX_ALPHA);
        if (this.mScale) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        }
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    public void setAnimationProgress(float f4) {
        this.mCircleView.setScaleX(f4);
        this.mCircleView.setScaleY(f4);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        a();
        e eVar = this.mProgress;
        d dVar = eVar.f3768a;
        dVar.i = iArr;
        dVar.a(0);
        dVar.a(0);
        eVar.invalidateSelf();
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = context.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.mTotalDragDistance = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        if (!z3) {
            reset();
        }
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z3) {
        this.mEnableLegacyRequestDisallowInterceptTouch = z3;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z3) {
        C0129q c0129q = this.mNestedScrollingChildHelper;
        if (c0129q.f1026d) {
            ViewGroup viewGroup = c0129q.f1025c;
            WeakHashMap weakHashMap = S.f954a;
            J.l(viewGroup);
        }
        c0129q.f1026d = z3;
    }

    public void setOnChildScrollUpCallback(i iVar) {
        this.mChildScrollUpCallback = iVar;
    }

    public void setOnRefreshListener(j jVar) {
        this.mListener = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.mCircleView.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getContext().getColor(i));
    }

    public void setProgressViewEndTarget(boolean z3, int i) {
        this.mSpinnerOffsetEnd = i;
        this.mScale = z3;
        this.mCircleView.invalidate();
    }

    public void setProgressViewOffset(boolean z3, int i, int i3) {
        this.mScale = z3;
        this.mOriginalOffsetTop = i;
        this.mSpinnerOffsetEnd = i3;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public void setRefreshing(boolean z3) {
        int i;
        if (z3 && this.mRefreshing != z3) {
            this.mRefreshing = z3;
            if (!this.mUsingCustomStart) {
                i = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
            } else {
                i = this.mSpinnerOffsetEnd;
            }
            setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop);
            this.mNotify = false;
            Animation.AnimationListener animationListener = this.mRefreshListener;
            this.mCircleView.setVisibility(0);
            this.mProgress.setAlpha(MAX_ALPHA);
            h hVar = new h(this, 2);
            this.mScaleAnimation = hVar;
            hVar.setDuration(this.mMediumAnimationDuration);
            if (animationListener != null) {
                this.mCircleView.f3740a = animationListener;
            }
            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(this.mScaleAnimation);
            return;
        }
        d(z3, false);
    }

    public void setSize(int i) {
        if (i != 0 && i != 1) {
            return;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (i == 0) {
            this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
        } else {
            this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        }
        this.mCircleView.setImageDrawable(null);
        this.mProgress.c(i);
        this.mCircleView.setImageDrawable(this.mProgress);
    }

    public void setSlingshotDistance(int i) {
        this.mCustomSlingshotDistance = i;
    }

    public void setTargetOffsetTopAndBottom(int i) {
        this.mCircleView.bringToFront();
        a aVar = this.mCircleView;
        WeakHashMap weakHashMap = S.f954a;
        aVar.offsetTopAndBottom(i);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    public boolean startNestedScroll(int i, int i3) {
        return i3 == 0 && startNestedScroll(i);
    }

    public void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        h hVar = new h(this, 3);
        this.mScaleDownAnimation = hVar;
        hVar.setDuration(150L);
        a aVar = this.mCircleView;
        aVar.f3740a = animationListener;
        aVar.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    public void stopNestedScroll(int i) {
        if (i == 0) {
            stopNestedScroll();
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i3, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.c(i, i3, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.f(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i3, int[] iArr) {
        if (i3 > 0) {
            float f4 = this.mTotalUnconsumed;
            if (f4 > 0.0f) {
                float f5 = i3;
                if (f5 > f4) {
                    iArr[1] = (int) f4;
                    this.mTotalUnconsumed = 0.0f;
                } else {
                    this.mTotalUnconsumed = f4 - f5;
                    iArr[1] = i3;
                }
                c(this.mTotalUnconsumed);
            }
        }
        if (this.mUsingCustomStart && i3 > 0 && this.mTotalUnconsumed == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i - iArr[0], i3 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedScrollingParentHelper.f1031a = i;
        startNestedScroll(i & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.mReturningToStart || this.mRefreshing || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.f1031a = 0;
        this.mNestedScrollInProgress = false;
        float f4 = this.mTotalUnconsumed;
        if (f4 > 0.0f) {
            b(f4);
            this.mTotalUnconsumed = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.mNestedScrollingChildHelper.g(i, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.h(0);
    }

    public boolean dispatchNestedScroll(int i, int i3, int i4, int i5, int[] iArr, int i6) {
        return i6 == 0 && this.mNestedScrollingChildHelper.d(i, i3, i4, i5, iArr, i6, null);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i3, int i4, int i5, int[] iArr) {
        return this.mNestedScrollingChildHelper.d(i, i3, i4, i5, iArr, 0, null);
    }

    @Override // J.r
    public void onNestedScroll(View view, int i, int i3, int i4, int i5, int i6) {
        onNestedScroll(view, i, i3, i4, i5, i6, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i3, int i4, int i5) {
        onNestedScroll(view, i, i3, i4, i5, 0, this.mNestedScrollingV2ConsumedCompat);
    }
}
