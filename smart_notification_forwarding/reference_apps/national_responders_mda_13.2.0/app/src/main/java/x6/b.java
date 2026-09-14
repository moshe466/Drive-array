package x6;

/* loaded from: classes.dex */
public enum b {
    RING("Ring", 2),
    ALARM("Alarm", 4),
    MEDIA("Media", 3),
    NOTIFICATION("Notification", 5),
    VOICE_CALL("Voice call", 0),
    SYSTEM_SOUNDS("System sounds", 1),
    DTMF("DTMF tokens", 8);

    public final int audioStreamName;
    public final String displayName;

    b(String str, int i10) {
        this.displayName = str;
        this.audioStreamName = i10;
    }
}
