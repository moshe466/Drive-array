package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() { // from class: androidx.fragment.app.FragmentState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    };
    final String a;
    final String b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final boolean i;
    final Bundle j;
    final boolean k;
    final int l;
    Bundle m;
    Fragment n;

    FragmentState(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt() != 0;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt() != 0;
        this.j = parcel.readBundle();
        this.k = parcel.readInt() != 0;
        this.m = parcel.readBundle();
        this.l = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentState(Fragment fragment) {
        this.a = fragment.getClass().getName();
        this.b = fragment.f;
        this.c = fragment.m;
        this.d = fragment.w;
        this.e = fragment.x;
        this.f = fragment.y;
        this.g = fragment.B;
        this.h = fragment.l;
        this.i = fragment.A;
        this.j = fragment.g;
        this.k = fragment.z;
        this.l = fragment.R.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull FragmentFactory fragmentFactory) {
        Fragment fragment;
        Bundle bundle;
        if (this.n == null) {
            Bundle bundle2 = this.j;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
            }
            this.n = fragmentFactory.instantiate(classLoader, this.a);
            this.n.setArguments(this.j);
            Bundle bundle3 = this.m;
            if (bundle3 != null) {
                bundle3.setClassLoader(classLoader);
                fragment = this.n;
                bundle = this.m;
            } else {
                fragment = this.n;
                bundle = new Bundle();
            }
            fragment.c = bundle;
            Fragment fragment2 = this.n;
            fragment2.f = this.b;
            fragment2.m = this.c;
            fragment2.o = true;
            fragment2.w = this.d;
            fragment2.x = this.e;
            fragment2.y = this.f;
            fragment2.B = this.g;
            fragment2.l = this.h;
            fragment2.A = this.i;
            fragment2.z = this.k;
            fragment2.R = Lifecycle.State.values()[this.l];
            if (FragmentManagerImpl.C) {
                Log.v("FragmentManager", "Instantiated fragment " + this.n);
            }
        }
        return this.n;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.a);
        sb.append(" (");
        sb.append(this.b);
        sb.append(")}:");
        if (this.c) {
            sb.append(" fromLayout");
        }
        if (this.e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.e));
        }
        String str = this.f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f);
        }
        if (this.g) {
            sb.append(" retainInstance");
        }
        if (this.h) {
            sb.append(" removing");
        }
        if (this.i) {
            sb.append(" detached");
        }
        if (this.k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeBundle(this.j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeBundle(this.m);
        parcel.writeInt(this.l);
    }
}
