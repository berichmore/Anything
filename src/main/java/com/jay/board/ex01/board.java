package com.jay.board.ex01;

/*
자바 게시판 시작
명령) /user/article/write
제목 : 제목1
내용 : 내용1
 */

import java.util.Scanner;

public class board {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lastId = 0;

        System.out.println("== 자바 게시판 시작 == ");

        while(true) {
            System.out.print("명령 ");
            String cmd = sc.nextLine();

            if(cmd.equals("/user/article/write")) {
                System.out.println("== 게시물 작성 ==");
                System.out.println("제목을 입력하세요: ");
                String title = sc.nextLine();

                System.out.println("내용을 입력하세요: ");
                String content = sc.nextLine();
                int id = ++lastId;
                System.out.printf("%d번 게시물이 등록되었습니다.", id);
            } else if(cmd.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else{
                System.out.println(" ㅇㅇㅇ");
            }
        }
    }
}
