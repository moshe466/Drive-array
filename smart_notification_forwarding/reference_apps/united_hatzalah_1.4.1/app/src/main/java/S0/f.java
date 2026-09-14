package S0;

import F0.C0019c2;
import com.android.apksig.internal.asn1.Asn1Class;
import com.android.apksig.internal.asn1.Asn1EncodingException;
import com.android.apksig.internal.asn1.Asn1Field;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final g f2089a = new g(new byte[]{5, 0});

    public static byte[] a(int i, boolean z3, int i3, byte[]... bArr) {
        int i4;
        byte[] bArr2;
        if (i3 < 31) {
            int i5 = 6;
            int i6 = i << 6;
            if (z3) {
                i4 = 32;
            } else {
                i4 = 0;
            }
            byte b4 = (byte) (i6 | i4 | i3);
            int i7 = 0;
            for (byte[] bArr3 : bArr) {
                i7 += bArr3.length;
            }
            int i8 = 2;
            if (i7 < 128) {
                bArr2 = new byte[i7 + 2];
                bArr2[0] = b4;
                bArr2[1] = (byte) i7;
            } else {
                if (i7 <= 255) {
                    byte[] bArr4 = new byte[i7 + 3];
                    bArr4[1] = -127;
                    bArr4[2] = (byte) i7;
                    i5 = 3;
                    bArr2 = bArr4;
                } else if (i7 <= 65535) {
                    byte[] bArr5 = new byte[i7 + 4];
                    bArr5[1] = -126;
                    bArr5[2] = (byte) (i7 >> 8);
                    bArr5[3] = (byte) (i7 & 255);
                    bArr2 = bArr5;
                    i5 = 4;
                } else if (i7 <= 16777215) {
                    byte[] bArr6 = new byte[i7 + 5];
                    bArr6[1] = -125;
                    bArr6[2] = (byte) (i7 >> 16);
                    bArr6[3] = (byte) ((i7 >> 8) & 255);
                    bArr6[4] = (byte) (i7 & 255);
                    bArr2 = bArr6;
                    i5 = 5;
                } else {
                    byte[] bArr7 = new byte[i7 + 6];
                    bArr7[1] = -124;
                    bArr7[2] = (byte) (i7 >> 24);
                    bArr7[3] = (byte) ((i7 >> 16) & 255);
                    bArr7[4] = (byte) ((i7 >> 8) & 255);
                    bArr7[5] = (byte) (i7 & 255);
                    bArr2 = bArr7;
                }
                bArr2[0] = b4;
                i8 = i5;
            }
            for (byte[] bArr8 : bArr) {
                System.arraycopy(bArr8, 0, bArr2, i8, bArr8.length);
                i8 += bArr8.length;
            }
            return bArr2;
        }
        throw new IllegalArgumentException(e0.a.c(i3, "High tag numbers not supported: "));
    }

    public static byte[] b(Object obj) {
        Class<?> cls = obj.getClass();
        Asn1Class asn1Class = (Asn1Class) cls.getDeclaredAnnotation(Asn1Class.class);
        if (asn1Class != null) {
            j type = asn1Class.type();
            int ordinal = type.ordinal();
            if (ordinal != 1) {
                if (ordinal != 5) {
                    if (ordinal == 12) {
                        return f(obj, true);
                    }
                    throw new Exception("Unsupported container type: " + type);
                }
                return f(obj, false);
            }
            return e(obj);
        }
        throw new Exception(cls.getName() + " not annotated with " + Asn1Class.class.getName());
    }

    public static ArrayList c(Object obj) {
        Class<?> cls = obj.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        ArrayList arrayList = new ArrayList(declaredFields.length);
        for (Field field : declaredFields) {
            Asn1Field asn1Field = (Asn1Field) field.getDeclaredAnnotation(Asn1Field.class);
            if (asn1Field != null) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    try {
                        arrayList.add(new d(obj, field, asn1Field));
                    } catch (Asn1EncodingException e4) {
                        throw new Exception("Invalid ASN.1 annotation on " + cls.getName() + "." + field.getName(), e4);
                    }
                } else {
                    throw new Exception(Asn1Field.class.getName() + " used on a static field: " + cls.getName() + "." + field.getName());
                }
            }
        }
        return arrayList;
    }

    public static Object d(Object obj, Field field) {
        try {
            return field.get(obj);
        } catch (ReflectiveOperationException e4) {
            throw new Exception("Failed to read " + obj.getClass().getName() + "." + field.getName(), e4);
        }
    }

    public static byte[] e(Object obj) {
        Class<?> cls = obj.getClass();
        ArrayList c4 = c(obj);
        if (!c4.isEmpty()) {
            int size = c4.size();
            d dVar = null;
            int i = 0;
            while (i < size) {
                Object obj2 = c4.get(i);
                i++;
                d dVar2 = (d) obj2;
                if (d(obj, dVar2.f2080a) != null) {
                    if (dVar == null) {
                        dVar = dVar2;
                    } else {
                        throw new Exception("Multiple non-null fields in CHOICE class " + cls.getName() + ": " + dVar.f2080a.getName() + ", " + dVar2.f2080a.getName());
                    }
                }
            }
            if (dVar != null) {
                return dVar.a();
            }
            throw new Exception("No non-null fields in CHOICE class ".concat(cls.getName()));
        }
        throw new Exception("No fields annotated with " + Asn1Field.class.getName() + " in CHOICE class " + cls.getName());
    }

    public static byte[] f(Object obj, boolean z3) {
        Class<?> cls = obj.getClass();
        ArrayList c4 = c(obj);
        Collections.sort(c4, new C0019c2(4));
        if (c4.size() > 1) {
            int size = c4.size();
            d dVar = null;
            int i = 0;
            while (i < size) {
                Object obj2 = c4.get(i);
                i++;
                d dVar2 = (d) obj2;
                if (dVar != null && dVar.f2082c.index() == dVar2.f2082c.index()) {
                    throw new Exception("Fields have the same index: " + cls.getName() + "." + dVar.f2080a.getName() + " and ." + dVar2.f2080a.getName());
                }
                dVar = dVar2;
            }
        }
        ArrayList arrayList = new ArrayList(c4.size());
        int size2 = c4.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size2) {
            Object obj3 = c4.get(i4);
            i4++;
            d dVar3 = (d) obj3;
            try {
                byte[] a2 = dVar3.a();
                if (a2 != null) {
                    arrayList.add(a2);
                    i3 += a2.length;
                }
            } catch (Asn1EncodingException e4) {
                throw new Exception("Failed to encode " + cls.getName() + "." + dVar3.f2080a.getName(), e4);
            }
        }
        if (z3) {
            byte[] bArr = new byte[i3];
            int size3 = arrayList.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size3) {
                Object obj4 = arrayList.get(i6);
                i6++;
                byte[] bArr2 = (byte[]) obj4;
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return bArr;
        }
        return a(0, true, 16, (byte[][]) arrayList.toArray(new byte[0]));
    }

    public static byte[] g(Collection collection, j jVar, boolean z3) {
        int i;
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(c.k(it.next(), jVar, null));
        }
        if (z3) {
            if (arrayList.size() > 1) {
                Collections.sort(arrayList, e.f2088a);
            }
            i = 17;
        } else {
            i = 16;
        }
        return a(0, true, i, (byte[][]) arrayList.toArray(new byte[0]));
    }
}
