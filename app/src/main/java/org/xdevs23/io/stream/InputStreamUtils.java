package org.xdevs23.io.stream;

import org.xdevs23.debugUtils.StackTraceParser;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;

public class InputStreamUtils {

    public static String readToString(InputStream inputStream) {
        String readData = "";

        try {
            readData = IOUtils.toString(inputStream, "UTF-8");
        } catch(Exception ex) {
            StackTraceParser.logStackTrace(ex);
        }

        return readData;
    }

}
