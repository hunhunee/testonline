package com.sie.mapper;

import com.sie.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface TestMapper {

    public User test(int id);
}
