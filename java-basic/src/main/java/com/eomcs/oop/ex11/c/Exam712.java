//2단계 : none 스태틱 중첩 클래스(inner class) 사용
package com.eomcs.oop.ex11.c;

import java.util.ArrayList;
import java.util.List;

public class Exam712 {
  public static void main(final String[] args) {
    Musics2 m1 = new Musics2();
    m1.add("aaa.mp3");
    m1.add("bbb.mp3");
    m1.add("ccc.mp3");

    Musics2 m2 = new Musics2();
    m2.add("xxx.mp3");
    m2.add("yyy.mp3");

    Musics2.Player p1 = m1.new Player();
    Musics2.Player p2 = m2.new Player();

    p1.play();
    p2.play();

  }
}


class Musics2 {

  List<String> songs = new ArrayList<>();

  public void add(final String song) {
    songs.add(song);
  }

  public void delete(final int index) {
    songs.remove(index);
  }

  //바깥 클래스의 인스턴스를 저장할 필드가 자동 생성된다.
  class Player {
    //    1. 논스태틱 중첩 클래스는 바깥 클래스 인스턴수 주소를 저장할 필드가 내장되어 다음 선언문이 필요없다.
    //    Musics1 musics;


    // 2. 바깥 클래스의 인스턴스를 받는 파라미터가 생성자에 자동으로 추가되므로 
    // 다음과 같이 바깥 클래스의 객체를 받는 파라미터를 개발자가 직접 선언할 필요 없다.
    public Player(/*Musics2 musics*/) {
      //따라서 바깥 클래스의 객체 주소를 인스턴스 필드에 저장하는 코드를 작성할 필요가 없다
      //      this.musics = musics;
    }

    public void play() {
      //    필드에 보관되어 있는 뮤직스 객체에서 음악 파일을 꺼내 플레이한다.
      for (final String song : Musics2.this.songs) {
        System.out.println(song);
      }
      System.out.println("-----------------------------");
    }
  }
}


