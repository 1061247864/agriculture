package com.mapper;

import com.pojo.GoodType;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodTypeMapper {
	List<GoodType> show(@Param("goodtype") GoodType type);
}