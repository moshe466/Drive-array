package com.wdullaer.materialdatetimepicker.time;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wdullaer.materialdatetimepicker.time.Timepoint;

/* loaded from: classes2.dex */
public interface TimepointLimiter extends Parcelable {
    boolean isAmDisabled();

    boolean isOutOfRange(@Nullable Timepoint timepoint, int i, @NonNull Timepoint.TYPE type);

    boolean isPmDisabled();

    @NonNull
    Timepoint roundToNearest(@NonNull Timepoint timepoint, @Nullable Timepoint.TYPE type, @NonNull Timepoint.TYPE type2);
}
