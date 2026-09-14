package org.yaml.snakeyaml.emitter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.RuleUtils;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.comments.CommentEventsCollector;
import org.yaml.snakeyaml.comments.CommentLine;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.CollectionEndEvent;
import org.yaml.snakeyaml.events.CollectionStartEvent;
import org.yaml.snakeyaml.events.CommentEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.scanner.Constant;
import org.yaml.snakeyaml.util.ArrayStack;

/* loaded from: classes2.dex */
public final class Emitter implements Emitable {
    private static final Map<String, String> DEFAULT_TAG_PREFIXES;
    private static final Map<Character, String> ESCAPE_REPLACEMENTS;
    private static final Pattern HANDLE_FORMAT;
    private static final Set<Character> INVALID_ANCHOR;
    public static final int MAX_INDENT = 10;
    public static final int MIN_INDENT = 1;
    private static final char[] SPACE = {' '};
    private static final Pattern SPACES_PATTERN = Pattern.compile("\\s");
    private final boolean allowUnicode;
    private ScalarAnalysis analysis;
    private int bestIndent;
    private final char[] bestLineBreak;
    private int bestWidth;
    private final CommentEventsCollector blockCommentsCollector;
    private final Boolean canonical;
    private int column;
    private final boolean emitComments;
    private Event event;
    private final Queue<Event> events;
    private int flowLevel;
    private Integer indent;
    private final boolean indentWithIndicator;
    private boolean indention;
    private final ArrayStack<Integer> indents;
    private final int indicatorIndent;
    private final CommentEventsCollector inlineCommentsCollector;
    private boolean mappingContext;
    private final int maxSimpleKeyLength;
    private boolean openEnded;
    private String preparedAnchor;
    private String preparedTag;
    private final Boolean prettyFlow;
    private boolean rootContext;
    private boolean simpleKeyContext;
    private final boolean splitLines;
    private final Writer stream;
    private DumperOptions.ScalarStyle style;
    private Map<String, String> tagPrefixes;
    private boolean whitespace;
    private final ArrayStack<EmitterState> states = new ArrayStack<>(100);
    private EmitterState state = new ExpectStreamStart(this, null);

    void writeStreamStart() {
    }

    static /* synthetic */ int access$2210(Emitter emitter) {
        int i = emitter.flowLevel;
        emitter.flowLevel = i - 1;
        return i;
    }

    static {
        HashSet hashSet = new HashSet();
        INVALID_ANCHOR = hashSet;
        hashSet.add('[');
        hashSet.add(']');
        hashSet.add('{');
        hashSet.add('}');
        hashSet.add(Character.valueOf(RuleUtils.COMMA));
        hashSet.add('*');
        hashSet.add(Character.valueOf(Typography.amp));
        HashMap hashMap = new HashMap();
        ESCAPE_REPLACEMENTS = hashMap;
        hashMap.put((char) 0, "0");
        hashMap.put((char) 7, "a");
        hashMap.put('\b', "b");
        hashMap.put('\t', "t");
        hashMap.put('\n', "n");
        hashMap.put((char) 11, "v");
        hashMap.put('\f', "f");
        hashMap.put('\r', "r");
        hashMap.put((char) 27, "e");
        hashMap.put('\"', "\"");
        hashMap.put('\\', "\\");
        hashMap.put((char) 133, "N");
        hashMap.put(Character.valueOf(Typography.nbsp), "_");
        hashMap.put((char) 8232, "L");
        hashMap.put((char) 8233, "P");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DEFAULT_TAG_PREFIXES = linkedHashMap;
        linkedHashMap.put("!", "!");
        linkedHashMap.put(Tag.PREFIX, "!!");
        HANDLE_FORMAT = Pattern.compile("^![-_\\w]*!$");
    }

    public Emitter(Writer writer, DumperOptions dumperOptions) {
        this.stream = writer;
        ArrayDeque arrayDeque = new ArrayDeque(100);
        this.events = arrayDeque;
        this.event = null;
        this.indents = new ArrayStack<>(10);
        this.indent = null;
        this.flowLevel = 0;
        this.mappingContext = false;
        this.simpleKeyContext = false;
        this.column = 0;
        this.whitespace = true;
        this.indention = true;
        this.openEnded = false;
        this.canonical = Boolean.valueOf(dumperOptions.isCanonical());
        this.prettyFlow = Boolean.valueOf(dumperOptions.isPrettyFlow());
        this.allowUnicode = dumperOptions.isAllowUnicode();
        this.bestIndent = 2;
        if (dumperOptions.getIndent() > 1 && dumperOptions.getIndent() < 10) {
            this.bestIndent = dumperOptions.getIndent();
        }
        this.indicatorIndent = dumperOptions.getIndicatorIndent();
        this.indentWithIndicator = dumperOptions.getIndentWithIndicator();
        this.bestWidth = 80;
        if (dumperOptions.getWidth() > this.bestIndent * 2) {
            this.bestWidth = dumperOptions.getWidth();
        }
        this.bestLineBreak = dumperOptions.getLineBreak().getString().toCharArray();
        this.splitLines = dumperOptions.getSplitLines();
        this.maxSimpleKeyLength = dumperOptions.getMaxSimpleKeyLength();
        this.emitComments = dumperOptions.isProcessComments();
        this.tagPrefixes = new LinkedHashMap();
        this.preparedAnchor = null;
        this.preparedTag = null;
        this.analysis = null;
        this.style = null;
        this.blockCommentsCollector = new CommentEventsCollector(arrayDeque, CommentType.BLANK_LINE, CommentType.BLOCK);
        this.inlineCommentsCollector = new CommentEventsCollector(arrayDeque, CommentType.IN_LINE);
    }

    @Override // org.yaml.snakeyaml.emitter.Emitable
    public void emit(Event event) throws IOException {
        this.events.add(event);
        while (!needMoreEvents()) {
            this.event = this.events.poll();
            this.state.expect();
            this.event = null;
        }
    }

    private boolean needMoreEvents() {
        if (this.events.isEmpty()) {
            return true;
        }
        Iterator<Event> it = this.events.iterator();
        Event next = it.next();
        while (true) {
            Event event = next;
            if (event instanceof CommentEvent) {
                if (!it.hasNext()) {
                    return true;
                }
                next = it.next();
            } else {
                if (event instanceof DocumentStartEvent) {
                    return needEvents(it, 1);
                }
                if (event instanceof SequenceStartEvent) {
                    return needEvents(it, 2);
                }
                if (event instanceof MappingStartEvent) {
                    return needEvents(it, 3);
                }
                if (event instanceof StreamStartEvent) {
                    return needEvents(it, 2);
                }
                if (!(event instanceof StreamEndEvent) && this.emitComments) {
                    return needEvents(it, 1);
                }
                return false;
            }
        }
    }

