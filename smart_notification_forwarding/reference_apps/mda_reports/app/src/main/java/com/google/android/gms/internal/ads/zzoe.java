package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzoe {
    private boolean isOpen;

    public final synchronized void block() {
        while (!this.isOpen) {
            wait();
        }
    }

    public final synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean zzim() {
        boolean z;
        z = this.isOpen;
        this.isOpen = false;
        return z;
    }
}
