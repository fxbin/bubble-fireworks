package cn.fxbin.bubble.fireworks.autoconfigure.cloud.openfeign;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import java.util.ArrayList;
import java.util.List;

import static cn.fxbin.bubble.fireworks.autoconfigure.cloud.openfeign.FeignGlobalProperties.BUBBLE_FIREWORKS_FEIGN_PREFIX;

/**
 * FeignGlobalProperties
 *
 * @author fxbin
 * @version v1.0
 * @since 2020/4/22 18:19
 */
@Data
@RefreshScope
@ConfigurationProperties(prefix = BUBBLE_FIREWORKS_FEIGN_PREFIX)
public class FeignGlobalProperties {

    /**
     * swagger prefix
     */
    public static final String BUBBLE_FIREWORKS_FEIGN_PREFIX = "bubble.fireworks.feign";

    /**
     * 默认的全局透传header 全局透传请求头：X-Real-IP x-forwarded-for 请求和转发的ip
     */
    public static final String[] ALLOW_HEADERS = new String[]{
            "X-Real-IP", "x-forwarded-for"
    };

    /**
     * 允许透传的header
     */
    private List<String> allowHeaders = new ArrayList<>();



}
