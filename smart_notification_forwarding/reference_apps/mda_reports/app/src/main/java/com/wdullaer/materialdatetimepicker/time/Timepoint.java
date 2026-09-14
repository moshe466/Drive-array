package com.wdullaer.materialdatetimepicker.time;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class Timepoint implements Parcelable, Comparable<Timepoint> {
    public static final Parcelable.Creator<Timepoint> CREATOR = new Parcelable.Creator<Timepoint>() { // from class: com.wdullaer.materialdatetimepicker.time.Timepoint.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timepoint createFromParcel(Parcel parcel) {
            return new Timepoint(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timepoint[] newArray(int i) {
            return new Timepoint[i];
        }
    };
    private int hour;
    private int minute;
    private int second;

    /* renamed from: com.wdullaer.materialdatetimepicker.time.Timepoint$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a = new int[TYPE.values().length];

        static {
            try {
                a[TYPE.SECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TYPE.MINUTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TYPE.HOUR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum TYPE {
        HOUR,
        MINUTE,
        SECOND
    }

    public Timepoint(@IntRange(from = 0, to = 23) int i) {
        this(i, 0);
    }

    public Timepoint(@IntRange(from = 0, to = 23) int i, @IntRange(from = 0, to = 59) int i2) {
        this(i, i2, 0);
    }

    public Timepoint(@IntRange(from = 0, to = 23) int i, @IntRange(from = 0, to = 59) int i2, @IntRange(from = 0, to = 59) int i3) {
        this.hour = i % 24;
        this.minute = i2 % 60;
        this.second = i3 % 60;
    }

    public Timepoint(Parcel parcel) {
        this.hour = parcel.readInt();
        this.minute = parcel.readInt();
        this.second = parcel.readInt();
    }

    public Timepoint(Timepoint timepoint) {
        this(timepoint.hour, timepoint.minute, timepoint.second);
    }

    public void add(TYPE type, int i) {
        if (type == TYPE.MINUTE) {
            i *= 60;
        }
        if (type == TYPE.HOUR) {
            i *= 3600;
        }
        int seconds = i + toSeconds();
        int i2 = AnonymousClass2.a[type.ordinal()];
        if (i2 == 1) {
            this.second = (seconds % 3600) % 60;
        } else if (i2 != 2) {
            if (i2 != 3) {
                return;
            }
            this.hour = (seconds / 3600) % 24;
        }
        this.minute = (seconds % 3600) / 60;
        this.hour = (seconds / 3600) % 24;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull Timepoint timepoint) {
        return hashCode() - timepoint.hashCode();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(@androidx.annotation.Nullable com.wdullaer.materialdatetimepicker.time.Timepoint r4, @androidx.annotation.NonNull com.wdullaer.materialdatetimepicker.time.Timepoint.TYPE r5) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            int[] r1 = com.wdullaer.materialdatetimepicker.time.Timepoint.AnonymousClass2.a
            int r5 = r5.ordinal()
            r5 = r1[r5]
            r1 = 1
            if (r5 == r1) goto L1a
            r2 = 2
            if (r5 == r2) goto L18
            r2 = 3
            if (r5 == r2) goto L16
            goto L42
        L16:
            r5 = 1
            goto L34
        L18:
            r5 = 1
            goto L26
        L1a:
            int r5 = r4.getSecond()
            int r2 = r3.getSecond()
            if (r5 != r2) goto L25
            goto L18
        L25:
            r5 = 0
        L26:
            if (r5 == 0) goto L33
            int r5 = r4.getMinute()
            int r2 = r3.getMinute()
            if (r5 != r2) goto L33
            goto L16
        L33:
            r5 = 0
        L34:
            if (r5 == 0) goto L41
            int r4 = r4.getHour()
            int r5 = r3.getHour()
            if (r4 != r5) goto L41
            goto L42
        L41:
            r1 = 0
        L42:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wdullaer.materialdatetimepicker.time.Timepoint.equals(com.wdullaer.materialdatetimepicker.time.Timepoint, com.wdullaer.materialdatetimepicker.time.Timepoint$TYPE):boolean");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && Timepoint.class == obj.getClass() && hashCode() == ((Timepoint) obj).hashCode();
    }

    public int get(@NonNull TYPE type) {
        int i = AnonymousClass2.a[type.ordinal()];
        return i != 1 ? i != 2 ? getHour() : getMinute() : getSecond();
    }

    @IntRange(from = 0, to = 23)
    public int getHour() {
        return this.hour;
    }

    @IntRange(from = 0, to = 59)
    public int getMinute() {
        return this.minute;
    }

    @IntRange(from = 0, to = 59)
    public int getSecond() {
        return this.second;
    }

    public int hashCode() {
        return toSeconds();
    }

    public boolean isAM() {
        return this.hour < 12;
    }

    public boolean isPM() {
        return !isAM();
    }

    public void setAM() {
        int i = this.hour;
        if (i >= 12) {
            this.hour = i % 12;
        }
    }

    public void setPM() {
        int i = this.hour;
        if (i < 12) {
            this.hour = (i + 12) % 24;
        }
    }

    public int toSeconds() {
        return (this.hour * 3600) + (this.minute * 60) + this.second;
    }

    public String toString() {
        return "" + this.hour + "h " + this.minute + "m " + this.second + "s";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.hour);
        parcel.writeInt(this.minute);
        parcel.writeInt(this.second);
    }
}
