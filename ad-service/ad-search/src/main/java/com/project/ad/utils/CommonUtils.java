package com.project.ad.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

@Slf4j
public class CommonUtils {

    public static <K, V> V getOrCreate(K key, Map<K, V> map,
                                       Supplier<V> factory) {
        return map.computeIfAbsent(key, k -> factory.get());
    }

    public static String stringConcat(String... args) {
        StringBuilder result = new StringBuilder();
        for (String arg : args) {
            result.append(arg);
            result.append("-");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    // Fri Mar 24 17:45:14 PDT 2023
    public static Date parseStringDate(String dateString) {
        try {
            DateFormat dateFormat = new SimpleDateFormat(
                    "EEE MMM dd HH:mm: ss zzz yyyy",
                    Locale.US
            );
            return DateUtils.addHours(
                    dateFormat.parse(dateString),
                    +7
            );
        } catch (ParseException e) {
            log.error("parseStringDate Error: {}");
            return null;
        }
    }
}
