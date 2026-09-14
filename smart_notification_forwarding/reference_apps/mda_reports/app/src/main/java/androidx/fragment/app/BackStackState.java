package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() { // from class: androidx.fragment.app.BackStackState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final int[] a;
    final ArrayList<String> b;
    final int[] c;
    final int[] d;
    final int e;
    final int f;
    final String g;
    final int h;
    final int i;
    final CharSequence j;
    final int k;
    final CharSequence l;
    final ArrayList<String> m;
    final ArrayList<String> n;
    final boolean o;

    public BackStackState(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.createStringArrayList();
        this.c = parcel.createIntArray();
        this.d = parcel.createIntArray();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.k = parcel.readInt();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }

    public BackStackState(BackStackRecord backStackRecord) {
        int size = backStackRecord.a.size();
        this.a = new int[size * 5];
        if (!backStackRecord.h) {
            throw new IllegalStateException("Not on back stack");
        }
        this.b = new ArrayList<>(size);
        this.c = new int[size];
        this.d = new int[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            FragmentTransaction.Op op = backStackRecord.a.get(i);
            int i3 = i2 + 1;
            this.a[i2] = op.a;
            ArrayList<String> arrayList = this.b;
            Fragment fragment = op.b;
            arrayList.add(fragment != null ? fragment.f : null);
            int[] iArr = this.a;
            int i4 = i3 + 1;
            iArr[i3] = op.c;
            int i5 = i4 + 1;
            iArr[i4] = op.d;
            int i6 = i5 + 1;
            iArr[i5] = op.e;
            iArr[i6] = op.f;
            this.c[i] = op.g.ordinal();
            this.d[i] = op.h.ordinal();
            i++;
            i2 = i6 + 1;
        }
        this.e = backStackRecord.f;
        this.f = backStackRecord.g;
        this.g = backStackRecord.j;
        this.h = backStackRecord.u;
        this.i = backStackRecord.k;
        this.j = backStackRecord.l;
        this.k = backStackRecord.m;
        this.l = backStackRecord.n;
        this.m = backStackRecord.o;
        this.n = backStackRecord.p;
        this.o = backStackRecord.q;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManagerImpl fragmentManagerImpl) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManagerImpl);
        int i = 0;
        int i2 = 0;
        while (i < this.a.length) {
            FragmentTransaction.Op op = new FragmentTransaction.Op();
            int i3 = i + 1;
            op.a = this.a[i];
            if (FragmentManagerImpl.C) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i2 + " base fragment #" + this.a[i3]);
            }
            String str = this.b.get(i2);
            op.b = str != null ? fragmentManagerImpl.f.get(str) : null;
            op.g = Lifecycle.State.values()[this.c[i2]];
            op.h = Lifecycle.State.values()[this.d[i2]];
            int[] iArr = this.a;
            int i4 = i3 + 1;
            op.c = iArr[i3];
            int i5 = i4 + 1;
            op.d = iArr[i4];
            int i6 = i5 + 1;
            op.e = iArr[i5];
            op.f = iArr[i6];
            backStackRecord.b = op.c;
            backStackRecord.c = op.d;
            backStackRecord.d = op.e;
            backStackRecord.e = op.f;
            backStackRecord.a(op);
            i2++;
            i = i6 + 1;
        }
        backStackRecord.f = this.e;
        backStackRecord.g = this.f;
        backStackRecord.j = this.g;
        backStackRecord.u = this.h;
        backStackRecord.h = true;
        backStackRecord.k = this.i;
        backStackRecord.l = this.j;
        backStackRecord.m = this.k;
        backStackRecord.n = this.l;
        backStackRecord.o = this.m;
        backStackRecord.p = this.n;
        backStackRecord.q = this.o;
        backStackRecord.a(1);
        return backStackRecord;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.a);
        parcel.writeStringList(this.b);
        parcel.writeIntArray(this.c);
        parcel.writeIntArray(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        TextUtils.writeToParcel(this.j, parcel, 0);
        parcel.writeInt(this.k);
        TextUtils.writeToParcel(this.l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }
}
