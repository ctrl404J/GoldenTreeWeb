package com.goldenTree.invest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldenTree.invest.dto.JongtoBoardDto;
import com.goldenTree.invest.mapper.InvestMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvestServiceImpl implements InvestService {
	
	@Autowired
	private InvestMapper invetMapper;

	@Override
	public List<JongtoBoardDto> getJongtoList(int pageSize, int pageNum) {
	    int offset = (pageNum - 1) * pageSize;
	    List<JongtoBoardDto> jongtoList = invetMapper.findJongtoList(pageSize, offset);
	    System.out.println("페이지 넘버::::" + pageNum);
	    System.out.println("페이지 싸이즈::::" + pageSize);
	    System.out.println("페이지 오프셋::::" + offset);
	    System.out.println("JongtoSize:::" + jongtoList.size());
	    return jongtoList;
	}

	@Override
	public void insertJongto(JongtoBoardDto jongtoBoardDto) {
		
		invetMapper.insertJongto(jongtoBoardDto);
		
	}

	@Override
	public JongtoBoardDto detailJongto(Integer jongtoId) {
		return invetMapper.detailJongto(jongtoId);
	}

	@Override
	public int deleteJongto(String jongtoId, String jongtoPass) {
		
		int result = invetMapper.deleteJongto(jongtoId, jongtoPass);
		
		return result;
		 
	}

	@Override
	public int countJongtoBoard() {
		int result = invetMapper.countJongtoBoard();
		return result;
	}

	
    
}
