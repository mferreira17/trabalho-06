package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import entidades.Automovel;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class AutomovelBean extends EntidadeBean<Automovel> implements Serializable{
	
	@PostConstruct
	public void carregarEntidade() {

		String autoId = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("autoId");
		if(autoId != null) {
			recuperaEntidadePorId(autoId);
		}
	}
	
	public void remove(Automovel auto) {
		remover(auto.getId());
	}
	

}
