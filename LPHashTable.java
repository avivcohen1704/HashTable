import java.util.Random;

public class LPHashTable extends OAHashTable {
	public ModHash h;

	public LPHashTable(int m, long p) {
		super(m);
		this.h = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int index = (h.Hash(x) + i)% h.m;
		return index;
	}
	
}
