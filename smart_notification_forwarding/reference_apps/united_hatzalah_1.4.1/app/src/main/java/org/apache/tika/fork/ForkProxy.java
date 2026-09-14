package org.apache.tika.fork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public interface ForkProxy extends Serializable {
    void init(DataInputStream dataInputStream, DataOutputStream dataOutputStream);
}
