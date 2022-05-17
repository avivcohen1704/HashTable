
public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	private int len;
	private HashTableElement deleted;
	
	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.len = this.table.length;
		this.deleted = new HashTableElement(-1,-1);
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		for (int i=0; i<this.len; i++) {
			int j = Hash(key,i);
			if (this.table[j] == null) {
				return null;
			}
			if (this.table[j].GetKey() == key) {
				return this.table[j];
			}
		}
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		for (int i=0; i<this.len; i++) {
			int j = Hash(hte.GetKey(), i);
			if (this.table[j] == null || this.table[j] == deleted) {
				this.table[j] = hte;
				return;
			}

			if (this.table[j].GetKey() == hte.GetKey()) {
				throw new KeyAlreadyExistsException(hte);
			}
		}
		throw new TableIsFullException(hte);
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		for (int i=0; i<this.len; i++) {
			int j=Hash(key, i);
			if (this.table[j].GetKey() == key){
				this.table[j] = this.deleted;
				return;
			}
			if (this.table[j] == null) {
				throw new KeyDoesntExistException(key);
			}
		}
		throw new KeyDoesntExistException(key);
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
