package com.wdullaer.materialdatetimepicker.time;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wdullaer.materialdatetimepicker.time.Timepoint;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class DefaultTimepointLimiter implements TimepointLimiter {
    public static final Parcelable.Creator<DefaultTimepointLimiter> CREATOR = new Parcelable.Creator<DefaultTimepointLimiter>() { // from class: com.wdullaer.materialdatetimepicker.time.DefaultTimepointLimiter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultTimepointLimiter createFromParcel(Parcel parcel) {
            return new DefaultTimepointLimiter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultTimepointLimiter[] newArray(int i) {
            return new DefaultTimepointLimiter[i];
        }
    };
    private TreeSet<Timepoint> exclusiveSelectableTimes;
    private TreeSet<Timepoint> mDisabledTimes;
    private Timepoint mMaxTime;
    private Timepoint mMinTime;
    private TreeSet<Timepoint> mSelectableTimes;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultTimepointLimiter() {
        this.mSelectableTimes = new TreeSet<>();
        this.mDisabledTimes = new TreeSet<>();
        this.exclusiveSelectableTimes = new TreeSet<>();
    }

    public DefaultTimepointLimiter(Parcel parcel) {
        this.mSelectableTimes = new TreeSet<>();
        this.mDisabledTimes = new TreeSet<>();
        this.exclusiveSelectableTimes = new TreeSet<>();
        this.mMinTime = (Timepoint) parcel.readParcelable(Timepoint.class.getClassLoader());
        this.mMaxTime = (Timepoint) parcel.readParcelable(Timepoint.class.getClassLoader());
        this.mSelectableTimes.addAll(Arrays.asList(parcel.createTypedArray(Timepoint.CREATOR)));
        this.mDisabledTimes.addAll(Arrays.asList(parcel.createTypedArray(Timepoint.CREATOR)));
        this.exclusiveSelectableTimes = getExclusiveSelectableTimes(this.mSelectableTimes, this.mDisabledTimes);
    }

    @NonNull
    private TreeSet<Timepoint> getExclusiveSelectableTimes(@NonNull TreeSet<Timepoint> treeSet, @NonNull TreeSet<Timepoint> treeSet2) {
        TreeSet<Timepoint> treeSet3 = new TreeSet<>((SortedSet<Timepoint>) treeSet);
        treeSet3.removeAll(treeSet2);
        return treeSet3;
    }

    private Timepoint searchValidTimePoint(@NonNull Timepoint timepoint, @Nullable Timepoint.TYPE type, @NonNull Timepoint.TYPE type2) {
        Timepoint timepoint2 = new Timepoint(timepoint);
        Timepoint timepoint3 = new Timepoint(timepoint);
        int i = type2 == Timepoint.TYPE.MINUTE ? 60 : 1;
        int i2 = 0;
        if (type2 == Timepoint.TYPE.SECOND) {
            i = 3600;
        }
        while (i2 < i * 24) {
            i2++;
            timepoint2.add(type2, 1);
            timepoint3.add(type2, -1);
            if (type == null || timepoint2.get(type) == timepoint.get(type)) {
                Timepoint ceiling = this.mDisabledTimes.ceiling(timepoint2);
                Timepoint floor = this.mDisabledTimes.floor(timepoint2);
                if (!timepoint2.equals(ceiling, type2) && !timepoint2.equals(floor, type2)) {
                    return timepoint2;
                }
            }
            if (type == null || timepoint3.get(type) == timepoint.get(type)) {
                Timepoint ceiling2 = this.mDisabledTimes.ceiling(timepoint3);
                Timepoint floor2 = this.mDisabledTimes.floor(timepoint3);
                if (!timepoint3.equals(ceiling2, type2) && !timepoint3.equals(floor2, type2)) {
                    return timepoint3;
                }
            }
            if (type != null && timepoint3.get(type) != timepoint.get(type) && timepoint2.get(type) != timepoint.get(type)) {
                break;
            }
        }
        return timepoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull Timepoint timepoint) {
        Timepoint timepoint2 = this.mMinTime;
        if (timepoint2 != null && timepoint.compareTo(timepoint2) < 0) {
            throw new IllegalArgumentException("Maximum time must be greater than the minimum time");
        }
        this.mMaxTime = timepoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull Timepoint[] timepointArr) {
        this.mDisabledTimes.addAll(Arrays.asList(timepointArr));
        this.exclusiveSelectableTimes = getExclusiveSelectableTimes(this.mSelectableTimes, this.mDisabledTimes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@NonNull Timepoint timepoint) {
        Timepoint timepoint2 = this.mMaxTime;
        if (timepoint2 != null && timepoint.compareTo(timepoint2) > 0) {
            throw new IllegalArgumentException("Minimum time must be smaller than the maximum time");
        }
        this.mMinTime = timepoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@NonNull Timepoint[] timepointArr) {
        this.mSelectableTimes.addAll(Arrays.asList(timepointArr));
        this.exclusiveSelectableTimes = getExclusiveSelectableTimes(this.mSelectableTimes, this.mDisabledTimes);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimepointLimiter
    public boolean isAmDisabled() {
        Timepoint timepoint = new Timepoint(12);
        Timepoint timepoint2 = this.mMinTime;
        if (timepoint2 == null || timepoint2.compareTo(timepoint) < 0) {
            return !this.exclusiveSelectableTimes.isEmpty() && this.exclusiveSelectableTimes.first().compareTo(timepoint) >= 0;
        }
        return true;
    }

    public boolean isOutOfRange(@NonNull Timepoint timepoint) {
        Timepoint timepoint2 = this.mMinTime;
        if (timepoint2 != null && timepoint2.compareTo(timepoint) > 0) {
            return true;
        }
        Timepoint timepoint3 = this.mMaxTime;
        if (timepoint3 == null || timepoint3.compareTo(timepoint) >= 0) {
            return !this.exclusiveSelectableTimes.isEmpty() ? !this.exclusiveSelectableTimes.contains(timepoint) : this.mDisabledTimes.contains(timepoint);
        }
        return true;
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimepointLimiter
    public boolean isOutOfRange(@Nullable Timepoint timepoint, int i, @NonNull Timepoint.TYPE type) {
        if (timepoint == null) {
            return false;
        }
        if (i == 0) {
            Timepoint timepoint2 = this.mMinTime;
            if (timepoint2 != null && timepoint2.getHour() > timepoint.getHour()) {
                return true;
            }
            Timepoint timepoint3 = this.mMaxTime;
            if (timepoint3 != null && timepoint3.getHour() + 1 <= timepoint.getHour()) {
                return true;
            }
            if (!this.exclusiveSelectableTimes.isEmpty()) {
                return (timepoint.equals(this.exclusiveSelectableTimes.ceiling(timepoint), Timepoint.TYPE.HOUR) || timepoint.equals(this.exclusiveSelectableTimes.floor(timepoint), Timepoint.TYPE.HOUR)) ? false : true;
            }
            if (this.mDisabledTimes.isEmpty() || type != Timepoint.TYPE.HOUR) {
                return false;
            }
            return timepoint.equals(this.mDisabledTimes.ceiling(timepoint), Timepoint.TYPE.HOUR) || timepoint.equals(this.mDisabledTimes.floor(timepoint), Timepoint.TYPE.HOUR);
        }
        if (i != 1) {
            return isOutOfRange(timepoint);
        }
        Timepoint timepoint4 = this.mMinTime;
        if (timepoint4 != null && new Timepoint(timepoint4.getHour(), this.mMinTime.getMinute()).compareTo(timepoint) > 0) {
            return true;
        }
        Timepoint timepoint5 = this.mMaxTime;
        if (timepoint5 != null && new Timepoint(timepoint5.getHour(), this.mMaxTime.getMinute(), 59).compareTo(timepoint) < 0) {
            return true;
        }
        if (!this.exclusiveSelectableTimes.isEmpty()) {
            return (timepoint.equals(this.exclusiveSelectableTimes.ceiling(timepoint), Timepoint.TYPE.MINUTE) || timepoint.equals(this.exclusiveSelectableTimes.floor(timepoint), Timepoint.TYPE.MINUTE)) ? false : true;
        }
        if (this.mDisabledTimes.isEmpty() || type != Timepoint.TYPE.MINUTE) {
            return false;
        }
        return timepoint.equals(this.mDisabledTimes.ceiling(timepoint), Timepoint.TYPE.MINUTE) || timepoint.equals(this.mDisabledTimes.floor(timepoint), Timepoint.TYPE.MINUTE);
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimepointLimiter
    public boolean isPmDisabled() {
        Timepoint timepoint = new Timepoint(12);
        Timepoint timepoint2 = this.mMaxTime;
        if (timepoint2 == null || timepoint2.compareTo(timepoint) >= 0) {
            return !this.exclusiveSelectableTimes.isEmpty() && this.exclusiveSelectableTimes.last().compareTo(timepoint) < 0;
        }
        return true;
    }

    @Override // com.wdullaer.materialdatetimepicker.time.TimepointLimiter
    @NonNull
    public Timepoint roundToNearest(@NonNull Timepoint timepoint, @Nullable Timepoint.TYPE type, @NonNull Timepoint.TYPE type2) {
        Timepoint timepoint2 = this.mMinTime;
        if (timepoint2 != null && timepoint2.compareTo(timepoint) > 0) {
            return this.mMinTime;
        }
        Timepoint timepoint3 = this.mMaxTime;
        if (timepoint3 != null && timepoint3.compareTo(timepoint) < 0) {
            return this.mMaxTime;
        }
        if (type == Timepoint.TYPE.SECOND) {
            return timepoint;
        }
        if (this.exclusiveSelectableTimes.isEmpty()) {
            if (this.mDisabledTimes.isEmpty()) {
                return timepoint;
            }
            if (type != null && type == type2) {
                return timepoint;
            }
            if (type2 == Timepoint.TYPE.SECOND) {
                return !this.mDisabledTimes.contains(timepoint) ? timepoint : searchValidTimePoint(timepoint, type, type2);
            }
            if (type2 == Timepoint.TYPE.MINUTE) {
                return (timepoint.equals(this.mDisabledTimes.ceiling(timepoint), Timepoint.TYPE.MINUTE) || timepoint.equals(this.mDisabledTimes.floor(timepoint), Timepoint.TYPE.MINUTE)) ? searchValidTimePoint(timepoint, type, type2) : timepoint;
            }
            if (type2 == Timepoint.TYPE.HOUR) {
                return (timepoint.equals(this.mDisabledTimes.ceiling(timepoint), Timepoint.TYPE.HOUR) || timepoint.equals(this.mDisabledTimes.floor(timepoint), Timepoint.TYPE.HOUR)) ? searchValidTimePoint(timepoint, type, type2) : timepoint;
            }
            return timepoint;
        }
        Timepoint floor = this.exclusiveSelectableTimes.floor(timepoint);
        Timepoint ceiling = this.exclusiveSelectableTimes.ceiling(timepoint);
        if (floor == null || ceiling == null) {
            if (floor == null) {
                floor = ceiling;
            }
            return type == null ? floor : floor.getHour() != timepoint.getHour() ? timepoint : (type != Timepoint.TYPE.MINUTE || floor.getMinute() == timepoint.getMinute()) ? floor : timepoint;
        }
        if (type == Timepoint.TYPE.HOUR) {
            if (floor.getHour() != timepoint.getHour() && ceiling.getHour() == timepoint.getHour()) {
                return ceiling;
            }
            if (floor.getHour() == timepoint.getHour() && ceiling.getHour() != timepoint.getHour()) {
                return floor;
            }
            if (floor.getHour() != timepoint.getHour() && ceiling.getHour() != timepoint.getHour()) {
                return timepoint;
            }
        }
        if (type == Timepoint.TYPE.MINUTE) {
            if (floor.getHour() != timepoint.getHour() && ceiling.getHour() != timepoint.getHour()) {
                return timepoint;
            }
            if (floor.getHour() != timepoint.getHour() && ceiling.getHour() == timepoint.getHour()) {
                return ceiling.getMinute() == timepoint.getMinute() ? ceiling : timepoint;
            }
            if (floor.getHour() == timepoint.getHour() && ceiling.getHour() != timepoint.getHour()) {
                return floor.getMinute() == timepoint.getMinute() ? floor : timepoint;
            }
            if (floor.getMinute() != timepoint.getMinute() && ceiling.getMinute() == timepoint.getMinute()) {
                return ceiling;
            }
            if (floor.getMinute() == timepoint.getMinute() && ceiling.getMinute() != timepoint.getMinute()) {
                return floor;
            }
            if (floor.getMinute() != timepoint.getMinute() && ceiling.getMinute() != timepoint.getMinute()) {
                return timepoint;
            }
        }
        return Math.abs(timepoint.compareTo(floor)) < Math.abs(timepoint.compareTo(ceiling)) ? floor : ceiling;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mMinTime, i);
        parcel.writeParcelable(this.mMaxTime, i);
        TreeSet<Timepoint> treeSet = this.mSelectableTimes;
        parcel.writeTypedArray((Parcelable[]) treeSet.toArray(new Timepoint[treeSet.size()]), i);
        TreeSet<Timepoint> treeSet2 = this.mDisabledTimes;
        parcel.writeTypedArray((Parcelable[]) treeSet2.toArray(new Timepoint[treeSet2.size()]), i);
    }
}
