package com.finmason;

import com.finmason.service.AutoDataFixingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AutoDataFixingService autoDataFixingService = context.getBean(AutoDataFixingService.class);

        // create test for this, this is just for testing
        List<BigDecimal> fmReturns = new ArrayList<>();
        List<BigDecimal> vendorReturns = new ArrayList<>();
        fmReturns.add(new BigDecimal(1.0));
        vendorReturns.add((new BigDecimal("5.0")));

        // this will run in loop for all data from input arguments
        autoDataFixingService.validateAndFixData(fmReturns.get(0), vendorReturns.get(0));

    }

}
