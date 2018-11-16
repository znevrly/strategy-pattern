package com.finmason.strategy;

import org.springframework.stereotype.Component;

@Component("dividendCorrectionStrategy")
public class DividendCorrectionStrategy implements DataFixingStrategy {

    @Override
    public void validateAndFlagAssets() {
        System.out.println("Applying DIVIDEND correction strategy");
    }
}
