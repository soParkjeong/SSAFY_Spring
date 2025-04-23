package com.ssafy.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.ssafy.ws.model.dto.*;
import com.ssafy.ws.service.BoardService;


/*
 * 게시판 기능을 위한 컨트롤러
 * 게시글 목록 조회, 게시글 상세 조회, 게시글 작성, 게시글 수정, 게시글 삭제 기능을 제공
 */

// BoardController 클래스를 컨트롤러 Bean으로 등록하고, 정의된 모든 요청 URL은 "/board"로 시작하도록 매핑
@RestController
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
    /*
     *  Q1. 게시글 전체 목록 조회 (GET /board)
     */
    @___________("")
    public ResponseEntity<?> list() {
        List<Board> boards = boardService.getBoardList();
    	return ResponseEntity.ok(boards);
    }

	/*
	 * Q2. 게시글 상세 조회 (GET /board/{id})
	 */
    @___________("/{id}")
    public ResponseEntity<?> detail(@PathVariable int id) {
		Board board = boardService.readBoard(id);
		return new ResponseEntity<>(board, board == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }
    
    /*
     * Q3. 게시글 생성 (POST /board)
     */
    @___________("")
    public ResponseEntity<?> create(@__________ Board board) {
		int result = boardService.___________(board);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    /*
     * Q4. 게시글 수정 (PUT /board/{id})
     */
    @___________("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @__________ Board updatedBoard) {
        updatedBoard.setId(id);
        int result = boardService.___________(updatedBoard);
        return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

	/*
	 * Q5. 게시글 삭제 (DELETE /board/{id})
	 */
    @___________("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
		int result = boardService.___________(id);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
    
	/*
	 * Q6. 게시글 검색 (GET /board/search)
	 */
    @___________("/search")
	public ResponseEntity<?> search(@_____________ SearchCondition condition) {
		List<Board> boards = boardService.___________(condition);
		return ResponseEntity.ok(boards);
	}
}