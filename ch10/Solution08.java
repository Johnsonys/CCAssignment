public class Solution08 {
	/**
	 *  Solution idea:
	 *  Since we have 4KB memory, we can use these 4*1024*8 bits(32 * 2^10 bits)
	 *  to store the statue of number.
 	**/

    class BitSet {
    	int[] bitset;
    	public BitSet(int size) {
    		bitset = new int[size >> 5 + 1]; //int => 4 bytes(32 bit)
    	}
    	public boolean get(int pos) {
    		int numberIndex = pos >> 5;
    		int bitIndex = pos & 0x1F;
    		return (bitset[numberIndex] & (1 << bitIndex)) != 0;
    	}
    	public void set(int pos) {
    		int numberIndex = pos >> 5;
    		int bitIndex = pos & 0x1F;
    		bitset[numberIndex] |= 1 << bitIndex;
    	}	
    }
    public void checkDuplicates(int[] array) {
    	BitSet bs = new BitSet(32000);
    	for (int i = 0; i < array.length; i++) {
    		int num = array[i];
    		int num0 = num - 1;  //bitset starts at 0, numbers start at 1.
    		if (bs.get(num0)) {
    			System.out.println(num);
    		} else {
    			bs.set(num0);
    		}
    	}
    }
}