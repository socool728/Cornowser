package org.xdevs23.management.config;

import org.xdevs23.debugutils.Logging;

public class SharedPreferenceArray {

    public static String getPreferenceString(String[] array) {
        if(array == null)     return "";
        if(array.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for ( String s : array) {
            if(s == null) {
                Logging.logd("Warning: something is wrong... a string is null?!");
                throw new NullPointerException("You can't use nulled strings here.");
            }
            String aps = s;
            if(s.contains(":")) aps = s.replace(":", "::");
            if(s.contains("|")) aps = aps.replace("|", "||");
            sb.append(aps).append("|:|");
        }
        sb.delete(sb.length() - 3, sb.length());
        return sb.toString();
    }

    public static String[] getStringArray(String preferenceString) {
        if(preferenceString.isEmpty()) return null;
        String[] array = preferenceString.split("([|][:][|])");
        for ( int i = 0; i < array.length; i++ ) {
            String aps = array[i];
            if(aps.contains(":")) aps = aps.replace("::", ":");
            if(aps.contains("|")) aps = aps.replace("||", "|");
            array[i] = aps;
        }
        return array;
    }

}
