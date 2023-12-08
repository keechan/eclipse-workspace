package pkg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoundUseMath {

	public static void main(String[] args) {
        // 대상 문자열
        String txt = "231102-3234567";

        //체크할 주민번호의 정규표현식
        String patternString = "\\d{6}\\-[1-4]\\d{6}";

        //정규식 패턴으로 변환
        Pattern pattern = Pattern.compile(patternString); 
        
        //문자열을 검사하고 필터링된 결과를 매처 객체로 반환
        Matcher matcher = pattern.matcher(txt);           

        // 매칭될 경우 : true
        System.out.println(matcher.find()); 
        //값출력 : 231102-3234567
        System.out.println(matcher.group());
	}
}
