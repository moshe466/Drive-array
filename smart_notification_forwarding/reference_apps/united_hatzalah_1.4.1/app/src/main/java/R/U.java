package R;

import F0.C0035g2;
import F0.C0047j2;
import F0.C0084t0;
import F0.G1;
import a.AbstractC0228a;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.pm.ConfigurationInfo;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.input.InputManager;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.Uri;
import android.provider.Settings;
import android.view.InputDevice;
import d1.C0358a;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import s2.C0681f;
import s2.C0684i;
import t2.AbstractC0709k;
import w0.C0752h;

/* loaded from: classes.dex */
public final class U extends kotlin.jvm.internal.k implements F2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1822a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1823b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public U(F2.a aVar) {
        super(0);
        this.f1822a = 1;
        this.f1823b = (kotlin.jvm.internal.k) aVar;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [kotlin.jvm.internal.k, F2.a] */
    @Override // F2.a
    public final Object invoke() {
        Object g3;
        switch (this.f1822a) {
            case 0:
                Object obj = V.f1825d;
                File file = (File) this.f1823b;
                synchronized (obj) {
                    V.f1824c.remove(file.getAbsolutePath());
                }
                return C0684i.f6340a;
            case 1:
                File file2 = (File) ((kotlin.jvm.internal.k) this.f1823b).invoke();
                kotlin.jvm.internal.j.e(file2, "<this>");
                String name = file2.getName();
                kotlin.jvm.internal.j.d(name, "getName(...)");
                if (N2.f.d0(name, '.', "").equals("preferences_pb")) {
                    File absoluteFile = file2.getAbsoluteFile();
                    kotlin.jvm.internal.j.d(absoluteFile, "file.absoluteFile");
                    return absoluteFile;
                }
                throw new IllegalStateException(("File extension for file: " + file2 + " does not match required extension for Preferences file: preferences_pb").toString());
            case 2:
                return androidx.lifecycle.P.e((androidx.lifecycle.a0) this.f1823b);
            case 3:
                try {
                    g3 = (c1.g) ((c1.c) ((C0084t0) this.f1823b).f663a).invoke();
                } catch (Throwable th) {
                    g3 = AbstractC0228a.g(th);
                }
                return new C0681f(g3);
            case 4:
                ContentResolver contentResolver = ((C0358a) this.f1823b).f4413a;
                kotlin.jvm.internal.j.b(contentResolver);
                String string = Settings.Secure.getString(contentResolver, "android_id");
                kotlin.jvm.internal.j.b(string);
                return string;
            case 5:
                C0047j2 c0047j2 = (C0047j2) this.f1823b;
                c0047j2.getClass();
                Uri parse = Uri.parse("content://com.google.android.gsf.gservices");
                String[] strArr = {"android_id"};
                try {
                    ContentResolver contentResolver2 = (ContentResolver) c0047j2.f546b;
                    kotlin.jvm.internal.j.b(contentResolver2);
                    Cursor query = contentResolver2.query(parse, null, null, strArr, null);
                    kotlin.jvm.internal.j.b(query);
                    try {
                        if (query.moveToFirst() && query.getColumnCount() >= 2) {
                            String string2 = query.getString(1);
                            kotlin.jvm.internal.j.d(string2, "getString(...)");
                            String hexString = Long.toHexString(Long.parseLong(string2));
                            query.close();
                            return hexString;
                        }
                        throw new IllegalStateException("Check failed.");
                    } finally {
                    }
                } catch (Exception unused) {
                    return null;
                }
            case 6:
                MediaCodecList mediaCodecList = (MediaCodecList) ((C0035g2) this.f1823b).f526b;
                kotlin.jvm.internal.j.b(mediaCodecList);
                MediaCodecInfo[] codecInfos = mediaCodecList.getCodecInfos();
                kotlin.jvm.internal.j.d(codecInfos, "getCodecInfos(...)");
                ArrayList arrayList = new ArrayList(codecInfos.length);
                for (MediaCodecInfo mediaCodecInfo : codecInfos) {
                    kotlin.jvm.internal.j.b(mediaCodecInfo);
                    String name2 = mediaCodecInfo.getName();
                    kotlin.jvm.internal.j.b(name2);
                    String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                    kotlin.jvm.internal.j.b(supportedTypes);
                    ArrayList arrayList2 = new ArrayList(supportedTypes.length);
                    for (String str : supportedTypes) {
                        arrayList2.add(String.valueOf(str));
                    }
                    arrayList.add(new g1.i(name2, arrayList2));
                }
                return arrayList;
            case 7:
                C.b bVar = (C.b) ((C0047j2) this.f1823b).f546b;
                kotlin.jvm.internal.j.b(bVar);
                FingerprintManager b4 = C.b.b(bVar.f84a);
                if (b4 != null && b4.isHardwareDetected()) {
                    FingerprintManager b5 = C.b.b(bVar.f84a);
                    if (b5 != null && b5.hasEnrolledFingerprints()) {
                        return g1.g.f4689d;
                    }
                    return g1.g.f4688c;
                }
                return g1.g.f4687b;
            case 8:
                ActivityManager activityManager = (ActivityManager) ((G1) this.f1823b).f218b;
                kotlin.jvm.internal.j.b(activityManager);
                ConfigurationInfo deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo();
                kotlin.jvm.internal.j.b(deviceConfigurationInfo);
                String glEsVersion = deviceConfigurationInfo.getGlEsVersion();
                kotlin.jvm.internal.j.b(glEsVersion);
                return glEsVersion;
            case 9:
                InputManager inputManager = (InputManager) ((C0035g2) this.f1823b).f526b;
                kotlin.jvm.internal.j.b(inputManager);
                int[] inputDeviceIds = inputManager.getInputDeviceIds();
                kotlin.jvm.internal.j.b(inputDeviceIds);
                ArrayList arrayList3 = new ArrayList(inputDeviceIds.length);
                for (int i : inputDeviceIds) {
                    InputDevice inputDevice = inputManager.getInputDevice(i);
                    kotlin.jvm.internal.j.b(inputDevice);
                    String valueOf = String.valueOf(inputDevice.getVendorId());
                    String name3 = inputDevice.getName();
                    kotlin.jvm.internal.j.b(name3);
                    arrayList3.add(new g1.h(name3, valueOf));
                }
                return arrayList3;
            case 10:
                SensorManager sensorManager = (SensorManager) ((G1) this.f1823b).f218b;
                kotlin.jvm.internal.j.b(sensorManager);
                List<Sensor> sensorList = sensorManager.getSensorList(-1);
                kotlin.jvm.internal.j.b(sensorList);
                ArrayList arrayList4 = new ArrayList(AbstractC0709k.Y(sensorList, 10));
                for (Sensor sensor : sensorList) {
                    kotlin.jvm.internal.j.b(sensor);
                    String name4 = sensor.getName();
                    kotlin.jvm.internal.j.b(name4);
                    String vendor = sensor.getVendor();
                    kotlin.jvm.internal.j.b(vendor);
                    arrayList4.add(new g1.m(name4, vendor));
                }
                return arrayList4;
            default:
                C0752h c0752h = (C0752h) this.f1823b;
                return BigInteger.valueOf(c0752h.f6699a).shiftLeft(32).or(BigInteger.valueOf(c0752h.f6700b)).shiftLeft(32).or(BigInteger.valueOf(c0752h.f6701c));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ U(Object obj, int i) {
        super(0);
        this.f1822a = i;
        this.f1823b = obj;
    }
}
