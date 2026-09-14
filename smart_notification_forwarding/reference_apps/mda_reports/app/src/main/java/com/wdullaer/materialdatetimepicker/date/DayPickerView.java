package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.wdullaer.materialdatetimepicker.GravitySnapHelper;
import com.wdullaer.materialdatetimepicker.Utils;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.date.MonthAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class DayPickerView extends RecyclerView implements DatePickerDialog.OnDateChangedListener {
    private static final String TAG = "MonthFragment";
    protected MonthAdapter.CalendarDay L;
    protected MonthAdapter M;
    protected MonthAdapter.CalendarDay N;
    private DatePickerController mController;
    private OnPageListener pageListener;

    /* loaded from: classes2.dex */
    public interface OnPageListener {
        void onPageChanged(int i);
    }

    public DayPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, Build.VERSION.SDK_INT < 23 ? DatePickerDialog.ScrollOrientation.VERTICAL : DatePickerDialog.ScrollOrientation.HORIZONTAL);
    }

    public DayPickerView(Context context, DatePickerController datePickerController) {
        super(context);
        init(context, datePickerController.getScrollOrientation());
        setController(datePickerController);
    }

    private MonthAdapter.CalendarDay findAccessibilityFocus() {
        MonthView monthView;
        MonthAdapter.CalendarDay accessibilityFocus;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof MonthView) && (accessibilityFocus = (monthView = (MonthView) childAt).getAccessibilityFocus()) != null) {
                if (Build.VERSION.SDK_INT == 17) {
                    monthView.clearAccessibilityFocus();
                }
                return accessibilityFocus;
            }
        }
        return null;
    }

    private static String getMonthAndYearString(int i, int i2, Locale locale) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2, i);
        calendar.set(1, i2);
        return new SimpleDateFormat("MMMM yyyy", locale).format(calendar.getTime());
    }

    private boolean restoreAccessibilityFocus(MonthAdapter.CalendarDay calendarDay) {
        if (calendarDay == null) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof MonthView) && ((MonthView) childAt).restoreAccessibilityFocus(calendarDay)) {
                return true;
            }
        }
        return false;
    }

    public /* synthetic */ void c(int i) {
        ((LinearLayoutManager) getLayoutManager()).scrollToPositionWithOffset(i, 0);
        restoreAccessibilityFocus(this.L);
        OnPageListener onPageListener = this.pageListener;
        if (onPageListener != null) {
            onPageListener.onPageChanged(i);
        }
    }

    public abstract MonthAdapter createMonthAdapter(DatePickerController datePickerController);

    public /* synthetic */ void d(int i) {
        OnPageListener onPageListener = this.pageListener;
        if (onPageListener != null) {
            onPageListener.onPageChanged(i);
        }
    }

    public int getCount() {
        return this.M.getItemCount();
    }

    @Nullable
    public MonthView getMostVisibleMonth() {
        boolean z = this.mController.getScrollOrientation() == DatePickerDialog.ScrollOrientation.VERTICAL;
        int height = z ? getHeight() : getWidth();
        MonthView monthView = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < height) {
            View childAt = getChildAt(i2);
            if (childAt == null) {
                break;
            }
            int bottom = z ? childAt.getBottom() : childAt.getRight();
            int min = Math.min(bottom, height) - Math.max(0, z ? childAt.getTop() : childAt.getLeft());
            if (min > i3) {
                monthView = (MonthView) childAt;
                i3 = min;
            }
            i2++;
            i = bottom;
        }
        return monthView;
    }

    public int getMostVisiblePosition() {
        return getChildAdapterPosition(getMostVisibleMonth());
    }

    @Nullable
    public OnPageListener getOnPageListener() {
        return this.pageListener;
    }

    public boolean goTo(MonthAdapter.CalendarDay calendarDay, boolean z, boolean z2, boolean z3) {
        View childAt;
        if (z2) {
            this.L.set(calendarDay);
        }
        this.N.set(calendarDay);
        int minYear = (((calendarDay.a - this.mController.getMinYear()) * 12) + calendarDay.b) - this.mController.getStartDate().get(2);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            childAt = getChildAt(i);
            if (childAt == null) {
                break;
            }
            int top = childAt.getTop();
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("child at ");
                sb.append(i2 - 1);
                sb.append(" has top ");
                sb.append(top);
                Log.d(TAG, sb.toString());
            }
            if (top >= 0) {
                break;
            }
            i = i2;
        }
        int childAdapterPosition = childAt != null ? getChildAdapterPosition(childAt) : 0;
        if (z2) {
            this.M.setSelectedDay(this.L);
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "GoTo position " + minYear);
        }
        if (minYear != childAdapterPosition || z3) {
            setMonthDisplayed(this.N);
            if (z) {
                smoothScrollToPosition(minYear);
                OnPageListener onPageListener = this.pageListener;
                if (onPageListener == null) {
                    return true;
                }
                onPageListener.onPageChanged(minYear);
                return true;
            }
            postSetSelection(minYear);
        } else if (z2) {
            setMonthDisplayed(this.L);
        }
        return false;
    }

    public void init(Context context, DatePickerDialog.ScrollOrientation scrollOrientation) {
        setLayoutManager(new LinearLayoutManager(context, scrollOrientation == DatePickerDialog.ScrollOrientation.VERTICAL ? 1 : 0, false));
        setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setClipChildren(false);
        setUpRecyclerView(scrollOrientation);
    }

    public void onChange() {
        w();
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateChangedListener
    public void onDateChanged() {
        goTo(this.mController.getSelectedDay(), false, true, true);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setItemCount(-1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        restoreAccessibilityFocus(findAccessibilityFocus());
    }

    public void postSetSelection(final int i) {
        clearFocus();
        post(new Runnable() { // from class: com.wdullaer.materialdatetimepicker.date.d
            @Override // java.lang.Runnable
            public final void run() {
                DayPickerView.this.c(i);
            }
        });
    }

    protected void setController(DatePickerController datePickerController) {
        this.mController = datePickerController;
        this.mController.registerOnDateChangedListener(this);
        this.L = new MonthAdapter.CalendarDay(this.mController.getTimeZone());
        this.N = new MonthAdapter.CalendarDay(this.mController.getTimeZone());
        w();
    }

    protected void setMonthDisplayed(MonthAdapter.CalendarDay calendarDay) {
        int i = calendarDay.b;
    }

    public void setOnPageListener(@Nullable OnPageListener onPageListener) {
        this.pageListener = onPageListener;
    }

    protected void setUpRecyclerView(DatePickerDialog.ScrollOrientation scrollOrientation) {
        setVerticalScrollBarEnabled(false);
        setFadingEdgeLength(0);
        new GravitySnapHelper(scrollOrientation == DatePickerDialog.ScrollOrientation.VERTICAL ? 48 : GravityCompat.START, new GravitySnapHelper.SnapListener() { // from class: com.wdullaer.materialdatetimepicker.date.c
            @Override // com.wdullaer.materialdatetimepicker.GravitySnapHelper.SnapListener
            public final void onSnap(int i) {
                DayPickerView.this.d(i);
            }
        }).attachToRecyclerView(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        MonthView mostVisibleMonth = getMostVisibleMonth();
        if (mostVisibleMonth != null) {
            Utils.tryAccessibilityAnnounce(this, getMonthAndYearString(mostVisibleMonth.g, mostVisibleMonth.h, this.mController.getLocale()));
        } else {
            Log.w("DayPickerView", "Tried to announce before layout was initialized");
        }
    }

    protected void w() {
        MonthAdapter monthAdapter = this.M;
        if (monthAdapter == null) {
            this.M = createMonthAdapter(this.mController);
        } else {
            monthAdapter.setSelectedDay(this.L);
            OnPageListener onPageListener = this.pageListener;
            if (onPageListener != null) {
                onPageListener.onPageChanged(getMostVisiblePosition());
            }
        }
        setAdapter(this.M);
    }
}
