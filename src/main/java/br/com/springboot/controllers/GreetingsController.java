package br.com.springboot.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.model.Usuario;
import br.com.springboot.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController{
	
	/* IC/CD ou Injeção de dependencia */
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
	 
	/* Método */ 
    @RequestMapping(value = "/mostrarNome/{name}", method = RequestMethod.GET) 
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "SpringBoot " + name + "!";
    }
    
    //--------------------------------------------------------
    
    @RequestMapping(value ="/olamundo/{nome}", method = RequestMethod.GET) /* Mapeamento de requisição */
    @ResponseStatus(HttpStatus.OK)
    public String getText(@PathVariable String nome) {
    	
    	Usuario usuario = new Usuario();
    	usuario.setNome(nome);
    	
    	/* Comando para gravar no banco de dados - usuario apenas com o nome */
    	usuarioRepository.save(usuario);
    	
    	System.out.println(usuario.getNome());
    	return "Olá Mundo! " + nome; 
    }
    
    //--------------------------------------------------------
    
    /* Primeiro método de API - Método de listar Usuario */
    @GetMapping(value = "listausuarios") /* Mesa função do RequestMapping - Mas não precisa retornar o método GET */
    @ResponseBody /* Retorna os dados para o corpo da resposta - Retorna um JSON*/
    public ResponseEntity<List<Usuario>> listarUsuarios() {
    	List<Usuario> usuarios = usuarioRepository.findAll(); /* Executa a consulta no banco de dados */
    	return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
   }
    
    //--------------------------------------------------------

    @PostMapping(value = "adicionar") /* Mapeia a URL */
    @ResponseBody
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario usuario){ /* @RequestBody - Recebe os dados para salvar */
    	
    	Usuario user = usuarioRepository.save(usuario);
    	
    	return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
    }
    
    //--------------------------------------------------------
    
    @PutMapping(value = "atualizar")
    @ResponseBody
    public ResponseEntity<?>atualizar(@RequestBody Usuario usuario){
    	
    	if(usuario.getId() == null) {
    		return new ResponseEntity<String>("ID não foi informado para atualização", HttpStatus.OK);
    	}
    	
    	Usuario user = usuarioRepository.saveAndFlush(usuario);
    	return new ResponseEntity<Usuario>(user, HttpStatus.OK);
    }
    
//    @PutMapping("atualizar")
//    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
//        return new ResponseEntity<>(usuarioRepository.saveAndFlush(usuario), HttpStatus.OK);    	
//    }
    
    //--------------------------------------------------------
    
    @DeleteMapping(value = "deletar") /* Mapeia a URL */
    @ResponseBody
    public ResponseEntity<String>delete(@RequestParam Long iduser){ /* RequestParam - Receber um parametro */
    	
    	usuarioRepository.deleteById(iduser);
    	
    	return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);
    }
    
    //--------------------------------------------------------
    
    @GetMapping(value = "buscaruserid")
    @ResponseBody
    public ResponseEntity<Usuario>buscarUserId(@RequestParam(name="iduser") Long iduser){
    	Usuario usuario = usuarioRepository.findById(iduser).get();
    	return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
}


