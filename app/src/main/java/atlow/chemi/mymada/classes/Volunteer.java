package atlow.chemi.mymada.classes;

/* loaded from: classes.dex */
public class Volunteer {
    private int job;
    private String name;

    public Volunteer(String str, int i) {
        this.name = str;
        this.job = i;
    }

    public int getJob() {
        return this.job;
    }

    public String getName() {
        return this.name;
    }

    public void setJob(int i) {
        this.job = i;
    }

    public void setName(String str) {
        this.name = str;
    }
}
