package com.episodeSix.EpisodeSixTest.utils;

import org.joda.time.DateTime;

public class Logger {

    private static final String DATEPATTERN = "MM-dd-yyyy HH:mm:ss ZZ";
    private static final String LOGTEMPLATE = "[%s %s] %s";

    public static void printInfo(String message){

        String logMessage = String.format(LOGTEMPLATE,"INFO",DateTime.now().toString(DATEPATTERN),message);
        System.out.println(logMessage);
    }
    public static void printError(String message) {
        String logMessage = String.format(LOGTEMPLATE,"ERROR",DateTime.now().toString(DATEPATTERN),message);
        System.out.println(logMessage);

    }
    public static void printWarning(String message) {
        String logMessage = String.format(LOGTEMPLATE,"WARNING",DateTime.now().toString(DATEPATTERN),message);
        System.out.println(logMessage);
    }
}