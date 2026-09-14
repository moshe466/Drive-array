package S0;

import F0.AbstractC0008a;
import F0.C0019c2;
import F0.C0035g2;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1DecodingException;
import com.android.apksig.internal.asn1.Asn1Field;
import com.android.apksig.internal.asn1.ber.BerDataValueFormatException;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f2079a = new byte[0];

    public static Class a(Field field) {
        String typeName;
        typeName = field.getGenericType().getTypeName();
        int indexOf = typeName.indexOf(60);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = typeName.indexOf(62, i);
            if (indexOf2 != -1) {
                return Class.forName(typeName.substring(i, indexOf2));
            }
            throw new Exception("Not a container type: " + field.getGenericType());
        }
        throw new Exception("Not a container type: " + field.getGenericType());
    }

    public static Object b(j jVar, T0.a aVar, Class cls) {
        if (ByteBuffer.class.equals(cls)) {
            return ((ByteBuffer) aVar.f2270d).slice();
        }
        if (byte[].class.equals(cls)) {
            ByteBuffer slice = ((ByteBuffer) aVar.f2270d).slice();
            if (!slice.hasRemaining()) {
                return f2079a;
            }
            byte[] bArr = new byte[slice.remaining()];
            slice.get(bArr);
            return bArr;
        }
        if (g.class.equals(cls)) {
            return new g(((ByteBuffer) aVar.f2269c).slice());
        }
        ByteBuffer slice2 = ((ByteBuffer) aVar.f2270d).slice();
        int ordinal = jVar.ordinal();
        boolean z3 = true;
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 5) {
                        switch (ordinal) {
                            case 9:
                            case 10:
                                if (String.class.equals(cls)) {
                                    byte[] bArr2 = new byte[slice2.remaining()];
                                    slice2.get(bArr2);
                                    return new String(bArr2);
                                }
                                break;
                            case 11:
                                if (Boolean.TYPE.equals(cls)) {
                                    if (slice2.remaining() == 1) {
                                        if (slice2.get() == 0) {
                                            z3 = false;
                                        }
                                        return new Boolean(z3);
                                    }
                                    throw new Exception("Incorrect encoded size of boolean value: " + slice2.remaining());
                                }
                                break;
                        }
                    } else {
                        Asn1Class asn1Class = (Asn1Class) cls.getDeclaredAnnotation(Asn1Class.class);
                        if (asn1Class != null && asn1Class.type() == j.f2104f) {
                            return i(aVar, cls, false);
                        }
                    }
                } else if (String.class.equals(cls)) {
                    if (slice2.hasRemaining()) {
                        long c4 = c(slice2);
                        int min = (int) Math.min(c4 / 40, 2L);
                        StringBuilder sb = new StringBuilder();
                        sb.append(Long.toString(min));
                        sb.append('.');
                        sb.append(Long.toString(c4 - (min * 40)));
                        while (slice2.hasRemaining()) {
                            long c5 = c(slice2);
                            sb.append('.');
                            sb.append(Long.toString(c5));
                        }
                        return sb.toString();
                    }
                    throw new Exception("Empty OBJECT IDENTIFIER");
                }
            } else if (!Integer.TYPE.equals(cls) && !Integer.class.equals(cls)) {
                if (!Long.TYPE.equals(cls) && !Long.class.equals(cls)) {
                    if (BigInteger.class.equals(cls)) {
                        return e(slice2);
                    }
                } else {
                    BigInteger e4 = e(slice2);
                    if (e4.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) >= 0 && e4.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
                        return Long.valueOf(e4.longValue());
                    }
                    throw new Exception(String.format("INTEGER cannot be represented as long: %1$d (0x%1$x)", e4));
                }
            } else {
                BigInteger e5 = e(slice2);
                if (e5.compareTo(BigInteger.valueOf(-2147483648L)) >= 0 && e5.compareTo(BigInteger.valueOf(2147483647L)) <= 0) {
                    return Integer.valueOf(e5.intValue());
                }
                throw new Exception(String.format("INTEGER cannot be represented as int: %1$d (0x%1$x)", e5));
            }
        } else {
            Asn1Class asn1Class2 = (Asn1Class) cls.getDeclaredAnnotation(Asn1Class.class);
            if (asn1Class2 != null && asn1Class2.type() == j.f2100b) {
                return h(aVar, cls);
            }
        }
        throw new Exception("Unsupported conversion: ASN.1 " + jVar + " to " + cls.getName());
    }

    public static long c(ByteBuffer byteBuffer) {
        long j2 = 0;
        if (!byteBuffer.hasRemaining()) {
            return 0L;
        }
        while (byteBuffer.hasRemaining()) {
            if (j2 <= 72057594037927935L) {
                j2 = (j2 << 7) | (r0 & Byte.MAX_VALUE);
                if ((byteBuffer.get() & 128) == 0) {
                    return j2;
                }
            } else {
                throw new Exception("Base-128 number too large");
            }
        }
        throw new Exception("Truncated base-128 encoded input: missing terminating byte, with highest bit not set");
    }

    public static ArrayList d(Class cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        ArrayList arrayList = new ArrayList(declaredFields.length);
        for (Field field : declaredFields) {
            Asn1Field asn1Field = (Asn1Field) field.getDeclaredAnnotation(Asn1Field.class);
            if (asn1Field != null) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    try {
                        arrayList.add(new a(field, asn1Field));
                    } catch (Asn1DecodingException e4) {
                        throw new Exception("Invalid ASN.1 annotation on " + cls.getName() + "." + field.getName(), e4);
                    }
                } else {
                    throw new Exception(Asn1Field.class.getName() + " used on a static field: " + cls.getName() + "." + field.getName());
                }
            }
        }
        return arrayList;
    }

    public static BigInteger e(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return BigInteger.ZERO;
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new BigInteger(bArr);
    }

    public static Object f(T0.a aVar, Class cls) {
        int i = aVar.f2268b;
        int i3 = aVar.f2267a;
        Asn1Class asn1Class = (Asn1Class) cls.getDeclaredAnnotation(Asn1Class.class);
        if (asn1Class != null) {
            int ordinal = asn1Class.type().ordinal();
            if (ordinal != 1 && ordinal != 5 && ordinal != 12) {
                throw new Exception("Unsupported ASN.1 container annotation type: " + asn1Class.type());
            }
            j type = asn1Class.type();
            int ordinal2 = type.ordinal();
            if (ordinal2 != 1) {
                if (ordinal2 != 5) {
                    if (ordinal2 == 12) {
                        return i(aVar, cls, true);
                    }
                    throw new Exception("Parsing container " + type + " not supported");
                }
                int s3 = p3.h.s(type);
                if (i3 == 0 && i == s3) {
                    return i(aVar, cls, false);
                }
                throw new Exception("Unexpected data value read as " + cls.getName() + ". Expected " + p3.h.F(0, s3) + ", but read: " + p3.h.F(i3, i));
            }
            return h(aVar, cls);
        }
        throw new Exception(cls.getName() + " is not annotated with " + Asn1Class.class.getName());
    }

    public static Object g(ByteBuffer byteBuffer, Class cls) {
        try {
            T0.a t3 = new C0035g2(byteBuffer).t();
            if (t3 != null) {
                return f(t3, cls);
            }
            throw new Exception("Empty input");
        } catch (BerDataValueFormatException e4) {
            throw new Exception("Failed to decode top-level data value", e4);
        }
    }

    public static Object h(T0.a aVar, Class cls) {
        ArrayList d2 = d(cls);
        if (!d2.isEmpty()) {
            int i = 0;
            int i3 = 0;
            while (i3 < d2.size() - 1) {
                a aVar2 = (a) d2.get(i3);
                int i4 = aVar2.f2076e;
                int i5 = aVar2.f2075d;
                i3++;
                for (int i6 = i3; i6 < d2.size(); i6++) {
                    a aVar3 = (a) d2.get(i6);
                    int i7 = aVar3.f2076e;
                    int i8 = aVar3.f2075d;
                    if (i4 == i7 && i5 == i8) {
                        throw new Exception("CHOICE fields are indistinguishable because they have the same tag class and number: " + cls.getName() + "." + aVar2.f2072a.getName() + " and ." + aVar3.f2072a.getName());
                    }
                }
            }
            try {
                Object newInstance = cls.getConstructor(null).newInstance(null);
                int size = d2.size();
                while (i < size) {
                    Object obj = d2.get(i);
                    i++;
                    try {
                        ((a) obj).a(aVar, newInstance);
                        return newInstance;
                    } catch (b unused) {
                    }
                }
                throw new Exception("No options of CHOICE " + cls.getName() + " matched");
            } catch (IllegalArgumentException | ReflectiveOperationException e4) {
                throw new Exception("Failed to instantiate ".concat(cls.getName()), e4);
            }
        }
        throw new Exception("No fields annotated with " + Asn1Field.class.getName() + " in CHOICE class " + cls.getName());
    }

    public static Object i(T0.a aVar, Class cls, boolean z3) {
        T0.a t3;
        ArrayList d2 = d(cls);
        Collections.sort(d2, new C0019c2(3));
        int i = 0;
        if (d2.size() > 1) {
            int size = d2.size();
            int i3 = 0;
            a aVar2 = null;
            while (i3 < size) {
                Object obj = d2.get(i3);
                i3++;
                a aVar3 = (a) obj;
                if (aVar2 != null && aVar2.f2073b.index() == aVar3.f2073b.index()) {
                    throw new Exception("Fields have the same index: " + cls.getName() + "." + aVar2.f2072a.getName() + " and ." + aVar3.f2072a.getName());
                }
                aVar2 = aVar3;
            }
        }
        try {
            Object newInstance = cls.getConstructor(null).newInstance(null);
            C0035g2 c0035g2 = new C0035g2(((ByteBuffer) aVar.f2270d).slice());
            while (i < d2.size()) {
                if (z3 && i == 0) {
                    t3 = aVar;
                } else {
                    try {
                        t3 = c0035g2.t();
                    } catch (BerDataValueFormatException e4) {
                        throw new Exception("Malformed data value", e4);
                    }
                }
                if (t3 == null) {
                    break;
                }
                for (int i4 = i; i4 < d2.size(); i4++) {
                    a aVar4 = (a) d2.get(i4);
                    try {
                        if (aVar4.f2078g) {
                            try {
                                aVar4.a(t3, newInstance);
                            } catch (b unused) {
                            }
                        } else {
                            aVar4.a(t3, newInstance);
                        }
                        i = i4 + 1;
                        break;
                    } catch (Asn1DecodingException e5) {
                        throw new Exception("Failed to parse " + cls.getName() + "." + aVar4.f2072a.getName(), e5);
                    }
                }
            }
            return newInstance;
        } catch (IllegalArgumentException | ReflectiveOperationException e6) {
            throw new Exception("Failed to instantiate ".concat(cls.getName()), e6);
        }
    }

    public static ArrayList j(T0.a aVar, Class cls) {
        Object f4;
        ArrayList arrayList = new ArrayList();
        C0035g2 c0035g2 = new C0035g2(((ByteBuffer) aVar.f2270d).slice());
        while (true) {
            try {
                T0.a t3 = c0035g2.t();
                if (t3 == null) {
                    return arrayList;
                }
                if (ByteBuffer.class.equals(cls)) {
                    f4 = ((ByteBuffer) t3.f2270d).slice();
                } else if (g.class.equals(cls)) {
                    f4 = new g(((ByteBuffer) t3.f2269c).slice());
                } else {
                    f4 = f(t3, cls);
                }
                arrayList.add(f4);
            } catch (BerDataValueFormatException e4) {
                throw new Exception("Malformed data value", e4);
            }
        }
    }

    public static byte[] k(Object obj, j jVar, j jVar2) {
        byte[] bArr;
        Class<?> cls = obj.getClass();
        if (g.class.equals(cls)) {
            ByteBuffer slice = ((g) obj).f2090a.slice();
            byte[] bArr2 = new byte[slice.remaining()];
            slice.get(bArr2);
            return bArr2;
        }
        if (jVar != null && jVar != j.f2099a) {
            switch (jVar.ordinal()) {
                case 1:
                    Asn1Class asn1Class = (Asn1Class) cls.getDeclaredAnnotation(Asn1Class.class);
                    if (asn1Class != null && asn1Class.type() == j.f2100b) {
                        return f.e(obj);
                    }
                    break;
                case 2:
                    if (obj instanceof Integer) {
                        long intValue = ((Integer) obj).intValue();
                        g gVar = f.f2089a;
                        return f.a(0, false, 2, BigInteger.valueOf(intValue).toByteArray());
                    }
                    if (obj instanceof Long) {
                        long longValue = ((Long) obj).longValue();
                        g gVar2 = f.f2089a;
                        return f.a(0, false, 2, BigInteger.valueOf(longValue).toByteArray());
                    }
                    if (obj instanceof BigInteger) {
                        g gVar3 = f.f2089a;
                        return f.a(0, false, 2, ((BigInteger) obj).toByteArray());
                    }
                    break;
                case 3:
                    if (obj instanceof String) {
                        String str = (String) obj;
                        g gVar4 = f.f2089a;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        String[] split = str.split("\\.");
                        if (split.length >= 2) {
                            try {
                                int parseInt = Integer.parseInt(split[0]);
                                if (parseInt <= 6 && parseInt >= 0) {
                                    try {
                                        int parseInt2 = Integer.parseInt(split[1]);
                                        if (parseInt2 < 40 && parseInt2 >= 0) {
                                            int i = (parseInt * 40) + parseInt2;
                                            if (i <= 255) {
                                                byteArrayOutputStream.write(i);
                                                for (int i3 = 2; i3 < split.length; i3++) {
                                                    String str2 = split[i3];
                                                    try {
                                                        int parseInt3 = Integer.parseInt(str2);
                                                        if (parseInt3 >= 0) {
                                                            if (parseInt3 <= 127) {
                                                                byteArrayOutputStream.write(parseInt3);
                                                            } else if (parseInt3 < 16384) {
                                                                byteArrayOutputStream.write((parseInt3 >> 7) | 128);
                                                                byteArrayOutputStream.write(parseInt3 & 127);
                                                            } else if (parseInt3 < 2097152) {
                                                                byteArrayOutputStream.write((parseInt3 >> 14) | 128);
                                                                byteArrayOutputStream.write((127 & (parseInt3 >> 7)) | 128);
                                                                byteArrayOutputStream.write(parseInt3 & 127);
                                                            } else {
                                                                throw new Exception("Node #" + (i3 + 1) + " too large: " + parseInt3);
                                                            }
                                                        } else {
                                                            throw new Exception("Invalid value for node #" + (i3 + 1) + ": " + parseInt3);
                                                        }
                                                    } catch (NumberFormatException unused) {
                                                        throw new Exception("Node #" + (i3 + 1) + " not numeric: " + str2);
                                                    }
                                                }
                                                return f.a(0, false, 6, byteArrayOutputStream.toByteArray());
                                            }
                                            throw new Exception(AbstractC0008a.k("First two nodes out of range: ", parseInt, parseInt2, "."));
                                        }
                                        throw new Exception(e0.a.c(parseInt2, "Invalid value for node #2: "));
                                    } catch (NumberFormatException unused2) {
                                        throw new Exception("Node #2 not numeric: " + split[1]);
                                    }
                                }
                                throw new Exception(e0.a.c(parseInt, "Invalid value for node #1: "));
                            } catch (NumberFormatException unused3) {
                                throw new Exception("Node #1 not numeric: " + split[0]);
                            }
                        }
                        throw new Exception("OBJECT IDENTIFIER must contain at least two nodes: ".concat(str));
                    }
                    break;
                case 4:
                case 8:
                    if (obj instanceof ByteBuffer) {
                        ByteBuffer byteBuffer = (ByteBuffer) obj;
                        bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.slice().get(bArr);
                    } else if (obj instanceof byte[]) {
                        bArr = (byte[]) obj;
                    } else {
                        bArr = null;
                    }
                    if (bArr != null) {
                        return f.a(0, false, p3.h.s(jVar), bArr);
                    }
                    break;
                case 5:
                    Asn1Class asn1Class2 = (Asn1Class) cls.getDeclaredAnnotation(Asn1Class.class);
                    if (asn1Class2 != null && asn1Class2.type() == j.f2104f) {
                        return f.f(obj, false);
                    }
                    break;
                case 6:
                    return f.g((Collection) obj, jVar2, false);
                case 7:
                    return f.g((Collection) obj, jVar2, true);
                case 9:
                case 10:
                    if (obj instanceof String) {
                        return f.a(0, false, p3.h.s(jVar), ((String) obj).getBytes());
                    }
                    break;
                case 11:
                    if (obj instanceof Boolean) {
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        g gVar5 = f.f2089a;
                        byte[] bArr3 = new byte[1];
                        if (!booleanValue) {
                            bArr3[0] = 0;
                        } else {
                            bArr3[0] = 1;
                        }
                        return f.a(0, false, 1, bArr3);
                    }
                    break;
            }
            throw new Exception("Unsupported conversion: " + cls.getName() + " to ASN.1 " + jVar);
        }
        return f.b(obj);
    }
}
