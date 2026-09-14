package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    private final IntentSender f517f;

    /* renamed from: g, reason: collision with root package name */
    private final Intent f518g;

    /* renamed from: h, reason: collision with root package name */
    private final int f519h;

    /* renamed from: i, reason: collision with root package name */
    private final int f520i;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<f> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i10) {
            return new f[i10];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private IntentSender f521a;

        /* renamed from: b, reason: collision with root package name */
        private Intent f522b;

        /* renamed from: c, reason: collision with root package name */
        private int f523c;

        /* renamed from: d, reason: collision with root package name */
        private int f524d;

        public b(IntentSender intentSender) {
            this.f521a = intentSender;
        }

        public f a() {
            return new f(this.f521a, this.f522b, this.f523c, this.f524d);
        }

        public b b(Intent intent) {
            this.f522b = intent;
            return this;
        }

        public b c(int i10, int i11) {
            this.f524d = i10;
            this.f523c = i11;
            return this;
        }
    }

    f(IntentSender intentSender, Intent intent, int i10, int i11) {
        this.f517f = intentSender;
        this.f518g = intent;
        this.f519h = i10;
        this.f520i = i11;
    }

    f(Parcel parcel) {
        this.f517f = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f518g = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f519h = parcel.readInt();
        this.f520i = parcel.readInt();
    }

    public Intent a() {
        return this.f518g;
    }

    public int b() {
        return this.f519h;
    }

    public int c() {
        return this.f520i;
    }

    public IntentSender d() {
        return this.f517f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f517f, i10);
        parcel.writeParcelable(this.f518g, i10);
        parcel.writeInt(this.f519h);
        parcel.writeInt(this.f520i);
    }
}
