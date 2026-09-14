package androidx.media;

import java.util.Arrays;

/* loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    int f3261a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f3262b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f3263c = 0;

    /* renamed from: d, reason: collision with root package name */
    int f3264d = -1;

    public int a() {
        return this.f3262b;
    }

    public int b() {
        int i10 = this.f3263c;
        int c10 = c();
        if (c10 == 6) {
            i10 |= 4;
        } else if (c10 == 7) {
            i10 |= 1;
        }
        return i10 & 273;
    }

    public int c() {
        int i10 = this.f3264d;
        return i10 != -1 ? i10 : AudioAttributesCompat.a(false, this.f3263c, this.f3261a);
    }

    public int d() {
        return this.f3261a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f3262b == audioAttributesImplBase.a() && this.f3263c == audioAttributesImplBase.b() && this.f3261a == audioAttributesImplBase.d() && this.f3264d == audioAttributesImplBase.f3264d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3262b), Integer.valueOf(this.f3263c), Integer.valueOf(this.f3261a), Integer.valueOf(this.f3264d)});
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AudioAttributesCompat:");
        if (this.f3264d != -1) {
            sb2.append(" stream=");
            sb2.append(this.f3264d);
            sb2.append(" derived");
        }
        sb2.append(" usage=");
        sb2.append(AudioAttributesCompat.b(this.f3261a));
        sb2.append(" content=");
        sb2.append(this.f3262b);
        sb2.append(" flags=0x");
        sb2.append(Integer.toHexString(this.f3263c).toUpperCase());
        return sb2.toString();
    }
}
