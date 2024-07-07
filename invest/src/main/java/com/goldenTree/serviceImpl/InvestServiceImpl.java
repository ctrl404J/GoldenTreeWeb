package com.goldenTree.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldenTree.dto.JongtoBoardDto;
import com.goldenTree.mapper.InvestMapper;
import com.goldenTree.service.InvestService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvestServiceImpl implements InvestService {
	
	@Autowired
	private InvestMapper invetMapper;

	@Override
	public List<JongtoBoardDto> getJongtoList(int pageSize, int pageNum) {
		List<JongtoBoardDto> jongtoList = new ArrayList<>();
		try {
		    int offset = (pageNum - 1) * pageSize;
		    jongtoList = invetMapper.findJongtoList(pageSize, offset);
		} catch (NullPointerException e) {
			e.getMessage();
			throw new NullPointerException("데이터를 찾을 수 없습니다.");
		};
	    return jongtoList;
	}

	@Override
	public void insertJongto(JongtoBoardDto jongtoBoardDto) {
		
		if(jongtoBoardDto == null) {
			throw new IllegalArgumentException("빈 게시글입니다.");
		}
		
		String postAuthor = jongtoBoardDto.getJongto_author();
		String postTitle = jongtoBoardDto.getJongto_title();
		String postContent = jongtoBoardDto.getJongto_content();
		String postPass = jongtoBoardDto.getJongto_pass();
		if(postAuthor == null) {
			throw new IllegalArgumentException("작성자가 비어있습니다.");
		} else if(postTitle == null) {
			throw new IllegalArgumentException("제목이 비어있습니다.");
		} else if(postContent == null) {
			throw new IllegalArgumentException("컨텐츠가 비어있습니다.");
		} else if(postPass == null) {
			throw new IllegalArgumentException("비밀번호가 비어있습니다.");
		}
		
		try {
			invetMapper.insertJongto(jongtoBoardDto);
		} catch (Exception e) {
			e.getMessage();
			System.out.println("글쓰기 실패!");;
		}
		
	}

	@Override
	public JongtoBoardDto detailJongto(Integer jongtoId,Integer jongtoViews) {
		updateJongtoViews(jongtoId, jongtoViews);
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

	@Override
	public void updateJongtoViews(Integer jongtoId, Integer views) {
		
		invetMapper.updateJongtoViews(jongtoId, views);
		
	}

	
    
};
