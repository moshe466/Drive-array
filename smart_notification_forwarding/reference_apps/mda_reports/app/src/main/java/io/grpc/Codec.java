package io.grpc;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
/* loaded from: classes2.dex */
public interface Codec extends Compressor, Decompressor {

    /* loaded from: classes2.dex */
    public static final class Gzip implements Codec {
        @Override // io.grpc.Compressor
        public OutputStream compress(OutputStream outputStream) {
            return new GZIPOutputStream(outputStream);
        }

        @Override // io.grpc.Decompressor
        public InputStream decompress(InputStream inputStream) {
            return new GZIPInputStream(inputStream);
        }

        @Override // io.grpc.Compressor, io.grpc.Decompressor
        public String getMessageEncoding() {
            return HttpRequest.ENCODING_GZIP;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Identity implements Codec {
        public static final Codec NONE = new Identity();

        private Identity() {
        }

        @Override // io.grpc.Compressor
        public OutputStream compress(OutputStream outputStream) {
            return outputStream;
        }

        @Override // io.grpc.Decompressor
        public InputStream decompress(InputStream inputStream) {
            return inputStream;
        }

        @Override // io.grpc.Compressor, io.grpc.Decompressor
        public String getMessageEncoding() {
            return "identity";
        }
    }
}
