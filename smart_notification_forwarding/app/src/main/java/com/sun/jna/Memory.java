package com.sun.jna;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Memory extends Pointer {
    private static LinkedReference HEAD;
    private static ReferenceQueue<Memory> QUEUE = new ReferenceQueue<>();
    private static final WeakMemoryHolder buffers = new WeakMemoryHolder();
    private final LinkedReference reference;
    protected long size;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LinkedReference extends WeakReference<Memory> {
        private LinkedReference next;
        private LinkedReference prev;

        private LinkedReference(Memory memory) {
            super(memory, Memory.QUEUE);
        }

        static LinkedReference track(Memory memory) {
            synchronized (Memory.QUEUE) {
                while (true) {
                    LinkedReference linkedReference = (LinkedReference) Memory.QUEUE.poll();
                    if (linkedReference == null) {
                        break;
                    }
                    linkedReference.unlink();
                }
            }
            LinkedReference linkedReference2 = new LinkedReference(memory);
            synchronized (LinkedReference.class) {
                if (Memory.HEAD != null) {
                    linkedReference2.next = Memory.HEAD;
                    Memory.HEAD.prev = linkedReference2;
                    LinkedReference unused = Memory.HEAD = linkedReference2;
                } else {
                    LinkedReference unused2 = Memory.HEAD = linkedReference2;
                }
            }
            return linkedReference2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void unlink() {
            LinkedReference linkedReference;
            synchronized (LinkedReference.class) {
                if (Memory.HEAD == this) {
                    linkedReference = Memory.HEAD = Memory.HEAD.next;
                } else {
                    LinkedReference linkedReference2 = this.prev;
                    if (linkedReference2 == null) {
                        return;
                    }
                    linkedReference = this.next;
                    linkedReference2.next = linkedReference;
                }
                if (linkedReference != null) {
                    linkedReference.prev = this.prev;
                }
                this.prev = null;
            }
        }
    }

    public static void purge() {
        buffers.clean();
    }

    public static void disposeAll() {
        LinkedReference linkedReference;
        synchronized (LinkedReference.class) {
            do {
                linkedReference = HEAD;
                if (linkedReference != null) {
                    Memory memory = (Memory) linkedReference.get();
                    if (memory == null) {
                        HEAD.unlink();
                    } else {
                        memory.dispose();
                    }
                }
            } while (HEAD != linkedReference);
            throw new IllegalStateException("the HEAD did not change");
        }
        synchronized (QUEUE) {
            while (true) {
                LinkedReference linkedReference2 = (LinkedReference) QUEUE.poll();
                if (linkedReference2 != null) {
                    linkedReference2.unlink();
                }
            }
        }
    }

    static int integrityCheck() {
        synchronized (LinkedReference.class) {
            if (HEAD == null) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            for (LinkedReference linkedReference = HEAD; linkedReference != null; linkedReference = linkedReference.next) {
                arrayList.add(linkedReference);
            }
            int size = arrayList.size() - 1;
            LinkedReference linkedReference2 = (LinkedReference) arrayList.get(size);
            while (linkedReference2 != null) {
                if (arrayList.get(size) == linkedReference2) {
                    linkedReference2 = linkedReference2.prev;
                    size--;
                } else {
                    throw new IllegalStateException(arrayList.get(size) + " vs. " + linkedReference2 + " at index " + size);
                }
            }
            return arrayList.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class SharedMemory extends Memory {
        public SharedMemory(long j, long j2) {
            this.size = j2;
            this.peer = Memory.this.peer + j;
        }

        @Override // com.sun.jna.Memory
        protected synchronized void dispose() {
            this.peer = 0L;
        }

        @Override // com.sun.jna.Memory
        protected void boundsCheck(long j, long j2) {
            Memory.this.boundsCheck((this.peer - Memory.this.peer) + j, j2);
        }

        @Override // com.sun.jna.Memory, com.sun.jna.Pointer
        public String toString() {
            return super.toString() + " (shared from " + Memory.this.toString() + ")";
        }
    }

    public Memory(long j) {
        this.size = j;
        if (j <= 0) {
            throw new IllegalArgumentException("Allocation size must be greater than zero");
        }
        this.peer = malloc(j);
        if (this.peer == 0) {
            throw new OutOfMemoryError("Cannot allocate " + j + " bytes");
        }
        this.reference = LinkedReference.track(this);
    }

    protected Memory() {
        this.reference = null;
    }

    @Override // com.sun.jna.Pointer
    public Pointer share(long j) {
        return share(j, size() - j);
    }

    @Override // com.sun.jna.Pointer
    public Pointer share(long j, long j2) {
        boundsCheck(j, j2);
        return new SharedMemory(j, j2);
    }

    public Memory align(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Byte boundary must be positive: " + i);
        }
        for (int i2 = 0; i2 < 32; i2++) {
            if (i == (1 << i2)) {
                long j = i;
                long j2 = ~(j - 1);
                if ((this.peer & j2) == this.peer) {
                    return this;
                }
                long j3 = ((this.peer + j) - 1) & j2;
                long j4 = (this.peer + this.size) - j3;
                if (j4 <= 0) {
                    throw new IllegalArgumentException("Insufficient memory to align to the requested boundary");
                }
                return (Memory) share(j3 - this.peer, j4);
            }
        }
        throw new IllegalArgumentException("Byte boundary must be a power of two");
    }

    protected void finalize() {
        dispose();
    }

    protected synchronized void dispose() {
        if (this.peer == 0) {
            return;
        }
        try {
            free(this.peer);
        } finally {
            this.peer = 0L;
            this.reference.unlink();
        }
    }

    public void clear() {
        clear(this.size);
    }

    public boolean valid() {
        return this.peer != 0;
    }

    public long size() {
        return this.size;
    }

    protected void boundsCheck(long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("Invalid offset: " + j);
        }
        long j3 = j + j2;
        if (j3 > this.size) {
            throw new IndexOutOfBoundsException("Bounds exceeds available space : size=" + this.size + ", offset=" + j3);
        }
    }

    @Override // com.sun.jna.Pointer
    public void read(long j, byte[] bArr, int i, int i2) {
        boundsCheck(j, i2 * 1);
        super.read(j, bArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j, short[] sArr, int i, int i2) {
        boundsCheck(j, i2 * 2);
        super.read(j, sArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j, char[] cArr, int i, int i2) {
        boundsCheck(j, Native.WCHAR_SIZE * i2);
        super.read(j, cArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j, int[] iArr, int i, int i2) {
        boundsCheck(j, i2 * 4);
        super.read(j, iArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j, long[] jArr, int i, int i2) {
        boundsCheck(j, i2 * 8);
        super.read(j, jArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j, float[] fArr, int i, int i2) {
        boundsCheck(j, i2 * 4);
        super.read(j, fArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j, double[] dArr, int i, int i2) {
        boundsCheck(j, i2 * 8);
        super.read(j, dArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j, Pointer[] pointerArr, int i, int i2) {
        boundsCheck(j, Native.POINTER_SIZE * i2);
        super.read(j, pointerArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j, byte[] bArr, int i, int i2) {
        boundsCheck(j, i2 * 1);
        super.write(j, bArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j, short[] sArr, int i, int i2) {
        boundsCheck(j, i2 * 2);
        super.write(j, sArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j, char[] cArr, int i, int i2) {
        boundsCheck(j, Native.WCHAR_SIZE * i2);
        super.write(j, cArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j, int[] iArr, int i, int i2) {
        boundsCheck(j, i2 * 4);
        super.write(j, iArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j, long[] jArr, int i, int i2) {
        boundsCheck(j, i2 * 8);
        super.write(j, jArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j, float[] fArr, int i, int i2) {
        boundsCheck(j, i2 * 4);
        super.write(j, fArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j, double[] dArr, int i, int i2) {
        boundsCheck(j, i2 * 8);
        super.write(j, dArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j, Pointer[] pointerArr, int i, int i2) {
        boundsCheck(j, Native.POINTER_SIZE * i2);
        super.write(j, pointerArr, i, i2);
    }

    @Override // com.sun.jna.Pointer
    public byte getByte(long j) {
        boundsCheck(j, 1L);
        return super.getByte(j);
    }

    @Override // com.sun.jna.Pointer
    public char getChar(long j) {
        boundsCheck(j, Native.WCHAR_SIZE);
        return super.getChar(j);
    }

    @Override // com.sun.jna.Pointer
    public short getShort(long j) {
        boundsCheck(j, 2L);
        return super.getShort(j);
    }

    @Override // com.sun.jna.Pointer
    public int getInt(long j) {
        boundsCheck(j, 4L);
        return super.getInt(j);
    }

    @Override // com.sun.jna.Pointer
    public long getLong(long j) {
        boundsCheck(j, 8L);
        return super.getLong(j);
    }

    @Override // com.sun.jna.Pointer
    public float getFloat(long j) {
        boundsCheck(j, 4L);
        return super.getFloat(j);
    }

    @Override // com.sun.jna.Pointer
    public double getDouble(long j) {
        boundsCheck(j, 8L);
        return super.getDouble(j);
    }

    @Override // com.sun.jna.Pointer
    public Pointer getPointer(long j) {
        boundsCheck(j, Native.POINTER_SIZE);
        return shareReferenceIfInBounds(super.getPointer(j));
    }

    @Override // com.sun.jna.Pointer
    public ByteBuffer getByteBuffer(long j, long j2) {
        boundsCheck(j, j2);
        ByteBuffer byteBuffer = super.getByteBuffer(j, j2);
        buffers.put(byteBuffer, this);
        return byteBuffer;
    }

    @Override // com.sun.jna.Pointer
    public String getString(long j, String str) {
        boundsCheck(j, 0L);
        return super.getString(j, str);
    }

    @Override // com.sun.jna.Pointer
    public String getWideString(long j) {
        boundsCheck(j, 0L);
        return super.getWideString(j);
    }

    @Override // com.sun.jna.Pointer
    public void setByte(long j, byte b) {
        boundsCheck(j, 1L);
        super.setByte(j, b);
    }

    @Override // com.sun.jna.Pointer
    public void setChar(long j, char c) {
        boundsCheck(j, Native.WCHAR_SIZE);
        super.setChar(j, c);
    }

    @Override // com.sun.jna.Pointer
    public void setShort(long j, short s) {
        boundsCheck(j, 2L);
        super.setShort(j, s);
    }

    @Override // com.sun.jna.Pointer
    public void setInt(long j, int i) {
        boundsCheck(j, 4L);
        super.setInt(j, i);
    }

    @Override // com.sun.jna.Pointer
    public void setLong(long j, long j2) {
        boundsCheck(j, 8L);
        super.setLong(j, j2);
    }

    @Override // com.sun.jna.Pointer
    public void setFloat(long j, float f) {
        boundsCheck(j, 4L);
        super.setFloat(j, f);
    }

    @Override // com.sun.jna.Pointer
    public void setDouble(long j, double d) {
        boundsCheck(j, 8L);
        super.setDouble(j, d);
    }

    @Override // com.sun.jna.Pointer
    public void setPointer(long j, Pointer pointer) {
        boundsCheck(j, Native.POINTER_SIZE);
        super.setPointer(j, pointer);
    }

    @Override // com.sun.jna.Pointer
    public void setString(long j, String str, String str2) {
        boundsCheck(j, Native.getBytes(str, str2).length + 1);
        super.setString(j, str, str2);
    }

    @Override // com.sun.jna.Pointer
    public void setWideString(long j, String str) {
        boundsCheck(j, (str.length() + 1) * Native.WCHAR_SIZE);
        super.setWideString(j, str);
    }

    @Override // com.sun.jna.Pointer
    public String toString() {
        return "allocated@0x" + Long.toHexString(this.peer) + " (" + this.size + " bytes)";
    }

    protected static void free(long j) {
        if (j != 0) {
            Native.free(j);
        }
    }

    protected static long malloc(long j) {
        return Native.malloc(j);
    }

    public String dump() {
        return dump(0L, (int) size());
    }

    private Pointer shareReferenceIfInBounds(Pointer pointer) {
        if (pointer == null) {
            return null;
        }
        long j = pointer.peer - this.peer;
        return (j < 0 || j >= this.size) ? pointer : share(j);
    }
}
