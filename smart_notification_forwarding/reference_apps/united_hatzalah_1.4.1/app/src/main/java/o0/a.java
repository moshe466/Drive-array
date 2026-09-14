package O0;

import N0.t;
import W0.e;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final e f1528a;

    /* renamed from: b, reason: collision with root package name */
    public final t f1529b;

    /* renamed from: c, reason: collision with root package name */
    public final t f1530c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f1531d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1532e;

    public a(e eVar, t tVar, t tVar2, byte[] bArr, int i) {
        this.f1528a = eVar;
        this.f1529b = tVar;
        this.f1530c = tVar2;
        this.f1531d = bArr;
        this.f1532e = i;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (!this.f1528a.equals(aVar.f1528a) || this.f1529b != aVar.f1529b || this.f1530c != aVar.f1530c || !Arrays.equals(this.f1531d, aVar.f1531d) || this.f1532e != aVar.f1532e) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = (this.f1528a.hashCode() + 31) * 31;
        int i = 0;
        t tVar = this.f1529b;
        if (tVar == null) {
            hashCode = 0;
        } else {
            hashCode = tVar.hashCode();
        }
        int i3 = (hashCode2 + hashCode) * 31;
        t tVar2 = this.f1530c;
        if (tVar2 != null) {
            i = tVar2.hashCode();
        }
        return ((Arrays.hashCode(this.f1531d) + ((i3 + i) * 31)) * 31) + this.f1532e;
    }
}
