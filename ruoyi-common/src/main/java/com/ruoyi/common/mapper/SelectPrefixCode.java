package com.ruoyi.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface SelectPrefixCode {

    @Select(" select prefix_code from sys_numbergenerateway where id = #{id}")
    String findPrefixCode(String id);

    @Select(" select count(contract_number) from manage_contract")
    Integer countNumber();

    @Select(" select * from manage_contract where notice_id = #{id}")
    String countById(String id);
}
