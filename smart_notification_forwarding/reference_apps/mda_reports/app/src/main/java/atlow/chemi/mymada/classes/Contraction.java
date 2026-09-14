package atlow.chemi.mymada.classes;

import java.util.Date;

/* loaded from: classes.dex */
public class Contraction {
    private Date end;
    private String length;
    private int number;
    private Date oldEnd;
    private String previous;
    private Date start;

    public Contraction(int i, String str, String str2) {
        this.number = i;
        this.previous = str2;
        this.length = str;
    }

    public Contraction(int i, Date date, Date date2, Date date3) {
        this.number = i;
        this.start = date;
        this.end = date2;
        this.oldEnd = date3;
    }

    public Date getEnd() {
        return this.end;
    }

    public int getNumber() {
        return this.number;
    }

    public Date getOldEnd() {
        return this.oldEnd;
    }

    public Date getStart() {
        return this.start;
    }

    public void setOldEnd(Date date) {
        this.oldEnd = date;
    }
}
