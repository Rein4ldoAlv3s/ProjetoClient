package com.reinaldo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.reinaldo.domain.Cidade;
import com.reinaldo.domain.Cliente;
import com.reinaldo.domain.Endereco;
import com.reinaldo.domain.Estado;
import com.reinaldo.domain.enums.TipoCliente;
import com.reinaldo.repo.CidadeRepo;
import com.reinaldo.repo.ClienteRepo;
import com.reinaldo.repo.EnderecoRepo;
import com.reinaldo.repo.EstadoRepo;

@SpringBootApplication()
public class ProjetoClientApplication implements CommandLineRunner{

	@Autowired
	private CidadeRepo cidadeRepo;
	@Autowired
	private EstadoRepo estadoRepo;
	@Autowired
	private EnderecoRepo enderecoRepo;
	@Autowired
	private ClienteRepo clienteRepo;
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(ProjetoClientApplication.class, args);
	}

	

	@Override
	public void run(String... args) throws Exception {
		Estado e1 = new Estado(null, "Goiás");
		Cidade cid1 = new Cidade(null, "Goiânia", e1);
		e1.getCidades().add(cid1);

		Endereco end1 = new Endereco(null, "Av Laranjeiras", "933", "Rua Gramados", "Bairro dos Carvalhos", "7400000",
				cid1);

		Cliente cli1 = new Cliente(null, "Diana", "diana11@gmail.com", "04944428523", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().add("62995019488");

		end1.setCliente(cli1);

		cli1.getEnderecos().add(end1);

		estadoRepo.save(e1);
		cidadeRepo.save(cid1);
		clienteRepo.save(cli1);
		enderecoRepo.save(end1);

	}

}
