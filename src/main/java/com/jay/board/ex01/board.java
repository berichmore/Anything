package com.jay.board.ex01;

/*
자바 게시판 시작
명령) /user/article/write
제목 : 제목1
내용 : 내용1
 */

import com.jay.board.domain.article.Article;

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

                // Article 객체 생성
                Article article = new Article();
                article.id = id;
                article.title = title;
                article.content = content;

                System.out.println("생성된 게시물 객체 : " + article);
                System.out.println("생성된 게시물 스레드 : " + Thread.currentThread().getName());

                System.out.printf("%d번 게시물이 등록되었습니다.", id);
            } else if(cmd.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else{
                System.out.println(" 다시 입력해주세요/");
            }
        }
        System.out.println("게시판 종료");
        sc.close();
    }
}
