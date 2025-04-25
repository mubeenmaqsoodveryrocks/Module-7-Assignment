package com.example.module7assignment;

import java.util.concurrent.locks.ReentrantLock;
import java.util.prefs.Preferences;

public class YourModel {

    private static final YourModel instance = new YourModel();
    private final ReentrantLock lock = new ReentrantLock();
    private String username;

    private YourModel() {}

    public static YourModel getInstance() {
        return instance;
    }

    public void setUsername(String username) {
        lock.lock();
        try {
            this.username = username;
        } finally {
            lock.unlock();
        }
    }

    public static int fromCSV(String line) {
        return 0;
    }

    public int toCSV() {
        return 0;
    }
    Preferences prefs = Preferences.userNodeForPackage(getClass());


}
