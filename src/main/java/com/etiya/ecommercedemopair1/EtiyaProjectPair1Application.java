package com.etiya.ecommercedemopair1;

import com.etiya.ecommercedemopair1.core.exceptions.BusinessException;
import com.etiya.ecommercedemopair1.core.results.ErrorDataResult;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@RestControllerAdvice
public class EtiyaProjectPair1Application {

    public static void main(String[] args) {
        SpringApplication.run(EtiyaProjectPair1Application.class, args);

        //Locale.setDefault(new Locale("en","tr"));
    }

    @Bean
    public ModelMapper GetModelMapper(){
        return new ModelMapper();
    }


    @ExceptionHandler
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException){
        // gelen exceptiondaki validasyon hatalarını oku liste olarak kullanıcıya göster
        Map<String, String> validationErrors = new HashMap<>();
        for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErrors,"VALIDATION.EXCEPTION");
        return errorDataResult;
    }


    @ExceptionHandler
    @ResponseStatus(code=HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleBusinessExceptions(BusinessException businessException){
        ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(businessException.getMessage(),"BUSINESS.EXCEPTION");
        return errorDataResult;
    }
}
