package com.google.firebase;

import F0.AbstractC0008a;
import a.AbstractC0228a;
import android.os.Parcel;
import android.os.Parcelable;
import java.time.Instant;
import java.util.Date;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.n;
import s2.C0679d;

/* loaded from: classes.dex */
public final class Timestamp implements Comparable<Timestamp>, Parcelable {
    private final int nanoseconds;
    private final long seconds;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<Timestamp> CREATOR = new Parcelable.Creator<Timestamp>() { // from class: com.google.firebase.Timestamp$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timestamp createFromParcel(Parcel source) {
            j.e(source, "source");
            return new Timestamp(source.readLong(), source.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Timestamp[] newArray(int i) {
            return new Timestamp[i];
        }
    };

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C0679d toPreciseTime(Date date) {
            long j2 = 1000;
            long time = date.getTime() / j2;
            int time2 = (int) ((date.getTime() % j2) * 1000000);
            if (time2 < 0) {
                return new C0679d(Long.valueOf(time - 1), Integer.valueOf(time2 + 1000000000));
            }
            return new C0679d(Long.valueOf(time), Integer.valueOf(time2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void validateRange(long j2, int i) {
            if (i >= 0 && i < 1000000000) {
                if (-62135596800L <= j2 && j2 < 253402300800L) {
                    return;
                } else {
                    throw new IllegalArgumentException(AbstractC0008a.l("Timestamp seconds out of range: ", j2).toString());
                }
            }
            throw new IllegalArgumentException(e0.a.c(i, "Timestamp nanoseconds out of range: ").toString());
        }

        public final Timestamp now() {
            return new Timestamp(new Date());
        }

        private Companion() {
        }
    }

    public Timestamp(long j2, int i) {
        Companion.validateRange(j2, i);
        this.seconds = j2;
        this.nanoseconds = i;
    }

    public static final Timestamp now() {
        return Companion.now();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof Timestamp) || compareTo((Timestamp) obj) != 0) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final int getNanoseconds() {
        return this.nanoseconds;
    }

    public final long getSeconds() {
        return this.seconds;
    }

    public int hashCode() {
        long j2 = this.seconds;
        return (((((int) j2) * 1369) + ((int) (j2 >> 32))) * 37) + this.nanoseconds;
    }

    public final Date toDate() {
        return new Date((this.seconds * 1000) + (this.nanoseconds / 1000000));
    }

    public final Instant toInstant() {
        Instant ofEpochSecond;
        ofEpochSecond = Instant.ofEpochSecond(this.seconds, this.nanoseconds);
        j.d(ofEpochSecond, "ofEpochSecond(seconds, nanoseconds.toLong())");
        return ofEpochSecond;
    }

    public String toString() {
        return "Timestamp(seconds=" + this.seconds + ", nanoseconds=" + this.nanoseconds + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i) {
        j.e(dest, "dest");
        dest.writeLong(this.seconds);
        dest.writeInt(this.nanoseconds);
    }

    @Override // java.lang.Comparable
    public int compareTo(Timestamp other) {
        j.e(other, "other");
        return AbstractC0228a.e(this, other, new n() { // from class: com.google.firebase.Timestamp$compareTo$1
            @Override // kotlin.jvm.internal.n, L2.h
            public Object get(Object obj) {
                return Long.valueOf(((Timestamp) obj).getSeconds());
            }
        }, new n() { // from class: com.google.firebase.Timestamp$compareTo$2
            @Override // kotlin.jvm.internal.n, L2.h
            public Object get(Object obj) {
                return Integer.valueOf(((Timestamp) obj).getNanoseconds());
            }
        });
    }

    public Timestamp(Date date) {
        j.e(date, "date");
        Companion companion = Companion;
        C0679d preciseTime = companion.toPreciseTime(date);
        long longValue = ((Number) preciseTime.f6332a).longValue();
        int intValue = ((Number) preciseTime.f6333b).intValue();
        companion.validateRange(longValue, intValue);
        this.seconds = longValue;
        this.nanoseconds = intValue;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Timestamp(java.time.Instant r3) {
        /*
            r2 = this;
            java.lang.String r0 = "time"
            kotlin.jvm.internal.j.e(r3, r0)
            long r0 = com.google.android.gms.common.wrappers.a.c(r3)
            int r3 = com.google.android.gms.common.wrappers.a.b(r3)
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.Timestamp.<init>(java.time.Instant):void");
    }
}
