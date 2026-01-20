package com.ssafy.day02.c_constructor;

public class SmartPhoneTest {
    public SmartPhone getPhone() {
        return null;
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        SmartPhone sphone = new SmartPhone("1010101");
        sphone.number = "010";
        System.out.println(sphone.osName + " : " + sphone.number);
        sphone.call("011");
        
        /* 위에 문장 그림
         * Stack : 1. main 메소드 실행 / 2. SmartPhone sphone 등록 / 3. println 을 호출하면 main 프레임 위에 새로운 프레임이 만들어짐 
         * --> Stack 은 Top Frame 만 실행, Top 실행 후 다시 아래로 내려옴
         * DataArea -> static Area 에 osName:IO 가 들어간다(로딩 될 때 생성)
         * DataArea -> Method Area 에 call() 이라는 메소드가 등록
         * heap : SmartPhone() 객체가 생성, 객체가 생성됐으므로 String  number 가 생성 후 null 로 default 초기화
         * heap : sphone은 SmartPhone을 가르킴, number 의 값을 "010"으로 바꿈
         * sphone.call()은 stack의 sphone.call()을 호출, call()은 함수이므로 Method Area 에서 call()을 찾아서 call() 은 stack에서 실행된다.
         * void call(String to)의 call이라는 프레임에 String to = 011 지역변수 생성, for문 실행 후 call() 프레임이 stack에서 사라짐
         * 메인이 끝나면 stack이 다 사라짐 -> 프로그램의 정상적 종료
         */

        SmartPhone sphone2 = new SmartPhone("101010");
        sphone2.number = "010-111-1111";
        System.out.println(sphone2.osName + " : " + sphone2.number);

        SmartPhone.osName = "android 4.0";
        System.out.println(sphone.osName + " : " + sphone.number);
    }
}
