package com.example.alexey.notes;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;

public class DataBase extends RealmObject {
    private static DataBase instance;

    public DataBase (){
    }

    public static DataBase getInstance(){
        if (null == instance){
            instance = new DataBase();
        }
        return instance;
    }

    public static void setInstance(DataBase dataBase) {
        instance = dataBase;
    }

    private RealmList<String> listDo = new RealmList<>();
    private RealmList<String> listDid = new RealmList<>();
    private RealmList<String> listbell = new RealmList<>();

    public RealmList<String> getListDo() {
        return listDo;
    }

    public void setListDo(RealmList<String> listDo) {
        this.listDo = listDo;
    }

    public RealmList<String> getListDid() {
        return listDid;
    }

    public void setListDid(RealmList<String> listDid) {
        this.listDid = listDid;
    }

    public RealmList<String> getListbell() {
        return listbell;
    }

    public void setListbell(RealmList<String> listbell) {
        this.listbell = listbell;
    }
}
