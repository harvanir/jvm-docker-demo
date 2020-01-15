import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

public class MemoryEater {
    public static void main(String[] args) {
        growthMemory(args);

        System.gc(); // NOSONAR
        System.out.println("Exit...");
        printMemory(0);
        sleep(5000);
    }

    private static void growthMemory(String[] args) {
        sleep(5000);
        int maxIteration = 1000;

        try {
            maxIteration = Integer.parseInt(args[1]);
        } catch (Exception e) {
        }

        List<byte[]> v = new ArrayList<>();
        int counter = 0;
        while (v.size() <= 1000) {
            byte[] b = new byte[1048592];
            v.add(b);

            if (args != null && args.length > 0) {
                Object obj = args[0];
                if (obj != null) {
                    sleep(Integer.parseInt(obj.toString()));
                }
            }

            printMemory(counter);

            counter++;
        }
    }

    private static void printMemory(long counter) {
        MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapUsage = mbean.getHeapMemoryUsage();
        Runtime rt = Runtime.getRuntime();

        long heapMax = heapUsage.getMax();
        long heapSize = heapUsage.getCommitted();
        long freeMemory = rt.freeMemory();
        long heapUsed = heapUsage.getUsed();

        System.out.println(String.format(
                "[counter: %s], [heap-max: %s], [heap-size: %s], [heap-used: %s], [heap-free: %s]",
                counter, heapMax, heapSize, heapUsed, freeMemory)
        );
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
