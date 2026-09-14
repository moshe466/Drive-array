package org.apache.tika.sax;

import F0.AbstractC0008a;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.tika.sax.StandardReference;

/* loaded from: classes.dex */
public class StandardsText {
    private static final String REGEX_APPLICABLE_DOCUMENTS = "(?i:.*APPLICABLE\\sDOCUMENTS|REFERENCE|STANDARD|REQUIREMENT|GUIDELINE|COMPLIANCE.*)";
    private static final String REGEX_FALLBACK = "\\(?(?<mainOrganization>[A-Z]\\w{1,64}+)\\)?((\\s?(?<separator>\\/)\\s?)(\\w{1,64}+\\s)*\\(?(?<secondOrganization>[A-Z]\\w{1,64}+)\\)?)?(\\s(?i:Publication|Standard))?(-|\\s)?(?<identifier>([0-9]{3,64}+|([A-Z]{1,64}+(-|_|\\.)?[0-9]{2,64}+))((-|_|\\.)?[A-Z0-9]{1,64}+){0,64}+)";
    private static final String REGEX_HEADER = "(\\d{1,10}+\\.(\\d{1,10}+\\.?){0,10}+)\\p{Blank}+([A-Z]{1,64}+(\\s[A-Z]{1,64}+){0,256}+){5,10}+";
    private static final String REGEX_IDENTIFIER = "(?<identifier>([0-9]{3,64}+|([A-Z]{1,64}+(-|_|\\.)?[0-9]{2,64}+))((-|_|\\.)?[A-Z0-9]{1,64}+){0,64}+)";
    private static final String REGEX_ORGANIZATION;
    private static final String REGEX_STANDARD;
    private static final String REGEX_STANDARD_TYPE = "(\\s(?i:Publication|Standard))";

    static {
        String organzationsRegex = StandardOrganizations.getOrganzationsRegex();
        REGEX_ORGANIZATION = organzationsRegex;
        REGEX_STANDARD = AbstractC0008a.p(".*", organzationsRegex, ".+", organzationsRegex, "?.*");
    }

    public static ArrayList<StandardReference> extractStandardReferences(String str, double d2) {
        return findStandards(str, findHeaders(str), d2);
    }

    private static Map<Integer, String> findHeaders(String str) {
        TreeMap treeMap = new TreeMap();
        Matcher matcher = Pattern.compile(REGEX_HEADER).matcher(str);
        while (matcher.find()) {
            treeMap.put(Integer.valueOf(matcher.start()), matcher.group());
        }
        return treeMap;
    }

    private static ArrayList<StandardReference> findStandards(String str, Map<Integer, String> map, double d2) {
        String group;
        String group2;
        String group3;
        String group4;
        double d4;
        ArrayList<StandardReference> arrayList = new ArrayList<>();
        Matcher matcher = Pattern.compile(REGEX_FALLBACK).matcher(str);
        while (matcher.find()) {
            group = matcher.group("mainOrganization");
            group2 = matcher.group(Constants.IDENTIFIER);
            StandardReference.StandardReferenceBuilder standardReferenceBuilder = new StandardReference.StandardReferenceBuilder(group, group2);
            group3 = matcher.group("separator");
            group4 = matcher.group("secondOrganization");
            StandardReference.StandardReferenceBuilder secondOrganization = standardReferenceBuilder.setSecondOrganization(group3, group4);
            if (matcher.group().matches(REGEX_STANDARD)) {
                d4 = 0.5d;
            } else {
                d4 = 0.25d;
            }
            if (matcher.group().matches(".*(\\s(?i:Publication|Standard)).*")) {
                d4 += 0.25d;
            }
            Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
            boolean z3 = false;
            int i = 0;
            int i3 = 0;
            while (it.hasNext() && !z3) {
                int intValue = it.next().getKey().intValue();
                if (intValue > matcher.start()) {
                    z3 = true;
                }
                int i4 = i3;
                i3 = intValue;
                i = i4;
            }
            if (map.get(Integer.valueOf(i)) != null && map.get(Integer.valueOf(i)).matches(REGEX_APPLICABLE_DOCUMENTS)) {
                d4 += 0.25d;
            }
            secondOrganization.setScore(d4);
            if (d4 >= d2) {
                arrayList.add(secondOrganization.build());
            }
        }
        return arrayList;
    }
}
