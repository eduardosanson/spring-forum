package br.com.itexto.springforum.controladores;

import java.awt.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import br.com.itexto.springforum.entidades.Usuario;

@Controller("usuario")
@SessionAttributes("usuario")
public class UsuarioController {
	
	@RequestMapping("/usuario/autenticado")
	public ModelAndView infoAutenticado(
			@ModelAttribute("usuario") Usuario usuario){
		
		ModelAndView mav = new ModelAndView();
		mav.getModel().put("usuario", usuario);
		return mav;
	}
	
	@RequestMapping("/usuario/avatar/${usuario.login}")
	@ResponseBody
	public byte[] avatar(@PathVariable("login") String login){
		
		return obterConteudo(login);
		
	}

	private byte[] obterConteudo(String login) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/usuario/post/{login}")
	public String topicosUsuarios(@PathVariable("login") String login,
	                               Map<String, 	Object> model){
		
		model.put("topicos", 
				getDaoTopicos.
				getTopicosPorAutor(getDaoUsuario().getUsuario(login)));
		
		return "usuario/posts";
		
	}
	
	public List<Topico> topicoUsuarioJson(String login){
		
		Usuario usuario = getDaoUsuario().getUsuario(login);
		
		return getDaoTopico().getTopicoPorAutor(usuario);
		
	}
	
	
	

}
