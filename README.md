#GuitarChords

![Screenshot](https://github.com/chRyNaN/GuitarChords/blob/master/app/src/main/res/drawable/screenshot.png)

An easily extensible and customizable native Android View to display guitar (and other stringed instruments) chords. 
Simple to use and beautifully designed.

Example usage:

```XML
<TextView
    android:id="@+id/chord_title"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_gravity="center_horizontal"
    android:gravity="center_horizontal"
    android:layout_margin="16dp"
    android:textSize="32sp"
    android:textColor="@color/black"/>

<com.chrynan.guitarchords.view.GuitarChordView
    android:id="@+id/chord_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

```Java
chordView = (GuitarChordView) findViewById(R.id.chord_view);
chordView.setTitle("E Major");
//Fret, String, Finger
chordView.addNote(1, 3, 1);
chordView.addNote(2, 4, 3);
chordView.addNote(2, 5, 2);
chordTitle = (TextView) findViewById(R.id.chord_title);
chordTitle.setText(chordView.getTitle());
```

Plenty of built in customization options. For instance:

```XML
<com.chrynan.guitarchords.view.GuitarChordView
    xmlns:chordView="http://schemas.android.com/apk/res-auto"
    android:id="@+id/chord_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    chordView:noteColor="@color/primary"
    chordView:noteNumberColor="@color/light_primary"/>
```

```Java
chordView.setNoteColor(getColor(R.color.primary));
chordView.setNoteNumberColor(getColor(R.color.light_primary));
```
