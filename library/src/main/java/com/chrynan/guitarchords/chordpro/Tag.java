package com.chrynan.guitarchords.chordpro;

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
