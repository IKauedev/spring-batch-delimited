package com.springbatch.filedelimited.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.filedelimited.domain.model.Customer;

@Configuration
public class ReadDelimitedFileStepConfig {
	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step readDelimitedFileStep(ItemReader<Customer> leituraArquivoDelimitadoReader,
			ItemWriter<Customer> leituraArquivoDelimitadoWriter) {
		return stepBuilderFactory
				.get("readDelimitedFileStep")
				.<Customer, Customer>chunk(1)
				.reader(leituraArquivoDelimitadoReader)
				.writer(leituraArquivoDelimitadoWriter)
				.build();
	}
}
