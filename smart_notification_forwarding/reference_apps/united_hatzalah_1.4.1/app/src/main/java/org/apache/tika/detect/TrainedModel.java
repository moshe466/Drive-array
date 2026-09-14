package org.apache.tika.detect;

/* loaded from: classes.dex */
public abstract class TrainedModel {
    public abstract double predict(double[] dArr);

    public abstract float predict(float[] fArr);
}
