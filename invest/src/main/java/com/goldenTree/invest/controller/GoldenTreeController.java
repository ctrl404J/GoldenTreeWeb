package com.goldenTree.invest.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goldenTree.invest.dto.JongtoBoardDto;
import com.goldenTree.invest.service.InvestService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GoldenTreeController {
	
	private final InvestService investService;
	
	@GetMapping("/")
    public String index() {
        
        return "index";
    };
	
//	@GetMapping("/jongto")
//	public String jongto(Model model) {
//		
//		List<JongtoBoardDto> jongtoList = investService.getJongtoList();
//		model.addAttribute("jongtoList", jongtoList);
//		return "layouts/jongto";
//	};
	
    @GetMapping("/jongto")
    public String jongto(@RequestParam(required = false, defaultValue = "1") Integer pageNum, Model model) {
        int pageSize = 10; // 페이지당 게시물 수
        
        // 게시물 목록 가져오기
        List<JongtoBoardDto> jongtoList = investService.getJongtoList(pageSize, pageNum);

        // 총 게시물 수
        int totalPosts = investService.countJongtoBoard();
        int totalPages = (int) Math.ceil((double) totalPosts / pageSize);

        // 페이지 번호 범위 계산
        int startPage = Math.max(1, pageNum - 2);
        int endPage = Math.min(totalPages, pageNum + 2);

        model.addAttribute("startPage", startPage);
        model.addAttribute("jongtoList", jongtoList);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("endPage", endPage);

        return "jongto";
    }

	@GetMapping("/jongtoWrite")
	public String jongtoWrite() {
		
		return "jongtoWrite";
		
	}
	
	@PostMapping("jongtoWriteAction")
	public String jongtoWriteAction(JongtoBoardDto jongtoBoardDto) {
	    investService.insertJongto(jongtoBoardDto);
	    return "redirect:/jongto"; // 리다이렉트할 페이지 경로를 지정하거나, 해당 페이지의 뷰 이름을 반환
	}
	
	@GetMapping("/jongtoDetail")
	public String jongtoDetail(Integer jongtoId, Model model) {
		System.out.println("아이디는:"+jongtoId);
		
		JongtoBoardDto dto = investService.detailJongto(jongtoId);
		
		System.out.println(dto.getJongto_author());
		
		model.addAttribute("jongtoDetail",dto);
		
		return "jongtoDetail";
	}
	
	@PostMapping("/jongtoDelete")
	@ResponseBody // 반환 값을 HTTP 응답으로 직렬화하도록 지정합니다.즉 문자열 자체를 반환하는 듯.
	public Boolean jongtoDelete(String jongtoId, String jongtoPass) {
		
		System.out.println("뭐가 왔지?::::::::::::"+jongtoId+"/"+jongtoPass);
		
		int result = investService.deleteJongto(jongtoId, jongtoPass);
		Boolean returnResult = true;
		
		if(result == 1) {
			returnResult = true;
		} else if(result == 0) {
			returnResult = false;
		}
		
		return returnResult;
		
	};
}
