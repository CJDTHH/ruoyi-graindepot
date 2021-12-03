package com.ruoyi.web.controller.single;

import java.util.List;

import com.ruoyi.system.domain.ManageContract;
import com.ruoyi.system.service.IManageContractService;
import com.ruoyi.web.controller.anHong.task.ManageTask;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出入库单Controller
 *
 * @author ruoyi
 * @date 2021-11-18
 */
@Controller
@RequestMapping("/single/contract")
public class ManageContractController extends BaseController {
    private String prefix = "single/contract";

    @Autowired
    private IManageContractService manageContractService;

    @Autowired
    private ManageTask task;

    @RequiresPermissions("single:contract:view")
    @GetMapping()
    public String contract() {
        return prefix + "/contract";
    }

    /**
     * 查询出入库单列表
     */
    @RequiresPermissions("single:contract:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ManageContract manageContract) {
        startPage();
        task.preformDetail();
        List<ManageContract> list = manageContractService.selectManageContractList(manageContract);
        return getDataTable(list);
    }

    /**
     * 导出出入库单列表
     */
    @RequiresPermissions("single:contract:export")
    @Log(title = "出入库单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ManageContract manageContract) {
        List<ManageContract> list = manageContractService.selectManageContractList(manageContract);
        ExcelUtil<ManageContract> util = new ExcelUtil<ManageContract>(ManageContract.class);
        return util.exportExcel(list, "出入库单数据");
    }

    /**
     * 新增出入库单
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存出入库单
     */
    @RequiresPermissions("single:contract:add")
    @Log(title = "出入库单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ManageContract manageContract) {
        return toAjax(manageContractService.insertManageContract(manageContract));
    }

    /**
     * 修改出入库单
     */
    @GetMapping("/edit/{contractNumber}")
    public String edit(@PathVariable("contractNumber") String contractNumber, ModelMap mmap) {
        ManageContract manageContract = manageContractService.selectManageContractByContractNumber(contractNumber);
        mmap.put("manageContract", manageContract);
        return prefix + "/edit";
    }

    /**
     * 修改出入库单
     */
    @GetMapping("/detail/{contractNumber}")
    public String detail(@PathVariable("contractNumber") String contractNumber, ModelMap mmap) {
        ManageContract manageContract = manageContractService.selectManageContractByContractNumber(contractNumber);
        mmap.put("manageContract", manageContract);
        return prefix + "/detail";
    }

    /**
     * 修改保存出入库单
     */
    @RequiresPermissions("single:contract:edit")
    @Log(title = "出入库单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ManageContract manageContract) {
        return toAjax(manageContractService.updateManageContract(manageContract));
    }

    /**
     * 删除出入库单
     */
    @RequiresPermissions("single:contract:remove")
    @Log(title = "出入库单", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(manageContractService.deleteManageContractByContractNumbers(ids));
    }
}
