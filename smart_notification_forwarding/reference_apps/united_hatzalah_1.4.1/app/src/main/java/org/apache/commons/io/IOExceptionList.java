package org.apache.commons.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class IOExceptionList extends IOException implements Iterable<Throwable> {
    @Override // java.lang.Iterable
    public final Iterator<Throwable> iterator() {
        return new ArrayList((Collection) null).iterator();
    }
}
