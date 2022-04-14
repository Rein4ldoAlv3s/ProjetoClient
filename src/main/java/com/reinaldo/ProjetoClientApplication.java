package com.reinaldo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reinaldo.domain.Cidade;
import com.reinaldo.domain.Cliente;
import com.reinaldo.domain.Endereco;
import com.reinaldo.domain.Estado;
import com.reinaldo.domain.enums.TipoCliente;

@SpringBootApplication
public class ProjetoClientApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProjetoClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estado e1 = new Estado(null, "Goiás");
		Cidade cid1 = new Cidade(null, "Goiânia", e1);
		e1.getCidades().add(cid1);
		
		Endereco end1 = new Endereco(null, "Av Laranjeiras", "933", "Rua Gramados", 
				"Bairro dos Carvalhos", "7400000", cid1);
		
		Cliente cli1 = new Cliente(null, "Diana", "diana11@gmail.com", 
				"04944428523", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().add("62995019488");
		
		end1.setCliente(cli1);
		
		cli1.getEnderecos().add(end1);
		
	}

}
