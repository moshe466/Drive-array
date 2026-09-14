package t2;

import java.util.RandomAccess;

/* renamed from: t2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0706h extends AbstractC0701c implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f6473a;

    public C0706h(byte[] bArr) {
        this.f6473a = bArr;
    }

    @Override // t2.AbstractC0701c, java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Byte) {
            byte byteValue = ((Number) obj).byteValue();
            byte[] bArr = this.f6473a;
            int length = bArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    if (byteValue == bArr[i]) {
                        break;
                    }
                    i++;
                } else {
                    i = -1;
                    break;
                }
            }
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    @Override // t2.AbstractC0701c
    public final int g() {
        return this.f6473a.length;
    }

    @Override // java.util.List
    public final Object get(int i) {
        return Byte.valueOf(this.f6473a[i]);
    }

    @Override // t2.AbstractC0701c, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Byte)) {
            return -1;
        }
        byte byteValue = ((Number) obj).byteValue();
        byte[] bArr = this.f6473a;
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (byteValue == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    @Override // t2.AbstractC0701c, java.util.List, java.util.Collection
    public final boolean isEmpty() {
        if (this.f6473a.length == 0) {
            return true;
        }
        return false;
    }

    @Override // t2.AbstractC0701c, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Byte)) {
            return -1;
        }
        byte byteValue = ((Number) obj).byteValue();
        byte[] bArr = this.f6473a;
        kotlin.jvm.internal.j.e(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (byteValue == bArr[length]) {
                    return length;
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return -1;
    }
}
