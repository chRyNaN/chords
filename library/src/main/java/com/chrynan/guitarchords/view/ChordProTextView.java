package com.chrynan.guitarchords.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;

import com.chrynan.guitarchords.chordpro.ChordPro;
import com.chrynan.guitarchords.chordpro.ChordTag;
import com.chrynan.guitarchords.chordpro.MetaTag;
import com.chrynan.guitarchords.chordpro.Tag;
import com.chrynan.guitarchords.span.LinkTouchMovementMethod;

import java.util.ArrayList;
import java.util.List;

/*
 * Copyright 2016 chRyNaN
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Created by chRyNaN on 2/14/2016. Displays ChordPro formatted Strings in a TextView where all chords
 * with known markings are ChordSpans.
 */
public class ChordProTextView extends TextView{
    private volatile Handler handler;
    private List<MetaTag> metaTags;
    private List<ChordTag> chordTags;

    public ChordProTextView(Context context){
        super(context);
        init(context, null);
    }

    public ChordProTextView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context, attrs);
    }

    public ChordProTextView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ChordProTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        setMovementMethod(LinkTouchMovementMethod.getInstance());
        handler = new Handler();
        metaTags = new ArrayList<>();
        chordTags = new ArrayList<>();
    }

    //Can't override TextView's setText() methods because they're final (terrible design).
    //So, this method should be used instead.
    public void setChordProText(final String text){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                metaTags = ChordPro.getMetaTags(text);
                chordTags = ChordPro.getChordTags(text);
                MetaTag defineTag;
                for(ChordTag tag : chordTags){
                    defineTag = ChordPro.getDefineTag(metaTags, tag.getChordName());
                    if(defineTag != null){
                        tag.setChord(new GuitarChordView.Chord(ChordPro.getChordFromDefineTag(defineTag)));
                    }
                }
                final SpannableStringBuilder sb = ChordPro.parseString(text);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        setText(sb);
                    }
                });
            }
        });
    }

    public List<MetaTag> getMetaTags(){
        return metaTags;
    }

    public List<ChordTag> getChordTags(){
        return chordTags;
    }

    public List<Tag> getTags(){
        List<Tag> tags = new ArrayList<>();
        tags.addAll(metaTags);
        tags.addAll(chordTags);
        return tags;
    }

}
