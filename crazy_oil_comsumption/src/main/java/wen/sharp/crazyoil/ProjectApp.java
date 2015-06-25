package wen.sharp.crazyoil;

import android.app.Application;

import wen.sharp.common.DatabaseManager;

/**
 * Created by code89757 on 2015/6/12.
 */
public class ProjectApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseOperHelper helper = new DatabaseOperHelper(getApplicationContext(), "data", null, 1);
        DatabaseManager manager = new DatabaseManager(helper);
        DatabaseManager.setManager(manager);
    }
}
