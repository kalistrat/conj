package com.jetbrains;

/**
 * Created by SemenovNA on 08.08.2016.
 */
public class BuAttach {

    String field_index;
    String field_rate;
    String field_user_create_sym;
    String field_user_owner_sym;


    public BuAttach(String ifi, String ifr, String ifu){
        this.field_index = ifi;
        this.field_rate = ifr;
        this.field_user_create_sym=ifu;
        this.field_user_owner_sym=ifu;
    }

    public void BuAttachChangeOwner(String eUsr){
        this.field_user_owner_sym = eUsr;
    }

}
