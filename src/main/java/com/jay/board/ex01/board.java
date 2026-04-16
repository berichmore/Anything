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
        System.out.println("== 자바 게시판 시작 ==");


        while(true) {
            System.out.print("명령 ");
            String cmd = sc.nextLine();

            if (cmd.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            System.out.println("입력받은 명령어 " + cmd);
        }
    }
}
