package com.chrynan.guitarchords.chordpro;

/**
 * Created by chRyNaN on 2/15/2016. References: http://www.onsongapp.com/docs/features/formats/chordpro/
 */
public class MetaTag extends Tag<String, String>{
    public static final int TYPE_METADATA = 0;
    public static final int TYPE_INLINE = 1;
    public static final int TYPE_FORMATTING = 2;
    public static final int TYPE_DEFAULT = 3;

    public static final String BASE_FRET = "base-fret";
    public static final String FRETS = "frets";
    public static final String FINGERS = "fingers";
    public static final String KEY = "key";

    public static final String[] METADATA_TAGS = new String[]{Metadata.TITLE, Metadata.T, Metadata.SUBTITLE, Metadata.ST,
        Metadata.SU, Metadata.ALBUM, Metadata.ARTIST, Metadata.A, Metadata.AUTHOR, Metadata.KEY, Metadata.K, Metadata.CAPO,
        Metadata.TEMPO, Metadata.TIME, Metadata.DURATION, Metadata.BOOK, Metadata.NUMBER, Metadata.FLOW, Metadata.MIDI,
        Metadata.MIDI_INDEX, Metadata.PITCH, Metadata.KEYWORDS, Metadata.TOPIC, Metadata.COPYRIGHT, Metadata.FOOTER,
        Metadata.CCLI, Metadata.RESTRICTIONS};

    public static final String[] INLINE_TAGS = new String[]{Inline.DEFINE, Inline.COMMENT, Inline.C, Inline.COMMENT_BOLD,
        Inline.CB, Inline.COMMENT_ITALIC, Inline.CI, Inline.GUITAR_COMMENT, Inline.GC, Inline.START_OF_BRIDGE, Inline.SOB,
        Inline.END_OF_BRIDGE, Inline.EOB, Inline.START_OF_CHORUS, Inline.SOC, Inline.END_OF_CHORUS, Inline.EOC,
        Inline.START_OF_TAB, Inline.SOT, Inline.END_OF_TAB, Inline.EOT, Inline.NEW_PAGE, Inline.NP,
        Inline.NEW_PHYSICAL_PAGE, Inline.NPP};

    public static final String[] FORMATTING_TAGS = new String[]{Formatting.TEXT_SIZE, Formatting.TEXT_FONT, Formatting.CHORD_SIZE,
        Formatting.CHORD_FONT};


    public static class Metadata{
        /*
         * The title of the song.
         */
        public static final String TITLE = "title";
        public static final String T = "t";
        /*
         * The artist name or any other byline information.
         * You can specify multiple artists by separating names with a semi-colon. - Kim Walker-Smith; Chris Quilala
         */
        public static final String SUBTITLE = "subtitle";
        public static final String ST = "st";
        public static final String SU = "su";
        /*
         * The name of the album where the song is located.
         */
        public static final String ALBUM = "album";
        /*
         * The artist name or any other byline information.
         * You can specify multiple artists by separating names with a semi-colon. - Kim Walker-Smith; Chris Quilala
         */
        public static final String ARTIST = "artist";
        public static final String A = "a";
        /*
         * The name of the person who created the chord chart.
         * This is displayed at the bottom of the chord chart and in lyrics projection.
         */
        public static final String AUTHOR = "author";
        /*
         * The key of the song written as a key with enharmonic preference and an
         * optional "m" to indicate minor. - alphabetic, e.g. Bb or Em
         */
        public static final String KEY = "key";
        public static final String K = "k";
        /*
         * The capo to set as number of frets - numeric
         */
        public static final String CAPO = "capo";
        /*
         * The beats per minute (BPM) - numeric
         */
        public static final String TEMPO = "tempo";
        /*
         * The time signature - numeric beat over bar e.g. 3/4
         */
        public static final String TIME = "time";
        /*
         * The song length for autoscroll - seconds or mm:ss
         */
        public static final String DURATION = "duration";
        /*
         * The name of the book or books to place the song into.
         * This is a comma-delimited list of book names into which the song will be placed.
         * If the book does not exist, it will be automatically created.
         */
        public static final String BOOK = "book";
        /*
         * The number of the song - numeric, use for hymns, years, etc. You can sort songs by the number for reference.
         */
        public static final String NUMBER = "number";
        /*
         * The arrangement of sections - list of section labels. See Flow for details on arranging the flow of a song.
         */
        public static final String FLOW = "flow";
        /*
         * The MIDI commands to send when the song is viewed.
         */
        public static final String MIDI = "midi";
        /*
         * The MIDI commands that will trigger this song to be opened in the Song Viewer.
         */
        public static final String MIDI_INDEX = "midi-index";
        /*
         * The notes to play when using the Pitch Pipe feature.
         */
        public static final String PITCH = "pitch";
        /*
         * The list of tags to use with topic search. See Topics for more information on browsing by topic.
         */
        public static final String KEYWORDS = "keywords";
        public static final String TOPIC = "topic";
        /*
         * Specifies copyright footer text to appear at the bottom of the page or lyrics projection.
         */
        public static final String COPYRIGHT = "copyright";
        public static final String FOOTER = "footer";
        /*
         * The CCLI number of the song.
         */
        public static final String CCLI = "ccli";
        /*
         * The rights management for the song's comma-delimited list of restrictions.
         */
        public static final String RESTRICTIONS = "restrictions";
    }


