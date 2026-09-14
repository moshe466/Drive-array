package io.grpc;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.io.BaseEncoding;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* loaded from: classes2.dex */
public final class Metadata {
    public static final String BINARY_HEADER_SUFFIX = "-bin";
    private byte[][] namesAndValues;
    private int size;
    public static final BinaryMarshaller<byte[]> BINARY_BYTE_MARSHALLER = new BinaryMarshaller<byte[]>() { // from class: io.grpc.Metadata.1
        @Override // io.grpc.Metadata.BinaryMarshaller
        public byte[] parseBytes(byte[] bArr) {
            return bArr;
        }

        @Override // io.grpc.Metadata.BinaryMarshaller
        public byte[] toBytes(byte[] bArr) {
            return bArr;
        }
    };
    public static final AsciiMarshaller<String> ASCII_STRING_MARSHALLER = new AsciiMarshaller<String>() { // from class: io.grpc.Metadata.2
        @Override // io.grpc.Metadata.AsciiMarshaller
        public String parseAsciiString(String str) {
            return str;
        }

        @Override // io.grpc.Metadata.AsciiMarshaller
        public String toAsciiString(String str) {
            return str;
        }
    };
    static final BaseEncoding a = BaseEncoding.base64().omitPadding();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class AsciiKey<T> extends Key<T> {
        private final AsciiMarshaller<T> marshaller;

        private AsciiKey(String str, boolean z, AsciiMarshaller<T> asciiMarshaller) {
            super(str, z);
            Preconditions.checkArgument(!str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
            this.marshaller = (AsciiMarshaller) Preconditions.checkNotNull(asciiMarshaller, "marshaller");
        }

        @Override // io.grpc.Metadata.Key
        T a(byte[] bArr) {
            return this.marshaller.parseAsciiString(new String(bArr, Charsets.US_ASCII));
        }

        @Override // io.grpc.Metadata.Key
        byte[] a(T t) {
            return this.marshaller.toAsciiString(t).getBytes(Charsets.US_ASCII);
        }
    }

    /* loaded from: classes2.dex */
    public interface AsciiMarshaller<T> {
        T parseAsciiString(String str);

        String toAsciiString(T t);
    }

    /* loaded from: classes2.dex */
    private static class BinaryKey<T> extends Key<T> {
        private final BinaryMarshaller<T> marshaller;

        private BinaryKey(String str, BinaryMarshaller<T> binaryMarshaller) {
            super(str, false);
            Preconditions.checkArgument(str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "Binary header is named %s. It must end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
            Preconditions.checkArgument(str.length() > 4, "empty key name");
            this.marshaller = (BinaryMarshaller) Preconditions.checkNotNull(binaryMarshaller, "marshaller is null");
        }

        @Override // io.grpc.Metadata.Key
        T a(byte[] bArr) {
            return this.marshaller.parseBytes(bArr);
        }

        @Override // io.grpc.Metadata.Key
        byte[] a(T t) {
            return this.marshaller.toBytes(t);
        }
    }

    /* loaded from: classes2.dex */
    public interface BinaryMarshaller<T> {
        T parseBytes(byte[] bArr);

        byte[] toBytes(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class IterableAt<T> implements Iterable<T> {
        private final Key<T> key;
        private int startIdx;

        private IterableAt(Key<T> key, int i) {
            this.key = key;
            this.startIdx = i;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new Iterator<T>() { // from class: io.grpc.Metadata.IterableAt.1
                private boolean hasNext = true;
                private int idx;

                {
                    this.idx = IterableAt.this.startIdx;
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    if (this.hasNext) {
                        return true;
                    }
                    while (this.idx < Metadata.this.size) {
                        IterableAt iterableAt = IterableAt.this;
                        if (Metadata.this.bytesEqual(iterableAt.key.a(), Metadata.this.name(this.idx))) {
                            this.hasNext = true;
                            return this.hasNext;
                        }
                        this.idx++;
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public T next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    this.hasNext = false;
                    Key key = IterableAt.this.key;
                    Metadata metadata = Metadata.this;
                    int i = this.idx;
                    this.idx = i + 1;
                    return (T) key.a(metadata.value(i));
                }

                @Override // java.util.Iterator
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }
    }

    @Immutable
    /* loaded from: classes2.dex */
    public static abstract class Key<T> {
        private static final BitSet VALID_T_CHARS = generateValidTChars();
        private final String name;
        private final byte[] nameBytes;
        private final String originalName;

        private Key(String str, boolean z) {
            this.originalName = (String) Preconditions.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            this.name = validateName(this.originalName.toLowerCase(Locale.ROOT), z);
            this.nameBytes = this.name.getBytes(Charsets.US_ASCII);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static <T> Key<T> a(String str, boolean z, AsciiMarshaller<T> asciiMarshaller) {
            return new AsciiKey(str, z, asciiMarshaller);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static <T> Key<T> a(String str, boolean z, TrustedAsciiMarshaller<T> trustedAsciiMarshaller) {
            return new TrustedAsciiKey(str, z, trustedAsciiMarshaller);
        }

        private static BitSet generateValidTChars() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c = '0'; c <= '9'; c = (char) (c + 1)) {
                bitSet.set(c);
            }
            for (char c2 = 'a'; c2 <= 'z'; c2 = (char) (c2 + 1)) {
                bitSet.set(c2);
            }
            return bitSet;
        }

        public static <T> Key<T> of(String str, AsciiMarshaller<T> asciiMarshaller) {
            return a(str, false, (AsciiMarshaller) asciiMarshaller);
        }

        public static <T> Key<T> of(String str, BinaryMarshaller<T> binaryMarshaller) {
            return new BinaryKey(str, binaryMarshaller);
        }

        private static String validateName(String str, boolean z) {
            Preconditions.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            Preconditions.checkArgument(!str.isEmpty(), "token must have at least 1 tchar");
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!z || charAt != ':' || i != 0) {
                    Preconditions.checkArgument(VALID_T_CHARS.get(charAt), "Invalid character '%s' in key name '%s'", charAt, (Object) str);
                }
            }
            return str;
        }

        abstract T a(byte[] bArr);

        @VisibleForTesting
        byte[] a() {
            return this.nameBytes;
        }

        abstract byte[] a(T t);

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.name.equals(((Key) obj).name);
        }

        public final int hashCode() {
            return this.name.hashCode();
        }

        public final String name() {
            return this.name;
        }

        public final String originalName() {
            return this.originalName;
        }

        public String toString() {
            return "Key{name='" + this.name + "'}";
        }
    }

    /* loaded from: classes2.dex */
    private static final class TrustedAsciiKey<T> extends Key<T> {
        private final TrustedAsciiMarshaller<T> marshaller;

        private TrustedAsciiKey(String str, boolean z, TrustedAsciiMarshaller<T> trustedAsciiMarshaller) {
            super(str, z);
            Preconditions.checkArgument(!str.endsWith(Metadata.BINARY_HEADER_SUFFIX), "ASCII header is named %s.  Only binary headers may end with %s", str, Metadata.BINARY_HEADER_SUFFIX);
            this.marshaller = (TrustedAsciiMarshaller) Preconditions.checkNotNull(trustedAsciiMarshaller, "marshaller");
        }

        @Override // io.grpc.Metadata.Key
        T a(byte[] bArr) {
            return this.marshaller.parseAsciiString(bArr);
        }

        @Override // io.grpc.Metadata.Key
        byte[] a(T t) {
            return this.marshaller.toAsciiString(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Immutable
    /* loaded from: classes2.dex */
    public interface TrustedAsciiMarshaller<T> {
        T parseAsciiString(byte[] bArr);

        byte[] toAsciiString(T t);
    }

    public Metadata() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata(int i, byte[]... bArr) {
        this.size = i;
        this.namesAndValues = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata(byte[]... bArr) {
        this(bArr.length / 2, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bytesEqual(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    private int cap() {
        byte[][] bArr = this.namesAndValues;
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    private void expand(int i) {
        byte[][] bArr = new byte[i];
        if (!isEmpty()) {
            System.arraycopy(this.namesAndValues, 0, bArr, 0, len());
        }
        this.namesAndValues = bArr;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private int len() {
        return this.size * 2;
    }

    private void maybeExpand() {
        if (len() == 0 || len() == cap()) {
            expand(Math.max(len() * 2, 8));
        }
    }

    private void name(int i, byte[] bArr) {
        this.namesAndValues[i * 2] = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] name(int i) {
        return this.namesAndValues[i * 2];
    }

    private void value(int i, byte[] bArr) {
        this.namesAndValues[(i * 2) + 1] = bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] value(int i) {
        return this.namesAndValues[(i * 2) + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public byte[][] b() {
        if (len() == cap()) {
            return this.namesAndValues;
        }
        byte[][] bArr = new byte[len()];
        System.arraycopy(this.namesAndValues, 0, bArr, 0, len());
        return bArr;
    }

    public boolean containsKey(Key<?> key) {
        for (int i = 0; i < this.size; i++) {
            if (bytesEqual(key.a(), name(i))) {
                return true;
            }
        }
        return false;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4691")
    public <T> void discardAll(Key<T> key) {
        if (isEmpty()) {
            return;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (!bytesEqual(key.a(), name(i2))) {
                name(i, name(i2));
                value(i, value(i2));
                i++;
            }
        }
        Arrays.fill(this.namesAndValues, i * 2, len(), (Object) null);
        this.size = i;
    }

    @Nullable
    public <T> T get(Key<T> key) {
        for (int i = this.size - 1; i >= 0; i--) {
            if (bytesEqual(key.a(), name(i))) {
                return key.a(value(i));
            }
        }
        return null;
    }

    @Nullable
    public <T> Iterable<T> getAll(Key<T> key) {
        int i = 0;
        while (true) {
            if (i >= this.size) {
                return null;
            }
            if (bytesEqual(key.a(), name(i))) {
                return new IterableAt(key, i);
            }
            i++;
        }
    }

    public Set<String> keys() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.size);
        for (int i = 0; i < this.size; i++) {
            hashSet.add(new String(name(i), 0));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public void merge(Metadata metadata) {
        if (metadata.isEmpty()) {
            return;
        }
        int cap = cap() - len();
        if (isEmpty() || cap < metadata.len()) {
            expand(len() + metadata.len());
        }
        System.arraycopy(metadata.namesAndValues, 0, this.namesAndValues, len(), metadata.len());
        this.size += metadata.size;
    }

    public void merge(Metadata metadata, Set<Key<?>> set) {
        Preconditions.checkNotNull(metadata, "other");
        HashMap hashMap = new HashMap(set.size());
        for (Key<?> key : set) {
            hashMap.put(ByteBuffer.wrap(key.a()), key);
        }
        for (int i = 0; i < metadata.size; i++) {
            if (hashMap.containsKey(ByteBuffer.wrap(metadata.name(i)))) {
                maybeExpand();
                name(this.size, metadata.name(i));
                value(this.size, metadata.value(i));
                this.size++;
            }
        }
    }

    public <T> void put(Key<T> key, T t) {
        Preconditions.checkNotNull(key, "key");
        Preconditions.checkNotNull(t, "value");
        maybeExpand();
        name(this.size, key.a());
        value(this.size, key.a((Key<T>) t));
        this.size++;
    }

    public <T> boolean remove(Key<T> key, T t) {
        Preconditions.checkNotNull(key, "key");
        Preconditions.checkNotNull(t, "value");
        for (int i = 0; i < this.size; i++) {
            if (bytesEqual(key.a(), name(i)) && t.equals(key.a(value(i)))) {
                int i2 = i * 2;
                int i3 = (i + 1) * 2;
                int len = len() - i3;
                byte[][] bArr = this.namesAndValues;
                System.arraycopy(bArr, i3, bArr, i2, len);
                this.size--;
                name(this.size, null);
                value(this.size, null);
                return true;
            }
        }
        return false;
    }

    public <T> Iterable<T> removeAll(Key<T> key) {
        if (isEmpty()) {
            return null;
        }
        ArrayList arrayList = null;
        int i = 0;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (bytesEqual(key.a(), name(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(key.a(value(i2)));
            } else {
                name(i, name(i2));
                value(i, value(i2));
                i++;
            }
        }
        Arrays.fill(this.namesAndValues, i * 2, len(), (Object) null);
        this.size = i;
        return arrayList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i = 0; i < this.size; i++) {
            if (i != 0) {
                sb.append(',');
            }
            String str = new String(name(i), Charsets.US_ASCII);
            sb.append(str);
            sb.append('=');
            sb.append(str.endsWith(BINARY_HEADER_SUFFIX) ? a.encode(value(i)) : new String(value(i), Charsets.US_ASCII));
        }
        sb.append(')');
        return sb.toString();
    }
}
