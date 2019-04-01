package beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.New;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entidades.Marca;
import entidades.Modelo;

@Named
@ViewScoped
@SuppressWarnings("serial")
public class ModeloBean extends EntidadeBean<Modelo> implements Serializable{

}
