package com.meucadastroweb;

import com.meucadastroweb.entity.Usuario;
import com.meucadastroweb.repository.UsuarioRepository;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeucadastrowebApplicationTests {

        @Autowired
        UsuarioRepository repository;
    
	@Test
	public void contextLoads() {
            final Usuario admin = repository.findByLoginAndSenha("admin", "admin");
            if(admin == null)
                repository.save(new Usuario("admin","-", "admin@gmail.com", "admin", "admin"));
            
            List<Usuario> usuarios = repository.findUsuarioByEmail("admin@gmai");
            
            for(Usuario us: usuarios)
                System.out.println(us.getNome());

	}

}
