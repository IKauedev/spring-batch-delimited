package com.springbatch.filedelimited.reader;

import com.springbatch.filedelimited.domain.model.Customer;
import com.springbatch.filedelimited.domain.model.Transaction;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CustomerTransactionMapperLineConfig {

    @Bean
    public PatternMatchingCompositeLineMapper lineMapper() {
        PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper<>();
        lineMapper.setTokenizers(tokenizers());
        lineMapper.setFieldSetMappers(fieldSetMappers());

        return lineMapper;
    }
    private Map<String, LineTokenizer> tokenizers() {
        Map<String, LineTokenizer> tokenizer = new HashMap<>();
        tokenizer.put("0*", customerTokenizer());
        tokenizer.put("1*", transactionTokenizer());
        return tokenizer;

    }

    private LineTokenizer customerTokenizer() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("name", "lastname", "email", "age");
        lineTokenizer.setIncludedFields(1, 2, 3, 4);
        return lineTokenizer;
    }

    private LineTokenizer transactionTokenizer() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setNames("id", "description", "value");
        lineTokenizer.setIncludedFields(1, 2, 3);
        return lineTokenizer;
    }

    private Map<String, FieldSetMapper> fieldSetMappers() {
        Map<String, FieldSetMapper> fieldSetMapperMap = new HashMap<>();
        fieldSetMapperMap.put("0*", fieldSet -> {
            BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();
            fieldSetMapper.setTargetType(Customer.class);
            return fieldSetMapper;
        });

        fieldSetMapperMap.put("1*", fieldSet -> {
            BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper<>();
            fieldSetMapper.setTargetType(Transaction.class);
            return fieldSetMapper;
        });

        return fieldSetMapperMap;
    }
}
