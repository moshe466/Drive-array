package com.wdullaer.materialdatetimepicker.date;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wdullaer.materialdatetimepicker.Utils;
import java.util.Calendar;
import java.util.HashSet;
import java.util.TimeZone;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class DefaultDateRangeLimiter implements DateRangeLimiter {
    public static final Parcelable.Creator<DefaultDateRangeLimiter> CREATOR = new Parcelable.Creator<DefaultDateRangeLimiter>() { // from class: com.wdullaer.materialdatetimepicker.date.DefaultDateRangeLimiter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultDateRangeLimiter createFromParcel(Parcel parcel) {
            return new DefaultDateRangeLimiter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultDateRangeLimiter[] newArray(int i) {
            return new DefaultDateRangeLimiter[i];
        }
    };
    private static final int DEFAULT_END_YEAR = 2100;
    private static final int DEFAULT_START_YEAR = 1900;
    private HashSet<Calendar> disabledDays;
    private transient DatePickerController mController;
    private Calendar mMaxDate;
    private int mMaxYear;
    private Calendar mMinDate;
    private int mMinYear;
    private TreeSet<Calendar> selectableDays;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultDateRangeLimiter() {
        this.mMinYear = DEFAULT_START_YEAR;
        this.mMaxYear = DEFAULT_END_YEAR;
        this.selectableDays = new TreeSet<>();
        this.disabledDays = new HashSet<>();
    }

    public DefaultDateRangeLimiter(Parcel parcel) {
        this.mMinYear = DEFAULT_START_YEAR;
        this.mMaxYear = DEFAULT_END_YEAR;
        this.selectableDays = new TreeSet<>();
        this.disabledDays = new HashSet<>();
        this.mMinYear = parcel.readInt();
        this.mMaxYear = parcel.readInt();
        this.mMinDate = (Calendar) parcel.readSerializable();
        this.mMaxDate = (Calendar) parcel.readSerializable();
        this.selectableDays = (TreeSet) parcel.readSerializable();
        this.disabledDays = (HashSet) parcel.readSerializable();
    }

    private boolean isAfterMax(@NonNull Calendar calendar) {
        Calendar calendar2 = this.mMaxDate;
        return (calendar2 != null && calendar.after(calendar2)) || calendar.get(1) > this.mMaxYear;
    }

    private boolean isBeforeMin(@NonNull Calendar calendar) {
        Calendar calendar2 = this.mMinDate;
        return (calendar2 != null && calendar.before(calendar2)) || calendar.get(1) < this.mMinYear;
    }

    private boolean isDisabled(@NonNull Calendar calendar) {
        return this.disabledDays.contains(Utils.trimToMidnight(calendar)) || isBeforeMin(calendar) || isAfterMax(calendar);
    }

    private boolean isOutOfRange(@NonNull Calendar calendar) {
        Utils.trimToMidnight(calendar);
        return isDisabled(calendar) || !isSelectable(calendar);
    }

    private boolean isSelectable(@NonNull Calendar calendar) {
        return this.selectableDays.isEmpty() || this.selectableDays.contains(Utils.trimToMidnight(calendar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        if (i2 < i) {
            throw new IllegalArgumentException("Year end must be larger than or equal to year start");
        }
        this.mMinYear = i;
        this.mMaxYear = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull DatePickerController datePickerController) {
        this.mController = datePickerController;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull Calendar calendar) {
        this.mMaxDate = Utils.trimToMidnight((Calendar) calendar.clone());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull Calendar[] calendarArr) {
        for (Calendar calendar : calendarArr) {
            this.disabledDays.add(Utils.trimToMidnight((Calendar) calendar.clone()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Calendar[] a() {
        if (this.disabledDays.isEmpty()) {
            return null;
        }
        return (Calendar[]) this.disabledDays.toArray(new Calendar[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Calendar b() {
        return this.mMaxDate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@NonNull Calendar calendar) {
        this.mMinDate = Utils.trimToMidnight((Calendar) calendar.clone());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@NonNull Calendar[] calendarArr) {
        for (Calendar calendar : calendarArr) {
            this.selectableDays.add(Utils.trimToMidnight((Calendar) calendar.clone()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Calendar c() {
        return this.mMinDate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Calendar[] d() {
        if (this.selectableDays.isEmpty()) {
            return null;
        }
        return (Calendar[]) this.selectableDays.toArray(new Calendar[0]);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DateRangeLimiter
    @NonNull
    public Calendar getEndDate() {
        if (!this.selectableDays.isEmpty()) {
            return (Calendar) this.selectableDays.last().clone();
        }
        Calendar calendar = this.mMaxDate;
        if (calendar != null) {
            return (Calendar) calendar.clone();
        }
        DatePickerController datePickerController = this.mController;
        Calendar calendar2 = Calendar.getInstance(datePickerController == null ? TimeZone.getDefault() : datePickerController.getTimeZone());
        calendar2.set(1, this.mMaxYear);
        calendar2.set(5, 31);
        calendar2.set(2, 11);
        return calendar2;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DateRangeLimiter
    public int getMaxYear() {
        if (!this.selectableDays.isEmpty()) {
            return this.selectableDays.last().get(1);
        }
        Calendar calendar = this.mMaxDate;
        return (calendar == null || calendar.get(1) >= this.mMaxYear) ? this.mMaxYear : this.mMaxDate.get(1);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DateRangeLimiter
    public int getMinYear() {
        if (!this.selectableDays.isEmpty()) {
            return this.selectableDays.first().get(1);
        }
        Calendar calendar = this.mMinDate;
        return (calendar == null || calendar.get(1) <= this.mMinYear) ? this.mMinYear : this.mMinDate.get(1);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DateRangeLimiter
    @NonNull
    public Calendar getStartDate() {
        if (!this.selectableDays.isEmpty()) {
            return (Calendar) this.selectableDays.first().clone();
        }
        Calendar calendar = this.mMinDate;
        if (calendar != null) {
            return (Calendar) calendar.clone();
        }
        DatePickerController datePickerController = this.mController;
        Calendar calendar2 = Calendar.getInstance(datePickerController == null ? TimeZone.getDefault() : datePickerController.getTimeZone());
        calendar2.set(1, this.mMinYear);
        calendar2.set(5, 1);
        calendar2.set(2, 0);
        return calendar2;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DateRangeLimiter
    public boolean isOutOfRange(int i, int i2, int i3) {
        DatePickerController datePickerController = this.mController;
        Calendar calendar = Calendar.getInstance(datePickerController == null ? TimeZone.getDefault() : datePickerController.getTimeZone());
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        return isOutOfRange(calendar);
    }

    @Override // com.wdullaer.materialdatetimepicker.date.DateRangeLimiter
    @NonNull
    public Calendar setToNearestDate(@NonNull Calendar calendar) {
        if (!this.selectableDays.isEmpty()) {
            Calendar calendar2 = null;
            Calendar ceiling = this.selectableDays.ceiling(calendar);
            Calendar lower = this.selectableDays.lower(calendar);
            if (ceiling == null && lower != null) {
                calendar2 = lower;
            } else if (lower == null && ceiling != null) {
                calendar2 = ceiling;
            }
            if (calendar2 == null && ceiling != null) {
                return Math.abs(calendar.getTimeInMillis() - lower.getTimeInMillis()) < Math.abs(ceiling.getTimeInMillis() - calendar.getTimeInMillis()) ? (Calendar) lower.clone() : (Calendar) ceiling.clone();
            }
            if (calendar2 != null) {
                calendar = calendar2;
            }
            DatePickerController datePickerController = this.mController;
            calendar.setTimeZone(datePickerController == null ? TimeZone.getDefault() : datePickerController.getTimeZone());
            return (Calendar) calendar.clone();
        }
        if (!this.disabledDays.isEmpty()) {
            Calendar startDate = isBeforeMin(calendar) ? getStartDate() : (Calendar) calendar.clone();
            Calendar endDate = isAfterMax(calendar) ? getEndDate() : (Calendar) calendar.clone();
            while (isDisabled(startDate) && isDisabled(endDate)) {
                startDate.add(5, 1);
                endDate.add(5, -1);
            }
            if (!isDisabled(endDate)) {
                return endDate;
            }
            if (!isDisabled(startDate)) {
                return startDate;
            }
        }
        DatePickerController datePickerController2 = this.mController;
        TimeZone timeZone = datePickerController2 == null ? TimeZone.getDefault() : datePickerController2.getTimeZone();
        if (isBeforeMin(calendar)) {
            Calendar calendar3 = this.mMinDate;
            if (calendar3 != null) {
                return (Calendar) calendar3.clone();
            }
            Calendar calendar4 = Calendar.getInstance(timeZone);
            calendar4.set(1, this.mMinYear);
            calendar4.set(2, 0);
            calendar4.set(5, 1);
            return Utils.trimToMidnight(calendar4);
        }
        if (!isAfterMax(calendar)) {
            return calendar;
        }
        Calendar calendar5 = this.mMaxDate;
        if (calendar5 != null) {
            return (Calendar) calendar5.clone();
        }
        Calendar calendar6 = Calendar.getInstance(timeZone);
        calendar6.set(1, this.mMaxYear);
        calendar6.set(2, 11);
        calendar6.set(5, 31);
        return Utils.trimToMidnight(calendar6);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mMinYear);
        parcel.writeInt(this.mMaxYear);
        parcel.writeSerializable(this.mMinDate);
        parcel.writeSerializable(this.mMaxDate);
        parcel.writeSerializable(this.selectableDays);
        parcel.writeSerializable(this.disabledDays);
    }
}
