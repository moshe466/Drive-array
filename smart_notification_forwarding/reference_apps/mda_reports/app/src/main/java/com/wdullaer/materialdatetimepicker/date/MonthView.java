package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import androidx.exifinterface.media.ExifInterface;
import com.wdullaer.materialdatetimepicker.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.date.MonthAdapter;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class MonthView extends View {
    protected static int A = 1;
    protected static int B = 0;
    protected static int C = 0;
    protected static int D = 0;
    protected static int E = 0;
    protected static int F = 0;
    protected static int G = 0;
    protected static int H = 0;
    protected static int I = 0;
    private static final int SELECTED_CIRCLE_ALPHA = 255;
    protected static int z = 32;
    protected DatePickerController a;
    protected int b;
    protected Paint c;
    protected Paint d;
    protected Paint e;
    protected Paint f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected boolean k;
    protected int l;
    protected int m;
    private final Calendar mCalendar;
    private int mDayOfWeekStart;
    private String mDayOfWeekTypeface;
    private boolean mLockAccessibilityDelegate;
    private String mMonthTitleTypeface;
    private final StringBuilder mStringBuilder;
    private final MonthViewTouchHelper mTouchHelper;
    protected int n;
    protected int o;
    protected int p;
    protected final Calendar q;
    protected int r;
    protected OnDayClickListener s;
    protected int t;
    protected int u;
    protected int v;
    protected int w;
    private SimpleDateFormat weekDayLabelFormatter;
    protected int x;
    protected int y;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class MonthViewTouchHelper extends ExploreByTouchHelper {
        private static final String DATE_FORMAT = "dd MMMM yyyy";
        private final Calendar mTempCalendar;
        private final Rect mTempRect;

        MonthViewTouchHelper(View view) {
            super(view);
            this.mTempRect = new Rect();
            this.mTempCalendar = Calendar.getInstance(MonthView.this.a.getTimeZone());
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int a(float f, float f2) {
            int dayFromLocation = MonthView.this.getDayFromLocation(f, f2);
            if (dayFromLocation >= 0) {
                return dayFromLocation;
            }
            return Integer.MIN_VALUE;
        }

        void a(int i, Rect rect) {
            MonthView monthView = MonthView.this;
            int i2 = monthView.b;
            int monthHeaderSize = monthView.getMonthHeaderSize();
            MonthView monthView2 = MonthView.this;
            int i3 = monthView2.j;
            int i4 = (monthView2.i - (monthView2.b * 2)) / monthView2.o;
            int a = (i - 1) + monthView2.a();
            int i5 = MonthView.this.o;
            int i6 = i2 + ((a % i5) * i4);
            int i7 = monthHeaderSize + ((a / i5) * i3);
            rect.set(i6, i7, i4 + i6, i3 + i7);
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void a(int i, @NonNull AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(b(i));
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void a(int i, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            a(i, this.mTempRect);
            accessibilityNodeInfoCompat.setContentDescription(b(i));
            accessibilityNodeInfoCompat.setBoundsInParent(this.mTempRect);
            accessibilityNodeInfoCompat.addAction(16);
            MonthView monthView = MonthView.this;
            accessibilityNodeInfoCompat.setEnabled(!monthView.a.isOutOfRange(monthView.h, monthView.g, i));
            if (i == MonthView.this.l) {
                accessibilityNodeInfoCompat.setSelected(true);
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void a(List<Integer> list) {
            for (int i = 1; i <= MonthView.this.p; i++) {
                list.add(Integer.valueOf(i));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean a(int i, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            MonthView.this.onDayClick(i);
            return true;
        }

        CharSequence b(int i) {
            Calendar calendar = this.mTempCalendar;
            MonthView monthView = MonthView.this;
            calendar.set(monthView.h, monthView.g, i);
            return DateFormat.format(DATE_FORMAT, this.mTempCalendar.getTimeInMillis());
        }

        void b() {
            int accessibilityFocusedVirtualViewId = getAccessibilityFocusedVirtualViewId();
            if (accessibilityFocusedVirtualViewId != Integer.MIN_VALUE) {
                getAccessibilityNodeProvider(MonthView.this).performAction(accessibilityFocusedVirtualViewId, 128, null);
            }
        }

        void c(int i) {
            getAccessibilityNodeProvider(MonthView.this).performAction(i, 64, null);
        }
    }

    /* loaded from: classes2.dex */
    public interface OnDayClickListener {
        void onDayClick(MonthView monthView, MonthAdapter.CalendarDay calendarDay);
    }

    public MonthView(Context context) {
        this(context, null, null);
    }

    public MonthView(Context context, AttributeSet attributeSet, DatePickerController datePickerController) {
        super(context, attributeSet);
        int i;
        int dimensionPixelOffset;
        int i2;
        this.b = 0;
        this.j = z;
        this.k = false;
        this.l = -1;
        this.m = -1;
        this.n = 1;
        this.o = 7;
        this.p = this.o;
        this.r = 6;
        this.mDayOfWeekStart = 0;
        this.a = datePickerController;
        Resources resources = context.getResources();
        this.q = Calendar.getInstance(this.a.getTimeZone(), this.a.getLocale());
        this.mCalendar = Calendar.getInstance(this.a.getTimeZone(), this.a.getLocale());
        this.mDayOfWeekTypeface = resources.getString(R.string.mdtp_day_of_week_label_typeface);
        this.mMonthTitleTypeface = resources.getString(R.string.mdtp_sans_serif);
        DatePickerController datePickerController2 = this.a;
        if (datePickerController2 != null && datePickerController2.isThemeDark()) {
            this.t = ContextCompat.getColor(context, R.color.mdtp_date_picker_text_normal_dark_theme);
            this.v = ContextCompat.getColor(context, R.color.mdtp_date_picker_month_day_dark_theme);
            this.y = ContextCompat.getColor(context, R.color.mdtp_date_picker_text_disabled_dark_theme);
            i = R.color.mdtp_date_picker_text_highlighted_dark_theme;
        } else {
            this.t = ContextCompat.getColor(context, R.color.mdtp_date_picker_text_normal);
            this.v = ContextCompat.getColor(context, R.color.mdtp_date_picker_month_day);
            this.y = ContextCompat.getColor(context, R.color.mdtp_date_picker_text_disabled);
            i = R.color.mdtp_date_picker_text_highlighted;
        }
        this.x = ContextCompat.getColor(context, i);
        this.u = ContextCompat.getColor(context, R.color.mdtp_white);
        this.w = this.a.getAccentColor();
        ContextCompat.getColor(context, R.color.mdtp_white);
        this.mStringBuilder = new StringBuilder(50);
        B = resources.getDimensionPixelSize(R.dimen.mdtp_day_number_size);
        C = resources.getDimensionPixelSize(R.dimen.mdtp_month_label_size);
        D = resources.getDimensionPixelSize(R.dimen.mdtp_month_day_label_text_size);
        E = resources.getDimensionPixelOffset(R.dimen.mdtp_month_list_item_header_height);
        F = resources.getDimensionPixelOffset(R.dimen.mdtp_month_list_item_header_height_v2);
        G = resources.getDimensionPixelSize(this.a.getVersion() == DatePickerDialog.Version.VERSION_1 ? R.dimen.mdtp_day_number_select_circle_radius : R.dimen.mdtp_day_number_select_circle_radius_v2);
        H = resources.getDimensionPixelSize(R.dimen.mdtp_day_highlight_circle_radius);
        I = resources.getDimensionPixelSize(R.dimen.mdtp_day_highlight_circle_margin);
        if (this.a.getVersion() == DatePickerDialog.Version.VERSION_1) {
            dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mdtp_date_picker_view_animator_height);
            i2 = getMonthHeaderSize();
        } else {
            dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mdtp_date_picker_view_animator_height_v2) - getMonthHeaderSize();
            i2 = D * 2;
        }
        this.j = (dimensionPixelOffset - i2) / 6;
        this.b = this.a.getVersion() != DatePickerDialog.Version.VERSION_1 ? context.getResources().getDimensionPixelSize(R.dimen.mdtp_date_picker_view_animator_padding_v2) : 0;
        this.mTouchHelper = getMonthViewTouchHelper();
        ViewCompat.setAccessibilityDelegate(this, this.mTouchHelper);
        ViewCompat.setImportantForAccessibility(this, 1);
        this.mLockAccessibilityDelegate = true;
        b();
    }

    private int calculateNumRows() {
        int a = a();
        int i = this.p;
        int i2 = this.o;
        return ((a + i) / i2) + ((a + i) % i2 > 0 ? 1 : 0);
    }

    @NonNull
    private String getMonthAndYearString() {
        Locale locale = this.a.getLocale();
        String string = Build.VERSION.SDK_INT < 18 ? getContext().getResources().getString(R.string.mdtp_date_v1_monthyear) : DateFormat.getBestDateTimePattern(locale, "MMMM yyyy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string, locale);
        simpleDateFormat.setTimeZone(this.a.getTimeZone());
        simpleDateFormat.applyLocalizedPattern(string);
        this.mStringBuilder.setLength(0);
        return simpleDateFormat.format(this.mCalendar.getTime());
    }

    private String getWeekDayLabel(Calendar calendar) {
        Locale locale = this.a.getLocale();
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.weekDayLabelFormatter == null) {
                this.weekDayLabelFormatter = new SimpleDateFormat("EEEEE", locale);
            }
            return this.weekDayLabelFormatter.format(calendar.getTime());
        }
        String format = new SimpleDateFormat(ExifInterface.LONGITUDE_EAST, locale).format(calendar.getTime());
        String substring = format.toUpperCase(locale).substring(0, 1);
        if (locale.equals(Locale.CHINA) || locale.equals(Locale.CHINESE) || locale.equals(Locale.SIMPLIFIED_CHINESE) || locale.equals(Locale.TRADITIONAL_CHINESE)) {
            int length = format.length();
            substring = format.substring(length - 1, length);
        }
        if (locale.getLanguage().equals("he") || locale.getLanguage().equals("iw")) {
            if (this.q.get(7) != 7) {
                int length2 = format.length();
                substring = format.substring(length2 - 2, length2 - 1);
            } else {
                substring = format.toUpperCase(locale).substring(0, 1);
            }
        }
        if (locale.getLanguage().equals("ca")) {
            substring = format.toLowerCase().substring(0, 2);
        }
        return (locale.getLanguage().equals("es") && calendar.get(7) == 4) ? "X" : substring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDayClick(int i) {
        if (this.a.isOutOfRange(this.h, this.g, i)) {
            return;
        }
        OnDayClickListener onDayClickListener = this.s;
        if (onDayClickListener != null) {
            onDayClickListener.onDayClick(this, new MonthAdapter.CalendarDay(this.h, this.g, i, this.a.getTimeZone()));
        }
        this.mTouchHelper.sendEventForVirtualView(i, 1);
    }

    private boolean sameDay(int i, Calendar calendar) {
        return this.h == calendar.get(1) && this.g == calendar.get(2) && i == calendar.get(5);
    }

    protected int a() {
        int i = this.mDayOfWeekStart;
        if (i < this.n) {
            i += this.o;
        }
        return i - this.n;
    }

    protected int a(float f, float f2) {
        float f3 = this.b;
        if (f < f3 || f > this.i - r0) {
            return -1;
        }
        return (((int) (((f - f3) * this.o) / ((this.i - r0) - this.b))) - a()) + 1 + ((((int) (f2 - getMonthHeaderSize())) / this.j) * this.o);
    }

    protected void a(Canvas canvas) {
        int monthHeaderSize = getMonthHeaderSize() - (D / 2);
        int i = (this.i - (this.b * 2)) / (this.o * 2);
        int i2 = 0;
        while (true) {
            int i3 = this.o;
            if (i2 >= i3) {
                return;
            }
            int i4 = (((i2 * 2) + 1) * i) + this.b;
            this.q.set(7, (this.n + i2) % i3);
            canvas.drawText(getWeekDayLabel(this.q), i4, monthHeaderSize, this.f);
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i, int i2, int i3) {
        return this.a.isHighlighted(i, i2, i3);
    }

    protected void b() {
        this.d = new Paint();
        if (this.a.getVersion() == DatePickerDialog.Version.VERSION_1) {
            this.d.setFakeBoldText(true);
        }
        this.d.setAntiAlias(true);
        this.d.setTextSize(C);
        this.d.setTypeface(Typeface.create(this.mMonthTitleTypeface, 1));
        this.d.setColor(this.t);
        this.d.setTextAlign(Paint.Align.CENTER);
        this.d.setStyle(Paint.Style.FILL);
        this.e = new Paint();
        this.e.setFakeBoldText(true);
        this.e.setAntiAlias(true);
        this.e.setColor(this.w);
        this.e.setTextAlign(Paint.Align.CENTER);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setAlpha(255);
        this.f = new Paint();
        this.f.setAntiAlias(true);
        this.f.setTextSize(D);
        this.f.setColor(this.v);
        this.d.setTypeface(Typeface.create(this.mDayOfWeekTypeface, 1));
        this.f.setStyle(Paint.Style.FILL);
        this.f.setTextAlign(Paint.Align.CENTER);
        this.f.setFakeBoldText(true);
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.c.setTextSize(B);
        this.c.setStyle(Paint.Style.FILL);
        this.c.setTextAlign(Paint.Align.CENTER);
        this.c.setFakeBoldText(false);
    }

    protected void b(Canvas canvas) {
        int monthHeaderSize = (((this.j + B) / 2) - A) + getMonthHeaderSize();
        int i = (this.i - (this.b * 2)) / (this.o * 2);
        int i2 = monthHeaderSize;
        int a = a();
        for (int i3 = 1; i3 <= this.p; i3++) {
            int i4 = (((a * 2) + 1) * i) + this.b;
            int i5 = this.j;
            int i6 = i2 - (((B + i5) / 2) - A);
            drawMonthDay(canvas, this.h, this.g, i3, i4, i2, i4 - i, i4 + i, i6, i6 + i5);
            a++;
            if (a == this.o) {
                i2 += this.j;
                a = 0;
            }
        }
    }

    protected void c(Canvas canvas) {
        canvas.drawText(getMonthAndYearString(), this.i / 2, this.a.getVersion() == DatePickerDialog.Version.VERSION_1 ? (getMonthHeaderSize() - D) / 2 : (getMonthHeaderSize() / 2) - D, this.d);
    }

    public void clearAccessibilityFocus() {
        this.mTouchHelper.b();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return this.mTouchHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public abstract void drawMonthDay(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);

    public MonthAdapter.CalendarDay getAccessibilityFocus() {
        int accessibilityFocusedVirtualViewId = this.mTouchHelper.getAccessibilityFocusedVirtualViewId();
        if (accessibilityFocusedVirtualViewId >= 0) {
            return new MonthAdapter.CalendarDay(this.h, this.g, accessibilityFocusedVirtualViewId, this.a.getTimeZone());
        }
        return null;
    }

    public int getCellWidth() {
        return (this.i - (this.b * 2)) / this.o;
    }

    public int getDayFromLocation(float f, float f2) {
        int a = a(f, f2);
        if (a < 1 || a > this.p) {
            return -1;
        }
        return a;
    }

    public int getEdgePadding() {
        return this.b;
    }

    public int getMonth() {
        return this.g;
    }

    protected int getMonthHeaderSize() {
        return this.a.getVersion() == DatePickerDialog.Version.VERSION_1 ? E : F;
    }

    public int getMonthHeight() {
        return getMonthHeaderSize() - (D * (this.a.getVersion() == DatePickerDialog.Version.VERSION_1 ? 2 : 3));
    }

    protected MonthViewTouchHelper getMonthViewTouchHelper() {
        return new MonthViewTouchHelper(this);
    }

    public int getYear() {
        return this.h;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        c(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), (this.j * this.r) + getMonthHeaderSize());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.i = i;
        this.mTouchHelper.invalidateRoot();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        int dayFromLocation;
        if (motionEvent.getAction() == 1 && (dayFromLocation = getDayFromLocation(motionEvent.getX(), motionEvent.getY())) >= 0) {
            onDayClick(dayFromLocation);
        }
        return true;
    }

    public boolean restoreAccessibilityFocus(MonthAdapter.CalendarDay calendarDay) {
        int i;
        if (calendarDay.a != this.h || calendarDay.b != this.g || (i = calendarDay.c) > this.p) {
            return false;
        }
        this.mTouchHelper.c(i);
        return true;
    }

    @Override // android.view.View
    public void setAccessibilityDelegate(View.AccessibilityDelegate accessibilityDelegate) {
        if (this.mLockAccessibilityDelegate) {
            return;
        }
        super.setAccessibilityDelegate(accessibilityDelegate);
    }

    public void setMonthParams(int i, int i2, int i3, int i4) {
        if (i3 == -1 && i2 == -1) {
            throw new InvalidParameterException("You must specify month and year for this view");
        }
        this.l = i;
        this.g = i3;
        this.h = i2;
        Calendar calendar = Calendar.getInstance(this.a.getTimeZone(), this.a.getLocale());
        int i5 = 0;
        this.k = false;
        this.m = -1;
        this.mCalendar.set(2, this.g);
        this.mCalendar.set(1, this.h);
        this.mCalendar.set(5, 1);
        this.mDayOfWeekStart = this.mCalendar.get(7);
        if (i4 != -1) {
            this.n = i4;
        } else {
            this.n = this.mCalendar.getFirstDayOfWeek();
        }
        this.p = this.mCalendar.getActualMaximum(5);
        while (i5 < this.p) {
            i5++;
            if (sameDay(i5, calendar)) {
                this.k = true;
                this.m = i5;
            }
        }
        this.r = calculateNumRows();
        this.mTouchHelper.invalidateRoot();
    }

    public void setOnDayClickListener(OnDayClickListener onDayClickListener) {
        this.s = onDayClickListener;
    }

    public void setSelectedDay(int i) {
        this.l = i;
    }
}
