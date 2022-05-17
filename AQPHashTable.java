import java.util.Random;

public class AQPHashTable extends OAHashTable {
	public ModHash h;

	public AQPHashTable(int m, long p) {
		super(m);
		this.h = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int index = (int) (((h.Hash(x) + Math.pow(-1,i)*i*i) % h.m)+h.m)% h.m;
		return index;
	}
}
