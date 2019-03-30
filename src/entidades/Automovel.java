package entidades;

import javax.enterprise.inject.Produces;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="automovel")
@NoArgsConstructor
@RequiredArgsConstructor
public class Automovel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NonNull
	@Column(name = "ano_fabricacao")
	private Integer anoFabricacao;

	@NonNull
	@Column(name = "ano_modelo")
	private Integer anoModelo;

	@NonNull
	@Column(name = "observacoes")
	private String observacao;

	@NonNull
	@Column(name = "preco")
	private Float preco;

	@NonNull
	@Column(name = "kilometragem")
	private Integer kilometragem;

	@NonNull
	@ManyToOne
	@JoinColumn(name = "id_modelo", referencedColumnName = "id")
	private Modelo modelo;

}
