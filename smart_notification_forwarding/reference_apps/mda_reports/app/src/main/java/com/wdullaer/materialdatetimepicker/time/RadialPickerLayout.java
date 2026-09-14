package com.wdullaer.materialdatetimepicker.time;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.wdullaer.materialdatetimepicker.R;
import com.wdullaer.materialdatetimepicker.time.RadialTextsView;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import com.wdullaer.materialdatetimepicker.time.Timepoint;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes2.dex */
public class RadialPickerLayout extends FrameLayout implements View.OnTouchListener {
    private static final int AM = 0;
    private static final int HOUR_INDEX = 0;
    private static final int HOUR_VALUE_TO_DEGREES_STEP_SIZE = 30;
    private static final int MINUTE_INDEX = 1;
    private static final int MINUTE_VALUE_TO_DEGREES_STEP_SIZE = 6;
    private static final int PM = 1;
    private static final int SECOND_INDEX = 2;
    private static final int SECOND_VALUE_TO_DEGREES_STEP_SIZE = 6;
    private static final String TAG = "RadialPickerLayout";
    private static final int VISIBLE_DEGREES_STEP_SIZE = 30;
    private final int TAP_TIMEOUT;
    private final int TOUCH_SLOP;
    private AccessibilityManager mAccessibilityManager;
    private AmPmCirclesView mAmPmCirclesView;
    private CircleView mCircleView;
    private TimePickerController mController;
    private int mCurrentItemShowing;
    private Timepoint mCurrentTime;
    private boolean mDoingMove;
    private boolean mDoingTouch;
    private int mDownDegrees;
    private float mDownX;
    private float mDownY;
    private View mGrayBox;
    private Handler mHandler;
    private RadialSelectorView mHourRadialSelectorView;
    private RadialTextsView mHourRadialTextsView;
    private boolean mInputEnabled;
    private boolean mIs24HourMode;
    private int mIsTouchingAmOrPm;
    private Timepoint mLastValueSelected;
    private OnValueSelectedListener mListener;
    private RadialSelectorView mMinuteRadialSelectorView;
    private RadialTextsView mMinuteRadialTextsView;
    private RadialSelectorView mSecondRadialSelectorView;
    private RadialTextsView mSecondRadialTextsView;
    private int[] mSnapPrefer30sMap;
    private boolean mTimeInitialized;
    private AnimatorSet mTransition;

    /* loaded from: classes2.dex */
    public interface OnValueSelectedListener {
        void advancePicker(int i);

        void enablePicker();

        void onValueSelected(Timepoint timepoint);
    }