    private boolean needEvents(Iterator<Event> it, int i) {
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Event next = it.next();
            if (!(next instanceof CommentEvent)) {
                i2++;
                if ((next instanceof DocumentStartEvent) || (next instanceof CollectionStartEvent)) {
                    i3++;
                } else if ((next instanceof DocumentEndEvent) || (next instanceof CollectionEndEvent)) {
                    i3--;
                } else if (next instanceof StreamEndEvent) {
                    i3 = -1;
                }
                if (i3 < 0) {
                    return false;
                }
            }
        }
        return i2 < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void increaseIndent(boolean z, boolean z2) {
        this.indents.push(this.indent);
        Integer num = this.indent;
        if (num != null) {
            if (z2) {
                return;
            }
            this.indent = Integer.valueOf(num.intValue() + this.bestIndent);
        } else if (z) {
            this.indent = Integer.valueOf(this.bestIndent);
        } else {
            this.indent = 0;
        }
    }

    /* loaded from: classes2.dex */
    private class ExpectStreamStart implements EmitterState {
        private ExpectStreamStart() {
        }

        /* synthetic */ ExpectStreamStart(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof StreamStartEvent) {
                Emitter.this.writeStreamStart();
                Emitter.this.state = new ExpectFirstDocumentStart(Emitter.this, null);
                return;
            }
            throw new EmitterException("expected StreamStartEvent, but got " + Emitter.this.event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ExpectNothing implements EmitterState {
        private ExpectNothing() {
        }

        /* synthetic */ ExpectNothing(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            throw new EmitterException("expecting nothing, but got " + Emitter.this.event);
        }
    }

    /* loaded from: classes2.dex */
    private class ExpectFirstDocumentStart implements EmitterState {
        private ExpectFirstDocumentStart() {
        }

        /* synthetic */ ExpectFirstDocumentStart(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            new ExpectDocumentStart(true).expect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ExpectDocumentStart implements EmitterState {
        private final boolean first;

        public ExpectDocumentStart(boolean z) {
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            AnonymousClass1 anonymousClass1 = null;
            if (Emitter.this.event instanceof DocumentStartEvent) {
                DocumentStartEvent documentStartEvent = (DocumentStartEvent) Emitter.this.event;
                if ((documentStartEvent.getVersion() != null || documentStartEvent.getTags() != null) && Emitter.this.openEnded) {
                    Emitter.this.writeIndicator("...", true, false, false);
                    Emitter.this.writeIndent();
                }
                if (documentStartEvent.getVersion() != null) {
                    Emitter.this.writeVersionDirective(Emitter.this.prepareVersion(documentStartEvent.getVersion()));
                }
                Emitter.this.tagPrefixes = new LinkedHashMap(Emitter.DEFAULT_TAG_PREFIXES);
                if (documentStartEvent.getTags() != null) {
                    for (String str : new TreeSet(documentStartEvent.getTags().keySet())) {
                        String str2 = documentStartEvent.getTags().get(str);
                        Emitter.this.tagPrefixes.put(str2, str);
                        Emitter.this.writeTagDirective(Emitter.this.prepareTagHandle(str), Emitter.this.prepareTagPrefix(str2));
                    }
                }
                if (!(this.first && !documentStartEvent.getExplicit() && !Emitter.this.canonical.booleanValue() && documentStartEvent.getVersion() == null && (documentStartEvent.getTags() == null || documentStartEvent.getTags().isEmpty()) && !Emitter.this.checkEmptyDocument())) {
                    Emitter.this.writeIndent();
                    Emitter.this.writeIndicator("---", true, false, false);
                    if (Emitter.this.canonical.booleanValue()) {
                        Emitter.this.writeIndent();
                    }
                }
                Emitter.this.state = new ExpectDocumentRoot(Emitter.this, anonymousClass1);
                return;
            }
            if (!(Emitter.this.event instanceof StreamEndEvent)) {
                if (Emitter.this.event instanceof CommentEvent) {
                    Emitter.this.blockCommentsCollector.collectEvents(Emitter.this.event);
                    Emitter.this.writeBlockComment();
                    return;
                }
                throw new EmitterException("expected DocumentStartEvent, but got " + Emitter.this.event);
            }
            Emitter.this.writeStreamEnd();
            Emitter.this.state = new ExpectNothing(Emitter.this, anonymousClass1);
        }
    }

    /* loaded from: classes2.dex */
    private class ExpectDocumentEnd implements EmitterState {
        private ExpectDocumentEnd() {
        }

        /* synthetic */ ExpectDocumentEnd(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter emitter = Emitter.this;
            emitter.event = emitter.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (Emitter.this.event instanceof DocumentEndEvent) {
                Emitter.this.writeIndent();
                if (((DocumentEndEvent) Emitter.this.event).getExplicit()) {
                    Emitter.this.writeIndicator("...", true, false, false);
                    Emitter.this.writeIndent();
                }
                Emitter.this.flushStream();
                Emitter.this.state = new ExpectDocumentStart(false);
                return;
            }
            throw new EmitterException("expected DocumentEndEvent, but got " + Emitter.this.event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ExpectDocumentRoot implements EmitterState {
        private ExpectDocumentRoot() {
        }

        /* synthetic */ ExpectDocumentRoot(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter emitter = Emitter.this;
            emitter.event = emitter.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            AnonymousClass1 anonymousClass1 = null;
            if (!Emitter.this.blockCommentsCollector.isEmpty()) {
                Emitter.this.writeBlockComment();
                if (Emitter.this.event instanceof DocumentEndEvent) {
                    new ExpectDocumentEnd(Emitter.this, anonymousClass1).expect();
                    return;
                }
            }
            Emitter.this.states.push(new ExpectDocumentEnd(Emitter.this, anonymousClass1));
            Emitter.this.expectNode(true, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void expectNode(boolean z, boolean z2, boolean z3) throws IOException {
        this.rootContext = z;
        this.mappingContext = z2;
        this.simpleKeyContext = z3;
        Event event = this.event;
        if (event instanceof AliasEvent) {
            expectAlias();
            return;
        }
        if ((event instanceof ScalarEvent) || (event instanceof CollectionStartEvent)) {
            processAnchor("&");
            processTag();
            Event event2 = this.event;
            if (event2 instanceof ScalarEvent) {
                expectScalar();
                return;
            }
            if (event2 instanceof SequenceStartEvent) {
                if (this.flowLevel != 0 || this.canonical.booleanValue() || ((SequenceStartEvent) this.event).isFlow() || checkEmptySequence()) {
                    expectFlowSequence();
                    return;
                } else {
                    expectBlockSequence();
                    return;
                }
            }
            if (this.flowLevel != 0 || this.canonical.booleanValue() || ((MappingStartEvent) this.event).isFlow() || checkEmptyMapping()) {
                expectFlowMapping();
                return;
            } else {
                expectBlockMapping();
                return;
            }
        }
        throw new EmitterException("expected NodeEvent, but got " + this.event);
    }

    private void expectAlias() throws IOException {
        if (!(this.event instanceof AliasEvent)) {
            throw new EmitterException("Alias must be provided");
        }
        processAnchor("*");
        this.state = this.states.pop();
    }

    private void expectScalar() throws IOException {
        increaseIndent(true, false);
        processScalar();
        this.indent = this.indents.pop();
        this.state = this.states.pop();
    }

    private void expectFlowSequence() throws IOException {
        writeIndicator("[", true, true, false);
        this.flowLevel++;
        increaseIndent(true, false);
        if (this.prettyFlow.booleanValue()) {
            writeIndent();
        }
        this.state = new ExpectFirstFlowSequenceItem(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ExpectFirstFlowSequenceItem implements EmitterState {
        private ExpectFirstFlowSequenceItem() {
        }

        /* synthetic */ ExpectFirstFlowSequenceItem(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (!(Emitter.this.event instanceof SequenceEndEvent)) {
                if (Emitter.this.event instanceof CommentEvent) {
                    Emitter.this.blockCommentsCollector.collectEvents(Emitter.this.event);
                    Emitter.this.writeBlockComment();
                    return;
                }
                if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.states.push(new ExpectFlowSequenceItem(Emitter.this, null));
                Emitter.this.expectNode(false, false, false);
                Emitter emitter = Emitter.this;
                emitter.event = emitter.inlineCommentsCollector.collectEvents(Emitter.this.event);
                Emitter.this.writeInlineComments();
                return;
            }
            Emitter emitter2 = Emitter.this;
            emitter2.indent = (Integer) emitter2.indents.pop();
            Emitter.access$2210(Emitter.this);
            Emitter.this.writeIndicator("]", false, false, false);
            Emitter.this.inlineCommentsCollector.collectEvents();
            Emitter.this.writeInlineComments();
            Emitter emitter3 = Emitter.this;
            emitter3.state = (EmitterState) emitter3.states.pop();
        }
    }

    /* loaded from: classes2.dex */
    private class ExpectFlowSequenceItem implements EmitterState {
        private ExpectFlowSequenceItem() {
        }

        /* synthetic */ ExpectFlowSequenceItem(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (!(Emitter.this.event instanceof SequenceEndEvent)) {
                if (Emitter.this.event instanceof CommentEvent) {
                    Emitter emitter = Emitter.this;
                    emitter.event = emitter.blockCommentsCollector.collectEvents(Emitter.this.event);
                    return;
                }
                Emitter.this.writeIndicator(",", false, false, false);
                Emitter.this.writeBlockComment();
                if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.states.push(new ExpectFlowSequenceItem());
                Emitter.this.expectNode(false, false, false);
                Emitter emitter2 = Emitter.this;
                emitter2.event = emitter2.inlineCommentsCollector.collectEvents(Emitter.this.event);
                Emitter.this.writeInlineComments();
                return;
            }
            Emitter emitter3 = Emitter.this;
            emitter3.indent = (Integer) emitter3.indents.pop();
            Emitter.access$2210(Emitter.this);
            if (!Emitter.this.canonical.booleanValue()) {
                if (Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
            } else {
                Emitter.this.writeIndicator(",", false, false, false);
                Emitter.this.writeIndent();
            }
            Emitter.this.writeIndicator("]", false, false, false);
            Emitter.this.inlineCommentsCollector.collectEvents();
            Emitter.this.writeInlineComments();
            if (Emitter.this.prettyFlow.booleanValue()) {
                Emitter.this.writeIndent();
            }
            Emitter emitter4 = Emitter.this;
            emitter4.state = (EmitterState) emitter4.states.pop();
        }
    }

    private void expectFlowMapping() throws IOException {
        writeIndicator("{", true, true, false);
        this.flowLevel++;
        increaseIndent(true, false);
        if (this.prettyFlow.booleanValue()) {
            writeIndent();
        }
        this.state = new ExpectFirstFlowMappingKey(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ExpectFirstFlowMappingKey implements EmitterState {
        private ExpectFirstFlowMappingKey() {
        }

        /* synthetic */ ExpectFirstFlowMappingKey(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter emitter = Emitter.this;
            emitter.event = emitter.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (!(Emitter.this.event instanceof MappingEndEvent)) {
                if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                    Emitter.this.writeIndent();
                }
                AnonymousClass1 anonymousClass1 = null;
                if (!Emitter.this.canonical.booleanValue() && Emitter.this.checkSimpleKey()) {
                    Emitter.this.states.push(new ExpectFlowMappingSimpleValue(Emitter.this, anonymousClass1));
                    Emitter.this.expectNode(false, true, true);
                    return;
                } else {
                    Emitter.this.writeIndicator("?", true, false, false);
                    Emitter.this.states.push(new ExpectFlowMappingValue(Emitter.this, anonymousClass1));
                    Emitter.this.expectNode(false, true, false);
                    return;
                }
            }
            Emitter emitter2 = Emitter.this;
            emitter2.indent = (Integer) emitter2.indents.pop();
            Emitter.access$2210(Emitter.this);
            Emitter.this.writeIndicator("}", false, false, false);
            Emitter.this.inlineCommentsCollector.collectEvents();
            Emitter.this.writeInlineComments();
            Emitter emitter3 = Emitter.this;
            emitter3.state = (EmitterState) emitter3.states.pop();
        }
    }

    /* loaded from: classes2.dex */
    private class ExpectFlowMappingKey implements EmitterState {
        private ExpectFlowMappingKey() {
        }

        /* synthetic */ ExpectFlowMappingKey(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.event instanceof MappingEndEvent) {
                Emitter emitter = Emitter.this;
                emitter.indent = (Integer) emitter.indents.pop();
                Emitter.access$2210(Emitter.this);
                if (Emitter.this.canonical.booleanValue()) {
                    Emitter.this.writeIndicator(",", false, false, false);
                    Emitter.this.writeIndent();
                }
                if (Emitter.this.prettyFlow.booleanValue()) {
                    Emitter.this.writeIndent();
                }
                Emitter.this.writeIndicator("}", false, false, false);
                Emitter.this.inlineCommentsCollector.collectEvents();
                Emitter.this.writeInlineComments();
                Emitter emitter2 = Emitter.this;
                emitter2.state = (EmitterState) emitter2.states.pop();
                return;
            }
            Emitter.this.writeIndicator(",", false, false, false);
            Emitter emitter3 = Emitter.this;
            emitter3.event = emitter3.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (Emitter.this.canonical.booleanValue() || ((Emitter.this.column > Emitter.this.bestWidth && Emitter.this.splitLines) || Emitter.this.prettyFlow.booleanValue())) {
                Emitter.this.writeIndent();
            }
            AnonymousClass1 anonymousClass1 = null;
            if (!Emitter.this.canonical.booleanValue() && Emitter.this.checkSimpleKey()) {
                Emitter.this.states.push(new ExpectFlowMappingSimpleValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, true);
            } else {
                Emitter.this.writeIndicator("?", true, false, false);
                Emitter.this.states.push(new ExpectFlowMappingValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, false);
            }
        }
    }

    /* loaded from: classes2.dex */
    private class ExpectFlowMappingSimpleValue implements EmitterState {
        private ExpectFlowMappingSimpleValue() {
        }

        /* synthetic */ ExpectFlowMappingSimpleValue(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndicator(":", false, false, false);
            Emitter emitter = Emitter.this;
            emitter.event = emitter.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeInlineComments();
            Emitter.this.states.push(new ExpectFlowMappingKey(Emitter.this, null));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }
    }

    /* loaded from: classes2.dex */
    private class ExpectFlowMappingValue implements EmitterState {
        private ExpectFlowMappingValue() {
        }

        /* synthetic */ ExpectFlowMappingValue(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (Emitter.this.canonical.booleanValue() || Emitter.this.column > Emitter.this.bestWidth || Emitter.this.prettyFlow.booleanValue()) {
                Emitter.this.writeIndent();
            }
            Emitter.this.writeIndicator(":", true, false, false);
            Emitter emitter = Emitter.this;
            emitter.event = emitter.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeInlineComments();
            Emitter.this.states.push(new ExpectFlowMappingKey(Emitter.this, null));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }
    }

    private void expectBlockSequence() throws IOException {
        increaseIndent(false, this.mappingContext && !this.indention);
        this.state = new ExpectFirstBlockSequenceItem(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ExpectFirstBlockSequenceItem implements EmitterState {
        private ExpectFirstBlockSequenceItem() {
        }

        /* synthetic */ ExpectFirstBlockSequenceItem(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            new ExpectBlockSequenceItem(true).expect();
        }
    }

    /* loaded from: classes2.dex */
    private class ExpectBlockSequenceItem implements EmitterState {
        private final boolean first;

        public ExpectBlockSequenceItem(boolean z) {
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            if (this.first || !(Emitter.this.event instanceof SequenceEndEvent)) {
                if (Emitter.this.event instanceof CommentEvent) {
                    Emitter.this.blockCommentsCollector.collectEvents(Emitter.this.event);
                    return;
                }
                Emitter.this.writeIndent();
                if (!Emitter.this.indentWithIndicator || this.first) {
                    Emitter emitter = Emitter.this;
                    emitter.writeWhitespace(emitter.indicatorIndent);
                }
                Emitter.this.writeIndicator("-", true, false, true);
                if (Emitter.this.indentWithIndicator && this.first) {
                    Emitter emitter2 = Emitter.this;
                    emitter2.indent = Integer.valueOf(emitter2.indent.intValue() + Emitter.this.indicatorIndent);
                }
                if (!Emitter.this.blockCommentsCollector.isEmpty()) {
                    Emitter.this.increaseIndent(false, false);
                    Emitter.this.writeBlockComment();
                    if (Emitter.this.event instanceof ScalarEvent) {
                        Emitter emitter3 = Emitter.this;
                        emitter3.analysis = emitter3.analyzeScalar(((ScalarEvent) emitter3.event).getValue());
                        if (!Emitter.this.analysis.isEmpty()) {
                            Emitter.this.writeIndent();
                        }
                    }
                    Emitter emitter4 = Emitter.this;
                    emitter4.indent = (Integer) emitter4.indents.pop();
                }
                Emitter.this.states.push(new ExpectBlockSequenceItem(false));
                Emitter.this.expectNode(false, false, false);
                Emitter.this.inlineCommentsCollector.collectEvents();
                Emitter.this.writeInlineComments();
                return;
            }
            Emitter emitter5 = Emitter.this;
            emitter5.indent = (Integer) emitter5.indents.pop();
            Emitter emitter6 = Emitter.this;
            emitter6.state = (EmitterState) emitter6.states.pop();
        }
    }

    private void expectBlockMapping() throws IOException {
        increaseIndent(false, false);
        this.state = new ExpectFirstBlockMappingKey(this, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ExpectFirstBlockMappingKey implements EmitterState {
        private ExpectFirstBlockMappingKey() {
        }

        /* synthetic */ ExpectFirstBlockMappingKey(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            new ExpectBlockMappingKey(true).expect();
        }
    }

    /* loaded from: classes2.dex */
    private class ExpectBlockMappingKey implements EmitterState {
        private final boolean first;

        public ExpectBlockMappingKey(boolean z) {
            this.first = z;
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter emitter = Emitter.this;
            emitter.event = emitter.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            if (!this.first && (Emitter.this.event instanceof MappingEndEvent)) {
                Emitter emitter2 = Emitter.this;
                emitter2.indent = (Integer) emitter2.indents.pop();
                Emitter emitter3 = Emitter.this;
                emitter3.state = (EmitterState) emitter3.states.pop();
                return;
            }
            Emitter.this.writeIndent();
            AnonymousClass1 anonymousClass1 = null;
            if (Emitter.this.checkSimpleKey()) {
                Emitter.this.states.push(new ExpectBlockMappingSimpleValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, true);
            } else {
                Emitter.this.writeIndicator("?", true, false, true);
                Emitter.this.states.push(new ExpectBlockMappingValue(Emitter.this, anonymousClass1));
                Emitter.this.expectNode(false, true, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFoldedOrLiteral(Event event) {
        if (!event.is(Event.ID.Scalar)) {
            return false;
        }
        DumperOptions.ScalarStyle scalarStyle = ((ScalarEvent) event).getScalarStyle();
        return scalarStyle == DumperOptions.ScalarStyle.FOLDED || scalarStyle == DumperOptions.ScalarStyle.LITERAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ExpectBlockMappingSimpleValue implements EmitterState {
        private ExpectBlockMappingSimpleValue() {
        }

        /* synthetic */ ExpectBlockMappingSimpleValue(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndicator(":", false, false, false);
            Emitter emitter = Emitter.this;
            emitter.event = emitter.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter emitter2 = Emitter.this;
            if (!emitter2.isFoldedOrLiteral(emitter2.event) && Emitter.this.writeInlineComments()) {
                Emitter.this.increaseIndent(true, false);
                Emitter.this.writeIndent();
                Emitter emitter3 = Emitter.this;
                emitter3.indent = (Integer) emitter3.indents.pop();
            }
            Emitter emitter4 = Emitter.this;
            emitter4.event = emitter4.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            if (!Emitter.this.blockCommentsCollector.isEmpty()) {
                Emitter.this.increaseIndent(true, false);
                Emitter.this.writeBlockComment();
                Emitter.this.writeIndent();
                Emitter emitter5 = Emitter.this;
                emitter5.indent = (Integer) emitter5.indents.pop();
            }
            Emitter.this.states.push(new ExpectBlockMappingKey(false));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents();
            Emitter.this.writeInlineComments();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class ExpectBlockMappingValue implements EmitterState {
        private ExpectBlockMappingValue() {
        }

        /* synthetic */ ExpectBlockMappingValue(Emitter emitter, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.yaml.snakeyaml.emitter.EmitterState
        public void expect() throws IOException {
            Emitter.this.writeIndent();
            Emitter.this.writeIndicator(":", true, false, true);
            Emitter emitter = Emitter.this;
            emitter.event = emitter.inlineCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeInlineComments();
            Emitter emitter2 = Emitter.this;
            emitter2.event = emitter2.blockCommentsCollector.collectEventsAndPoll(Emitter.this.event);
            Emitter.this.writeBlockComment();
            Emitter.this.states.push(new ExpectBlockMappingKey(false));
            Emitter.this.expectNode(false, true, false);
            Emitter.this.inlineCommentsCollector.collectEvents(Emitter.this.event);
            Emitter.this.writeInlineComments();
        }
    }

    private boolean checkEmptySequence() {
        return (this.event instanceof SequenceStartEvent) && !this.events.isEmpty() && (this.events.peek() instanceof SequenceEndEvent);
    }

    private boolean checkEmptyMapping() {
        return (this.event instanceof MappingStartEvent) && !this.events.isEmpty() && (this.events.peek() instanceof MappingEndEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkEmptyDocument() {
        if (!(this.event instanceof DocumentStartEvent) || this.events.isEmpty()) {
            return false;
        }
        Event peek = this.events.peek();
        if (!(peek instanceof ScalarEvent)) {
            return false;
        }
        ScalarEvent scalarEvent = (ScalarEvent) peek;
        return scalarEvent.getAnchor() == null && scalarEvent.getTag() == null && scalarEvent.getImplicit() != null && scalarEvent.getValue().length() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkSimpleKey() {
        int i;
        String tag;
        Event event = this.event;
        if (!(event instanceof NodeEvent) || ((NodeEvent) event).getAnchor() == null) {
            i = 0;
        } else {
            if (this.preparedAnchor == null) {
                this.preparedAnchor = prepareAnchor(((NodeEvent) this.event).getAnchor());
            }
            i = this.preparedAnchor.length() + 0;
        }
        Event event2 = this.event;
        if (event2 instanceof ScalarEvent) {
            tag = ((ScalarEvent) event2).getTag();
        } else {
            tag = event2 instanceof CollectionStartEvent ? ((CollectionStartEvent) event2).getTag() : null;
        }
        if (tag != null) {
            if (this.preparedTag == null) {
                this.preparedTag = prepareTag(tag);
            }
            i += this.preparedTag.length();
        }
        Event event3 = this.event;
        if (event3 instanceof ScalarEvent) {
            if (this.analysis == null) {
                this.analysis = analyzeScalar(((ScalarEvent) event3).getValue());
            }
            i += this.analysis.getScalar().length();
        }
        if (i >= this.maxSimpleKeyLength) {
            return false;
        }
        Event event4 = this.event;
        return (event4 instanceof AliasEvent) || !(!(event4 instanceof ScalarEvent) || this.analysis.isEmpty() || this.analysis.isMultiline()) || checkEmptySequence() || checkEmptyMapping();
    }

    private void processAnchor(String str) throws IOException {
        NodeEvent nodeEvent = (NodeEvent) this.event;
        if (nodeEvent.getAnchor() == null) {
            this.preparedAnchor = null;
            return;
        }
        if (this.preparedAnchor == null) {
            this.preparedAnchor = prepareAnchor(nodeEvent.getAnchor());
        }
        writeIndicator(str + this.preparedAnchor, true, false, false);
        this.preparedAnchor = null;
    }

    private void processTag() throws IOException {
        String tag;
        Event event = this.event;
        if (event instanceof ScalarEvent) {
            ScalarEvent scalarEvent = (ScalarEvent) event;
            tag = scalarEvent.getTag();
            if (this.style == null) {
                this.style = chooseScalarStyle();
            }
            if ((!this.canonical.booleanValue() || tag == null) && ((this.style == null && scalarEvent.getImplicit().canOmitTagInPlainScalar()) || (this.style != null && scalarEvent.getImplicit().canOmitTagInNonPlainScalar()))) {
                this.preparedTag = null;
                return;
            } else if (scalarEvent.getImplicit().canOmitTagInPlainScalar() && tag == null) {
                this.preparedTag = null;
                tag = "!";
            }
        } else {
            CollectionStartEvent collectionStartEvent = (CollectionStartEvent) event;
            tag = collectionStartEvent.getTag();
            if ((!this.canonical.booleanValue() || tag == null) && collectionStartEvent.getImplicit()) {
                this.preparedTag = null;
                return;
            }
        }
        if (tag == null) {
            throw new EmitterException("tag is not specified");
        }
        if (this.preparedTag == null) {
            this.preparedTag = prepareTag(tag);
        }
        writeIndicator(this.preparedTag, true, false, false);
        this.preparedTag = null;
    }

    private DumperOptions.ScalarStyle chooseScalarStyle() {
        ScalarEvent scalarEvent = (ScalarEvent) this.event;
        if (this.analysis == null) {
            this.analysis = analyzeScalar(scalarEvent.getValue());
        }
        if ((!scalarEvent.isPlain() && scalarEvent.getScalarStyle() == DumperOptions.ScalarStyle.DOUBLE_QUOTED) || this.canonical.booleanValue()) {
            return DumperOptions.ScalarStyle.DOUBLE_QUOTED;
        }
        if (scalarEvent.isPlain() && scalarEvent.getImplicit().canOmitTagInPlainScalar() && (!this.simpleKeyContext || (!this.analysis.isEmpty() && !this.analysis.isMultiline()))) {
            if (this.flowLevel != 0 && this.analysis.isAllowFlowPlain()) {
                return null;
            }
            if (this.flowLevel == 0 && this.analysis.isAllowBlockPlain()) {
                return null;
            }
        }
        if (!scalarEvent.isPlain() && ((scalarEvent.getScalarStyle() == DumperOptions.ScalarStyle.LITERAL || scalarEvent.getScalarStyle() == DumperOptions.ScalarStyle.FOLDED) && this.flowLevel == 0 && !this.simpleKeyContext && this.analysis.isAllowBlock())) {
            return scalarEvent.getScalarStyle();
        }
        if ((scalarEvent.isPlain() || scalarEvent.getScalarStyle() == DumperOptions.ScalarStyle.SINGLE_QUOTED) && this.analysis.isAllowSingleQuoted() && (!this.simpleKeyContext || !this.analysis.isMultiline())) {
            return DumperOptions.ScalarStyle.SINGLE_QUOTED;
        }
        return DumperOptions.ScalarStyle.DOUBLE_QUOTED;
    }

    private void processScalar() throws IOException {
        ScalarEvent scalarEvent = (ScalarEvent) this.event;
        if (this.analysis == null) {
            this.analysis = analyzeScalar(scalarEvent.getValue());
        }
        if (this.style == null) {
            this.style = chooseScalarStyle();
        }
        boolean z = !this.simpleKeyContext && this.splitLines;
        if (this.style == null) {
            writePlain(this.analysis.getScalar(), z);
        } else {
            int i = AnonymousClass1.$SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle[this.style.ordinal()];
            if (i == 1) {
                writeDoubleQuoted(this.analysis.getScalar(), z);
            } else if (i == 2) {
                writeSingleQuoted(this.analysis.getScalar(), z);
            } else if (i == 3) {
                writeFolded(this.analysis.getScalar(), z);
            } else if (i == 4) {
                writeLiteral(this.analysis.getScalar());
            } else {
                throw new YAMLException("Unexpected style: " + this.style);
            }
        }
        this.analysis = null;
        this.style = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.yaml.snakeyaml.emitter.Emitter$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle;

        static {
            int[] iArr = new int[DumperOptions.ScalarStyle.values().length];
            $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle = iArr;
            try {
                iArr[DumperOptions.ScalarStyle.DOUBLE_QUOTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle[DumperOptions.ScalarStyle.SINGLE_QUOTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle[DumperOptions.ScalarStyle.FOLDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$DumperOptions$ScalarStyle[DumperOptions.ScalarStyle.LITERAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareVersion(DumperOptions.Version version) {
        if (version.major() != 1) {
            throw new EmitterException("unsupported YAML version: " + version);
        }
        return version.getRepresentation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareTagHandle(String str) {
        if (str.length() == 0) {
            throw new EmitterException("tag handle must not be empty");
        }
        if (str.charAt(0) != '!' || str.charAt(str.length() - 1) != '!') {
            throw new EmitterException("tag handle must start and end with '!': " + str);
        }
        if ("!".equals(str) || HANDLE_FORMAT.matcher(str).matches()) {
            return str;
        }
        throw new EmitterException("invalid character in the tag handle: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String prepareTagPrefix(String str) {
        if (str.length() == 0) {
            throw new EmitterException("tag prefix must not be empty");
        }
        StringBuilder sb = new StringBuilder();
        int i = str.charAt(0) == '!' ? 1 : 0;
        while (i < str.length()) {
            i++;
        }
        if (i > 0) {
            sb.append((CharSequence) str, 0, i);
        }
        return sb.toString();
    }

    private String prepareTag(String str) {
        if (str.length() == 0) {
            throw new EmitterException("tag must not be empty");
        }
        if ("!".equals(str)) {
            return str;
        }
        String str2 = null;
        for (String str3 : this.tagPrefixes.keySet()) {
            if (str.startsWith(str3) && ("!".equals(str3) || str3.length() < str.length())) {
                str2 = str3;
            }
        }
        if (str2 != null) {
            str = str.substring(str2.length());
            str2 = this.tagPrefixes.get(str2);
        }
        int length = str.length();
        String substring = length > 0 ? str.substring(0, length) : JsonProperty.USE_DEFAULT_NAME;
        if (str2 != null) {
            return str2 + substring;
        }
        return "!<" + substring + ">";
    }

    static String prepareAnchor(String str) {
        if (str.length() == 0) {
            throw new EmitterException("anchor must not be empty");
        }
        for (Character ch : INVALID_ANCHOR) {
            if (str.indexOf(ch.charValue()) > -1) {
                throw new EmitterException("Invalid character '" + ch + "' in the anchor: " + str);
            }
        }
        if (SPACES_PATTERN.matcher(str).find()) {
            throw new EmitterException("Anchor may not contain spaces: " + str);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x009e, code lost:
    
        if (r14 != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
    
        if (r6 != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a0, code lost:
    
        r0 = true;
        r5 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0129 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.yaml.snakeyaml.emitter.ScalarAnalysis analyzeScalar(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.emitter.Emitter.analyzeScalar(java.lang.String):org.yaml.snakeyaml.emitter.ScalarAnalysis");
    }

    void flushStream() throws IOException {
        this.stream.flush();
    }

    void writeStreamEnd() throws IOException {
        flushStream();
    }

    void writeIndicator(String str, boolean z, boolean z2, boolean z3) throws IOException {
        if (!this.whitespace && z) {
            this.column++;
            this.stream.write(SPACE);
        }
        this.whitespace = z2;
        this.indention = this.indention && z3;
        this.column += str.length();
        this.openEnded = false;
        this.stream.write(str);
    }

    void writeIndent() throws IOException {
        int i;
        Integer num = this.indent;
        int intValue = num != null ? num.intValue() : 0;
        if (!this.indention || (i = this.column) > intValue || (i == intValue && !this.whitespace)) {
            writeLineBreak(null);
        }
        writeWhitespace(intValue - this.column);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeWhitespace(int i) throws IOException {
        if (i <= 0) {
            return;
        }
        this.whitespace = true;
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = ' ';
        }
        this.column += i;
        this.stream.write(cArr);
    }

    private void writeLineBreak(String str) throws IOException {
        this.whitespace = true;
        this.indention = true;
        this.column = 0;
        if (str == null) {
            this.stream.write(this.bestLineBreak);
        } else {
            this.stream.write(str);
        }
    }

    void writeVersionDirective(String str) throws IOException {
        this.stream.write("%YAML ");
        this.stream.write(str);
        writeLineBreak(null);
    }

    void writeTagDirective(String str, String str2) throws IOException {
        this.stream.write("%TAG ");
        this.stream.write(str);
        this.stream.write(SPACE);
        this.stream.write(str2);
        writeLineBreak(null);
    }

    private void writeSingleQuoted(String str, boolean z) throws IOException {
        writeIndicator("'", true, false, false);
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (i <= str.length()) {
            char charAt = i < str.length() ? str.charAt(i) : (char) 0;
            if (z2) {
                if (charAt == 0 || charAt != ' ') {
                    if (i2 + 1 == i && this.column > this.bestWidth && z && i2 != 0 && i != str.length()) {
                        writeIndent();
                    } else {
                        int i3 = i - i2;
                        this.column += i3;
                        this.stream.write(str, i2, i3);
                    }
                    i2 = i;
                }
            } else if (z3) {
                if (charAt == 0 || Constant.LINEBR.hasNo(charAt)) {
                    if (str.charAt(i2) == '\n') {
                        writeLineBreak(null);
                    }
                    for (char c : str.substring(i2, i).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    writeIndent();
                    i2 = i;
                }
            } else if (Constant.LINEBR.has(charAt, "\u0000 '") && i2 < i) {
                int i4 = i - i2;
                this.column += i4;
                this.stream.write(str, i2, i4);
                i2 = i;
            }
            if (charAt == '\'') {
                this.column += 2;
                this.stream.write("''");
                i2 = i + 1;
            }
            if (charAt != 0) {
                z2 = charAt == ' ';
                z3 = Constant.LINEBR.has(charAt);
            }
            i++;
        }
        writeIndicator("'", false, false, false);
    }

    private void writeDoubleQuoted(String str, boolean z) throws IOException {
        String str2;
        writeIndicator("\"", true, false, false);
        int i = 0;
        int i2 = 0;
        while (i <= str.length()) {
            Character valueOf = i < str.length() ? Character.valueOf(str.charAt(i)) : null;
            if (valueOf == null || "\"\\\u0085\u2028\u2029\ufeff".indexOf(valueOf.charValue()) != -1 || ' ' > valueOf.charValue() || valueOf.charValue() > '~') {
                if (i2 < i) {
                    int i3 = i - i2;
                    this.column += i3;
                    this.stream.write(str, i2, i3);
                    i2 = i;
                }
                if (valueOf != null) {
                    Map<Character, String> map = ESCAPE_REPLACEMENTS;
                    if (map.containsKey(valueOf)) {
                        str2 = "\\" + map.get(valueOf);
                    } else if (!this.allowUnicode || !StreamReader.isPrintable(valueOf.charValue())) {
                        if (valueOf.charValue() <= 255) {
                            str2 = "\\x" + ("0" + Integer.toString(valueOf.charValue(), 16)).substring(r4.length() - 2);
                        } else if (valueOf.charValue() >= 55296 && valueOf.charValue() <= 56319) {
                            int i4 = i + 1;
                            if (i4 < str.length()) {
                                str2 = "\\U" + ("000" + Long.toHexString(Character.toCodePoint(valueOf.charValue(), Character.valueOf(str.charAt(i4)).charValue()))).substring(r3.length() - 8);
                                i = i4;
                            } else {
                                str2 = "\\u" + ("000" + Integer.toString(valueOf.charValue(), 16)).substring(r4.length() - 4);
                            }
                        } else {
                            str2 = "\\u" + ("000" + Integer.toString(valueOf.charValue(), 16)).substring(r4.length() - 4);
                        }
                    } else {
                        str2 = String.valueOf(valueOf);
                    }
                    this.column += str2.length();
                    this.stream.write(str2);
                    i2 = i + 1;
                }
            }
            if (i > 0 && i < str.length() - 1 && ((valueOf.charValue() == ' ' || i2 >= i) && this.column + (i - i2) > this.bestWidth && z)) {
                String str3 = i2 >= i ? "\\" : str.substring(i2, i) + "\\";
                if (i2 < i) {
                    i2 = i;
                }
                this.column += str3.length();
                this.stream.write(str3);
                writeIndent();
                this.whitespace = false;
                this.indention = false;
                if (str.charAt(i2) == ' ') {
                    this.column++;
                    this.stream.write("\\");
                }
            }
            i++;
        }
        writeIndicator("\"", false, false, false);
    }

    private boolean writeCommentLines(List<CommentLine> list) throws IOException {
        if (!this.emitComments) {
            return false;
        }
        boolean z = true;
        boolean z2 = false;
        int i = 0;
        for (CommentLine commentLine : list) {
            if (commentLine.getCommentType() != CommentType.BLANK_LINE) {
                if (z) {
                    writeIndicator("#", commentLine.getCommentType() == CommentType.IN_LINE, false, false);
                    int i2 = this.column;
                    i = i2 > 0 ? i2 - 1 : 0;
                    z = false;
                } else {
                    writeWhitespace(i);
                    writeIndicator("#", false, false, false);
                }
                this.stream.write(commentLine.getValue());
                writeLineBreak(null);
            } else {
                writeLineBreak(null);
                writeIndent();
            }
            z2 = true;
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeBlockComment() throws IOException {
        if (this.blockCommentsCollector.isEmpty()) {
            return;
        }
        writeIndent();
        writeCommentLines(this.blockCommentsCollector.consume());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean writeInlineComments() throws IOException {
        return writeCommentLines(this.inlineCommentsCollector.consume());
    }

    private String determineBlockHints(String str) {
        StringBuilder sb = new StringBuilder();
        if (Constant.LINEBR.has(str.charAt(0), " ")) {
            sb.append(this.bestIndent);
        }
        if (Constant.LINEBR.hasNo(str.charAt(str.length() - 1))) {
            sb.append("-");
        } else if (str.length() == 1 || Constant.LINEBR.has(str.charAt(str.length() - 2))) {
            sb.append("+");
        }
        return sb.toString();
    }

    void writeFolded(String str, boolean z) throws IOException {
        String determineBlockHints = determineBlockHints(str);
        writeIndicator(">" + determineBlockHints, true, false, false);
        if (determineBlockHints.length() > 0 && determineBlockHints.charAt(determineBlockHints.length() - 1) == '+') {
            this.openEnded = true;
        }
        if (!writeInlineComments()) {
            writeLineBreak(null);
        }
        boolean z2 = true;
        boolean z3 = true;
        int i = 0;
        boolean z4 = false;
        int i2 = 0;
        while (i <= str.length()) {
            char charAt = i < str.length() ? str.charAt(i) : (char) 0;
            if (z2) {
                if (charAt == 0 || Constant.LINEBR.hasNo(charAt)) {
                    if (!z3 && charAt != 0 && charAt != ' ' && str.charAt(i2) == '\n') {
                        writeLineBreak(null);
                    }
                    z3 = charAt == ' ';
                    for (char c : str.substring(i2, i).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    if (charAt != 0) {
                        writeIndent();
                    }
                    i2 = i;
                }
            } else if (z4) {
                if (charAt != ' ') {
                    if (i2 + 1 == i && this.column > this.bestWidth && z) {
                        writeIndent();
                    } else {
                        int i3 = i - i2;
                        this.column += i3;
                        this.stream.write(str, i2, i3);
                    }
                    i2 = i;
                }
            } else if (Constant.LINEBR.has(charAt, "\u0000 ")) {
                int i4 = i - i2;
                this.column += i4;
                this.stream.write(str, i2, i4);
                if (charAt == 0) {
                    writeLineBreak(null);
                }
                i2 = i;
            }
            if (charAt != 0) {
                z2 = Constant.LINEBR.has(charAt);
                z4 = charAt == ' ';
            }
            i++;
        }
    }

    void writeLiteral(String str) throws IOException {
        String determineBlockHints = determineBlockHints(str);
        boolean z = true;
        writeIndicator("|" + determineBlockHints, true, false, false);
        if (determineBlockHints.length() > 0 && determineBlockHints.charAt(determineBlockHints.length() - 1) == '+') {
            this.openEnded = true;
        }
        if (!writeInlineComments()) {
            writeLineBreak(null);
        }
        int i = 0;
        int i2 = 0;
        while (i <= str.length()) {
            char charAt = i < str.length() ? str.charAt(i) : (char) 0;
            if (z) {
                if (charAt == 0 || Constant.LINEBR.hasNo(charAt)) {
                    for (char c : str.substring(i2, i).toCharArray()) {
                        if (c == '\n') {
                            writeLineBreak(null);
                        } else {
                            writeLineBreak(String.valueOf(c));
                        }
                    }
                    if (charAt != 0) {
                        writeIndent();
                    }
                    i2 = i;
                }
            } else if (charAt == 0 || Constant.LINEBR.has(charAt)) {
                this.stream.write(str, i2, i - i2);
                if (charAt == 0) {
                    writeLineBreak(null);
                }
                i2 = i;
            }
            if (charAt != 0) {
                z = Constant.LINEBR.has(charAt);
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void writePlain(java.lang.String r14, boolean r15) throws java.io.IOException {
        /*
            r13 = this;
            boolean r0 = r13.rootContext
            r1 = 1
            if (r0 == 0) goto L7
            r13.openEnded = r1
        L7:
            int r0 = r14.length()
            if (r0 != 0) goto Le
            return
        Le:
            boolean r0 = r13.whitespace
            if (r0 != 0) goto L1e
            int r0 = r13.column
            int r0 = r0 + r1
            r13.column = r0
            java.io.Writer r0 = r13.stream
            char[] r2 = org.yaml.snakeyaml.emitter.Emitter.SPACE
            r0.write(r2)
        L1e:
            r0 = 0
            r13.whitespace = r0
            r13.indention = r0
            r2 = r0
            r3 = r2
            r4 = r3
            r5 = r4
        L27:
            int r6 = r14.length()
            if (r2 > r6) goto Lc4
            int r6 = r14.length()
            if (r2 >= r6) goto L38
            char r6 = r14.charAt(r2)
            goto L39
        L38:
            r6 = r0
        L39:
            r7 = 32
            if (r3 == 0) goto L60
            if (r6 == r7) goto Lb3
            int r8 = r5 + 1
            if (r8 != r2) goto L53
            int r8 = r13.column
            int r9 = r13.bestWidth
            if (r8 <= r9) goto L53
            if (r15 == 0) goto L53
            r13.writeIndent()
            r13.whitespace = r0
            r13.indention = r0
            goto Lb2
        L53:
            int r8 = r2 - r5
            int r9 = r13.column
            int r9 = r9 + r8
            r13.column = r9
            java.io.Writer r9 = r13.stream
            r9.write(r14, r5, r8)
            goto Lb2
        L60:
            if (r4 == 0) goto L9c
            org.yaml.snakeyaml.scanner.Constant r8 = org.yaml.snakeyaml.scanner.Constant.LINEBR
            boolean r8 = r8.hasNo(r6)
            if (r8 == 0) goto Lb3
            char r8 = r14.charAt(r5)
            r9 = 0
            r10 = 10
            if (r8 != r10) goto L76
            r13.writeLineBreak(r9)
        L76:
            java.lang.String r5 = r14.substring(r5, r2)
            char[] r5 = r5.toCharArray()
            int r8 = r5.length
            r11 = r0
        L80:
            if (r11 >= r8) goto L94
            char r12 = r5[r11]
            if (r12 != r10) goto L8a
            r13.writeLineBreak(r9)
            goto L91
        L8a:
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r13.writeLineBreak(r12)
        L91:
            int r11 = r11 + 1
            goto L80
        L94:
            r13.writeIndent()
            r13.whitespace = r0
            r13.indention = r0
            goto Lb2
        L9c:
            org.yaml.snakeyaml.scanner.Constant r8 = org.yaml.snakeyaml.scanner.Constant.LINEBR
            java.lang.String r9 = "\u0000 "
            boolean r8 = r8.has(r6, r9)
            if (r8 == 0) goto Lb3
            int r8 = r2 - r5
            int r9 = r13.column
            int r9 = r9 + r8
            r13.column = r9
            java.io.Writer r9 = r13.stream
            r9.write(r14, r5, r8)
        Lb2:
            r5 = r2
        Lb3:
            if (r6 == 0) goto Lc0
            if (r6 != r7) goto Lb9
            r3 = r1
            goto Lba
        Lb9:
            r3 = r0
        Lba:
            org.yaml.snakeyaml.scanner.Constant r4 = org.yaml.snakeyaml.scanner.Constant.LINEBR
            boolean r4 = r4.has(r6)
        Lc0:
            int r2 = r2 + 1
            goto L27
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.emitter.Emitter.writePlain(java.lang.String, boolean):void");
    }
}
