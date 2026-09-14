package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0012\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "quickSort-oBK06Vg", "([III)V", "quickSort--nroSd4", "([JII)V", "quickSort-Aa5vz7o", "([SII)V", "sortArray", "sortArray-GBYM_sE", "([B)V", "sortArray--ajY-9A", "([I)V", "sortArray-QwZRm1k", "([J)V", "sortArray-rL5Bavg", "([S)V", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    /* renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m338partitionnroSd4(long[] jArr, int i, int i2) {
        long m224getimpl = ULongArray.m224getimpl(jArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.ulongCompare(ULongArray.m224getimpl(jArr, i), m224getimpl) < 0) {
                i++;
            }
            while (UnsignedKt.ulongCompare(ULongArray.m224getimpl(jArr, i2), m224getimpl) > 0) {
                i2--;
            }
            if (i <= i2) {
                long m224getimpl2 = ULongArray.m224getimpl(jArr, i);
                ULongArray.m229setk8EXiF4(jArr, i, ULongArray.m224getimpl(jArr, i2));
                ULongArray.m229setk8EXiF4(jArr, i2, m224getimpl2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m339partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3;
        byte m86getimpl = UByteArray.m86getimpl(bArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                i3 = m86getimpl & 255;
                if (Intrinsics.compare(UByteArray.m86getimpl(bArr, i) & 255, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UByteArray.m86getimpl(bArr, i2) & 255, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                byte m86getimpl2 = UByteArray.m86getimpl(bArr, i);
                UByteArray.m91setVurrAj0(bArr, i, UByteArray.m86getimpl(bArr, i2));
                UByteArray.m91setVurrAj0(bArr, i2, m86getimpl2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m340partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3;
        short m319getimpl = UShortArray.m319getimpl(sArr, (i + i2) / 2);
        while (i <= i2) {
            while (true) {
                int m319getimpl2 = UShortArray.m319getimpl(sArr, i) & UShort.MAX_VALUE;
                i3 = m319getimpl & UShort.MAX_VALUE;
                if (Intrinsics.compare(m319getimpl2, i3) >= 0) {
                    break;
                }
                i++;
            }
            while (Intrinsics.compare(UShortArray.m319getimpl(sArr, i2) & UShort.MAX_VALUE, i3) > 0) {
                i2--;
            }
            if (i <= i2) {
                short m319getimpl3 = UShortArray.m319getimpl(sArr, i);
                UShortArray.m324set01HTLdE(sArr, i, UShortArray.m319getimpl(sArr, i2));
                UShortArray.m324set01HTLdE(sArr, i2, m319getimpl3);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m341partitionoBK06Vg(int[] iArr, int i, int i2) {
        int m155getimpl = UIntArray.m155getimpl(iArr, (i + i2) / 2);
        while (i <= i2) {
            while (UnsignedKt.uintCompare(UIntArray.m155getimpl(iArr, i), m155getimpl) < 0) {
                i++;
            }
            while (UnsignedKt.uintCompare(UIntArray.m155getimpl(iArr, i2), m155getimpl) > 0) {
                i2--;
            }
            if (i <= i2) {
                int m155getimpl2 = UIntArray.m155getimpl(iArr, i);
                UIntArray.m160setVXSXFK8(iArr, i, UIntArray.m155getimpl(iArr, i2));
                UIntArray.m160setVXSXFK8(iArr, i2, m155getimpl2);
                i++;
                i2--;
            }
        }
        return i;
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m342quickSortnroSd4(long[] jArr, int i, int i2) {
        int m338partitionnroSd4 = m338partitionnroSd4(jArr, i, i2);
        int i3 = m338partitionnroSd4 - 1;
        if (i < i3) {
            m342quickSortnroSd4(jArr, i, i3);
        }
        if (m338partitionnroSd4 < i2) {
            m342quickSortnroSd4(jArr, m338partitionnroSd4, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m343quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m339partition4UcCI2c = m339partition4UcCI2c(bArr, i, i2);
        int i3 = m339partition4UcCI2c - 1;
        if (i < i3) {
            m343quickSort4UcCI2c(bArr, i, i3);
        }
        if (m339partition4UcCI2c < i2) {
            m343quickSort4UcCI2c(bArr, m339partition4UcCI2c, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m344quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m340partitionAa5vz7o = m340partitionAa5vz7o(sArr, i, i2);
        int i3 = m340partitionAa5vz7o - 1;
        if (i < i3) {
            m344quickSortAa5vz7o(sArr, i, i3);
        }
        if (m340partitionAa5vz7o < i2) {
            m344quickSortAa5vz7o(sArr, m340partitionAa5vz7o, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m345quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m341partitionoBK06Vg = m341partitionoBK06Vg(iArr, i, i2);
        int i3 = m341partitionoBK06Vg - 1;
        if (i < i3) {
            m345quickSortoBK06Vg(iArr, i, i3);
        }
        if (m341partitionoBK06Vg < i2) {
            m345quickSortoBK06Vg(iArr, m341partitionoBK06Vg, i2);
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray--ajY-9A, reason: not valid java name */
    public static final void m346sortArrayajY9A(@NotNull int[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        m345quickSortoBK06Vg(array, 0, UIntArray.m156getSizeimpl(array) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-GBYM_sE, reason: not valid java name */
    public static final void m347sortArrayGBYM_sE(@NotNull byte[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        m343quickSort4UcCI2c(array, 0, UByteArray.m87getSizeimpl(array) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-QwZRm1k, reason: not valid java name */
    public static final void m348sortArrayQwZRm1k(@NotNull long[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        m342quickSortnroSd4(array, 0, ULongArray.m225getSizeimpl(array) - 1);
    }

    @ExperimentalUnsignedTypes
    /* renamed from: sortArray-rL5Bavg, reason: not valid java name */
    public static final void m349sortArrayrL5Bavg(@NotNull short[] array) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        m344quickSortAa5vz7o(array, 0, UShortArray.m320getSizeimpl(array) - 1);
    }
}
