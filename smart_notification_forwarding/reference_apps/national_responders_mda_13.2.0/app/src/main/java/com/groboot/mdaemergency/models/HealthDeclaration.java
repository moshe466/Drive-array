package com.groboot.mdaemergency.models;

/* loaded from: classes.dex */
public final class HealthDeclaration {
    private boolean noTroubleBreathing;
    private boolean normalBodyHeat;

    public HealthDeclaration() {
    }

    public HealthDeclaration(boolean z10, boolean z11) {
        this();
        this.noTroubleBreathing = z11;
        this.normalBodyHeat = z10;
    }

    public final boolean getNoTroubleBreathing() {
        return this.noTroubleBreathing;
    }

    public final boolean getNormalBodyHeat() {
        return this.normalBodyHeat;
    }

    public final void setNoTroubleBreathing(boolean z10) {
        this.noTroubleBreathing = z10;
    }

    public final void setNormalBodyHeat(boolean z10) {
        this.normalBodyHeat = z10;
    }
}
