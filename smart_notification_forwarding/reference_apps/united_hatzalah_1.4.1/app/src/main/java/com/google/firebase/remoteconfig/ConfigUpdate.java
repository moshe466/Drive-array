package com.google.firebase.remoteconfig;

import java.util.Set;

/* loaded from: classes.dex */
public abstract class ConfigUpdate {
    public static ConfigUpdate create(Set<String> set) {
        return new AutoValue_ConfigUpdate(set);
    }

    public abstract Set<String> getUpdatedKeys();
}
