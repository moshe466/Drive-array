package com.google.gson;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class q extends k {

    /* renamed from: a, reason: collision with root package name */
    private final Object f7518a;

    public q(Boolean bool) {
        this.f7518a = z4.a.b(bool);
    }

    public q(Number number) {
        this.f7518a = z4.a.b(number);
    }

    public q(String str) {
        this.f7518a = z4.a.b(str);
    }

    private static boolean B(q qVar) {
        Object obj = qVar.f7518a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public boolean A() {
        return this.f7518a instanceof Boolean;
    }

    public boolean C() {
        return this.f7518a instanceof Number;
    }

    public boolean D() {
        return this.f7518a instanceof String;
    }

    @Override // com.google.gson.k
    public int c() {
        return C() ? z().intValue() : Integer.parseInt(s());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f7518a == null) {
            return qVar.f7518a == null;
        }
        if (B(this) && B(qVar)) {
            return z().longValue() == qVar.z().longValue();
        }
        Object obj2 = this.f7518a;
        if (!(obj2 instanceof Number) || !(qVar.f7518a instanceof Number)) {
            return obj2.equals(qVar.f7518a);
        }
        double doubleValue = z().doubleValue();
        double doubleValue2 = qVar.z().doubleValue();
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f7518a == null) {
            return 31;
        }
        if (B(this)) {
            doubleToLongBits = z().longValue();
        } else {
            Object obj = this.f7518a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(z().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    @Override // com.google.gson.k
    public long l() {
        return C() ? z().longValue() : Long.parseLong(s());
    }

    @Override // com.google.gson.k
    public String s() {
        return C() ? z().toString() : A() ? ((Boolean) this.f7518a).toString() : (String) this.f7518a;
    }

    public boolean x() {
        return A() ? ((Boolean) this.f7518a).booleanValue() : Boolean.parseBoolean(s());
    }

    public double y() {
        return C() ? z().doubleValue() : Double.parseDouble(s());
    }

    public Number z() {
        Object obj = this.f7518a;
        return obj instanceof String ? new z4.g((String) obj) : (Number) obj;
    }
}
