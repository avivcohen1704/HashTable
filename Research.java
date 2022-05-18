import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Research {


    public static void main(String[]args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException, IHashTable.KeyDoesntExistException {
        int q = 6571;
        Set<Integer> set1 = new HashSet<>();
        Set<Double> set2 = new HashSet<>();
        for (int i = 0; i < q; i++) {
            set1.add((i * i) % q);
            set2.add((double) ((Math.pow(-1, i) * (i * i)) % q));
        }

        System.out.println("### Q3 - a ###");
        System.out.println("Q1 SIZE: " + set1.size());
        System.out.println("Q2 SIZE: " + set2.size());

        int CNTexceptions1 = 0;

        for (int i = 0; i < 100; i++) {
            try {
                IHashTable I = new QPHashTable(q, 1000000007);
                for (int j = 0; j < q; j++) {
                    Random r = new Random();
                    int b = r.nextInt(100);
                    int a = 100 * j + b;
                    I.Insert(new HashTableElement(a, a));
                }
            } catch (IHashTable.TableIsFullException e) {
                CNTexceptions1++;
            }
        }
        System.out.println("");
        System.out.println("### Q3 - b ###");
        System.out.println("NUM of execptions QPHashTable: " + CNTexceptions1);

        int CNTexceptions2 = 0;

        for (int i = 0; i < 100; i++) {
            try {
                IHashTable I = new AQPHashTable(q, 1000000007);
                for (int j = 0; j < q; j++) {
                    Random r = new Random();
                    int b = r.nextInt(100);
                    int a = 100 * j + b;
                    I.Insert(new HashTableElement(a, a));
                }
            } catch (IHashTable.TableIsFullException e) {
                CNTexceptions2++;
            }
        }

        System.out.println("NUM of execptions AQPHashTable: " + CNTexceptions2);

        System.out.println("");
        System.out.println("### Q4 - a ###");

        int m = 10000019;
        int p = 1000000007;
        int n = (m-1) / 2;

        double start0 = System.currentTimeMillis();
        for (int i = 0; i<10; i++) {
            IHashTable LPHashTable = new LPHashTable(m, p);
            for (int j = 0; j < n; j++) {
                Random r = new Random();
                int b = r.nextInt(100);
                int a = 100 * j + b;
                LPHashTable.Insert(new HashTableElement(a, a));
            }
        }
        double end0 = System.currentTimeMillis();
        double elapsedTime0 = end0 - start0;
        elapsedTime0 = elapsedTime0 / 10000;
        System.out.println("AVG for LPHashTable: " + elapsedTime0 + " seconds");

        double start1 = System.currentTimeMillis();
        for (int i = 0; i<10; i++) {
            IHashTable QPHashTable = new QPHashTable(m, p);
            for (int j = 0; j < n; j++) {
                Random r = new Random();
                int b = r.nextInt(100);
                int a = 100 * j + b;
                QPHashTable.Insert(new HashTableElement(a, a));
            }
        }
        double end1 = System.currentTimeMillis();
        double elapsedTime1 = end1 - start1;
        elapsedTime1 = elapsedTime1 / 10000;
        System.out.println("AVG for QPHashTable: " + elapsedTime1 + " seconds");

        double start2 = System.currentTimeMillis();
        for (int i = 0; i<10; i++) {
            IHashTable AQPHashTable = new AQPHashTable(m, p);
            for (int j = 0; j < n; j++) {
                Random r = new Random();
                int b = r.nextInt(100);
                int a = 100 * j + b;
                AQPHashTable.Insert(new HashTableElement(a, a));
            }
        }
        double end2 = System.currentTimeMillis();
        double elapsedTime2 = end2 - start2;
        elapsedTime2 = elapsedTime2 / 10000;
        System.out.println("AVG for AQPHashTable: " + elapsedTime2 + " seconds");

        try {

            double start3 = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                IHashTable DoubleHashTable = new DoubleHashTable(m, p);
                for (int j = 0; j < n; j++) {
                    Random r = new Random();
                    int b = r.nextInt(100);
                    int a = 100 * j + b;
                    DoubleHashTable.Insert(new HashTableElement(a, a));
                }
            }
            double end3 = System.currentTimeMillis();
            double elapsedTime3 = end3 - start3;
            elapsedTime3 = elapsedTime3 / 10000;
            System.out.println("AVG for DoubleHashTable: " + elapsedTime3 + " seconds");
        }
        catch (IHashTable.TableIsFullException E) {

        }
        System.out.println("");
        System.out.println("### Q4 - b ###");

        int n11 = (19 * m) / 20;

        double start10 = System.currentTimeMillis();
        for (int i = 0; i<5; i++) {
            IHashTable LPHashTable = new LPHashTable(m, p);
            for (int j = 0; j < n11; j++) {
                Random r = new Random();
                int b = r.nextInt(100);
                int a = 100 * j + b;
                LPHashTable.Insert(new HashTableElement(a, a));
            }
        }
        double end10 = System.currentTimeMillis();
        double elapsedTime10 = end10 - start10;
        elapsedTime10 = elapsedTime10 / 5000;
        System.out.println("AVG for LPHashTable: " + elapsedTime10 + " seconds");

        double start12 = System.currentTimeMillis();
        for (int i = 0; i<5; i++) {
            IHashTable AQPHashTable = new AQPHashTable(m, p);
            for (int j = 0; j < n11; j++) {
                Random r = new Random();
                int b = r.nextInt(100);
                int a = 100 * j + b;
                AQPHashTable.Insert(new HashTableElement(a, a));
            }
        }
        double end12 = System.currentTimeMillis();
        double elapsedTime12 = end12 - start12;
        elapsedTime12 = elapsedTime12 / 5000;
        System.out.println("AVG for AQPHashTable: " + elapsedTime12 + " seconds");

        try {
            double start13 = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                IHashTable DoubleHashTable = new DoubleHashTable(m, p);
                for (int j = 0; j < n11; j++) {
                    Random r = new Random();
                    int b = r.nextInt(100);
                    int a = 100 * j + b;
                    DoubleHashTable.Insert(new HashTableElement(a, a));
                }
            }
            double end13 = System.currentTimeMillis();
            double elapsedTime13 = end13 - start13;
            elapsedTime13 = elapsedTime13 / 5000;
            System.out.println("AVG for DoubleHashTable: " + elapsedTime13 + " seconds");
        }
        catch (IHashTable.TableIsFullException E) {

        }

        System.out.println("");
        System.out.println("### Q5 ###");

        IHashTable DoubleHashTable1 = new DoubleHashTable(m, p);
        int n0 = (m - 1) / 2;
        double elapsedTime101 = 0;
        double start = System.currentTimeMillis();
        double start100 = 0;
        for (int i = 0; i < 6; i++) {
            if (i == 3) {
                double end = System.currentTimeMillis();
                elapsedTime101 = end - start;
                elapsedTime101 = elapsedTime101 / 1000;
                start100 = System.currentTimeMillis();
            }
            for (int j = 0; j < n0; j++) {
                Random r = new Random();
                int b = r.nextInt(100);
                int a = 100 * j + b;
                DoubleHashTable1.Insert(new HashTableElement(a, a));
                DoubleHashTable1.Delete(a);
            }
        }
        double end100 = System.currentTimeMillis();
        double elapsedTime100 = (end100 - start100) / 1000;
        System.out.println("First 3 iterations: " + elapsedTime101 + " seconds");
        System.out.println("Last 3 iterations: " + elapsedTime100 + " seconds");
    }

}
