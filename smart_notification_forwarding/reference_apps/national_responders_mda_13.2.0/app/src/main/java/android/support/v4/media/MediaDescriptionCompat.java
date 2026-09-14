package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    private final String f387f;

    /* renamed from: g, reason: collision with root package name */
    private final CharSequence f388g;

    /* renamed from: h, reason: collision with root package name */
    private final CharSequence f389h;

    /* renamed from: i, reason: collision with root package name */
    private final CharSequence f390i;

    /* renamed from: j, reason: collision with root package name */
    private final Bitmap f391j;

    /* renamed from: k, reason: collision with root package name */
    private final Uri f392k;

    /* renamed from: l, reason: collision with root package name */
    private final Bundle f393l;

    /* renamed from: m, reason: collision with root package name */
    private final Uri f394m;

    /* renamed from: n, reason: collision with root package name */
    private Object f395n;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return Build.VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.a(android.support.v4.media.a.a(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i10) {
            return new MediaDescriptionCompat[i10];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private String f396a;

        /* renamed from: b, reason: collision with root package name */
        private CharSequence f397b;

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f398c;

        /* renamed from: d, reason: collision with root package name */
        private CharSequence f399d;

        /* renamed from: e, reason: collision with root package name */
        private Bitmap f400e;

        /* renamed from: f, reason: collision with root package name */
        private Uri f401f;

        /* renamed from: g, reason: collision with root package name */
        private Bundle f402g;

        /* renamed from: h, reason: collision with root package name */
        private Uri f403h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f396a, this.f397b, this.f398c, this.f399d, this.f400e, this.f401f, this.f402g, this.f403h);
        }

        public b b(CharSequence charSequence) {
            this.f399d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f402g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f400e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f401f = uri;
            return this;
        }

        public b f(String str) {
            this.f396a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f403h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f398c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f397b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f387f = parcel.readString();
        this.f388g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f389h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f390i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f391j = (Bitmap) parcel.readParcelable(classLoader);
        this.f392k = (Uri) parcel.readParcelable(classLoader);
        this.f393l = parcel.readBundle(classLoader);
        this.f394m = (Uri) parcel.readParcelable(classLoader);
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f387f = str;
        this.f388g = charSequence;
        this.f389h = charSequence2;
        this.f390i = charSequence3;
        this.f391j = bitmap;
        this.f392k = uri;
        this.f393l = bundle;
        this.f394m = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r9) {
        /*
            r0 = 0
            if (r9 == 0) goto L7e
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r1 < r2) goto L7e
            android.support.v4.media.MediaDescriptionCompat$b r2 = new android.support.v4.media.MediaDescriptionCompat$b
            r2.<init>()
            java.lang.String r3 = android.support.v4.media.a.f(r9)
            r2.f(r3)
            java.lang.CharSequence r3 = android.support.v4.media.a.h(r9)
            r2.i(r3)
            java.lang.CharSequence r3 = android.support.v4.media.a.g(r9)
            r2.h(r3)
            java.lang.CharSequence r3 = android.support.v4.media.a.b(r9)
            r2.b(r3)
            android.graphics.Bitmap r3 = android.support.v4.media.a.d(r9)
            r2.d(r3)
            android.net.Uri r3 = android.support.v4.media.a.e(r9)
            r2.e(r3)
            android.os.Bundle r3 = android.support.v4.media.a.c(r9)
            java.lang.String r4 = "android.support.v4.media.description.MEDIA_URI"
            if (r3 == 0) goto L4a
            android.support.v4.media.session.MediaSessionCompat.a(r3)
            android.os.Parcelable r5 = r3.getParcelable(r4)
            android.net.Uri r5 = (android.net.Uri) r5
            goto L4b
        L4a:
            r5 = r0
        L4b:
            if (r5 == 0) goto L63
            java.lang.String r6 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r7 = r3.containsKey(r6)
            if (r7 == 0) goto L5d
            int r7 = r3.size()
            r8 = 2
            if (r7 != r8) goto L5d
            goto L64
        L5d:
            r3.remove(r4)
            r3.remove(r6)
        L63:
            r0 = r3
        L64:
            r2.c(r0)
            if (r5 == 0) goto L6d
            r2.g(r5)
            goto L78
        L6d:
            r0 = 23
            if (r1 < r0) goto L78
            android.net.Uri r0 = android.support.v4.media.b.a(r9)
            r2.g(r0)
        L78:
            android.support.v4.media.MediaDescriptionCompat r0 = r2.a()
            r0.f395n = r9
        L7e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public Object b() {
        int i10;
        Object obj = this.f395n;
        if (obj != null || (i10 = Build.VERSION.SDK_INT) < 21) {
            return obj;
        }
        Object b10 = a.C0013a.b();
        a.C0013a.g(b10, this.f387f);
        a.C0013a.i(b10, this.f388g);
        a.C0013a.h(b10, this.f389h);
        a.C0013a.c(b10, this.f390i);
        a.C0013a.e(b10, this.f391j);
        a.C0013a.f(b10, this.f392k);
        Bundle bundle = this.f393l;
        if (i10 < 23 && this.f394m != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.f394m);
        }
        a.C0013a.d(b10, bundle);
        if (i10 >= 23) {
            b.a.a(b10, this.f394m);
        }
        Object a10 = a.C0013a.a(b10);
        this.f395n = a10;
        return a10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.f388g) + ", " + ((Object) this.f389h) + ", " + ((Object) this.f390i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (Build.VERSION.SDK_INT >= 21) {
            android.support.v4.media.a.i(b(), parcel, i10);
            return;
        }
        parcel.writeString(this.f387f);
        TextUtils.writeToParcel(this.f388g, parcel, i10);
        TextUtils.writeToParcel(this.f389h, parcel, i10);
        TextUtils.writeToParcel(this.f390i, parcel, i10);
        parcel.writeParcelable(this.f391j, i10);
        parcel.writeParcelable(this.f392k, i10);
        parcel.writeBundle(this.f393l);
        parcel.writeParcelable(this.f394m, i10);
    }
}
