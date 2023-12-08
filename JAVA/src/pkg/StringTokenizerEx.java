package pkg;

import java.util.StringTokenizer;

public class StringTokenizerEx {

	public static void main(String[] args) {
		//문제 5. 다음 조건을 참고하여 프로그램을 완성하시오.  ( 10점 )
		//		조건 1.  main() 함수 안의 내용만 작성하시오. 
		//		조건 2.  StringTokenizer 클래스를 이용하여 “홍길동&이수홍&둘리”를 
		//		        “홍길동,이수홍,둘리”로 출력이 가능하도록 프로그램을 작성하시오.
		String str = "홍길동&이수홍&둘리";
		StringTokenizer st = new StringTokenizer(str, "&");
		
		String newStr="";
		int i = 1;
		int j = st.countTokens();
		while (st.hasMoreTokens()) {
			newStr = st.nextToken("&") + (j != i  ? "," : "");
			System.out.print(newStr);
			i++;
		}
	}
}
