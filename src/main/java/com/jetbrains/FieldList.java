package com.jetbrains;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SemenovNA on 10.08.2016.
 */
public class FieldList {

    private List<String> list;

    public FieldList(){
        list = new ArrayList<String>();
    }

    public void add(String ef){
        list.add(ef);
    }

    public void remove(String ef){
        list.remove(ef);
    }

    public int size(){
        return list.size();
    }

    public String get(int i){
        return list.get(i);
    }
}
