package com.google.firebase.sessions;

import java.util.UUID;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class UuidGeneratorImpl implements UuidGenerator {
    public static final UuidGeneratorImpl INSTANCE = new UuidGeneratorImpl();

    private UuidGeneratorImpl() {
    }

    @Override // com.google.firebase.sessions.UuidGenerator
    public UUID next() {
        UUID randomUUID = UUID.randomUUID();
        j.d(randomUUID, "randomUUID()");
        return randomUUID;
    }
}
