package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public enum zzdrn {
    DOUBLE(0, zzdrp.SCALAR, zzdsg.DOUBLE),
    FLOAT(1, zzdrp.SCALAR, zzdsg.FLOAT),
    INT64(2, zzdrp.SCALAR, zzdsg.LONG),
    UINT64(3, zzdrp.SCALAR, zzdsg.LONG),
    INT32(4, zzdrp.SCALAR, zzdsg.INT),
    FIXED64(5, zzdrp.SCALAR, zzdsg.LONG),
    FIXED32(6, zzdrp.SCALAR, zzdsg.INT),
    BOOL(7, zzdrp.SCALAR, zzdsg.BOOLEAN),
    STRING(8, zzdrp.SCALAR, zzdsg.STRING),
    MESSAGE(9, zzdrp.SCALAR, zzdsg.MESSAGE),
    BYTES(10, zzdrp.SCALAR, zzdsg.BYTE_STRING),
    UINT32(11, zzdrp.SCALAR, zzdsg.INT),
    ENUM(12, zzdrp.SCALAR, zzdsg.ENUM),
    SFIXED32(13, zzdrp.SCALAR, zzdsg.INT),
    SFIXED64(14, zzdrp.SCALAR, zzdsg.LONG),
    SINT32(15, zzdrp.SCALAR, zzdsg.INT),
    SINT64(16, zzdrp.SCALAR, zzdsg.LONG),
    GROUP(17, zzdrp.SCALAR, zzdsg.MESSAGE),
    DOUBLE_LIST(18, zzdrp.VECTOR, zzdsg.DOUBLE),
    FLOAT_LIST(19, zzdrp.VECTOR, zzdsg.FLOAT),
    INT64_LIST(20, zzdrp.VECTOR, zzdsg.LONG),
    UINT64_LIST(21, zzdrp.VECTOR, zzdsg.LONG),
    INT32_LIST(22, zzdrp.VECTOR, zzdsg.INT),
    FIXED64_LIST(23, zzdrp.VECTOR, zzdsg.LONG),
    FIXED32_LIST(24, zzdrp.VECTOR, zzdsg.INT),
    BOOL_LIST(25, zzdrp.VECTOR, zzdsg.BOOLEAN),
    STRING_LIST(26, zzdrp.VECTOR, zzdsg.STRING),
    MESSAGE_LIST(27, zzdrp.VECTOR, zzdsg.MESSAGE),
    BYTES_LIST(28, zzdrp.VECTOR, zzdsg.BYTE_STRING),
    UINT32_LIST(29, zzdrp.VECTOR, zzdsg.INT),
    ENUM_LIST(30, zzdrp.VECTOR, zzdsg.ENUM),
    SFIXED32_LIST(31, zzdrp.VECTOR, zzdsg.INT),
    SFIXED64_LIST(32, zzdrp.VECTOR, zzdsg.LONG),
    SINT32_LIST(33, zzdrp.VECTOR, zzdsg.INT),
    SINT64_LIST(34, zzdrp.VECTOR, zzdsg.LONG),
    DOUBLE_LIST_PACKED(35, zzdrp.PACKED_VECTOR, zzdsg.DOUBLE),
    FLOAT_LIST_PACKED(36, zzdrp.PACKED_VECTOR, zzdsg.FLOAT),
    INT64_LIST_PACKED(37, zzdrp.PACKED_VECTOR, zzdsg.LONG),
    UINT64_LIST_PACKED(38, zzdrp.PACKED_VECTOR, zzdsg.LONG),
    INT32_LIST_PACKED(39, zzdrp.PACKED_VECTOR, zzdsg.INT),
    FIXED64_LIST_PACKED(40, zzdrp.PACKED_VECTOR, zzdsg.LONG),
    FIXED32_LIST_PACKED(41, zzdrp.PACKED_VECTOR, zzdsg.INT),
    BOOL_LIST_PACKED(42, zzdrp.PACKED_VECTOR, zzdsg.BOOLEAN),
    UINT32_LIST_PACKED(43, zzdrp.PACKED_VECTOR, zzdsg.INT),
    ENUM_LIST_PACKED(44, zzdrp.PACKED_VECTOR, zzdsg.ENUM),
    SFIXED32_LIST_PACKED(45, zzdrp.PACKED_VECTOR, zzdsg.INT),
    SFIXED64_LIST_PACKED(46, zzdrp.PACKED_VECTOR, zzdsg.LONG),
    SINT32_LIST_PACKED(47, zzdrp.PACKED_VECTOR, zzdsg.INT),
    SINT64_LIST_PACKED(48, zzdrp.PACKED_VECTOR, zzdsg.LONG),
    GROUP_LIST(49, zzdrp.VECTOR, zzdsg.MESSAGE),
    MAP(50, zzdrp.MAP, zzdsg.VOID);

    private static final zzdrn[] zzhlw;
    private static final Type[] zzhlx = new Type[0];
    private final int id;
    private final zzdsg zzhls;
    private final zzdrp zzhlt;
    private final Class<?> zzhlu;
    private final boolean zzhlv;

    static {
        zzdrn[] values = values();
        zzhlw = new zzdrn[values.length];
        for (zzdrn zzdrnVar : values) {
            zzhlw[zzdrnVar.id] = zzdrnVar;
        }
    }

    zzdrn(int i, zzdrp zzdrpVar, zzdsg zzdsgVar) {
        int i2;
        this.id = i;
        this.zzhlt = zzdrpVar;
        this.zzhls = zzdsgVar;
        int i3 = zzdrq.a[zzdrpVar.ordinal()];
        this.zzhlu = (i3 == 1 || i3 == 2) ? zzdsgVar.zzbat() : null;
        boolean z = false;
        if (zzdrpVar == zzdrp.SCALAR && (i2 = zzdrq.b[zzdsgVar.ordinal()]) != 1 && i2 != 2 && i2 != 3) {
            z = true;
        }
        this.zzhlv = z;
    }

    public final int id() {
        return this.id;
    }
}
