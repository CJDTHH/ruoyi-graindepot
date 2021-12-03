package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 出入库单对象 manage_contract
 *
 * @author ruoyi
 * @date 2021-11-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManageContract extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 合同编号，HT+10位流水号
     */
    private String contractNumber;

    /**
     * 所属组织机构ID
     */
    @Excel(name = "所属组织机构ID")
    private Integer orgId;

    /**
     * 所属组织机构编码，对应组织机构表的code字段
     */
    @Excel(name = "所属组织机构编码，对应组织机构表的code字段")
    private String orgCode;

    /**
     * 合同标题
     */
    @Excel(name = "合同标题")
    private String contractTitle;

    /**
     * 合同签订方的客户名称
     */
    @Excel(name = "合同签订方的客户名称")
    private String customerName;

    /**
     * 合同规定的粮食单价
     */
    @Excel(name = "合同规定的粮食单价")
    private BigDecimal grainPrice;

    /**
     * 合同规定的粮食数量
     */
    @Excel(name = "合同规定的粮食数量")
    private BigDecimal grainQuantity;

    /**
     * 合同生效日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "合同生效日期")
    private Date enableDate;

    /**
     * 合同截止日期，格式：yyyyMMd
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "合同截止日期")
    private Date disableDate;

    /**
     * 合同状态：1 未提交；2 审批通过；3终止；4撤销；5 正在审批；6 审批未通过
     */
    @Excel(name = "合同状态：1 未提交；2 审批通过；3终止；4撤销；5 正在审批；6 审批未通过")
    private Integer contractStatus;

    /**
     * 合同类型：1 收购合同；2 销售合同； 3 代储合同
     */
    @Excel(name = "合同类型：1 收购合同；2 销售合同； 3 代储合同")
    private Integer contractType;

    /**
     * 粮食性质标识
     */
    @Excel(name = "粮食性质标识")
    private String grainAttribute;

    /**
     * 粮食性质Name
     */
    @Excel(name = "粮食性质Name")
    private String lsxz;

    /**
     * 粮食品种ID
     */
    @Excel(name = "粮食品种ID")
    private Integer grainKind;

    /**
     * 粮食品种Name
     */
    @Excel(name = "粮食品种Name")
    private String lspz;

    /**
     * 粮食年期
     */
    @Excel(name = "粮食年期")
    private String grainAnnual;

    /**
     * 已完成数量：当净重产生时，进行累加；当作业完成时，如果有增扣量，需要将增扣量加减到该数值上
     */
    @Excel(name = "已完成数量：当净重产生时，进行累加；当作业完成时，如果有增扣量，需要将增扣量加减到该数值上")
    private BigDecimal finishedQuantity;

    /**
     * 审批流程实例标识
     */
    @Excel(name = "审批流程实例标识")
    private Integer approveProcessInstance;

    /**
     * 通知书编号
     */
    @Excel(name = "通知书编号")
    private String noticeId;

    /**
     * 入库时间 yyyy-MM-dd
     */
    @Excel(name = "入库时间 yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date warehousingTime;

    /**
     * 产地ID
     */
    @Excel(name = "产地ID")
    private String districtId;

    private String warehousing;

    private String enable;

    private String disable;


    /**
     * 产地Name
     */
    @Excel(name = "产地Name")
    private String cityName;

    /**
     * 执行单详情单号
     */
    @Excel(name = "执行单详情单号")
    private String executionOrderDetails;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("contractNumber", getContractNumber())
                .append("orgId", getOrgId())
                .append("orgCode", getOrgCode())
                .append("contractTitle", getContractTitle())
                .append("customerName", getCustomerName())
                .append("grainPrice", getGrainPrice())
                .append("grainQuantity", getGrainQuantity())
                .append("enableDate", getEnableDate())
                .append("disableDate", getDisableDate())
                .append("contractStatus", getContractStatus())
                .append("createTime", getCreateTime())
                .append("contractType", getContractType())
                .append("grainAttribute", getGrainAttribute())
                .append("grainKind", getGrainKind())
                .append("lspz", getLspz())
                .append("lsxz", getLsxz())
                .append("cityName", getCityName())
                .append("grainAnnual", getGrainAnnual())
                .append("finishedQuantity", getFinishedQuantity())
                .append("approveProcessInstance", getApproveProcessInstance())
                .append("remark", getRemark())
                .append("noticeId", getNoticeId())
                .append("warehousingTime", getWarehousingTime())
                .append("districtId", getDistrictId())
                .append("executionOrderDetails", getExecutionOrderDetails())
                .toString();
    }
}
