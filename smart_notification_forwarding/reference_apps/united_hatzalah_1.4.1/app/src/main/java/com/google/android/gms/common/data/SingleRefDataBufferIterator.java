package com.google.android.gms.common.data;

import F0.AbstractC0008a;
import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    private Object zac;

    public SingleRefDataBufferIterator(DataBuffer dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.google.android.gms.common.data.DataBufferIterator, java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            int i = this.zab + 1;
            this.zab = i;
            if (i == 0) {
                Object checkNotNull = Preconditions.checkNotNull(this.zaa.get(0));
                this.zac = checkNotNull;
                if (!(checkNotNull instanceof DataBufferRef)) {
                    String valueOf = String.valueOf(checkNotNull.getClass());
                    throw new IllegalStateException(AbstractC0008a.v(new StringBuilder(valueOf.length() + 44), "DataBuffer reference of type ", valueOf, " is not movable"));
                }
            } else {
                ((DataBufferRef) Preconditions.checkNotNull(this.zac)).zaa(this.zab);
            }
            return this.zac;
        }
        int i3 = this.zab;
        throw new NoSuchElementException(AbstractC0008a.t(new StringBuilder(String.valueOf(i3).length() + 35), "Cannot advance the iterator beyond ", i3));
    }
}
