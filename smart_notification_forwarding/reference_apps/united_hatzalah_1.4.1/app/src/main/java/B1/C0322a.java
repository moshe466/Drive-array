package b1;

import F0.G1;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;
import org.apache.tika.mime.MimeTypesReaderMetKeys;

/* renamed from: b1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0322a implements MethodChannel.MethodCallHandler {

    /* renamed from: a, reason: collision with root package name */
    public final G1 f3801a;

    public C0322a(G1 g12) {
        this.f3801a = g12;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public final void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        boolean hasAmplitudeControl;
        boolean hasAmplitudeControl2;
        VibrationEffect createOneShot;
        VibrationEffect createOneShot2;
        VibrationEffect createWaveform;
        boolean hasAmplitudeControl3;
        VibrationEffect createWaveform2;
        VibrationEffect createWaveform3;
        Vibrator vibrator = (Vibrator) this.f3801a.f218b;
        String str = methodCall.method;
        str.getClass();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1367724422:
                if (str.equals("cancel")) {
                    c4 = 0;
                    break;
                }
                break;
            case 86129172:
                if (str.equals("hasAmplitudeControl")) {
                    c4 = 1;
                    break;
                }
                break;
            case 451310959:
                if (str.equals("vibrate")) {
                    c4 = 2;
                    break;
                }
                break;
            case 890723587:
                if (str.equals("hasCustomVibrationsSupport")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                vibrator.cancel();
                result.success(null);
                return;
            case 1:
                if (Build.VERSION.SDK_INT >= 26) {
                    hasAmplitudeControl = vibrator.hasAmplitudeControl();
                    result.success(Boolean.valueOf(hasAmplitudeControl));
                    return;
                } else {
                    result.success(Boolean.FALSE);
                    return;
                }
            case 2:
                Integer num = (Integer) methodCall.argument("duration");
                List list = (List) methodCall.argument(MimeTypesReaderMetKeys.PATTERN_ATTR);
                Integer num2 = (Integer) methodCall.argument("repeat");
                List list2 = (List) methodCall.argument("intensities");
                Integer num3 = (Integer) methodCall.argument("amplitude");
                if (!list.isEmpty() && !list2.isEmpty()) {
                    int intValue = num2.intValue();
                    int size = list.size();
                    long[] jArr = new long[size];
                    int size2 = list2.size();
                    int[] iArr = new int[size2];
                    int i = 0;
                    while (i < size) {
                        jArr[i] = ((Integer) list.get(i)).intValue();
                        i++;
                        size = size;
                    }
                    for (int i3 = 0; i3 < size2; i3++) {
                        iArr[i3] = ((Integer) list2.get(i3)).intValue();
                    }
                    if (vibrator.hasVibrator()) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            hasAmplitudeControl3 = vibrator.hasAmplitudeControl();
                            if (hasAmplitudeControl3) {
                                createWaveform3 = VibrationEffect.createWaveform(jArr, iArr, intValue);
                                vibrator.vibrate(createWaveform3, new AudioAttributes.Builder().setContentType(4).setUsage(4).build());
                            } else {
                                createWaveform2 = VibrationEffect.createWaveform(jArr, intValue);
                                vibrator.vibrate(createWaveform2, new AudioAttributes.Builder().setContentType(4).setUsage(4).build());
                            }
                        } else {
                            vibrator.vibrate(jArr, intValue);
                        }
                    }
                } else if (list.size() > 0) {
                    int intValue2 = num2.intValue();
                    int size3 = list.size();
                    long[] jArr2 = new long[size3];
                    for (int i4 = 0; i4 < size3; i4++) {
                        jArr2[i4] = ((Integer) list.get(i4)).intValue();
                    }
                    if (vibrator.hasVibrator()) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            createWaveform = VibrationEffect.createWaveform(jArr2, intValue2);
                            vibrator.vibrate(createWaveform, new AudioAttributes.Builder().setContentType(4).setUsage(4).build());
                        } else {
                            vibrator.vibrate(jArr2, intValue2);
                        }
                    }
                } else {
                    long intValue3 = num.intValue();
                    int intValue4 = num3.intValue();
                    if (vibrator.hasVibrator()) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            hasAmplitudeControl2 = vibrator.hasAmplitudeControl();
                            if (hasAmplitudeControl2) {
                                createOneShot2 = VibrationEffect.createOneShot(intValue3, intValue4);
                                vibrator.vibrate(createOneShot2, new AudioAttributes.Builder().setContentType(4).setUsage(4).build());
                            } else {
                                createOneShot = VibrationEffect.createOneShot(intValue3, -1);
                                vibrator.vibrate(createOneShot, new AudioAttributes.Builder().setContentType(4).setUsage(4).build());
                            }
                        } else {
                            vibrator.vibrate(intValue3);
                        }
                    }
                }
                result.success(null);
                return;
            case 3:
                result.success(Boolean.TRUE);
                return;
            default:
                result.notImplemented();
                return;
        }
    }
}
