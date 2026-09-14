package org.yaml.snakeyaml.scanner;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.RuleUtils;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.tokens.AliasToken;
import org.yaml.snakeyaml.tokens.AnchorToken;
import org.yaml.snakeyaml.tokens.BlockEndToken;
import org.yaml.snakeyaml.tokens.BlockEntryToken;
import org.yaml.snakeyaml.tokens.BlockMappingStartToken;
import org.yaml.snakeyaml.tokens.BlockSequenceStartToken;
import org.yaml.snakeyaml.tokens.CommentToken;
import org.yaml.snakeyaml.tokens.DirectiveToken;
import org.yaml.snakeyaml.tokens.DocumentEndToken;
import org.yaml.snakeyaml.tokens.DocumentStartToken;
import org.yaml.snakeyaml.tokens.FlowEntryToken;
import org.yaml.snakeyaml.tokens.FlowMappingEndToken;
import org.yaml.snakeyaml.tokens.FlowMappingStartToken;
import org.yaml.snakeyaml.tokens.FlowSequenceEndToken;
import org.yaml.snakeyaml.tokens.FlowSequenceStartToken;
import org.yaml.snakeyaml.tokens.KeyToken;
import org.yaml.snakeyaml.tokens.ScalarToken;
import org.yaml.snakeyaml.tokens.StreamEndToken;
import org.yaml.snakeyaml.tokens.StreamStartToken;
import org.yaml.snakeyaml.tokens.TagToken;
import org.yaml.snakeyaml.tokens.TagTuple;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.tokens.ValueToken;
import org.yaml.snakeyaml.util.ArrayStack;
import org.yaml.snakeyaml.util.UriEncoder;

/* loaded from: classes2.dex */
public final class ScannerImpl implements Scanner {
    public static final Map<Character, Integer> ESCAPE_CODES;
    public static final Map<Character, String> ESCAPE_REPLACEMENTS;
    private static final Pattern NOT_HEXA = Pattern.compile("[^0-9A-Fa-f]");
    private Token lastToken;
    private final StreamReader reader;
    private boolean done = false;
    private int flowLevel = 0;
    private int tokensTaken = 0;
    private int indent = -1;
    private boolean allowSimpleKey = true;
    private boolean parseComments = false;
    private List<Token> tokens = new ArrayList(100);
    private ArrayStack<Integer> indents = new ArrayStack<>(10);
    private Map<Integer, SimpleKey> possibleSimpleKeys = new LinkedHashMap();

    static {
        HashMap hashMap = new HashMap();
        ESCAPE_REPLACEMENTS = hashMap;
        HashMap hashMap2 = new HashMap();
        ESCAPE_CODES = hashMap2;
        hashMap.put('0', "\u0000");
        hashMap.put('a', "\u0007");
        hashMap.put('b', "\b");
        hashMap.put('t', "\t");
        hashMap.put('n', "\n");
        hashMap.put('v', "\u000b");
        hashMap.put('f', "\f");
        hashMap.put('r', "\r");
        hashMap.put('e', "\u001b");
        hashMap.put(' ', " ");
        hashMap.put('\"', "\"");
        hashMap.put('\\', "\\");
        hashMap.put('N', "\u0085");
        hashMap.put('_', " ");
        hashMap.put('L', "\u2028");
        hashMap.put('P', "\u2029");
        hashMap2.put('x', 2);
        hashMap2.put('u', 4);
        hashMap2.put('U', 8);
    }

    public ScannerImpl(StreamReader streamReader) {
        this.reader = streamReader;
        fetchStreamStart();
    }

    public ScannerImpl setParseComments(boolean z) {
        this.parseComments = z;
        return this;
    }

