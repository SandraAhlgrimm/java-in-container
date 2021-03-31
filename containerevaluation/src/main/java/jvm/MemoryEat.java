package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Eat all the available Memory
 *
 */
public class MemoryEat {
    public static void main(String[] args) {
        List l = new ArrayList<>();
        while (true) {
            byte b[] = new byte[1048576];
            l.add(b);
            Runtime rt = Runtime.getRuntime();
            System.out.println( "free memory: " + rt.freeMemory() );
        }
    }
}