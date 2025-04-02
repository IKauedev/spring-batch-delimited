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
	public ItemWriter<Customer> readDelimitedFileWriter() {
		return items -> {
			List<Customer> filteredItems = new ArrayList<>();

			for (int i = 0; i < items.size() - 1; i++) {
				Customer current = items.get(i);
				Customer next = items.get(i + 1);

				if (!current.getName().equals(next.getName() + "1")) {
					filteredItems.add(current);
				} else {
					System.out.println("Nome do cliente '" + current.getName() + "' corresponde ao próximo acrescido de '1', e foi desconsiderado!");
				}
			}

			if (!items.isEmpty()) {
				filteredItems.add(items.get(items.size() - 1));
			}

			filteredItems.forEach(System.out::println);
		};
	}
}
