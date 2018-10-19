package com.nguyen.liem.weatherproblem;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

public class UserRepository {

    private UserDao userDao;
    private LiveData<User> userLiveData;

    public UserRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        userDao = database.userDao();
        userLiveData = userDao.getAllUserInfo();
    }

    public void insert(User user) {
        new InsertUserAsynTask(userDao).execute(user);
    }

    public void update(User user) {
        new UpdateUserAsynTask(userDao).execute(user);
    }

    public void delete(User user) {
        new DeleteUserAsynTask(userDao).execute(user);
    }

    public void deleteAll() {
        new DeleteAllUserAsynTask(userDao).execute();
    }

    public LiveData<User> getUserLiveData() {
        return userLiveData;
    }

    private static class InsertUserAsynTask extends AsyncTask< User, Void, Void> {

        private UserDao userDao;

        private InsertUserAsynTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }

    private static class UpdateUserAsynTask extends AsyncTask< User, Void, Void> {

        private UserDao userDao;

        private UpdateUserAsynTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.update(users[0]);
            return null;
        }
    }

    private static class DeleteUserAsynTask extends AsyncTask< User, Void, Void> {

        private UserDao userDao;

        private DeleteUserAsynTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.delete(users[0]);
            return null;
        }
    }

    private static class DeleteAllUserAsynTask extends AsyncTask< Void, Void, Void> {

        private UserDao userDao;

        private DeleteAllUserAsynTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(Void... Voids) {
            userDao.deleteAllData();
            return null;
        }
    }

}
