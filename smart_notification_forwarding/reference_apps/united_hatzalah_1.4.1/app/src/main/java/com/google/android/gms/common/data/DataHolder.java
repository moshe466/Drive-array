package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new zad();
    private static final Builder zak = new zab(new String[0], null);
    final int zaa;
    Bundle zab;
    int[] zac;
    int zad;
    int zae;
    private final String[] zaf;
    private final CursorWindow[] zag;
    private final int zah;
    private final Bundle zai;
    private boolean zaj;

    /* loaded from: classes.dex */
    public static class Builder {
        private final String[] zaa;
        private final ArrayList zab = new ArrayList();
        private final HashMap zac = new HashMap();

        public /* synthetic */ Builder(String[] strArr, String str, byte[] bArr) {
            this.zaa = (String[]) Preconditions.checkNotNull(strArr);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DataHolder build(int i) {
            return new DataHolder(this, i, (Bundle) null, (byte[]) (0 == true ? 1 : 0));
        }

        public Builder withRow(ContentValues contentValues) {
            Asserts.checkNotNull(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            return zaa(hashMap);
        }

        public Builder zaa(HashMap hashMap) {
            Asserts.checkNotNull(hashMap);
            this.zab.add(hashMap);
            return this;
        }

        public final /* synthetic */ String[] zab() {
            return this.zaa;
        }

        public final /* synthetic */ ArrayList zac() {
            return this.zab;
        }

        public DataHolder build(int i, Bundle bundle) {
            return new DataHolder(this, i, bundle, -1, (byte[]) null);
        }
    }

    public /* synthetic */ DataHolder(Builder builder, int i, Bundle bundle, byte[] bArr) {
        this(builder, i, (Bundle) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Builder builder(String[] strArr) {
        return new Builder(strArr, null, 0 == true ? 1 : 0);
    }

    public static DataHolder empty(int i) {
        return new DataHolder(zak, i, (Bundle) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x013b, code lost:
    
        if (r7 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013d, code lost:
    
        new java.lang.StringBuilder(java.lang.String.valueOf(r6).length() + 63);
        r4.freeLastRow();
        r4 = new android.database.CursorWindow(false);
        r4.setStartPosition(r6);
        r4.setNumColumns(r14.zab().length);
        r5.add(r4);
        r6 = r6 - 1;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0165, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x016f, code lost:
    
        throw new com.google.android.gms.common.data.zac("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.database.CursorWindow[] zae(com.google.android.gms.common.data.DataHolder.Builder r14, int r15) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.zae(com.google.android.gms.common.data.DataHolder$Builder, int):android.database.CursorWindow[]");
    }

    private final void zaf(String str, int i) {
        Bundle bundle = this.zab;
        if (bundle != null && bundle.containsKey(str)) {
            if (!isClosed()) {
                if (i >= 0 && i < this.zad) {
                    return;
                } else {
                    throw new CursorIndexOutOfBoundsException(i, this.zad);
                }
            }
            throw new IllegalArgumentException("Buffer is closed.");
        }
        throw new IllegalArgumentException("No such column: ".concat(String.valueOf(str)));
    }

    public void acquireReference() {
        synchronized (this) {
            try {
                int i = this.zae;
                if (i > 0) {
                    this.zae = i + 1;
                } else {
                    throw new IllegalStateException("Attempt to acquire reference to an already-closed DataHolder");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        releaseReference();
    }

    public DataHolder copy() {
        DataHolder dataHolder;
        synchronized (this) {
            if (!isClosed()) {
                CursorWindow[] cursorWindowArr = this.zag;
                CursorWindow[] cursorWindowArr2 = (CursorWindow[]) Arrays.copyOf(cursorWindowArr, cursorWindowArr.length);
                for (int i = 0; i < cursorWindowArr2.length; i++) {
                    try {
                        cursorWindowArr2[i].acquireReference();
                    } catch (RuntimeException e4) {
                        for (int i3 = 0; i3 < i; i3++) {
                            cursorWindowArr2[i3].releaseReference();
                        }
                        if (e4 instanceof IllegalStateException) {
                            throw new IllegalStateException("Closed CursorWindow encountered during DataHolder copy", e4);
                        }
                        throw e4;
                    }
                }
                dataHolder = new DataHolder(this.zaf, cursorWindowArr2, this.zah, this.zai);
            } else {
                throw new IllegalStateException("Cannot copy a closed DataHolder");
            }
        }
        return dataHolder;
    }

    public final void finalize() {
        try {
            if (this.zaj && this.zag.length > 0 && !isClosed()) {
                synchronized (this) {
                    try {
                        if (this.zae > 1) {
                            this.zae = 1;
                        }
                        releaseReference();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    public boolean getBoolean(String str, int i, int i3) {
        zaf(str, i);
        if (this.zag[i3].getLong(i, this.zab.getInt(str)) == 1) {
            return true;
        }
        return false;
    }

    public byte[] getByteArray(String str, int i, int i3) {
        zaf(str, i);
        return this.zag[i3].getBlob(i, this.zab.getInt(str));
    }

    public int getCount() {
        return this.zad;
    }

    public int getInteger(String str, int i, int i3) {
        zaf(str, i);
        return this.zag[i3].getInt(i, this.zab.getInt(str));
    }

    public long getLong(String str, int i, int i3) {
        zaf(str, i);
        return this.zag[i3].getLong(i, this.zab.getInt(str));
    }

    public Bundle getMetadata() {
        return this.zai;
    }

    public int getStatusCode() {
        return this.zah;
    }

    public String getString(String str, int i, int i3) {
        zaf(str, i);
        return this.zag[i3].getString(i, this.zab.getInt(str));
    }

    public int getWindowIndex(int i) {
        boolean z3;
        int length;
        int i3 = 0;
        if (i >= 0 && i < this.zad) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        while (true) {
            int[] iArr = this.zac;
            length = iArr.length;
            if (i3 >= length) {
                break;
            }
            if (i < iArr[i3]) {
                i3--;
                break;
            }
            i3++;
        }
        if (i3 == length) {
            return i3 - 1;
        }
        return i3;
    }

    public boolean hasColumn(String str) {
        return this.zab.containsKey(str);
    }

    public boolean hasNull(String str, int i, int i3) {
        zaf(str, i);
        return this.zag[i3].isNull(i, this.zab.getInt(str));
    }

    public boolean isClosed() {
        boolean z3;
        synchronized (this) {
            if (this.zae <= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    public void releaseReference() {
        synchronized (this) {
            try {
                int i = this.zae - 1;
                this.zae = i;
                if (i == 0) {
                    for (CursorWindow cursorWindow : this.zag) {
                        cursorWindow.releaseReference();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String[] strArr = this.zaf;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, strArr, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zag, i, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zaa);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i & 1) != 0) {
            releaseReference();
        }
    }

    public final void zaa() {
        this.zab = new Bundle();
        int i = 0;
        while (true) {
            String[] strArr = this.zaf;
            if (i >= strArr.length) {
                break;
            }
            this.zab.putInt(strArr[i], i);
            i++;
        }
        CursorWindow[] cursorWindowArr = this.zag;
        this.zac = new int[cursorWindowArr.length];
        int i3 = 0;
        for (int i4 = 0; i4 < cursorWindowArr.length; i4++) {
            this.zac[i4] = i3;
            i3 += cursorWindowArr[i4].getNumRows() - (i3 - cursorWindowArr[i4].getStartPosition());
        }
        this.zad = i3;
    }

    public final float zab(String str, int i, int i3) {
        zaf(str, i);
        return this.zag[i3].getFloat(i, this.zab.getInt(str));
    }

    public final double zac(String str, int i, int i3) {
        zaf(str, i);
        return this.zag[i3].getDouble(i, this.zab.getInt(str));
    }

    public final void zad(String str, int i, int i3, CharArrayBuffer charArrayBuffer) {
        zaf(str, i);
        this.zag[i3].copyStringToBuffer(i, this.zab.getInt(str), charArrayBuffer);
    }

    public DataHolder(int i, String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        this.zae = 1;
        this.zaj = true;
        this.zaa = i;
        this.zaf = strArr;
        this.zag = cursorWindowArr;
        this.zah = i3;
        this.zai = bundle;
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i, Bundle bundle) {
        this.zae = 1;
        this.zaj = true;
        this.zaa = 1;
        this.zaf = (String[]) Preconditions.checkNotNull(strArr);
        this.zag = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.zah = i;
        this.zai = bundle;
        zaa();
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public DataHolder(android.database.Cursor r8, int r9, android.os.Bundle r10) {
        /*
            r7 = this;
            com.google.android.gms.common.sqlite.CursorWrapper r0 = new com.google.android.gms.common.sqlite.CursorWrapper
            r0.<init>(r8)
            java.lang.String[] r8 = r0.getColumnNames()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.getCount()     // Catch: java.lang.Throwable -> L2e
            android.database.CursorWindow r3 = r0.getWindow()     // Catch: java.lang.Throwable -> L2e
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L30
            int r6 = r3.getStartPosition()     // Catch: java.lang.Throwable -> L2e
            if (r6 != 0) goto L30
            r3.acquireReference()     // Catch: java.lang.Throwable -> L2e
            r0.setWindow(r4)     // Catch: java.lang.Throwable -> L2e
            r1.add(r3)     // Catch: java.lang.Throwable -> L2e
            int r3 = r3.getNumRows()     // Catch: java.lang.Throwable -> L2e
            goto L31
        L2e:
            r8 = move-exception
            goto L78
        L30:
            r3 = r5
        L31:
            if (r3 >= r2) goto L65
            boolean r6 = r0.moveToPosition(r3)     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto L65
            android.database.CursorWindow r6 = r0.getWindow()     // Catch: java.lang.Throwable -> L2e
            if (r6 == 0) goto L46
            r6.acquireReference()     // Catch: java.lang.Throwable -> L2e
            r0.setWindow(r4)     // Catch: java.lang.Throwable -> L2e
            goto L51
        L46:
            android.database.CursorWindow r6 = new android.database.CursorWindow     // Catch: java.lang.Throwable -> L2e
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L2e
            r6.setStartPosition(r3)     // Catch: java.lang.Throwable -> L2e
            r0.fillWindow(r3, r6)     // Catch: java.lang.Throwable -> L2e
        L51:
            int r3 = r6.getNumRows()     // Catch: java.lang.Throwable -> L2e
            if (r3 != 0) goto L58
            goto L65
        L58:
            r1.add(r6)     // Catch: java.lang.Throwable -> L2e
            int r3 = r6.getStartPosition()     // Catch: java.lang.Throwable -> L2e
            int r6 = r6.getNumRows()     // Catch: java.lang.Throwable -> L2e
            int r3 = r3 + r6
            goto L31
        L65:
            r0.close()
            int r0 = r1.size()
            android.database.CursorWindow[] r0 = new android.database.CursorWindow[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            android.database.CursorWindow[] r0 = (android.database.CursorWindow[]) r0
            r7.<init>(r8, r0, r9, r10)
            return
        L78:
            r0.close()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.<init>(android.database.Cursor, int, android.os.Bundle):void");
    }

    private DataHolder(Builder builder, int i, Bundle bundle) {
        this(builder.zab(), zae(builder, -1), i, (Bundle) null);
    }

    public /* synthetic */ DataHolder(Builder builder, int i, Bundle bundle, int i3, byte[] bArr) {
        this(builder.zab(), zae(builder, -1), i, bundle);
    }
}
