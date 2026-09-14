package com.opentok.android;

import com.opentok.android.BaseAudioDevice;
import com.opentok.android.j;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final j.a f8544a = new j.a();

    /* renamed from: b, reason: collision with root package name */
    private static BaseAudioDevice f8545b;

    public static BaseAudioDevice a() {
        f8544a.b("getAudioDevice() called", new Object[0]);
        return f8545b;
    }

    public static void b(BaseAudioDevice baseAudioDevice) {
        f8544a.b("setAudioDevice() called", new Object[0]);
        if (f8545b != null) {
            throw new IllegalStateException("AudioDevice can only be changed before initialization.");
        }
        if (baseAudioDevice != null && baseAudioDevice.a() == null) {
            baseAudioDevice.e(new BaseAudioDevice.AudioBus(baseAudioDevice));
        }
        f8545b = baseAudioDevice;
    }
}
