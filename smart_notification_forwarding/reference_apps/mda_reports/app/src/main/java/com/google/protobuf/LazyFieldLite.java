package com.google.protobuf;

/* loaded from: classes2.dex */
public class LazyFieldLite {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    protected volatile MessageLite a;
    private ByteString delayedBytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile ByteString memoizedBytes;

    public LazyFieldLite() {
    }

    public LazyFieldLite(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        checkArguments(extensionRegistryLite, byteString);
        this.extensionRegistry = extensionRegistryLite;
        this.delayedBytes = byteString;
    }

    private static void checkArguments(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        if (extensionRegistryLite == null) {
            throw new NullPointerException("found null ExtensionRegistry");
        }
        if (byteString == null) {
            throw new NullPointerException("found null ByteString");
        }
    }

    public static LazyFieldLite fromValue(MessageLite messageLite) {
        LazyFieldLite lazyFieldLite = new LazyFieldLite();
        lazyFieldLite.setValue(messageLite);
        return lazyFieldLite;
    }

    private static MessageLite mergeValueAndBytes(MessageLite messageLite, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return messageLite.toBuilder().mergeFrom(byteString, extensionRegistryLite).build();
        } catch (InvalidProtocolBufferException unused) {
            return messageLite;
        }
    }

    protected void a(MessageLite messageLite) {
        ByteString byteString;
        if (this.a != null) {
            return;
        }
        synchronized (this) {
            if (this.a != null) {
                return;
            }
            try {
                if (this.delayedBytes != null) {
                    this.a = messageLite.getParserForType().parseFrom(this.delayedBytes, this.extensionRegistry);
                    byteString = this.delayedBytes;
                } else {
                    this.a = messageLite;
                    byteString = ByteString.EMPTY;
                }
                this.memoizedBytes = byteString;
            } catch (InvalidProtocolBufferException unused) {
                this.a = messageLite;
                this.memoizedBytes = ByteString.EMPTY;
            }
        }
    }

    public void clear() {
        this.delayedBytes = null;
        this.a = null;
        this.memoizedBytes = null;
    }

    public boolean containsDefaultInstance() {
        ByteString byteString;
        return this.memoizedBytes == ByteString.EMPTY || (this.a == null && ((byteString = this.delayedBytes) == null || byteString == ByteString.EMPTY));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.a;
        MessageLite messageLite2 = lazyFieldLite.a;
        return (messageLite == null && messageLite2 == null) ? toByteString().equals(lazyFieldLite.toByteString()) : (messageLite == null || messageLite2 == null) ? messageLite != null ? messageLite.equals(lazyFieldLite.getValue(messageLite.getDefaultInstanceForType())) : getValue(messageLite2.getDefaultInstanceForType()).equals(messageLite2) : messageLite.equals(messageLite2);
    }

    public int getSerializedSize() {
        if (this.memoizedBytes != null) {
            return this.memoizedBytes.size();
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.a != null) {
            return this.a.getSerializedSize();
        }
        return 0;
    }

    public MessageLite getValue(MessageLite messageLite) {
        a(messageLite);
        return this.a;
    }

    public int hashCode() {
        return 1;
    }

    public void merge(LazyFieldLite lazyFieldLite) {
        ByteString byteString;
        if (lazyFieldLite.containsDefaultInstance()) {
            return;
        }
        if (containsDefaultInstance()) {
            set(lazyFieldLite);
            return;
        }
        if (this.extensionRegistry == null) {
            this.extensionRegistry = lazyFieldLite.extensionRegistry;
        }
        ByteString byteString2 = this.delayedBytes;
        if (byteString2 != null && (byteString = lazyFieldLite.delayedBytes) != null) {
            this.delayedBytes = byteString2.concat(byteString);
            return;
        }
        if (this.a == null && lazyFieldLite.a != null) {
            setValue(mergeValueAndBytes(lazyFieldLite.a, this.delayedBytes, this.extensionRegistry));
            return;
        }
        if (this.a != null && lazyFieldLite.a == null) {
            setValue(mergeValueAndBytes(this.a, lazyFieldLite.delayedBytes, lazyFieldLite.extensionRegistry));
            return;
        }
        if (lazyFieldLite.extensionRegistry != null) {
            setValue(mergeValueAndBytes(this.a, lazyFieldLite.toByteString(), lazyFieldLite.extensionRegistry));
        } else if (this.extensionRegistry != null) {
            setValue(mergeValueAndBytes(lazyFieldLite.a, toByteString(), this.extensionRegistry));
        } else {
            setValue(mergeValueAndBytes(this.a, lazyFieldLite.toByteString(), EMPTY_REGISTRY));
        }
    }

    public void mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ByteString concat;
        if (containsDefaultInstance()) {
            concat = codedInputStream.readBytes();
        } else {
            if (this.extensionRegistry == null) {
                this.extensionRegistry = extensionRegistryLite;
            }
            ByteString byteString = this.delayedBytes;
            if (byteString == null) {
                try {
                    setValue(this.a.toBuilder().mergeFrom(codedInputStream, extensionRegistryLite).build());
                    return;
                } catch (InvalidProtocolBufferException unused) {
                    return;
                }
            } else {
                concat = byteString.concat(codedInputStream.readBytes());
                extensionRegistryLite = this.extensionRegistry;
            }
        }
        setByteString(concat, extensionRegistryLite);
    }

    public void set(LazyFieldLite lazyFieldLite) {
        this.delayedBytes = lazyFieldLite.delayedBytes;
        this.a = lazyFieldLite.a;
        this.memoizedBytes = lazyFieldLite.memoizedBytes;
        ExtensionRegistryLite extensionRegistryLite = lazyFieldLite.extensionRegistry;
        if (extensionRegistryLite != null) {
            this.extensionRegistry = extensionRegistryLite;
        }
    }

    public void setByteString(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        checkArguments(extensionRegistryLite, byteString);
        this.delayedBytes = byteString;
        this.extensionRegistry = extensionRegistryLite;
        this.a = null;
        this.memoizedBytes = null;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.a;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.a = messageLite;
        return messageLite2;
    }

    public ByteString toByteString() {
        if (this.memoizedBytes != null) {
            return this.memoizedBytes;
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.memoizedBytes != null) {
                return this.memoizedBytes;
            }
            this.memoizedBytes = this.a == null ? ByteString.EMPTY : this.a.toByteString();
            return this.memoizedBytes;
        }
    }
}
