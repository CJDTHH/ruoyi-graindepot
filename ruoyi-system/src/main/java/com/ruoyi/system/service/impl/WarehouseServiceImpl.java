package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Warehouse;
import com.ruoyi.system.mapper.WarehouseMapper;
import com.ruoyi.system.service.IWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 仓房信息Service业务层处理
 *
 * @author ruoyi
 * @date 2021-12-02
 */
@Service
public class WarehouseServiceImpl implements IWarehouseService
{
    @Autowired
    private WarehouseMapper warehouseMapper;

    /**
     * 查询仓房信息
     *
     * @param warehouseId 仓房信息主键
     * @return 仓房信息
     */
    @Override
    public Warehouse selectWarehouseByWarehouseId(String warehouseId)
    {
        return warehouseMapper.selectWarehouseByWarehouseId(warehouseId);
    }

    /**
     * 查询仓房信息列表
     *
     * @param warehouse 仓房信息
     * @return 仓房信息
     */
    @Override
    public List<Warehouse> selectWarehouseList(Warehouse warehouse)
    {
        return warehouseMapper.selectWarehouseList(warehouse);
    }

    /**
     * 新增仓房信息
     *
     * @param warehouse 仓房信息
     * @return 结果
     */
    @Override
    public int insertWarehouse(Warehouse warehouse)
    {
        return warehouseMapper.insertWarehouse(warehouse);
    }

    /**
     * 修改仓房信息
     *
     * @param warehouse 仓房信息
     * @return 结果
     */
    @Override
    public int updateWarehouse(Warehouse warehouse)
    {
        return warehouseMapper.updateWarehouse(warehouse);
    }

    /**
     * 批量删除仓房信息
     *
     * @param warehouseIds 需要删除的仓房信息主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseByWarehouseIds(String warehouseIds)
    {
        return warehouseMapper.deleteWarehouseByWarehouseIds(Convert.toStrArray(warehouseIds));
    }

    /**
     * 删除仓房信息信息
     *
     * @param warehouseId 仓房信息主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseByWarehouseId(String warehouseId)
    {
        return warehouseMapper.deleteWarehouseByWarehouseId(warehouseId);
    }
}
