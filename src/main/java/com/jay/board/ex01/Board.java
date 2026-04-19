package com.jay.board.ex01;

/*
자바 게시판 시작
명령) /user/article/write
제목 : 제목1
내용 : 내용1
 */

import com.jay.board.domain.article.Article;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Board {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Article> articles = new ArrayList<>();
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
                // 내가 넣은 값이 주소값으로 나오면 보기 불편하니 toString을 쓰자
                System.out.println("생성된 게시물 객체 toString: " + article.toString());
                System.out.println("생성된 게시물 스레드 : " + Thread.currentThread().getName());

                // 생성된 게시물 객체를 공유

                articles.add(article);


                System.out.printf("%d번 게시물이 등록되었습니다.", id);
            } else if(cmd.startsWith("/user/article/detail")) {
                System.out.println("== 게시물 상세보기 ==");

                String[] urlBits =  cmd.trim().split("/");
                System.out.println(Arrays.toString(urlBits));
                // ====
                if (urlBits.length < 5) {
                    System.out.println("/detail/ 글 번호를 입력해주세요");
                    continue;
                }

                if (articles.isEmpty()) {
                    System.out.println("게시물이 존재하지 않습니다.");
                    continue;
                }

                // --

                // '/ ' 를 기준으로 데이터 쪼갠다.

                int id = Integer.parseInt(urlBits[4]);


                // Q) List에 저장된 마지막 게시물을 가져오는 방법은??

                Article article = articles.get(articles.size() -1);
                // java 21 이상은 getLast로 대체 가능

                if (article == null) {
                    System.out.println("해당 게시물은 존재하지 않습니다.");
                    continue;
                }

                System.out.printf("== %d번 게시물 상세보기 ==\n", article.id);
                System.out.printf("번호: %s\n", article.id);
                System.out.printf("제목: %s\n", article.title);
                System.out.printf("내용: %s\n", article.content);

            } else if (cmd.equals("exit")){
                System.out.println(" 프로그램을 종료합니다.");
                break;
            } else {
                System.out.println(" 다시 입력해주세요/");
            }

        }
        System.out.println("게시판 종료");
        sc.close();
    }
}
