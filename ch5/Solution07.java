public class Solution07 {
	public static int swapOddEvenBits(int n) {
		return (((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1));
	}
    public static void main(String[] args) {
    	System.out.println(swapOddEvenBits(2));
    }
}