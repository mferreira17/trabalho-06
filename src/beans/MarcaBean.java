package beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import entidades.Marca;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class MarcaBean extends EntidadeBean<Marca> implements Serializable{

}
