package io.grpc;

import java.io.InputStream;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
/* loaded from: classes2.dex */
public interface Decompressor {
    InputStream decompress(InputStream inputStream);

    String getMessageEncoding();
}
