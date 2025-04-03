package com.springbatch.filedelimited.reader;

import com.springbatch.filedelimited.domain.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.beans.factory.annotation.Qualifier;

@Configuration
public class ReadDelimitedFileReaderConfig {
	private static final Logger logger = LoggerFactory.getLogger(ReadDelimitedFileReaderConfig.class);

	@Bean
	@StepScope
	@Qualifier("readingDelimitedFileReader")
	public FlatFileItemReader<Customer> readingDelimitedFileReader() {
		return new FlatFileItemReaderBuilder<Customer>()
				.name("readingDelimitedFileReader")
				.resource(new FileSystemResource("files/clientes.txt"))
				.fixedLength()
				.columns(new Range[]{new Range(1, 10), new Range(11, 20), new Range(21, 23), new Range(24, 43)})
				.strict(false)
				.names("name", "lastname", "age", "email")
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Customer>() {{
					setTargetType(Customer.class);
				}})
				.build();
	}

	@Bean
	@StepScope
	@Qualifier("readingDelimitedFilePointReader")
	public FlatFileItemReader<Customer> readingDelimitedFilePointReader() {
		return new FlatFileItemReaderBuilder<Customer>()
				.name("readingDelimitedFilePointReader")
				.resource(new FileSystemResource("files/clientes-point.txt"))
				.delimited()
				.names("name", "lastname", "age", "email")
				.targetType(Customer.class)
				.build();
	}

	@Bean
	@StepScope
	@Qualifier("readingDelimitedMultipleFilePointReader")
	@SuppressWarnings({"rawtypes", "unchecked"})
	public FlatFileItemReader readingDelimitedMultipleFilePointReader(LineMapper lineMapper) {
		return new FlatFileItemReaderBuilder<>()
				.name("readingDelimitedMultipleFilePointReader")
				.resource(new FileSystemResource("files/clientes-multiple.txt"))
				.lineMapper(lineMapper)
				.build();
	}
}
