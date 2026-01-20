package com.ssafy.day02.c_constructor;

public class SmartPhone {
    static String osName = "iOS";
    String number;
//    SmartPhone(){
//    defalut constructor
//    }
    
    //SmartPhone(int a){
    	//파라미터가 하나라도 있으면 값을 넣어야한다.
    //}
    
    SmartPhone(String number){
    	this.number = number;
    }

    void call(String to) {// 파라미터 변수
        String msg = "띠";// 로컬 변수
        for (int i = 0; i < 3; i++) {// 로컬 변수
            System.out.println(msg);
        }
    }
}
