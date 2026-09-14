package z4;

import java.math.BigDecimal;

/* loaded from: classes.dex */
public final class g extends Number {

    /* renamed from: f, reason: collision with root package name */
    private final String f16192f;

    public g(String str) {
        this.f16192f = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f16192f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        String str = this.f16192f;
        String str2 = ((g) obj).f16192f;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f16192f);
    }

    public int hashCode() {
        return this.f16192f.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f16192f);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f16192f);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f16192f).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f16192f);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f16192f).longValue();
        }
    }

    public String toString() {
        return this.f16192f;
    }
}
