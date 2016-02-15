package com.chrynan.guitarchords.chordpro;

/**
 * Created by chRyNaN on 2/15/2016. Represents a ChordPro tag, either a delimiter or a chord tag. Subclasses are more specific
 * for the type of tag.
 */
public class Tag<K, V> {
    public static final String DELIMITER = ":";
    public static final String MULTIPLE_ITEM_SEPARATOR = ";";

    private K key;
    private V value;

    public Tag(){

    }

    public Tag(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }

    public void setKey(K key){
        this.key = key;
    }

    public V getValue(){
        return value;
    }

    public void setValue(V value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag<?, ?> tag = (Tag<?, ?>) o;

        if (key != null ? !key.equals(tag.key) : tag.key != null) return false;
        return !(value != null ? !value.equals(tag.value) : tag.value != null);

    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    public String toTagString(){
        return key + DELIMITER + value;
    }

}
