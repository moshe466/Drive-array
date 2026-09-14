package x7;

import android.media.AudioRecord;

/* loaded from: classes.dex */
class f implements g {

    /* renamed from: a, reason: collision with root package name */
    private AudioRecord f15524a;

    public f(AudioRecord audioRecord) {
        this.f15524a = audioRecord;
    }

    @Override // x7.g
    public void a() {
        AudioRecord audioRecord = this.f15524a;
        if (audioRecord != null) {
            audioRecord.startRecording();
        }
    }

    @Override // x7.g
    public void b() {
        AudioRecord audioRecord = this.f15524a;
        if (audioRecord != null) {
            audioRecord.stop();
            this.f15524a.release();
            this.f15524a = null;
        }
    }
}
