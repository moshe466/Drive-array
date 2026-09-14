package D2;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class a extends ByteArrayOutputStream {
    public final byte[] a() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        j.d(buf, "buf");
        return buf;
    }
}
