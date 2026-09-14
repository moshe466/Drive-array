package io.grpc.protobuf.lite;

import com.google.common.base.Preconditions;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.ExperimentalApi;
import io.grpc.KnownLength;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

@ExperimentalApi("Experimental until Lite is stable in protobuf")
/* loaded from: classes2.dex */
public final class ProtoLiteUtils {
    private static final int BUF_SIZE = 8192;
    static volatile ExtensionRegistryLite a = ExtensionRegistryLite.getEmptyRegistry();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class MessageMarshaller<T extends MessageLite> implements MethodDescriptor.PrototypeMarshaller<T> {
        private static final ThreadLocal<Reference<byte[]>> bufs = new ThreadLocal<>();
        private final T defaultInstance;
        private final Parser<T> parser;

        MessageMarshaller(T t) {
            this.defaultInstance = t;
            this.parser = (Parser<T>) t.getParserForType();
        }

        private T parseFrom(CodedInputStream codedInputStream) {
            T parseFrom = this.parser.parseFrom(codedInputStream, ProtoLiteUtils.a);
            try {
                codedInputStream.checkLastTagWas(0);
                return parseFrom;
            } catch (InvalidProtocolBufferException e) {
                e.setUnfinishedMessage(parseFrom);
                throw e;
            }
        }

        @Override // io.grpc.MethodDescriptor.ReflectableMarshaller
        public Class<T> getMessageClass() {
            return (Class<T>) this.defaultInstance.getClass();
        }

        @Override // io.grpc.MethodDescriptor.PrototypeMarshaller
        public T getMessagePrototype() {
            return this.defaultInstance;
        }

        @Override // io.grpc.MethodDescriptor.Marshaller
        public T parse(InputStream inputStream) {
            byte[] bArr;
            if ((inputStream instanceof ProtoInputStream) && ((ProtoInputStream) inputStream).b() == this.parser) {
                try {
                    return (T) ((ProtoInputStream) inputStream).a();
                } catch (IllegalStateException unused) {
                }
            }
            CodedInputStream codedInputStream = null;
            try {
                if (inputStream instanceof KnownLength) {
                    int available = inputStream.available();
                    if (available > 0 && available <= 4194304) {
                        Reference<byte[]> reference = bufs.get();
                        if (reference == null || (bArr = reference.get()) == null || bArr.length < available) {
                            bArr = new byte[available];
                            bufs.set(new WeakReference(bArr));
                        }
                        int i = available;
                        while (i > 0) {
                            int read = inputStream.read(bArr, available - i, i);
                            if (read == -1) {
                                break;
                            }
                            i -= read;
                        }
                        if (i != 0) {
                            throw new RuntimeException("size inaccurate: " + available + " != " + (available - i));
                        }
                        codedInputStream = CodedInputStream.newInstance(bArr, 0, available);
                    } else if (available == 0) {
                        return this.defaultInstance;
                    }
                }
                if (codedInputStream == null) {
                    codedInputStream = CodedInputStream.newInstance(inputStream);
                }
                codedInputStream.setSizeLimit(Integer.MAX_VALUE);
                try {
                    return parseFrom(codedInputStream);
                } catch (InvalidProtocolBufferException e) {
                    throw Status.INTERNAL.withDescription("Invalid protobuf byte sequence").withCause(e).asRuntimeException();
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // io.grpc.MethodDescriptor.Marshaller
        public InputStream stream(T t) {
            return new ProtoInputStream(t, this.parser);
        }
    }

    /* loaded from: classes2.dex */
    private static final class MetadataMarshaller<T extends MessageLite> implements Metadata.BinaryMarshaller<T> {
        private final T defaultInstance;

        MetadataMarshaller(T t) {
            this.defaultInstance = t;
        }

        @Override // io.grpc.Metadata.BinaryMarshaller
        public T parseBytes(byte[] bArr) {
            try {
                return (T) this.defaultInstance.getParserForType().parseFrom(bArr, ProtoLiteUtils.a);
            } catch (InvalidProtocolBufferException e) {
                throw new IllegalArgumentException(e);
            }
        }

        @Override // io.grpc.Metadata.BinaryMarshaller
        public byte[] toBytes(T t) {
            return t.toByteArray();
        }
    }

    private ProtoLiteUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(InputStream inputStream, OutputStream outputStream) {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += read;
        }
    }

    public static <T extends MessageLite> MethodDescriptor.Marshaller<T> marshaller(T t) {
        return new MessageMarshaller(t);
    }

    public static <T extends MessageLite> Metadata.BinaryMarshaller<T> metadataMarshaller(T t) {
        return new MetadataMarshaller(t);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1787")
    public static void setExtensionRegistry(ExtensionRegistryLite extensionRegistryLite) {
        a = (ExtensionRegistryLite) Preconditions.checkNotNull(extensionRegistryLite, "newRegistry");
    }
}
