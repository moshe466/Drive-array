package org.apache.tika.fork;

import java.lang.ref.WeakReference;
import java.net.URL;

/* loaded from: classes.dex */
class MemoryURLStreamRecord {
    public byte[] data;
    public WeakReference<URL> url;
}
