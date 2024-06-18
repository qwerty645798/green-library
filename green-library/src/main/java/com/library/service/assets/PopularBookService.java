package com.library.service.assets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.assets.PopularBookDto;
import com.library.repository.assets.PopularBookRepository;

@Service
public class PopularBookService {
	
	@Autowired 
	private PopularBookRepository popularBookRepository;
	
	public List<PopularBookDto> getBookId() {
		return popularBookRepository.findBookId();
	}
}
