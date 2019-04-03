package beans;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.New;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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
	
	@Getter @Setter
	private StreamedContent foto;
	
	@PostConstruct
	public void carregarEntidades() {
		automoveis = autoBean.listar();
	}
	
	public void downloadFoto(Automovel automovel) {
		Optional<byte[]> fotos = Optional.ofNullable(automovel.getFoto());
		foto = new DefaultStreamedContent(new ByteArrayInputStream(fotos.get()),"image/png","imagem_carro.png");
	}
	


}
