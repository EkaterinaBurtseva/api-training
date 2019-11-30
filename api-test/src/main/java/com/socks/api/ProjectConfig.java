package com.socks.api;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

   // String env();

    //@Key("{env}.baseUrl")
    String baseUrl();

    @DefaultValue("es")
    String locale();

    boolean logging();
}
