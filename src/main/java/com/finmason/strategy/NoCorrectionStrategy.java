package com.finmason.strategy;

import org.springframework.stereotype.Component;

@Component("noCorrectionStrategy")
public class NoCorrectionStrategy implements DataFixingStrategy {

    @Override
    public void validateAndFlagAssets() {
        System.out.println("Applying no correction strategy, only flagging assets");
    }
}
