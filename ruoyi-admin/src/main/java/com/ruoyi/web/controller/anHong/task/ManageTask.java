package com.ruoyi.web.controller.anHong.task;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.reflect.TypeToken;
import com.ruoyi.common.mapper.SelectPrefixCode;
import com.ruoyi.system.domain.ManageContract;
import com.ruoyi.system.service.IManageContractService;
import com.ruoyi.web.controller.anHong.pojo.ManagePoJo;
import com.ruoyi.web.controller.anHong.pojo.PerformDtlPoJo;
import com.ruoyi.web.controller.common.GetToken;
import com.ruoyi.web.controller.common.HttpRequest;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.ruoyi.web.controller.common.GetToken.buildToken;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageTask {

    @Autowired
    private GetToken getToken;
    @Autowired
    private SelectPrefixCode prefixCode;
    @Autowired
    private IManageContractService manageContractService;

    private String host = "http://www.wzcbl.com:9018/oh-wzls/_api/gw/v1/";

    public void preformDetail() {
        long timestamp = System.currentTimeMillis() / 1000;
        String data = "{\"limit\":0,\"page\":0,\"storePointCode\":\"3303000701002\",\"completed\":\"0\"}";
        String url = "doc/perform";
        String token = buildToken(timestamp, data, url);
        try {
            //发送 GET 请求
            HttpRequest request = new HttpRequest();
            String s = HttpRequest.sendGet(host + url,
                    "orgcode=3303000701002&timestamp=" + timestamp + "&token=" + token + "&data=" + URLEncoder.encode(data, "UTF-8"));
            JSONObject jsonObject = JSONObject.parseObject(s);
            String connect = jsonObject.getString("data");
            System.out.println("connect:" + connect);
            // 将json串转换成List集合,然后进行封装;
            Gson gson = new Gson();
            List<ManagePoJo> list = gson.fromJson(connect, new TypeToken<List<ManagePoJo>>() {
            }.getType());
            for (ManagePoJo poJo : list) {
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
                ManageContract ct = new ManageContract();
                String zxdbh = poJo.getZxdbh();
                String countById = prefixCode.countById(zxdbh);
                if (countById == null) {
                    // 生成编号
                    String dzlx = poJo.getDzlx();
                    String idtemp = getToken.getContractId(dzlx);
                    ct.setContractNumber(idtemp);
                    // 开单时间
                    String kdsj = poJo.getKdsj();
                    ct.setEnableDate(format.parse(kdsj));
                    // 执行单编号
                    ct.setNoticeId(zxdbh);
                    // 单证类型
                    if (dzlx.equals("CK")) {
                        ct.setContractType(2);
                    } else if (dzlx.equals("RK")) {
                        ct.setContractType(1);
                    } else if (dzlx.equals("EK")) {
                        ct.setContractType(3);
                    } else {
                        ct.setContractType(3);
                    }

                    List<PerformDtlPoJo> performDtl = poJo.getPerformDtl();
                    for (PerformDtlPoJo performDtlPoJo : performDtl) {
                        // 产地
                        String cd = performDtlPoJo.getCd() == null ? "410201" : performDtlPoJo.getCd();
                        if (cd.length() <= 6 && cd.length() != 0) {
                            ct.setDistrictId(cd);
                        } else {
                            ct.setDistrictId("410201");
                        }
                        // 粮食品种
                        String lspz = performDtlPoJo.getLspz();
                        ct.setGrainKind(Integer.valueOf(lspz));
                        // 粮食性质
                        String lyxz = performDtlPoJo.getLyxz() == null ? "Q" : performDtlPoJo.getLyxz();
                        ct.setGrainAttribute(lyxz);
                        // 入库时间 yyyy-MM-dd
                        String rksj = performDtlPoJo.getRksj() == null ? "2021-12-02" : performDtlPoJo.getRksj();
                        format.applyPattern("yyyyMMdd");
                        ct.setWarehousingTime(format.parse(rksj));
                        // 截至时间
                        format.applyPattern("yyyy-MM-dd");
                        Date date = format.parse(kdsj);
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(date);
                        cal.add(Calendar.YEAR, 2);//增加两年
                        String jssj = format.format(cal.getTime());
                        format.applyPattern("yyyyMMdd");
                        ct.setDisableDate(format.parse(jssj));
                        // 数量
                        BigDecimal sl = performDtlPoJo.getSl();
                        if (sl != null) {
                            ct.setGrainQuantity(sl);
                        } else {
                            sl = new BigDecimal(0.0);
                            ct.setGrainQuantity(sl);
                            //logger.error("数量为null");
                        }
                        // 收获年份
                        String shnf = performDtlPoJo.getShnf() == null ? "2021" : performDtlPoJo.getShnf();
                        ct.setGrainAnnual(shnf);

                        // 完成数量
                        BigDecimal wcsl = performDtlPoJo.getWcsl();
                        ct.setFinishedQuantity(wcsl);
                        // 关联执行单详情编号
                        String zxdxqbh = performDtlPoJo.getZxdxqbh();
                        ct.setExecutionOrderDetails(zxdxqbh);

                        // 核定单价
                        BigDecimal hddj = performDtlPoJo.getHddj();
                        if (hddj != null) {
                            ct.setGrainPrice(hddj);
                        } else {
                            hddj = new BigDecimal(0.0);
                            ct.setGrainPrice(hddj);
                        }
                        Integer contractType = ct.getContractType();
                        // 目标廒间编号
                        String mbajbh = poJo.getMbajbh() == null ? "1P4" : poJo.getMbajbh();
                        if (contractType == 1) {
                            ct.setContractTitle(mbajbh + "入库");
                        } else if (contractType == 2) {
                            ct.setContractTitle(mbajbh + "出库");
                        } else {
                            ct.setContractTitle(mbajbh + "倒仓");
                        }
                        // 粮源单位名称
                        String lydwmc = performDtlPoJo.getLydwmc() == null ? "未获取到客户名称" : performDtlPoJo.getLydwmc();
                        ct.setCustomerName(lydwmc);
                        int i = manageContractService.insertManageContract(ct);
                        System.out.println(i);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
