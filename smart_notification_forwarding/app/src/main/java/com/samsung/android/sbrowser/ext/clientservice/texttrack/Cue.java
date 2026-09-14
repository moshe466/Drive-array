package com.samsung.android.sbrowser.ext.clientservice.texttrack;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.android.sbrowser.ext.clientservice.six.SixLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Cue implements Comparable<Cue> {
    public static double EPSILON = 1.0E-6d;
    public static final double INVALID_SEC = 0.0d;
    private static final String TAG = "Cue";
    private static int kSplitDebugLevel;
    static int mKey;
    List<CueSeg> mCueSegs;
    private double mEndSec;
    private final int mId;
    private boolean mIsTrans;
    private String mLangCode;
    private Cue mRefCue;
    private double mStartSec;

    public Cue() {
        this.mId = getNextId();
        this.mCueSegs = new ArrayList();
        this.mStartSec = INVALID_SEC;
        this.mEndSec = INVALID_SEC;
        this.mLangCode = null;
        this.mIsTrans = false;
        this.mRefCue = null;
    }

    public Cue(double d, double d2) {
        this();
        this.mStartSec = d;
        this.mEndSec = d2;
    }

    public Cue(double d, double d2, String str) {
        this(d, d2);
        addCueSeg(new CueSeg(INVALID_SEC, getDurationSec(), str));
    }

    public Cue(double d, double d2, List<CueSeg> list) {
        this(d, d2);
        this.mCueSegs = list;
        if (list.size() <= 0) {
            SixLog.error(TAG, "Cue::ctor invalide CueSegs");
            return;
        }
        CueSeg cueSeg = this.mCueSegs.get(r3.size() - 1);
        if (d2 <= INVALID_SEC) {
            this.mEndSec = this.mStartSec + cueSeg.getOffsetSec() + cueSeg.getDuration();
        }
    }

    public Cue(double d, List<CueSeg> list) {
        this(d, -1.0d, list);
    }

    public static double doubleCmp(double d, double d2) {
        double d3 = d - d2;
        return Math.abs(d3) < EPSILON ? INVALID_SEC : d3;
    }

    static int getNextId() {
        int i = mKey;
        mKey = i + 1;
        return i;
    }

    public static void initId() {
        mKey = 0;
    }

    public static int getCurrId() {
        return mKey;
    }

    public void copyAttr(Cue cue) {
        this.mLangCode = cue.getLangCode();
        this.mIsTrans = cue.getIsTrans();
        this.mRefCue = cue.getRefCue();
    }

    public Cue getRefCue() {
        return this.mRefCue;
    }

    public void setRefCue(Cue cue) {
        this.mRefCue = cue;
    }

    public List<CueSeg> cloneCueSegs(List<CueSeg> list, boolean z) {
        this.mCueSegs.clear();
        for (CueSeg cueSeg : list) {
            if (z) {
                this.mCueSegs.add(new CueSeg(cueSeg.getOffsetSec(), cueSeg.getDuration(), cueSeg.getText(), cueSeg.getConfidence()));
            } else {
                this.mCueSegs.add(cueSeg);
            }
        }
        CueSeg cueSeg2 = this.mCueSegs.get(r12.size() - 1);
        if (doubleCmp(this.mEndSec, this.mStartSec + cueSeg2.getOffsetSec() + cueSeg2.getDuration()) == INVALID_SEC) {
            SixLog.error(TAG, "Cue::cloneCueSegs : mEndSec != CueSeg's end");
        }
        return this.mCueSegs;
    }

    public void addCueSeg(CueSeg cueSeg) {
        this.mCueSegs.add(cueSeg);
    }

    public boolean isOnlyNewLine() {
        return this.mCueSegs.size() == 1 && this.mCueSegs.get(0).getText().equals("\n");
    }

    public String getText() {
        Iterator<CueSeg> it = this.mCueSegs.iterator();
        String str = JsonProperty.USE_DEFAULT_NAME;
        while (it.hasNext()) {
            str = str + it.next().getText();
            if (it.hasNext()) {
                str = str + " ";
            }
        }
        return str;
    }

    public double getStartSec() {
        return this.mStartSec;
    }

    public void setStartSec(double d) {
        this.mStartSec = d;
    }

    public double getEndSec() {
        return this.mEndSec;
    }

    public void setEndSec(double d) {
        this.mEndSec = d;
    }

    public double getDurationSec() {
        return this.mEndSec - this.mStartSec;
    }

    public double totalDuration() {
        Iterator<CueSeg> it = iterator();
        double d = INVALID_SEC;
        while (it.hasNext()) {
            d += it.next().getDuration();
        }
        return d;
    }

    public int getId() {
        return this.mId;
    }

    public String getLangCode() {
        return this.mLangCode;
    }

    public void setLangCode(String str) {
        this.mLangCode = str;
    }

    public int getCueSegSize() {
        return this.mCueSegs.size();
    }

    @Override // java.lang.Comparable
    public int compareTo(Cue cue) {
        double d = cue.mStartSec;
        double d2 = this.mStartSec;
        if (d2 == d) {
            return 0;
        }
        return d2 > d ? 1 : -1;
    }

    public Iterator<CueSeg> iterator() {
        return this.mCueSegs.iterator();
    }

    public String toString() {
        double doubleCmp = doubleCmp(getDurationSec(), totalDuration());
        String str = "[ V: " + (doubleCmp >= INVALID_SEC);
        if (doubleCmp < INVALID_SEC) {
            str = ((str + "(") + doubleCmp) + ")";
        }
        return (((((((((str + " , ") + "S: " + this.mStartSec) + " , ") + "E: " + this.mEndSec) + " , ") + "D: " + getDurationSec()) + " ] : ") + "{") + getText()) + "}";
    }

    public void debugPrintCueSegs() {
        CueSeg.debugCueSegs(this.mCueSegs);
    }

    public double getConfidence() {
        Iterator<CueSeg> it = iterator();
        double d = 0.0d;
        double d2 = 0.0d;
        while (it.hasNext()) {
            d += it.next().getConfidence();
            d2 += 1.0d;
        }
        return Math.max(INVALID_SEC, Math.min(d / d2, 1.0d));
    }

    public boolean getIsTrans() {
        return this.mIsTrans;
    }

    public void setIsTrans(boolean z) {
        this.mIsTrans = z;
    }

    public List<Cue> splitCueByCharCount(int i, Cue cue) {
        Cue buildCueSegForTransCue = cue != null ? buildCueSegForTransCue(cue) : this;
        if (kSplitDebugLevel >= 2) {
            buildCueSegForTransCue.debugPrintCueSegs();
        }
        if (buildCueSegForTransCue.getText().length() <= i) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this);
            return arrayList;
        }
        if (doubleCmp(buildCueSegForTransCue.getDurationSec(), buildCueSegForTransCue.totalDuration()) < INVALID_SEC) {
            SixLog.error(TAG, "splitCueByCharCount: wrong duration  dur: " + buildCueSegForTransCue.getDurationSec() + " tdur: " + buildCueSegForTransCue.totalDuration());
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this);
            return arrayList2;
        }
        return buildCueSegForTransCue.__splitCueByCharCount(i);
    }

    private List<Cue> __splitCueByCharCount(int i) {
        String[] strArr;
        int i2;
        ArrayList arrayList = new ArrayList();
        this.mCueSegs.iterator();
        SplitSession splitSession = new SplitSession(i, this.mStartSec);
        Iterator<CueSeg> it = this.mCueSegs.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            int i3 = 0;
            String str = TAG;
            if (!hasNext) {
                break;
            }
            CueSeg next = it.next();
            String text = next.getText();
            int codePointCount = text.codePointCount(0, text.length());
            if (codePointCount != 0) {
                if (splitSession.canAdd(codePointCount)) {
                    Cue addSeg = splitSession.addSeg(next, codePointCount);
                    if (addSeg != null) {
                        addSeg.copyAttr(this);
                        arrayList.add(addSeg);
                    }
                } else {
                    String[] split = text.split(" ");
                    if (kSplitDebugLevel >= 2) {
                        SixLog.dlog(TAG, "currSeg " + next);
                    }
                    double duration = next.getDuration() / codePointCount;
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < split.length) {
                        String str2 = split[i4];
                        int codePointCount2 = str2.codePointCount(i3, str2.length());
                        if (codePointCount2 == 0) {
                            strArr = split;
                            i2 = i4;
                        } else {
                            String str3 = str;
                            strArr = split;
                            i2 = i4;
                            CueSeg cueSeg = new CueSeg(next.getOffsetSec() + (i5 * duration), codePointCount2 * duration, str2, next.getConfidence());
                            i5 += codePointCount2;
                            if (kSplitDebugLevel >= 2) {
                                str = str3;
                                SixLog.dlog(str, "newCueSeg " + cueSeg);
                            } else {
                                str = str3;
                            }
                            Cue addSeg2 = splitSession.addSeg(cueSeg, codePointCount2);
                            if (addSeg2 != null) {
                                addSeg2.copyAttr(this);
                                arrayList.add(addSeg2);
                            }
                        }
                        i4 = i2 + 1;
                        split = strArr;
                        i3 = 0;
                    }
                }
            }
        }
        Cue splitCue = splitSession.splitCue();
        if (splitCue != null) {
            splitCue.copyAttr(this);
            arrayList.add(splitCue);
        }
        if (SixLog.isDebug()) {
            if (kSplitDebugLevel >= 1) {
                SixLog.dlog(TAG, "splitCueByCharCount_ : org " + this);
            }
            Iterator it2 = arrayList.iterator();
            double d = 0.0d;
            while (it2.hasNext()) {
                Cue cue = (Cue) it2.next();
                d += cue.getDurationSec();
                if (kSplitDebugLevel >= 1) {
                    SixLog.dlog(TAG, "splitCueByCharCount_ : split " + cue);
                }
            }
            double doubleCmp = doubleCmp(getStartSec(), ((Cue) arrayList.get(0)).getStartSec());
            if (doubleCmp < INVALID_SEC) {
                SixLog.error(TAG, "splitCueByCharCount_ : org start < split start " + doubleCmp);
            }
            double doubleCmp2 = doubleCmp(getDurationSec(), d);
            if (doubleCmp2 < INVALID_SEC) {
                SixLog.error(TAG, "splitCueByCharCount_ : org dur < split dur " + doubleCmp2);
            }
        }
        return arrayList;
    }

    private Cue buildCueSegForTransCue(Cue cue) {
        if (this.mCueSegs.size() != 1 || cue == null || cue.getCueSegSize() == 1) {
            return this;
        }
        int i = 0;
        String[] split = this.mCueSegs.get(0).getText().split(" ");
        ArrayList arrayList = new ArrayList();
        String text = cue.getText();
        int codePointCount = text.codePointCount(0, text.length());
        String text2 = getText();
        int codePointCount2 = text2.codePointCount(0, text2.length());
        Iterator<CueSeg> it = cue.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            CueSeg next = it.next();
            int codePointCount3 = (int) ((next.getText().codePointCount(i, next.getText().length()) / codePointCount) * codePointCount2);
            String str = JsonProperty.USE_DEFAULT_NAME;
            while (codePointCount3 > 0 && i2 < split.length) {
                String str2 = split[i2];
                str = (str + str2) + " ";
                i2++;
                codePointCount3 -= str2.codePointCount(0, str2.length());
            }
            if (!it.hasNext() && i2 < split.length) {
                SixLog.dlog(TAG, "buildCueSegForTransCue : words doesn't seem to be distributed correctly");
                while (i2 < split.length) {
                    str = (str + split[i2]) + " ";
                    i2++;
                }
            }
            arrayList.add(new CueSeg(next.getOffsetSec(), next.getDuration(), str, this.mCueSegs.get(0).getConfidence()));
            if (i2 >= split.length) {
                break;
            }
            i = 0;
        }
        Cue cue2 = new Cue(getStartSec(), getEndSec(), arrayList);
        if (kSplitDebugLevel >= 1) {
            SixLog.dlog(TAG, "buildCueSegForTransCue : refSrcCue " + cue);
            cue.debugPrintCueSegs();
            SixLog.dlog(TAG, "buildCueSegForTransCue : after " + cue2);
            cue2.debugPrintCueSegs();
        }
        if (SixLog.isDebug()) {
            double doubleCmp = doubleCmp(cue.getStartSec(), cue2.getStartSec());
            if (doubleCmp < INVALID_SEC) {
                SixLog.error(TAG, "buildCueSegForTransCue : ref start < rebuild start " + doubleCmp);
            }
            double doubleCmp2 = doubleCmp(cue.getDurationSec(), cue2.getDurationSec());
            if (doubleCmp2 < INVALID_SEC) {
                SixLog.error(TAG, "buildCueSegForTransCue : ref dur < rebuild dur " + doubleCmp2);
            }
        }
        cue2.copyAttr(this);
        return cue2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class SplitSession {
        private int mCharsForSplit;
        private int mSplitChars;
        private double mSplitStart;
        private ArrayList<CueSeg> mSegList = new ArrayList<>();
        private double mStartOffset = Cue.INVALID_SEC;

        SplitSession(int i, double d) {
            this.mCharsForSplit = i;
            this.mSplitStart = d;
            this.mSplitChars = this.mCharsForSplit;
        }

        boolean canAdd(int i) {
            return i <= this.mSplitChars;
        }

        Cue addSeg(CueSeg cueSeg, int i) {
            if (canAdd(i)) {
                this.mSplitChars -= i;
                CueSeg cueSeg2 = new CueSeg(cueSeg.getOffsetSec() - this.mStartOffset, cueSeg.getDuration(), cueSeg.getText(), cueSeg.getConfidence());
                if (Cue.kSplitDebugLevel >= 2) {
                    SixLog.dlog(Cue.TAG, "addSeg1 : " + cueSeg2 + " " + this.mStartOffset);
                }
                this.mSegList.add(cueSeg2);
                if (this.mSplitChars == 0) {
                    return splitCue();
                }
                return null;
            }
            Cue splitCue = splitCue();
            this.mSplitChars -= i;
            CueSeg cueSeg3 = new CueSeg(cueSeg.getOffsetSec() - this.mStartOffset, cueSeg.getDuration(), cueSeg.getText(), cueSeg.getConfidence());
            if (Cue.kSplitDebugLevel >= 2) {
                SixLog.dlog(Cue.TAG, "addSeg2 : " + cueSeg3 + " " + this.mStartOffset);
            }
            this.mSegList.add(cueSeg3);
            return splitCue;
        }

        Cue splitCue() {
            if (this.mSegList.size() == 0) {
                return null;
            }
            Cue cue = new Cue(this.mSplitStart, this.mSegList);
            this.mSplitChars = this.mCharsForSplit;
            this.mSegList = new ArrayList<>();
            this.mSplitStart = cue.getEndSec();
            this.mStartOffset += cue.getDurationSec();
            return cue;
        }

        double currStart() {
            return this.mSplitStart;
        }
    }
}
