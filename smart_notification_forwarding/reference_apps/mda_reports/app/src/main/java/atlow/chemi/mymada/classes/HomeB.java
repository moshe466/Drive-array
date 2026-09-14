package atlow.chemi.mymada.classes;

/* loaded from: classes.dex */
public class HomeB {
    private int bg;
    private String intent;

    public HomeB(String str, int i) {
        this.intent = str;
        this.bg = i;
    }

    public int getBg() {
        return this.bg;
    }

    public String getIntent() {
        return this.intent;
    }

    public void setBg(int i) {
        this.bg = i;
    }

    public void setIntent(String str) {
        this.intent = str;
    }
}
