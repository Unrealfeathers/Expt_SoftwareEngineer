package com.expt.Expt_SoftwareEngineer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    private Long total;  // 列表条数
    private List<T> items;  // 列表数据集合
}
