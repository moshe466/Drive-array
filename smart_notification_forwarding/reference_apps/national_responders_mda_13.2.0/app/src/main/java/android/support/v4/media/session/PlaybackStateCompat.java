package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.g;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    final int f425f;

    /* renamed from: g, reason: collision with root package name */
    final long f426g;

    /* renamed from: h, reason: collision with root package name */
    final long f427h;

    /* renamed from: i, reason: collision with root package name */
    final float f428i;

    /* renamed from: j, reason: collision with root package name */
    final long f429j;

    /* renamed from: k, reason: collision with root package name */
    final int f430k;

    /* renamed from: l, reason: collision with root package name */
    final CharSequence f431l;

    /* renamed from: m, reason: collision with root package name */
    final long f432m;

    /* renamed from: n, reason: collision with root package name */
    List<CustomAction> f433n;

    /* renamed from: o, reason: collision with root package name */
    final long f434o;

    /* renamed from: p, reason: collision with root package name */
    final Bundle f435p;

    /* renamed from: q, reason: collision with root package name */
    private Object f436q;

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        private final String f437f;

        /* renamed from: g, reason: collision with root package name */
        private final CharSequence f438g;

        /* renamed from: h, reason: collision with root package name */
        private final int f439h;

        /* renamed from: i, reason: collision with root package name */
        private final Bundle f440i;

        /* renamed from: j, reason: collision with root package name */
        private Object f441j;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<CustomAction> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i10) {
                return new CustomAction[i10];
            }
        }

        CustomAction(Parcel parcel) {
            this.f437f = parcel.readString();
            this.f438g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f439h = parcel.readInt();
            this.f440i = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        CustomAction(String str, CharSequence charSequence, int i10, Bundle bundle) {
            this.f437f = str;
            this.f438g = charSequence;
            this.f439h = i10;
            this.f440i = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(g.a.a(obj), g.a.d(obj), g.a.c(obj), g.a.b(obj));
            customAction.f441j = obj;
            return customAction;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f438g) + ", mIcon=" + this.f439h + ", mExtras=" + this.f440i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f437f);
            TextUtils.writeToParcel(this.f438g, parcel, i10);
            parcel.writeInt(this.f439h);
            parcel.writeBundle(this.f440i);
        }
    }

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<PlaybackStateCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i10) {
            return new PlaybackStateCompat[i10];
        }
    }

    PlaybackStateCompat(int i10, long j10, long j11, float f10, long j12, int i11, CharSequence charSequence, long j13, List<CustomAction> list, long j14, Bundle bundle) {
        this.f425f = i10;
        this.f426g = j10;
        this.f427h = j11;
        this.f428i = f10;
        this.f429j = j12;
        this.f430k = i11;
        this.f431l = charSequence;
        this.f432m = j13;
        this.f433n = new ArrayList(list);
        this.f434o = j14;
        this.f435p = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f425f = parcel.readInt();
        this.f426g = parcel.readLong();
        this.f428i = parcel.readFloat();
        this.f432m = parcel.readLong();
        this.f427h = parcel.readLong();
        this.f429j = parcel.readLong();
        this.f431l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f433n = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f434o = parcel.readLong();
        this.f435p = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f430k = parcel.readInt();
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> d10 = g.d(obj);
        if (d10 != null) {
            ArrayList arrayList2 = new ArrayList(d10.size());
            Iterator<Object> it = d10.iterator();
            while (it.hasNext()) {
                arrayList2.add(CustomAction.a(it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(g.i(obj), g.h(obj), g.c(obj), g.g(obj), g.a(obj), 0, g.e(obj), g.f(obj), arrayList, g.b(obj), Build.VERSION.SDK_INT >= 22 ? h.a(obj) : null);
        playbackStateCompat.f436q = obj;
        return playbackStateCompat;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f425f + ", position=" + this.f426g + ", buffered position=" + this.f427h + ", speed=" + this.f428i + ", updated=" + this.f432m + ", actions=" + this.f429j + ", error code=" + this.f430k + ", error message=" + this.f431l + ", custom actions=" + this.f433n + ", active item id=" + this.f434o + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f425f);
        parcel.writeLong(this.f426g);
        parcel.writeFloat(this.f428i);
        parcel.writeLong(this.f432m);
        parcel.writeLong(this.f427h);
        parcel.writeLong(this.f429j);
        TextUtils.writeToParcel(this.f431l, parcel, i10);
        parcel.writeTypedList(this.f433n);
        parcel.writeLong(this.f434o);
        parcel.writeBundle(this.f435p);
        parcel.writeInt(this.f430k);
    }
}
