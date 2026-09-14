package com.fasterxml.jackson.module.kotlin;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnsignedNumbers.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u001a\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u0004ø\u0001\u0000\u001a\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0007ø\u0001\u0000\u001a\u000f\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u0001ø\u0001\u0000\u001a\u000f\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\fø\u0001\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"uLongMaxValue", "Ljava/math/BigInteger;", "asUByte", "Lkotlin/UByte;", JsonProperty.USE_DEFAULT_NAME, "asUInt", "Lkotlin/UInt;", JsonProperty.USE_DEFAULT_NAME, "asULong", "Lkotlin/ULong;", "asUShort", "Lkotlin/UShort;", JsonProperty.USE_DEFAULT_NAME, "jackson-module-kotlin"}, k = 2, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class UnsignedNumbersKt {
    private static final BigInteger uLongMaxValue = new BigInteger(Long.toUnsignedString(-1));

    public static final UByte asUByte(short s) {
        if (s < 0 || s > ((short) (((short) (-1)) & 255))) {
            return null;
        }
        return UByte.m119boximpl(UByte.m125constructorimpl((byte) s));
    }

    public static final UShort asUShort(int i) {
        if (i < 0 || i > 65535) {
            return null;
        }
        return UShort.m382boximpl(UShort.m388constructorimpl((short) i));
    }

    public static final UInt asUInt(long j) {
        if (j < 0 || j > ((-1) & 4294967295L)) {
            return null;
        }
        return UInt.m196boximpl(UInt.m202constructorimpl((int) j));
    }

    public static final ULong asULong(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        if (bigInteger.compareTo(BigInteger.ZERO) < 0 || bigInteger.compareTo(uLongMaxValue) > 0) {
            return null;
        }
        return ULong.m275boximpl(ULong.m281constructorimpl(bigInteger.longValue()));
    }
}
