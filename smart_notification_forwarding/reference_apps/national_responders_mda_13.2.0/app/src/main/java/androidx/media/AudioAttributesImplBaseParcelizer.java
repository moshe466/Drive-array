package androidx.media;

import androidx.versionedparcelable.a;

/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(a aVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f3261a = aVar.p(audioAttributesImplBase.f3261a, 1);
        audioAttributesImplBase.f3262b = aVar.p(audioAttributesImplBase.f3262b, 2);
        audioAttributesImplBase.f3263c = aVar.p(audioAttributesImplBase.f3263c, 3);
        audioAttributesImplBase.f3264d = aVar.p(audioAttributesImplBase.f3264d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, a aVar) {
        aVar.x(false, false);
        aVar.F(audioAttributesImplBase.f3261a, 1);
        aVar.F(audioAttributesImplBase.f3262b, 2);
        aVar.F(audioAttributesImplBase.f3263c, 3);
        aVar.F(audioAttributesImplBase.f3264d, 4);
    }
}
