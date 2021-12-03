package com.ruoyi.web.controller.ware;

import java.util.List;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Warehouse;
import com.ruoyi.system.service.IWarehouseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓房信息Controller
 *
 * @author ruoyi
 * @date 2021-12-02
 */
@Controller
@RequestMapping("/system/warehouse")
public class WarehouseController extends BaseController
{
    private String prefix = "warehouse";

    @Autowired
    private IWarehouseService warehouseService;

    @RequiresPermissions("system:warehouse:view")
    @GetMapping()
    public String warehouse()
    {
        return prefix + "/warehouse";
    }

    /**
     * 查询仓房信息列表
     */
    @RequiresPermissions("system:warehouse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Warehouse warehouse)
    {
        startPage();
        List<Warehouse> list = warehouseService.selectWarehouseList(warehouse);
        return getDataTable(list);
    }

    /**
     * 导出仓房信息列表
     */
    @RequiresPermissions("system:warehouse:export")
    @Log(title = "仓房信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Warehouse warehouse)
    {
        List<Warehouse> list = warehouseService.selectWarehouseList(warehouse);
        ExcelUtil<Warehouse> util = new ExcelUtil<Warehouse>(Warehouse.class);
        return util.exportExcel(list, "仓房信息数据");
    }

    /**
     * 新增仓房信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存仓房信息
     */
    @RequiresPermissions("system:warehouse:add")
    @Log(title = "仓房信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Warehouse warehouse)
    {
        return toAjax(warehouseService.insertWarehouse(warehouse));
    }

    /**
     * 修改仓房信息
     */
    @GetMapping("/edit/{warehouseId}")
    public String edit(@PathVariable("warehouseId") String warehouseId, ModelMap mmap)
    {
        Warehouse warehouse = warehouseService.selectWarehouseByWarehouseId(warehouseId);
        mmap.put("warehouse", warehouse);
        return prefix + "/edit";
    }

    /**
     * 修改保存仓房信息
     */
    @RequiresPermissions("system:warehouse:edit")
    @Log(title = "仓房信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Warehouse warehouse)
    {
        return toAjax(warehouseService.updateWarehouse(warehouse));
    }

    /**
     * 删除仓房信息
     */
    @RequiresPermissions("system:warehouse:remove")
    @Log(title = "仓房信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(warehouseService.deleteWarehouseByWarehouseIds(ids));
    }
}
