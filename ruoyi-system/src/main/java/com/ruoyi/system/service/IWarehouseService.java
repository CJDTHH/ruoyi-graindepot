package com.ruoyi.system.service;


import com.ruoyi.system.domain.Warehouse;

import java.util.List;

/**
 * 仓房信息Service接口
 *
 * @author ruoyi
 * @date 2021-12-02
 */
public interface IWarehouseService
{
    /**
     * 查询仓房信息
     *
     * @param warehouseId 仓房信息主键
     * @return 仓房信息
     */
    public Warehouse selectWarehouseByWarehouseId(String warehouseId);

    /**
     * 查询仓房信息列表
     *
     * @param warehouse 仓房信息
     * @return 仓房信息集合
     */
    public List<Warehouse> selectWarehouseList(Warehouse warehouse);

    /**
     * 新增仓房信息
     *
     * @param warehouse 仓房信息
     * @return 结果
     */
    public int insertWarehouse(Warehouse warehouse);

    /**
     * 修改仓房信息
     *
     * @param warehouse 仓房信息
     * @return 结果
     */
    public int updateWarehouse(Warehouse warehouse);

    /**
     * 批量删除仓房信息
     *
     * @param warehouseIds 需要删除的仓房信息主键集合
     * @return 结果
     */
    public int deleteWarehouseByWarehouseIds(String warehouseIds);

    /**
     * 删除仓房信息信息
     *
     * @param warehouseId 仓房信息主键
     * @return 结果
     */
    public int deleteWarehouseByWarehouseId(String warehouseId);
}
