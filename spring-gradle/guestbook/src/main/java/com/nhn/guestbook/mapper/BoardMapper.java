package com.nhn.guestbook.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardMapper {
	List<Map<String, Object>> getBoard();
}
