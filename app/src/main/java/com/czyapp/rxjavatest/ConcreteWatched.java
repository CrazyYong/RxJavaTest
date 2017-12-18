package com.czyapp.rxjavatest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by czy on 2017/12/18.
 */

public class ConcreteWatched implements Watched{
private List<Watcher> list = new ArrayList<>();

    @Override
    public void addwatcher(Watcher watcher) {
       list.add(watcher);
    }

    @Override
    public void removewatcher(Watcher watcher) {
      list.remove(watcher);
    }

    @Override
    public void notifywatchers(String str) {
        for (Watcher watcher : list){
            watcher.update(str);
        }

    }
}
