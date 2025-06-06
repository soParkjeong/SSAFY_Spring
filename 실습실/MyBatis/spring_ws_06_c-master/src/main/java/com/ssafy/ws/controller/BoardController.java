package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ssafy.ws.model.dto.Board;
import com.ssafy.ws.service.BoardService;

import jakarta.servlet.http.HttpSession;

/*
 * 게시판 기능을 위한 컨트롤러
 * 게시글 목록 조회, 게시글 상세 조회, 게시글 작성, 게시글 수정, 게시글 삭제 기능을 제공
 */

// BoardController 클래스를 컨트롤러 Bean으로 등록하고, 정의된 모든 요청 URL은 "/board"로 시작하도록 매핑
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
    /*
     *  Q1. 게시글 전체 목록 조회 (GET /board/list)
     *  모델 객체에 게시글 목록을 담아서 board/list.jsp로 포워딩
     */
    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardService.____________();
    	model.addAttribute("boards", boards);
        return "board/list";
    }

	/*
	 * Q2. 게시글 상세 조회 (GET /board/detail/{id}) 모델 객체에 
	 * 해당 id를 갖는 게시글을 담아서 board/detail.jsp로 포워딩
	 * 게시글 목록이 없을 경우 /board/list로 리다이렉트
	 */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
		Board board = boardService.____________(id);
		if (board == null) {
			return "redirect:/board/list";
		}
		model.addAttribute("board", board);
		return "board/detail";
    }
    
	/*
	 * Q3. 게시글 작성 폼으로 이동 (GET /board/create) 
	 * board/write.jsp로 포워딩
	 */
    @GetMapping("/create")
	public String write() {
		return ____________;
	}
    
    /*
     * Q4. 게시글 생성 (POST /board/create)
     * form으로부터 받은 게시글 정보를 이용하여 게시글을 생성하고
     * 게시글 목록 /board/list로 리다이렉트
     */
    @PostMapping("/create")
    public String create(@ModelAttribute Board board) {
		boardService.____________(board);
		return ____________;
    }
    /*
     * Q5. 게시글 수정 폼으로 이동 (GET /board/update/{id})
     * 해당 id를 갖는 게시글을 모델 객체에 담아서 board/update.jsp로 포워딩
     * 게시글 목록이 없을 경우 /board/list로 리다이렉트
     */
    @GetMapping("/update/{id}")
	public String edit(@PathVariable int id, Model model) {
		Board board = boardService.____________(id);
		if (board == null) {
			return "redirect:/board/list";
		}
		model.addAttribute("board", board);
		return "board/update";
	}

    /*
     * Q6. 게시글 수정 (POST /board/update/{id})
     * form으로부터 받은 게시글 정보를 이용하여 해당 id를 갖는 게시글을 수정하고
     * 게시글 상세 조회 /board/detail/{id}로 리다이렉트
     */
    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, @ModelAttribute Board updatedBoard) {
        updatedBoard.______(id);
        boardService.____________(updatedBoard);
        return "redirect:/board/detail/" + id;
    }

	/*
	 * Q7. 게시글 삭제 (POST /board/delete/{id}) 
	 * 해당 id를 갖는 게시글을 삭제하고 게시글 목록 /board/list로 리다이렉트
	 */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        Board board = boardService.____________(id);
		if (board == null) {
			return "redirect:/board/list";
		}
		boardService.____________(id);
		return "redirect:/board/list";
    }
}