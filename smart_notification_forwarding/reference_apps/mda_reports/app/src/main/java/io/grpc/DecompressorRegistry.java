package io.grpc;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import io.grpc.Codec;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
@ThreadSafe
/* loaded from: classes2.dex */
public final class DecompressorRegistry {
    private final byte[] advertisedDecompressors;
    private final Map<String, DecompressorInfo> decompressors;
    static final Joiner a = Joiner.on(',');
    private static final DecompressorRegistry DEFAULT_INSTANCE = emptyInstance().with(new Codec.Gzip(), true).with(Codec.Identity.NONE, false);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class DecompressorInfo {
        final Decompressor a;
        final boolean b;

        DecompressorInfo(Decompressor decompressor, boolean z) {
            this.a = (Decompressor) Preconditions.checkNotNull(decompressor, "decompressor");
            this.b = z;
        }
    }

    private DecompressorRegistry() {
        this.decompressors = new LinkedHashMap(0);
        this.advertisedDecompressors = new byte[0];
    }

    private DecompressorRegistry(Decompressor decompressor, boolean z, DecompressorRegistry decompressorRegistry) {
        String messageEncoding = decompressor.getMessageEncoding();
        Preconditions.checkArgument(!messageEncoding.contains(","), "Comma is currently not allowed in message encoding");
        int size = decompressorRegistry.decompressors.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(decompressorRegistry.decompressors.containsKey(decompressor.getMessageEncoding()) ? size : size + 1);
        for (DecompressorInfo decompressorInfo : decompressorRegistry.decompressors.values()) {
            String messageEncoding2 = decompressorInfo.a.getMessageEncoding();
            if (!messageEncoding2.equals(messageEncoding)) {
                linkedHashMap.put(messageEncoding2, new DecompressorInfo(decompressorInfo.a, decompressorInfo.b));
            }
        }
        linkedHashMap.put(messageEncoding, new DecompressorInfo(decompressor, z));
        this.decompressors = Collections.unmodifiableMap(linkedHashMap);
        this.advertisedDecompressors = a.join(getAdvertisedMessageEncodings()).getBytes(Charset.forName("US-ASCII"));
    }

    public static DecompressorRegistry emptyInstance() {
        return new DecompressorRegistry();
    }

    public static DecompressorRegistry getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.advertisedDecompressors;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public Set<String> getAdvertisedMessageEncodings() {
        HashSet hashSet = new HashSet(this.decompressors.size());
        for (Map.Entry<String, DecompressorInfo> entry : this.decompressors.entrySet()) {
            if (entry.getValue().b) {
                hashSet.add(entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public Set<String> getKnownMessageEncodings() {
        return this.decompressors.keySet();
    }

    @Nullable
    public Decompressor lookupDecompressor(String str) {
        DecompressorInfo decompressorInfo = this.decompressors.get(str);
        if (decompressorInfo != null) {
            return decompressorInfo.a;
        }
        return null;
    }

    public DecompressorRegistry with(Decompressor decompressor, boolean z) {
        return new DecompressorRegistry(decompressor, z, this);
    }
}
