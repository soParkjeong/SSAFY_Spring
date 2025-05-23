package com.ssafy.sw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// Q3. 해당 클래스가 스프링 설정 정보를 포함한 Bean 구성 클래스임을 나타는 어노테이션
// Q4. 지정된 패키지 이하의 @Component 어노테이션이 붙은 클래스를 찾아 빈으로 등록
//@Component
public class Game {

    // 1-A 실습 내용을 참고 주입 부분을 완성하시오.
    @Autowired
    private Monster monster;

    @Autowired
    @Qualifier("heroA")
    private Player playerA;

    @Autowired
    @Qualifier("heroB")
    private Player playerB;

    public void run() {
        System.out.println("게임을 시작합니다.");
        System.out.println("------------------------------------------");
        // 몬스터의 원래 체력 출력
        System.out.println("몬스터의 원래 체력: " + monster.getHealth() + " HP");
        // 플레이어A가 몬스터를 공격
        playerA.attack(monster);
        // 플레이어B가 몬스터를 공격
        playerB.attack(monster);
        System.out.println("------------------------------------------");
        System.out.println("몬스터의 바뀐 체력: " + monster.getHealth() + " HP");
    }

}
