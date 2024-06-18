package com.library.service.assets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.assets.DataSearchResultDto;
import com.library.repository.assets.DataSearchResultRepository;

@Service
public class DataSearchResultService {
	
	@Autowired 
	private DataSearchResultRepository dataSearchResultRepository;
	
	public List<DataSearchResultDto> getBookId(String inputCategory, String inputText) {
		return dataSearchResultRepository.findBookId(inputCategory, inputText);
	}
}
