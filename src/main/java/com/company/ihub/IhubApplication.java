package com.company.ihub;

import com.company.ihub.ibruma.entity.IbrumaEntity;
import com.company.ihub.ibruma.entity.property.LegalEntity;
import com.company.ihub.ibruma.repository.IbrumaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.List;

@EnableJpaAuditing
@ComponentScan({"com"})
@SpringBootApplication
@RequiredArgsConstructor
@EntityScan(basePackages = {("com.company.ihub")})
@EnableJpaRepositories(basePackages = {("com.company.ihub")})
public class IhubApplication implements CommandLineRunner {

	private final IbrumaRepository ibrumaRepository;

	public static void main(String[] args) {
		SpringApplication.run(IhubApplication.class, args);
	}

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) {

		List<IbrumaEntity> ibrumaEntities = new ArrayList<>();
		LegalEntity legalEntity = new LegalEntity("uk", "opo", "test",
				List.of("a", "b", "c"), List.of("t", "w", "v"), List.of("u", "i", "l"));

		ibrumaEntities.add(new IbrumaEntity(legalEntity, "testing"));

		if (ibrumaRepository.count() == 0)
			ibrumaRepository.saveAll(ibrumaEntities);
	}
}
