package com.finmason.strategy;

import org.springframework.stereotype.Component;

@Component("splitCorrectionStrategy")
public class SplitCorrectionStrategy implements DataFixingStrategy {

    @Override
    public void validateAndFlagAssets() {
        System.out.println("Applying SPLIT correction strategy");
    }
}
