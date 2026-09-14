package com.opentok.android;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Process;
import android.telephony.PhoneStateListener;
import com.opentok.android.BaseAudioDevice;
import com.opentok.android.d;
import com.opentok.android.j;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BaseAudioDevice {
    private BaseAudioDevice.b A;
    private BluetoothAdapter B;
    private BluetoothProfile C;
    private final Object D;
    private boolean E;
    private i F;
    private h G;
    private BroadcastReceiver H;
    private final BroadcastReceiver I;
    private final BroadcastReceiver J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private final BluetoothProfile.ServiceListener O;

    /* renamed from: d, reason: collision with root package name */
    private final j.a f8548d;

    /* renamed from: e, reason: collision with root package name */
    private Context f8549e;

    /* renamed from: f, reason: collision with root package name */
    private AudioTrack f8550f;

    /* renamed from: g, reason: collision with root package name */
    private AudioRecord f8551g;

    /* renamed from: h, reason: collision with root package name */
    private ByteBuffer f8552h;

    /* renamed from: i, reason: collision with root package name */
    private ByteBuffer f8553i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f8554j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f8555k;

    /* renamed from: l, reason: collision with root package name */
    private final ReentrantLock f8556l;

    /* renamed from: m, reason: collision with root package name */
    private final Condition f8557m;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f8558n;

    /* renamed from: o, reason: collision with root package name */
    private volatile boolean f8559o;

    /* renamed from: p, reason: collision with root package name */
    private final ReentrantLock f8560p;

    /* renamed from: q, reason: collision with root package name */
    private final Condition f8561q;

    /* renamed from: r, reason: collision with root package name */
    private volatile boolean f8562r;

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f8563s;

    /* renamed from: t, reason: collision with root package name */
    private int f8564t;

    /* renamed from: u, reason: collision with root package name */
    private int f8565u;

    /* renamed from: v, reason: collision with root package name */
    private AudioManager f8566v;

    /* renamed from: w, reason: collision with root package name */
    private g f8567w;

    /* renamed from: x, reason: collision with root package name */
    private int f8568x;

    /* renamed from: y, reason: collision with root package name */
    private int f8569y;

    /* renamed from: z, reason: collision with root package name */
    private int f8570z;

    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            d.this.f8548d.b("headsetBroadcastReceiver.onReceive()", new Object[0]);
            if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                if (intent.getIntExtra("state", 0) == 1) {
                    d.this.f8548d.b("headsetBroadcastReceiver.onReceive():  Headphones connected", new Object[0]);
                    d.this.G.e(d.this.E());
                    d.this.I(i.HEAD_PHONES);
                    d.this.f8566v.setSpeakerphoneOn(false);
                    d.this.f8566v.setBluetoothScoOn(false);
                    return;
                }
                d.this.f8548d.b("headsetBroadcastReceiver.onReceive():  Headphones disconnected", new Object[0]);
                if (d.this.E() == i.HEAD_PHONES) {
                    i b10 = d.this.G.b();
                    i iVar = i.BLUETOOTH;
                    if (b10 == iVar && BaseAudioDevice.b.Connected == d.this.A) {
                        d.this.f8566v.setBluetoothScoOn(true);
                        d.this.J();
                        d.this.I(iVar);
                        return;
                    }
                    i b11 = d.this.G.b();
                    i iVar2 = i.SPEAKER_PHONE;
                    if (b11 == iVar2) {
                        d.this.I(iVar2);
                        d.this.f8566v.setSpeakerphoneOn(true);
                    }
                    i b12 = d.this.G.b();
                    i iVar3 = i.EAR_PIECE;
                    if (b12 == iVar3) {
                        d.this.I(iVar3);
                        d.this.f8566v.setSpeakerphoneOn(false);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED")) {
                switch (intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1)) {
                    case 10:
                        d.this.f8548d.b("bluetoothHeadsetReceiver.onReceive(): STATE_AUDIO_DISCONNECTED", new Object[0]);
                        return;
                    case 11:
                        d.this.f8548d.b("bluetoothHeadsetReceiver.onReceive(): STATE_AUDIO_CONNECTING", new Object[0]);
                        return;
                    case 12:
                        d.this.f8548d.b("bluetoothHeadsetReceiver.onReceive(): STATE_AUDIO_CONNECTED", new Object[0]);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            d.this.C();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                if (intExtra == 0) {
                    d.this.f8548d.b("bluetoothBroadcastReceiver.onReceive(): BluetoothHeadset.STATE_DISCONNECTED", new Object[0]);
                    d.this.N();
                    d.this.f8566v.setBluetoothScoOn(false);
                    return;
                } else if (intExtra == 2) {
                    d.this.f8548d.b("bluetoothBroadcastReceiver.onReceive(): BluetoothHeadset.STATE_CONNECTED", new Object[0]);
                    new Handler().postDelayed(new Runnable() { // from class: com.opentok.android.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.c.this.b();
                        }
                    }, 2000L);
                    return;
                } else {
                    if (intExtra != 3) {
                        return;
                    }
                    d.this.f8548d.b("bluetoothBroadcastReceiver.onReceive(): BluetoothHeadset.STATE_DISCONNECTING", new Object[0]);
                    return;
                }
            }
            if (action == null || !action.equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                return;
            }
            int intExtra2 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
            if (intExtra2 == -1) {
                d.this.f8548d.b("bluetoothBroadcastReceiver.onReceive(): AudioManager.SCO_AUDIO_STATE_ERROR", new Object[0]);
                return;
            }
            if (intExtra2 == 0) {
                d.this.f8548d.b("bluetoothBroadcastReceiver.onReceive(): AudioManager.SCO_AUDIO_STATE_DISCONNECTED", new Object[0]);
                d.this.H();
                d.this.A = BaseAudioDevice.b.Disconnected;
                return;
            }
            if (intExtra2 != 1) {
                if (intExtra2 != 2) {
                    return;
                }
                d.this.f8548d.b("bluetoothBroadcastReceiver.onReceive(): AudioManager.SCO_AUDIO_STATE_CONNECTING", new Object[0]);
            } else {
                d.this.f8548d.b("bluetoothBroadcastReceiver.onReceive(): AudioManager.SCO_AUDIO_STATE_CONNECTED", new Object[0]);
                d.this.A = BaseAudioDevice.b.Connected;
                d.this.I(i.BLUETOOTH);
                d.super.f(BaseAudioDevice.c.Handset);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opentok.android.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0137d extends PhoneStateListener {
        C0137d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            d.this.M();
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int i10, String str) {
            d.this.f8548d.b("PhoneStateListener.onCallStateChanged()", new Object[0]);
            super.onCallStateChanged(i10, str);
            if (i10 == 0) {
                d.this.f8548d.b("PhoneStateListener.onCallStateChanged(): TelephonyManager.CALL_STATE_IDLE", new Object[0]);
                new Handler().postDelayed(new Runnable() { // from class: com.opentok.android.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.C0137d.this.b();
                    }
                }, 5000L);
                return;
            }
            if (i10 == 1) {
                d.this.f8548d.b("PhoneStateListener.onCallStateChanged(): TelephonyManager.CALL_STATE_RINGING", new Object[0]);
            } else {
                if (i10 != 2) {
                    d.this.f8548d.b("PhoneStateListener.onCallStateChanged() default", new Object[0]);
                    return;
                }
                d.this.f8548d.b("PhoneStateListener.onCallStateChanged(): TelephonyManager.CALL_STATE_OFFHOOK", new Object[0]);
            }
            d.this.Q();
        }
    }

    /* loaded from: classes.dex */
    class e implements AudioManager.OnAudioFocusChangeListener {
        e() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i10) {
            d.this.f8548d.b("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange(" + i10 + ")", new Object[0]);
            if (i10 == -3) {
                d.this.f8548d.b("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange(" + i10 + "): AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK", new Object[0]);
                d.this.G.f(d.this.f8566v.getStreamVolume(0));
                d.this.f8566v.setStreamVolume(0, 0, 0);
            } else if (i10 == -2) {
                d.this.f8548d.b("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange(" + i10 + "): AudioManager.AUDIOFOCUS_LOSS_TRANSIENT", new Object[0]);
            } else if (i10 == -1) {
                d.this.f8548d.b("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange(" + i10 + "): AudioManager.AUDIOFOCUS_LOSS", new Object[0]);
            } else if (i10 == 0) {
                d.this.f8548d.b("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange(" + i10 + "): AudioManager.AUDIOFOCUS_NONE", new Object[0]);
            } else if (i10 != 1) {
                d.this.f8548d.b("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange(" + i10 + "): default", new Object[0]);
            } else {
                d.this.f8548d.b("AudioManager.OnAudioFocusChangeListener.onAudioFocusChange(" + i10 + "): ", new Object[0]);
                int a10 = d.this.G.a();
                if (a10 == -3) {
                    d.this.f8566v.setStreamVolume(0, d.this.G.c(), 0);
                } else if (a10 != -2 && a10 != -1) {
                    d.this.f8548d.b("focusChange = " + i10, new Object[0]);
                }
                d dVar = d.this;
                dVar.I(dVar.G.b());
                d.this.C();
                d.this.D();
            }
            d.this.G.e(d.this.E());
            d.this.G.d(i10);
        }
    }

    /* loaded from: classes.dex */
    class f implements BluetoothProfile.ServiceListener {
        f() {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i10, BluetoothProfile bluetoothProfile) {
            d.this.f8548d.b("BluetoothProfile.ServiceListener.onServiceConnected()", new Object[0]);
            if (1 == i10) {
                d.this.C = bluetoothProfile;
                List<BluetoothDevice> connectedDevices = bluetoothProfile.getConnectedDevices();
                d.this.f8548d.b("Service Proxy Connected", new Object[0]);
                if (connectedDevices.isEmpty() || 2 != bluetoothProfile.getConnectionState(connectedDevices.get(0))) {
                    return;
                }
                Intent intent = new Intent("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
                intent.putExtra("android.bluetooth.profile.extra.STATE", 2);
                d.this.J.onReceive(d.this.f8549e, intent);
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i10) {
            d.this.f8548d.b("BluetoothProfile.ServiceListener.onServiceDisconnected()", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: c, reason: collision with root package name */
        private final j.a f8579c = new j.a(this);

        /* renamed from: a, reason: collision with root package name */
        private int f8577a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f8578b = 0;

        g() {
        }

        void a(AudioManager audioManager) {
            this.f8579c.b("AudioManagerMode.acquireMode() called", new Object[0]);
            int i10 = this.f8578b;
            this.f8578b = i10 + 1;
            if (i10 == 0) {
                this.f8577a = audioManager.getMode();
                audioManager.setMode(3);
            }
        }

        void b(AudioManager audioManager) {
            this.f8579c.b("AudioManagerMode.releaseMode() called", new Object[0]);
            int i10 = this.f8578b - 1;
            this.f8578b = i10;
            if (i10 == 0) {
                audioManager.setMode(this.f8577a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        private int f8580a;

        /* renamed from: b, reason: collision with root package name */
        private int f8581b;

        /* renamed from: c, reason: collision with root package name */
        private i f8582c;

        /* renamed from: d, reason: collision with root package name */
        private final j.a f8583d;

        private h() {
            this.f8580a = 0;
            this.f8581b = 0;
            this.f8582c = i.SPEAKER_PHONE;
            this.f8583d = new j.a(this);
        }

        /* synthetic */ h(a aVar) {
            this();
        }

        int a() {
            return this.f8581b;
        }

        i b() {
            return this.f8582c;
        }

        int c() {
            return this.f8580a;
        }

        void d(int i10) {
            this.f8581b = i10;
        }

        void e(i iVar) {
            this.f8583d.b("AudioState.setLastOutputType(" + iVar + ") called", new Object[0]);
            this.f8582c = iVar;
        }

        void f(int i10) {
            this.f8580a = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum i {
        SPEAKER_PHONE,
        EAR_PIECE,
        HEAD_PHONES,
        BLUETOOTH
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00de, code lost:
    
        if (r6 == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0102, code lost:
    
        r9.f8568x = 44100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0104, code lost:
    
        r4 = java.lang.Integer.parseInt(r9.f8566v.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER"));
        r9.f8570z = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0112, code lost:
    
        r4 = (r4 * 2) * 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0116, code lost:
    
        if (r4 != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0118, code lost:
    
        r9.f8570z = 440;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x011b, code lost:
    
        r1 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x011f, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0120, code lost:
    
        r9.f8548d.c("DefaultAudioDevice(): " + r4.getMessage(), new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0100, code lost:
    
        if (r9.f8568x != 0) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opentok.android.d.<init>(android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        int i10 = this.f8570z;
        try {
            Process.setThreadPriority(-19);
        } catch (Exception e10) {
            this.f8548d.c("android.os.Process.setThreadPriority(): " + e10.getMessage(), new Object[0]);
        }
        while (!this.f8559o) {
            this.f8556l.lock();
            try {
                if (this.f8558n) {
                    this.f8556l.unlock();
                    this.f8552h.clear();
                    int a10 = a().a(this.f8552h, i10);
                    this.f8556l.lock();
                    if (this.f8550f != null && this.f8558n) {
                        int i11 = (a10 << 1) * 1;
                        this.f8552h.get(this.f8554j, 0, i11);
                        int write = this.f8550f.write(this.f8554j, 0, i11);
                        if (write <= 0) {
                            if (write == -3) {
                                throw new RuntimeException("renderThread(): AudioTrack.ERROR_INVALID_OPERATION");
                            }
                            if (write == -2) {
                                throw new RuntimeException("renderThread(): AudioTrack.ERROR_BAD_VALUE");
                            }
                            throw new RuntimeException("renderThread(): AudioTrack.ERROR or default");
                        }
                        this.f8564t += (write >> 1) / 1;
                        int playbackHeadPosition = this.f8550f.getPlaybackHeadPosition();
                        if (playbackHeadPosition < this.f8565u) {
                            this.f8565u = 0;
                        }
                        int i12 = this.f8564t - (playbackHeadPosition - this.f8565u);
                        this.f8564t = i12;
                        this.f8565u = playbackHeadPosition;
                        int i13 = (i12 * 1000) / this.f8568x;
                    }
                } else {
                    this.f8557m.await();
                }
            } catch (Exception e11) {
                BaseAudioDevice.d(e11);
                return;
            } finally {
                this.f8556l.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.f8548d.b("connectBluetooth() called", new Object[0]);
        this.f8566v.setBluetoothScoOn(true);
        J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.f8548d.b("forceConnectBluetooth() called", new Object[0]);
        synchronized (this.D) {
            this.A = BaseAudioDevice.b.Disconnected;
            BluetoothAdapter bluetoothAdapter = this.B;
            if (bluetoothAdapter != null) {
                bluetoothAdapter.getProfileProxy(this.f8549e, this.O, 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i E() {
        return this.F;
    }

    private void F() {
        this.f8548d.b("registerBtReceiver() called .. isBluetoothHeadSetReceiverRegistered = " + this.N, new Object[0]);
        if (this.N) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        this.f8549e.registerReceiver(this.J, intentFilter);
        this.f8549e.registerReceiver(this.I, new IntentFilter("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED"));
        this.N = true;
    }

    private void G() {
        this.f8548d.b("registerHeadsetReceiver() called ... isHeadsetReceiverRegistered = " + this.M, new Object[0]);
        if (this.M) {
            return;
        }
        this.f8549e.registerReceiver(this.H, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        this.M = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        AudioManager audioManager;
        boolean z10 = false;
        if (this.f8566v.isWiredHeadsetOn()) {
            I(i.HEAD_PHONES);
        } else {
            i b10 = this.G.b();
            i iVar = i.SPEAKER_PHONE;
            if (b10 == iVar) {
                I(iVar);
                super.f(BaseAudioDevice.c.SpeakerPhone);
                audioManager = this.f8566v;
                z10 = true;
                audioManager.setSpeakerphoneOn(z10);
            }
            i b11 = this.G.b();
            i iVar2 = i.EAR_PIECE;
            if (b11 != iVar2) {
                return;
            }
            I(iVar2);
            super.f(BaseAudioDevice.c.Handset);
        }
        audioManager = this.f8566v;
        audioManager.setSpeakerphoneOn(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(i iVar) {
        this.F = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.f8548d.b("startBluetoothSco() called", new Object[0]);
        try {
            this.f8566v.startBluetoothSco();
        } catch (NullPointerException e10) {
            this.f8548d.c("startBluetoothSco(): " + e10.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        this.f8548d.b("startRendererAndCapturer()", new Object[0]);
        if (this.K) {
            L();
        }
        if (this.L) {
            K();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.f8548d.b("stopBluetoothSco() called", new Object[0]);
        try {
            this.f8566v.stopBluetoothSco();
        } catch (NullPointerException e10) {
            this.f8548d.c("stopBluetoothSco(): " + e10.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        this.f8548d.b("stopRendererAndCapturer()", new Object[0]);
        if (this.f8558n) {
            P();
            this.K = true;
        }
        if (this.f8562r) {
            O();
            this.L = true;
        }
    }

    private void R() {
        this.f8548d.b("unregisterBtReceiver() called .. bluetoothHeadSetReceiverRegistered = " + this.N, new Object[0]);
        if (this.N) {
            this.f8549e.unregisterReceiver(this.J);
            this.f8549e.unregisterReceiver(this.I);
            this.N = false;
        }
    }

    private void S() {
        this.f8548d.b("unregisterHeadsetReceiver() called .. isHeadsetReceiverRegistered = " + this.M, new Object[0]);
        if (this.M) {
            this.f8549e.unregisterReceiver(this.H);
            this.M = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        int i10 = this.f8569y / 100;
        try {
            Process.setThreadPriority(-19);
        } catch (Exception e10) {
            this.f8548d.c("android.os.Process.setThreadPriority(): " + e10.getMessage(), new Object[0]);
        }
        while (!this.f8563s) {
            this.f8560p.lock();
            try {
                if (this.f8562r) {
                    AudioRecord audioRecord = this.f8551g;
                    if (audioRecord != null) {
                        int read = audioRecord.read(this.f8555k, 0, (i10 << 1) * 1);
                        if (read < 0) {
                            if (read == -3) {
                                throw new RuntimeException("captureThread(): AudioRecord.ERROR_INVALID_OPERATION");
                            }
                            if (read == -2) {
                                throw new RuntimeException("captureThread(): AudioRecord.ERROR_BAD_VALUE");
                            }
                            throw new RuntimeException("captureThread(): AudioRecord.ERROR or default");
                        }
                        this.f8553i.rewind();
                        this.f8553i.put(this.f8555k);
                        int i11 = (read >> 1) / 1;
                        this.f8560p.unlock();
                        a().c(this.f8553i, i11);
                        int i12 = (i11 * 1000) / this.f8569y;
                    }
                } else {
                    this.f8561q.await();
                }
            } catch (Exception e11) {
                BaseAudioDevice.d(e11);
                return;
            } finally {
                this.f8560p.unlock();
            }
        }
    }

    public boolean K() {
        this.f8548d.b("startCapturer() called", new Object[0]);
        AudioRecord audioRecord = this.f8551g;
        if (audioRecord == null) {
            throw new IllegalStateException("startCapturer(): startRecording() called on an uninitialized AudioRecord.");
        }
        try {
            audioRecord.startRecording();
            this.f8560p.lock();
            this.f8562r = true;
            this.f8561q.signal();
            this.f8560p.unlock();
            this.f8567w.a(this.f8566v);
            return true;
        } catch (IllegalStateException e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    public boolean L() {
        this.f8548d.b("startRenderer() called", new Object[0]);
        synchronized (this.D) {
            if (BaseAudioDevice.b.Connected != this.A) {
                if (this.f8566v.isWiredHeadsetOn()) {
                    this.f8548d.b("startRenderer(): Turn off Speaker phone", new Object[0]);
                    this.f8566v.setSpeakerphoneOn(false);
                } else {
                    this.f8548d.b("startRenderer(): Turn on Speaker phone", new Object[0]);
                    if (E() == i.SPEAKER_PHONE) {
                        this.f8566v.setSpeakerphoneOn(true);
                    }
                }
            }
        }
        AudioTrack audioTrack = this.f8550f;
        if (audioTrack == null) {
            throw new IllegalStateException("startRenderer(): play() called on uninitialized AudioTrack.");
        }
        try {
            audioTrack.play();
            this.f8556l.lock();
            this.f8558n = true;
            this.f8557m.signal();
            this.f8556l.unlock();
            this.f8567w.a(this.f8566v);
            F();
            G();
            return true;
        } catch (IllegalStateException e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    public boolean O() {
        this.f8548d.b("stopCapturer() called", new Object[0]);
        if (this.f8551g == null) {
            throw new IllegalStateException("stopCapturer(): stop() called on an uninitialized AudioRecord.");
        }
        this.f8560p.lock();
        try {
            try {
                if (this.f8551g.getRecordingState() == 3) {
                    this.f8551g.stop();
                }
                this.f8562r = false;
                this.f8560p.unlock();
                this.f8567w.b(this.f8566v);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        } catch (Throwable th) {
            this.f8562r = false;
            this.f8560p.unlock();
            throw th;
        }
    }

    public boolean P() {
        this.f8548d.b("stopRenderer() called", new Object[0]);
        if (this.f8550f == null) {
            throw new IllegalStateException("stopRenderer(): stop() called on uninitialized AudioTrack.");
        }
        this.f8556l.lock();
        try {
            try {
                if (this.f8550f.getPlayState() == 3) {
                    this.f8550f.stop();
                }
                this.f8550f.flush();
                this.f8558n = false;
                this.f8556l.unlock();
                this.f8567w.b(this.f8566v);
                S();
                R();
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10.getMessage());
            }
        } catch (Throwable th) {
            this.f8558n = false;
            this.f8556l.unlock();
            throw th;
        }
    }

    @Override // com.opentok.android.BaseAudioDevice
    public synchronized void b() {
        this.f8548d.b("onPause() called", new Object[0]);
        this.G.e(E());
        R();
        S();
        this.E = true;
    }

    @Override // com.opentok.android.BaseAudioDevice
    public synchronized void c() {
        this.f8548d.b("onResume() called", new Object[0]);
        if (this.E) {
            if (this.A == BaseAudioDevice.b.Disconnected && this.f8558n && this.G.b() == i.SPEAKER_PHONE && !this.f8566v.isWiredHeadsetOn()) {
                this.f8548d.b("onResume() - Set Speaker Phone ON True", new Object[0]);
                this.f8566v.setSpeakerphoneOn(true);
            }
            F();
            G();
            C();
            D();
            this.E = false;
        }
    }
}
