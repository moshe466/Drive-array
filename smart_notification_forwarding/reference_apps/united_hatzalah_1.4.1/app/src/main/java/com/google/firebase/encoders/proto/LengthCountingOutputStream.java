package com.google.firebase.encoders.proto;

import java.io.OutputStream;

/* loaded from: classes.dex */
final class LengthCountingOutputStream extends OutputStream {
    private long length = 0;

    public long getLength() {
        return this.length;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.length++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.length += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i3) {
        int i4;
        if (i >= 0 && i <= bArr.length && i3 >= 0 && (i4 = i + i3) <= bArr.length && i4 >= 0) {
            this.length += i3;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
