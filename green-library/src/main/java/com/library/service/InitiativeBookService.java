package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.InitiativeBookDto;
import com.library.repository.InitiativeBookRepository;

@Service
public class InitiativeBookService {

	@Autowired 
	private InitiativeBookRepository initiativeBookRepository;
	
	public List<InitiativeBookDto> getBookId() {
		return initiativeBookRepository.findBookId();
	}
}
