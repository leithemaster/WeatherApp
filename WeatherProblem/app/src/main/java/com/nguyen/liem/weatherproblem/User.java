package com.nguyen.liem.weatherproblem;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user_info")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String _city;
    private String _state;
    private String _location;
    private String _API;

    public User(String _city, String _state, String _location, String _API) {
        this._city = _city;
        this._state = _state;
        this._location = _location;
        this._API = _API;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return _city;
    }

    public String getState() {
        return _state;
    }

    public String getLocation() {
        return _location;
    }

    public String getAPI() {
        return _API;
    }
}
