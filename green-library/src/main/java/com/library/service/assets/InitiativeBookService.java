package com.library.service.assets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.assets.InitiativeBookDto;
import com.library.repository.assets.InitiativeBookRepository;

@Service
public class InitiativeBookService {

	@Autowired 
	private InitiativeBookRepository initiativeBookRepository;
	
	public List<InitiativeBookDto> getBookId() {
		return initiativeBookRepository.findBookId();
	}
}
