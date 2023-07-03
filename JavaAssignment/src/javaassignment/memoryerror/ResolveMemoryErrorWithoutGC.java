
package javaassignment.memoryerror;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ResolveMemoryErrorWithoutGC {

    private static final String APPENDING_VALUE = "Record : ";
    private static final String STORE_FILE_PATH = "C:\\Store\\StoreFile";
    private static final String EXTENTION = ".txt";

    public static void main(String[] args) {
        LocalTime start = LocalTime.now();
        try {

            System.out.println(start.toString());

            StringBuffer sb = new StringBuffer();
            int set = 0;
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                sb.append(APPENDING_VALUE + i);
                System.out.println(sb.toString());
                if (i % 10000 == 0) {
                    set++;
                    writeToFile(sb, set);
                    sb.delete(0, sb.length() - 1);

                }
            }
        } catch (OutOfMemoryError error) {
            error.printStackTrace();
        }
        LocalTime end = LocalTime.now();
        System.out.println(end.toString());
        System.out.println("Time Difference is :" + (end.getSecond() - start.getSecond()));

    }

    private static void writeToFile(StringBuffer sb, int set) {
        File f = new File(STORE_FILE_PATH + set + EXTENTION);
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(sb.toString());
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(ResolveMemoryErrorWithoutGC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
