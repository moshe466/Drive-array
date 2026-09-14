package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f3839d;

    /* renamed from: e, reason: collision with root package name */
    private final Parcel f3840e;

    /* renamed from: f, reason: collision with root package name */
    private final int f3841f;

    /* renamed from: g, reason: collision with root package name */
    private final int f3842g;

    /* renamed from: h, reason: collision with root package name */
    private final String f3843h;

    /* renamed from: i, reason: collision with root package name */
    private int f3844i;

    /* renamed from: j, reason: collision with root package name */
    private int f3845j;

    /* renamed from: k, reason: collision with root package name */
    private int f3846k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new l.a(), new l.a(), new l.a());
    }

    private b(Parcel parcel, int i10, int i11, String str, l.a<String, Method> aVar, l.a<String, Method> aVar2, l.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f3839d = new SparseIntArray();
        this.f3844i = -1;
        this.f3845j = 0;
        this.f3846k = -1;
        this.f3840e = parcel;
        this.f3841f = i10;
        this.f3842g = i11;
        this.f3845j = i10;
        this.f3843h = str;
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f3840e.writeInt(-1);
        } else {
            this.f3840e.writeInt(bArr.length);
            this.f3840e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f3840e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i10) {
        this.f3840e.writeInt(i10);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f3840e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f3840e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i10 = this.f3844i;
        if (i10 >= 0) {
            int i11 = this.f3839d.get(i10);
            int dataPosition = this.f3840e.dataPosition();
            this.f3840e.setDataPosition(i11);
            this.f3840e.writeInt(dataPosition - i11);
            this.f3840e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f3840e;
        int dataPosition = parcel.dataPosition();
        int i10 = this.f3845j;
        if (i10 == this.f3841f) {
            i10 = this.f3842g;
        }
        return new b(parcel, dataPosition, i10, this.f3843h + "  ", this.f3836a, this.f3837b, this.f3838c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f3840e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int readInt = this.f3840e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f3840e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f3840e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i10) {
        while (this.f3845j < this.f3842g) {
            int i11 = this.f3846k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f3840e.setDataPosition(this.f3845j);
            int readInt = this.f3840e.readInt();
            this.f3846k = this.f3840e.readInt();
            this.f3845j += readInt;
        }
        return this.f3846k == i10;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f3840e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T q() {
        return (T) this.f3840e.readParcelable(b.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f3840e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i10) {
        a();
        this.f3844i = i10;
        this.f3839d.put(i10, this.f3840e.dataPosition());
        E(0);
        E(i10);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z10) {
        this.f3840e.writeInt(z10 ? 1 : 0);
    }
}
