import java.util.Random;

public class ModHash {
	public int a;
	public int b;
	public int m;
	public long p;

	public ModHash(int m, long p, int a, int b){
		this.a=a;
		this.b=b;
		this.m =m;
		this.p =p;

	}

	public static ModHash GetFunc(int m, long p){
		Random rand = new Random();
		int a = 1 + rand.nextInt((int) (p-2));
		int b = rand.nextInt((int) (p-1));
		return new ModHash(m,p,a,b);
	}
	
	public int Hash(long key) {

		int i = (int) (((a*key + b)%p)%m);
		return i;
	}
}
