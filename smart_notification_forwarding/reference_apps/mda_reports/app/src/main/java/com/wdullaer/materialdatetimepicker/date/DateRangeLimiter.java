package com.wdullaer.materialdatetimepicker.date;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Calendar;

/* loaded from: classes2.dex */
public interface DateRangeLimiter extends Parcelable {
    @NonNull
    Calendar getEndDate();

    int getMaxYear();

    int getMinYear();

    @NonNull
    Calendar getStartDate();

    boolean isOutOfRange(int i, int i2, int i3);

    @NonNull
    Calendar setToNearestDate(@NonNull Calendar calendar);
}
