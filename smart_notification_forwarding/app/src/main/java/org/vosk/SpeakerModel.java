package org.vosk;

import com.sun.jna.PointerType;

/* loaded from: classes2.dex */
public class SpeakerModel extends PointerType implements AutoCloseable {
    public SpeakerModel() {
    }

    public SpeakerModel(String path) {
        super(LibVosk.vosk_spk_model_new(path));
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        LibVosk.vosk_spk_model_free(getPointer());
    }
}
