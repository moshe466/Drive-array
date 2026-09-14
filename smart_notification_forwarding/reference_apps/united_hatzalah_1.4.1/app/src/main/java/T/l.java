package T;

import androidx.datastore.preferences.protobuf.AbstractC0251s;
import androidx.datastore.preferences.protobuf.AbstractC0253u;
import androidx.datastore.preferences.protobuf.C0240g;
import androidx.datastore.preferences.protobuf.N;
import androidx.datastore.preferences.protobuf.Q;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes.dex */
public final class l extends AbstractC0253u {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    public static final int BYTES_FIELD_NUMBER = 8;
    private static final l DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile N PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int valueCase_ = 0;
    private Object value_;

    static {
        l lVar = new l();
        DEFAULT_INSTANCE = lVar;
        AbstractC0253u.j(l.class, lVar);
    }

    public static j D() {
        return (j) ((AbstractC0251s) DEFAULT_INSTANCE.c(5));
    }

    public static void l(l lVar, long j2) {
        lVar.valueCase_ = 4;
        lVar.value_ = Long.valueOf(j2);
    }

    public static void m(l lVar, String str) {
        lVar.getClass();
        str.getClass();
        lVar.valueCase_ = 5;
        lVar.value_ = str;
    }

    public static void n(l lVar, i iVar) {
        lVar.getClass();
        lVar.value_ = iVar;
        lVar.valueCase_ = 6;
    }

    public static void o(l lVar, double d2) {
        lVar.valueCase_ = 7;
        lVar.value_ = Double.valueOf(d2);
    }

    public static void p(l lVar, C0240g c0240g) {
        lVar.getClass();
        lVar.valueCase_ = 8;
        lVar.value_ = c0240g;
    }

    public static void q(l lVar, boolean z3) {
        lVar.valueCase_ = 1;
        lVar.value_ = Boolean.valueOf(z3);
    }

    public static void r(l lVar, float f4) {
        lVar.valueCase_ = 2;
        lVar.value_ = Float.valueOf(f4);
    }

    public static void s(l lVar, int i) {
        lVar.valueCase_ = 3;
        lVar.value_ = Integer.valueOf(i);
    }

    public static l v() {
        return DEFAULT_INSTANCE;
    }

    public final String A() {
        if (this.valueCase_ == 5) {
            return (String) this.value_;
        }
        return "";
    }

    public final i B() {
        if (this.valueCase_ == 6) {
            return (i) this.value_;
        }
        return i.m();
    }

    public final int C() {
        switch (this.valueCase_) {
            case 0:
                return 9;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            default:
                return 0;
        }
    }

    /* JADX WARN: Type inference failed for: r4v14, types: [androidx.datastore.preferences.protobuf.N, java.lang.Object] */
    @Override // androidx.datastore.preferences.protobuf.AbstractC0253u
    public final Object c(int i) {
        N n4;
        switch (k.b(i)) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new Q(DEFAULT_INSTANCE, "\u0001\b\u0001\u0000\u0001\b\b\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000\b=\u0000", new Object[]{"value_", "valueCase_", i.class});
            case 3:
                return new l();
            case 4:
                return new AbstractC0251s(DEFAULT_INSTANCE);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                N n5 = PARSER;
                if (n5 == null) {
                    synchronized (l.class) {
                        try {
                            N n6 = PARSER;
                            n4 = n6;
                            if (n6 == null) {
                                ?? obj = new Object();
                                PARSER = obj;
                                n4 = obj;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return n4;
                }
                return n5;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final boolean t() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public final C0240g u() {
        if (this.valueCase_ == 8) {
            return (C0240g) this.value_;
        }
        return C0240g.f3173c;
    }

    public final double w() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public final float x() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public final int y() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public final long z() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }
}
