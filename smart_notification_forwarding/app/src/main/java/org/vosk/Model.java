package org.vosk;

import com.sun.jna.PointerType;

/* loaded from: classes2.dex */
public class Model extends PointerType implements AutoCloseable {
    public Model() {
    }

    public Model(String path) {
        super(LibVosk.vosk_model_new(path));
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        LibVosk.vosk_model_free(getPointer());
    }
}
