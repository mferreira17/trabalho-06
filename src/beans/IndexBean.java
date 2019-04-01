package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.New;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entidades.Automovel;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class IndexBean implements Serializable{
	
	@New
	@Inject
	private AutomovelBean autoBean;
	
	@Getter @Setter
	private List<Automovel> automoveis;
	
	@PostConstruct
	public void carregarEntidades() {
		automoveis = autoBean.listar();
	}

}
