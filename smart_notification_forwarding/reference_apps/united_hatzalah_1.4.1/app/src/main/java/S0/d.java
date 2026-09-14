package S0;

import com.android.apksig.internal.asn1.Asn1Field;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Field f2080a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2081b;

    /* renamed from: c, reason: collision with root package name */
    public final Asn1Field f2082c;

    /* renamed from: d, reason: collision with root package name */
    public final j f2083d;

    /* renamed from: e, reason: collision with root package name */
    public final j f2084e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2085f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2086g;

    /* renamed from: h, reason: collision with root package name */
    public final i f2087h;
    public final boolean i;

    public d(Object obj, Field field, Asn1Field asn1Field) {
        int i;
        this.f2081b = obj;
        this.f2080a = field;
        this.f2082c = asn1Field;
        j type = asn1Field.type();
        this.f2083d = type;
        this.f2084e = asn1Field.elementType();
        h cls = asn1Field.cls();
        if (cls == h.f2093c) {
            if (asn1Field.tagNumber() != -1) {
                cls = h.f2092b;
            } else {
                cls = h.f2091a;
            }
        }
        this.f2085f = p3.h.r(cls);
        if (asn1Field.tagNumber() != -1) {
            i = asn1Field.tagNumber();
        } else if (type != j.f2100b && type != j.f2099a) {
            i = p3.h.s(type);
        } else {
            i = -1;
        }
        this.f2086g = i;
        i tagging = asn1Field.tagging();
        this.f2087h = tagging;
        if ((tagging != i.f2096b && tagging != i.f2097c) || asn1Field.tagNumber() != -1) {
            this.i = asn1Field.optional();
        } else {
            throw new Exception("Tag number must be specified when tagging mode is " + tagging);
        }
    }

    public final byte[] a() {
        Object d2 = f.d(this.f2081b, this.f2080a);
        if (d2 == null) {
            if (this.i) {
                return null;
            }
            throw new Exception("Required field not set");
        }
        byte[] k4 = c.k(d2, this.f2083d, this.f2084e);
        i iVar = this.f2087h;
        int ordinal = iVar.ordinal();
        if (ordinal != 0) {
            int i = this.f2085f;
            int i3 = this.f2086g;
            if (ordinal != 1) {
                if (ordinal == 2) {
                    byte b4 = k4[0];
                    if ((b4 & 31) != 31) {
                        if (i3 < 31) {
                            byte b5 = (byte) ((b4 & (-32)) | i3);
                            k4[0] = b5;
                            k4[0] = (byte) ((b5 & 63) | (i << 6));
                            return k4;
                        }
                        throw new Exception("Unsupported high tag number: " + i3);
                    }
                    throw new Exception("High-tag-number form not supported");
                }
                throw new RuntimeException("Unknown tagging mode: " + iVar);
            }
            return f.a(i, true, i3, k4);
        }
        return k4;
    }
}
