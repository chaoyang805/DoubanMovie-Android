package me.chaoyang805.doubanmovie.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;

/**
 * Created by chaoyang805 on 16/10/16.
 */

public class ActivityUtils extends Object {

    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment,
                                             @IdRes int contentId) {
        fragmentManager.beginTransaction().addToBackStack("HomeActivity").add(contentId, fragment).commit();
    }

}
