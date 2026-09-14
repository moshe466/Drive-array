package x7;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;

/* loaded from: classes.dex */
public class j {

    /* renamed from: e, reason: collision with root package name */
    static j f15529e;

    /* renamed from: b, reason: collision with root package name */
    private k f15531b;

    /* renamed from: c, reason: collision with root package name */
    AudioManager f15532c;

    /* renamed from: a, reason: collision with root package name */
    public int f15530a = 0;

    /* renamed from: d, reason: collision with root package name */
    String f15533d = "";

    public j(Context context) {
        this.f15531b = i.a(context).b();
        this.f15532c = (AudioManager) context.getSystemService("audio");
    }

    public static j b() {
        return f15529e;
    }

    public static j c(Context context) {
        if (f15529e == null) {
            f15529e = new j(context);
        }
        return b();
    }

    public int a() {
        k kVar = this.f15531b;
        return (kVar == null || kVar.f15537d || !e()) ? 0 : 1;
    }

    public float d() {
        String str;
        if (!e()) {
            str = "";
        } else {
            if (!this.f15531b.f15537d) {
                String str2 = "getVolume headset:" + this.f15531b.f15536c;
                if (!this.f15533d.equals(str2)) {
                    v7.b.c("VolumeManager", str2);
                }
                return this.f15531b.f15536c;
            }
            str = "cancelHeadset ";
        }
        if (this.f15531b.f15538e) {
            String str3 = str + "getVolume receiver:" + this.f15531b.f15535b;
            if (!this.f15533d.equals(str3)) {
                v7.b.c("VolumeManager", str3);
            }
            return this.f15531b.f15535b;
        }
        String str4 = str + "getVolume speaker:" + this.f15531b.f15534a;
        if (!this.f15533d.equals(str4)) {
            v7.b.c("VolumeManager", str4);
        }
        return this.f15531b.f15534a;
    }

    boolean e() {
        AudioManager audioManager = this.f15532c;
        if (audioManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return audioManager.isWiredHeadsetOn() || this.f15532c.isBluetoothScoOn() || this.f15532c.isBluetoothA2dpOn();
        }
        for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
            if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        StringBuilder sb2;
        float f10;
        StringBuilder sb3 = new StringBuilder();
        if (e()) {
            sb2 = new StringBuilder();
            sb2.append("headsetVolume:");
            f10 = this.f15531b.f15536c;
        } else if (this.f15531b.f15538e) {
            sb2 = new StringBuilder();
            sb2.append("receiverVolume:");
            f10 = this.f15531b.f15535b;
        } else {
            sb2 = new StringBuilder();
            sb2.append("speakerVolume:");
            f10 = this.f15531b.f15534a;
        }
        sb2.append(f10);
        sb2.append(" ");
        sb3.append(sb2.toString());
        if (this.f15531b.f15538e) {
            sb3.append("silence ");
        }
        if (this.f15531b.f15537d) {
            sb3.append("cancelHeadset");
        }
        v7.b.c("Volume settings", sb3.toString());
    }

    public void g() {
        boolean i10 = i();
        this.f15532c.setSpeakerphoneOn(i10);
        v7.b.c("VolumeManager", "setSpeakerphoneOn(" + i10 + ")");
    }

    public void h(k kVar) {
        this.f15531b = kVar;
        g();
        f();
    }

    boolean i() {
        k kVar = this.f15531b;
        if (kVar.f15538e) {
            return false;
        }
        if (kVar.f15537d) {
            return true;
        }
        return !e();
    }
}
