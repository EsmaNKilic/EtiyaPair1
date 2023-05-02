package com.etiya.ecommercedemopair1.core.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;
@Configuration
public class MessageSourceConfiguration {
    // Boilerplate => Basmakalıp
    @Bean
    public ResourceBundleMessageSource bundleMessageSource(){
        // Veritabanı
        // Dosya
        // API
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver(){
        // Clientden seçili dili hangi yöntemle almalıyız?
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();

        // Dil gönderilmemişse hangi dili baz alayım?
        acceptHeaderLocaleResolver.setDefaultLocale(Locale.US); // (new Locale("tr")) şeklinde de kullanabilirsin.

        return acceptHeaderLocaleResolver;
    }
}
