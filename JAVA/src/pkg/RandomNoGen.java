package pkg;

public class RandomNoGen {
	public static void main(String[] args) {
	    int random = 0;
	    int min = 11;
	    int max = 21;
	    for (int j = 0; j < 5; j++) {
	    	//min 부터 max 미만까지 난수 생성
	    	random = (int)((Math.random() * (max - min)) + min);
		    System.out.println(random);
	    }
	}
}
