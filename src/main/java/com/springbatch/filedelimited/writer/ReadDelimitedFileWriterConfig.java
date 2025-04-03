package com.springbatch.filedelimited.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.filedelimited.domain.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ReadDelimitedFileWriterConfig {
	@Bean
	public ItemWriter<?> readDelimitedFileWriter() {
		return items -> items.forEach(System.out::println);
	}
}
