package kotlin.collections;

import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

@Deprecated(level = DeprecationLevel.HIDDEN, message = "Provided for binary compatibility")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0003\u001a\u00020\u0004*\u00020\t2\u0006\u0010\u0006\u001a\u00020\tH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0003\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u0006\u001a\u00020\fH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0003\u001a\u00020\u0004*\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000fH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0016\u0010\u001c\u001a\u00020\u001d*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u001e\u0010&\u001a\u00020'*\u00020\u00052\u0006\u0010&\u001a\u00020(H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u001e\u0010&\u001a\u00020+*\u00020\t2\u0006\u0010&\u001a\u00020(H\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001e\u0010&\u001a\u00020.*\u00020\f2\u0006\u0010&\u001a\u00020(H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u001e\u0010&\u001a\u000201*\u00020\u000f2\u0006\u0010&\u001a\u00020(H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020'05*\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020+05*\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020.05*\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020105*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, d2 = {"Lkotlin/collections/UArraysKt;", "", "()V", "contentEquals", "", "Lkotlin/UByteArray;", "other", "contentEquals-kdPth3s", "([B[B)Z", "Lkotlin/UIntArray;", "contentEquals-ctEhBpI", "([I[I)Z", "Lkotlin/ULongArray;", "contentEquals-us8wMrg", "([J[J)Z", "Lkotlin/UShortArray;", "contentEquals-mazbYpA", "([S[S)Z", "contentHashCode", "", "contentHashCode-GBYM_sE", "([B)I", "contentHashCode--ajY-9A", "([I)I", "contentHashCode-QwZRm1k", "([J)I", "contentHashCode-rL5Bavg", "([S)I", "contentToString", "", "contentToString-GBYM_sE", "([B)Ljava/lang/String;", "contentToString--ajY-9A", "([I)Ljava/lang/String;", "contentToString-QwZRm1k", "([J)Ljava/lang/String;", "contentToString-rL5Bavg", "([S)Ljava/lang/String;", "random", "Lkotlin/UByte;", "Lkotlin/random/Random;", "random-oSF2wD8", "([BLkotlin/random/Random;)B", "Lkotlin/UInt;", "random-2D5oskM", "([ILkotlin/random/Random;)I", "Lkotlin/ULong;", "random-JzugnMA", "([JLkotlin/random/Random;)J", "Lkotlin/UShort;", "random-s5X_as8", "([SLkotlin/random/Random;)S", "toTypedArray", "", "toTypedArray-GBYM_sE", "([B)[Lkotlin/UByte;", "toTypedArray--ajY-9A", "([I)[Lkotlin/UInt;", "toTypedArray-QwZRm1k", "([J)[Lkotlin/ULong;", "toTypedArray-rL5Bavg", "([S)[Lkotlin/UShort;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class UArraysKt {
    public static final UArraysKt INSTANCE = new UArraysKt();

    private UArraysKt() {
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-ctEhBpI, reason: not valid java name */
    public static final boolean m350contentEqualsctEhBpI(@NotNull int[] contentEquals, @NotNull int[] other) {
        Intrinsics.checkParameterIsNotNull(contentEquals, "$this$contentEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return Arrays.equals(contentEquals, other);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-kdPth3s, reason: not valid java name */
    public static final boolean m351contentEqualskdPth3s(@NotNull byte[] contentEquals, @NotNull byte[] other) {
        Intrinsics.checkParameterIsNotNull(contentEquals, "$this$contentEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return Arrays.equals(contentEquals, other);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-mazbYpA, reason: not valid java name */
    public static final boolean m352contentEqualsmazbYpA(@NotNull short[] contentEquals, @NotNull short[] other) {
        Intrinsics.checkParameterIsNotNull(contentEquals, "$this$contentEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return Arrays.equals(contentEquals, other);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentEquals-us8wMrg, reason: not valid java name */
    public static final boolean m353contentEqualsus8wMrg(@NotNull long[] contentEquals, @NotNull long[] other) {
        Intrinsics.checkParameterIsNotNull(contentEquals, "$this$contentEquals");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return Arrays.equals(contentEquals, other);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode--ajY-9A, reason: not valid java name */
    public static final int m354contentHashCodeajY9A(@NotNull int[] contentHashCode) {
        Intrinsics.checkParameterIsNotNull(contentHashCode, "$this$contentHashCode");
        return Arrays.hashCode(contentHashCode);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-GBYM_sE, reason: not valid java name */
    public static final int m355contentHashCodeGBYM_sE(@NotNull byte[] contentHashCode) {
        Intrinsics.checkParameterIsNotNull(contentHashCode, "$this$contentHashCode");
        return Arrays.hashCode(contentHashCode);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-QwZRm1k, reason: not valid java name */
    public static final int m356contentHashCodeQwZRm1k(@NotNull long[] contentHashCode) {
        Intrinsics.checkParameterIsNotNull(contentHashCode, "$this$contentHashCode");
        return Arrays.hashCode(contentHashCode);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: contentHashCode-rL5Bavg, reason: not valid java name */
    public static final int m357contentHashCoderL5Bavg(@NotNull short[] contentHashCode) {
        Intrinsics.checkParameterIsNotNull(contentHashCode, "$this$contentHashCode");
        return Arrays.hashCode(contentHashCode);
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString--ajY-9A, reason: not valid java name */
    public static final String m358contentToStringajY9A(@NotNull int[] contentToString) {
        String joinToString$default;
        Intrinsics.checkParameterIsNotNull(contentToString, "$this$contentToString");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(UIntArray.m148boximpl(contentToString), ", ", "[", "]", 0, null, null, 56, null);
        return joinToString$default;
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-GBYM_sE, reason: not valid java name */
    public static final String m359contentToStringGBYM_sE(@NotNull byte[] contentToString) {
        String joinToString$default;
        Intrinsics.checkParameterIsNotNull(contentToString, "$this$contentToString");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(UByteArray.m79boximpl(contentToString), ", ", "[", "]", 0, null, null, 56, null);
        return joinToString$default;
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-QwZRm1k, reason: not valid java name */
    public static final String m360contentToStringQwZRm1k(@NotNull long[] contentToString) {
        String joinToString$default;
        Intrinsics.checkParameterIsNotNull(contentToString, "$this$contentToString");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(ULongArray.m217boximpl(contentToString), ", ", "[", "]", 0, null, null, 56, null);
        return joinToString$default;
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: contentToString-rL5Bavg, reason: not valid java name */
    public static final String m361contentToStringrL5Bavg(@NotNull short[] contentToString) {
        String joinToString$default;
        Intrinsics.checkParameterIsNotNull(contentToString, "$this$contentToString");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(UShortArray.m312boximpl(contentToString), ", ", "[", "]", 0, null, null, 56, null);
        return joinToString$default;
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: random-2D5oskM, reason: not valid java name */
    public static final int m362random2D5oskM(@NotNull int[] random, @NotNull Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        if (UIntArray.m158isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UIntArray.m155getimpl(random, random2.nextInt(UIntArray.m156getSizeimpl(random)));
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: random-JzugnMA, reason: not valid java name */
    public static final long m363randomJzugnMA(@NotNull long[] random, @NotNull Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        if (ULongArray.m227isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return ULongArray.m224getimpl(random, random2.nextInt(ULongArray.m225getSizeimpl(random)));
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: random-oSF2wD8, reason: not valid java name */
    public static final byte m364randomoSF2wD8(@NotNull byte[] random, @NotNull Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        if (UByteArray.m89isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UByteArray.m86getimpl(random, random2.nextInt(UByteArray.m87getSizeimpl(random)));
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    /* renamed from: random-s5X_as8, reason: not valid java name */
    public static final short m365randoms5X_as8(@NotNull short[] random, @NotNull Random random2) {
        Intrinsics.checkParameterIsNotNull(random, "$this$random");
        Intrinsics.checkParameterIsNotNull(random2, "random");
        if (UShortArray.m322isEmptyimpl(random)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return UShortArray.m319getimpl(random, random2.nextInt(UShortArray.m320getSizeimpl(random)));
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray--ajY-9A, reason: not valid java name */
    public static final UInt[] m366toTypedArrayajY9A(@NotNull int[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        int m156getSizeimpl = UIntArray.m156getSizeimpl(toTypedArray);
        UInt[] uIntArr = new UInt[m156getSizeimpl];
        for (int i = 0; i < m156getSizeimpl; i++) {
            uIntArr[i] = UInt.m98boximpl(UIntArray.m155getimpl(toTypedArray, i));
        }
        return uIntArr;
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray-GBYM_sE, reason: not valid java name */
    public static final UByte[] m367toTypedArrayGBYM_sE(@NotNull byte[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        int m87getSizeimpl = UByteArray.m87getSizeimpl(toTypedArray);
        UByte[] uByteArr = new UByte[m87getSizeimpl];
        for (int i = 0; i < m87getSizeimpl; i++) {
            uByteArr[i] = UByte.m31boximpl(UByteArray.m86getimpl(toTypedArray, i));
        }
        return uByteArr;
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray-QwZRm1k, reason: not valid java name */
    public static final ULong[] m368toTypedArrayQwZRm1k(@NotNull long[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        int m225getSizeimpl = ULongArray.m225getSizeimpl(toTypedArray);
        ULong[] uLongArr = new ULong[m225getSizeimpl];
        for (int i = 0; i < m225getSizeimpl; i++) {
            uLongArr[i] = ULong.m167boximpl(ULongArray.m224getimpl(toTypedArray, i));
        }
        return uLongArr;
    }

    @JvmStatic
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: toTypedArray-rL5Bavg, reason: not valid java name */
    public static final UShort[] m369toTypedArrayrL5Bavg(@NotNull short[] toTypedArray) {
        Intrinsics.checkParameterIsNotNull(toTypedArray, "$this$toTypedArray");
        int m320getSizeimpl = UShortArray.m320getSizeimpl(toTypedArray);
        UShort[] uShortArr = new UShort[m320getSizeimpl];
        for (int i = 0; i < m320getSizeimpl; i++) {
            uShortArr[i] = UShort.m264boximpl(UShortArray.m319getimpl(toTypedArray, i));
        }
        return uShortArr;
    }
}
