package com.google.firebase.remoteconfig.interop.rollouts;

import java.util.Set;

/* loaded from: classes.dex */
public abstract class RolloutsState {
    public static RolloutsState create(Set<RolloutAssignment> set) {
        return new AutoValue_RolloutsState(set);
    }

    public abstract Set<RolloutAssignment> getRolloutAssignments();
}
