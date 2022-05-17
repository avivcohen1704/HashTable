import java.util.Random;

public class QPHashTable extends OAHashTable {
	public ModHash h;

	public QPHashTable(int m, long p) {
		super(m);
		this.h = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int index = ((h.Hash(x)+i*i)% h.m);
		return index;
	}
}
