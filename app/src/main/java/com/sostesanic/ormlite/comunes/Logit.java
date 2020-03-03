package com.sostesanic.ormlite.comunes;

import android.os.Environment;
import android.os.SystemClock;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Logit {
    private static String fileName = "Log";
    private static Logit log;
    private PrintStream printStr;
    private GregorianCalendar g = new GregorianCalendar();
    private Date date = new Date();
    private String programName = "";

    public static Logit getInstance(String fileName) {
        if (log == null)
            log = new Logit();
        log.setFileName(fileName);
        return log;
    }

    public static String stringStackTrace(Exception exception) {
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        exception.printStackTrace(printWriter);
        return writer.toString();
    }

    private PrintStream createLogFile() {
        Calendar calendar = Calendar.getInstance();
        g.setTime(date);
        String name = fileName + "_" + calendar.get(Calendar.YEAR) + (calendar.get(Calendar.MONTH) + 1 < 10 ? "0" : "")
                + (calendar.get(Calendar.MONTH) + 1) + (calendar.get(Calendar.DATE) < 10 ? "0" : "")
                + calendar.get(Calendar.DATE) + ".log";
        File file = new File(Environment.getExternalStorageDirectory(), name);
        FileOutputStream out;
        PrintStream ps = null;

        try {
            out = new FileOutputStream(file, true);
            ps = new PrintStream(out);
            printStr = ps;
        } catch (Exception ignored) { }
        return ps;
    }

    public void error(String text) {
        if (printStr == null)
            printStr = createLogFile();
        String programName = "";
        printStr.println("Hora: " + Fechas.fechahoy() + " " + SystemClock.currentThreadTimeMillis()
                + " -- " + programName + " -- [ERR] : " + text);
        printStr.flush();
    }

    public void setFileName(String fileName) {
        Logit.fileName = fileName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public static Logit getInstance() {
        if (log == null)
            log = new Logit();
        return log;
    }

    public void write(String text) {
        if (printStr == null) {
            printStr = createLogFile();
        }
        printStr.println("Hora: " + Fechas.fechahoy() + " "
                + SystemClock.currentThreadTimeMillis() + " -- " + programName + " -- [MSG] : " + text);
        printStr.flush();
    }
}
