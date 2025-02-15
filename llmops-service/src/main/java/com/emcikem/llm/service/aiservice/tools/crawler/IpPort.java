package com.emcikem.llm.service.aiservice.tools.crawler;

import lombok.Data;

import java.net.InetSocketAddress;
import java.net.Proxy;

/**
 * Create with Emcikem on {DATE}
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class IpPort {

    private String ip;

    private Integer port;

    public Proxy toProxy() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.ip, this.port));
    }
}
