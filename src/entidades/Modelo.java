package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "modelo")
@NoArgsConstructor
@NamedQuery(name="Modelo.obterPorMarca", query="select m from Modelo m where m.marca = :marca")
public class Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name="descricao")
	private String descricao;

	@Column(name="potencia")
	private Integer potencia;

	@ManyToOne
	@JoinColumn(name = "id_marca", referencedColumnName = "id")
	private Marca marca;

}
