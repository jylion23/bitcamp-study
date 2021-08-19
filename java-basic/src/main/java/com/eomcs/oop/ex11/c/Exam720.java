//2단계 : inner 클래스와 인터페이스
package com.eomcs.oop.ex11.c;

import java.util.ArrayList;
import java.util.List;

public class Exam720 {
  public static void main(final String[] args) {
    Musics3 m1 = new Musics3();
    m1.add("aaa.mp3");
    m1.add("bbb.mp3");
    m1.add("ccc.mp3");

    Musics3 m2 = new Musics3();
    m2.add("xxx.mp3");
    m2.add("yyy.mp3");


    //바깥 클래스의 인스턴스를 사용하는 inner class 라면 
    //inner 클래스의 객체를 만드는 역할도 
    //바깥 클래스가 하는게 유지보수에 더 낫다
    // GRASP 설계 기법에서 "정보를 가진 자가 그 일을 하라.(Information Expert)"를 적용

    Musics3.Player p1 = m1.createPlayer();
    Musics3.Player p2 = m2.createPlayer();

    //뮤직4의 플레이어 객체 생성
    // 리턴 객체는 
    p1.play();
    p2.play();

  }
}
// 음악 플레이어의 사용법을 정의
interface Player {
  void play();
}

class Musics4 {

  List<String> songs = new ArrayList<>();

  public void add(final String song) {
    songs.add(song);
  }

  public void delete(final int index) {
    songs.remove(index);
  }
  // player 구현 객체를 리턴한다
  // player 구현체는 뮤직스4의 이너 클래스로 되어 있다.
  public Player createPlayer() {
    return new PlayerImpl(); /*this.new Player();*/
  }
  //인터페이스 구현체를 inner 클래스로 정의
  class PlayerImpl implements Player {
    public void play() {
      for (final String song : Musics4.this.songs) {
        System.out.println(song);
      }
      System.out.println("-----------------------------");
    }
  }
}


