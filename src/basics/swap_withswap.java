/**
 * 
 */
package basics;
public class swap_withswap {

	public static void main(String[] args) {
      int x=20;
      int y=50;
      System.out.println("before swap:");
      System.out.println("x vaue:"+x);
      System.out.println("y vaue:"+y);
      swap(x,y);
    /*  x=x+y;
      y=x-y;
      x=x-y;*/
      System.out.println("After swap:");
      System.out.println("x vaue:"+x);
      System.out.println("y vaue:"+y);
	}

	/**
	 * @param x
	 * @param y
	 */
	private static void swap(int x, int y) {
 int temp=x;
 x=y;
 y=x;
	}

}
