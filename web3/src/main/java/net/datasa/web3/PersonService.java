package net.datasa.web3;

import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * DB에 Person 저장
	 * @param personDTO
	 */
	public void save(PersonDTO personDTO) {
		System.out.println(personDTO.getID());
		PersonEntity entity = PersonEntity.builder().id(personDTO.getID()).name(personDTO.getName()).age(personDTO.getAge()).build();
		personRepository.save(entity);
	}
	
	/**
	 * 
	 * @param ID 			불러올 Person의 ID
	 * @return PersonDTO	
	 */
	public PersonDTO getMember(String ID){
		
		PersonEntity p = personRepository.findById(ID).orElseThrow(()-> new RuntimeException());
		
		PersonDTO personDTO = PersonDTO.builder().ID(p.getId()).name(p.getName()).age(p.getAge()).build();
		
		return personDTO;
	}
	
	public List<PersonDTO> selectAll(){
		List<PersonEntity> entityList = personRepository.findAll();
		List<PersonDTO> dtoList = new ArrayList<>();
		
		for(PersonEntity entity : entityList) {
			PersonDTO dto = PersonDTO.builder()
					.ID(entity.getId())
					.name(entity.getName())
					.age(entity.getAge()).build();
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	public void delete(String ID) {
		personRepository.deleteById(ID);
		return;
	}
}
