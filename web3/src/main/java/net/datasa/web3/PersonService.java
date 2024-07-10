package net.datasa.web3;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * 사용자 정보 관련 처리를 하는 서비스 클래스
 */
@Service
@RequiredArgsConstructor
public class PersonService {

	private final PersonRepository personRepository;

	// 객체를 생성해서 DB에 저장
	public void test() {
		PersonEntity entity = PersonEntity.builder().id("abcde").name("김김김").age(10).build();

		personRepository.save(entity);

	}
	
	public void save(PersonDTO personDTO) {
		System.out.println(personDTO.getID());
		PersonEntity entity = PersonEntity.builder().id(personDTO.getID()).name(personDTO.getName()).age(personDTO.getAge()).build();
		personRepository.save(entity);
	}
	
	public PersonDTO getMember(String ID) throws NoSuchFieldException {
		
		PersonEntity p = personRepository.findById(ID).orElseThrow(()-> new NoSuchFieldException());
		
		PersonDTO personDTO = PersonDTO.builder().ID(p.getId()).name(p.getName()).age(p.getAge()).build();
		
		return personDTO;
	}

}
