
package com.example.demo.aspect;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(customerInterceptor()).addPathPatterns("/**");
    }

    @Bean
    CustomerInterceptor customerInterceptor() {
        return new CustomerInterceptor();
    }*/

   /* @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fjc = new FastJsonHttpMessageConverter();
        FastJsonConfig fj = new FastJsonConfig();
        fj.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect);
        fjc.setFastJsonConfig(fj);
        converters.add(fjc);
        converters.add(converter());
    }

    @Bean
    public StringMessageConverter converter() {
        return new StringMessageConverter();
    }*/

}