    public boolean isParseComments() {
        return this.parseComments;
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public boolean checkToken(Token.ID... idArr) {
        while (needMoreTokens()) {
            fetchMoreTokens();
        }
        if (!this.tokens.isEmpty()) {
            if (idArr.length == 0) {
                return true;
            }
            Token.ID tokenId = this.tokens.get(0).getTokenId();
            for (Token.ID id : idArr) {
                if (tokenId == id) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public Token peekToken() {
        while (needMoreTokens()) {
            fetchMoreTokens();
        }
        return this.tokens.get(0);
    }

    @Override // org.yaml.snakeyaml.scanner.Scanner
    public Token getToken() {
        this.tokensTaken++;
        return this.tokens.remove(0);
    }

    private void addToken(Token token) {
        this.lastToken = token;
        this.tokens.add(token);
    }

    private void addToken(int i, Token token) {
        if (i == this.tokens.size()) {
            this.lastToken = token;
        }
        this.tokens.add(i, token);
    }

    private void addAllTokens(List<Token> list) {
        this.lastToken = list.get(list.size() - 1);
        this.tokens.addAll(list);
    }

    private boolean needMoreTokens() {
        if (this.done) {
            return false;
        }
        if (this.tokens.isEmpty()) {
            return true;
        }
        stalePossibleSimpleKeys();
        return nextPossibleSimpleKey() == this.tokensTaken;
    }

    private void fetchMoreTokens() {
        scanToNextToken();
        stalePossibleSimpleKeys();
        unwindIndent(this.reader.getColumn());
        int peek = this.reader.peek();
        if (peek == 0) {
            fetchStreamEnd();
            return;
        }
        if (peek == 42) {
            fetchAlias();
            return;
        }
        if (peek != 58) {
            if (peek == 91) {
                fetchFlowSequenceStart();
                return;
            }
            if (peek == 93) {
                fetchFlowSequenceEnd();
                return;
            }
            if (peek == 33) {
                fetchTag();
                return;
            }
            if (peek == 34) {
                fetchDouble();
                return;
            }
            if (peek != 62) {
                if (peek != 63) {
                    switch (peek) {
                        case 37:
                            if (checkDirective()) {
                                fetchDirective();
                                return;
                            }
                            break;
                        case 38:
                            fetchAnchor();
                            return;
                        case 39:
                            fetchSingle();
                            return;
                        default:
                            switch (peek) {
                                case 44:
                                    fetchFlowEntry();
                                    return;
                                case 45:
                                    if (checkDocumentStart()) {
                                        fetchDocumentStart();
                                        return;
                                    } else if (checkBlockEntry()) {
                                        fetchBlockEntry();
                                        return;
                                    }
                                    break;
                                case 46:
                                    if (checkDocumentEnd()) {
                                        fetchDocumentEnd();
                                        return;
                                    }
                                    break;
                                default:
                                    switch (peek) {
                                        case 123:
                                            fetchFlowMappingStart();
                                            return;
                                        case 124:
                                            if (this.flowLevel == 0) {
                                                fetchLiteral();
                                                return;
                                            }
                                            break;
                                        case 125:
                                            fetchFlowMappingEnd();
                                            return;
                                    }
                            }
                    }
                } else if (checkKey()) {
                    fetchKey();
                    return;
                }
            } else if (this.flowLevel == 0) {
                fetchFolded();
                return;
            }
        } else if (checkValue()) {
            fetchValue();
            return;
        }
        if (checkPlain()) {
            fetchPlain();
            return;
        }
        String escapeChar = escapeChar(String.valueOf(Character.toChars(peek)));
        if (peek == 9) {
            escapeChar = escapeChar + "(TAB)";
        }
        throw new ScannerException("while scanning for the next token", null, String.format("found character '%s' that cannot start any token. (Do not use %s for indentation)", escapeChar, escapeChar), this.reader.getMark());
    }

    private String escapeChar(String str) {
        for (Character ch : ESCAPE_REPLACEMENTS.keySet()) {
            if (ESCAPE_REPLACEMENTS.get(ch).equals(str)) {
                return "\\" + ch;
            }
        }
        return str;
    }

    private int nextPossibleSimpleKey() {
        if (this.possibleSimpleKeys.isEmpty()) {
            return -1;
        }
        return this.possibleSimpleKeys.values().iterator().next().getTokenNumber();
    }

    private void stalePossibleSimpleKeys() {
        if (this.possibleSimpleKeys.isEmpty()) {
            return;
        }
        Iterator<SimpleKey> it = this.possibleSimpleKeys.values().iterator();
        while (it.hasNext()) {
            SimpleKey next = it.next();
            if (next.getLine() != this.reader.getLine() || this.reader.getIndex() - next.getIndex() > 1024) {
                if (next.isRequired()) {
                    throw new ScannerException("while scanning a simple key", next.getMark(), "could not find expected ':'", this.reader.getMark());
                }
                it.remove();
            }
        }
    }

    private void savePossibleSimpleKey() {
        boolean z = this.flowLevel == 0 && this.indent == this.reader.getColumn();
        boolean z2 = this.allowSimpleKey;
        if (!z2 && z) {
            throw new YAMLException("A simple key is required only if it is the first token in the current line");
        }
        if (z2) {
            removePossibleSimpleKey();
            this.possibleSimpleKeys.put(Integer.valueOf(this.flowLevel), new SimpleKey(this.tokensTaken + this.tokens.size(), z, this.reader.getIndex(), this.reader.getLine(), this.reader.getColumn(), this.reader.getMark()));
        }
    }

    private void removePossibleSimpleKey() {
        SimpleKey remove = this.possibleSimpleKeys.remove(Integer.valueOf(this.flowLevel));
        if (remove != null && remove.isRequired()) {
            throw new ScannerException("while scanning a simple key", remove.getMark(), "could not find expected ':'", this.reader.getMark());
        }
    }

    private void unwindIndent(int i) {
        if (this.flowLevel != 0) {
            return;
        }
        while (this.indent > i) {
            Mark mark = this.reader.getMark();
            this.indent = this.indents.pop().intValue();
            addToken(new BlockEndToken(mark, mark));
        }
    }

    private boolean addIndent(int i) {
        int i2 = this.indent;
        if (i2 >= i) {
            return false;
        }
        this.indents.push(Integer.valueOf(i2));
        this.indent = i;
        return true;
    }

    private void fetchStreamStart() {
        Mark mark = this.reader.getMark();
        addToken(new StreamStartToken(mark, mark));
    }

    private void fetchStreamEnd() {
        unwindIndent(-1);
        removePossibleSimpleKey();
        this.allowSimpleKey = false;
        this.possibleSimpleKeys.clear();
        Mark mark = this.reader.getMark();
        addToken(new StreamEndToken(mark, mark));
        this.done = true;
    }

    private void fetchDirective() {
        unwindIndent(-1);
        removePossibleSimpleKey();
        this.allowSimpleKey = false;
        addAllTokens(scanDirective());
    }

    private void fetchDocumentStart() {
        fetchDocumentIndicator(true);
    }

    private void fetchDocumentEnd() {
        fetchDocumentIndicator(false);
    }

    private void fetchDocumentIndicator(boolean z) {
        Token documentEndToken;
        unwindIndent(-1);
        removePossibleSimpleKey();
        this.allowSimpleKey = false;
        Mark mark = this.reader.getMark();
        this.reader.forward(3);
        Mark mark2 = this.reader.getMark();
        if (z) {
            documentEndToken = new DocumentStartToken(mark, mark2);
        } else {
            documentEndToken = new DocumentEndToken(mark, mark2);
        }
        addToken(documentEndToken);
    }

    private void fetchFlowSequenceStart() {
        fetchFlowCollectionStart(false);
    }

    private void fetchFlowMappingStart() {
        fetchFlowCollectionStart(true);
    }

    private void fetchFlowCollectionStart(boolean z) {
        Token flowSequenceStartToken;
        savePossibleSimpleKey();
        this.flowLevel++;
        this.allowSimpleKey = true;
        Mark mark = this.reader.getMark();
        this.reader.forward(1);
        Mark mark2 = this.reader.getMark();
        if (z) {
            flowSequenceStartToken = new FlowMappingStartToken(mark, mark2);
        } else {
            flowSequenceStartToken = new FlowSequenceStartToken(mark, mark2);
        }
        addToken(flowSequenceStartToken);
    }

    private void fetchFlowSequenceEnd() {
        fetchFlowCollectionEnd(false);
    }

    private void fetchFlowMappingEnd() {
        fetchFlowCollectionEnd(true);
    }

    private void fetchFlowCollectionEnd(boolean z) {
        Token flowSequenceEndToken;
        removePossibleSimpleKey();
        this.flowLevel--;
        this.allowSimpleKey = false;
        Mark mark = this.reader.getMark();
        this.reader.forward();
        Mark mark2 = this.reader.getMark();
        if (z) {
            flowSequenceEndToken = new FlowMappingEndToken(mark, mark2);
        } else {
            flowSequenceEndToken = new FlowSequenceEndToken(mark, mark2);
        }
        addToken(flowSequenceEndToken);
    }

    private void fetchFlowEntry() {
        this.allowSimpleKey = true;
        removePossibleSimpleKey();
        Mark mark = this.reader.getMark();
        this.reader.forward();
        addToken(new FlowEntryToken(mark, this.reader.getMark()));
    }

    private void fetchBlockEntry() {
        if (this.flowLevel == 0) {
            if (!this.allowSimpleKey) {
                throw new ScannerException(null, null, "sequence entries are not allowed here", this.reader.getMark());
            }
            if (addIndent(this.reader.getColumn())) {
                Mark mark = this.reader.getMark();
                addToken(new BlockSequenceStartToken(mark, mark));
            }
        }
        this.allowSimpleKey = true;
        removePossibleSimpleKey();
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        addToken(new BlockEntryToken(mark2, this.reader.getMark()));
    }

    private void fetchKey() {
        if (this.flowLevel == 0) {
            if (!this.allowSimpleKey) {
                throw new ScannerException(null, null, "mapping keys are not allowed here", this.reader.getMark());
            }
            if (addIndent(this.reader.getColumn())) {
                Mark mark = this.reader.getMark();
                addToken(new BlockMappingStartToken(mark, mark));
            }
        }
        this.allowSimpleKey = this.flowLevel == 0;
        removePossibleSimpleKey();
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        addToken(new KeyToken(mark2, this.reader.getMark()));
    }

    private void fetchValue() {
        SimpleKey remove = this.possibleSimpleKeys.remove(Integer.valueOf(this.flowLevel));
        if (remove != null) {
            addToken(remove.getTokenNumber() - this.tokensTaken, new KeyToken(remove.getMark(), remove.getMark()));
            if (this.flowLevel == 0 && addIndent(remove.getColumn())) {
                addToken(remove.getTokenNumber() - this.tokensTaken, new BlockMappingStartToken(remove.getMark(), remove.getMark()));
            }
            this.allowSimpleKey = false;
        } else {
            int i = this.flowLevel;
            if (i == 0 && !this.allowSimpleKey) {
                throw new ScannerException(null, null, "mapping values are not allowed here", this.reader.getMark());
            }
            if (i == 0 && addIndent(this.reader.getColumn())) {
                Mark mark = this.reader.getMark();
                addToken(new BlockMappingStartToken(mark, mark));
            }
            this.allowSimpleKey = this.flowLevel == 0;
            removePossibleSimpleKey();
        }
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        addToken(new ValueToken(mark2, this.reader.getMark()));
    }

    private void fetchAlias() {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanAnchor(false));
    }

    private void fetchAnchor() {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanAnchor(true));
    }

    private void fetchTag() {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanTag());
    }

    private void fetchLiteral() {
        fetchBlockScalar('|');
    }

    private void fetchFolded() {
        fetchBlockScalar(Typography.greater);
    }

    private void fetchBlockScalar(char c) {
        this.allowSimpleKey = true;
        removePossibleSimpleKey();
        addAllTokens(scanBlockScalar(c));
    }

    private void fetchSingle() {
        fetchFlowScalar(RuleUtils.QUOTE);
    }

    private void fetchDouble() {
        fetchFlowScalar('\"');
    }

    private void fetchFlowScalar(char c) {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanFlowScalar(c));
    }

