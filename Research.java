import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Research {


    public static void main(String[]args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {
        int q = 6571;
        Set<Integer> set1 = new HashSet<>();
        Set<Double> set2 = new HashSet<>();
        for (int i=0; i < q; i++) {
            set1.add((i*i)%q);
            set2.add((double) ((Math.pow(-1,i)*(i*i))%q));
        }
        System.out.println("Q1 SIZE: " + set1.size());
        System.out.println("Q2 SIZE: " + set2.size());

        int CNTexceptions1 = 0;

        for (int i=0; i < 100; i++) {
            try{
                IHashTable I = new QPHashTable(q, 1000000007);
                for (int j = 0; j < q; j++) {
                    Random r = new Random();
                    int b = r.nextInt(100);
                    int a = 100 * j + b;
                    I.Insert(new HashTableElement(a, a));
                }
        }
            catch (IHashTable.TableIsFullException e){
            CNTexceptions1++;
        }
        }

        System.out.println("NUM of execptions QPHashTable: " + CNTexceptions1);

        int CNTexceptions2 = 0;

        for (int i=0; i < 100; i++) {
            try{
                IHashTable I = new AQPHashTable(q, 1000000007);
                for (int j = 0; j < q; j++) {
                    Random r = new Random();
                    int b = r.nextInt(100);
                    int a = 100 * j + b;
                    I.Insert(new HashTableElement(a, a));
                }
            }
            catch (IHashTable.TableIsFullException e){
                CNTexceptions2++;
            }
        }

        System.out.println("NUM of execptions AQPHashTable: " + CNTexceptions2);
    }
}
