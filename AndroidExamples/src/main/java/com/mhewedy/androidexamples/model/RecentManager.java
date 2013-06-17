package com.mhewedy.androidexamples.model;

import java.util.HashSet;
import java.util.Set;

public class RecentManager {

    private static final RecentManager INSTANCE = new RecentManager();

    private Set<String> data = new HashSet<String>();

    private RecentManager() {
    }

    public static RecentManager getRecentManager() {
        return INSTANCE;
    }

    public void addRecent(String recent){
        data.add(recent);
    }

    public Set<String> getAllRecents(){
        return data;
    }

    public void clearRecents(){
        data.clear();
    }


}
