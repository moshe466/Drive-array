package org.apache.tika.detect;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class NNTrainedModel extends TrainedModel {
    private final float[][] Theta1;
    private final float[][] Theta2;
    private final int numOfHidden;
    private final int numOfInputs;
    private final int numOfOutputs;

    public NNTrainedModel(int i, int i3, int i4, float[] fArr) {
        this.numOfInputs = i;
        this.numOfHidden = i3;
        this.numOfOutputs = i4;
        Class cls = Float.TYPE;
        this.Theta1 = (float[][]) Array.newInstance((Class<?>) cls, i3, i + 1);
        this.Theta2 = (float[][]) Array.newInstance((Class<?>) cls, i4, i3 + 1);
        populateThetas(fArr);
    }

    private void populateThetas(float[] fArr) {
        float[][] fArr2 = this.Theta1;
        int length = fArr2.length;
        int length2 = fArr2[0].length;
        int i = 0;
        for (int i3 = 0; i3 < length2; i3++) {
            for (int i4 = 0; i4 < length; i4++) {
                this.Theta1[i4][i3] = fArr[i];
                i++;
            }
        }
        float[][] fArr3 = this.Theta2;
        int length3 = fArr3.length;
        int length4 = fArr3[0].length;
        for (int i5 = 0; i5 < length4; i5++) {
            for (int i6 = 0; i6 < length3; i6++) {
                this.Theta2[i6][i5] = fArr[i];
                i++;
            }
        }
    }

    @Override // org.apache.tika.detect.TrainedModel
    public double predict(double[] dArr) {
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    @Override // org.apache.tika.detect.TrainedModel
    public float predict(float[] fArr) {
        float[][] fArr2 = this.Theta1;
        int length = fArr2.length;
        int length2 = fArr2[0].length;
        float[] fArr3 = new float[length + 1];
        fArr3[0] = 1.0f;
        int i = 0;
        while (true) {
            double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            if (i >= length) {
                break;
            }
            for (int i3 = 0; i3 < length2; i3++) {
                d2 += this.Theta1[i][i3] * fArr[i3];
            }
            i++;
            fArr3[i] = (float) (1.0d / (Math.exp(-d2) + 1.0d));
        }
        float[][] fArr4 = this.Theta2;
        int length3 = fArr4.length;
        int length4 = fArr4[0].length;
        float[] fArr5 = new float[length3];
        for (int i4 = 0; i4 < length3; i4++) {
            double d4 = 0.0d;
            for (int i5 = 0; i5 < length4; i5++) {
                d4 += this.Theta2[i4][i5] * fArr3[i5];
            }
            fArr5[i4] = (float) (1.0d / (Math.exp(-d4) + 1.0d));
        }
        return fArr5[0];
    }
}
