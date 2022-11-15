package com.socks.api.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:user/user.properties", "classpath:config.properties"})
public interface ProjectConfig extends Config {


    String env();

    @Key("base.url")
    String baseUrl();

    String locale();

    Boolean logging();

}
