package com.wdullaer.materialdatetimepicker.date;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.date.MonthAdapter;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public interface DatePickerController {
    int getAccentColor();

    Calendar getEndDate();

    int getFirstDayOfWeek();

    Locale getLocale();

    int getMaxYear();

    int getMinYear();

    DatePickerDialog.ScrollOrientation getScrollOrientation();

    MonthAdapter.CalendarDay getSelectedDay();

    Calendar getStartDate();

    TimeZone getTimeZone();

    DatePickerDialog.Version getVersion();

    boolean isHighlighted(int i, int i2, int i3);

    boolean isOutOfRange(int i, int i2, int i3);

    boolean isThemeDark();

    void onDayOfMonthSelected(int i, int i2, int i3);

    void onYearSelected(int i);

    void registerOnDateChangedListener(DatePickerDialog.OnDateChangedListener onDateChangedListener);

    void tryVibrate();

    void unregisterOnDateChangedListener(DatePickerDialog.OnDateChangedListener onDateChangedListener);
}