    private void fetchPlain() {
        savePossibleSimpleKey();
        this.allowSimpleKey = false;
        addToken(scanPlain());
    }

    private boolean checkDirective() {
        return this.reader.getColumn() == 0;
    }

    private boolean checkDocumentStart() {
        return this.reader.getColumn() == 0 && "---".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3));
    }

    private boolean checkDocumentEnd() {
        return this.reader.getColumn() == 0 && "...".equals(this.reader.prefix(3)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3));
    }

    private boolean checkBlockEntry() {
        return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }

    private boolean checkKey() {
        if (this.flowLevel != 0) {
            return true;
        }
        return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }

    private boolean checkValue() {
        if (this.flowLevel != 0) {
            return true;
        }
        return Constant.NULL_BL_T_LINEBR.has(this.reader.peek(1));
    }

    private boolean checkPlain() {
        int peek = this.reader.peek();
        if (Constant.NULL_BL_T_LINEBR.hasNo(peek, "-?:,[]{}#&*!|>'\"%@`")) {
            return true;
        }
        if (Constant.NULL_BL_T_LINEBR.hasNo(this.reader.peek(1))) {
            if (peek == 45) {
                return true;
            }
            if (this.flowLevel == 0 && "?:".indexOf(peek) != -1) {
                return true;
            }
        }
        return false;
    }

    private void scanToNextToken() {
        boolean z;
        CommentType commentType;
        int i;
        Token token;
        if (this.reader.getIndex() == 0 && this.reader.peek() == 65279) {
            this.reader.forward();
        }
        int i2 = -1;
        boolean z2 = false;
        while (!z2) {
            Mark mark = this.reader.getMark();
            int column = this.reader.getColumn();
            int i3 = 0;
            while (this.reader.peek(i3) == 32) {
                i3++;
            }
            if (i3 > 0) {
                this.reader.forward(i3);
            }
            if (this.reader.peek() == 35) {
                if (column != 0 && ((token = this.lastToken) == null || token.getTokenId() != Token.ID.BlockEntry)) {
                    commentType = CommentType.IN_LINE;
                    i = this.reader.getColumn();
                } else if (i2 == this.reader.getColumn()) {
                    i = i2;
                    commentType = CommentType.IN_LINE;
                } else {
                    commentType = CommentType.BLOCK;
                    i = -1;
                }
                CommentToken scanComment = scanComment(commentType);
                if (this.parseComments) {
                    addToken(scanComment);
                }
                i2 = i;
                z = true;
            } else {
                z = false;
            }
            String scanLineBreak = scanLineBreak();
            if (scanLineBreak.length() != 0) {
                if (this.parseComments && !z && column == 0) {
                    addToken(new CommentToken(CommentType.BLANK_LINE, scanLineBreak, mark, this.reader.getMark()));
                }
                if (this.flowLevel == 0) {
                    this.allowSimpleKey = true;
                }
            } else {
                z2 = true;
            }
        }
    }

    private CommentToken scanComment(CommentType commentType) {
        Mark mark = this.reader.getMark();
        this.reader.forward();
        int i = 0;
        while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i))) {
            i++;
        }
        return new CommentToken(commentType, this.reader.prefixForward(i), mark, this.reader.getMark());
    }

    private List<Token> scanDirective() {
        Mark mark;
        List list;
        Mark mark2 = this.reader.getMark();
        this.reader.forward();
        String scanDirectiveName = scanDirectiveName(mark2);
        if (YAMLFactory.FORMAT_NAME_YAML.equals(scanDirectiveName)) {
            list = scanYamlDirectiveValue(mark2);
            mark = this.reader.getMark();
        } else if ("TAG".equals(scanDirectiveName)) {
            list = scanTagDirectiveValue(mark2);
            mark = this.reader.getMark();
        } else {
            mark = this.reader.getMark();
            int i = 0;
            while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i))) {
                i++;
            }
            if (i > 0) {
                this.reader.forward(i);
            }
            list = null;
        }
        return makeTokenList(new DirectiveToken(scanDirectiveName, list, mark2, mark), scanDirectiveIgnoredLine(mark2));
    }

    private String scanDirectiveName(Mark mark) {
        int i = 0;
        int peek = this.reader.peek(0);
        while (Constant.ALPHA.has(peek)) {
            i++;
            peek = this.reader.peek(i);
        }
        if (i == 0) {
            throw new ScannerException("while scanning a directive", mark, "expected alphabetic or numeric character, but found " + String.valueOf(Character.toChars(peek)) + "(" + peek + ")", this.reader.getMark());
        }
        String prefixForward = this.reader.prefixForward(i);
        int peek2 = this.reader.peek();
        if (!Constant.NULL_BL_LINEBR.hasNo(peek2)) {
            return prefixForward;
        }
        throw new ScannerException("while scanning a directive", mark, "expected alphabetic or numeric character, but found " + String.valueOf(Character.toChars(peek2)) + "(" + peek2 + ")", this.reader.getMark());
    }

    private List<Integer> scanYamlDirectiveValue(Mark mark) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        Integer scanYamlDirectiveNumber = scanYamlDirectiveNumber(mark);
        int peek = this.reader.peek();
        if (peek != 46) {
            throw new ScannerException("while scanning a directive", mark, "expected a digit or '.', but found " + String.valueOf(Character.toChars(peek)) + "(" + peek + ")", this.reader.getMark());
        }
        this.reader.forward();
        Integer scanYamlDirectiveNumber2 = scanYamlDirectiveNumber(mark);
        int peek2 = this.reader.peek();
        if (Constant.NULL_BL_LINEBR.hasNo(peek2)) {
            throw new ScannerException("while scanning a directive", mark, "expected a digit or ' ', but found " + String.valueOf(Character.toChars(peek2)) + "(" + peek2 + ")", this.reader.getMark());
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(scanYamlDirectiveNumber);
        arrayList.add(scanYamlDirectiveNumber2);
        return arrayList;
    }

    private Integer scanYamlDirectiveNumber(Mark mark) {
        int peek = this.reader.peek();
        if (!Character.isDigit(peek)) {
            throw new ScannerException("while scanning a directive", mark, "expected a digit, but found " + String.valueOf(Character.toChars(peek)) + "(" + peek + ")", this.reader.getMark());
        }
        int i = 0;
        while (Character.isDigit(this.reader.peek(i))) {
            i++;
        }
        return Integer.valueOf(Integer.parseInt(this.reader.prefixForward(i)));
    }

    private List<String> scanTagDirectiveValue(Mark mark) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        String scanTagDirectiveHandle = scanTagDirectiveHandle(mark);
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        String scanTagDirectivePrefix = scanTagDirectivePrefix(mark);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(scanTagDirectiveHandle);
        arrayList.add(scanTagDirectivePrefix);
        return arrayList;
    }

    private String scanTagDirectiveHandle(Mark mark) {
        String scanTagHandle = scanTagHandle("directive", mark);
        int peek = this.reader.peek();
        if (peek == 32) {
            return scanTagHandle;
        }
        throw new ScannerException("while scanning a directive", mark, "expected ' ', but found " + String.valueOf(Character.toChars(peek)) + "(" + peek + ")", this.reader.getMark());
    }

    private String scanTagDirectivePrefix(Mark mark) {
        String scanTagUri = scanTagUri("directive", mark);
        int peek = this.reader.peek();
        if (!Constant.NULL_BL_LINEBR.hasNo(peek)) {
            return scanTagUri;
        }
        throw new ScannerException("while scanning a directive", mark, "expected ' ', but found " + String.valueOf(Character.toChars(peek)) + "(" + peek + ")", this.reader.getMark());
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r5.parseComments != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private org.yaml.snakeyaml.tokens.CommentToken scanDirectiveIgnoredLine(org.yaml.snakeyaml.error.Mark r6) {
        /*
            r5 = this;
        L0:
            org.yaml.snakeyaml.reader.StreamReader r0 = r5.reader
            int r0 = r0.peek()
            r1 = 32
            if (r0 != r1) goto L10
            org.yaml.snakeyaml.reader.StreamReader r0 = r5.reader
            r0.forward()
            goto L0
        L10:
            org.yaml.snakeyaml.reader.StreamReader r0 = r5.reader
            int r0 = r0.peek()
            r1 = 35
            if (r0 != r1) goto L25
            org.yaml.snakeyaml.comments.CommentType r0 = org.yaml.snakeyaml.comments.CommentType.IN_LINE
            org.yaml.snakeyaml.tokens.CommentToken r0 = r5.scanComment(r0)
            boolean r1 = r5.parseComments
            if (r1 == 0) goto L25
            goto L26
        L25:
            r0 = 0
        L26:
            org.yaml.snakeyaml.reader.StreamReader r1 = r5.reader
            int r1 = r1.peek()
            java.lang.String r2 = r5.scanLineBreak()
            int r2 = r2.length()
            if (r2 != 0) goto L6e
            if (r1 != 0) goto L39
            goto L6e
        L39:
            char[] r0 = java.lang.Character.toChars(r1)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            org.yaml.snakeyaml.scanner.ScannerException r2 = new org.yaml.snakeyaml.scanner.ScannerException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "expected a comment or a line break, but found "
            r3.<init>(r4)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.String r3 = "("
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ")"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            org.yaml.snakeyaml.reader.StreamReader r1 = r5.reader
            org.yaml.snakeyaml.error.Mark r1 = r1.getMark()
            java.lang.String r3 = "while scanning a directive"
            r2.<init>(r3, r6, r0, r1)
            throw r2
        L6e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.scanner.ScannerImpl.scanDirectiveIgnoredLine(org.yaml.snakeyaml.error.Mark):org.yaml.snakeyaml.tokens.CommentToken");
    }

    private Token scanAnchor(boolean z) {
        Mark mark = this.reader.getMark();
        String str = this.reader.peek() == 42 ? "alias" : "anchor";
        this.reader.forward();
        int i = 0;
        int peek = this.reader.peek(0);
        while (Constant.NULL_BL_T_LINEBR.hasNo(peek, ":,[]{}/.*&")) {
            i++;
            peek = this.reader.peek(i);
        }
        if (i == 0) {
            throw new ScannerException("while scanning an ".concat(str), mark, "unexpected character found " + String.valueOf(Character.toChars(peek)) + "(" + peek + ")", this.reader.getMark());
        }
        String prefixForward = this.reader.prefixForward(i);
        int peek2 = this.reader.peek();
        if (Constant.NULL_BL_T_LINEBR.hasNo(peek2, "?:,]}%@`")) {
            throw new ScannerException("while scanning an ".concat(str), mark, "unexpected character found " + String.valueOf(Character.toChars(peek2)) + "(" + peek2 + ")", this.reader.getMark());
        }
        Mark mark2 = this.reader.getMark();
        if (z) {
            return new AnchorToken(prefixForward, mark, mark2);
        }
        return new AliasToken(prefixForward, mark, mark2);
    }

    private Token scanTag() {
        String scanTagUri;
        Mark mark = this.reader.getMark();
        boolean z = true;
        int peek = this.reader.peek(1);
        String str = null;
        if (peek == 60) {
            this.reader.forward(2);
            scanTagUri = scanTagUri("tag", mark);
            int peek2 = this.reader.peek();
            if (peek2 != 62) {
                throw new ScannerException("while scanning a tag", mark, "expected '>', but found '" + String.valueOf(Character.toChars(peek2)) + "' (" + peek2 + ")", this.reader.getMark());
            }
            this.reader.forward();
        } else if (Constant.NULL_BL_T_LINEBR.has(peek)) {
            this.reader.forward();
            scanTagUri = "!";
        } else {
            int i = 1;
            while (true) {
                if (!Constant.NULL_BL_LINEBR.hasNo(peek)) {
                    z = false;
                    break;
                }
                if (peek == 33) {
                    break;
                }
                i++;
                peek = this.reader.peek(i);
            }
            if (z) {
                str = scanTagHandle("tag", mark);
            } else {
                this.reader.forward();
                str = "!";
            }
            scanTagUri = scanTagUri("tag", mark);
        }
        int peek3 = this.reader.peek();
        if (Constant.NULL_BL_LINEBR.hasNo(peek3)) {
            throw new ScannerException("while scanning a tag", mark, "expected ' ', but found '" + String.valueOf(Character.toChars(peek3)) + "' (" + peek3 + ")", this.reader.getMark());
        }
        return new TagToken(new TagTuple(str, scanTagUri), mark, this.reader.getMark());
    }

    private List<Token> scanBlockScalar(char c) {
        int i;
        String str;
        Mark mark;
        Mark mark2;
        char c2 = 1;
        boolean z = c == '>';
        StringBuilder sb = new StringBuilder();
        Mark mark3 = this.reader.getMark();
        this.reader.forward();
        Chomping scanBlockScalarIndicators = scanBlockScalarIndicators(mark3);
        int increment = scanBlockScalarIndicators.getIncrement();
        CommentToken scanBlockScalarIgnoredLine = scanBlockScalarIgnoredLine(mark3);
        int i2 = this.indent + 1;
        if (i2 < 1) {
            i2 = 1;
        }
        if (increment == -1) {
            Object[] scanBlockScalarIndentation = scanBlockScalarIndentation();
            str = (String) scanBlockScalarIndentation[0];
            int intValue = ((Integer) scanBlockScalarIndentation[1]).intValue();
            mark = (Mark) scanBlockScalarIndentation[2];
            i = Math.max(i2, intValue);
        } else {
            i = (i2 + increment) - 1;
            Object[] scanBlockScalarBreaks = scanBlockScalarBreaks(i);
            str = (String) scanBlockScalarBreaks[0];
            mark = (Mark) scanBlockScalarBreaks[1];
        }
        String str2 = JsonProperty.USE_DEFAULT_NAME;
        while (this.reader.getColumn() == i && this.reader.peek() != 0) {
            sb.append(str);
            char c3 = " \t".indexOf(this.reader.peek()) == -1 ? c2 : (char) 0;
            int i3 = 0;
            while (Constant.NULL_OR_LINEBR.hasNo(this.reader.peek(i3))) {
                i3++;
            }
            sb.append(this.reader.prefixForward(i3));
            str2 = scanLineBreak();
            Object[] scanBlockScalarBreaks2 = scanBlockScalarBreaks(i);
            String str3 = (String) scanBlockScalarBreaks2[0];
            mark2 = (Mark) scanBlockScalarBreaks2[c2];
            if (this.reader.getColumn() != i || this.reader.peek() == 0) {
                str = str3;
                break;
            }
            if (z && "\n".equals(str2) && c3 != 0 && " \t".indexOf(this.reader.peek()) == -1) {
                if (str3.length() == 0) {
                    sb.append(" ");
                }
            } else {
                sb.append(str2);
            }
            mark = mark2;
            str = str3;
            c2 = 1;
        }
        mark2 = mark;
        if (scanBlockScalarIndicators.chompTailIsNotFalse()) {
            sb.append(str2);
        }
        if (scanBlockScalarIndicators.chompTailIsTrue()) {
            sb.append(str);
        }
        return makeTokenList(scanBlockScalarIgnoredLine, new ScalarToken(sb.toString(), false, mark3, mark2, DumperOptions.ScalarStyle.createStyle(Character.valueOf(c))));
    }

    private Chomping scanBlockScalarIndicators(Mark mark) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        int peek = this.reader.peek();
        int i = -1;
        if (peek == 45 || peek == 43) {
            if (peek == 43) {
                bool = Boolean.TRUE;
            } else {
                bool = Boolean.FALSE;
            }
            bool2 = bool;
            this.reader.forward();
            int peek2 = this.reader.peek();
            if (Character.isDigit(peek2)) {
                i = Integer.parseInt(String.valueOf(Character.toChars(peek2)));
                if (i == 0) {
                    throw new ScannerException("while scanning a block scalar", mark, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
                }
                this.reader.forward();
            }
        } else {
            bool2 = null;
            if (Character.isDigit(peek)) {
                i = Integer.parseInt(String.valueOf(Character.toChars(peek)));
                if (i == 0) {
                    throw new ScannerException("while scanning a block scalar", mark, "expected indentation indicator in the range 1-9, but found 0", this.reader.getMark());
                }
                this.reader.forward();
                int peek3 = this.reader.peek();
                if (peek3 == 45 || peek3 == 43) {
                    if (peek3 == 43) {
                        bool3 = Boolean.TRUE;
                    } else {
                        bool3 = Boolean.FALSE;
                    }
                    bool2 = bool3;
                    this.reader.forward();
                }
            }
        }
        int peek4 = this.reader.peek();
        if (Constant.NULL_BL_LINEBR.hasNo(peek4)) {
            throw new ScannerException("while scanning a block scalar", mark, "expected chomping or indentation indicators, but found " + String.valueOf(Character.toChars(peek4)) + "(" + peek4 + ")", this.reader.getMark());
        }
        return new Chomping(bool2, i);
    }

    private CommentToken scanBlockScalarIgnoredLine(Mark mark) {
        while (this.reader.peek() == 32) {
            this.reader.forward();
        }
        CommentToken scanComment = this.reader.peek() == 35 ? scanComment(CommentType.IN_LINE) : null;
        int peek = this.reader.peek();
        if (scanLineBreak().length() != 0 || peek == 0) {
            return scanComment;
        }
        throw new ScannerException("while scanning a block scalar", mark, "expected a comment or a line break, but found " + String.valueOf(Character.toChars(peek)) + "(" + peek + ")", this.reader.getMark());
    }

    private Object[] scanBlockScalarIndentation() {
        StringBuilder sb = new StringBuilder();
        Mark mark = this.reader.getMark();
        int i = 0;
        while (Constant.LINEBR.has(this.reader.peek(), " \r")) {
            if (this.reader.peek() != 32) {
                sb.append(scanLineBreak());
                mark = this.reader.getMark();
            } else {
                this.reader.forward();
                if (this.reader.getColumn() > i) {
                    i = this.reader.getColumn();
                }
            }
        }
        return new Object[]{sb.toString(), Integer.valueOf(i), mark};
    }

    private Object[] scanBlockScalarBreaks(int i) {
        StringBuilder sb = new StringBuilder();
        Mark mark = this.reader.getMark();
        for (int column = this.reader.getColumn(); column < i && this.reader.peek() == 32; column++) {
            this.reader.forward();
        }
        while (true) {
            String scanLineBreak = scanLineBreak();
            if (scanLineBreak.length() == 0) {
                return new Object[]{sb.toString(), mark};
            }
            sb.append(scanLineBreak);
            mark = this.reader.getMark();
            for (int column2 = this.reader.getColumn(); column2 < i && this.reader.peek() == 32; column2++) {
                this.reader.forward();
            }
        }
    }

    private Token scanFlowScalar(char c) {
        boolean z = c == '\"';
        StringBuilder sb = new StringBuilder();
        Mark mark = this.reader.getMark();
        int peek = this.reader.peek();
        this.reader.forward();
        sb.append(scanFlowScalarNonSpaces(z, mark));
        while (this.reader.peek() != peek) {
            sb.append(scanFlowScalarSpaces(mark));
            sb.append(scanFlowScalarNonSpaces(z, mark));
        }
        this.reader.forward();
        return new ScalarToken(sb.toString(), false, mark, this.reader.getMark(), DumperOptions.ScalarStyle.createStyle(Character.valueOf(c)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
    
        if (r1 == 39) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String scanFlowScalarNonSpaces(boolean r7, org.yaml.snakeyaml.error.Mark r8) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.scanner.ScannerImpl.scanFlowScalarNonSpaces(boolean, org.yaml.snakeyaml.error.Mark):java.lang.String");
    }

    private String scanFlowScalarSpaces(Mark mark) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (" \t".indexOf(this.reader.peek(i)) != -1) {
            i++;
        }
        String prefixForward = this.reader.prefixForward(i);
        if (this.reader.peek() == 0) {
            throw new ScannerException("while scanning a quoted scalar", mark, "found unexpected end of stream", this.reader.getMark());
        }
        String scanLineBreak = scanLineBreak();
        if (scanLineBreak.length() != 0) {
            String scanFlowScalarBreaks = scanFlowScalarBreaks(mark);
            if (!"\n".equals(scanLineBreak)) {
                sb.append(scanLineBreak);
            } else if (scanFlowScalarBreaks.length() == 0) {
                sb.append(" ");
            }
            sb.append(scanFlowScalarBreaks);
        } else {
            sb.append(prefixForward);
        }
        return sb.toString();
    }

    private String scanFlowScalarBreaks(Mark mark) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String prefix = this.reader.prefix(3);
            if (("---".equals(prefix) || "...".equals(prefix)) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3))) {
                throw new ScannerException("while scanning a quoted scalar", mark, "found unexpected document separator", this.reader.getMark());
            }
            while (" \t".indexOf(this.reader.peek()) != -1) {
                this.reader.forward();
            }
            String scanLineBreak = scanLineBreak();
            if (scanLineBreak.length() != 0) {
                sb.append(scanLineBreak);
            } else {
                return sb.toString();
            }
        }
    }

    private Token scanPlain() {
        StringBuilder sb = new StringBuilder();
        Mark mark = this.reader.getMark();
        int i = this.indent + 1;
        Mark mark2 = mark;
        String str = JsonProperty.USE_DEFAULT_NAME;
        while (this.reader.peek() != 35) {
            int i2 = 0;
            while (true) {
                int peek = this.reader.peek(i2);
                if (!Constant.NULL_BL_T_LINEBR.has(peek)) {
                    if (peek == 58) {
                        if (Constant.NULL_BL_T_LINEBR.has(this.reader.peek(i2 + 1), this.flowLevel != 0 ? ",[]{}" : JsonProperty.USE_DEFAULT_NAME)) {
                            break;
                        }
                    }
                    if (this.flowLevel != 0 && ",?[]{}".indexOf(peek) != -1) {
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            if (i2 != 0) {
                this.allowSimpleKey = false;
                sb.append(str);
                sb.append(this.reader.prefixForward(i2));
                mark2 = this.reader.getMark();
                str = scanPlainSpaces();
                if (str.length() == 0 || this.reader.peek() == 35 || (this.flowLevel == 0 && this.reader.getColumn() < i)) {
                    break;
                }
            } else {
                break;
            }
        }
        return new ScalarToken(sb.toString(), mark, mark2, true);
    }

    private boolean atEndOfPlain() {
        int i;
        int column = this.reader.getColumn();
        int i2 = 0;
        while (true) {
            int peek = this.reader.peek(i2);
            if (peek == 0 || !Constant.NULL_BL_T_LINEBR.has(peek)) {
                break;
            }
            i2++;
            column = (Constant.LINEBR.has(peek) || (peek == 13 && this.reader.peek(i2 + 1) == 10) || peek == 65279) ? 0 : column + 1;
        }
        if (this.reader.peek(i2) == 35 || this.reader.peek(i2 + 1) == 0 || ((i = this.flowLevel) == 0 && column < this.indent)) {
            return true;
        }
        if (i == 0) {
            int i3 = 1;
            while (true) {
                int i4 = i2 + i3;
                int peek2 = this.reader.peek(i4);
                if (peek2 == 0 || Constant.NULL_BL_T_LINEBR.has(peek2)) {
                    break;
                }
                if (peek2 == 58 && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(i4 + 1))) {
                    return true;
                }
                i3++;
            }
        }
        return false;
    }

    private String scanPlainSpaces() {
        int i = 0;
        while (true) {
            if (this.reader.peek(i) != 32 && this.reader.peek(i) != 9) {
                break;
            }
            i++;
        }
        String prefixForward = this.reader.prefixForward(i);
        String scanLineBreak = scanLineBreak();
        if (scanLineBreak.length() == 0) {
            return prefixForward;
        }
        this.allowSimpleKey = true;
        String prefix = this.reader.prefix(3);
        if ("---".equals(prefix) || ("...".equals(prefix) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3)))) {
            return JsonProperty.USE_DEFAULT_NAME;
        }
        if (this.parseComments && atEndOfPlain()) {
            return JsonProperty.USE_DEFAULT_NAME;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (this.reader.peek() == 32) {
                this.reader.forward();
            } else {
                String scanLineBreak2 = scanLineBreak();
                if (scanLineBreak2.length() != 0) {
                    sb.append(scanLineBreak2);
                    String prefix2 = this.reader.prefix(3);
                    if ("---".equals(prefix2) || ("...".equals(prefix2) && Constant.NULL_BL_T_LINEBR.has(this.reader.peek(3)))) {
                        break;
                    }
                } else {
                    if ("\n".equals(scanLineBreak)) {
                        return sb.length() == 0 ? " " : sb.toString();
                    }
                    return scanLineBreak + ((Object) sb);
                }
            }
        }
        return JsonProperty.USE_DEFAULT_NAME;
    }

    private String scanTagHandle(String str, Mark mark) {
        int peek = this.reader.peek();
        if (peek != 33) {
            throw new ScannerException("while scanning a " + str, mark, "expected '!', but found " + String.valueOf(Character.toChars(peek)) + "(" + peek + ")", this.reader.getMark());
        }
        int i = 1;
        int peek2 = this.reader.peek(1);
        if (peek2 != 32) {
            int i2 = 1;
            while (Constant.ALPHA.has(peek2)) {
                i2++;
                peek2 = this.reader.peek(i2);
            }
            if (peek2 != 33) {
                this.reader.forward(i2);
                throw new ScannerException("while scanning a " + str, mark, "expected '!', but found " + String.valueOf(Character.toChars(peek2)) + "(" + peek2 + ")", this.reader.getMark());
            }
            i = 1 + i2;
        }
        return this.reader.prefixForward(i);
    }

    private String scanTagUri(String str, Mark mark) {
        StringBuilder sb = new StringBuilder();
        int peek = this.reader.peek(0);
        int i = 0;
        while (Constant.URI_CHARS.has(peek)) {
            if (peek == 37) {
                sb.append(this.reader.prefixForward(i));
                sb.append(scanUriEscapes(str, mark));
                i = 0;
            } else {
                i++;
            }
            peek = this.reader.peek(i);
        }
        if (i != 0) {
            sb.append(this.reader.prefixForward(i));
        }
        if (sb.length() == 0) {
            throw new ScannerException("while scanning a " + str, mark, "expected URI, but found " + String.valueOf(Character.toChars(peek)) + "(" + peek + ")", this.reader.getMark());
        }
        return sb.toString();
    }

    private String scanUriEscapes(String str, Mark mark) {
        int i = 1;
        while (this.reader.peek(i * 3) == 37) {
            i++;
        }
        Mark mark2 = this.reader.getMark();
        ByteBuffer allocate = ByteBuffer.allocate(i);
        while (this.reader.peek() == 37) {
            this.reader.forward();
            try {
                allocate.put((byte) Integer.parseInt(this.reader.prefix(2), 16));
                this.reader.forward(2);
            } catch (NumberFormatException unused) {
                int peek = this.reader.peek();
                String valueOf = String.valueOf(Character.toChars(peek));
                int peek2 = this.reader.peek(1);
                throw new ScannerException("while scanning a " + str, mark, "expected URI escape sequence of 2 hexadecimal numbers, but found " + valueOf + "(" + peek + ") and " + String.valueOf(Character.toChars(peek2)) + "(" + peek2 + ")", this.reader.getMark());
            }
        }
        allocate.flip();
        try {
            return UriEncoder.decode(allocate);
        } catch (CharacterCodingException e) {
            throw new ScannerException("while scanning a " + str, mark, "expected URI in UTF-8: " + e.getMessage(), mark2);
        }
    }

    private String scanLineBreak() {
        int peek = this.reader.peek();
        if (peek != 13 && peek != 10 && peek != 133) {
            if (peek != 8232 && peek != 8233) {
                return JsonProperty.USE_DEFAULT_NAME;
            }
            this.reader.forward();
            return String.valueOf(Character.toChars(peek));
        }
        if (peek == 13 && 10 == this.reader.peek(1)) {
            this.reader.forward(2);
            return "\n";
        }
        this.reader.forward();
        return "\n";
    }

    private List<Token> makeTokenList(Token... tokenArr) {
        ArrayList arrayList = new ArrayList();
        for (Token token : tokenArr) {
            if (token != null && (this.parseComments || !(token instanceof CommentToken))) {
                arrayList.add(token);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Chomping {
        private final int increment;
        private final Boolean value;

        public Chomping(Boolean bool, int i) {
            this.value = bool;
            this.increment = i;
        }

        public boolean chompTailIsNotFalse() {
            Boolean bool = this.value;
            return bool == null || bool.booleanValue();
        }

        public boolean chompTailIsTrue() {
            Boolean bool = this.value;
            return bool != null && bool.booleanValue();
        }

        public int getIncrement() {
            return this.increment;
        }
    }
}
