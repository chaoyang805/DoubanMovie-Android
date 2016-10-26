package me.chaoyang805.doubanmovie.utils;

import java.util.List;

/**
 * Created by chaoyang805 on 16/10/16.
 */

public class StringUtils {

    /**
     * combine strings of a list to a single string using glueString, just like implode func in php.
     * @param list list to combine
     * @param glueString using glueString to combine the list*
     * @param <T>
     * @return a single string
     */
    public static <T> String combinedString(List<T> list, String glueString) {
        StringBuilder sb = new StringBuilder();

        for (T item :
            list) {
            sb.append(item);
            sb.append(glueString);
        }
        return sb.delete(sb.length() - glueString.length(),sb.length()).toString();
    }
}
