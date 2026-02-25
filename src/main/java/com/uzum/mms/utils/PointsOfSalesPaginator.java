package com.uzum.mms.utils;

import com.uzum.mms.constant.Constants;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;

@UtilityClass
public class PointsOfSalesPaginator {
    public PageRequest validate(int page, int size) {
        return PageRequest.of(page, Math.min(size, Constants.MAX_PAGE_SIZE));
    }

}
