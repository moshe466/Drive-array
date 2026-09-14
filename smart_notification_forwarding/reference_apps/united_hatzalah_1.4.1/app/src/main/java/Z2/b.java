package z2;

import F0.AbstractC0008a;
import java.io.Serializable;
import kotlin.jvm.internal.j;
import t2.AbstractC0701c;

/* loaded from: classes.dex */
public final class b extends AbstractC0701c implements InterfaceC0796a, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Enum[] f6880a;

    public b(Enum[] entries) {
        j.e(entries, "entries");
        this.f6880a = entries;
    }

    @Override // t2.AbstractC0701c, java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        Enum r02;
        if (obj instanceof Enum) {
            Enum element = (Enum) obj;
            j.e(element, "element");
            int ordinal = element.ordinal();
            Enum[] enumArr = this.f6880a;
            j.e(enumArr, "<this>");
            if (ordinal >= 0 && ordinal < enumArr.length) {
                r02 = enumArr[ordinal];
            } else {
                r02 = null;
            }
            if (r02 == element) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // t2.AbstractC0701c
    public final int g() {
        return this.f6880a.length;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Enum[] enumArr = this.f6880a;
        int length = enumArr.length;
        if (i >= 0 && i < length) {
            return enumArr[i];
        }
        throw new IndexOutOfBoundsException(AbstractC0008a.k("index: ", i, length, ", size: "));
    }

    @Override // t2.AbstractC0701c, java.util.List
    public final int indexOf(Object obj) {
        Enum r22;
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        j.e(element, "element");
        int ordinal = element.ordinal();
        Enum[] enumArr = this.f6880a;
        j.e(enumArr, "<this>");
        if (ordinal >= 0 && ordinal < enumArr.length) {
            r22 = enumArr[ordinal];
        } else {
            r22 = null;
        }
        if (r22 != element) {
            return -1;
        }
        return ordinal;
    }

    @Override // t2.AbstractC0701c, java.util.List
    public final int lastIndexOf(Object obj) {
        Enum r22;
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum element = (Enum) obj;
        j.e(element, "element");
        int ordinal = element.ordinal();
        Enum[] enumArr = this.f6880a;
        j.e(enumArr, "<this>");
        if (ordinal >= 0 && ordinal < enumArr.length) {
            r22 = enumArr[ordinal];
        } else {
            r22 = null;
        }
        if (r22 != element) {
            return -1;
        }
        return ordinal;
    }
}
