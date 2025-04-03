package com.springbatch.filedelimited.step;

import com.springbatch.filedelimited.domain.model.Customer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReadDelimitedFileStepConfig {

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step readDelimitedFileStep(
			@Qualifier("readingDelimitedMultipleFilePointReader") ItemReader<Customer> reader,
			ItemWriter<Customer> writer) {
		return stepBuilderFactory
				.get("readDelimitedFileStep")
				.<Customer, Customer>chunk(1)
				.reader(reader)
				.writer(writer)
				.build();
	}
}
