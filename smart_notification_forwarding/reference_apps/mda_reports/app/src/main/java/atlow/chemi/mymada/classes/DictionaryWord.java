package atlow.chemi.mymada.classes;

/* loaded from: classes.dex */
public class DictionaryWord {
    private boolean approved;
    private String definition;
    private String key;
    public String name;

    public DictionaryWord(String str, String str2, String str3, boolean z) {
        this.name = str;
        this.definition = str2;
        this.key = str3;
        this.approved = z;
    }

    public DictionaryWord(String str, String str2, boolean z) {
        this.name = str;
        this.definition = str2;
        this.approved = z;
    }

    public String getDefinition() {
        return this.definition;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public boolean isApproved() {
        return this.approved;
    }
}
