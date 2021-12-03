package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.ManageContract;

import java.util.List;

/**
 * 出入库单Mapper接口
 *
 * @author ruoyi
 * @date 2021-11-18
 */

public interface ManageContractMapper {
    /**
     * 查询出入库单
     *
     * @param contractNumber 出入库单主键
     * @return 出入库单
     */
    public ManageContract selectManageContractByContractNumber(String contractNumber);

    /**
     * 查询出入库单列表
     *
     * @param manageContract 出入库单
     * @return 出入库单集合
     */
    public List<ManageContract> selectManageContractList(ManageContract manageContract);

    /**
     * 新增出入库单
     *
     * @param manageContract 出入库单
     * @return 结果
     */
    public int insertManageContract(ManageContract manageContract);

    /**
     * 修改出入库单
     *
     * @param manageContract 出入库单
     * @return 结果
     */
    public int updateManageContract(ManageContract manageContract);

    /**
     * 删除出入库单
     *
     * @param contractNumber 出入库单主键
     * @return 结果
     */
    public int deleteManageContractByContractNumber(String contractNumber);

    /**
     * 批量删除出入库单
     *
     * @param contractNumbers 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteManageContractByContractNumbers(String[] contractNumbers);
}
