package com.ssafy.day02.d_init;

public class InitializerTest {
    int iv;
    static int cv;

    static {
      System.out.println("static initializer"); //생성자를 계속 만들어도 한 번 만 생성된다
      cv = 100;
    }

    {
      System.out.println("instance initializer"); //생성자를 계속 만들 때 마다 호출
      iv = 100;
    }

    public InitializerTest() {
      System.out.printf("생성자-1 iv: %d, cv: %d%n", iv, cv);
      this.iv = 300;
    }
    public InitializerTest(int a) {
        System.out.printf("생성자-2 iv: %d, cv: %d%n", iv, cv);
        this.iv = 300;
      }

    public static void main(String args[]) {
      InitializerTest it = new InitializerTest();
//      System.out.printf("1 - cv: %d, iv: %d%n", cv, it.iv);
      InitializerTest it2 = new InitializerTest(1);
//      System.out.printf("2 - cv: %d, iv: %d%n", cv, it2.iv);
    }
  }
