package net.datasa.test4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.datasa.test4.domain.Person;


@Controller
@RequestMapping("lom")
@Slf4j
public class LomController {
	
	@GetMapping("lombok")
	public String lombokTest() {
		Person a = Person.builder().name("김").age(1).phoneNum("010-1111-2222").build();
		System.out.println(a);
		return "redirect:/"; // 리다이렉트 
	}
	
	@GetMapping("logger")
	public String loggerTest() {
		log.error("error 메시지"); // 오류메시지, 심각한 문제, 예외 상황
		log.warn("warn 메시지"); // 경고성 메시지, 예상치 못한 무넺, 잠재적 오류 상황, 정상적으로 작동은 하나 주의 필요
		log.info("info 메시지"); // 정보성 메시지 기록, 주요 이벤트, 실행 상태 정보
		log.debug("debug 메시지"); // 디버깅 목적, 상세 정보 기록, 내부 동작 이해, 문제 분석 도움
		log.trace("trace 메시지"); // 가장 상세한 로그 레벨, 애플리케이션의 실행 흐름과 디버깅 정보 상세히 기록, 디버깅시 사용
		
		String a = "abc";
		int b= 12;
		log.debug("a={}, b={}", a, b); // 빈 중괄호, 변수
		return "redirect:/"; // 포워딩
	}
}
