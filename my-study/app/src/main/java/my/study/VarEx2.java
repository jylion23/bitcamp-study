package my.study;    
// 컴파일 방식
// javac [-옵션 옵션이름] [컴파일한 파일 저장 경로] [소스파일 경로]
// javac -encoding utf-8 src/main/java/my/study/VarEx1.java 소스파일 경로
// src/main/java <= 프로젝트에서 지정한 소스 폴더  

// 자바 실행 방식
// 클래스파일은 패키지 이름과 같은 폴더에 있어야한다.
// java -cp 루트폴더 [.패키지명.클래스파일]
// java -cp bin/main com.eomcs.lang.Hello3

class VarEx1{
    public static void main(String[] args) {
        int year= 0;
        int age = 14;
        
        System.out.println(year);
        System.out.println(age);

        year = age + 2000;
        age = age + 1;

        System.out.println(year);
        System.out.println(age);
    }
}