package com.tt.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tt.demo.model.Users;
import com.tt.demo.model.boards;
import com.tt.demo.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardrepository;
	
	@Transactional
	public void 글쓰기(boards board,Users user) {
		board.setCount(0);
		board.setUsers(user);
		boardrepository.save(board);
	}
	@Transactional(readOnly=true)
	public Page<boards> 글목록(Pageable pageable){
		return boardrepository.findAll(pageable);
	}
	@Transactional(readOnly=true)
	public boards 글상세보기(int id) {
		return boardrepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패:아이디를 찾을수없습니다.");
				});
	}
	@Transactional
	public void 글삭제하기(int id) {
		boardrepository.deleteById(id);
	}
	@Transactional
	public void 글수정하기(int id,boards board) {
		boards boardrefer= boardrepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 찾기 실패:아이디를 찾을수없습니다.");
		});
		boardrefer.setTitle(board.getTitle());
		boardrefer.setContent(board.getContent());
	}
	
	@Transactional
	public List<boards> searchpost(String keyword){
		List<boards> listboard = boardrepository.findByContentContaining(keyword);
		return listboard;
	}
}
