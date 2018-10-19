package com.nguyen.liem.weatherproblem;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

public class UserViewModel extends AndroidViewModel {

    private UserRepository repository;
    private LiveData<User> userLiveData;

    public UserViewModel(@NonNull Application application) {
        super(application);

        repository = new UserRepository(application);
        userLiveData = repository.getUserLiveData();
    }

    public void insert(User user) {
        repository.insert(user);
    }

    public void update(User user) {
        repository.update(user);
    }

    public void delete(User user) {
        repository.delete(user);
    }

    public void deleteall() {
        repository.deleteAll();
    }

    public LiveData<User> getUserLiveData() {
        return userLiveData;
    }

}
