package org.apache.tika.extractor;

import J.C0119g;
import a3.c;
import b3.a;
import b3.d;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import f3.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.pipes.extractor.EmbeddedDocumentBytesConfig;

/* loaded from: classes.dex */
public class BasicEmbeddedDocumentBytesHandler extends AbstractEmbeddedDocumentBytesHandler {
    private final EmbeddedDocumentBytesConfig config;
    Map<Integer, byte[]> docBytes = new HashMap();

    public BasicEmbeddedDocumentBytesHandler(EmbeddedDocumentBytesConfig embeddedDocumentBytesConfig) {
        this.config = embeddedDocumentBytesConfig;
    }

    @Override // org.apache.tika.extractor.AbstractEmbeddedDocumentBytesHandler, org.apache.tika.extractor.EmbeddedDocumentBytesHandler
    public void add(int i, Metadata metadata, InputStream inputStream) {
        super.add(i, metadata, inputStream);
        Map<Integer, byte[]> map = this.docBytes;
        Integer valueOf = Integer.valueOf(i);
        byte[] bArr = c.f2765a;
        int i3 = f3.c.f4619f;
        new d();
        f3.c cVar = new f3.c();
        b bVar = new b(new C0119g(14), new J0.d(cVar, 6));
        try {
            c.b(inputStream, bVar);
            byte[] b4 = cVar.b();
            bVar.close();
            map.put(valueOf, b4);
        } catch (Throwable th) {
            try {
                bVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [e3.g, java.io.InputStream] */
    public InputStream getDocument(int i) {
        d dVar = new d();
        dVar.f3807c = new a(this.docBytes.get(Integer.valueOf(i)));
        a aVar = dVar.f3807c;
        if (aVar != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) aVar.f3806c);
            ?? inputStream = new InputStream();
            inputStream.f4462a = byteArrayInputStream;
            inputStream.f4466e = -1;
            inputStream.f4463b = new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
            return inputStream;
        }
        throw new IllegalStateException("origin == null");
    }
}
