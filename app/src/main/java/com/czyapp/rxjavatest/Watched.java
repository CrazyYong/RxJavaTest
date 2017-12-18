package com.czyapp.rxjavatest;

/**
 * Created by czy on 2017/12/18.
 */

public interface Watched {

    public void addwatcher(Watcher watcher);

    public void removewatcher(Watcher watcher);

    public void notifywatchers(String str);
}
