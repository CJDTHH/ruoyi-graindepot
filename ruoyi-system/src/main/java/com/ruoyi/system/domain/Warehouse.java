package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 仓房信息对象 warehouse
 *
 * @author ruoyi
 * @date 2021-12-02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 仓库标识：由仓库所属库点编号 + 固定长度编码组成 */
    private String warehouseId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String parent;

    /** 所属的组织机构ID */
    @Excel(name = "所属的组织机构ID")
    private Long orgId;

    /** 所属组织机构编码，对应组织机构表的code字段 */
    @Excel(name = "所属组织机构编码，对应组织机构表的code字段")
    private String orgCode;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String warehouseName;

    /** 仓库的人工编号，用于和粮情系统等其他系统对接 */
    @Excel(name = "仓库的人工编号，用于和粮情系统等其他系统对接")
    private String warehouseNumber;

    /** 仓库名称或仓库编号 */
    @Excel(name = "仓库名称或仓库编号")
    private String warehouseDesc;

    /** 仓房状态：1 空仓；2封仓；3 作业 */
    @Excel(name = "仓房状态：1 空仓；2封仓；3 作业")
    private Long warehouseStatus;

    /** 仓房额定容量，公斤制 */
    @Excel(name = "仓房额定容量，公斤制")
    private BigDecimal warehouseCapacity;

    /** 仓房是否是可用：0 仓房不可用；1 仓房可用，默认仓房是可用的状态 */
    @Excel(name = "仓房是否是可用：0 仓房不可用；1 仓房可用，默认仓房是可用的状态")
    private Integer isAvailable;

    /** 仓房类型标识 */
    @Excel(name = "仓房类型标识")
    private Long warehouseType;

    /** 温州使用4种类型:1.大平房仓,2.中平房仓3.小平房仓4.筒仓 */
    @Excel(name = "温州使用4种类型:1.大平房仓,2.中平房仓3.小平房仓4.筒仓")
    private String warehouseSmalltype;

    /** 例如：江苏粮食局机构代码014000255
查询来源：全国组织机构代码管理中心http://www.nacao.org.cn/ */
    private String dictinfoCode;

    /** 用于页面显示的时候排序 */
    @Excel(name = "用于页面显示的时候排序")
    private Long orderIndex;

    /** 墙体 */
    @Excel(name = "墙体")
    private String jgQiangTi;

    /** 房顶 */
    @Excel(name = "房顶")
    private String jgFangDing;

    /** $column.columnComment */
    @Excel(name = "房顶")
    private String jgFangJia;

    /** 地面 */
    @Excel(name = "地面")
    private String jgDiMian;

    /** 长 */
    @Excel(name = "长")
    private String cwChang;
    private String status;

    /** 宽 */
    @Excel(name = "宽")
    private String cwKuan;

    /** $column.columnComment */
    @Excel(name = "宽")
    private String cwYanGao;

    /** $column.columnComment */
    @Excel(name = "宽")
    private String cwDingGao;

    /** $column.columnComment */
    @Excel(name = "宽")
    private String cnChang;

    /** $column.columnComment */
    @Excel(name = "宽")
    private String cnKuan;

    /** 偃高 */
    @Excel(name = "偃高")
    private String cnYanGao;

    /** 顶高 */
    @Excel(name = "顶高")
    private String cnDingGao;

    /** $column.columnComment */
    @Excel(name = "顶高")
    private String kmShuLiang;

    /** $column.columnComment */
    @Excel(name = "顶高")
    private String kmWeiZhi;

    /** $column.columnComment */
    @Excel(name = "顶高")
    private String kmGaoDu;

    /** $column.columnComment */
    @Excel(name = "顶高")
    private String kmKuanDu;

    /** $column.columnComment */
    @Excel(name = "顶高")
    private String lsCode;

    /** $column.columnComment */
    @Excel(name = "顶高")
    private BigDecimal planeX;

    /** $column.columnComment */
    @Excel(name = "顶高")
    private BigDecimal planeY;

    /** $column.columnComment */
    @Excel(name = "顶高")
    private String reserve;

    /** $column.columnComment */
    @Excel(name = "顶高")
    private String warehouseGbCode;

    /** $column.columnComment */
    @Excel(name = "顶高")
    private String warehouseBusiness;

    /** $column.columnComment */
    @Excel(name = "顶高")
    private String createYear;

    /** $column.columnComment */
    @Excel(name = "顶高")
    private BigDecimal designCapacity;

    /** $column.columnComment */
    @Excel(name = "顶高")
    private Long grainHeight;

    /** 经度 */
    @Excel(name = "经度")
    private Long longitude;

    /** 纬度 */
    @Excel(name = "纬度")
    private Long latitude;

    /** $column.columnComment */
    @Excel(name = "纬度")
    private String protectionTechnology;

    /** 预订资格 */
    @Excel(name = "预订资格")
    private String reserveQualification;

    /** $column.columnComment */
    @Excel(name = "预订资格")
    private String warehouseImgUrl;

    /** 全景url */
    @Excel(name = "全景url")
    private String panoramaUrl;

    /** $column.columnComment */
    @Excel(name = "全景url")
    private String cnZhijing;

    /** 仓房还是货位：0代表仓房，1代表货位 */
    @Excel(name = "仓房还是货位：0代表仓房，1代表货位")
    private Long warehouseGoodsType;

    /** 仓科保管员 */
    @Excel(name = "仓科保管员")
    private Long keeper;

    /** 自增长id */
    private Long id;

    /** 作业状态 */
    @Excel(name = "作业状态")
    private Long jobStatus;

    /** 粮情分机对应ip */
    @Excel(name = "粮情分机对应ip")
    private String grainSituationIp;

    /** 粮情温湿度(仓内温湿度)通道。即发送指令的第几个通道。每个仓房的温湿度通道可能不一样，不是24就是25 */
    @Excel(name = "粮情温湿度(仓内温湿度)通道。即发送指令的第几个通道。每个仓房的温湿度通道可能不一样，不是24就是25")
    private Long grainSituationChannel;

    /** 编号，用于生成粮情采集的通道指令。同时也对应着数量在线监测上传接口的仓房对应编号。 */
    @Excel(name = "编号，用于生成粮情采集的通道指令。同时也对应着数量在线监测上传接口的仓房对应编号。")
    private Integer number;

    /** 新增，对应数量在线监测上传数据的扣除体积。单位(m^3) */
    @Excel(name = "新增，对应数量在线监测上传数据的扣除体积。单位(m^3)")
    private BigDecimal deductionVolume;


}
