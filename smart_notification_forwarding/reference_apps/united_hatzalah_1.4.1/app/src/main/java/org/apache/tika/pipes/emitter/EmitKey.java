package org.apache.tika.pipes.emitter;

import F0.AbstractC0008a;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes.dex */
public class EmitKey implements Serializable {
    public static EmitKey NO_EMIT = new EmitKey(null, null);
    private static final long serialVersionUID = -3861669115439125268L;
    private String emitKey;
    private String emitterName;

    public EmitKey() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmitKey emitKey = (EmitKey) obj;
        if (!Objects.equals(this.emitterName, emitKey.emitterName)) {
            return false;
        }
        return Objects.equals(this.emitKey, emitKey.emitKey);
    }

    public String getEmitKey() {
        return this.emitKey;
    }

    public String getEmitterName() {
        return this.emitterName;
    }

    public int hashCode() {
        int i;
        String str = this.emitterName;
        int i3 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i4 = i * 31;
        String str2 = this.emitKey;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i4 + i3;
    }

    public String toString() {
        return AbstractC0008a.p("EmitterKey{emitterName='", this.emitterName, "', emitterKey='", this.emitKey, "'}");
    }

    public EmitKey(String str, String str2) {
        this.emitterName = str;
        this.emitKey = str2;
    }
}
