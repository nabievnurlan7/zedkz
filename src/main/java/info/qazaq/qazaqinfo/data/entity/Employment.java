package info.qazaq.qazaqinfo.data.entity;

import io.realm.RealmObject;

/**
 * Created by nurik on 02.01.2018.
 */

public class Employment extends RealmObject
{

    String name;
    String position;

    public Employment() {
    }

    public Employment(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
