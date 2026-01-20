package com.ssafy.day02.d_init;

/*
 * static
 * 		목적 : 객체를 생성하지 않고도 호출이 가능하다
 * 		위치 : 멤버변수 => 객체변수가 아니고, 클래스 변수가 된다
 * 		      멤버함수 => static이 붙으면 static 변수나 static 함수만 사용할 수 있다.
 *  		  내부클래스 => java는 여러 클래스를 만들 수 있지만, public은 하나만 만들 수 있다
 *  			ㄴ 메인 클래스 안에 (void main 아님)
 */

class Test2{}
class Test3{}
class Test4{} // class가 3개 파일 더 만들어짐

public class StaticTest {
	int i;
	static int si;
	
//	class Inner{ //내부클래스, staticTest%Inner.class로 생성
//		
//	}
	
	void instanceMethod() {
		i++;
		si++;
	}
	
	static void staticMethod() { //객체를 생성하지 않아도 호출 가능 -> 그래서 타이밍이 안맞음
		// static method 에서는 static 변수나 static method만 호출할 수 있다
		// i++;
		si++;
	}
	
	static class Inner{
		public Inner() {
			StaticTest st = new StaticTest(); // 내부 클래스에서 외부 클래스 생성 가능
		}
	}
	
	public static void main(String[] args) { //main함수는 JVM이 호출 (ClassName.main으로 호출)
		// staticMethod(); 가능
		// instanceMethod() 은 불가능 객체를 만들어줘야함
		
		StaticTest.Inner in = new StaticTest.Inner(); //inner 클래스 객체 생성 방법
		
		StaticTest st1 = new StaticTest();		st1.i = 10;
		st1.si = 15;
		st1.instanceMethod();
		st1.staticMethod();
		StaticTest.staticMethod();	
		
		StaticTest st2 = new StaticTest();
		st2.i = 20;
		st2.si = 25;
		
		System.out.println(st1.i + "," + st1.si); //si는 static 이므로 static Area에 생성, st1과 st2가 si를 공유하므로
												// sysout si는 25가 출력
		StaticTest.si = 30;						// class 명으로도 초기화 가능
		System.out.println(st2.si + "," + st1.si); // class 로 si을 30으로 초기화했으므로 30 출력
	}
}
