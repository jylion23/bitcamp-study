package com.eomcs.pms;

public class Test {


  static void deleteValue(int[] arr, int value) {
    int i;
    int deleteIndex = -1;
    for(i = 0; i <arr.length; i ++) {
      if(arr[i] == value) {
        continue;
      }

    }

    if(i == arr.length) {
      return;
    }

    for (i++; i <arr.length; i++) {
      arr[i - 1] = arr[i];
    }
    arr[arr.length -1] = -1;
  }

  public static void main(String[] args) {
    int[] arr = {100, 200, 300};
    deleteValue(arr, 200);

    for(int value : arr) {
      System.out.println(value);
    }

  }
}
