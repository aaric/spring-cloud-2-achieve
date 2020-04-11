package com.incarcloud.common.data;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Collection;

/**
 * 请求分页数据对象
 *
 * @author Aaric, created on 2020-04-11T18:39.
 * @version 0.7.0-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ApiModel(description = "分页记录")
public class PageData<T extends Object> {

    @ApiModelProperty(position = 1, value = "查询页码", example = "1")
    private long pageNo;

    @ApiModelProperty(position = 2, value = "分页大小", example = "10")
    private long pageSize;

    @ApiModelProperty(position = 3, value = "记录总数")
    private long totalRecord;

    @ApiModelProperty(position = 4, value = "分页总数")
    private long totalPage;

    @ApiModelProperty(position = 5, value = "记录列表")
    private Collection<T> records;

    /**
     * 构造函数
     *
     * @param page 分页对象
     */
    public static <T> PageData<T> of(IPage<T> page) {
        PageData<T> pageData = new PageData<>();
        pageData.pageNo = page.getCurrent();
        pageData.pageSize = page.getSize();
        pageData.totalRecord = page.getTotal();
        pageData.totalPage = page.getPages();
        pageData.records = page.getRecords();
        return pageData;
    }
}
