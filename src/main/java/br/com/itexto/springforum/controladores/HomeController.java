package br.com.itexto.springforum.controladores;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.itexto.springforum.dao.DAOAssunto;
import br.com.itexto.springforum.dao.DAOUsuario;
import br.com.itexto.springforum.entidades.Usuario;


@Controller
public class HomeController {

	@Autowired
	private DAOUsuario daoUsuario;
	
	@Autowired
	private DAOAssunto daoAssunto;
	
	@RequestMapping("/")
	public String index(Map<String, Object> model){

		//model.put("assuntos",getDaoAssunto().list());
		//model.put("usuarios", getDaoUsuario().list());
		
		return "index";
	}
	
	@RequestMapping("/registro")
	public String registro(Map<String, Object> model){
		if(model.get("usuario")==null){
			model.put("usuario", new Usuario());
		}
		return "registro";
	}
	
	@RequestMapping(value="/executarRegistro", method=RequestMethod.POST)
	public String executarRegistro(@Valid Usuario usuario,BindingResult bindigResult, HttpSession sessao, 
								   @RequestParam(value="avatar",required=false) MultipartFile avatar){
	
		if(bindigResult.hasErrors()){
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("usuario", usuario);
			return registro(model);			
		}
		//getDaoUsuario().persistir(usuario);
		
		if(!avatar.isEmpty()){
			//processarAvatar(usuario,avatar);
		}
		sessao.setAttribute("usuario", usuario);
		
		return "redirect/";
	}
	
	private void processarAvatar(Usuario usuario, MultipartFile avatar) throws IOException {
		byte[] conteudo = avatar.getBytes();
		//persistirConteudo(usuario,conteudo);
		
	}

	public DAOUsuario getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}

	public DAOAssunto getDaoAssunto() {
		return daoAssunto;
	}

	public void setDaoAssunto(DAOAssunto daoAssunto) {
		this.daoAssunto = daoAssunto;
	}
	
	
}
