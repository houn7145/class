package com.lec.ch17.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.ch17.model.Board;

@Mapper
public interface BoardDao {
	public List<Board> boardList(Board board);
	public int boardTotCnt();
	public int boardWrite(Board board);
	public int boardHitUp(int bid);
	public Board boardDetail(int bid);
	public int boardModify(Board board);
	public int boardDelete(int bid);
	public int boardReplyPreStep(Board board);
	public int boardReply(Board board);
}
