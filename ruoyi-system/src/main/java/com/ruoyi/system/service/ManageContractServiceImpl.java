package com.ruoyi.system.service;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.ManageContract;
import com.ruoyi.system.mapper.ManageContractMapper;
import com.ruoyi.system.service.IManageContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 出入库单Service业务层处理
 *
 * @author ruoyi
 * @date 2021-11-18
 */
@Service
public class ManageContractServiceImpl implements IManageContractService {
    @Autowired
    private ManageContractMapper manageContractMapper;

    /**
     * 查询出入库单
     *
     * @param contractNumber 出入库单主键
     * @return 出入库单
     */
    @Override
    public ManageContract selectManageContractByContractNumber(String contractNumber) {
        return manageContractMapper.selectManageContractByContractNumber(contractNumber);
    }

    /**
     * 查询出入库单列表
     *
     * @param manageContract 出入库单
     * @return 出入库单
     */
    @Override
    public List<ManageContract> selectManageContractList(ManageContract manageContract) {
        return manageContractMapper.selectManageContractList(manageContract);
    }

    /**
     * 新增出入库单
     *
     * @param manageContract 出入库单
     * @return 结果
     */
    @Override
    public int insertManageContract(ManageContract manageContract) {
        manageContract.setCreateTime(DateUtils.getNowDate());
        return manageContractMapper.insertManageContract(manageContract);
    }

    /**
     * 修改出入库单
     *
     * @param manageContract 出入库单
     * @return 结果
     */
    @Override
    public int updateManageContract(ManageContract manageContract) {
        return manageContractMapper.updateManageContract(manageContract);
    }

    /**
     * 批量删除出入库单
     *
     * @param contractNumbers 需要删除的出入库单主键
     * @return 结果
     */
    @Override
    public int deleteManageContractByContractNumbers(String contractNumbers) {
        return manageContractMapper.deleteManageContractByContractNumbers(Convert.toStrArray(contractNumbers));
    }

    /**
     * 删除出入库单信息
     *
     * @param contractNumber 出入库单主键
     * @return 结果
     */
    @Override
    public int deleteManageContractByContractNumber(String contractNumber) {
        return manageContractMapper.deleteManageContractByContractNumber(contractNumber);
    }

    /**
     * 出入库详细信息
     */

}
