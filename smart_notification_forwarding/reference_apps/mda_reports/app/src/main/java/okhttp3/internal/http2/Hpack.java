package okhttp3.internal.http2;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.fabric.sdk.android.services.network.HttpRequest;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Hpack {
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] a = {new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, HttpRequest.METHOD_GET), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, "/"), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, "http"), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header(GrpcUtil.CONTENT_ACCEPT_ENCODING, "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header(GrpcUtil.CONTENT_ENCODING, ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(FirebaseAnalytics.Param.LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
    static final Map<ByteString, Integer> b = nameToFirstIndex();

    /* loaded from: classes3.dex */
    static final class Reader {
        Header[] a;
        int b;
        int c;
        int d;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private final BufferedSource source;

        Reader(int i, int i2, Source source) {
            this.headerList = new ArrayList();
            this.a = new Header[8];
            this.b = this.a.length - 1;
            this.c = 0;
            this.d = 0;
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i2;
            this.source = Okio.buffer(source);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Reader(int i, Source source) {
            this(i, i, source);
        }

        private void adjustDynamicTableByteCount() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.d;
            if (i < i2) {
                if (i == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - i);
                }
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.a, (Object) null);
            this.b = this.a.length - 1;
            this.c = 0;
            this.d = 0;
        }

        private int dynamicTableIndex(int i) {
            return this.b + 1 + i;
        }

        private int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.a.length;
                while (true) {
                    length--;
                    if (length < this.b || i <= 0) {
                        break;
                    }
                    Header[] headerArr = this.a;
                    i -= headerArr[length].a;
                    this.d -= headerArr[length].a;
                    this.c--;
                    i2++;
                }
                Header[] headerArr2 = this.a;
                int i3 = this.b;
                System.arraycopy(headerArr2, i3 + 1, headerArr2, i3 + 1 + i2, this.c);
                this.b += i2;
            }
            return i2;
        }

        private ByteString getName(int i) {
            Header header;
            if (!isStaticHeader(i)) {
                int dynamicTableIndex = dynamicTableIndex(i - Hpack.a.length);
                if (dynamicTableIndex >= 0) {
                    Header[] headerArr = this.a;
                    if (dynamicTableIndex < headerArr.length) {
                        header = headerArr[dynamicTableIndex];
                    }
                }
                throw new IOException("Header index too large " + (i + 1));
            }
            header = Hpack.a[i];
            return header.name;
        }

        private void insertIntoDynamicTable(int i, Header header) {
            this.headerList.add(header);
            int i2 = header.a;
            if (i != -1) {
                i2 -= this.a[dynamicTableIndex(i)].a;
            }
            int i3 = this.maxDynamicTableByteCount;
            if (i2 > i3) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.d + i2) - i3);
            if (i == -1) {
                int i4 = this.c + 1;
                Header[] headerArr = this.a;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.b = this.a.length - 1;
                    this.a = headerArr2;
                }
                int i5 = this.b;
                this.b = i5 - 1;
                this.a[i5] = header;
                this.c++;
            } else {
                this.a[i + dynamicTableIndex(i) + evictToRecoverBytes] = header;
            }
            this.d += i2;
        }

        private boolean isStaticHeader(int i) {
            return i >= 0 && i <= Hpack.a.length - 1;
        }

        private int readByte() {
            return this.source.readByte() & 255;
        }

        private void readIndexedHeader(int i) {
            if (isStaticHeader(i)) {
                this.headerList.add(Hpack.a[i]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i - Hpack.a.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.a;
                if (dynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[dynamicTableIndex]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i) {
            insertIntoDynamicTable(-1, new Header(getName(i), a()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() {
            ByteString a = a();
            Hpack.a(a);
            insertIntoDynamicTable(-1, new Header(a, a()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i) {
            this.headerList.add(new Header(getName(i), a()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() {
            ByteString a = a();
            Hpack.a(a);
            this.headerList.add(new Header(a, a()));
        }

        int a(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i2 + (readByte << i4);
                }
                i2 += (readByte & Hpack.PREFIX_7_BITS) << i4;
                i4 += 7;
            }
        }

        ByteString a() {
            int readByte = readByte();
            boolean z = (readByte & 128) == 128;
            int a = a(readByte, Hpack.PREFIX_7_BITS);
            return z ? ByteString.of(Huffman.get().a(this.source.readByteArray(a))) : this.source.readByteString(a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            while (!this.source.exhausted()) {
                int readByte = this.source.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    readIndexedHeader(a(readByte, Hpack.PREFIX_7_BITS) - 1);
                } else if (readByte == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((readByte & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    this.maxDynamicTableByteCount = a(readByte, 31);
                    int i = this.maxDynamicTableByteCount;
                    if (i < 0 || i > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (readByte == 16 || readByte == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(a(readByte, 15) - 1);
                }
            }
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }
    }

    /* loaded from: classes3.dex */
    static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        int a;
        Header[] b;
        int c;
        int d;
        int e;
        private boolean emitDynamicTableSizeUpdate;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        Writer(int i, boolean z, Buffer buffer) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.b = new Header[8];
            this.c = this.b.length - 1;
            this.d = 0;
            this.e = 0;
            this.a = i;
            this.useCompression = z;
            this.out = buffer;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Writer(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void adjustDynamicTableByteCount() {
            int i = this.a;
            int i2 = this.e;
            if (i < i2) {
                if (i == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - i);
                }
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.b, (Object) null);
            this.c = this.b.length - 1;
            this.d = 0;
            this.e = 0;
        }

        private int evictToRecoverBytes(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.b.length;
                while (true) {
                    length--;
                    if (length < this.c || i <= 0) {
                        break;
                    }
                    Header[] headerArr = this.b;
                    i -= headerArr[length].a;
                    this.e -= headerArr[length].a;
                    this.d--;
                    i2++;
                }
                Header[] headerArr2 = this.b;
                int i3 = this.c;
                System.arraycopy(headerArr2, i3 + 1, headerArr2, i3 + 1 + i2, this.d);
                Header[] headerArr3 = this.b;
                int i4 = this.c;
                Arrays.fill(headerArr3, i4 + 1, i4 + 1 + i2, (Object) null);
                this.c += i2;
            }
            return i2;
        }

        private void insertIntoDynamicTable(Header header) {
            int i = header.a;
            int i2 = this.a;
            if (i > i2) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.e + i) - i2);
            int i3 = this.d + 1;
            Header[] headerArr = this.b;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.c = this.b.length - 1;
                this.b = headerArr2;
            }
            int i4 = this.c;
            this.c = i4 - 1;
            this.b[i4] = header;
            this.d++;
            this.e += i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(int i) {
            int min = Math.min(i, 16384);
            int i2 = this.a;
            if (i2 == min) {
                return;
            }
            if (min < i2) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.a = min;
            adjustDynamicTableByteCount();
        }

        void a(int i, int i2, int i3) {
            int i4;
            Buffer buffer;
            if (i < i2) {
                buffer = this.out;
                i4 = i | i3;
            } else {
                this.out.writeByte(i3 | i2);
                i4 = i - i2;
                while (i4 >= 128) {
                    this.out.writeByte(128 | (i4 & Hpack.PREFIX_7_BITS));
                    i4 >>>= 7;
                }
                buffer = this.out;
            }
            buffer.writeByte(i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(List<Header> list) {
            int i;
            int i2;
            if (this.emitDynamicTableSizeUpdate) {
                int i3 = this.smallestHeaderTableSizeSetting;
                if (i3 < this.a) {
                    a(i3, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                a(this.a, 31, 32);
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                Header header = list.get(i4);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Integer num = Hpack.b.get(asciiLowercase);
                if (num != null) {
                    i = num.intValue() + 1;
                    if (i > 1 && i < 8) {
                        if (Util.equal(Hpack.a[i - 1].value, byteString)) {
                            i2 = i;
                        } else if (Util.equal(Hpack.a[i].value, byteString)) {
                            i2 = i;
                            i++;
                        }
                    }
                    i2 = i;
                    i = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i == -1) {
                    int i5 = this.c + 1;
                    int length = this.b.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        if (Util.equal(this.b[i5].name, asciiLowercase)) {
                            if (Util.equal(this.b[i5].value, byteString)) {
                                i = Hpack.a.length + (i5 - this.c);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i5 - this.c) + Hpack.a.length;
                            }
                        }
                        i5++;
                    }
                }
                if (i != -1) {
                    a(i, Hpack.PREFIX_7_BITS, 128);
                } else {
                    if (i2 == -1) {
                        this.out.writeByte(64);
                        a(asciiLowercase);
                    } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || Header.TARGET_AUTHORITY.equals(asciiLowercase)) {
                        a(i2, 63, 64);
                    } else {
                        a(i2, 15, 0);
                        a(byteString);
                    }
                    a(byteString);
                    insertIntoDynamicTable(header);
                }
            }
        }

        void a(ByteString byteString) {
            int size;
            int i;
            if (!this.useCompression || Huffman.get().a(byteString) >= byteString.size()) {
                size = byteString.size();
                i = 0;
            } else {
                Buffer buffer = new Buffer();
                Huffman.get().a(byteString, buffer);
                byteString = buffer.readByteString();
                size = byteString.size();
                i = 128;
            }
            a(size, Hpack.PREFIX_7_BITS, i);
            this.out.write(byteString);
        }
    }

    private Hpack() {
    }

    static ByteString a(ByteString byteString) {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b2 = byteString.getByte(i);
            if (b2 >= 65 && b2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        int i = 0;
        while (true) {
            Header[] headerArr = a;
            if (i >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i].name)) {
                linkedHashMap.put(a[i].name, Integer.valueOf(i));
            }
            i++;
        }
    }
}
