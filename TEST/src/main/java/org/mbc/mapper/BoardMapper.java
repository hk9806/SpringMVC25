package org.mbc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mbc.domain.BoardVO;

public interface BoardMapper {

	@Select("SELECT * FROM tbl_board WHERE bno > 0")

	public List<BoardVO> getList();

	public List<BoardVO> getList2();

	public void insert(BoardVO board);

	public void insertSelectKey(BoardVO board);

	public BoardVO read(Long bno);

	public int delete(Long bno);

	public int update(BoardVO board);
}
