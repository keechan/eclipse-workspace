package pkg;

public class Singleton {
	private  static Singleton singleton = new Singleton(); 
	private Singleton() {
		//외부 호출 금지, private 설정
	}
	static Singleton getInstance() {	   
		return singleton;	   
	}	
}
