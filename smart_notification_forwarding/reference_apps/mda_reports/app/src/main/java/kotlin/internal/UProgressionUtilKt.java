package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class UProgressionUtilKt {
    /* renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m886differenceModuloWZ9TVnA(int i, int i2, int i3) {
        int m331uintRemainderJ1ME1BU = UnsignedKt.m331uintRemainderJ1ME1BU(i, i3);
        int m331uintRemainderJ1ME1BU2 = UnsignedKt.m331uintRemainderJ1ME1BU(i2, i3);
        int uintCompare = UnsignedKt.uintCompare(m331uintRemainderJ1ME1BU, m331uintRemainderJ1ME1BU2);
        int m104constructorimpl = UInt.m104constructorimpl(m331uintRemainderJ1ME1BU - m331uintRemainderJ1ME1BU2);
        return uintCompare >= 0 ? m104constructorimpl : UInt.m104constructorimpl(m104constructorimpl + i3);
    }

    /* renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m887differenceModulosambcqE(long j, long j2, long j3) {
        long m333ulongRemaindereb3DHEI = UnsignedKt.m333ulongRemaindereb3DHEI(j, j3);
        long m333ulongRemaindereb3DHEI2 = UnsignedKt.m333ulongRemaindereb3DHEI(j2, j3);
        int ulongCompare = UnsignedKt.ulongCompare(m333ulongRemaindereb3DHEI, m333ulongRemaindereb3DHEI2);
        long m173constructorimpl = ULong.m173constructorimpl(m333ulongRemaindereb3DHEI - m333ulongRemaindereb3DHEI2);
        return ulongCompare >= 0 ? m173constructorimpl : ULong.m173constructorimpl(m173constructorimpl + j3);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m888getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        long m887differenceModulosambcqE;
        if (j3 > 0) {
            if (UnsignedKt.ulongCompare(j, j2) >= 0) {
                return j2;
            }
            m887differenceModulosambcqE = j2 - m887differenceModulosambcqE(j2, j, ULong.m173constructorimpl(j3));
        } else {
            if (j3 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (UnsignedKt.ulongCompare(j, j2) <= 0) {
                return j2;
            }
            m887differenceModulosambcqE = j2 + m887differenceModulosambcqE(j, j2, ULong.m173constructorimpl(-j3));
        }
        return ULong.m173constructorimpl(m887differenceModulosambcqE);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m889getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        int m886differenceModuloWZ9TVnA;
        if (i3 > 0) {
            if (UnsignedKt.uintCompare(i, i2) >= 0) {
                return i2;
            }
            m886differenceModuloWZ9TVnA = i2 - m886differenceModuloWZ9TVnA(i2, i, UInt.m104constructorimpl(i3));
        } else {
            if (i3 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (UnsignedKt.uintCompare(i, i2) <= 0) {
                return i2;
            }
            m886differenceModuloWZ9TVnA = i2 + m886differenceModuloWZ9TVnA(i, i2, UInt.m104constructorimpl(-i3));
        }
        return UInt.m104constructorimpl(m886differenceModuloWZ9TVnA);
    }
}
