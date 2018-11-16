package com.finmason.service;

import com.finmason.strategy.DataFixingStrategy;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AutoDataFixingService {

    private BeanFactory bf;

    public AutoDataFixingService(BeanFactory bf) {
        this.bf = bf;
    }

    public void validateAndFixData(BigDecimal fmReturn, BigDecimal vendorReturn) {
        BigDecimal diff = fmReturn.subtract(vendorReturn);
        DataFixingStrategy  strategy = null;
        if (diff.compareTo(new BigDecimal("0.0001")) <= 0) {
            strategy = bf.getBean("noCorrectionStrategy", DataFixingStrategy.class);
        }
        if (diff.compareTo(new BigDecimal("0.1")) > 0) {
            strategy = bf.getBean("splitCorrectionStrategy", DataFixingStrategy.class);
        }
        if (diff.compareTo(new BigDecimal("0.1")) <= 0) {
            strategy = bf.getBean("dividendCorrectionStrategy", DataFixingStrategy.class);
        }

        if (strategy != null) {
            strategy.validateAndFlagAssets();
        }
        else {
            throw new IllegalArgumentException("Can not find strategy for difference " + diff);
        }
    }
}
