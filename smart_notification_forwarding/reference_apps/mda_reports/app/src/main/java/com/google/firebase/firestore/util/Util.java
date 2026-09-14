package com.google.firebase.firestore.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.cloud.datastore.core.number.NumberComparisonHelper;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/* loaded from: classes2.dex */
public class Util {
    private static final String AUTO_ID_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int AUTO_ID_LENGTH = 20;
    private static final Random rand = new Random();
    private static final Comparator COMPARABLE_COMPARATOR = new Comparator<Comparable<?>>() { // from class: com.google.firebase.firestore.util.Util.1
        AnonymousClass1() {
        }

        /* renamed from: compare */
        public int compare2(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Comparable<?> comparable, Comparable<?> comparable2) {
            return compare2((Comparable) comparable, (Comparable) comparable2);
        }
    };
    private static final Continuation<Void, Void> VOID_ERROR_TRANSFORMER = Util$$Lambda$2.lambdaFactory$();

    /* renamed from: com.google.firebase.firestore.util.Util$1 */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements Comparator<Comparable<?>> {
        AnonymousClass1() {
        }

        /* renamed from: compare */
        public int compare2(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Comparable<?> comparable, Comparable<?> comparable2) {
            return compare2((Comparable) comparable, (Comparable) comparable2);
        }
    }

    static {
        Continuation<Void, Void> continuation;
        continuation = Util$$Lambda$2.instance;
        VOID_ERROR_TRANSFORMER = continuation;
    }

    public static /* synthetic */ Void a(Task task) {
        if (task.isSuccessful()) {
            return (Void) task.getResult();
        }
        Exception convertStatusException = convertStatusException(task.getException());
        if (convertStatusException instanceof FirebaseFirestoreException) {
            throw convertStatusException;
        }
        throw new FirebaseFirestoreException(convertStatusException.getMessage(), FirebaseFirestoreException.Code.UNKNOWN, convertStatusException);
    }

    public static /* synthetic */ void a(RuntimeException runtimeException) {
        throw runtimeException;
    }

    public static String autoId() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            sb.append(AUTO_ID_ALPHABET.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }

    public static List<Object> collectUpdateArguments(int i, Object obj, Object obj2, Object... objArr) {
        if (objArr.length % 2 == 1) {
            throw new IllegalArgumentException("Missing value in call to update().  There must be an even number of arguments that alternate between field names and values");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        arrayList.add(obj2);
        Collections.addAll(arrayList, objArr);
        for (int i2 = 0; i2 < arrayList.size(); i2 += 2) {
            Object obj3 = arrayList.get(i2);
            if (!(obj3 instanceof String) && !(obj3 instanceof FieldPath)) {
                throw new IllegalArgumentException("Excepted field name at argument position " + (i2 + i + 1) + " but got " + obj3 + " in call to update.  The arguments to update should alternate between field names and values");
            }
        }
        return arrayList;
    }

    public static <T extends Comparable<T>> Comparator<T> comparator() {
        return COMPARABLE_COMPARATOR;
    }

    public static int compareBooleans(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public static int compareDoubles(double d, double d2) {
        return NumberComparisonHelper.firestoreCompareDoubles(d, d2);
    }

    public static int compareIntegers(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int compareInts(int i, int i2) {
        return NumberComparisonHelper.compareLongs(i, i2);
    }

    public static int compareLongs(long j, long j2) {
        return NumberComparisonHelper.compareLongs(j, j2);
    }

    public static int compareMixed(double d, long j) {
        return NumberComparisonHelper.firestoreCompareDoubleWithLong(d, j);
    }

    private static Exception convertStatusException(Exception exc) {
        Status status;
        if (exc instanceof StatusException) {
            status = ((StatusException) exc).getStatus();
        } else {
            if (!(exc instanceof StatusRuntimeException)) {
                return exc;
            }
            status = ((StatusRuntimeException) exc).getStatus();
        }
        return exceptionFromStatus(status);
    }

    public static Exception convertThrowableToException(Throwable th) {
        return th instanceof Exception ? convertStatusException((Exception) th) : new Exception(th);
    }

    public static void crashMainThread(RuntimeException runtimeException) {
        new Handler(Looper.getMainLooper()).post(Util$$Lambda$1.lambdaFactory$(runtimeException));
    }

    public static FirebaseFirestoreException exceptionFromStatus(Status status) {
        StatusException asException = status.asException();
        return new FirebaseFirestoreException(asException.getMessage(), FirebaseFirestoreException.Code.fromValue(status.getCode().value()), asException);
    }

    public static String toDebugString(ByteString byteString) {
        int size = byteString.size();
        StringBuilder sb = new StringBuilder(size * 2);
        for (int i = 0; i < size; i++) {
            int byteAt = byteString.byteAt(i) & 255;
            sb.append(Character.forDigit(byteAt >>> 4, 16));
            sb.append(Character.forDigit(byteAt & 15, 16));
        }
        return sb.toString();
    }

    public static String typeName(@Nullable Object obj) {
        return obj == null ? "null" : obj.getClass().getName();
    }

    public static Continuation<Void, Void> voidErrorTransformer() {
        return VOID_ERROR_TRANSFORMER;
    }
}
