package io.grpc;

import java.io.OutputStream;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
/* loaded from: classes2.dex */
public interface Compressor {
    OutputStream compress(OutputStream outputStream);

    String getMessageEncoding();
}
