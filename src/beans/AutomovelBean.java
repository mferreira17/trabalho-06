package beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import entidades.Automovel;
import entidades.Marca;
import entidades.Modelo;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class AutomovelBean extends EntidadeBean<Automovel> implements Serializable {

	@Getter
	@Setter
	private Marca marca;

	@Getter
	@Setter
	private List<Modelo> modelos;

	@PostConstruct
	public void carregarEntidade() {

		String autoId = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("autoId");
		if (autoId != null) {
			recuperaEntidadePorId(autoId);
		}
	}

	public void remove(Automovel auto) {
		remover(auto.getId());
	}

	@SuppressWarnings("unchecked")
	public void updateComboModelo() {
		HashMap<String, Object> params = new HashMap<>();
		params.put("marca", marca);
		modelos = obterPorConsulta("Modelo.obterPorMarca", params);
	}

}
