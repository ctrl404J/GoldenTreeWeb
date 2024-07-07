package com.goldenTree.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JongtoBoardDto {
	
	private Integer jongto_id;
	private String jongto_sort;
	private String jongto_title;
	private String jongto_content;
	private String jongto_author;
	private Integer jongto_views = 0;
	private String jongto_createdDate;
	private String jongto_pass;
	
	
}
