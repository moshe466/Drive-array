package x6;

/* loaded from: classes.dex */
public enum f {
    NotExist,
    Exist,
    Recording,
    Playing,
    Downloading,
    Uploading;

    public static f getDefault() {
        return NotExist;
    }
}
