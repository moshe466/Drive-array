package g1;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final String f4695a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f4696b;

    public i(String str, ArrayList arrayList) {
        this.f4695a = str;
        this.f4696b = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof i) {
                i iVar = (i) obj;
                if (!this.f4695a.equals(iVar.f4695a) || !this.f4696b.equals(iVar.f4696b)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f4696b.hashCode() + (this.f4695a.hashCode() * 31);
    }

    public final String toString() {
        return "MediaCodecInfo(name=" + this.f4695a + ", capabilities=" + this.f4696b + ')';
    }
}
