import java.util.Random;

public class DoubleHashTable extends OAHashTable {
	public ModHash h1;
	public ModHash h2;
	
	public DoubleHashTable(int m, long p) {
		super(m);
		this.h1 = ModHash.GetFunc(m,p);
		this.h2 = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int index = (this.h1.Hash(x)+i*this.h2.Hash(x))% h1.m;
		return index;
	}
	
}
