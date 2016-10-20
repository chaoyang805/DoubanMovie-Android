package me.chaoyang805.doubanmovie.data.source.remote;

/**
 * Created by chaoyang805 on 16/10/20.
 */

public class DoubanServiceFactory {

    private static DoubanService sInstance = null;

    private static final Object obj = new Object();

    public static DoubanService getDoubanService() {
        if (sInstance == null) {
            synchronized (obj) {
                if (sInstance == null) {
                    sInstance = new DoubanAPI().getDoubanService();
                }
            }
        }
        return sInstance;
    }
}
