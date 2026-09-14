package atlow.chemi.mymada.classes;

/* loaded from: classes.dex */
public class mCodeKid {
    private String category;
    public String id;
    private boolean isChecked = false;
    private String name;
    private int order;

    public mCodeKid(String str, String str2, String str3, int i) {
        this.id = str2;
        this.name = str;
        this.category = str3;
        this.order = i;
    }

    public String getCategory() {
        return this.category;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getOrder() {
        return this.order;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }
}
