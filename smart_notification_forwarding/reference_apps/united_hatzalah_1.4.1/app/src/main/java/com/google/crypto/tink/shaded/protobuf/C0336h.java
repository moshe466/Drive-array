package com.google.crypto.tink.shaded.protobuf;

import F0.AbstractC0008a;
import androidx.datastore.preferences.protobuf.C0237d;
import java.util.Iterator;

/* renamed from: com.google.crypto.tink.shaded.protobuf.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0336h extends AbstractC0337i {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f4105d;

    public C0336h(byte[] bArr) {
        this.f4109a = 0;
        bArr.getClass();
        this.f4105d = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if ((obj instanceof AbstractC0337i) && size() == ((AbstractC0337i) obj).size()) {
                if (size() != 0) {
                    if (obj instanceof C0336h) {
                        C0336h c0336h = (C0336h) obj;
                        int i = this.f4109a;
                        int i3 = c0336h.f4109a;
                        if (i == 0 || i3 == 0 || i == i3) {
                            int size = size();
                            if (size <= c0336h.size()) {
                                if (size <= c0336h.size()) {
                                    byte[] bArr = c0336h.f4105d;
                                    int l3 = l() + size;
                                    int l4 = l();
                                    int l5 = c0336h.l();
                                    while (l4 < l3) {
                                        if (this.f4105d[l4] != bArr[l5]) {
                                            return false;
                                        }
                                        l4++;
                                        l5++;
                                    }
                                    return true;
                                }
                                StringBuilder w3 = AbstractC0008a.w(size, "Ran off end of other: 0, ", ", ");
                                w3.append(c0336h.size());
                                throw new IllegalArgumentException(w3.toString());
                            }
                            throw new IllegalArgumentException("Length too large: " + size + size());
                        }
                        return false;
                    }
                    return obj.equals(this);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0337i
    public byte g(int i) {
        return this.f4105d[i];
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C0237d(this);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0337i
    public void j(byte[] bArr, int i) {
        System.arraycopy(this.f4105d, 0, bArr, 0, i);
    }

    public int l() {
        return 0;
    }

    public byte m(int i) {
        return this.f4105d[i];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0337i
    public int size() {
        return this.f4105d.length;
    }
}
