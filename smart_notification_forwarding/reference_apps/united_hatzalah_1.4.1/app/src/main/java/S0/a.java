package S0;

import F0.C0035g2;
import com.android.apksig.internal.asn1.Asn1Field;
import com.android.apksig.internal.asn1.ber.BerDataValueFormatException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Field f2072a;

    /* renamed from: b, reason: collision with root package name */
    public final Asn1Field f2073b;

    /* renamed from: c, reason: collision with root package name */
    public final j f2074c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2075d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2076e;

    /* renamed from: f, reason: collision with root package name */
    public final i f2077f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2078g;

    public a(Field field, Asn1Field asn1Field) {
        int i;
        this.f2072a = field;
        this.f2073b = asn1Field;
        j type = asn1Field.type();
        this.f2074c = type;
        h cls = asn1Field.cls();
        if (cls == h.f2093c) {
            if (asn1Field.tagNumber() != -1) {
                cls = h.f2092b;
            } else {
                cls = h.f2091a;
            }
        }
        this.f2075d = p3.h.r(cls);
        if (asn1Field.tagNumber() != -1) {
            i = asn1Field.tagNumber();
        } else if (type != j.f2100b && type != j.f2099a) {
            i = p3.h.s(type);
        } else {
            i = -1;
        }
        this.f2076e = i;
        i tagging = asn1Field.tagging();
        this.f2077f = tagging;
        if ((tagging != i.f2096b && tagging != i.f2097c) || asn1Field.tagNumber() != -1) {
            this.f2078g = asn1Field.optional();
        } else {
            throw new Exception("Tag number must be specified when tagging mode is " + tagging);
        }
    }

    public final void a(T0.a aVar, Object obj) {
        int i = aVar.f2267a;
        int i3 = this.f2075d;
        int i4 = this.f2076e;
        if (i4 != -1) {
            int i5 = aVar.f2268b;
            if (i != i3 || i5 != i4) {
                throw new Exception("Tag mismatch. Expected: " + p3.h.F(i3, i4) + ", but found " + p3.h.F(i, i5));
            }
        } else if (i != i3) {
            throw new Exception("Tag mismatch. Expected class: " + p3.h.G(i3) + ", but found " + p3.h.G(i));
        }
        if (this.f2077f == i.f2096b) {
            try {
                aVar = new C0035g2(((ByteBuffer) aVar.f2270d).slice()).t();
            } catch (BerDataValueFormatException e4) {
                throw new Exception("Failed to read contents of EXPLICIT data value", e4);
            }
        }
        Field field = this.f2072a;
        j jVar = this.f2074c;
        try {
            int ordinal = jVar.ordinal();
            if (ordinal != 6 && ordinal != 7) {
                field.set(obj, c.b(jVar, aVar, field.getType()));
            } else if (g.class.equals(field.getType())) {
                field.set(obj, c.b(jVar, aVar, field.getType()));
            } else {
                field.set(obj, c.j(aVar, c.a(field)));
            }
        } catch (ReflectiveOperationException e5) {
            throw new Exception("Failed to set value of " + obj.getClass().getName() + "." + field.getName(), e5);
        }
    }
}
