package com.xgon.classmanager.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * <p>FileName:&ensp;com.xgon.classmanager.common.<strong>Page.java</strong></p>
 * <p>Date:&ensp;2021-09-24 9:55</p>
 * <p>Description:&ensp;帮助查询分页</p>
 * <p color=blue>pageSize 先不要设置成静态成员，当前还不能解决jackson反序列化时不填充其所创建对象的静态成员属性！</p>
 *
 * @author <a href="mail to: laoshi1998@outlook.com" rel="nofollow">xgon</a>
 * @version 1.0.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
public class Page implements Serializable {
    private static final long serialVersionUID = 43L;

    /**
     * <p>Description:&ensp;存储查询返回的总记录集合</p>
     */
    private List<Serializable> records;
    /**
     * <p>Description:&ensp;当前页面页码</p>
     */
    @JsonProperty(value = "current")
    private Integer currentPageNum;
    /**
     * <p>Description:&ensp;上一页</p>
     */
    private Integer prePageNum;
    /**
     * <p>Description:&ensp;下一页</p>
     */
    private Integer nextPageNum;
    /**
     * <p>Description:&ensp;开始页码</p>
     */
    private Integer startPageNum;
    /**
     * <p>Description:&ensp;结束页码</p>
     */
    private Integer endPageNum;
    /**
     * <p>Description:&ensp;前端显示的可点击的页码的个数</p>
     * <p>totalPages > showPageCount 时，需要隐藏一些页码</p>
     */
    private Integer showPageCount = 5;
    /**
     * <p>Description:&ensp;总页数</p>
     */
    private Integer totalPages;
    /**
     * <p>Description:&ensp;每页记录的条数</p>
     */
    @JsonProperty(value = "size")
    private Integer pageSize = 10;
    /**
     * <p>Description:&ensp;总记录的条数</p>
     */
    private Integer totalRecords;
    /**
     * <p>Description:&ensp;开始分页索引/下标位置</p>
     */
    private Integer startIndex;
    /**
     * <p>Description:&ensp;设置跳转页的 uri</p>
     */
    private String uri;

    public Page(Integer currentPageNum, Integer totalRecords) {
        this.currentPageNum = currentPageNum;
        this.totalRecords = totalRecords;
        build();
    }

    public void build() {
        if (null == currentPageNum || null == totalRecords) {
            return;
        }

        totalPages = totalRecords % pageSize == 0
                ? totalRecords / pageSize : totalRecords / pageSize + 1;

        buildStartIndex();

        if (totalPages > showPageCount) {
            startPageNum = currentPageNum - 2;
            endPageNum = currentPageNum + 2;

            if (startPageNum < 1) {
                startPageNum = 1;
                endPageNum = showPageCount;
            }

            if (endPageNum > totalPages) {
                endPageNum = totalPages;
                startPageNum = totalPages - 4;
            }
        } else {
            startPageNum = 1;
            endPageNum = totalPages;
        }

    }

    public void buildStartIndex() {
        startIndex = (currentPageNum - 1) * pageSize;
    }
}
