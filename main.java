import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class main {
    public static void main(String args[]) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {
        int m = 10000019;
        int p = 1000000007;
        int m2 = (int)Math.floor(m/2);
        int exception1 =0;
        int exception2 =0;
        int exception3 =0;
        DoubleHashTable Doubletable = new DoubleHashTable(m, p);
        String[] times = new String[6];
        for(int j = 0 ; j < 6; j++){
            long startTime = System.currentTimeMillis();
            HashTableElement[] Ai = new HashTableElement[m2];
            //###################### Making list Ai #############
            for(int i =0; i< m2 ; i++){
                int b = new Random().nextInt(100);
                int a = 100 * i + b;
                Ai[i] = new HashTableElement(a, a);
            }
            //###################### Inseting Ai #############
            for(HashTableElement element : Ai) {
                try {
                    Doubletable.Insert(element);
                } catch (IHashTable.KeyAlreadyExistsException ex) {
                    exception1 += 1;
                }
                catch (IHashTable.TableIsFullException ex1) {
                    exception2 += 1;
                }
                catch (ArrayIndexOutOfBoundsException ex1) {
                    System.out.println(element.GetKey() + " " + element.GetValue());
                }
            }
            //###################### Deleting Ai #############
            for(HashTableElement element : Ai){
                try {
                    Doubletable.Delete(element.GetKey());
                } catch (Exception ex) {
                    exception3 += 1;
                }
            }
            long stopTime = System.currentTimeMillis();
            String time = (stopTime-startTime)/1000 + "." + (stopTime-startTime)%1000;
            times[j] = time;
            System.out.println(exception1 + "  " + exception2);
        }
        System.out.println(Arrays.toString(times));
    }
}