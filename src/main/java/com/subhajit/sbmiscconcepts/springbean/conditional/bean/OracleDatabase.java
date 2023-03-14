package com.subhajit.sbmiscconcepts.springbean.conditional.bean;

import com.subhajit.sbmiscconcepts.springbean.config.ConditionalPropertyBeanInterface;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix="database.conditional", name = "flag", havingValue = "oracle-db")
public class OracleDatabase implements ConditionalPropertyBeanInterface {
    @Override
    public String connectDatabase() {
        return "Connectiong to Oracle....................";
    }
}
