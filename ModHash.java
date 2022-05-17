import java.util.Random;

public class ModHash {
	public int a;
	public int b;
	public int m;
	public long p;

	public ModHash(int m, long p, int a, int b){
		this.a =0 ;
		this.b =0;
		this.m =0;
		this.p =0;

	}

	public static ModHash GetFunc(int m, long p){
		Random rand = new Random();
		int a = 1 + rand.nextInt((int) (p-2));
		int b = rand.nextInt((int) (p-1));
		return new ModHash(m,p,a,b);
	}
	
	public int Hash(long key) {
		ModHash h = GetFunc(this.m, this.p);

		int i = (int) (((this.a*key + this.b)%this.m)%this.p);
		return i;
	}
}
