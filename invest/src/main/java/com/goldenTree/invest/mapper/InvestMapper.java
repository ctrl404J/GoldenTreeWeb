package com.goldenTree.invest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goldenTree.invest.dto.JongtoBoardDto;

@Mapper
public interface InvestMapper {
	
	public List<JongtoBoardDto> findJongtoList(int pageSize, int offset);
	
	public void insertJongto(JongtoBoardDto jongtoBoardDto);
	
	public JongtoBoardDto detailJongto(Integer jongtoId);

	public int deleteJongto(String jongtoId, String jongtoPass);

	public int countJongtoBoard();

}
