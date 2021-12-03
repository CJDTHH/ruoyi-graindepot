package com.ruoyi.web.controller.anHong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagePoJo {
    private String kdsj;
    private String zxdbh;
    private String mbajbh;
    private String dzlx__dsp;
    private String mbdwbm;
    private String tzsbh;
    private String dzlx;
    private String mbkdbm;
    private List<PerformDtlPoJo> performDtl;
}
