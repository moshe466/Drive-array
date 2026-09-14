package c7;

import android.bluetooth.BluetoothAdapter;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: a, reason: collision with root package name */
    private String f4498a;

    /* renamed from: b, reason: collision with root package name */
    private String f4499b;

    public b(String str, b7.d dVar) {
        this.f4499b = "00001101-0000-1000-8000-00805F9B34FB";
        this.f4498a = str;
        if (dVar == b7.d.STATUS_CHANNEL) {
            this.f4499b = "AEB33570-0B7B-11E3-8FFD-0800200C9A66";
        }
    }

    @Override // c7.d
    public e c() {
        try {
            c cVar = new c(BluetoothAdapter.getDefaultAdapter().getRemoteDevice(this.f4498a).createRfcommSocketToServiceRecord(UUID.fromString(this.f4499b)));
            cVar.e();
            return cVar;
        } catch (IOException e10) {
            throw new b7.e(e10.getMessage());
        }
    }
}
