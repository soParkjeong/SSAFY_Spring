package com.ssafy.ws.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ssafy.ws.dto.Board;

/*
 * 게시판 기능을 위한 컨트롤러
 * 게시글 목록 조회, 게시글 상세 조회, 게시글 작성, 게시글 수정, 게시글 삭제 기능을 제공
 */

// Q1. BoardController 클래스를 컨트롤러 Bean으로 등록하고, 정의된 모든 요청 URL은 "/board"로 시작하도록 매핑
@_________
@______________("/board")
public class BoardController {
	
	// 게시글 목록을 저장하는 리스트
    private List<Board> boards = new ArrayList<>();
    private int nxtId = 1;

    // 게시글 목록 초기화
	public BoardController() {
		boards.add(new Board(nxtId++, "알고리즘 스터디 모집해요", "SW역량테스트 A형 준비하고 있는데 같이 할 사람 구해요!", new Date()));
		boards.add(new Board(nxtId++, "Sprin Boot 스터디 모집", "Spring Boot 공부하고 있는데 같이 할 사람 구해요!", new Date()));
		boards.add(new Board(nxtId++, "SSAFY 1학기를 진행하면서", "1학기 고생 많았어요! 같이 회고해요!", new Date()));
	}
    
    /*
     *  Q2. 게시글 전체 목록 조회 (GET /board/list)
     *  모델 객체에 게시글 목록을 담아서 board/list.jsp로 포워딩
     */
	@___________("/list")
    public String list(Model model) {
    	model.addAttribute(_______, _______);
        return ____________;
    }

	/*
	 * Q3. 게시글 상세 조회 (GET /board/detail/{id}) 모델 객체에 
	 * 해당 id를 갖는 게시글을 담아서 board/detail.jsp로 포워딩
	 * 게시글 목록이 없을 경우 /board/list로 리다이렉트
	 */
	@___________("/detail/{id}")
    public String detail(@___________ int id, Model model) {
        for (Board board : _______) {
            if (board.getId() == id) {
            	model.addAttribute(_______, _______);
                return ______________;
            }
        }
        return _____________________;
    }
    
	/*
	 * Q4. 게시글 작성 폼으로 이동 (GET /board/create) 
	 * board/write.jsp로 포워딩
	 */
	@___________("/create")
	public String write() {
		return _____________;
	}
    
    /*
	 * Q5. 게시글 생성 (POST /board/create) form으로부터 받은 
	 * 게시글 정보를 이용하여 게시글을 생성하고 게시글 목록에
	 * 추가한 뒤 게시글 목록 /board/list로 리다이렉트
     */
    @___________("/create")
    public String create(@_____________ Board board) {
    	board.setId(______);
    	board.setCreated(new Date());
        boards.add(board);
        return _________________________;
    }
    /*
     * Q6. 게시글 수정 폼으로 이동 (GET /board/update/{id})
     * 해당 id를 갖는 게시글을 모델 객체에 담아서 board/update.jsp로 포워딩
     * 게시글 목록이 없을 경우 /board/list로 리다이렉트
     */
    @___________("/update/{id}")
	public String edit(@____________ int id, Model model) {
		for (Board board : boards) {
			if (board.getId() == id) {
				model.addAttribute(_________, _________);
				return ________________;
			}
		}
		return _________________________;
	}

    /*
     * Q7. 게시글 수정 (POST /board/update/{id})
     * form으로부터 받은 게시글 정보를 이용하여 
     * 해당 id를 갖는 게시글의 제목과 내용을 수정하고
     * 게시글 목록 /board/list로 리다이렉트
     */
    @___________("/update/{id}")
    public String update(@____________ int id, @_____________ Board updatedBoard) {
        for (Board board : ______) {
            if (board.getId() == id) {
                board.setTitle(____________________);
                board.setContent(________________________);
                return ___________________;
            }
        }
        return ______________________;
    }

	/*
	 * Q8. 게시글 삭제 (POST /board/delete/{id}) 
	 * 해당 id를 갖는 게시글을 목록에서 삭제하고 
	 * 게시글 목록 /board/list로 리다이렉트
	 */
    @___________("/delete/{id}")
    public String delete(@____________ int id) {
        for (Board board : _______) {
            if (board.getId() == id) {
                boards.remove(board);
                break;
            }
        }
        return _____________________;
    }
}