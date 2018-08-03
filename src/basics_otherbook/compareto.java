package basics_otherbook;

public class compareto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x="mindq";
		String y="MINIdQ";
		int w=x.compareTo(y);
		System.out.println(w); //0
		int z=x.compareToIgnoreCase(y);
		System.out.println(z); //0
	}

}

