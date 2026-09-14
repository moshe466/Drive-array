package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes2.dex */
public class SimpleDayPickerView extends DayPickerView {
    public SimpleDayPickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SimpleDayPickerView(Context context, DatePickerController datePickerController) {
        super(context, datePickerController);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DayPickerView
    public MonthAdapter createMonthAdapter(DatePickerController datePickerController) {
        return new SimpleMonthAdapter(datePickerController);
    }
}
