package com.eomcs;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {

  private static List<Peg> pegs = new ArrayList<>();
  private static int numOfMoves = 0;
  private static int maxDisk = 3;
  public static void main(String[] args) {
    System.out.println("Tower Of Hanoi, deconstructed! ");
    System.out.println("Disk = 1, Number Of Moves : " + numberOfMoves(1));
    System.out.println("Disk = 2, Number Of Moves : " + numberOfMoves(2));
    System.out.println("Disk = 3, Number Of Moves : " + numberOfMoves(3));
    System.out.println("Disk = 4, Number Of Moves : " + numberOfMoves(4));
    System.out.println("Disk = 5, Number Of Moves : " + numberOfMoves(5));

    Disk disk1 = new Disk(1, "    #     ");
    Disk disk2 = new Disk(2, "   ###    ");
    Disk disk3 = new Disk(3, "  #####   ");
    Disk disk4 = new Disk(4, " #######  ");
    Disk disk5 = new Disk(5, "#########");

    Peg peg1 = new Peg("Peg1");
    Peg peg2 = new Peg("Peg2");
    Peg peg3 = new Peg("Peg3");
    pegs.add(peg1);
    pegs.add(peg2);
    pegs.add(peg3);
    //peg1.addDisk(disk5);
    //peg1.addDisk(disk4);
    peg1.addDisk(disk3);
    peg1.addDisk(disk2);
    peg1.addDisk(disk1);
    System.out.println("Starting position ");
    displayAllPegs();
    System.out.println("--------- ");
    maxDisk = peg1.disks.size();
    recursiveMove(peg1.disks.size(), peg1, peg2, peg3);
    System.out.println("Number of moves : " + numOfMoves);
  }

  private static void recursiveMove(int n, Peg source, Peg temp, Peg dest) {
    if(n == 0 ) return;
    // move n-1 disks to the second peg
    recursiveMove(n-1, source, dest, temp);
    // move nth disk to peg3
    System.out.println("moving disk " + n + ".");
    System.out.println("source : " + source.name);
    System.out.println("temp : " + temp.name);
    System.out.println("dest : " + dest.name);
    move(source, dest);
    // now move n-1 disks in peg2 to the third peg
    recursiveMove(n-1, temp, source, dest);

  }

  private static void displayAllPegs() {
    String leftAlignFormat = "| %-10s | %-10s | %-10s |%n";

    System.out.format("+------------+------------+------------+%n");
    System.out.format(leftAlignFormat, "Peg1", "Peg2", "Peg3");
    System.out.format("+------------+------------+------------+%n");
    for (int i = 0; i < maxDisk; i++) {
      Peg p1 = pegs.get(0);
      Peg p2 = pegs.get(1);
      Peg p3 = pegs.get(2);

      System.out.format(leftAlignFormat, pos(p1, i), pos(p2, i), pos(p3, i));
    }
    System.out.format("+------------+------------+------------+%n");
  }

  private static String pos(Peg p, int n) {
    if(p.isEmpty()) return "";
    if( n - (maxDisk - p.getDisks().size()) >= 0) {
      return p.getDisks().get(n - (maxDisk - p.getDisks().size())).graphic;
      //n = 0 , disk size = 3 -> ""  3    n - (5 - 3)
      //n = 1, disk size = 3 ->  ""  4
      //n = 2, disk size = 3 ->  "   #   " 0th
      //n = 3, disk size = 3 ->  "  ###  " 1st
      //n = 4, disk size = 3 ->  " ##### " 2nd
    }
    return "";
  }

  private static void move(Peg source, Peg dest) {
    dest.addDisk(source.remove());
    numOfMoves++;
    System.out.println("number of moves : " + numOfMoves);
    displayAllPegs();
  }


  public static int numberOfMoves(int n) {
    if(n == 0) {
      return 0;
    }
    return 2*(numberOfMoves(n-1)) + 1;
  }

  static class Disk {
    public final int size;
    public final String graphic;

    public Disk(int size, String graphic) {
      this.size = size;
      this.graphic = graphic;
    }
  }


  static class Peg {
    public final String name;
    private List<Disk> disks;

    public Peg(String name) {
      this.name = name;
      this.disks = new ArrayList<>();
    }

    /**
     * 원판을 추가하는 메서드. 0번째에 원판을 추가하고, 추가하는 원판은 반드시 현재 0번째의 원판보다 크기가 작아야 한다.
     * @param disk
     */
    public void addDisk(final Disk disk) {
      if(this.disks.isEmpty() || this.disks.get(0).size > disk.size) {
        this.disks.add(0, disk);
        return;
      }
      throw new IllegalArgumentException("can't add bigger disk to a smaller disk.");
    }

    /**
     * 가장 첫번재 원판을 지우고 리턴함.
     * @return 0th disk
     */
    public Disk remove() {
      if(this.disks.isEmpty()) {
        throw new IllegalArgumentException(this.name + " is empty.");
      }
      return this.disks.remove(0);
    }

    public boolean isEmpty() {
      return this.disks.isEmpty();
    }

    public List<Disk> getDisks() {
      return this.disks;
    }
  }
}