    public static class Inline{
        /*
         * is used to define custom chord diagrams.
         */
        public static final String DEFINE = "define";
        /*
         * Defines a comment and appears as a musical instruction.
         */
        public static final String COMMENT = "comment";
        public static final String C = "c";
        /*
         * Defines text to appear in bold.
         */
        public static final String COMMENT_BOLD = "comment_bold";
        public static final String CB = "cb";
        /*
         * Defines text to appear as italic.
         */
        public static final String COMMENT_ITALIC = "comment_italic";
        public static final String CI = "ci";
        /*
         * Defines a comment that appears as a musical instruction.
         */
        public static final String GUITAR_COMMENT = "guitar_comment";
        public static final String GC = "gc";
        /*
         * Declares the start of a bridge section.
         */
        public static final String START_OF_BRIDGE = "start_of_bridge";
        public static final String SOB = "sob";
        /*
         * Declares the end of a bridge section.
         */
        public static final String END_OF_BRIDGE = "end_of_bridge";
        public static final String EOB = "eob";
        /*
         * Declares the start of a chorus section.
         */
        public static final String START_OF_CHORUS = "start_of_chorus";
        public static final String SOC = "soc";
        /*
         * Declares the end of a chorus section.
         */
        public static final String END_OF_CHORUS = "end_of_chorus";
        public static final String EOC = "eoc";
        /*
         * Declares the start of tablature which OnSong renders in a monospaced font.
         */
        public static final String START_OF_TAB = "start_of_tab";
        public static final String SOT = "sot";
        /*
         * Declares the end of a tablature section.
         */
        public static final String END_OF_TAB = "end_of_tab";
        public static final String EOT = "eot";
        /*
         * This is used to declare a new page.
         */
        public static final String NEW_PAGE = "new_page";
        public static final String NP = "np";
        /*
         * This is used to declare a new page.
         */
        public static final String NEW_PHYSICAL_PAGE = "new_physical_page";
        public static final String NPP = "npp";
    }


    public static class Formatting{
        /*
         * Defines the size of the lyrics as a numeric value in points.
         */
        public static final String TEXT_SIZE = "textsize";
        /*
         * Defines the name of the font to use for lyrics. Must be supported on the platform.
         */
        public static final String TEXT_FONT = "textfont";
        /*
         * Defines the size of the chords as a numeric value in points.
         */
        public static final String CHORD_SIZE = "chordsize";
        /*
         * Defines the name of the font to use for chords. Must be supported on the platform.
         */
        public static final String CHORD_FONT = "chordfont";
    }


    private int type;

    public MetaTag(){
        super();
        setType();
    }

    public MetaTag(String key, String value){
        super(key, value);
        setType();
    }

    public MetaTag(String tagString){
        int i = tagString.indexOf(DELIMITER);
        if(i == -1){
            setKey(tagString);
            setValue(null);
        }else{
            setKey(tagString.substring(0, i));
            setValue(tagString.substring(i + 1, tagString.length()));
        }
        setType();
    }

    private void setType(){
        if(isDefaultMetadataTag(getKey())){
            this.type = TYPE_METADATA;
        }else if(isDefaultInlineTag(getKey())){
            this.type = TYPE_INLINE;
        }else if(isDefaultFormattingTag(getKey())){
            this.type = TYPE_FORMATTING;
        }else{
            this.type = TYPE_DEFAULT;
        }
    }

    public static boolean isDefaultMetadataTag(String tag){
        if(tag != null) {
            for (int i = 0; i < METADATA_TAGS.length; i++) {
                if (tag.toLowerCase().equals(METADATA_TAGS[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isDefaultInlineTag(String tag){
        if(tag != null) {
            for (int i = 0; i < INLINE_TAGS.length; i++) {
                if (tag.toLowerCase().equals(METADATA_TAGS[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isDefaultFormattingTag(String tag){
        if(tag != null) {
            for (int i = 0; i < FORMATTING_TAGS.length; i++) {
                if (tag.toLowerCase().equals(METADATA_TAGS[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTotalLength(){
        //Gets the total length including the starting and ending brackets and the delimiter
        String k = getKey();
        String v = getValue();
        if(k != null && v != null){
            return 3 + k.length() + v.length();
        }else if(k != null){
            return 2 + k.length();
        }else if(v != null){
            return 2 + v.length();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "MetaTag{" +
                "type=" + type +
                "key=" + getKey() +
                "value=" + getValue() +
                '}';
    }

    @Override
    public String toTagString(){
        String k = getKey();
        String v = getValue();
        if(k != null && v != null) {
            return "{" + k.toString() + DELIMITER + v.toString() + "}";
        }else if(k != null){
            return "{" + k.toString() + "}";
        }else if(v != null){
            return "{" + v.toString() + "}";
        }else{
            return this.toString();
        }
    }

}