    public RadialPickerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsTouchingAmOrPm = -1;
        this.mHandler = new Handler();
        setOnTouchListener(this);
        this.TOUCH_SLOP = ViewConfiguration.get(context).getScaledTouchSlop();
        this.TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        this.mDoingMove = false;
        this.mCircleView = new CircleView(context);
        addView(this.mCircleView);
        this.mAmPmCirclesView = new AmPmCirclesView(context);
        addView(this.mAmPmCirclesView);
        this.mHourRadialSelectorView = new RadialSelectorView(context);
        addView(this.mHourRadialSelectorView);
        this.mMinuteRadialSelectorView = new RadialSelectorView(context);
        addView(this.mMinuteRadialSelectorView);
        this.mSecondRadialSelectorView = new RadialSelectorView(context);
        addView(this.mSecondRadialSelectorView);
        this.mHourRadialTextsView = new RadialTextsView(context);
        addView(this.mHourRadialTextsView);
        this.mMinuteRadialTextsView = new RadialTextsView(context);
        addView(this.mMinuteRadialTextsView);
        this.mSecondRadialTextsView = new RadialTextsView(context);
        addView(this.mSecondRadialTextsView);
        preparePrefer30sMap();
        this.mLastValueSelected = null;
        this.mInputEnabled = true;
        this.mGrayBox = new View(context);
        this.mGrayBox.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mGrayBox.setBackgroundColor(ContextCompat.getColor(context, R.color.mdtp_transparent_black));
        this.mGrayBox.setVisibility(4);
        addView(this.mGrayBox);
        this.mAccessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        this.mTimeInitialized = false;
    }

    private int getCurrentlyShowingValue() {
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            return this.mCurrentTime.getHour();
        }
        if (currentItemShowing == 1) {
            return this.mCurrentTime.getMinute();
        }
        if (currentItemShowing != 2) {
            return -1;
        }
        return this.mCurrentTime.getSecond();
    }

    private int getDegreesFromCoords(float f, float f2, boolean z, Boolean[] boolArr) {
        RadialSelectorView radialSelectorView;
        int currentItemShowing = getCurrentItemShowing();
        if (currentItemShowing == 0) {
            radialSelectorView = this.mHourRadialSelectorView;
        } else if (currentItemShowing == 1) {
            radialSelectorView = this.mMinuteRadialSelectorView;
        } else {
            if (currentItemShowing != 2) {
                return -1;
            }
            radialSelectorView = this.mSecondRadialSelectorView;
        }
        return radialSelectorView.getDegreesFromCoords(f, f2, z, boolArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0035, code lost:
    
        if (r8 == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0038, code lost:
    
        if (r7 == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0041, code lost:
    
        if (r0 == 2) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.wdullaer.materialdatetimepicker.time.Timepoint getTimeFromDegrees(int r7, boolean r8, boolean r9) {
        /*
            r6 = this;
            r0 = -1
            if (r7 != r0) goto L5
            r7 = 0
            return r7
        L5:
            int r0 = r6.getCurrentItemShowing()
            r1 = 2
            r2 = 0
            r3 = 1
            if (r9 != 0) goto L14
            if (r0 == r3) goto L12
            if (r0 != r1) goto L14
        L12:
            r9 = 1
            goto L15
        L14:
            r9 = 0
        L15:
            if (r9 == 0) goto L1c
            int r7 = r6.snapPrefer30s(r7)
            goto L20
        L1c:
            int r7 = snapOnly30s(r7, r2)
        L20:
            r9 = 6
            if (r0 == 0) goto L24
            goto L26
        L24:
            r9 = 30
        L26:
            r4 = 360(0x168, float:5.04E-43)
            if (r0 != 0) goto L3d
            boolean r5 = r6.mIs24HourMode
            if (r5 == 0) goto L38
            if (r7 != 0) goto L33
            if (r8 == 0) goto L33
            goto L3a
        L33:
            if (r7 != r4) goto L44
            if (r8 != 0) goto L44
            goto L43
        L38:
            if (r7 != 0) goto L44
        L3a:
            r7 = 360(0x168, float:5.04E-43)
            goto L44
        L3d:
            if (r7 != r4) goto L44
            if (r0 == r3) goto L43
            if (r0 != r1) goto L44
        L43:
            r7 = 0
        L44:
            int r9 = r7 / r9
            if (r0 != 0) goto L52
            boolean r5 = r6.mIs24HourMode
            if (r5 == 0) goto L52
            if (r8 != 0) goto L52
            if (r7 == 0) goto L52
            int r9 = r9 + 12
        L52:
            if (r0 != 0) goto L66
            com.wdullaer.materialdatetimepicker.time.TimePickerController r8 = r6.mController
            com.wdullaer.materialdatetimepicker.time.TimePickerDialog$Version r8 = r8.getVersion()
            com.wdullaer.materialdatetimepicker.time.TimePickerDialog$Version r5 = com.wdullaer.materialdatetimepicker.time.TimePickerDialog.Version.VERSION_1
            if (r8 == r5) goto L66
            boolean r8 = r6.mIs24HourMode
            if (r8 == 0) goto L66
            int r9 = r9 + 12
            int r9 = r9 % 24
        L66:
            if (r0 == 0) goto L93
            if (r0 == r3) goto L81
            if (r0 == r1) goto L6f
            com.wdullaer.materialdatetimepicker.time.Timepoint r7 = r6.mCurrentTime
            goto Lbf
        L6f:
            com.wdullaer.materialdatetimepicker.time.Timepoint r7 = new com.wdullaer.materialdatetimepicker.time.Timepoint
            com.wdullaer.materialdatetimepicker.time.Timepoint r8 = r6.mCurrentTime
            int r8 = r8.getHour()
            com.wdullaer.materialdatetimepicker.time.Timepoint r0 = r6.mCurrentTime
            int r0 = r0.getMinute()
            r7.<init>(r8, r0, r9)
            goto Lbf
        L81:
            com.wdullaer.materialdatetimepicker.time.Timepoint r7 = new com.wdullaer.materialdatetimepicker.time.Timepoint
            com.wdullaer.materialdatetimepicker.time.Timepoint r8 = r6.mCurrentTime
            int r8 = r8.getHour()
            com.wdullaer.materialdatetimepicker.time.Timepoint r0 = r6.mCurrentTime
            int r0 = r0.getSecond()
            r7.<init>(r8, r9, r0)
            goto Lbf
        L93:
            boolean r8 = r6.mIs24HourMode
            if (r8 != 0) goto La1
            int r8 = r6.getIsCurrentlyAmOrPm()
            if (r8 != r3) goto La1
            if (r7 == r4) goto La1
            int r9 = r9 + 12
        La1:
            boolean r8 = r6.mIs24HourMode
            if (r8 != 0) goto Lae
            int r8 = r6.getIsCurrentlyAmOrPm()
            if (r8 != 0) goto Lae
            if (r7 != r4) goto Lae
            r9 = 0
        Lae:
            com.wdullaer.materialdatetimepicker.time.Timepoint r7 = new com.wdullaer.materialdatetimepicker.time.Timepoint
            com.wdullaer.materialdatetimepicker.time.Timepoint r8 = r6.mCurrentTime
            int r8 = r8.getMinute()
            com.wdullaer.materialdatetimepicker.time.Timepoint r0 = r6.mCurrentTime
            int r0 = r0.getSecond()
            r7.<init>(r9, r8, r0)
        Lbf:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wdullaer.materialdatetimepicker.time.RadialPickerLayout.getTimeFromDegrees(int, boolean, boolean):com.wdullaer.materialdatetimepicker.time.Timepoint");
    }

    private boolean isHourInnerCircle(int i) {
        boolean z = i <= 12 && i != 0;
        if (this.mController.getVersion() != TimePickerDialog.Version.VERSION_1) {
            z = !z;
        }
        return this.mIs24HourMode && z;
    }

    private void preparePrefer30sMap() {
        this.mSnapPrefer30sMap = new int[361];
        int i = 0;
        int i2 = 1;
        int i3 = 8;
        for (int i4 = 0; i4 < 361; i4++) {
            this.mSnapPrefer30sMap[i4] = i;
            if (i2 == i3) {
                i += 6;
                i3 = i == 360 ? 7 : i % 30 == 0 ? 14 : 4;
                i2 = 1;
            } else {
                i2++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (r7.getSecond() != r6.mCurrentTime.getSecond()) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0091, code lost:
    
        if (r7.getSecond() != r6.mCurrentTime.getSecond()) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0007, code lost:
    
        if (r9 != 2) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
    
        r6.mSecondRadialSelectorView.setSelection(r7.getSecond() * 6, r2, r8);
        r6.mSecondRadialTextsView.setSelection(r7.getSecond());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void reselectSelector(com.wdullaer.materialdatetimepicker.time.Timepoint r7, boolean r8, int r9) {
        /*
            r6 = this;
            r0 = 2
            r1 = 1
            if (r9 == 0) goto L42
            r2 = 0
            if (r9 == r1) goto L21
            if (r9 == r0) goto Lb
            goto L95
        Lb:
            int r9 = r7.getSecond()
            int r9 = r9 * 6
            com.wdullaer.materialdatetimepicker.time.RadialSelectorView r3 = r6.mSecondRadialSelectorView
            r3.setSelection(r9, r2, r8)
            com.wdullaer.materialdatetimepicker.time.RadialTextsView r8 = r6.mSecondRadialTextsView
            int r7 = r7.getSecond()
            r8.setSelection(r7)
            goto L95
        L21:
            int r9 = r7.getMinute()
            int r9 = r9 * 6
            com.wdullaer.materialdatetimepicker.time.RadialSelectorView r3 = r6.mMinuteRadialSelectorView
            r3.setSelection(r9, r2, r8)
            com.wdullaer.materialdatetimepicker.time.RadialTextsView r9 = r6.mMinuteRadialTextsView
            int r3 = r7.getMinute()
            r9.setSelection(r3)
            int r9 = r7.getSecond()
            com.wdullaer.materialdatetimepicker.time.Timepoint r3 = r6.mCurrentTime
            int r3 = r3.getSecond()
            if (r9 == r3) goto L95
            goto Lb
        L42:
            int r9 = r7.getHour()
            boolean r2 = r6.isHourInnerCircle(r9)
            int r3 = r9 % 12
            int r4 = r3 * 360
            int r4 = r4 / 12
            boolean r5 = r6.mIs24HourMode
            if (r5 != 0) goto L55
            r9 = r3
        L55:
            boolean r3 = r6.mIs24HourMode
            if (r3 != 0) goto L5d
            if (r9 != 0) goto L5d
            int r9 = r9 + 12
        L5d:
            com.wdullaer.materialdatetimepicker.time.RadialSelectorView r3 = r6.mHourRadialSelectorView
            r3.setSelection(r4, r2, r8)
            com.wdullaer.materialdatetimepicker.time.RadialTextsView r3 = r6.mHourRadialTextsView
            r3.setSelection(r9)
            int r9 = r7.getMinute()
            com.wdullaer.materialdatetimepicker.time.Timepoint r3 = r6.mCurrentTime
            int r3 = r3.getMinute()
            if (r9 == r3) goto L87
            int r9 = r7.getMinute()
            int r9 = r9 * 6
            com.wdullaer.materialdatetimepicker.time.RadialSelectorView r3 = r6.mMinuteRadialSelectorView
            r3.setSelection(r9, r2, r8)
            com.wdullaer.materialdatetimepicker.time.RadialTextsView r9 = r6.mMinuteRadialTextsView
            int r3 = r7.getMinute()
            r9.setSelection(r3)
        L87:
            int r9 = r7.getSecond()
            com.wdullaer.materialdatetimepicker.time.Timepoint r3 = r6.mCurrentTime
            int r3 = r3.getSecond()
            if (r9 == r3) goto L95
            goto Lb
        L95:
            int r7 = r6.getCurrentItemShowing()
            if (r7 == 0) goto Lb0
            if (r7 == r1) goto La8
            if (r7 == r0) goto La0
            goto Lba
        La0:
            com.wdullaer.materialdatetimepicker.time.RadialSelectorView r7 = r6.mSecondRadialSelectorView
            r7.invalidate()
            com.wdullaer.materialdatetimepicker.time.RadialTextsView r7 = r6.mSecondRadialTextsView
            goto Lb7
        La8:
            com.wdullaer.materialdatetimepicker.time.RadialSelectorView r7 = r6.mMinuteRadialSelectorView
            r7.invalidate()
            com.wdullaer.materialdatetimepicker.time.RadialTextsView r7 = r6.mMinuteRadialTextsView
            goto Lb7
        Lb0:
            com.wdullaer.materialdatetimepicker.time.RadialSelectorView r7 = r6.mHourRadialSelectorView
            r7.invalidate()
            com.wdullaer.materialdatetimepicker.time.RadialTextsView r7 = r6.mHourRadialTextsView
        Lb7:
            r7.invalidate()
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wdullaer.materialdatetimepicker.time.RadialPickerLayout.reselectSelector(com.wdullaer.materialdatetimepicker.time.Timepoint, boolean, int):void");
    }

    private Timepoint roundToValidTime(Timepoint timepoint, int i) {
        TimePickerController timePickerController;
        Timepoint.TYPE type;
        if (i == 0) {
            timePickerController = this.mController;
            type = null;
        } else if (i != 1) {
            timePickerController = this.mController;
            type = Timepoint.TYPE.MINUTE;
        } else {
            timePickerController = this.mController;
            type = Timepoint.TYPE.HOUR;
        }
        return timePickerController.roundToNearest(timepoint, type);
    }

    private void setItem(int i, Timepoint timepoint) {
        Timepoint roundToValidTime = roundToValidTime(timepoint, i);
        this.mCurrentTime = roundToValidTime;
        reselectSelector(roundToValidTime, false, i);
    }

    private static int snapOnly30s(int i, int i2) {
        int i3 = (i / 30) * 30;
        int i4 = i3 + 30;
        if (i2 != 1) {
            if (i2 == -1) {
                return i == i3 ? i3 - 30 : i3;
            }
            if (i - i3 < i4 - i) {
                return i3;
            }
        }
        return i4;
    }

    private int snapPrefer30s(int i) {
        int[] iArr = this.mSnapPrefer30sMap;
        if (iArr == null) {
            return -1;
        }
        return iArr[i];
    }

    private void transitionWithoutAnimation(int i) {
        int i2 = i == 0 ? 1 : 0;
        int i3 = i == 1 ? 1 : 0;
        int i4 = i == 2 ? 1 : 0;
        float f = i2;
        this.mHourRadialTextsView.setAlpha(f);
        this.mHourRadialSelectorView.setAlpha(f);
        float f2 = i3;
        this.mMinuteRadialTextsView.setAlpha(f2);
        this.mMinuteRadialSelectorView.setAlpha(f2);
        float f3 = i4;
        this.mSecondRadialTextsView.setAlpha(f3);
        this.mSecondRadialSelectorView.setAlpha(f3);
    }

    public /* synthetic */ void a() {
        this.mAmPmCirclesView.setAmOrPmPressed(this.mIsTouchingAmOrPm);
        this.mAmPmCirclesView.invalidate();
    }

    public /* synthetic */ void a(Boolean[] boolArr) {
        this.mDoingMove = true;
        this.mLastValueSelected = getTimeFromDegrees(this.mDownDegrees, boolArr[0].booleanValue(), false);
        this.mLastValueSelected = roundToValidTime(this.mLastValueSelected, getCurrentItemShowing());
        reselectSelector(this.mLastValueSelected, true, getCurrentItemShowing());
        this.mListener.onValueSelected(this.mLastValueSelected);
    }

    public /* synthetic */ boolean a(int i) {
        return !this.mController.isOutOfRange(new Timepoint(this.mCurrentTime.getHour(), this.mCurrentTime.getMinute(), i), 2);
    }

    public /* synthetic */ boolean b(int i) {
        return !this.mController.isOutOfRange(new Timepoint(this.mCurrentTime.getHour(), i, this.mCurrentTime.getSecond()), 1);
    }

    public /* synthetic */ boolean c(int i) {
        Timepoint timepoint = new Timepoint(i, this.mCurrentTime.getMinute(), this.mCurrentTime.getSecond());
        if (!this.mIs24HourMode && getIsCurrentlyAmOrPm() == 1) {
            timepoint.setPM();
        }
        if (!this.mIs24HourMode && getIsCurrentlyAmOrPm() == 0) {
            timepoint.setAM();
        }
        return !this.mController.isOutOfRange(timepoint, 0);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        accessibilityEvent.getText().clear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(10, getHours());
        calendar.set(12, getMinutes());
        calendar.set(13, getSeconds());
        accessibilityEvent.getText().add(DateUtils.formatDateTime(getContext(), calendar.getTimeInMillis(), this.mIs24HourMode ? 129 : 1));
        return true;
    }

    public int getCurrentItemShowing() {
        int i = this.mCurrentItemShowing;
        if (i == 0 || i == 1 || i == 2) {
            return this.mCurrentItemShowing;
        }
        Log.e(TAG, "Current item showing was unfortunately set to " + this.mCurrentItemShowing);
        return -1;
    }

    public int getHours() {
        return this.mCurrentTime.getHour();
    }

    public int getIsCurrentlyAmOrPm() {
        if (this.mCurrentTime.isAM()) {
            return 0;
        }
        return this.mCurrentTime.isPM() ? 1 : -1;
    }

    public int getMinutes() {
        return this.mCurrentTime.getMinute();
    }

    public int getSeconds() {
        return this.mCurrentTime.getSecond();
    }

    public Timepoint getTime() {
        return this.mCurrentTime;
    }

    public void initialize(Context context, Locale locale, TimePickerController timePickerController, Timepoint timepoint, boolean z) {
        char c;
        String format;
        if (this.mTimeInitialized) {
            Log.e(TAG, "Time has already been initialized.");
            return;
        }
        this.mController = timePickerController;
        this.mIs24HourMode = this.mAccessibilityManager.isTouchExplorationEnabled() || z;
        this.mCircleView.initialize(context, this.mController);
        this.mCircleView.invalidate();
        if (!this.mIs24HourMode && this.mController.getVersion() == TimePickerDialog.Version.VERSION_1) {
            this.mAmPmCirclesView.initialize(context, locale, this.mController, !timepoint.isAM() ? 1 : 0);
            this.mAmPmCirclesView.invalidate();
        }
        RadialTextsView.SelectionValidator selectionValidator = new RadialTextsView.SelectionValidator() { // from class: com.wdullaer.materialdatetimepicker.time.b
            @Override // com.wdullaer.materialdatetimepicker.time.RadialTextsView.SelectionValidator
            public final boolean isValidSelection(int i) {
                return RadialPickerLayout.this.a(i);
            }
        };
        RadialTextsView.SelectionValidator selectionValidator2 = new RadialTextsView.SelectionValidator() { // from class: com.wdullaer.materialdatetimepicker.time.c
            @Override // com.wdullaer.materialdatetimepicker.time.RadialTextsView.SelectionValidator
            public final boolean isValidSelection(int i) {
                return RadialPickerLayout.this.b(i);
            }
        };
        RadialTextsView.SelectionValidator selectionValidator3 = new RadialTextsView.SelectionValidator() { // from class: com.wdullaer.materialdatetimepicker.time.a
            @Override // com.wdullaer.materialdatetimepicker.time.RadialTextsView.SelectionValidator
            public final boolean isValidSelection(int i) {
                return RadialPickerLayout.this.c(i);
            }
        };
        int[] iArr = {12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] iArr2 = {0, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
        int[] iArr3 = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55};
        int[] iArr4 = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55};
        String[] strArr = new String[12];
        String[] strArr2 = new String[12];
        String[] strArr3 = new String[12];
        String[] strArr4 = new String[12];
        int i = 0;
        for (int i2 = 12; i < i2; i2 = 12) {
            RadialTextsView.SelectionValidator selectionValidator4 = selectionValidator;
            RadialTextsView.SelectionValidator selectionValidator5 = selectionValidator2;
            if (z) {
                c = 0;
                format = String.format(locale, "%02d", Integer.valueOf(iArr2[i]));
            } else {
                c = 0;
                format = String.format(locale, "%d", Integer.valueOf(iArr[i]));
            }
            strArr[i] = format;
            Object[] objArr = new Object[1];
            objArr[c] = Integer.valueOf(iArr[i]);
            strArr2[i] = String.format(locale, "%d", objArr);
            Object[] objArr2 = new Object[1];
            objArr2[c] = Integer.valueOf(iArr3[i]);
            strArr3[i] = String.format(locale, "%02d", objArr2);
            Object[] objArr3 = new Object[1];
            objArr3[c] = Integer.valueOf(iArr4[i]);
            strArr4[i] = String.format(locale, "%02d", objArr3);
            i++;
            selectionValidator = selectionValidator4;
            selectionValidator2 = selectionValidator5;
        }
        RadialTextsView.SelectionValidator selectionValidator6 = selectionValidator;
        RadialTextsView.SelectionValidator selectionValidator7 = selectionValidator2;
        if (this.mController.getVersion() != TimePickerDialog.Version.VERSION_2) {
            strArr2 = strArr;
            strArr = strArr2;
        }
        this.mHourRadialTextsView.initialize(context, strArr2, z ? strArr : null, this.mController, selectionValidator3, true);
        RadialTextsView radialTextsView = this.mHourRadialTextsView;
        int hour = timepoint.getHour();
        if (!z) {
            hour = iArr[hour % 12];
        }
        radialTextsView.setSelection(hour);
        this.mHourRadialTextsView.invalidate();
        this.mMinuteRadialTextsView.initialize(context, strArr3, null, this.mController, selectionValidator7, false);
        this.mMinuteRadialTextsView.setSelection(timepoint.getMinute());
        this.mMinuteRadialTextsView.invalidate();
        this.mSecondRadialTextsView.initialize(context, strArr4, null, this.mController, selectionValidator6, false);
        this.mSecondRadialTextsView.setSelection(timepoint.getSecond());
        this.mSecondRadialTextsView.invalidate();
        this.mCurrentTime = timepoint;
        this.mHourRadialSelectorView.initialize(context, this.mController, z, true, (timepoint.getHour() % 12) * 30, isHourInnerCircle(timepoint.getHour()));
        this.mMinuteRadialSelectorView.initialize(context, this.mController, false, false, timepoint.getMinute() * 6, false);
        this.mSecondRadialSelectorView.initialize(context, this.mController, false, false, timepoint.getSecond() * 6, false);
        this.mTimeInitialized = true;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        if (r11 <= r7) goto L66;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wdullaer.materialdatetimepicker.time.RadialPickerLayout.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        int i2;
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        int i3 = Build.VERSION.SDK_INT;
        int i4 = 0;
        int i5 = i == 4096 ? 1 : i == 8192 ? -1 : 0;
        if (i5 == 0) {
            return false;
        }
        int currentlyShowingValue = getCurrentlyShowingValue();
        int currentItemShowing = getCurrentItemShowing();
        int i6 = 6;
        if (currentItemShowing == 0) {
            i6 = 30;
            currentlyShowingValue %= 12;
        } else if (currentItemShowing != 1 && currentItemShowing != 2) {
            i6 = 0;
        }
        int snapOnly30s = snapOnly30s(currentlyShowingValue * i6, i5) / i6;
        if (currentItemShowing != 0) {
            i2 = 55;
        } else if (this.mIs24HourMode) {
            i2 = 23;
        } else {
            i2 = 12;
            i4 = 1;
        }
        if (snapOnly30s > i2) {
            snapOnly30s = i4;
        } else if (snapOnly30s < i4) {
            snapOnly30s = i2;
        }
        Timepoint timepoint = currentItemShowing != 0 ? currentItemShowing != 1 ? currentItemShowing != 2 ? this.mCurrentTime : new Timepoint(this.mCurrentTime.getHour(), this.mCurrentTime.getMinute(), snapOnly30s) : new Timepoint(this.mCurrentTime.getHour(), snapOnly30s, this.mCurrentTime.getSecond()) : new Timepoint(snapOnly30s, this.mCurrentTime.getMinute(), this.mCurrentTime.getSecond());
        setItem(currentItemShowing, timepoint);
        this.mListener.onValueSelected(timepoint);
        return true;
    }

    public void setAmOrPm(int i) {
        this.mAmPmCirclesView.setAmOrPm(i);
        this.mAmPmCirclesView.invalidate();
        Timepoint timepoint = new Timepoint(this.mCurrentTime);
        if (i == 0) {
            timepoint.setAM();
        } else if (i == 1) {
            timepoint.setPM();
        }
        Timepoint roundToValidTime = roundToValidTime(timepoint, 0);
        reselectSelector(roundToValidTime, false, 0);
        this.mCurrentTime = roundToValidTime;
        this.mListener.onValueSelected(roundToValidTime);
    }

    public void setCurrentItemShowing(int i, boolean z) {
        if (i != 0 && i != 1 && i != 2) {
            Log.e(TAG, "TimePicker does not support view at index " + i);
            return;
        }
        int currentItemShowing = getCurrentItemShowing();
        this.mCurrentItemShowing = i;
        reselectSelector(getTime(), true, i);
        if (z && i != currentItemShowing) {
            ObjectAnimator[] objectAnimatorArr = new ObjectAnimator[4];
            if (i == 1 && currentItemShowing == 0) {
                objectAnimatorArr[0] = this.mHourRadialTextsView.getDisappearAnimator();
                objectAnimatorArr[1] = this.mHourRadialSelectorView.getDisappearAnimator();
                objectAnimatorArr[2] = this.mMinuteRadialTextsView.getReappearAnimator();
                objectAnimatorArr[3] = this.mMinuteRadialSelectorView.getReappearAnimator();
            } else if (i == 0 && currentItemShowing == 1) {
                objectAnimatorArr[0] = this.mHourRadialTextsView.getReappearAnimator();
                objectAnimatorArr[1] = this.mHourRadialSelectorView.getReappearAnimator();
                objectAnimatorArr[2] = this.mMinuteRadialTextsView.getDisappearAnimator();
                objectAnimatorArr[3] = this.mMinuteRadialSelectorView.getDisappearAnimator();
            } else if (i == 1 && currentItemShowing == 2) {
                objectAnimatorArr[0] = this.mSecondRadialTextsView.getDisappearAnimator();
                objectAnimatorArr[1] = this.mSecondRadialSelectorView.getDisappearAnimator();
                objectAnimatorArr[2] = this.mMinuteRadialTextsView.getReappearAnimator();
                objectAnimatorArr[3] = this.mMinuteRadialSelectorView.getReappearAnimator();
            } else if (i == 0 && currentItemShowing == 2) {
                objectAnimatorArr[0] = this.mSecondRadialTextsView.getDisappearAnimator();
                objectAnimatorArr[1] = this.mSecondRadialSelectorView.getDisappearAnimator();
                objectAnimatorArr[2] = this.mHourRadialTextsView.getReappearAnimator();
                objectAnimatorArr[3] = this.mHourRadialSelectorView.getReappearAnimator();
            } else if (i == 2 && currentItemShowing == 1) {
                objectAnimatorArr[0] = this.mSecondRadialTextsView.getReappearAnimator();
                objectAnimatorArr[1] = this.mSecondRadialSelectorView.getReappearAnimator();
                objectAnimatorArr[2] = this.mMinuteRadialTextsView.getDisappearAnimator();
                objectAnimatorArr[3] = this.mMinuteRadialSelectorView.getDisappearAnimator();
            } else if (i == 2 && currentItemShowing == 0) {
                objectAnimatorArr[0] = this.mSecondRadialTextsView.getReappearAnimator();
                objectAnimatorArr[1] = this.mSecondRadialSelectorView.getReappearAnimator();
                objectAnimatorArr[2] = this.mHourRadialTextsView.getDisappearAnimator();
                objectAnimatorArr[3] = this.mHourRadialSelectorView.getDisappearAnimator();
            }
            if (objectAnimatorArr[0] != null && objectAnimatorArr[1] != null && objectAnimatorArr[2] != null && objectAnimatorArr[3] != null) {
                AnimatorSet animatorSet = this.mTransition;
                if (animatorSet != null && animatorSet.isRunning()) {
                    this.mTransition.end();
                }
                this.mTransition = new AnimatorSet();
                this.mTransition.playTogether(objectAnimatorArr);
                this.mTransition.start();
                return;
            }
        }
        transitionWithoutAnimation(i);
    }

    public void setOnValueSelectedListener(OnValueSelectedListener onValueSelectedListener) {
        this.mListener = onValueSelectedListener;
    }

    public void setTime(Timepoint timepoint) {
        setItem(0, timepoint);
    }

    public boolean trySettingInputEnabled(boolean z) {
        if (this.mDoingTouch && !z) {
            return false;
        }
        this.mInputEnabled = z;
        this.mGrayBox.setVisibility(z ? 4 : 0);
        return true;
    }
}
