package com.example.domain.Page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

    private int pageNum;
    private int amount;
    private int skip;  // 페이지 skip

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.skip = (pageNum - 1) * amount;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
        this.skip = (this.pageNum - 1) * amount;
    }

}
