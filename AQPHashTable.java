import java.util.Random;

public class AQPHashTable extends OAHashTable {
	public ModHash h;

	public AQPHashTable(int m, long p) {
		super(m);
		this.h = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int sign;
		if (i%2==0){
			sign=1;
		}
		else{
			sign=-1;
		}
		int index = (int) (((h.Hash(x) + sign*i*i) % h.m)+h.m)% h.m;
		return index;
	}
}
