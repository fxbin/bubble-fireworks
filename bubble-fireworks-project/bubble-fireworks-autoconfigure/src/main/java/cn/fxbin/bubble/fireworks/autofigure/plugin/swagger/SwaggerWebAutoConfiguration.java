package cn.fxbin.bubble.fireworks.autofigure.plugin.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger.configuration.SwaggerCommonConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;
import springfox.documentation.swagger2.web.Swagger2Controller;

import static cn.fxbin.bubble.fireworks.autofigure.plugin.swagger.SwaggerProperties.BUBBLE_FIREWORKS_SWAGGER_PREFIX;

/**
 * SwaggerWebAutoConfiguration
 *
 * @author fxbin
 * @version v1.0
 * @since 2020/3/31 18:54
 */
@EnableSwagger2
@Configuration(
        proxyBeanMethods = false
)
@EnableConfigurationProperties(SwaggerProperties.class)
@ConditionalOnWebApplication(type = Type.SERVLET)
@ConditionalOnClass({SwaggerCommonConfiguration.class, Swagger2DocumentationConfiguration.class, Swagger2Controller.class})
@ConditionalOnProperty(prefix = BUBBLE_FIREWORKS_SWAGGER_PREFIX, name = "enable", havingValue = "true", matchIfMissing = true)
public class SwaggerWebAutoConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
