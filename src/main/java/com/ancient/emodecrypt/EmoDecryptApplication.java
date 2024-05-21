package com.ancient.emodecrypt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(
		info = @Info(
				title = "Emotion Decoder",
				summary = "API de Natural process language",
				description = "Uma Api voltada a saber como esta a reputação de marcas, produtos ou empresas com base em comentarios trazidos das redes.",
				version = "1.0.0",
				contact = @Contact(name = "Julia Nery", email = "sac@emotiondecoder.com")
		)
)
public class EmoDecryptApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmoDecryptApplication.class, args);
	}

}
