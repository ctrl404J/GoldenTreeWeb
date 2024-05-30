package com.goldenTree.invest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JongtoCommentsDto {

	private Integer jongto_commentId;
	private Integer jongto_id;
	private String jongto_commenter;
	private String jongto_commentText;
	private String jongto_commentCreated;
	
}
